package com.formation.jpatp.Services;


import com.formation.jpatp.Entities.Ordinateur;
import com.formation.jpatp.Repositories.OrdinateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdinateurService {

    private final OrdinateurRepository or;
    @Autowired
    public OrdinateurService(OrdinateurRepository or) {
        this.or=or;
    }

    public void add (Ordinateur ordi){
        or.save(ordi);
    }

    public void delete(long id){
        or.deleteById(id);
    }
    public Ordinateur findById(long id){
        return or.findById(id).get();

    }


    public List<Ordinateur> getAllOrdinateurs() {

        return or.findAll();
    }
}
