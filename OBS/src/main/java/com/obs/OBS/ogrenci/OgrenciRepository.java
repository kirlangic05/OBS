package com.obs.OBS.ogrenci;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OgrenciRepository extends JpaRepository<Ogrenci,Long> {
}
