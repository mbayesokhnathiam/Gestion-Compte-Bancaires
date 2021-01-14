package com.gainde.banque.repository;


import com.gainde.banque.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClientRepository extends JpaRepository<Client, Long> {
}