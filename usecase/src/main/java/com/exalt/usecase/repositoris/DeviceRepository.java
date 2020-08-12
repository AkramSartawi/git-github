package com.exalt.usecase.repositoris;

import com.exalt.usecase.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeviceRepository  extends JpaRepository<Device , Integer> {
    @Query(value = "select * from Device", nativeQuery = true)
    List<Device> findAll();
    @Query("from Device R where R.id=:id")
    Device findById(@Param("id") int id);
    @Modifying
    @Query(value = "delete from Device u where u.userid=:id", nativeQuery = true)
    void deleteByIdNQ(@Param("id") int id);
}
