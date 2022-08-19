package com.firstownproject.FirstProject.service;


import com.firstownproject.FirstProject.model.entity.UserEntity;
import com.firstownproject.FirstProject.model.entity.UserRoleEntity;
import com.firstownproject.FirstProject.model.enums.UserRoleEnum;
import com.firstownproject.FirstProject.model.user.MyAppUser;
import com.firstownproject.FirstProject.respository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AppUserDetailsServiceTest {

    @Mock
    private UserRepository mockUserRepository;

    private AppUserDetailsService toTest;

    @BeforeEach
    void setUp(){
        toTest = new AppUserDetailsService(mockUserRepository);
    }

    @Test
    void testLoadUserByUsername_UserExists() {
        UserEntity testUserEntity =
                new UserEntity().
                        setUsername("test").
                        setPassword("123test").
                        setFirstName("Test").
                        setLastName("Testov").
                        setEmail("test@mail.com").
                        setUserRoles(List.of(new UserRoleEntity().setUserRole(UserRoleEnum.USER),
                                new UserRoleEntity().setUserRole(UserRoleEnum.ADMINISTRATOR)));

        when(mockUserRepository.
                findByUsername(testUserEntity.getUsername())).
                thenReturn(Optional.of(testUserEntity));

        MyAppUser userDetails = (MyAppUser) toTest.loadUserByUsername(testUserEntity.getUsername());

        Assertions.assertEquals(testUserEntity.getUsername(),userDetails.getUsername());
        Assertions.assertEquals(testUserEntity.getFirstName(),userDetails.getFirstName());
        Assertions.assertEquals(testUserEntity.getLastName(),userDetails.getLastName());
        Assertions.assertEquals(testUserEntity.getPassword(),userDetails.getPassword());

        var authorities = userDetails.getAuthorities();

        var authoritiesIter = authorities.iterator();

        Assertions.assertEquals(2, authorities.size());
        Assertions.assertEquals("ROLE_" + UserRoleEnum.ADMINISTRATOR.name(),authoritiesIter.next().getAuthority());
        Assertions.assertEquals("ROLE_" + UserRoleEnum.USER.name(),authoritiesIter.next().getAuthority());


    }

    @Test
    void testLoadUserByUsername_UserDoesNotExists() {


    }
}
