/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

/**
 *
 * @author User
 */
public class Class {
    private Integer class_id;
    private String class_name;
    private Integer subject_id;
    private Integer teacher_id;
    private Integer semester_id;
    private String description;
    private String subjectName;
    private String teacherName;
    private String semester;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Class() {
    }
    
    public Class(Integer class_id, String class_name, Integer subject_id, Integer teacher_id, Integer semester_id, String description) {
        this.class_id = class_id;
        this.class_name = class_name;
        this.subject_id = subject_id;
        this.teacher_id = teacher_id;
        this.semester_id = semester_id;
        this.description = description;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Integer getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Integer getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(Integer semester_id) {
        this.semester_id = semester_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
