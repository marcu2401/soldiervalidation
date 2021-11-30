package hu.soldierValidation.services;

import hu.soldierValidation.domain.Soldier;
import hu.soldierValidation.repositories.SoldierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SoldierService {

    private SoldierRepository repository;

    @Autowired
    public void setRepository(SoldierRepository repository) {
        this.repository = repository;
    }

    public List<Soldier> getSoldiers() {
        return repository.findAll();
    }

    public Soldier getSoldier(int id) {
        Optional<Soldier> optionalSoldier = repository.findById(id);
        if(optionalSoldier.isPresent()){
            return optionalSoldier.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Soldier addSoldier(Soldier soldier) {
        return repository.save(soldier);
    }

    public Soldier updateSoldier(int id, int shot) {
        Optional<Soldier> optionalSoldier = repository.findById(id);
        if(optionalSoldier.isPresent()){
            Soldier soldier = optionalSoldier.get();
            soldier.setShotpeople(shot);
            return repository.save(soldier);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public Soldier replaceSoldier(int id, Soldier soldier) {
        Optional<Soldier> optionalSoldier = repository.findById(id);
        if(optionalSoldier.isPresent()){
            soldier.setId(id);
            return repository.save(soldier);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void deleteSoldier(int id) {
        Optional<Soldier> optionalSoldier = repository.findById(id);
        if(optionalSoldier.isPresent()){
            repository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
