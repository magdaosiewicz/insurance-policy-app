package com.muka.modul_ubezpieczen.service;

import com.muka.modul_ubezpieczen.domain.Ubezpieczenie.UbezpieczenieRuchomosciDomowych;
import com.muka.modul_ubezpieczen.repository.UbezpieczenieRuchomosciDomowychRepository;
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
public class UbezpieczenieRuchomosciDomowychServiceTest {

    @InjectMocks
    UbezpieczenieRuchomosciDomowychService ubezpieczenieRuchomosciDomowychService;

    @Mock
    UbezpieczenieRuchomosciDomowychRepository ubezpieczenieRuchomosciDomowychRepository;

    @Test
    public void shouldReturnUbezpieczenieRuchomoscidomowych() {

        UbezpieczenieRuchomosciDomowych ubezpieczenieRuchomosciDomowych = UbezpieczenieRuchomosciDomowych.builder()
            .koszt(200)
            .build();

        when(ubezpieczenieRuchomosciDomowychRepository.save(ubezpieczenieRuchomosciDomowych)).thenReturn(ubezpieczenieRuchomosciDomowych);
        UbezpieczenieRuchomosciDomowych dodaneUbezpieczenieRuchomosciDomowych = ubezpieczenieRuchomosciDomowychService.dodajUbezpieczenieRuchomosciDomowych(ubezpieczenieRuchomosciDomowych);

        assertEquals(ubezpieczenieRuchomosciDomowych.getKoszt(), dodaneUbezpieczenieRuchomosciDomowych.getKoszt(), 0);

    }

    @Test
    public void shouldRetunUpdateUbezpieczenieRuchomosciDomowych() {
        UbezpieczenieRuchomosciDomowych ubezpieczenieRuchomosciDomowych = UbezpieczenieRuchomosciDomowych.builder()
            .koszt(200)
            .build();

        when(ubezpieczenieRuchomosciDomowychRepository.save(ubezpieczenieRuchomosciDomowych)).thenReturn(ubezpieczenieRuchomosciDomowych);
        UbezpieczenieRuchomosciDomowych dodaneUbezpieczenieRuchomosciDomowych = ubezpieczenieRuchomosciDomowychService.modyfikujUbezpieczenieRuchomosciDomowych(ubezpieczenieRuchomosciDomowych);

        assertEquals(ubezpieczenieRuchomosciDomowych.getKoszt(), dodaneUbezpieczenieRuchomosciDomowych.getKoszt(), 0);

    }


}

