package com.muka.modul_ubezpieczen.domain.Inne;

import com.muka.modul_ubezpieczen.domain.Klient.Klient;
import com.muka.modul_ubezpieczen.domain.Ubezpieczenie.Ubezpieczenie;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

/**
 * Created by Magda on 26.12.2017.
 */

@NoArgsConstructor
@Getter
@Entity
@Table(name = "POLISY_TURYSTYCZNE")
public class PolisaTurystyczna {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "ubezpieczenia_id")
    @ManyToOne
    private Ubezpieczenie ubezpieczenie;  // ubezpieczenia

    @JoinColumn(name = "Warianty_turystyczne_id")
    @ManyToOne
    private WariantTurystyczny wariantTurystyczny;

    @JoinColumn(name = "Klienci_id")
    @ManyToOne
    private Klient klient;//

    @JoinColumn(name = "Pracownicy_id")
    @ManyToOne
    private Pracownik pracownik;


    @Column(name = "Data_dodania ", length = 60)
    private LocalDateTime dataDodania = now();

    @Column(name = "Data_rozpoczecia ", length = 60)
    private LocalDateTime dataRozpoczecia = now();

    @Column(name = "Data_zakonczenia ", length = 60)
    private LocalDateTime dataZakonczenia = now();

    @Column(name = "Cena")
    private double cena;

    @Column(name = "Max_odszkodowanie")
    private double max_odszkodowanie;


}
