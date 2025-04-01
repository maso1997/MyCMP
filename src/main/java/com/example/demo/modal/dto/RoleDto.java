package com.example.demo.modal.dto;

import com.example.demo.Domain.Role;

public class RoleDto {
    private Long id ;
    private Role name ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getName() {
        return name;
    }

    public void setName(Role name) {
        this.name = name;
    }
}
