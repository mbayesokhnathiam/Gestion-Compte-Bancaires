package com.gainde.banque.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OP",discriminatorType=DiscriminatorType.STRING,length=1)
public abstract class Operation implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero ;
    private Date dateOp;
    private double montant;
    @ManyToOne
    @JoinColumn(name="CODE_CPT")
    private Compte compte;
    public Operation() {}
    public Operation(Long numero, Date dateOp, double montant, Compte compte) {
        super();
        this.numero = numero;
        this.dateOp = dateOp;
        this.montant = montant;
        this.compte = compte;
    }
    public Operation(Date dateOp, double montant, Compte compte) {
        super();
        this.dateOp = dateOp;
        this.montant = montant;
        this.compte = compte;
    }
//getters and setters
}
