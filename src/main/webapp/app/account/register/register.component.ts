import {Component, OnInit, AfterViewInit, Renderer, ElementRef} from "@angular/core";
import {NgbModalRef} from "@ng-bootstrap/ng-bootstrap";
import {JhiLanguageService} from "ng-jhipster";
import {Register} from "./register.service";
import {LoginModalService, EMAIL_ALREADY_USED_TYPE, LOGIN_ALREADY_USED_TYPE} from "../../shared";
import {PolisaMieszkaniowa} from "../../PolisaMieszkaniowa";
import {Http} from "@angular/http";
import {Klient} from "../../Klient";
import {Polisa} from "../../home/polisa.service";
import {ZabezpieczeniePrzeciwkradziezowe} from "../../ZabezpieczeniePrzeciwkradziezowe";
import {UbezpieczenieRuchomosciDomowych} from "../../UbezpieczenieRuchomosciDomowych";
import {FakturaMieszkaniowa} from "../../FakturaMieszkaniowa";


@Component({
    selector: 'jhi-register',
    templateUrl: './register.component.html'
})
export class RegisterComponent implements OnInit, AfterViewInit {

    confirmPassword: string;
    doNotMatch: string;
    error: string;
    errorEmailExists: string;
    errorUserExists: string;
    registerAccount: any;
    success: boolean;
    modalRef: NgbModalRef;


    private _webApiUrl = 'http://localhost:8080/api/';
    public polisy: PolisaMieszkaniowa[];
    public klienci: Klient[];
    public polisa: PolisaMieszkaniowa;
    public polisaId: number;
    public zabezpieczeniaPrzeciwkradziezowe: ZabezpieczeniePrzeciwkradziezowe;
    public ubezpieczenieRuchomosciDomowych: UbezpieczenieRuchomosciDomowych;
    public fakturaMieszkaniowa: FakturaMieszkaniowa;
    public kwota: number;
    public kwota2: number;
    public klientDTO: Klient = null;
    public miasto: string = '';
    public kodPocztowy: number = null;
    public ulica: string = '';
    public numerBudynku: number = null;
    public numerMieszkania: number = null;
    public fakturaId: number;
    public opis: string = '';
    public kwotaF: number;
    public faktury: FakturaMieszkaniowa[];
    public data: Date;
//    public kwota: number;


    constructor(private languageService: JhiLanguageService,
                private loginModalService: LoginModalService,
                private registerService: Register,
                private elementRef: ElementRef,
                private renderer: Renderer,
                private http: Http,
                private polisaService: Polisa
                //private fakturaService: Faktura
    ) {
    }

    ngOnInit() {
        this.success = false;
        this.registerAccount = {};
    }

    ngAfterViewInit() {
        this.renderer.invokeElementMethod(this.elementRef.nativeElement.querySelector('#login'), 'focus', []);
    }

    register() {
        if (this.registerAccount.password !== this.confirmPassword) {
            this.doNotMatch = 'ERROR';
        } else {
            this.doNotMatch = null;
            this.error = null;
            this.errorUserExists = null;
            this.errorEmailExists = null;
            this.languageService.getCurrent().then((key) => {
                this.registerAccount.langKey = key;
                this.registerService.save(this.registerAccount).subscribe(() => {
                    this.success = true;
                }, (response) => this.processError(response));
            });
        }
    }


    private processError(response) {
        this.success = null;
        if (response.status === 400 && response.json().type === LOGIN_ALREADY_USED_TYPE) {
            this.errorUserExists = 'ERROR';
        } else if (response.status === 400 && response.json().type === EMAIL_ALREADY_USED_TYPE) {
            this.errorEmailExists = 'ERROR';
        } else {
            this.error = 'ERROR';
        }
    }


    public pobierzPolise = () => {
        this.polisaId = this.polisaService.getPolisaId();
        // this.http.get(this._webApiUrl + 'polisa_mieszkaniowa/' + this.polisaService.getPolisaId())
        //     .subscribe(result => this.polisa = result.json());
    };


    dodajZabezpieczeniePrzeciwkradziezowe() {
        let pol = new PolisaMieszkaniowa(null, null, null, null, null, null, this.polisaId);
        console.log(pol);
        let zab = new ZabezpieczeniePrzeciwkradziezowe(pol, this.kwota);
        console.log(zab);
        this.http.post(this._webApiUrl + 'zabezpieczenie_przeciwkradziezowe', zab)
            .subscribe(data => {

            }, error => {
                console.log(error.json());
            });
    };


    dodajUbezpieczenieRuchomosciDomowych() {
        let pol = new PolisaMieszkaniowa(null, null, null, null, null, null, this.polisaId);
        console.log(pol);
        let ubezp = new UbezpieczenieRuchomosciDomowych(pol, this.kwota2);
        this.http.post(this._webApiUrl + 'ubezpieczenie_ruchomosci_domowych', ubezp)
            .subscribe(data => {

            }, error => {
                console.log(error.json());
            });
    };

    dodajFakture() {
        let faktura = new FakturaMieszkaniowa(this.fakturaId, this.kwotaF, this.opis, this.data); //
        // console.log(faktura);
        this.http.post(this._webApiUrl + 'faktura', faktura)
            .subscribe(data => {
                this.fakturaMieszkaniowa = data.json();
                console.log(data.json());
                console.log(this.fakturaMieszkaniowa);
            }, error => {
                console.log(error.json());
            });

    };

    public pobierzFakturyMieszkaniowe = () => {
        this.http.get(this._webApiUrl + 'faktura')

            .subscribe(result => this.faktury = result.json());
    };


    public uaktualnijPoliseMieszkaniowa(fakturaId) {
        let pol = new PolisaMieszkaniowa(null, null, null, null, null, null, this.polisaId, new FakturaMieszkaniowa(fakturaId, null, null, null));
        console.log(pol);
        this.http.put(this._webApiUrl + 'polisa_mieszkaniowa', pol)
            .subscribe(data => {
            }, error => {
                console.log(error.json());
            });
    };


}
