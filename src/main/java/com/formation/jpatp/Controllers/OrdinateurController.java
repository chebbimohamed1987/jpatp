package com.formation.jpatp.Controllers;

import com.formation.jpatp.Entities.Ordinateur;
import com.formation.jpatp.Services.OrdinateurService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class OrdinateurController {
    private final OrdinateurService os;

    public OrdinateurController(OrdinateurService os) {
        this.os = os;
    }

    @GetMapping("/DisplayAllPC1")
    public List<Ordinateur> displayAll1() {
        return  os.getAllOrdinateurs();
    }


    @GetMapping("/DisplayAllPC2")
    public ModelAndView displayAll2() {
        return new ModelAndView("pages/ordinateurs").addObject("liste", os.getAllOrdinateurs());
    }

    //getformulaire
    @RequestMapping(value = "/getformulaire", method = RequestMethod.GET)
    public ModelAndView getFormulaire() {
        return new ModelAndView("pages/OrdinateurForm").addObject("ordinateur", new Ordinateur());
    }

   //formulaire creation
    @RequestMapping(value="/ordinateur",  method= RequestMethod.POST)
    public ModelAndView AddOrdinateur(@Validated  Ordinateur ordinateur, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return  new ModelAndView("pages/ordinateur");
        }
        os.add(ordinateur);
        return new ModelAndView("pages/ordinateurs").addObject("liste",os.getAllOrdinateurs());
    }
//afichage brut
    @RequestMapping(value="/ordinateur1/{id}", method= RequestMethod.GET)
    public Ordinateur displayPC1( @PathVariable long id) {
        return  os.findById(id);
    }

//affichage
    @RequestMapping(value="/ordinateur/{id}", method= RequestMethod.GET)
    public ModelAndView displayPC2(@PathVariable Long id) {
        return new ModelAndView("pages/ordinateur").addObject("ordinateur", os.findById(id));
    }

    //mise a jour
    @RequestMapping(value="/ordinateur/{id}", method= RequestMethod.PUT)
    public ModelAndView UpdateOrdinateur( Ordinateur ordinateur){
        os.add(ordinateur);
        return new ModelAndView("pages/ordinateurs").addObject("liste", os.getAllOrdinateurs());
    }


//supression
    @RequestMapping(value="/ordinateur/{id}",  method= RequestMethod.DELETE)
    public ModelAndView DeleteOrdinateur(@PathVariable Long id){

        os.delete(id);
        return new ModelAndView("pages/ordinateurs").addObject("liste",os.getAllOrdinateurs());

    }
}
