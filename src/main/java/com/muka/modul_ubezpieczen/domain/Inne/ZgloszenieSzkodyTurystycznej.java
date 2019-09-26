package com.muka.modul_ubezpieczen.domain.Inne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

/**
 * Created by Magda on 26.12.2017.
 */


@NoArgsConstructor
@Getter
@Entity
@Table(name = "ZGLOSZENIE_SZKODY_TURYSTYCZNEJ")
public class ZgloszenieSzkodyTurystycznej {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @ManyToOne
    private PolisaTurystyczna polisaTurystyczna;

    @Column(name = "Data")
    private LocalDateTime data = now();

    @Column(name = "Opis")
    private String opis;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "Oplata_polisy")
    private double oplataPolisy;


}
