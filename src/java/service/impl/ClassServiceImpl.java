/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dal.ClassDAL;
import java.util.List;
import modal.Class;
import service.ClassService;

/**
 *
 * @author User
 */
public class ClassServiceImpl implements ClassService {

    private final ClassDAL class_dal = new ClassDAL();

    @Override
    public void create(String class_name, Integer subject_Id, Integer teacher_Id, Integer semester_Id, String description) {
        class_dal.create(class_name, subject_Id, teacher_Id, semester_Id, description);
    }

    @Override
    public List<Class> findAll() {
        return class_dal.findAll();
    }

    @Override
    public Class findById(Integer id) {
        return class_dal.findById(id);
    }

    @Override
    public List<Class> searchAll(String semester, String teacher, String subject, String class_name) {
        return class_dal.searchAll(semester, teacher, subject, class_name);
    }

    @Override
    public void update(String id, String name, String subjectId, String teacherId, String semesterId, String description) {
        class_dal.update(id, name, subjectId, teacherId, semesterId, description);
    }

    @Override
    public void create(String name, String subjectId, String teacherId, String semesterId, String description) {
        class_dal.create(name, subjectId, teacherId, semesterId, description);
    }

}
