package com.tecleo.hrworker.controller;

import com.tecleo.hrworker.entities.Worker;
import com.tecleo.hrworker.repositories.WorkerRepositories;
import com.tecleo.hrworker.services.WorkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    @Autowired private WorkerServices wkServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Worker>> findAll() {
        return ResponseEntity.ok().body(wkServices.findAll());
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Worker> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(wkServices.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Worker obj) {
        wkServices.insert(obj);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Worker obj) {
        Worker wk = obj;
        wk.setId(id);
        wkServices.update(wk);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        wkServices.delete(id);
        return ResponseEntity.ok().build();
    }
}
