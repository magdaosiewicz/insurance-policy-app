package com.muka.modul_ubezpieczen.repository;

import com.muka.modul_ubezpieczen.domain.Klient.Klient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Magda on 17.12.2017.
 */
@Repository
public interface KlientRepository extends JpaRepository<Klient, Long> {
}
