package com.muka.modul_ubezpieczen.service;

import com.muka.modul_ubezpieczen.domain.Faktura.FakturaMieszkaniowa;
import com.muka.modul_ubezpieczen.repository.FakturaMieszkaniowaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Magda on 28.12.2017.
 */
@Service
public class FakturaMieszkaniowaService {

    @Autowired
    FakturaMieszkaniowaRepository fakturaMieszkaniowaRepository;

    public FakturaMieszkaniowa dodajFakture(FakturaMieszkaniowa fakturaMieszkaniowa) {
        return fakturaMieszkaniowaRepository.save(fakturaMieszkaniowa);
    }

    public FakturaMieszkaniowa findOne(Long idFaktura) {
        return fakturaMieszkaniowaRepository.findOne(idFaktura);
    }


    public List<FakturaMieszkaniowa> pobierzFakturyMieszkaniowe() {
        return fakturaMieszkaniowaRepository.findAll();
    }


}
