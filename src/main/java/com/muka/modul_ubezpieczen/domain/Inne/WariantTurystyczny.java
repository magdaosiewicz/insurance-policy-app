package com.muka.modul_ubezpieczen.domain.Inne;

import com.muka.modul_ubezpieczen.domain.Ubezpieczenie.Ubezpieczenie;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Magda on 26.12.2017.
 */


@NoArgsConstructor
@Getter
@Entity
@Table(name = "WARIANTY_TURYSTYCZNE")
public class WariantTurystyczny {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "ubezpieczenia_id")
    @ManyToOne
    private Ubezpieczenie ubezpieczenie;

    @JoinColumn(name = "Warianty_turystyczne_ubezpieczenia_ID")
    @OneToMany
    private List<PolisaTurystyczna> polisyTurystyczne;


    @Column(name = "Nazwa")
    private String nazwa;

    @Column(name = "Opis_polisy")
    private String opisPolisy;

    @Column(name = "Skladka_miesieczna")
    private double skladkaMiesieczna;

    @Column(name = "Max_odszkodowanie")
    private double max_odszkodowanie;


}
