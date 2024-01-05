package com.obs.OBS.MailSender;

import com.obs.OBS.ders.DersController;
import com.obs.OBS.ders.DersService;
import com.obs.OBS.ders.Dersler;
import com.obs.OBS.ogrenci.Ogrenci;
import com.obs.OBS.ogrenci.OgrenciService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.File;
import java.util.Objects;

@Service
public class EmailService {
    @Autowired
    OgrenciService ogrenciService;
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public void sendEmail(@RequestBody Dersler dersler, Ogrenci ogrenci) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true); // true kısmı çok parçalı bir mail oldugu anlamına gelir


        if (ogrenci == null) {
            throw new RuntimeException("Öğrenci bulunamadı");
        }
        String email = ogrenci.getEmail();

        mimeMessageHelper.setFrom("SENDER");
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setText(" Ders programınıza yeni bir ders eklendi! " + dersler);
        mimeMessageHelper.setSubject("Ders Programı güncellemesi.");

//        FileSystemResource fileSystemResource= new FileSystemResource(new File("C:\\Users\\melih\\Downloads\\ChatAppGörsel.jpeg"));
//
//        mimeMessageHelper.addAttachment(Objects.requireNonNull(fileSystemResource.getFilename()),fileSystemResource);

        javaMailSender.send(mimeMessage);

        System.out.println("Mail send to " + email);
    }
}
