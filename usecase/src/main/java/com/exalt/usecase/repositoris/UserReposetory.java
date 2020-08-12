package com.exalt.usecase.repositoris;

import com.exalt.usecase.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface UserReposetory extends JpaRepository<User, Integer> {
    @Query("from User ")
    List<User> findAll();

    @Query(value = "select * from usert OFFSET :page limit :limit ",nativeQuery = true)
    List<User> findAllNQ(@Param("page") int page,@Param("limit") int limit );

    @Query("from User u where u.id=:id")
    User getAllusersById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "delete from Usert u where u.userid=:id", nativeQuery = true)
    void deleteByIdNQ(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "insert into user2roles (userid , rolesid) values (:userId , :roleId)", nativeQuery = true)
    void assignUserToRoleNQ(@Param("userId") int userId ,@Param("roleId") int roleId );

    @Query(value = "select count(*) from usert where email=:email ", nativeQuery = true)
    int findEmailExistNQ(@Param("email") String email);
}
