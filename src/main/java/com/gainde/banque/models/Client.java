package com.gainde.banque.models;

import lombok.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;

/**
 * @Entity permet à l'ORM Hibernate de s'avoir que cette classe doit etre mapper à une table(la tqble est crée par hibernqte)
 * @Id c'est pour définir la clé primaire
 * @GeneratedValues permet de gérer la génération de la clé primaire https://thorben-janssen.com/jpa-generate-primary-keys/
 * @Table nommer la table
 * @Column (Nommer la colonne et ajouter les des parametres
 * @Getter seulement les getters
 * @Setter seulement les setteurs
 * @Data getters et setter
 *  @AllArgsConstructor constructeur avec arguments
 *  @NoArgsConstructor constructeur sans arguments
 * La sérialisation est le processus de conversion d'un objet en un flux d'octets pour stocker l'objet ou le transmettre à la mémoire, à une base de données ou à un fichier. Son objectif principal est de sauvegarder l'état d'un objet afin de pouvoir le recréer en cas de besoin. Le processus inverse est appelé désérialisation.
 * @OneToMany Relqtion 1 à plusieurs
 * @ManyToOne plusieurs à 1
 * @ManyToMany Plusieur à Plusieurs
 * @OneToOne 1 à 1
 * fetch=FetchType.LAZY
 */

@Entity
@Table(name = "customer")
@AllArgsConstructor
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long code ;

    @Column(name = "toureum", length = 50,nullable = true)
    private String nom;
    @OneToMany(mappedBy="client",fetch=FetchType.LAZY)
    private List<Compte> comptes;
    public Client(String nom) {
        this.nom = nom;
    }
    public Client(String nom, List<Compte> comptes) {

        this.nom = nom;
        this.comptes = comptes;
    }
    public Client() {

// TODO Auto-generated constructor stub
    }
// getters/setters
}
