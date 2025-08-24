package com.example.Paulo_Dias_DSSB_TP2.API;

import com.example.Paulo_Dias_DSSB_TP2.facade.TaskFacade;
import com.example.Paulo_Dias_DSSB_TP2.models.Wines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "wines", produces = MediaType.APPLICATION_JSON_VALUE)
public class WineController {

    @Autowired
    private TaskFacade taskFacade;

    @PostMapping
    @ResponseBody
    public ResponseEntity<Wines> create(@RequestBody Wines wine){
        Wines created = taskFacade.create(wine);
        return ResponseEntity
                .created(URI.create("/wines/" + created.getId()))
                .body(created);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Wines> update(@PathVariable("id") Long id, @RequestBody Wines wine){
        Wines updated = taskFacade.update(wine, id);
        return ResponseEntity
                .ok(updated);
    }

    @GetMapping
    public ResponseEntity<List<Wines>> getAll(){
        List<Wines> all = taskFacade.getAll();
        return ResponseEntity
                .ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wines> getById(@PathVariable Long id){
        Wines wine = taskFacade.getById(id);

        if(wine == null){
            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity
                .ok(wine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        taskFacade.delete(id);
        return ResponseEntity.noContent().build();

    }
}
