package com.muka.modul_ubezpieczen.service.dto;

import com.muka.modul_ubezpieczen.domain.Ubezpieczenie.UbezpieczenieRuchomosciDomowych;
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
public class UbezpieczenieRuchomosciDomowychDTO {

    public Long id;
    public Double koszt;
    public LocalDateTime data = now();
    public PolisaMieszkaniowaDTO polisaMieszkaniowaDTO;


    public static UbezpieczenieRuchomosciDomowychDTO ofUbezpieczenieRuchomosciDomowych(UbezpieczenieRuchomosciDomowych ubezpieczenieRuchomosciDomowych) {


        return UbezpieczenieRuchomosciDomowychDTO.builder()
            .id(ubezpieczenieRuchomosciDomowych.getId())
            .koszt(ubezpieczenieRuchomosciDomowych.getKoszt())
            .data(ubezpieczenieRuchomosciDomowych.getData())
            .polisaMieszkaniowaDTO(ofPolisaMieszkaniowa(ubezpieczenieRuchomosciDomowych.getPolisaMieszkaniowa()))
            .build();

    }


}
