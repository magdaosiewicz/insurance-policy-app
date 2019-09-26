package com.muka.modul_ubezpieczen.domain.Faktura;

import com.muka.modul_ubezpieczen.domain.Inne.PolisaTurystyczna;
import com.muka.modul_ubezpieczen.domain.Inne.Pracownik;
import com.muka.modul_ubezpieczen.domain.Ubezpieczenie.PolisaMieszkaniowa;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

/**
 * Created by Magda on 25.12.2017.
 */

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "FAKTURA_MIESZKANIOWA")
public class FakturaMieszkaniowa {


    @Id
    @Column(name = "ID ", length = 60)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Kwota ", length = 60)
    private double kwota;

    @Column(name = "Opis ", length = 60)
    private String opis;

    @Column(name = "Data ", length = 60)
    private LocalDateTime data = now();


    @Builder
    public FakturaMieszkaniowa (double kwota, String opis, LocalDateTime data){

        this.kwota=kwota;
        this.opis=opis;
        this.data=data;
    }


}
