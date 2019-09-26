package com.muka.modul_ubezpieczen.repository;

import com.muka.modul_ubezpieczen.domain.Faktura.FakturaMieszkaniowa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Magda on 28.12.2017.
 */
@Repository
public interface FakturaMieszkaniowaRepository extends JpaRepository<FakturaMieszkaniowa, Long> {

}
