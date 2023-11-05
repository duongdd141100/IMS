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
public class Subject {
    private Integer subject_id;
    private String subject_name;
    private Integer manager_id; 
    private String  description;

    public Subject() {
    }

    public Subject(Integer subject_id, String subject_name, Integer manager_id, String description) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.manager_id = manager_id;
        this.description = description;
    }

    public Integer getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
