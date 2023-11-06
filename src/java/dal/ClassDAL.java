/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modal.Class;

/**
 *
 * @author User
 */
public class ClassDAL extends BaseDal {

    private final String CLASS_ID = "class_id";
    private final String CLASS_NAME = "class_name";
    private final String SUBJECT_ID = "subject_id";
    private final String TEACHER_ID = "teacher_id";
    private final String SEMESTER_ID = "semester_id";
    private final String DESCRIPTION = "description";

    public List<Class> findAll() {
        try {
            String sql = "SELECT * FROM Class";
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<Class> class_list = new ArrayList<>();
            while (resultSet.next()) {
                class_list.add(new Class(
                        resultSet.getInt(CLASS_ID),
                        resultSet.getString(CLASS_NAME),
                        resultSet.getInt(SUBJECT_ID),
                        resultSet.getInt(TEACHER_ID),
                        resultSet.getInt(SEMESTER_ID),
                        resultSet.getString(DESCRIPTION)
                ));
            }
            return class_list;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Class> searchAll(String semester, String teacher, String subject, String class_name) {
        String condition = "";
        if (!semester.equals("All")) {
            condition += " and st.setting_name = '" + semester + "'";
        }
        if (!teacher.equals("All")) {
            condition += " and u.user_fullname = '" + teacher + "'";
        }
        if (!subject.equals("All")) {
            condition += " and su.subject_name = '" + subject + "'";
        }
        if (!class_name.equals("All")) {
            condition += " and c.class_name = '" + class_name + "'";
        }
        try {
            String sql = "select c.class_id, c.class_name, c.subject_id, c.teacher_id, c.description, c.semester_id \n"
                    + "from class c left join subject su on c.subject_id = su.subject_id \n"
                    + "left join [user] u on c.teacher_id = u.user_id \n"
                    + "left join setting st on c.semester_id = st.setting_id and st.setting_type = 'Semester'";
            if(!condition.equals("")){
                sql = sql + " WHERE 1 = 1 " +condition;
            }
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<Class> class_list = new ArrayList<>();
            while (resultSet.next()) {
                class_list.add(new Class(
                        resultSet.getInt(CLASS_ID),
                        resultSet.getString(CLASS_NAME),
                        resultSet.getInt(SUBJECT_ID),
                        resultSet.getInt(TEACHER_ID),
                        resultSet.getInt(SEMESTER_ID),
                        resultSet.getString(DESCRIPTION)
                ));
            }
            return class_list;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Class findById(Integer id) {
        try {
            String sql = "select c.*, s.subject_name, u.user_fullname, se.setting_name from class c" +
                " inner join subject s" +
                " on c.subject_id = s.subject_id" +
                " inner join [user] u" +
                " on u.user_id = c.teacher_id" +
                " inner join setting se" +
                " on se.setting_id = c.semester_id" +
                " where c.class_id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Class classs = new Class(
                        resultSet.getInt(CLASS_ID),
                        resultSet.getString(CLASS_NAME),
                        resultSet.getInt(SUBJECT_ID),
                        resultSet.getInt(TEACHER_ID),
                        resultSet.getInt(SEMESTER_ID),
                        resultSet.getString(DESCRIPTION)
                );
                classs.setSubjectName(resultSet.getString("subject_name"));
                classs.setTeacherName(resultSet.getString("user_fullname"));
                classs.setSemester(resultSet.getString("setting_name"));
                return classs;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void create(String class_name, Integer subject_Id, Integer teacher_Id, Integer semester_Id, String description) {
        try {
            String sql = "insert into class(class_name, subject_id, teacher_id, semester_id, description) values (? ,?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, class_name);
            statement.setInt(2, subject_Id);
            statement.setInt(3, teacher_Id);
            statement.setInt(4, semester_Id);
            statement.setString(5, description);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void update(String id, String name, String subjectId, String teacherId, String semesterId, String description) {
        try {
            String sql = "update class set class_name = ?, subject_id = ?, teacher_id = ?, semester_id = ?, description = ?"
                    + " where class_id = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, subjectId);
            statement.setString(3, teacherId);
            statement.setString(4, semesterId);
            statement.setString(5, description);
            statement.setString(6, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void create(String name, String subjectId, String teacherId, String semesterId, String description) {
        try {
            String sql = "insert into class(class_name, subject_id, teacher_id, semester_id, description) values (? ,?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, subjectId);
            statement.setString(3, teacherId);
            statement.setString(4, semesterId);
            statement.setString(5, description);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }    }
}
