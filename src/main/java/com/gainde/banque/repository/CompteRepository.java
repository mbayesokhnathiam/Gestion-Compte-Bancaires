package com.gainde.banque.repository;

import com.gainde.banque.models.Compte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompteRepository extends JpaRepository<Compte, String> {
    @Query("select c from Compte c where c.client.code=:x")
    List<Compte> listComptes(@Param("x")Long codeCte);


}
