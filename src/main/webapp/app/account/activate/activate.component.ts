import { Component, OnInit } from '@angular/core';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';

import { ActivateService } from './activate.service';
import { LoginModalService } from '../../shared';
import {Polisa} from "../../home/polisa.service";
import {Http} from "@angular/http";
import {PolisaMieszkaniowa} from "../../PolisaMieszkaniowa";
import {Klient} from "../../Klient";
import {FakturaMieszkaniowa} from "../../FakturaMieszkaniowa";
import {UbezpieczenieRuchomosciDomowych} from "../../UbezpieczenieRuchomosciDomowych";
import {ZabezpieczeniePrzeciwkradziezowe} from "../../ZabezpieczeniePrzeciwkradziezowe";

@Component({
    selector: 'jhi-activate',
    templateUrl: './activate.component.html'
})
export class ActivateComponent implements OnInit {
    error: string;
    success: string;
    modalRef: NgbModalRef;

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
    public koszt: number;
    public data: Date;
    public faktury: FakturaMieszkaniowa[];


    constructor(
        private activateService: ActivateService,
        private loginModalService: LoginModalService,
        private route: ActivatedRoute,
        private http: Http,
        private polisaService: Polisa
    ) {
    }

    ngOnInit() {
        this.route.queryParams.subscribe((params) => {
            this.activateService.get(params['key']).subscribe(() => {
                this.error = null;
                this.success = 'OK';
            }, () => {
                this.success = null;
                this.error = 'ERROR';
            });
        });
    }

    login() {
        this.modalRef = this.loginModalService.open();
    }

    public pobierzFakturyMieszkaniowe = () => {
        this.http.get(this._webApiUrl + 'faktura')
            .subscribe(result => this.faktury = result.json());
    };


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















}
