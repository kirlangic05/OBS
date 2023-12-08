package com.obs.OBS.notlar;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.obs.OBS.ders.Dersler;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "notlar")
public class Not {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "not_id")
    private Long id;

    @Column(name = "notlar")
    private int not;

    @OneToOne//(mappedBy = "notlar")
    @JoinColumn(name = "ders_Id")
    @JsonBackReference
    private Dersler dersler;

}
