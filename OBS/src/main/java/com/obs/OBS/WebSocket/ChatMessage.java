package com.obs.OBS.WebSocket;


import com.obs.OBS.ogrenci.Ogrenci;
import com.obs.OBS.ogretmen.Ogretmen;
import lombok.Data;


@Data
public class ChatMessage {
    private String message;
    private String sender;
    private String receiver;
}
