package com.exalt.usecase.repositoris;

import com.exalt.usecase.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository  extends JpaRepository<Location ,Integer> {
    @Query("from Location ")
    List<Location> findAll();

    @Query("from Location R where R.id=:id")
    Location findById(@Param("id") int id);

    @Modifying
    @Query(value = "delete from Location u where u.userid=:id", nativeQuery = true)
    void deleteByIdNQ(@Param("id") int id);
}
