package com.firstownproject.FirstProject.init;

import com.firstownproject.FirstProject.service.CreateAdminAndRoles;
import com.firstownproject.FirstProject.service.CreateEvents;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppInit implements CommandLineRunner {

    private CreateAdminAndRoles createAdminAndRoles;
    private CreateEvents createEvents;

    public AppInit(CreateAdminAndRoles createAdminAndRoles, CreateEvents createEvents) {
        this.createAdminAndRoles = createAdminAndRoles;
        this.createEvents = createEvents;
    }

    @Override
    public void run(String... args) throws Exception {
        createAdminAndRoles.addRolesAndAdmin();
        createEvents.createEvents();
    }
}
