package com.formation.jpatp.Entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordinateur")
public class Ordinateur {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "marque", length = 100)
    private String marque;

    @OneToMany(mappedBy = "ordinateur")

    private List<Ram> rams  ;

    public Ordinateur() {
this.rams= new ArrayList<>();
    }

    public Ordinateur(String marque) {
        this.marque = marque;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public List getRams() {
        return rams;
    }

    public void setRams(List rams) {
        this.rams = rams;
    }
}
