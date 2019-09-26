import {Component, AfterViewInit, Renderer, ElementRef, OnInit} from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { JhiEventManager } from 'ng-jhipster';

import { LoginService } from './login.service';
import { StateStorageService } from '../auth/state-storage.service';
import {Http} from "@angular/http";
import {Polisa} from "../../home/polisa.service";
import {Klient} from "../../Klient";
import {PolisaMieszkaniowa} from "../../PolisaMieszkaniowa";
import {FakturaMieszkaniowa} from "../../FakturaMieszkaniowa";
import {UbezpieczenieRuchomosciDomowych} from "../../UbezpieczenieRuchomosciDomowych";
import {ZabezpieczeniePrzeciwkradziezowe} from "../../ZabezpieczeniePrzeciwkradziezowe";

@Component({
    selector: 'jhi-login-modal',
    templateUrl: './login.component.html'
})
export class JhiLoginModalComponent implements  AfterViewInit {
    authenticationError: boolean;
    password: string;
    rememberMe: boolean;
    username: string;
    credentials: any;

    private _webApiUrl = 'http://localhost:8080/api/';
    public polisa: PolisaMieszkaniowa;
    public polisaId: number;
    public id: number;
    public klientDTO: Klient;
    public miasto: string = '';
    public kodPocztowy: number;
    public ulica: string = '';
    public numerBudynku: number;
    public numerMieszkania: number;
    public polisy: PolisaMieszkaniowa[];
    public fakturaMieszkaniowa: FakturaMieszkaniowa;
    public ubezpieczenieRuchomosciDomowych: UbezpieczenieRuchomosciDomowych;
    public koszt: number;
    public zabezpieczeniePrzeciwkradziezowe: ZabezpieczeniePrzeciwkradziezowe;

    constructor(
        private eventManager: JhiEventManager,
        private loginService: LoginService,
        private stateStorageService: StateStorageService,
        private elementRef: ElementRef,
        private renderer: Renderer,
        private router: Router,
        public activeModal: NgbActiveModal,
        private http: Http,
        private polisaService: Polisa
    ) {
        this.credentials = {};
    }

    ngAfterViewInit() {
        this.renderer.invokeElementMethod(this.elementRef.nativeElement.querySelector('#username'), 'focus', []);
    }

    cancel() {
        this.credentials = {
            username: null,
            password: null,
            rememberMe: true
        };
        this.authenticationError = false;
        this.activeModal.dismiss('cancel');
    }

    login() {
        this.loginService.login({
            username: this.username,
            password: this.password,
            rememberMe: this.rememberMe
        }).then(() => {
            this.authenticationError = false;
            this.activeModal.dismiss('login success');
            if (this.router.url === '/register' || (/^\/activate\//.test(this.router.url)) ||
                (/^\/reset\//.test(this.router.url))) {
                this.router.navigate(['']);
            }

            this.eventManager.broadcast({
                name: 'authenticationSuccess',
                content: 'Sending Authentication Success'
            });

            // // previousState was set in the authExpiredInterceptor before being redirected to login modal.
            // // since login is succesful, go to stored previousState and clear previousState
            const redirect = this.stateStorageService.getUrl();
            if (redirect) {
                this.stateStorageService.storeUrl(null);
                this.router.navigate([redirect]);
            }
        }).catch(() => {
            this.authenticationError = true;
        });
    }

    register() {
        this.activeModal.dismiss('to state register');
        this.router.navigate(['/register']);
    }

    requestResetPassword() {
        this.activeModal.dismiss('to state requestReset');
        this.router.navigate(['/reset', 'request']);
    }

    public pobierzPolise = () => {
        this.polisaId = this.polisaService.getPolisaId();
        // this.http.get(this._webApiUrl + 'polisa_mieszkaniowa/' + this.polisaService.getPolisaId())
        //     .subscribe(result => this.polisa = result.json());
    };

    public pobierzPoliseById = (polisaId) => {
        this.http.get(this._webApiUrl + 'polisa_mieszkaniowa/' + polisaId)
            .subscribe(result => {
                this.polisa = result.json();
                console.log(this.polisa);
            }, error => {
                console.log(error.json());
            });
            // .subscribe(result => this.polisa = result.json());
    };


    public pobierzPolisy = () => {
        this.http.get(this._webApiUrl + 'polisa_mieszkaniowa')
            .subscribe(result => this.polisy = result.json());
    };

    public pobierzUbezpieczeniaRuchomosciDomowychByIdPolisaMieszkaniowa = (polisaId) => {
        this.http.get(this._webApiUrl + 'ubezpieczenie_ruchomosci_domowych/' + polisaId)
            .subscribe(result => {
                this.ubezpieczenieRuchomosciDomowych = result.json();
                console.log(this.ubezpieczenieRuchomosciDomowych);
            },  error => {
                console.log(error.json());
            });
        // .subscribe(result => this.polisa = result.json());
    };

    public pobierzZabezpieczeniePrzeciwkradziezoweByIdPolisaMieszkaniowa = (polisaId) => {
        this.http.get(this._webApiUrl + 'zabezpieczenie_przeciwkradziezowe/' + polisaId)
            .subscribe(result => {
                this.zabezpieczeniePrzeciwkradziezowe = result.json();
                console.log(this.zabezpieczeniePrzeciwkradziezowe);
            },  error => {
                console.log(error.json());
            });
        // .subscribe(result => this.polisa = result.json());
    };

    public modyfikujZabezpieczeniePrzeciwkradziezowe(nowyKoszt){
        this.zabezpieczeniePrzeciwkradziezowe.koszt = nowyKoszt;
        this.http.put(this._webApiUrl + 'zabezpieczenie_przeciwkradziezowe', this.zabezpieczeniePrzeciwkradziezowe)
            .subscribe(data => {
            }, error => {
                console.log(error.json());
            });
    };


    public modyfikujUbezpieczeniaRuchomosciDomowych(nowyKoszt){
        this.ubezpieczenieRuchomosciDomowych.koszt = nowyKoszt;
        this.http.put(this._webApiUrl + 'ubezpieczenie_ruchomosci_domowych', this.ubezpieczenieRuchomosciDomowych)
            .subscribe(data => {
            }, error => {
                console.log(error.json());
            });
    };

    public zrezygnujZUbezpieczeniaRuchomosciDomowych(polisaId){
        this.http.delete(this._webApiUrl + 'polisa_mieszkaniowa/ubezpieczenie-ruchomosci-domowych/'+ polisaId)
            .subscribe(data => {
            }, error => {
                console.log(error.json());
            });
    };

    public zrezygnujZZabezpieczeniaPrzeciwkradziezowego(polisaId){
        this.http.delete(this._webApiUrl + 'polisa_mieszkaniowa/zabezpieczenie-przeciwkradziezowe/'+ polisaId)
            .subscribe(data => {
            }, error => {
                console.log(error.json());
            });
    };



}
