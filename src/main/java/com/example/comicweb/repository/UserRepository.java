package com.example.comicweb.repository;

import com.example.comicweb.dto.UserDTO;
import com.example.comicweb.model.Role;
import com.example.comicweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);

    @Modifying
    @Query("update User set role = :role where username = :username")
    void updateUserRole(@Param("username") String username, @Param("role") Role role);

    @Transactional
    @Modifying
    @Query("update User u set u.username = ?1 where u.id = ?2")
    void updateTest(String userName, Long id);
    @Modifying
    @Transactional
    @Query("update User u set u.status = 'DELETED' where u.id = ?1")
    void deleteUser( Long id);



}
