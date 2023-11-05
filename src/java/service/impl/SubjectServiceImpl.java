/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dal.SubjectDAL;
import java.util.List;
import modal.Subject;
import service.SubjectService;

/**
 *
 * @author User
 */
public class SubjectServiceImpl implements SubjectService{
    
    private final SubjectDAL subjectDAL = new SubjectDAL();
    @Override
    public List<Subject> findAll() {
       return subjectDAL.findAll();
    }
    
}
