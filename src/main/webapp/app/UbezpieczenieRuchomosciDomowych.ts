import {PolisaMieszkaniowa} from "./PolisaMieszkaniowa";
/**
 * Created by Magda on 03.01.2018.
 */

export class UbezpieczenieRuchomosciDomowych{

    constructor(public polisaMieszkaniowaDTO: PolisaMieszkaniowa, public koszt: number, public  id:any=null, public data: Date=null)
    {};
}
