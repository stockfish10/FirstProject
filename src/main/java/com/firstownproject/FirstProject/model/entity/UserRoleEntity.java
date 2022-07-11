package com.firstownproject.FirstProject.model.entity;

import com.firstownproject.FirstProject.model.enums.UserRoleEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_role")
public class UserRoleEntity extends BaseEntity{

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleEnum userRole;

    public UserRoleEnum getUserRole() {
        return userRole;
    }

    public UserRoleEntity setUserRole(UserRoleEnum userRole) {
        this.userRole = userRole;
        return this;
    }
}
