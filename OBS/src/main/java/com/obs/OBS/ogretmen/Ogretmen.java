package com.obs.OBS.ogretmen;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.obs.OBS.ders.Dersler;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ogretmen")
public class Ogretmen {
    @Id
    @Column(name = "ogretmenId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ogretmen_isim")
    private String isim;

    @OneToOne(mappedBy = "ogretmen")
    @JsonBackReference
    private Dersler ders;


}
