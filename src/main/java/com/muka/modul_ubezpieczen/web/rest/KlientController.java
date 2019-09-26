package com.muka.modul_ubezpieczen.web.rest;

import com.muka.modul_ubezpieczen.domain.Klient.Klient;
import com.muka.modul_ubezpieczen.service.KlientService;
import com.muka.modul_ubezpieczen.service.dto.KlientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

import static com.muka.modul_ubezpieczen.service.dto.KlientDTO.ofKlient;

/**
 * Created by Magda on 17.12.2017.
 */

@RestController
@RequestMapping("/api/klient")
public class KlientController {

    @Autowired
    KlientService klientService;

    @PostMapping(value = "/addEmpolyee")
    public ResponseEntity<KlientDTO> dodajKlienta(KlientDTO klient) throws URISyntaxException {

        Klient klientToPersist = Klient.builder()
            .imie(klient.getImie())
            .nazwisko(klient.getNazwisko())
            .adres(klient.getAdresZamieszkania())
            .kodPocztowy(klient.getKodPocztowy())
            .email(klient.getEmail())
            .numerTelefonu(klient.getNumerTelefonu())
            .pesel(klient.getPesel())
            .seriaDowodu(klient.getSeriaDowodu())
            .build();
        Klient persistedKlient = klientService.dodajKlienta(klientToPersist);

        return ResponseEntity.created(new URI("/api/klient/" + persistedKlient.getId()))
            .body(ofKlient(persistedKlient));
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> pobierzKlientow() {

        return ResponseEntity.ok(klientService.pobierzKlientow());
    }


}

