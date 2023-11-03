/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import dal.ProjectDAL;
import java.util.List;
import modal.Project;
import service.ProjectService;

/**
 *
 * @author Do Duc Duong
 */
public class ProjectServiceImpl implements ProjectService {
    
    private ProjectDAL projectDAL = new ProjectDAL();

    @Override
    public void create(String name, Integer classId, Integer leaderId, String description) {
        projectDAL.create(name, classId, leaderId, description);
    }

    @Override
    public List<Project> findAll() {
        return projectDAL.findAll();
    }

    @Override
    public void update(Integer id, String name, String classId, String leaderId, String description) {
        projectDAL.update(id, name, classId, leaderId, description);
    }

    @Override
    public Project findById(Integer id) {
        return projectDAL.findById(id);
    }

    @Override
    public void delete(Integer id) {
        projectDAL.delete(id);
    }
    
}
