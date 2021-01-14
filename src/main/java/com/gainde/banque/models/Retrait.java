package com.gainde.banque.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation {
    public Retrait() {
        super();
    }
    public Retrait(Date dateOp, double montant, Compte compte) {
        super(dateOp, montant, compte);
    }
    public Retrait(Long numero, Date dateOp, double montant, Compte compte) {
        super(numero, dateOp, montant, compte);
    }
}
