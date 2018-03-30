package com.formation.jpatp.Repositories;


import com.formation.jpatp.Entities.Ordinateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdinateurRepository extends JpaRepository<Ordinateur, Long> {

}
