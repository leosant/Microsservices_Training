package com.tecleo.hrworker.services;

import com.tecleo.hrworker.entities.Worker;
import com.tecleo.hrworker.repositories.WorkerRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerServices {

    @Autowired private WorkerRepositories wkRepositories;

    public List<Worker> findAll() {
        List<Worker> list = wkRepositories.findAll();
        return list;
    }

    public Worker findById(String id) {
        Optional<Worker> wk = wkRepositories.findById(id);
        if(wk.isPresent()) {
            Worker worker = wk.get();
            return worker;
        }
        return null;
    }

    public Worker insert(Worker obj) {
            Worker wk = null;
        try {
            wk = wkRepositories.insert(obj);
            if(!(wk == null)) {
                wkRepositories.save(wk);
            }
            return wk;
        }catch(Exception e) {
            System.out.println(e.getStackTrace());
        }
        return wk;
    }

    public Worker update(Worker obj) {
        Worker wk = this.findById(obj.getId());
        updateData(wk, obj);
        return wkRepositories.save(wk);
    }

    private void updateData(Worker newWk, Worker wk) {
        newWk.setName(wk.getName());
        newWk.setDailyIncome(wk.getDailyIncome());
    }

    public void delete(String id) {
        findById(id);
        wkRepositories.deleteById(id);
    }
}
