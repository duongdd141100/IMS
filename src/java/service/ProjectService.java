/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import modal.Project;
import modal.User;

/**
 *
 * @author Do Duc Duong
 */
public interface ProjectService {
    void create(String name, Integer classId, Integer leaderId, String description);
    List<Project> findAll();
    void update(Integer id, String name, String classId, String leaderId, String description);
    Project findById(Integer id);
    void delete(Integer id);

    public List<User> findStudentByClassIdAndProjectId(String classId, String projectId);

    public void moveStudentIn(String projectId, String studentId);

    public void moveStudentOut(String projectId, String studentId);

    public List<User> findStudentsInClassNotInProject(Integer id, String classId);
}
