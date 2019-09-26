import {Injectable} from "@angular/core";

@Injectable()
export class Polisa {

    private polisaId;

    constructor() {
    }

    public setPolisaId(polisaId) {
        this.polisaId = polisaId;
    }

    public getPolisaId() {
        return this.polisaId;
    }
}
