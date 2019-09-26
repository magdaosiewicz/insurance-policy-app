package com.muka.modul_ubezpieczen.service;

import com.muka.modul_ubezpieczen.domain.Ubezpieczenie.PolisaMieszkaniowa;
import com.muka.modul_ubezpieczen.repository.PolisaMieszkaniowaRepository;
import com.muka.modul_ubezpieczen.repository.UbezpieczenieRuchomosciDomowychRepository;
import com.muka.modul_ubezpieczen.repository.ZabezpieczeniePrzeciwkradziezoweRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

/**
 * Created by Magda on 27.12.2017.
 */
@Service
public class PolisaMieszkaniowaService {


    @Autowired
    private PolisaMieszkaniowaRepository polisaMieszkaniowaRepository;


    private final List<PolisaMieszkaniowa> polisy = new ArrayList<>();


    @Autowired
    private UbezpieczenieRuchomosciDomowychRepository ubezpieczenieRuchomosciDomowychRepository;

    @Autowired
    private ZabezpieczeniePrzeciwkradziezoweRepository zabezpieczeniePrzeciwkradziezoweRepository;



    public PolisaMieszkaniowa dodajPoliseMieszkaniowa(PolisaMieszkaniowa polisaMieszkaniowa) {
        return polisaMieszkaniowaRepository.save(polisaMieszkaniowa);

//        PolisaMieszkaniowa p = polisaMieszkaniowaRepository.save(polisaMieszkaniowa);
//        PolisaMieszkaniowa p2 = PolisaMieszkaniowa.builder()
//            .numerMieszkania(p.getNumerMieszkania() + 1)
//            .build();
//        return p2;
    }

    public PolisaMieszkaniowa uaktualnijPoliseMieszkaniowa(PolisaMieszkaniowa polisaMieszkaniowa) {
        return polisaMieszkaniowaRepository.save(polisaMieszkaniowa);
    }

    public PolisaMieszkaniowa findOneById(Long polisaMieszkaniowaId) {
        return ofNullable(polisaMieszkaniowaRepository.findOne(polisaMieszkaniowaId)).orElseThrow(ResourceNotExistException::new);
    }


    public void deleteUbezpieczenieRuchomosciDomowych(Long polisaMieszkaniowaId) {
        ubezpieczenieRuchomosciDomowychRepository.delete(ubezpieczenieRuchomosciDomowychRepository.findByPolisaMieszkaniowaIdPolisaMieszkaniowa(polisaMieszkaniowaId));
    }

    public void deleteZabezpieczeniePrzeciwkradziezowe(Long polisaMieszkaniowaId) {
        zabezpieczeniePrzeciwkradziezoweRepository.delete(zabezpieczeniePrzeciwkradziezoweRepository.findByPolisaMieszkaniowaIdPolisaMieszkaniowa(polisaMieszkaniowaId));
    }

    public List<PolisaMieszkaniowa> pobierzPolisy() {
        return polisaMieszkaniowaRepository.findAll();
    }


}
