package com.obs.OBS.ogretmen;

import com.obs.OBS.ogrenci.OgrenciController;
import com.obs.OBS.ogrenci.OgrenciRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obs/ogretmen")
public class OgretmenController {

    @Autowired
    OgretmenService service;

    private static final Logger logger = LoggerFactory.getLogger(OgrenciController.class);

    @GetMapping
    public List<Ogretmen> findAllOgretmen() {
        try {
            logger.info("Ogretmen GET işlemi gerçekleşti.");
            return service.findAllOgretmen();
        } catch (Exception e) {
            logger.error("Ogretmen GET işlemi hatalı.", e);
            return null;
        }
    }

    @GetMapping("/{id}")
    public Ogretmen findOgretmenById(@PathVariable Long id) {
        try {
            logger.info("Id ile ogretmen getirme işlemi gerçekleşti.");
            return service.findOgretmenById(id);
        } catch (Exception e) {
            logger.error("Id ile ogretmen getirme işlemi hatalı. Id'yi kontrol edin", e);
            return null;
        }
    }

    @PostMapping
    public Ogretmen saveOgretmen(@RequestBody Ogretmen ogretmen) {
        try {
            logger.info("Ogretmen kaydetme işlemi başarılı.");
            return service.saveOgretmen(ogretmen);
        } catch (Exception e) {
            logger.error("Ogretmen kaydetme işlemi hatalı.", e);
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteOgretmenById(@PathVariable Long id) {
        try {
            logger.info("Ogretmen silme işlemi başarılı.");
            service.deleteOgretmen(id);
            return id + " delete işlemi yapıldı";
        } catch (Exception e) {
            logger.error("Ogretmen silme işlemi Hatalı.", e);
            return id + " delete işlemi HATALI!";
        }
    }

    @PutMapping("/{id}")
    public Ogretmen updateOgretmen(@RequestBody Ogretmen ogretmen) {
        try {
            logger.info("Ogretmen update işlemi gerçekleşti.");
            return service.updateOgretmen(ogretmen);
        } catch (Exception e) {
            logger.error("Ogretmen update işlemi hatalı.", e);
            return null;
        }
    }
}


