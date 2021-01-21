package com.gainde.banque.service;

import com.gainde.banque.models.Client;
import com.gainde.banque.models.Compte;
import org.springframework.data.domain.Page;
public interface IClientMetier {
    public Client consulterClient(Long codeClt);
    public void supprimerClient(Long codeClt);
    public Client ajouter(Client c);
    public Page<Compte> listComptes(Long codeClt, int page, int size);
}
