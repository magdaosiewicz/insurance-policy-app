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
@NoArgsConstructor
@Getter
@Entity
@Table(name = "ZGLOSZENIE_SZKODY_SAMOCHODOWEJ")
public class ZgloszenieSzkodySamochodowej {

    @Id
    @Column(name = "id_zgloszenia")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @ManyToOne
    private PolisaSamochodowa polisaSamochodowa;


    @Column(name = "Data_zgloszenia")
    private LocalDateTime dataZgloszenia = now();

    @Column(name = "Status_zgloszenia")
    private String statusZgloszenia;

}
