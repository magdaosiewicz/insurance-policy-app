/**
 * Created by Magda on 29.12.2017.
 */


export class Klient {

    constructor(public id: number, public imie: string = null, public nazwisko: string = null, public adres: string = null, public kodPocztowy: number = null, public email: string = null, public numerTelefonu: number = null, public pesel: number = null, public seriaDowodu: string = null) {
    };

}
