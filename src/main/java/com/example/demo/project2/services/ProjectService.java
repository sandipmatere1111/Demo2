package com.example.demo.project2.services;

import com.example.demo.project2.entities.Client;
import com.example.demo.project2.entities.Project;
import com.example.demo.project2.exception.RequestException;
import com.example.demo.project2.repositories.ClientRepository;
import com.example.demo.project2.repositories.ProjectRepository;
import com.example.demo.project2.views.ProjectView;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    private final ClientRepository clientRepository;

    public ProjectService(ProjectRepository projectRepository, ClientRepository clientRepository) {
        this.projectRepository = projectRepository;
        this.clientRepository = clientRepository;
    }

    public ProjectView getProject(Integer id) throws RequestException{
        ProjectView projectView = new ProjectView();
        Project project = new Project();
        Optional<Project> optionalProject = projectRepository.findById(id);

        if(!optionalProject.isPresent()){
            throw new RequestException("Project Not Found");
        }else{
            project = optionalProject.get();
        }

        projectView.setId(id);
        projectView.setClientId(project.getClientId());
        projectView.setProjectName(project.getProjectName());
        projectView.setProjectManager(project.getProjectManager());
        projectView.setProjectHead(project.getProjectHead());
        return projectView;
    }

    public void saveProject(ProjectView projectView) throws RequestException {
        Project project = new Project();
        Client client = clientRepository.findClientById(projectView.getClientId());
        if(client==null){
            throw new RequestException("Client does not exist");
        }

        List<Project> projectList = projectRepository.getAllProjects();
        for (Project project1 : projectList) {
            if (project1.getProjectName().equals(projectView.getProjectName())) {
                throw new RequestException("Project Name already exists");
            }
        }
        project.setId(projectView.getId());
        project.setProjectName(projectView.getProjectName());
        project.setClientId(projectView.getClientId());
        project.setProjectHead(projectView.getProjectHead());
        project.setProjectManager(projectView.getProjectManager());
        project.setDeleted(false);
        try {
            projectRepository.save(project);
        } catch (DataIntegrityViolationException ex) {
            throw new RequestException("Duplicate project ID or client ID");
        }
    }

    public void deleteProject(Integer id) throws Exception{

        Project project = new Project();
        Optional<Project> optionalProject = projectRepository.findById(id);

        if(!optionalProject.isPresent()){
            throw new RequestException("Project doesn't Exist");
        }else{
            project = optionalProject.get();
        }

        if(project.getDeleted()){
            throw new RequestException("Project already deleted");
        }else{
            project.setDeleted(true);
        }
        projectRepository.save(project);
    }


}
