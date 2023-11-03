/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import modal.Project;

/**
 *
 * @author Do Duc Duong
 */
public class ProjectDAL extends BaseDal{
    public List<Project> findAll() {
        try {
            String sql = "select p.project_name, c.class_name, u.user_fullname, p.description from project p" +
                " inner join class c" +
                " on p.class_id = c.class_id" +
                " inner join [user] u" +
                " on u.user_id = p.leader_id";
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<Project> projects = new ArrayList<>();
            while (resultSet.next()) {
                projects.add(new Project(resultSet.getInt("id"), resultSet.getString("project_name"),
                        resultSet.getString("class_name"), resultSet.getString("user_fullname"), resultSet.getString("description")));
            }
            return projects;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(Integer id) {
        try {
            String sql = "delete project where id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Project findById(Integer id) {
        try {
            String sql = "select p.project_name, c.class_name, u.user_fullname, p.description from project p" +
                " inner join class c" +
                " on p.class_id = c.class_id" +
                " inner join [user] u" +
                " on u.user_id = p.leader_id";
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Project(resultSet.getInt("id"), resultSet.getString("project_name"),
                        resultSet.getString("class_name"), resultSet.getString("user_fullname"), resultSet.getString("description"));
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void update(Integer id, String name, String classId, String leaderId, String description) {
        try {
            String sql = "update project set project_name = ?,"
                    + " class_id = ?,"
                    + " leader_id = ?,"
                    + " description = ?"
                    + " where id = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, classId);
            statement.setString(3, leaderId);
            statement.setString(4, description);
            statement.setInt(5, id);
            statement.executeQuery();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void create(String name, Integer classId, Integer leaderId, String description) {
        try {
            String sql = "insert into project(project_name, class_id, leader_id, description) values (? ,?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, classId);
            statement.setInt(3, leaderId);
            statement.setString(4, description);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
