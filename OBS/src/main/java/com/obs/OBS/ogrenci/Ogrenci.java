package com.obs.OBS.ogrenci;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.obs.OBS.ders.Dersler;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "ogrenci")
@Data
public class Ogrenci {
    //OneToMany derslere
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ogrenci_id")
    private Long id;

    @Column(name = "ogrenci_isim")
    private String isim;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "ogrenci",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private List<Dersler> ders;
/**
 * cascade = CascadeType.ALL yapılan bir güncellemede
 *   dersler tarafındada güncellemeyi geçerli kılar.
 *   @JsonManagedReference &  @JsonBackReference
*/




}
