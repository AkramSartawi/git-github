package com.exalt.usecase.repositoris;

import com.exalt.usecase.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
    @Query("from UserProfile ")
    List<UserProfile> findAll();

    @Query("from UserProfile u where u.id=:id")
    UserProfile findById(@Param("id") int id);

    @Modifying
    @Query(value = "delete from UserProfile u where u.userid=:id", nativeQuery = true)
    void deleteByIdNQ(@Param("id") int id);
}
