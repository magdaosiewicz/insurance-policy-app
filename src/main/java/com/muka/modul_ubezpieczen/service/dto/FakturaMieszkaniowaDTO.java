package com.muka.modul_ubezpieczen.service.dto;

import com.muka.modul_ubezpieczen.domain.Faktura.FakturaMieszkaniowa;
import lombok.*;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

/**
 * Created by Magda on 28.12.2017.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakturaMieszkaniowaDTO {

    private Long id;
    private Double kwota;
    private String opis;
    private LocalDateTime data = now();


    public static FakturaMieszkaniowaDTO ofFakturaMieszkaniowa(FakturaMieszkaniowa fakturaMieszkaniowa) {
        return FakturaMieszkaniowaDTO.builder()
            .id(fakturaMieszkaniowa.getId())
            .kwota(fakturaMieszkaniowa.getKwota())
            .opis(fakturaMieszkaniowa.getOpis())
            .data(fakturaMieszkaniowa.getData())
            .build();

    }


}
