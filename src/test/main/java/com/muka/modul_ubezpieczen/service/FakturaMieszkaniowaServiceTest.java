package com.muka.modul_ubezpieczen.service;

import com.muka.modul_ubezpieczen.domain.Faktura.FakturaMieszkaniowa;
import com.muka.modul_ubezpieczen.repository.FakturaMieszkaniowaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by Magda on 19.01.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class FakturaMieszkaniowaServiceTest {

    @InjectMocks
    FakturaMieszkaniowaService fakturaMieszkaniowaService;

    @Mock
    FakturaMieszkaniowaRepository fakturaMieszkaniowaRepository;

    @Test
    public void shouldReturnFakturaMieszkaniowa() {

        FakturaMieszkaniowa fakturaMieszkaniowa = FakturaMieszkaniowa.builder()
            .kwota(89)
            .opis("pierwsza")
            .build();

        when(fakturaMieszkaniowaRepository.save(fakturaMieszkaniowa)).thenReturn(fakturaMieszkaniowa);
        FakturaMieszkaniowa dodanaFakturaMieszkaniowa = fakturaMieszkaniowaService.dodajFakture(fakturaMieszkaniowa);

        assertEquals(fakturaMieszkaniowa.getKwota(), dodanaFakturaMieszkaniowa.getKwota(), 0);
        assertEquals(fakturaMieszkaniowa.getOpis(), dodanaFakturaMieszkaniowa.getOpis());

    }


}
