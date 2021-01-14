package com.gainde.banque.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING,length=2)
public abstract class Compte implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code ;
    private double solde;
    private Date dateCreation;
    @ManyToOne
    @JoinColumn(name="CODE_CLIENT")
    private Client client ;
    @OneToMany(mappedBy="compte",fetch=FetchType.LAZY)
    private List<Operation> operations;
    public Compte() {}
    public Compte(Long code, double solde, Date dateCreation, Client client) {
        this.code = code;
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.client = client;
    }
    public Compte(double solde, Date dateCreation, Client client) {
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.client = client;
    }
    // getters/setters
}
