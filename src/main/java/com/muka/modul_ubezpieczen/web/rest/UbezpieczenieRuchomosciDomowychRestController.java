package com.muka.modul_ubezpieczen.web.rest;

import com.muka.modul_ubezpieczen.domain.Ubezpieczenie.PolisaMieszkaniowa;
import com.muka.modul_ubezpieczen.domain.Ubezpieczenie.UbezpieczenieRuchomosciDomowych;
import com.muka.modul_ubezpieczen.repository.UbezpieczenieRuchomosciDomowychRepository;
import com.muka.modul_ubezpieczen.service.PolisaMieszkaniowaService;
import com.muka.modul_ubezpieczen.service.UbezpieczenieRuchomosciDomowychService;
import com.muka.modul_ubezpieczen.service.dto.UbezpieczenieRuchomosciDomowychDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import static com.muka.modul_ubezpieczen.service.dto.UbezpieczenieRuchomosciDomowychDTO.ofUbezpieczenieRuchomosciDomowych;
import static java.time.LocalDateTime.now;

/**
 * Created by Magda on 28.12.2017.
 */
@RestController
@RequestMapping("/api/ubezpieczenie_ruchomosci_domowych")
public class UbezpieczenieRuchomosciDomowychRestController {


    @Autowired
    UbezpieczenieRuchomosciDomowychService ubezpieczenieRuchomosciDomowychService;

    @Autowired
    PolisaMieszkaniowaService polisaMieszkaniowaService;
    @Autowired
    UbezpieczenieRuchomosciDomowychRepository ubezpieczenieRuchomosciDomowychRepository;


    @PostMapping()
    public ResponseEntity<UbezpieczenieRuchomosciDomowychDTO> dodajUbezpieczenieRuchomosciDomowych(@RequestBody UbezpieczenieRuchomosciDomowychDTO ubezpieczenieRuchomosciDomowychDTO) throws URISyntaxException {

        PolisaMieszkaniowa polisaMieszkaniowa1 = polisaMieszkaniowaService.findOneById(ubezpieczenieRuchomosciDomowychDTO.getPolisaMieszkaniowaDTO().getId());

        UbezpieczenieRuchomosciDomowych ubezpieczenieRuchomosciDomowychToPersist = UbezpieczenieRuchomosciDomowych.builder()
            .koszt(ubezpieczenieRuchomosciDomowychDTO.getKoszt())
            .data(now())
            .polisaMieszkaniowa(polisaMieszkaniowa1)
            .build();


        UbezpieczenieRuchomosciDomowych persistedUbezpieczenieRuchomosciDomowych = ubezpieczenieRuchomosciDomowychService.dodajUbezpieczenieRuchomosciDomowych(ubezpieczenieRuchomosciDomowychToPersist);

        return ResponseEntity.created(new URI("/api/ubezpieczenie_ruchomosci_domowych/" + persistedUbezpieczenieRuchomosciDomowych.getId()))
            .body(ofUbezpieczenieRuchomosciDomowych(persistedUbezpieczenieRuchomosciDomowych));

    }

    @PutMapping
    public ResponseEntity<UbezpieczenieRuchomosciDomowychDTO> modyfikujUbezpieczenieRuchomosciDomowych(@RequestBody UbezpieczenieRuchomosciDomowychDTO ubezpieczenieRuchomosciDomowychDTO) throws URISyntaxException {


        UbezpieczenieRuchomosciDomowych ubezpieczenieRuchomosciDomowychToUpdate = ubezpieczenieRuchomosciDomowychService.findOneById(ubezpieczenieRuchomosciDomowychDTO.getId());
        ubezpieczenieRuchomosciDomowychToUpdate.setKoszt(ubezpieczenieRuchomosciDomowychDTO.getKoszt());

        UbezpieczenieRuchomosciDomowych updatedUbezpieczenieRuchomosciDomowych = ubezpieczenieRuchomosciDomowychService.modyfikujUbezpieczenieRuchomosciDomowych(ubezpieczenieRuchomosciDomowychToUpdate);

        return ResponseEntity.ok(ofUbezpieczenieRuchomosciDomowych(updatedUbezpieczenieRuchomosciDomowych));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> pobierzUbezpieczeniaRuchomosciDomowych() {
        return ResponseEntity.ok(ubezpieczenieRuchomosciDomowychService.pobierzUbezpieczeniaRuchomosciDomowych());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> pobierzUbezpieczeniaRuchomosciDomowychByIdPolisaMieszkaniowa(@PathVariable Long id) {

        return ResponseEntity.ok(ofUbezpieczenieRuchomosciDomowych(ubezpieczenieRuchomosciDomowychService.pobierzUbezpieczeniaRuchomosciDomowychByIdPolisaMieszkaniowa(id)));
    }


}
