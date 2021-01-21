package com.gainde.banque.service;


import com.gainde.banque.models.Compte;
import com.gainde.banque.models.Operation;
import org.springframework.data.domain.Page;

public interface IBanqueMetier {
    public Compte consulterCompte(String codeCte);
    public void verser(String codeCte,double montant);
    public void retirer(String codeCte,double montant);
    public void virement(String codeCte1,String codeCte2,double montant);
    public Page<Operation> listOperation(String codeCte, int page, int size);
}
