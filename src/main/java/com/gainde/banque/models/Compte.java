package com.gainde.banque.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * @Inheritance gére l'héritage (définition de la classe mere)
 * strategy=InheritanceType.SINGLE_TABLE classes filles seront gérées dans une table mais avec un slug qui les diffèrent
 * strategy=InheritanceType.TABLE_PER_CLASS Chaque classes fille aura sq table
 * @Inheritance(strategy=InheritanceType.JOINED) avoir une table de jointure
 * @DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING,length=2) denition des proprietes du slug
 * @ManyToOne -> Terminaison de One (Un objet à créer)
 * @OneToMany -> Terminaison de Many (Une liste à créer)
 *  @JoinColumn(name="CODE_CLIENT") définition de la clé etrangère
 * */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING,length=2)
@Data
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
