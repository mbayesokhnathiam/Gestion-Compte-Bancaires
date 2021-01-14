package com.gainde.banque.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable {
    @Id @GeneratedValue
    private Long code ;
    private String nom;
    @OneToMany(mappedBy="client",fetch=FetchType.LAZY)
    private Collection<Compte> comptes;
    public Client(String nom) {
        super();
        this.nom = nom;
    }
    public Client(String nom, Collection<Compte> comptes) {
        super();
        this.nom = nom;
        this.comptes = comptes;
    }
    public Client() {
        super();
// TODO Auto-generated constructor stub
    }
// getters/setters
}
