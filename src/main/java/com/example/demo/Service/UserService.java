package com.example.demo.Service;

import com.example.demo.Domain.Role;
import com.example.demo.Domain.User;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.mapper.UserMapper;
import com.example.demo.modal.dto.UserRolesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    public void saveUser(UserRolesDto userDto) {
        try {
            User user = userMapper.toEntiteRole(userDto, roleRepository);
            userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save user", e);
        }
    }

    public Page<UserRolesDto> getAllUsers(Pageable pageable, String nom, String email, String matricule, String role) {
        try {
            Page<User> users = userRepository.findBySearchPage(pageable, nom, email, matricule, role);
            return users.map(userMapper::toDtoRole);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all users list", e);
        }
    }

    public void deleteUserById(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete user by id", e);
        }
    }

    public void updateUser(UserRolesDto userDto) {
        try {
            User user = userMapper.toEntiteRole(userDto, roleRepository);
            userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update user", e);
        }
    }

    public List<User> searchUser(String nom, String email, String matricule, String role) {
        try {
            return userRepository.findBySearch(nom, email, matricule, role);
        } catch (Exception e) {
            throw new RuntimeException("Failed to search user", e);
        }
    }

    public List<UserRolesDto> getAllUsersList() {
        try {
            List<User> users = userRepository.findAll();
            return users.stream().map(userMapper::toDtoRole).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all users list", e);
        }
    }

    public UserRolesDto getByUserName(String username) {
        try {
            User user = userRepository.findUserByUsername(username);
            return userMapper.toDtoRole(user);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get user by username", e);
        }
    }

    public UserRolesDto getUserByIdDto(Long id) {
        try {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));
            return userMapper.toDtoRole(user);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get user by id", e);
        }
    }

    @Override
    public List<User> getByRoles(Role role) {
        return userRepository.findAllByRole(role);
    }

    public List<User> getByRoles(List<Role> roles) {
        return roles.stream()
                .map(userRepository::findAllByRole)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public User getAuthenticatedUser() throws PermissionException {
        User user = userRepository.findByEmail(getAuthenticatedUserEmail())
                .orElseThrow(() -> new PermissionException("User not found"));

        if (!user.isEnabled()) {
            System.out.println("User disabled: " + user.getEmail());
            throw new PermissionException("Utilisateur désactivé");
        }

        return user;
    }

    public static String getAuthenticatedUserEmail() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Principal principal = (Principal) authentication.getPrincipal();
            return principal.getName();
        } catch (Exception e) {
            return "system.system@soogen.com";
        }
    }

    public User getUserById(Long id) {
        try {
            return userRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to get user by id", e);
        }
    }
}
