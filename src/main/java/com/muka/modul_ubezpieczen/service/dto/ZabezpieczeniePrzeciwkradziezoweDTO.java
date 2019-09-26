package com.muka.modul_ubezpieczen.service.dto;

import com.muka.modul_ubezpieczen.domain.Ubezpieczenie.ZabezpieczeniePrzeciwkradziezowe;
import lombok.*;

import java.time.LocalDateTime;

import static com.muka.modul_ubezpieczen.service.dto.PolisaMieszkaniowaDTO.ofPolisaMieszkaniowa;
import static java.time.LocalDateTime.now;

/**
 * Created by Magda on 28.12.2017.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ZabezpieczeniePrzeciwkradziezoweDTO {


    public Long id;
    public Double koszt;
    public LocalDateTime data = now();
    public PolisaMieszkaniowaDTO polisaMieszkaniowaDTO;


    public static ZabezpieczeniePrzeciwkradziezoweDTO ofZabezpieczeniePrzeciwkradziezowe(ZabezpieczeniePrzeciwkradziezowe zabezpieczeniePrzeciwkradziezowe) {

        return ZabezpieczeniePrzeciwkradziezoweDTO.builder()
            .id(zabezpieczeniePrzeciwkradziezowe.getId())
            .koszt(zabezpieczeniePrzeciwkradziezowe.getKoszt())
            .data(zabezpieczeniePrzeciwkradziezowe.getData())
            .polisaMieszkaniowaDTO(ofPolisaMieszkaniowa(zabezpieczeniePrzeciwkradziezowe.getPolisaMieszkaniowa()))
            .build();

    }


}
