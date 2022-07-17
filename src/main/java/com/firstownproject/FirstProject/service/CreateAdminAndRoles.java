package com.firstownproject.FirstProject.service;

import com.firstownproject.FirstProject.model.entity.UserEntity;
import com.firstownproject.FirstProject.model.entity.UserRoleEntity;
import com.firstownproject.FirstProject.model.enums.UserRoleEnum;
import com.firstownproject.FirstProject.respository.UserRepository;
import com.firstownproject.FirstProject.respository.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CreateAdminAndRoles {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateAdminAndRoles(UserRepository userRepository,
                               UserRoleRepository userRoleRepository,
                               PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addRolesAndAdmin(){
        if (userRoleRepository.count() == 0){
            UserRoleEntity adminRole = new UserRoleEntity().setUserRole(UserRoleEnum.ADMINISTRATOR);
            UserRoleEntity userRole = new UserRoleEntity().setUserRole(UserRoleEnum.USER);

            userRoleRepository.save(adminRole);
            userRoleRepository.save(userRole);

            createAdmin(List.of(adminRole));
        }
    }

    private void createAdmin(List<UserRoleEntity> roles) {
        if (userRepository.count() == 0){
            UserEntity administrator = new UserEntity()
                    .setUsername("Admin")
                    .setPassword(passwordEncoder.encode("123456"))
                    .setFirstName("Administrator")
                    .setLastName("Boss")
                    .setEmail("admin@mail.com")
                    .setUserRoles(roles);

            userRepository.save(administrator);
        }
    }

}
