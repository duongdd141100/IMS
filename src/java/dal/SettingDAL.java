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
                        resultSet.getString(STATUAS),
                        resultSet.getString(DESCRIPTION)
                ));
            }
            return setting_list;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<Setting> getAll() {
        List<Setting> list = new ArrayList<>();
        String querry = "SELECT *FROM setting";
        try {
            statement = conn.prepareStatement(querry);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(new Setting(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Setting getSettingById(String settingId) {
        Setting setting = new Setting();
        String querry = "SELECT * FROM setting where setting_id="+settingId+"";
        try {
            statement = conn.prepareStatement(querry);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                setting = new Setting(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return setting;
    }
    
    public void updateSetting(String id, String name, String type, String display_order, String status, String description) {       
        String querry = "UPDATE [dbo].[setting] SET [setting_name] = '"+name+"' ,[setting_type] = '"+type+"' ,[display_order] = "+display_order+", [status] = '"+status+"'  ,[description] = '"+description+"' WHERE setting_id = "+id+"";
        try {
            statement = conn.prepareStatement(querry);
            resultSet = statement.executeQuery();          
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void createSetting(String name, String type, String display_order, String status, String description) {       
        String querry = "INSERT INTO [dbo].[setting] ([setting_name],[setting_type],[display_order],[status],[description]) VALUES('"+name+"','"+type+"',"+display_order+",'"+status+"','"+description+"')";
        try {
            statement = conn.prepareStatement(querry);
            resultSet = statement.executeQuery();          
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
