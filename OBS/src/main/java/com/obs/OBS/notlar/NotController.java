package com.obs.OBS.notlar;

import com.obs.OBS.ders.DersController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obs/not")
public class NotController {
    @Autowired
    NotService service;

    private static final Logger logger = LoggerFactory.getLogger(NotController.class);

    @GetMapping
    public List<Not> findAllNot() {
        logger.info("Notların Get işlemi gerçekleşti.");
        return service.findAllNot();
    }

    @GetMapping("/{id}")
    public Not findNotById(@PathVariable Long id) {
        try {
            logger.info("Id ile Not getirme işlemi gerçekleşti.");
            return service.findNotById(id);
        } catch (Exception e) {
            logger.error("Not GET etme işlemi hatalı. Id'yi kontrol edin", e);
            return null;
        }

    }

    @PostMapping
    public Not saveNot(@RequestBody Not not) {
        try {
            logger.info("\nNot ekleme işlemi gerçekleşti.");
            return service.saveNot(not);
        } catch (Exception e) {
            logger.error("\nNot ekleme işleminde bir hata var.", e);
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteNot(@PathVariable Long id) {
        try {
            logger.info(" Not silme işlemi gerçekleşti.");
            service.deleteNotById(id);
            return id + " Not silindi..";
        } catch (Exception e) {
            logger.error("Not silme işlemi başarısız.", e);
            return id + " Id'li Not SİLİNMEDİ.";
        }
    }

    @PutMapping("/{id}")
    public Not updateNot(@RequestBody Not not) {
        try {
            logger.info("\n" + not + "\nNot update işlemi gerçekleşti.");
            return service.updateNot(not);
        } catch (Exception e) {
            logger.error("\n" + not + "\nNot update işlemi hatalı.", e);
            return null;
        }

    }
}
