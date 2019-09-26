package com.muka.modul_ubezpieczen.service;

import com.muka.modul_ubezpieczen.domain.Klient.Klient;
import com.muka.modul_ubezpieczen.repository.KlientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

/**
 * Created by Magda on 18.12.2017.
 */
@Service
public class KlientService {

    @Autowired
    private KlientRepository klientRepository;


    public Klient dodajKlienta(Klient klient) {
        return klientRepository.save(klient);
    }

    public List<Klient> pobierzKlientow() {
        return klientRepository.findAll();
    }

    public Klient findOneById(Long klientId) {
        return ofNullable(klientRepository.findOne(klientId)).orElseThrow(ResourceNotExistException::new);
    }


}
