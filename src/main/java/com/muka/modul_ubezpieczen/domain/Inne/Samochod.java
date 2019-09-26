package com.muka.modul_ubezpieczen.domain.Inne;

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
@Table(name = "SAMOCHOD")
public class Samochod {


    @Id
    @Column(name = "ID ", length = 60)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IDSamochod;

    @Column(name = "Rok_produkcji")
    private LocalDateTime rokProdukcji = now();

    @Column(name = "Marka")
    private String marka;

    @Column(name = "Model")
    private String model;

    @Column(name = "Wartosc")
    private Long wartosc;

    @Column(name = "Numer_rejestracyjny")
    private String numerRejestracyjny;


}
