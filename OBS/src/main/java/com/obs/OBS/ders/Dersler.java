package com.obs.OBS.ders;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.obs.OBS.notlar.Not;
import com.obs.OBS.ogrenci.Ogrenci;
import com.obs.OBS.ogretmen.Ogretmen;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ders")
public class Dersler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ders_id")
    private Long id;

    @Column(name = "ders_adi")
    private String dersAdi;

    @Override //yapay zeka eklentisi
    public String toString() {
        return "\nDers Adı = " + dersAdi;
    }

    @ManyToOne
    @JoinColumn(name = "ogrenciId")
    @JsonBackReference
    private Ogrenci ogrenci;


    @OneToOne(orphanRemoval = true, cascade = CascadeType.REMOVE) //yeni
    @JoinColumn(name = "ogretmen_id")
    @JsonManagedReference
    private Ogretmen ogretmen;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.REMOVE) //yeni
    @JoinColumn(name = "notId")
    @JsonManagedReference
    private Not notlar;


}
