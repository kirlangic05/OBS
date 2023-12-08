package com.obs.OBS.ogretmen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OgretmenService {
    @Autowired
    OgretmenRepository repo;

    public List<Ogretmen> findAllOgretmen(){
        return repo.findAll();
    }

    public Ogretmen findOgretmenById(Long id){
        return repo.findById(id).get();
    }

    public Ogretmen saveOgretmen(Ogretmen ogretmen){
        return repo.save(ogretmen);
    }

    public void deleteOgretmen(Long id){
        repo.deleteById(id);
    }

    public Ogretmen updateOgretmen(Ogretmen requestOgretmen){
        Ogretmen existingOgretmen= repo.findById(requestOgretmen.getId()).get();
        existingOgretmen.setId(requestOgretmen.getId());
       // existingOgretmen.setDers(requestOgretmen.getDers());
        existingOgretmen.setIsim(requestOgretmen.getIsim());

        return repo.save(existingOgretmen);
    }
}
