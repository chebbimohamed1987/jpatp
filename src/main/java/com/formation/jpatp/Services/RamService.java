package com.formation.jpatp.Services;



import com.formation.jpatp.Entities.Ram;
import com.formation.jpatp.Repositories.RamRepository;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class RamService {
    private final RamRepository rr;

    public RamService(RamRepository rr) {
        this.rr = rr;
    }


    public void add(Ram ram){
        rr.save(ram);

    }

    public void delete(long id){
        rr.deleteById(id);
    }
    public Ram findById(long id){
        return rr.findById(id).get();

    }
    public List<Ram> getAllRams() {

        return rr.findAll();
    }
}


