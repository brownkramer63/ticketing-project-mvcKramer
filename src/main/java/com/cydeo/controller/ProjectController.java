package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final UserService userService;
    private final ProjectService projectService;

    public ProjectController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }

    @GetMapping("create")
    public String createProject(Model model){

        model.addAttribute("project",new ProjectDTO());
        model.addAttribute("managers",userService.findManagers());

        model.addAttribute("projects", projectService.findAll());


        return "/project/create";
    }

    @PostMapping("create")
    public String insertProject(@ModelAttribute("project") ProjectDTO project){


        projectService.save(project);


        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectCode}")
    public String deleteProject(@PathVariable("projectCode") String projectCode){

        projectService.deleteById(projectCode);


        return "redirect:/project/create";

    }

    @GetMapping("/complete/{projectCode}")
    public String completeProject(@PathVariable("projectCode") String projectCode){

        //complete we need to change enum status to complete

        projectService.complete(projectService.findById(projectCode));


        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectCode}")
    public String editProject(@PathVariable("projectCode") String projectCode, Model model){
//we need one user object one roles object and one users with annotation ${}

        //user we are getting
        model.addAttribute("project",projectService.findById(projectCode));

        // role object we are getting
        model.addAttribute("managers", userService.findManagers() );

        //we will get all users for our user list
        model.addAttribute("projects", projectService.findAll());



        return "/project/update";
    }

    @PostMapping("/update")
    public String updateProject(@ModelAttribute("project") ProjectDTO project){

        projectService.update(project);

        return "redirect:/project/create";
    }

}
