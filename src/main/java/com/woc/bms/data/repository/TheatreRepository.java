package com.woc.bms.data.repository;

import com.woc.bms.data.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

    Theatre findByTheatreCode(String theatreCode);

    @Query("from Theatre t where t.theatreCode=:theatreCodeParam")
    Theatre getTheatre(@Param("theatreCodeParam") String theatreCode);

    @Query("from Theatre t where t.city.cityCode=:cityCodeParam")
    List<Theatre> getTheatreByCityCode(@Param("cityCodeParam") String cityCode);
}
