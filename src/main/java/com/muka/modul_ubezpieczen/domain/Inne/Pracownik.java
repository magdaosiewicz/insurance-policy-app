package com.muka.modul_ubezpieczen.domain.Inne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Magda on 25.12.2017.
 */
@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "PRACOWNICY")
public class Pracownik {

    @Id
    @Column(name = "ID ", length = 60)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idKlient;

    @Column(name = "Imie ", length = 60)
    private String imie;

    @Column(name = "Nazwisko ", length = 60)
    private String nazwisko;

    @Column(name = "Adres", length = 60)
    private String adresZamieszkania;

    @Column(name = "Kod_poczztowy ", length = 6)
    private Integer kodPocztowy;

    @Column(name = "Email ", length = 60)
    private String email;

    @Column(name = "Numer_telefonu ", length = 12)
    private Integer numerTelefonu;

    @Column(name = "PESEL ", length = 60)
    private Long pesel;

    @Column(name = "Seria_dowodu", length = 10)
    private String seriaDowodu;

}
