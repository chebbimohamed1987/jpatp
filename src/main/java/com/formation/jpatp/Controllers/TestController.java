package com.formation.jpatp.Controllers;

import com.formation.jpatp.Entities.Ordinateur;
import com.formation.jpatp.Entities.Ram;
import com.formation.jpatp.Services.OrdinateurService;
import com.formation.jpatp.Services.RamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private   OrdinateurService os;
    @Autowired
    private  RamService rs;


    @RequestMapping("/TestAdd")
public void test(){
    Ordinateur ordi1 = new Ordinateur("hp");
    Ordinateur ordi2 = new Ordinateur("dell");

    Ram ram1 = new Ram("kingston");
    Ram ram2 = new Ram("samsung");
    Ram ram3 = new Ram("dell");
    Ram ram4 = new Ram("kingstom");

/*    ordi1.getRams().add(ram1);
    ordi1.getRams().add(ram2);
    ordi1.getRams().add(ram3);
    ordi2.getRams().add(ram4);*/
    ram1.setOrdinateur(ordi1);
    ram2.setOrdinateur(ordi2);
    ram3.setOrdinateur(ordi1);
    ram4.setOrdinateur(ordi1);
        os.add(ordi1);
        os.add(ordi2);
        rs.add(ram1);
        rs.add(ram2);
        rs.add(ram3);
        rs.add(ram4);






}




}
