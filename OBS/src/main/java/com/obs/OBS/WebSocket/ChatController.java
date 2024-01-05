package com.obs.OBS.WebSocket;

import com.obs.OBS.ogrenci.Ogrenci;
import com.obs.OBS.ogrenci.OgrenciRepository;
import com.obs.OBS.ogretmen.Ogretmen;
import com.obs.OBS.ogretmen.OgretmenRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.Optional;


@Controller
public class ChatController {

private static final Logger logger= LoggerFactory.getLogger(ChatController.class);
    @MessageMapping("obs/ogrenci/chat")
    @SendToUser("/obs/ogretmen/mesaj")
    public ChatMessage OgrenciSendMessage(ChatMessage message) {

        logger.info("ogrenciden ogretmene");
       return message;

    }

    @MessageMapping("obs/ogretmen/chat")
    @SendToUser("/obs/ogrenci/mesaj")
    public ChatMessage OgretmenSendMessage(ChatMessage message) {
        logger.info("ogretmenden ogrenciye");
        return message;
    }








//@Autowired
//private OgrenciRepository ogrenciRepository;
//
//    @Autowired
//    private OgretmenRepository ogretmenRepository;
//
//    @MessageMapping("/obs/ogrenci/chat")
//    @SendTo("/obs/ogretmen/mesaj")
//    public ChatMessage OgrenciSendMessage(ChatMessage message) {
//        // Öğrenci id'sine göre öğrenciyi bul
//        Optional<Ogrenci> ogrenciOptional = ogrenciRepository.findById(message.getSenderId());
//        ogrenciOptional.ifPresent(ogrenci -> {
//            // Öğretmenin id'sine gönderilecek mesajı hazırla
//            ChatMessage ogretmenMessage = new ChatMessage();
//            ogretmenMessage.setContent(message.getContent());
//            ogretmenMessage.setSenderId(message.getSenderId());
//            ogretmenMessage.setReceiverId(ogrenci.getDers().getOgretmen.getId());
//
//            // Mesajı ilgili öğretmene gönder
//            messagingTemplate.convertAndSend("/obs/ogretmen/mesaj", ogretmenMessage);
//        });
//
//        return message;
//    }
//
//    @MessageMapping("/obs/ogretmen/chat")
//    @SendTo("/obs/ogrenci/mesaj")
//    public ChatMessage OgretmenSendMessage(ChatMessage message) {
//        // Öğretmen id'sine göre öğretmeni bul
//        Optional<Ogretmen> ogretmenOptional = ogretmenRepository.findById(message.getSenderId());
//        ogretmenOptional.ifPresent(ogretmen -> {
//            // Öğrencinin id'sine gönderilecek mesajı hazırla
//            ChatMessage ogrenciMessage = new ChatMessage();
//            ogrenciMessage.setContent(message.getContent());
//            ogrenciMessage.setSenderId(message.getSenderId());
//            ogrenciMessage.setReceiverId(ogretmen.getDers().getOgrenci().getId());
//
//            // Mesajı ilgili öğrenciye gönder
//            messagingTemplate.convertAndSend("/obs/ogrenci/mesaj", ogrenciMessage);
//        });
//
//        return message;
//    }
}
