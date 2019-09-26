package com.muka.modul_ubezpieczen.service.dto;

import com.muka.modul_ubezpieczen.domain.Klient.Klient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Magda on 18.12.2017.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KlientDTO {

    private Long id;
    private String imie;
    private String nazwisko;
    private String adresZamieszkania;
    private Integer kodPocztowy;
    private String email;
    private Integer numerTelefonu;
    private Long pesel;
    private String seriaDowodu;

    public KlientDTO(Long id) {
        this.id = id;
    }


    public static KlientDTO ofKlient(Klient klient) {
        return new KlientDTO(klient.getId(), klient.getImie(), klient.getNazwisko(), klient.getAdres(),
            klient.getKodPocztowy(), klient.getEmail(), klient.getNumerTelefonu(), klient.getPesel(), klient.getSeriaDowodu());
    }


}
