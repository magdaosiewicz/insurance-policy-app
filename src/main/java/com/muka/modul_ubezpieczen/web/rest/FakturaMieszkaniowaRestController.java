package com.muka.modul_ubezpieczen.web.rest;

import com.muka.modul_ubezpieczen.domain.Faktura.FakturaMieszkaniowa;
import com.muka.modul_ubezpieczen.service.FakturaMieszkaniowaService;
import com.muka.modul_ubezpieczen.service.dto.FakturaMieszkaniowaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import static com.muka.modul_ubezpieczen.service.dto.FakturaMieszkaniowaDTO.ofFakturaMieszkaniowa;


/**
 * Created by Magda on 28.12.2017.
 */
@RestController
@RequestMapping("/api/faktura")
public class FakturaMieszkaniowaRestController {


    @Autowired
    FakturaMieszkaniowaService fakturaMieszkaniowaService;


    @PostMapping()
    public ResponseEntity<FakturaMieszkaniowaDTO> dodajFakture(@RequestBody FakturaMieszkaniowaDTO fakturaMieszkaniowaDTO) throws URISyntaxException {

        FakturaMieszkaniowa fakturaMieszkaniowaToPersist = FakturaMieszkaniowa.builder()
            .kwota(fakturaMieszkaniowaDTO.getKwota())
            .opis(fakturaMieszkaniowaDTO.getOpis())
            .data(fakturaMieszkaniowaDTO.getData())
            .build();

        FakturaMieszkaniowa persistedFakturaMieszkaniowa = fakturaMieszkaniowaService.dodajFakture(fakturaMieszkaniowaToPersist);

        return ResponseEntity.created(new URI("/api/faktura/" + persistedFakturaMieszkaniowa.getId()))
            .body(ofFakturaMieszkaniowa(persistedFakturaMieszkaniowa));
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> pobierzFakturyMieszkaniowe() {

        return ResponseEntity.ok(fakturaMieszkaniowaService.pobierzFakturyMieszkaniowe());
    }


    //   @RequestMapping(value ="/{id}",method = RequestMethod.GET)
//    public ResponseEntity<?> pobierzFakturaMieszkaniowaByKlientId(@PathVariable Long id) {

    //     return ResponseEntity.ok(ofFakturaMieszkaniowa(fakturaMieszkaniowaService.pobierzFakturaMieszkaniowaByKlientId(id)));
    // }

}
