package com.firstownproject.FirstProject.init;

import com.firstownproject.FirstProject.service.CreateAdminAndRoles;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppInit implements CommandLineRunner {

    private CreateAdminAndRoles createAdminAndRoles;

    public AppInit(CreateAdminAndRoles createAdminAndRoles) {
        this.createAdminAndRoles = createAdminAndRoles;
    }

    @Override
    public void run(String... args) throws Exception {
        createAdminAndRoles.addRolesAndAdmin();
    }
}
