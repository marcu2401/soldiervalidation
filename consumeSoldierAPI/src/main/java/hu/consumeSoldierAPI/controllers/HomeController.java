package hu.consumeSoldierAPI.controllers;

import hu.consumeSoldierAPI.domain.Soldier;
import hu.consumeSoldierAPI.services.SoldierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class HomeController {

    @Autowired
    private SoldierService service;

    @GetMapping("/")
    public String home(){
        return "index";
    }
    
    @GetMapping("/soldiers")
    public String getSoldiers(Model model){
        model.addAttribute("soldiers", service.getSoldiers());
        return "soldiers";
    }

    @GetMapping("/soldiers/{id}")
    public String getSoldier(@PathVariable("id") int id, Model model){
        model.addAttribute("soldier", service.getSoldier(id));
        return "soldier";
    }

    @GetMapping("/newsoldier")
    public String newSoldier(){
        return "newsoldier";
    }

    @PostMapping("/soldiers")
    public String addSoldier(@RequestParam("rank") String rank,
                             @RequestParam("birth") String birth,
                             @RequestParam("weapon") String weapon,
                             @RequestParam("shotpeople") int shotpeople,
                             Model model){
        int statusCode = service.addSoldier(rank, birth, weapon, shotpeople);
        model.addAttribute("statuscode", statusCode);
        model.addAttribute("soldiers", service.getSoldiers());
        return "soldiers";
    }
    @DeleteMapping("/soldiers")
    public String disarmSoldier(@RequestParam("id") int id, Model model){
        System.out.println("deletemapping()");
        service.disarmSoldier(id);
        model.addAttribute("soldiers", service.getSoldiers());
        return "soldiers";
    }

    @PatchMapping(value="/soldiers")
    public String updateSoldier(@RequestParam("id") int id,
                                @RequestParam("shotpeople") int shot,
                                Model model){
        int statusCode = service.updateSoldier(id, shot);
        model.addAttribute("statuscode", statusCode);
        model.addAttribute("soldiers", service.getSoldiers());
        return "soldiers";
    }

    @GetMapping("/soldiers/replace/{id}")
    public String replace(){
        return "replace";
    }

    @PutMapping("/soldiers")
    public String replaceSoldier(@RequestParam("id") int id,
                                 @RequestParam("rank") int rank,
                                 @RequestParam("birth") String birth,
                                 @RequestParam("weapon") String weapon,
                                 @RequestParam("shotpeople") int shotpeople,
                                 Model model){
        int statusCode = service.replaceSoldier(id, rank, birth, weapon, shotpeople);
        model.addAttribute("statuscode", statusCode);
        model.addAttribute("soldiers", service.getSoldiers());
        return "soldiers";
    }
}
