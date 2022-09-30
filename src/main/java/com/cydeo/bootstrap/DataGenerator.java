package com.cydeo.bootstrap;

import com.cydeo.dto.RoleDTO;
import org.springframework.boot.CommandLineRunner;

public class DataGenerator implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        RoleDTO adminRole= new RoleDTO(1L,"Admin");
        RoleDTO managerRole= new RoleDTO(2L,"Manager");
        RoleDTO employeeRole= new RoleDTO(3L,"Employee");


        //create some rows for usercreate page and put in the DB(map)
        //create users and put in the DB(map)
        //this run method will execute first before anything when we start the application
    }
}
