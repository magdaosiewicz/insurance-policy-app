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
@Table(name = "ZABEZPIECZENIA_PRZECIWKRADZIEZOWE")
public class ZabezpieczeniePrzeciwkradziezowe {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Column(name = "Koszt")
    private double koszt;

    @Setter
    @Column(name = "Data")
    private LocalDateTime data = now();

    @Setter
    @OneToOne
    private PolisaMieszkaniowa polisaMieszkaniowa;


    @Builder
    public ZabezpieczeniePrzeciwkradziezowe(LocalDateTime data, PolisaMieszkaniowa polisaMieszkaniowa, double koszt) {
        this.koszt = koszt;
        this.data = data;
        this.polisaMieszkaniowa = polisaMieszkaniowa;
    }


}
