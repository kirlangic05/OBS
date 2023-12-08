package com.obs.OBS.notlar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotService {

    @Autowired
    NotRepository repo;

    public List<Not> findAllNot(){
        return repo.findAll();
    }

    public Not findNotById(Long id){
        return repo.findById(id).get();
    }

    public Not saveNot(Not not){
        return repo.save(not);
    }

    public void deleteNotById(Long id){
        repo.deleteById(id);
    }

    public Not updateNot(Not requestNot){
        Not existingNot= repo.findById(requestNot.getId()).get();
        existingNot.setId(requestNot.getId());
        existingNot.setNot(requestNot.getNot());

        return repo.save(existingNot);
    }
}
