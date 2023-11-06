/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import modal.Project;
import modal.User;

/**
 *
 * @author Do Duc Duong
 */
public class ProjectDAL extends BaseDal{
    public List<Project> findAll() {
        try {
            String sql = "select p.project_id, p.project_name, c.class_id, c.class_name, u.user_id, u.user_fullname, p.description from project p" +
                " inner join class c" +
                " on p.class_id = c.class_id" +
                " left join [user] u" +
                " on u.user_id = p.leader_id";
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<Project> projects = new ArrayList<>();
            while (resultSet.next()) {
                projects.add(new Project(resultSet.getInt("project_id"),
                        resultSet.getString("project_name"),
                        resultSet.getString("class_id"),
                        resultSet.getString("class_name"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("user_fullname"),
                        resultSet.getString("description")));
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
            String sql = "select p.project_id, p.project_name, c.class_id, c.class_name, u.user_id, u.user_fullname, p.description from project p" +
                " inner join class c" +
                " on p.class_id = c.class_id" +
                " left join [user] u" +
                " on u.user_id = p.leader_id" +
                " where p.project_id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Project(resultSet.getInt("project_id"),
                        resultSet.getString("project_name"),
                        resultSet.getString("class_id"),
                        resultSet.getString("class_name"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("user_fullname"),
                        resultSet.getString("description"));
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
                    + " where project_id = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, classId);
            statement.setString(3, leaderId);
            statement.setString(4, description);
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void create(String name, Integer classId, String description) {
        try {
            String sql = "insert into project(project_name, class_id, description) values (? , ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, classId);
            statement.setString(3, description);
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<User> findStudentByClassIdAndProjectId(String classId, String projectId) {
        try {
            String sql = "select u.user_id, u.user_fullname from class_student cs" +
                " inner join class c" +
                " on cs.class_id = c.class_id" +
                " inner join [user] u" +
                " on u.user_id = cs.student_id" +
                " inner join project p " +
                " on p.project_id = cs.project_id" +
                " where cs.class_id = ? and cs.project_id = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, classId);
            statement.setString(2, projectId);
            resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setFullName(resultSet.getString("user_fullname"));
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void moveStudentIn(String projectId, String studentId, String classId) {
        try {
            String sql = "insert into class_student values (?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, classId);
            statement.setString(2, studentId);
            statement.setString(3, projectId);
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void moveStudentOut(String projectId, String studentId, String classId) {
        try {
            String sql = "delete class_student where project_id = ? and class_id = ? and student_id = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, projectId);
            statement.setString(2, classId);
            statement.setString(3, studentId);
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<User> findStudentsInClassNotInProject(Integer id, String classId) {
        try {
            String sql = "select * from [user] where user_id in" +
                " (select t1.student_id from " +
                " (select * from class_student where project_id is null and class_id = ?) t1" +
                " left join" +
                " (select * from class_student where project_id = ?) t2" +
                " on t1.class_id = t2.class_id and t1.student_id = t2.student_id" +
                " where t2.project_id is null)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, classId);
            statement.setInt(2, id);
            resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setFullName(resultSet.getString("user_fullname"));
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
