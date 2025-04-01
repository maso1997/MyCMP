package com.example.demo.Repository;
import com.example.demo.Domain.Role;
import com.example.demo.Domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u join u.roles ur where" +
            "(:nom is null or :nom = '' or u.nom like concat('%', :nom, '%')) " +
            "and (:email is null or :email ='' or u.email like concat('%', :email, '%')) " +
            "and (:matricule is null or :matricule ='' or u.matricule like concat('%', :matricule, '%')) " +
            "and ((:role) is null  or ur.name in (:role) order by u.user_id desc")
    List<User> findBySearch(
            Pageable pageable,
            @Param("nom") String nom,
            @Param("email") String email,
            @Param("matricule") String matricule,
            @Param("role") String role);
    @Query("select distinct u from User u left join u.roles ur where "+
            "(:nom is null or :nom = '' or u.nom like concat('%', :nom, '%')) " +
            "and (:email is null or or :email = '' u.email like concat('%', :email, '%')) " +
            "and (:prenom is null or :prenom = '' or u.prenom like concat('%', :prenom, '%')) " +
            "and (:matricule is null or :matricule = '' or u.matricule like concat('%', :matricule, '%')) " +
            "and ((:role )is null or ur.name in (:role)) order by u.user_id desc ")

    Page<User> findBySearchPage(
            Pageable pageable,
            @Param("nom") String nom,
            @Param("email") String email,
            @Param("matricule") String matricule,
            @Param("prenom") String prenom,
            @Param("role") List<Role> role);
    User findUserByUsername(String username);

    @Query("select u from User u join u.roles ur where ur.name = :role")
    List<User> findAllByRole(Role role);

    @Query("select u from User u join u.roles ur where ur.name = :role and u.enabled = true")
    User findAllByRoleActive(Role role);

    Optional<User> findByEmail(String email);
}
