package com.muka.modul_ubezpieczen.service.dto;

import com.muka.modul_ubezpieczen.domain.Ubezpieczenie.PolisaMieszkaniowa;
import lombok.*;

import static com.muka.modul_ubezpieczen.service.dto.FakturaMieszkaniowaDTO.ofFakturaMieszkaniowa;
import static com.muka.modul_ubezpieczen.service.dto.KlientDTO.ofKlient;
import static java.util.Optional.ofNullable;

/**
 * Created by Magda on 27.12.2017.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PolisaMieszkaniowaDTO {

    public Long id;
    public String miasto;
    public Integer kodPocztowy;
    public String ulica;
    public Integer numerBudynku;
    public Integer numerMieszkania;
    public KlientDTO klientDTO;
    public FakturaMieszkaniowaDTO fakturaMieszkaniowa;

    public static PolisaMieszkaniowaDTO ofPolisaMieszkaniowa(PolisaMieszkaniowa polisaMieszkaniowa) {
        FakturaMieszkaniowaDTO fakturaMieszkaniowa = ofNullable(polisaMieszkaniowa.getFakturaMieszkaniowa())
            .map(fakturaMieszkaniowa1 -> ofFakturaMieszkaniowa(fakturaMieszkaniowa1))
            .orElse(null);


        return PolisaMieszkaniowaDTO.builder()
            .id(polisaMieszkaniowa.getIdPolisaMieszkaniowa())
            .miasto(polisaMieszkaniowa.getMiasto())
            .kodPocztowy(polisaMieszkaniowa.getKodPcztowy())
            .ulica(polisaMieszkaniowa.getUlica())
            .numerBudynku(polisaMieszkaniowa.getNumerBudynku())
            .numerMieszkania(polisaMieszkaniowa.getNumerMieszkania())
            .klientDTO(ofKlient(polisaMieszkaniowa.getKlient()))
            .fakturaMieszkaniowa(fakturaMieszkaniowa)
            .build();
    }


}
