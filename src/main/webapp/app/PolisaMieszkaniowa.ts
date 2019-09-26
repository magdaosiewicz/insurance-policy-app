import {Klient} from "./Klient";
import {FakturaMieszkaniowa} from "./FakturaMieszkaniowa";
/**
 * Created by Magda on 29.12.2017.
 */

export class PolisaMieszkaniowa {

    constructor( public klientDTO: Klient, public miasto: string, public kodPocztowy: number, public  ulica: string, public numerBudynku: number, public  numerMieszkania: number, public  id:any=null, public fakturaMieszkaniowa: FakturaMieszkaniowa=null)
    {};


}

