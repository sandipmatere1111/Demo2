package com.example.demo.project2.controllers;

import com.example.demo.project2.entities.Project;
import com.example.demo.project2.exception.RequestException;
import com.example.demo.project2.repositories.ProjectRepository;
import com.example.demo.project2.services.ProjectService;
import com.example.demo.project2.views.ProjectView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectRepository projectRepository;

    public ProjectController(ProjectService projectService, ProjectRepository projectRepository) {
        this.projectService = projectService;
        this.projectRepository = projectRepository;
    }

    @GetMapping("/getProject")
    public ProjectView getProjectById(@RequestParam Integer id) throws RequestException {
        ProjectView projectView = projectService.getProject(id);
        return projectView;
    }

    @PostMapping("/saveProject")
    public void saveProject(@RequestBody ProjectView projectView) throws RequestException {
        projectService.saveProject(projectView);
    }

    @GetMapping("/getAllProjects")
    public ResponseEntity<List<Project>> getAllProjects() throws RequestException{
        List<Project> projects = projectRepository.getAllProjects();
        if (projects.isEmpty()) {
            throw new RequestException("No clients found");
        }
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProject")
    public ResponseEntity<String> deleteProject(@RequestParam Integer id) throws Exception{

        projectService.deleteProject(id);
        return new ResponseEntity<>("Client deleted successfully", HttpStatus.OK);
    }


}
