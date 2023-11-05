/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import dal.ProjectDAL;
import java.util.List;
import modal.Project;
import modal.User;
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

    @Override
    public List<User> findStudentByClassIdAndProjectId(String classId, String projectId) {
        return projectDAL.findStudentByClassIdAndProjectId(classId, projectId);
    }

    @Override
    public void moveStudentIn(String projectId, String studentId) {
        Project project = projectDAL.findById(Integer.parseInt(projectId));
        projectDAL.moveStudentIn(projectId, studentId, project.getClassId());
    }

    @Override
    public void moveStudentOut(String projectId, String studentId) {
        Project project = projectDAL.findById(Integer.parseInt(projectId));
        projectDAL.moveStudentOut(projectId, studentId, project.getClassId());
    }

    @Override
    public List<User> findStudentsInClassNotInProject(Integer id, String classId) {
        return projectDAL.findStudentsInClassNotInProject(id, classId);
    }
    
}
