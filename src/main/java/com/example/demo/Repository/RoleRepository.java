package com.example.demo.Repository;

import com.example.demo.Domain.Role;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository {
    @Query("select r from  Role r where r.name= :name")
    Optional<Role> findbyName(com.example.demo.modal.Enum.Role name);
}
