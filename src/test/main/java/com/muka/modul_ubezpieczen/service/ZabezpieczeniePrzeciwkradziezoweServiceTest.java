package com.muka.modul_ubezpieczen.service;

import com.muka.modul_ubezpieczen.domain.Ubezpieczenie.ZabezpieczeniePrzeciwkradziezowe;
import com.muka.modul_ubezpieczen.repository.ZabezpieczeniePrzeciwkradziezoweRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by Magda on 17.01.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class ZabezpieczeniePrzeciwkradziezoweServiceTest {

    @InjectMocks
    ZabezpieczeniePrzeciwkradziezoweService zabezpieczeniePrzeciwkradziezoweService;

    @Mock
    ZabezpieczeniePrzeciwkradziezoweRepository zabezpieczeniePrzeciwkradziezoweRepository;

    @Test
    public void shouldReturnZabezpieczeniePrzeciwkradziezowe() {
        ZabezpieczeniePrzeciwkradziezowe zabezpieczeniePrzeciwkradziezowe = ZabezpieczeniePrzeciwkradziezowe.builder()
            .koszt(199)
            .build();

        when(zabezpieczeniePrzeciwkradziezoweRepository.save(zabezpieczeniePrzeciwkradziezowe)).thenReturn(zabezpieczeniePrzeciwkradziezowe);

        ZabezpieczeniePrzeciwkradziezowe dodaneZabezpieczeniePrzeciwkradziezowe = zabezpieczeniePrzeciwkradziezoweService.dodajZabezpieczeniePrzeciwkradziezowe(zabezpieczeniePrzeciwkradziezowe);

        assertEquals(zabezpieczeniePrzeciwkradziezowe.getKoszt(), dodaneZabezpieczeniePrzeciwkradziezowe.getKoszt(), 0);
    }

    @Test
    public void shouldRetunUpdateZabezpieczeniePrzeciwkradziezowe() {
        ZabezpieczeniePrzeciwkradziezowe zabezpieczeniePrzeciwkradziezowe = ZabezpieczeniePrzeciwkradziezowe.builder()
            .koszt(200)
            .build();

        when(zabezpieczeniePrzeciwkradziezoweRepository.save(zabezpieczeniePrzeciwkradziezowe)).thenReturn(zabezpieczeniePrzeciwkradziezowe);
        ZabezpieczeniePrzeciwkradziezowe dodaneZabezpieczeniePrzeciwkradziezowe = zabezpieczeniePrzeciwkradziezoweService.modyfikujZabezpieczeniePrzeciwkradziezowe(zabezpieczeniePrzeciwkradziezowe);

        assertEquals(zabezpieczeniePrzeciwkradziezowe.getKoszt(), dodaneZabezpieczeniePrzeciwkradziezowe.getKoszt(), 0);

    }


}
