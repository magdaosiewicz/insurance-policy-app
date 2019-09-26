/**
 * Created by Magda on 18.01.2018.
 */
import {Injectable} from "@angular/core";

@Injectable()
export class Faktura {

    private fakturaId;

    constructor() {
    }

    public setFakturaId(fakturaId) {
        this.fakturaId = fakturaId;
    }

    public getFakturaId() {
        return this.fakturaId;
    }
}
