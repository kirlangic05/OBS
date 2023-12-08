package com.obs.OBS.ders;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DersService {

    @Autowired
    DersRepository repo;

    public List<Dersler> findAllDers(){
        return repo.findAll();
    }

    public Dersler findDersById(Long id){
        return repo.findById(id).get();
    }

    public Dersler saveDers(Dersler dersler){
        return repo.save(dersler);
    }

    public void deleteDersById(Long id){
        repo.deleteById(id);
    }



    public Dersler updateDers(Dersler requestDers){
        Dersler existingDers = repo.findById(requestDers.getId()).get();
        existingDers.setId(requestDers.getId());
        existingDers.setDersAdi(requestDers.getDersAdi());
        existingDers.setOgrenci(requestDers.getOgrenci());
        existingDers.setOgretmen(requestDers.getOgretmen());
        return repo.save(existingDers);

    }


}
