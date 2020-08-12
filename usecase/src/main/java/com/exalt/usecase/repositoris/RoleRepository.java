package com.exalt.usecase.repositoris;

import com.exalt.usecase.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("from Role ")
    List<Role> findAll();

    @Query("from Role R where R.id=:id")
    Role findById(@Param("id") int id);

    @Modifying
    @Query(value = "delete from Role u where u.userid=:id", nativeQuery = true)
    void deleteByIdNQ(@Param("id") int id);
}
