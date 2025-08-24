package com.example.Paulo_Dias_DSSB_TP2.facade;

import com.example.Paulo_Dias_DSSB_TP2.models.Wines;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskFacade {
    private static final Map<Long, Wines> repo = new HashMap<>();

    private Long setId (Wines wine){
        Long nextId = repo.keySet().size() +1L;
        wine.setId(nextId);
        return nextId;
    }

    public Wines create(Wines wine){
        Long id = setId(wine);
        repo.put(id, wine);
        return wine;
    }

    public Wines update(Wines wine, Long id){
        if (repo.containsKey(id)){
            wine.setId(id);
            repo.replace(id, wine);
            return wine;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wine not found");
        }
    }

    public Wines getById(Long id){
        if (repo.containsKey(id)){
            return repo.get(id);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wine not found");
        }
    }

    public List<Wines> getAll(){
        return new ArrayList<>(repo.values());
    }

    public void delete(Long id){
        if (repo.containsKey(id)){
            repo.remove(id);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wine not found");
        }
    }
}
