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
            logger.info("\nOgretmen GET işlemi gerçekleşti.");
            return service.findAllOgretmen();
        } catch (Exception e) {
            logger.error("\nOgretmen GET işlemi hatalı.", e);
            return null;
        }
    }

    @GetMapping("/{id}")
    public Ogretmen findOgretmenById(@PathVariable Long id) {
        try {
            logger.info("\n" + id + "ID'li ogretmen getirme işlemi gerçekleşti.");
            return service.findOgretmenById(id);
        } catch (Exception e) {
            logger.error("\n" + id + "Id ile ogretmen getirme işlemi hatalı. Id'yi kontrol edin", e);
            return null;
        }
    }

    @PostMapping
    public Ogretmen saveOgretmen(@RequestBody Ogretmen ogretmen) {
        try {
            logger.info("\nOgretmen kaydetme işlemi başarılı.");
            return service.saveOgretmen(ogretmen);
        } catch (Exception e) {
            logger.error("\nOgretmen kaydetme işlemi hatalı.", e);
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteOgretmenById(@PathVariable Long id) {
        try {
            logger.info("\n" + id + "ID'li Ogretmen silme işlemi başarılı.");
            service.deleteOgretmen(id);
            return id + " delete işlemi yapıldı";
        } catch (Exception e) {
            logger.error("\n" + id + "ID'li Ogretmen silme işlemi Hatalı.", e);
            return id + " delete işlemi HATALI!";
        }
    }

    @PutMapping("/{id}")
    public Ogretmen updateOgretmen(@RequestBody Ogretmen ogretmen) {
        try {
            logger.info("\n" + ogretmen + "\nOgretmen update işlemi gerçekleşti.");
            return service.updateOgretmen(ogretmen);
        } catch (Exception e) {
            logger.error("\n" + ogretmen + "\nOgretmen update işlemi hatalı.", e);
            return null;
        }
    }
}


