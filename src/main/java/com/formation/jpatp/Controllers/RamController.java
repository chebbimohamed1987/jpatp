package com.formation.jpatp.Controllers;

import com.formation.jpatp.Entities.Ram;
import com.formation.jpatp.Services.RamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class RamController {

private final RamService rs;
@Autowired
    public RamController(RamService rs) {
        this.rs = rs;
    }

    @GetMapping("/DisplayAllRAM1")
    public List<Ram> displayAll1() {
        return  rs.getAllRams();
    }


    @GetMapping("/DisplayAllRAM2")
    public ModelAndView displayAll2() {
        return new ModelAndView("pages/rams").addObject("liste", rs.getAllRams());
    }

    //getformulaire
    @RequestMapping(value = "/getformulaireRam", method = RequestMethod.GET)
    public ModelAndView getFormulaire() {
        return new ModelAndView("pages/RamForm").addObject("ram", new Ram());
    }

    //formulaire creation
    @RequestMapping(value="/ram",  method= RequestMethod.POST)
    public ModelAndView AddRam(@Validated Ram ram, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return  new ModelAndView("pages/ram");
        }
        rs.add(ram);
        return new ModelAndView("pages/rams").addObject("liste",rs.getAllRams());
    }
    //afichage brut
    @RequestMapping(value="/ram1/{id}", method= RequestMethod.GET)
    public Ram displayPC1( @PathVariable long id) {
        return  rs.findById(id);
    }

    //affichage
    @RequestMapping(value="/ram/{id}", method= RequestMethod.GET)
    public ModelAndView displayPC2(@PathVariable Long id) {
        return new ModelAndView("pages/ram").addObject("ram", rs.findById(id));
    }

    //mise a jour
    @RequestMapping(value="/ram/{id}", method= RequestMethod.PUT)
    public ModelAndView UpdateRam( Ram ram){
        rs.add(ram);
        return new ModelAndView("pages/rams").addObject("liste", rs.getAllRams());
    }


    //supression
    @RequestMapping(value="/ram/{id}",  method= RequestMethod.DELETE)
    public ModelAndView DeleteRam(@PathVariable Long id){

        rs.delete(id);
        return new ModelAndView("pages/rams").addObject("liste",rs.getAllRams());

    }

}
