package com.muka.modul_ubezpieczen.domain.Inne;

import com.muka.modul_ubezpieczen.domain.Klient.Klient;
import com.muka.modul_ubezpieczen.domain.Ubezpieczenie.Ubezpieczenie;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

/**
 * Created by Magda on 25.12.2017.
 */

@NoArgsConstructor
@Getter
@Entity
@Table(name = "POLISY_SAMOCHODOWE")
public class PolisaSamochodowa {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "ubezpieczenia_id")
    @ManyToOne
    private Ubezpieczenie ubezpieczenie;  // ubezpieczenia

    @JoinColumn(name = "Klienci_id")
    @ManyToOne
    private Klient klient;

    @JoinColumn(name = "Pracownicy_id")
    @ManyToOne
    private Pracownik pracownik;

    @ManyToOne
    private Samochod samochod;

    @Column(name = "Data_dodania ", length = 60)
    private LocalDateTime dataDodania = now();

    @Column(name = "Data_rozpoczecia ", length = 60)
    private LocalDateTime dataRozpoczecia = now();

    @Column(name = "Data_zakonczenia ", length = 60)
    private LocalDateTime dataZakonczenia = now();

    @Column(name = "Typ_umowy ", length = 60)
    private Integer typUmowy;

    @Column(name = "Status ", length = 60)
    private Integer status;


}
