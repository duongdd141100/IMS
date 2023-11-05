/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

/**
 *
 * @author User
 */
public interface ClassService {

    void create(String class_name, Integer subject_Id, Integer teacher_Id, Integer semester_Id, String description);

    List<modal.Class> findAll();

    List<modal.Class> searchAll(String semester, String teacher, String subject, String class_name);

    modal.Class findById(Integer id);

}
