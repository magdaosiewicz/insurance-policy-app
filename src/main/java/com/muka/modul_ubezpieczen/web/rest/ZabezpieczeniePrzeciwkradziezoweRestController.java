package com.muka.modul_ubezpieczen.web.rest;

import com.muka.modul_ubezpieczen.domain.Ubezpieczenie.PolisaMieszkaniowa;
import com.muka.modul_ubezpieczen.domain.Ubezpieczenie.ZabezpieczeniePrzeciwkradziezowe;
import com.muka.modul_ubezpieczen.service.PolisaMieszkaniowaService;
import com.muka.modul_ubezpieczen.service.ZabezpieczeniePrzeciwkradziezoweService;
import com.muka.modul_ubezpieczen.service.dto.ZabezpieczeniePrzeciwkradziezoweDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import static com.muka.modul_ubezpieczen.service.dto.ZabezpieczeniePrzeciwkradziezoweDTO.ofZabezpieczeniePrzeciwkradziezowe;
import static java.time.LocalDateTime.now;

/**
 * Created by Magda on 28.12.2017.
 */


@RestController
@RequestMapping("/api/zabezpieczenie_przeciwkradziezowe")
public class ZabezpieczeniePrzeciwkradziezoweRestController {

    @Autowired
    ZabezpieczeniePrzeciwkradziezoweService zabezpieczeniePrzeciwkradziezoweService;

    @Autowired
    PolisaMieszkaniowaService polisaMieszkaniowaService;

    @PostMapping()
    public ResponseEntity<ZabezpieczeniePrzeciwkradziezoweDTO> dodajZabezpieczeniePrzeciwkradziezowe(@RequestBody ZabezpieczeniePrzeciwkradziezoweDTO zabezpieczeniePrzeciwkradziezoweDTO) throws URISyntaxException {

        PolisaMieszkaniowa polisaMieszkaniowa1 = polisaMieszkaniowaService.findOneById(zabezpieczeniePrzeciwkradziezoweDTO.getPolisaMieszkaniowaDTO().getId());

        ZabezpieczeniePrzeciwkradziezowe zabezpieczeniePrzeciwkradziezoweToPersist = ZabezpieczeniePrzeciwkradziezowe.builder()
            .koszt(zabezpieczeniePrzeciwkradziezoweDTO.getKoszt())
            .data(now())
            .polisaMieszkaniowa(polisaMieszkaniowa1)
            .build();


        ZabezpieczeniePrzeciwkradziezowe persistedZabezpieczeniePrzeciwkradziezowe = zabezpieczeniePrzeciwkradziezoweService.dodajZabezpieczeniePrzeciwkradziezowe(zabezpieczeniePrzeciwkradziezoweToPersist);

        return ResponseEntity.created(new URI("/api/zabezpieczenie_przeciwkradziezowe/" + persistedZabezpieczeniePrzeciwkradziezowe.getId()))
            .body(ofZabezpieczeniePrzeciwkradziezowe(persistedZabezpieczeniePrzeciwkradziezowe));

    }

    @PutMapping
    public ResponseEntity<ZabezpieczeniePrzeciwkradziezoweDTO> modyfikujZabezpieczeniePrzeciwkradziezowe(@RequestBody ZabezpieczeniePrzeciwkradziezoweDTO zabezpieczeniePrzeciwkradziezoweDTO) throws URISyntaxException {

        //  ZabezpieczeniePrzeciwkradziezowe zabezpieczeniePrzeciwkradziezowe = zabezpieczeniePrzeciwkradziezoweService.findOne(ofNullable(zabezpieczeniePrzeciwkradziezoweDTO)
        // .map(zabezpieczeniePrzeciwkradziezoweDTO-> zabezpieczeniePrzeciwkradziezoweDTO.getKoszt())
        // .orElse(-1L));

        ZabezpieczeniePrzeciwkradziezowe zabezpieczeniePrzeciwkradziezoweToUpdate = zabezpieczeniePrzeciwkradziezoweService.findOneById(zabezpieczeniePrzeciwkradziezoweDTO.getId());
        zabezpieczeniePrzeciwkradziezoweToUpdate.setKoszt(zabezpieczeniePrzeciwkradziezoweDTO.getKoszt());

        ZabezpieczeniePrzeciwkradziezowe updatedZabezpieczeniePrzeciwkradziezowe = zabezpieczeniePrzeciwkradziezoweService.modyfikujZabezpieczeniePrzeciwkradziezowe(zabezpieczeniePrzeciwkradziezoweToUpdate);

        return ResponseEntity.ok(ofZabezpieczeniePrzeciwkradziezowe(updatedZabezpieczeniePrzeciwkradziezowe));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> pobierzZabezpieczeniaPrzeciwkradziezowe() {
        return ResponseEntity.ok(zabezpieczeniePrzeciwkradziezoweService.pobierzZabezpieczeniaPrzeciwkradziezowe());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> pobierzZabezpieczeniePrzeciwkradziezoweByIdPolisaMieszkaniowa(@PathVariable Long id) {

        return ResponseEntity.ok(ofZabezpieczeniePrzeciwkradziezowe(zabezpieczeniePrzeciwkradziezoweService.pobierzZabezpieczeniePrzeciwkradziezoweByIdPolisaMieszkaniowa(id)));
    }


}

