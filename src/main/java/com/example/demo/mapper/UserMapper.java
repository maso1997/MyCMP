package com.example.demo.mapper;

import com.example.demo.Domain.Role;
import com.example.demo.Domain.User;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.modal.dto.RoleDto;
import com.example.demo.modal.dto.UserDto;
import com.example.demo.modal.dto.UserRolesDto;
import org.mapstruct.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends EntityMapper<UserDto, User> {

    @Mapping(target = "nom", source = "nom")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapRolesDto")
    UserDto toDto(User user);

    @Mapping(target = "nom", source = "nom")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapRoles")
    User toEntity(UserDto userDto);

    @Mapping(target = "user_id", source = "user_id")
    @Mapping(target = "nom", source = "nom")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapUserRolesDto")
    UserRolesDto toDtoRole(User user);

    @Mapping(target = "nom", source = "nom")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "matricule", source = "matricule")
    @Mapping(target = "roles", expression = "java(mapUserRolesEntite(userRolesDto.getRoles(), roleRepository))")
    User toEntiteRole(UserRolesDto userRolesDto, @Context RoleRepository roleRepository);

    @Named("mapRoles")
    default Set<Role> mapRoles(Set<RoleDto> roleDtos) {
        if (roleDtos.isEmpty()) {
            return Collections.emptySet();
        }
        Set<Role> roles = new HashSet<>();
        for (RoleDto roleDto : roleDtos) {
            Role role = new Role();
            role.setName(roleDto.getName());
            role.setId(roleDto.getId());
            roles.add(role);
        }
        return roles;
    }

    @Named("mapUserRolesDto")
    default Set<com.example.demo.modal.Enum.Role>mapUserRolesDto(Set<Role>role) {
        if (role.isEmpty()) {
            return Collections.emptySet();
        }
        return role.stream().map(Role::getName).collect(Collectors.toSet());
    }

    @Named("mapRolesDto")
    default Set<RoleDto> mapRolesDto(Set<Role> role) {
        if ( role.isEmpty()) {
            return Collections.emptySet();
        }
        Set<RoleDto> roleDtoSet = new HashSet<>();
        for (Role role1 : role) {
            RoleDto roleMap = new RoleDto();
             roleMap.setName(role1.getName());
            roleMap.setId(role1.getId());
            roleDtoSet.add(roleMap);
        }
        return roleDtoSet;
    }

    @Named("mapUserRolesEntite")
    default Set<Role> mapUserRolesEntite(Set<com.example.demo.modal.Enum.Role> roleNames, @Context RoleRepository roleRepository) {
        if ( roleNames.isEmpty()) {
            return Collections.emptySet();
        }
        return roleNames.stream()
                .map(roleRepository::findbyName)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }
}
