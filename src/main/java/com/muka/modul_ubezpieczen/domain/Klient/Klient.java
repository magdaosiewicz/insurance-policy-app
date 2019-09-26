package com.muka.modul_ubezpieczen.domain.Klient;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Magda on 17.12.2017.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "KLIENCI")
public class Klient {


    @Id
    @Column(name = "ID", length = 60)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Imie ", length = 60)
    private String imie;

    @Column(name = "Nazwisko ", length = 60)
    private String nazwisko;

    @Column(name = "Adres_zamieszkania", length = 60)
    private String adres;

    @Column(name = "Kod_pocztowy ", length = 6)
    private Integer kodPocztowy;

    @Column(name = "Email ", length = 60)
    private String email;

    @Column(name = "Numer_telefonu ", length = 12)
    private Integer numerTelefonu;

    @Column(name = "PESEL ", length = 60)
    private Long pesel;

    @Column(name = "Seria_dowodu", length = 10)
    private String seriaDowodu;


    @Builder
    public Klient(String imie, String nazwisko, String adres, Integer kodPocztowy, String email, Integer numerTelefonu, Long pesel, String seriaDowodu) {

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.kodPocztowy = kodPocztowy;
        this.email = email;
        this.numerTelefonu = numerTelefonu;
        this.pesel = pesel;
        this.seriaDowodu = seriaDowodu;
    }

}
