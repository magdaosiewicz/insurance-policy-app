package com.muka.modul_ubezpieczen.repository;

import com.muka.modul_ubezpieczen.domain.Ubezpieczenie.ZabezpieczeniePrzeciwkradziezowe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Magda on 28.12.2017.
 */
@Repository
public interface ZabezpieczeniePrzeciwkradziezoweRepository extends JpaRepository<ZabezpieczeniePrzeciwkradziezowe, Long> {
    ZabezpieczeniePrzeciwkradziezowe findByPolisaMieszkaniowaIdPolisaMieszkaniowa(Long polisaMieszkaniowaId);


}
