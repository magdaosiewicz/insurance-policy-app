package com.muka.modul_ubezpieczen.web.rest;

import com.muka.modul_ubezpieczen.domain.Faktura.FakturaMieszkaniowa;
import com.muka.modul_ubezpieczen.domain.Klient.Klient;
import com.muka.modul_ubezpieczen.domain.Ubezpieczenie.PolisaMieszkaniowa;
import com.muka.modul_ubezpieczen.service.FakturaMieszkaniowaService;
import com.muka.modul_ubezpieczen.service.KlientService;
import com.muka.modul_ubezpieczen.service.PolisaMieszkaniowaService;
import com.muka.modul_ubezpieczen.service.dto.PolisaMieszkaniowaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import static com.muka.modul_ubezpieczen.service.dto.PolisaMieszkaniowaDTO.ofPolisaMieszkaniowa;
import static java.util.Optional.ofNullable;

/**
 * Created by Magda on 28.12.2017.
 */
@RestController
@RequestMapping("/api/polisa_mieszkaniowa")
public class PolisaMieszkaniowaRestController {

    @Autowired
    private KlientService klientService;

    @Autowired
    private PolisaMieszkaniowaService polisaMieszkaniowaService;

    @Autowired
    private FakturaMieszkaniowaService fakturaMieszkaniowaService;

    @PostMapping()
    public ResponseEntity<PolisaMieszkaniowaDTO> dodajPoliseMieszkaniowa(@RequestBody PolisaMieszkaniowaDTO polisaMieszkaniowa) throws URISyntaxException {

        Klient klient = klientService.findOneById(polisaMieszkaniowa.getKlientDTO().getId());

        PolisaMieszkaniowa polisaMieszkaniowaToPersist = PolisaMieszkaniowa.builder()
            .miasto(polisaMieszkaniowa.getMiasto())
            .kodPcztowy(polisaMieszkaniowa.getKodPocztowy())
            .ulica(polisaMieszkaniowa.getUlica())
            .numerBudynku(polisaMieszkaniowa.getNumerBudynku())
            .numerMieszkania(polisaMieszkaniowa.getNumerMieszkania())
            .klient(klient)
            .build();


        PolisaMieszkaniowa persistedPolisaMieszkaniowa = polisaMieszkaniowaService.dodajPoliseMieszkaniowa(polisaMieszkaniowaToPersist);

        return ResponseEntity.created(new URI("/api/polisa_mieszkaniowa/" + persistedPolisaMieszkaniowa.getIdPolisaMieszkaniowa()))
            .body(ofPolisaMieszkaniowa(persistedPolisaMieszkaniowa));
    }

    @PutMapping
    public ResponseEntity<PolisaMieszkaniowaDTO> uaktualnijPoliseMieszkaniowa(@RequestBody PolisaMieszkaniowaDTO polisaMieszkaniowa) throws URISyntaxException {

        FakturaMieszkaniowa fakturaMieszkaniowa = fakturaMieszkaniowaService.findOne(ofNullable(polisaMieszkaniowa.fakturaMieszkaniowa)
            .map(fakturaMieszkaniowaDTO -> fakturaMieszkaniowaDTO.getId())
            .orElse(-1L));

        PolisaMieszkaniowa polisaMieszkaniowaToUpdate = polisaMieszkaniowaService.findOneById(polisaMieszkaniowa.getId());
        polisaMieszkaniowaToUpdate.setFakturaMieszkaniowa(fakturaMieszkaniowa);

        PolisaMieszkaniowa updatedPolisaMieszkaniowa = polisaMieszkaniowaService.uaktualnijPoliseMieszkaniowa(polisaMieszkaniowaToUpdate);

        return ResponseEntity.ok(ofPolisaMieszkaniowa(updatedPolisaMieszkaniowa));
    }


    @DeleteMapping(value = "/ubezpieczenie-ruchomosci-domowych/{polisaMieszkaniowaId}")
    public ResponseEntity<Void> deleteUbezpieczenieRuchomosciDomowychByPolisaMieszkaniowaId(@PathVariable Long polisaMieszkaniowaId) {
        polisaMieszkaniowaService.deleteUbezpieczenieRuchomosciDomowych(polisaMieszkaniowaId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/zabezpieczenie-przeciwkradziezowe/{polisaMieszkaniowaId}")
    public ResponseEntity<Void> deleteZabezpieczeniePrzeciwkradziezoweByPolisaMieszkaniowaId(@PathVariable Long polisaMieszkaniowaId) {
        polisaMieszkaniowaService.deleteZabezpieczeniePrzeciwkradziezowe(polisaMieszkaniowaId);
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> pobierzPolisy() {
        return ResponseEntity.ok(polisaMieszkaniowaService.pobierzPolisy());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> pobierzPoliseById(@PathVariable Long id) {
        return ResponseEntity.ok(ofPolisaMieszkaniowa(polisaMieszkaniowaService.findOneById(id)));
    }

}
