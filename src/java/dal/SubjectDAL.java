/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class SubjectDAL extends BaseDal {

    private final String SUBJECT_ID = "subject_id";
    private final String SUBJECT_NAME = "subject_name";
    private final String MANAGER_ID = "manager_id";
    private final String DESCRIPTION = "description";

    public List<modal.Subject> findAll() {
        try {
            String sql = "SELECT * FROM subject";
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<modal.Subject> subject_list = new ArrayList<>();
            while (resultSet.next()) {
                subject_list.add(new modal.Subject(
                        resultSet.getInt(SUBJECT_ID),
                        resultSet.getString(SUBJECT_NAME),
                        resultSet.getInt(MANAGER_ID),
                        resultSet.getString(DESCRIPTION)
                ));
            }
            return subject_list;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
