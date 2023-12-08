package com.obs.OBS.ders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obs/ders")
public class DersController {
    @Autowired
    DersService service;

    private static final Logger logger = LoggerFactory.getLogger(DersController.class);

    @GetMapping
    public List<Dersler> findAllDers() {
        logger.info("Tüm Derslerin GET işlemi gerçekleşti.");
        return service.findAllDers();
    }

    @GetMapping("/{id}")
    public Dersler findDersById(@PathVariable Long id) {
        try {
            logger.info("Id ile Ders GET işlemi gerçekleşti.");
            return service.findDersById(id);
        } catch (Exception e) {
            logger.error("GET işlemi başarısız oldu. Id'yi kontrol edin. ", e);
            return null;
        }
    }

    @PostMapping
    public Dersler saveDers(@RequestBody Dersler dersler) {
        try {
            logger.info("Ders ekleme işlemi gerçekleşti");
            return service.saveDers(dersler);
        } catch (Exception e) {
            logger.error("Ders ekleme işlemi başarısız oldu.", e);
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteDers(@PathVariable Long id) {
        try {
            service.deleteDersById(id);
            logger.info("Ders silme işlemi gerçekleşti");
            return id + " Ders Silme işlemi başarılı..";
        } catch (Exception e) {
            logger.error("Ders Silme işlemi hatalı. Id kontrolü yapın.", e);
            return id + " Ders Silme işlemi hatalı.";
        }


    }

    @PutMapping("/{id}")
    public Dersler updateDers(@RequestBody Dersler dersler) {
        try {
            logger.info("Ders Update işlemi gerçekleşti");
            return service.updateDers(dersler);
        } catch (Exception e) {
            logger.error("Update işlemi hatalı.", e);
            return null;
        }
    }
}
