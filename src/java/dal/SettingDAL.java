/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modal.Setting;

/**
 *
 * @author User
 */
public class SettingDAL extends BaseDal {

    private final String SETTING_ID = "setting_id";
    private final String SETTING_NAME = "setting_name";
    private final String SETTING_TYPE = "setting_type";
    private final String DISPLAY_ORDER = "display_order";
    private final String STATUAS = "status";
    private final String DESCRIPTION = "description";

    public List<Setting> findAllSemesterIsActive() {
        try {
            String sql = "SELECT * FROM [setting] WHERE setting_type = 'Semester' and status = 1";
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<modal.Setting> setting_list = new ArrayList<>();
            while (resultSet.next()) {
                setting_list.add(new modal.Setting(
                        resultSet.getInt(SETTING_ID),
                        resultSet.getString(SETTING_NAME),
                        resultSet.getString(SETTING_TYPE),
                        resultSet.getInt(DISPLAY_ORDER),
                        resultSet.getInt(STATUAS),
                        resultSet.getString(DESCRIPTION)
                ));
            }
            return setting_list;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
