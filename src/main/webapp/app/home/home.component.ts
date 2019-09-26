import {Component, OnInit} from "@angular/core";
import {NgbModalRef} from "@ng-bootstrap/ng-bootstrap";
import {JhiEventManager} from "ng-jhipster";
import {PolisaMieszkaniowa} from "../PolisaMieszkaniowa";
import {Account, LoginModalService, Principal} from "../shared";
import {Klient} from "../Klient";
import {Http} from "@angular/http";
import {Polisa} from './polisa.service';

@Component({
    selector: 'jhi-home',
    templateUrl: './home.component.html',
    styleUrls: [
        'home.scss'
    ]

})
export class HomeComponent implements OnInit {
    account: Account;
    modalRef: NgbModalRef;


    private _webApiUrl = 'http://localhost:8080/api/';
    public miasto = '';
    public kodPocztowy;
    public ulica = '';
    public numerBudynku;
    public numerMieszkania;
    public klientId;
    public idPolisaMieszkaniowa;
    public klienci: Klient[];
    public polisaMieszkaniowaId;


    constructor(private principal: Principal,
                private loginModalService: LoginModalService,
                private eventManager: JhiEventManager,
                private http: Http,
                private polisaService : Polisa) {
    }

    ngOnInit() {
        this.principal.identity().then((account) => {
            this.account = account;
        });
        this.registerAuthenticationSuccess();
    }

    registerAuthenticationSuccess() {
        this.eventManager.subscribe('authenticationSuccess', (message) => {
            this.principal.identity().then((account) => {
                this.account = account;
            });
        });
    }

    isAuthenticated() {
        return this.principal.isAuthenticated();
    }

    login() {
        this.modalRef = this.loginModalService.open();
    }


    dodajPoliseMieszkaniowa() {
        let polisaMieszkaniowa = new PolisaMieszkaniowa( new Klient(this.klientId), this.miasto, this.kodPocztowy, this.ulica, this.numerBudynku, this.numerMieszkania, this.polisaMieszkaniowaId); //
        this.http.post(this._webApiUrl + 'polisa_mieszkaniowa', polisaMieszkaniowa)
            .subscribe(data => {
                this.polisaService.setPolisaId(data.json().id);
            }, error => {
                console.log(error.json());
            });
    };



    public pobierzKlientow = () => {
        this.http.get(this._webApiUrl + 'klient')
            .subscribe(result => this.klienci = result.json());
    };









}
