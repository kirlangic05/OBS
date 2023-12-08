package com.obs.OBS.ogretmen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OgretmenRepository extends JpaRepository<Ogretmen,Long> {
}
