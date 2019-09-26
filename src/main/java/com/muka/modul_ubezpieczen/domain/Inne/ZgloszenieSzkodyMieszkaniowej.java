package com.muka.modul_ubezpieczen.domain.Inne;

import com.muka.modul_ubezpieczen.domain.Ubezpieczenie.PolisaMieszkaniowa;
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
@Table(name = "ZGLOSZENIE_SZKODY_MIESZKANIOWEJ")
public class ZgloszenieSzkodyMieszkaniowej {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @ManyToOne
    private PolisaMieszkaniowa polisaMieszkaniowa;

    @Column(name = "Data")
    private LocalDateTime data = now();

    @Column(name = "Dokumentacja_url")
    private String DokumentacjaUrl;

    @Column(name = "Rozpatrzone")
    private Integer rozpatrzone;

    @Column(name = "Data_weryfikacji")
    private LocalDateTime dataWeryfikacji = now();

}
