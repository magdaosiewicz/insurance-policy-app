package com.muka.modul_ubezpieczen.domain.Ubezpieczenie;

import com.muka.modul_ubezpieczen.domain.Faktura.FakturaMieszkaniowa;
import com.muka.modul_ubezpieczen.domain.Inne.Pracownik;
import com.muka.modul_ubezpieczen.domain.Klient.Klient;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Magda on 25.12.2017.
 */


@NoArgsConstructor
@Getter
@Entity
@Table(name = "POLISY_MIESZKANIOWE")
public class PolisaMieszkaniowa {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPolisaMieszkaniowa;

    @Setter
    @JoinColumn(name = "ubezpieczenia_id")
    @ManyToOne
    private Ubezpieczenie ubezpieczenie;

    @Setter
    @JoinColumn(name = "Klienci_id")
    @ManyToOne
    private Klient klient;

    @Setter
    @JoinColumn(name = "Pracownicy_id")
    @ManyToOne
    private Pracownik pracownik;

    @Setter
    @OneToOne
    private FakturaMieszkaniowa fakturaMieszkaniowa;

    @Setter
    @Column(name = "Miasto ", length = 60)
    private String miasto;

    @Setter
    @Column(name = "KodPocztowy ", length = 60)
    private Integer kodPcztowy;

    @Setter
    @Column(name = "Ulica ", length = 60)
    private String ulica;

    @Setter
    @Column(name = "Numer_budynku ", length = 60)
    private Integer numerBudynku;

    @Setter
    @Column(name = "Numer_mieszkania ", length = 60)
    private Integer numerMieszkania;

    @Builder
    public PolisaMieszkaniowa(String miasto, Integer kodPcztowy, String ulica, Integer numerBudynku, Integer numerMieszkania, Klient klient, FakturaMieszkaniowa fakturaMieszkaniowa) {

        this.miasto = miasto;
        this.kodPcztowy = kodPcztowy;
        this.ulica = ulica;
        this.numerBudynku = numerBudynku;
        this.numerMieszkania = numerMieszkania;
        this.klient = klient;
        this.fakturaMieszkaniowa = fakturaMieszkaniowa;

    }


}
