package com.gainde.banque.repository;


import com.gainde.banque.models.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface OperationRepository extends JpaRepository<Operation, Long> {
    @Query("select o from Operation o where o.compte.code like :x order by o.dateOp desc")
            public Page<Operation> listOperation(@Param("x")String codeCte, Pageable page);
}