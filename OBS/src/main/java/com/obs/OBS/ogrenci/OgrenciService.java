package com.obs.OBS.ogrenci;

import com.obs.OBS.ders.DersRepository;
import com.obs.OBS.ders.Dersler;
import com.obs.OBS.notlar.Not;
import com.obs.OBS.notlar.NotRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OgrenciService {

    @Autowired
    OgrenciRepository repo;
    @Autowired
    NotRepository notRepository;
    @Autowired
    DersRepository dersRepository;

    private static final Logger logger = LoggerFactory.getLogger(OgrenciService.class);

    public List<Ogrenci> findAllOgrenci(){
        return repo.findAll();
    }

    public Ogrenci findOgrenciById(Long id){
        return repo.findById(id).get();
    }

    public Ogrenci saveOgrenci(Ogrenci ogrenci){
        return repo.save(ogrenci);
    }

    public void deleteOgrenciById(Long id){
        repo.deleteById(id);
    }

    public Ogrenci updateOgrenci(Ogrenci requestOgrenci){
        Ogrenci existOgrenci= repo.findById(requestOgrenci.getId()).get();
        existOgrenci.setId(requestOgrenci.getId());
        existOgrenci.setDers(requestOgrenci.getDers());
        existOgrenci.setIsim(requestOgrenci.getIsim());

        return repo.save(existOgrenci);
    }

    // Ogrenci silerek kayıt silme denemesi.
    @Transactional
    public void ogrenciSil(Long id) {
        Ogrenci ogrenci = repo.findById(id).orElse(null);
        if (ogrenci != null) {
            logger.info("ogrenci!= null kısmı ");
            // Ogrenci'ye ait ders, not ve ogretmen kayitlarini sil
            List<Dersler> dersList = ogrenci.getDers();
            if (dersList != null) {
                logger.info("derslist != kısmı");
                for (Dersler ders : dersList) {
                    logger.info("for döngüsü başladı");
                    // Ders'e ait not kaydını sil
                    Not notlar = ders.getNotlar();
                    if (notlar != null) {
                        logger.info("notlar=! kısmı");
                        ders.setNotlar(null);
                        // Notları sil
                        notRepository.delete(notlar);
                        logger.info("not silindi");
                    }
                    // Dersi sil
                    dersRepository.delete(ders);
                    logger.info("ders silindi");
                }
            }
            // Ogrenciyi sil
            repo.delete(ogrenci);
            logger.info("ogrenci silindi");
        }
    }
}
