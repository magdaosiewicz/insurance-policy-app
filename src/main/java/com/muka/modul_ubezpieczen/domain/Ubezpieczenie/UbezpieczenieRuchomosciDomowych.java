package com.muka.modul_ubezpieczen.domain.Ubezpieczenie;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

/**
 * Created by Magda on 27.12.2017.
 */
@NoArgsConstructor
@Getter
@Entity
@Table(name = "UBEZPIECZENIA_RUCHOMOSCI_DOMOWYCH")
public class UbezpieczenieRuchomosciDomowych {

    @Id
    @Column(name = "ID")
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Column(name = "Koszt")
    private double koszt;

    @Column(name = "Data")
    private LocalDateTime data = now();

    @OneToOne
    private PolisaMieszkaniowa polisaMieszkaniowa;


    @Builder
    public UbezpieczenieRuchomosciDomowych(double koszt, LocalDateTime data, PolisaMieszkaniowa polisaMieszkaniowa) {
        this.koszt = koszt;
        this.data = data;
        this.polisaMieszkaniowa = polisaMieszkaniowa;
    }

    public Long getId() {
        return id;
    }
}
