package com.formation.jpatp.Entities;


import javax.persistence.*;

@Entity
@Table(name = "ram")
public class Ram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="marque", length = 100)
    private String marque;

    @ManyToOne
    @JoinColumn(name="ordinateur")
    private Ordinateur ordinateur;



    public Ram() {

    }



    public Ram(String marque) {
        this.marque = marque;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setOrdinateur(Ordinateur ordinateur) {
        this.ordinateur = ordinateur;
    }

    public long getId() {
        return id;
    }

    public String getMarque() {
        return marque;
    }

    public Ordinateur getOrdinateur() {
        return ordinateur;
    }
}
