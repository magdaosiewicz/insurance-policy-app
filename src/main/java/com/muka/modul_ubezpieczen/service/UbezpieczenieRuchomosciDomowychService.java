package com.muka.modul_ubezpieczen.service;

import com.muka.modul_ubezpieczen.domain.Ubezpieczenie.UbezpieczenieRuchomosciDomowych;
import com.muka.modul_ubezpieczen.repository.UbezpieczenieRuchomosciDomowychRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

/**
 * Created by Magda on 28.12.2017.
 */
@Service
public class UbezpieczenieRuchomosciDomowychService {

    @Autowired
    UbezpieczenieRuchomosciDomowychRepository ubezpieczenieRuchomosciDomowychRepository;


    public UbezpieczenieRuchomosciDomowych dodajUbezpieczenieRuchomosciDomowych(UbezpieczenieRuchomosciDomowych ubezpieczenieRuchomosciDomowych) {
        return ubezpieczenieRuchomosciDomowychRepository.save(ubezpieczenieRuchomosciDomowych);
    }

    public UbezpieczenieRuchomosciDomowych findOneById(Long idUbezpieczenieRuchomosciDomowych) {
        return ofNullable(ubezpieczenieRuchomosciDomowychRepository.findOne(idUbezpieczenieRuchomosciDomowych)).orElseThrow(ResourceNotExistException::new);
    }

    public UbezpieczenieRuchomosciDomowych modyfikujUbezpieczenieRuchomosciDomowych(UbezpieczenieRuchomosciDomowych ubezpieczenieRuchomosciDomowych) {
        return ubezpieczenieRuchomosciDomowychRepository.save(ubezpieczenieRuchomosciDomowych);
    }


    public List<UbezpieczenieRuchomosciDomowych> pobierzUbezpieczeniaRuchomosciDomowych() {
        return ubezpieczenieRuchomosciDomowychRepository.findAll();
    }

    public UbezpieczenieRuchomosciDomowych pobierzUbezpieczeniaRuchomosciDomowychByIdPolisaMieszkaniowa(Long polisaMieszkaniowaId) {
        return ubezpieczenieRuchomosciDomowychRepository.findByPolisaMieszkaniowaIdPolisaMieszkaniowa(polisaMieszkaniowaId);
    }


}
