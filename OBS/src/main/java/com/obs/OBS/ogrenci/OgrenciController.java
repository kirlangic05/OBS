package com.obs.OBS.ogrenci;

import com.obs.OBS.notlar.NotController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obs/ogrenci")
public class OgrenciController {

    @Autowired
    OgrenciService service;
    private static final Logger logger = LoggerFactory.getLogger(OgrenciController.class);

    @GetMapping
    public List<Ogrenci> findAllOgrenci() {
        try {
            logger.info("Ogrenci verileri getirildi.");
            return service.findAllOgrenci();
        } catch (Exception e) {
            logger.error("Ogrenci getirme işlemi hatalı.", e);
            return null;
        }
    }

    @GetMapping("/{id}")
    public Ogrenci findOgrenciById(@PathVariable Long id) {
        try {
            logger.info("Id ile ogrenci getirme işlemi gerçekleşti.");
            return service.findOgrenciById(id);
        } catch (Exception e) {
            logger.error("Ogrenci getirme işlemi hatalı. Id'yi kontrol edin.", e);
            return null;
        }
    }

    @PostMapping
    public Ogrenci saveOgrenci(@RequestBody Ogrenci ogrenci) {
        try {
            logger.info("Ogrenci ekleme işlemi gerçekleşti.");
            return service.saveOgrenci(ogrenci);
        } catch (Exception e) {
            logger.error("Ogrenci ekleme işlemi Hatalı.", e);
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteOgrenci(@PathVariable Long id) {
        try {
            service.deleteOgrenciById(id);
            return id + " Öğrenci silme işlemi başarılı...";
        } catch (Exception e) {
            logger.error("Ogrenci silme işlemi hatalı.", e);
            return id + " ogrenci silme işlemi HATALI";
        }
    }

    @PutMapping("{id}")
    public Ogrenci updateOgrenci(@RequestBody Ogrenci ogrenci) {
        try {
            logger.info("Ogrenci update işlemi gerçekleşti.");
            return service.updateOgrenci(ogrenci);
        } catch (Exception e) {
            logger.error("Ogrenci update işlemi hatalı.", e);
            return null;
        }
    }
}
