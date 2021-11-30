package hu.soldierValidation.controllers;

import hu.soldierValidation.domain.Soldier;
import hu.soldierValidation.services.SoldierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/soldiers")  // root path
public class SoldierController {

    private SoldierService service;

    @Autowired
    public void setService(SoldierService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Soldier> getSoldiers(){
        return service.getSoldiers();
    }

    @GetMapping("/{id}")
    public Soldier getSoldier(@PathVariable("id") int id){
        return service.getSoldier(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Soldier addSoldier(@Valid @RequestBody Soldier soldier){
        return service.addSoldier(soldier);
    }

    @PatchMapping("/{id}/{shotpeople}")
    public Soldier updateSoldier(@Valid @PathVariable("id") int id, @PathVariable("shotpeople") int shot){
        return service.updateSoldier(id, shot);
    }

    @PutMapping("/{id}")
    public Soldier replaceSoldier(@Valid @PathVariable("id") int id, @RequestBody Soldier soldier){
        return service.replaceSoldier(id, soldier);
    }

    @DeleteMapping("/{id}")
    public void deleteSoldier(@PathVariable("id") int id){
        service.deleteSoldier(id);
    }

}
