/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dal.SettingDAL;
import java.util.List;
import java.util.regex.Pattern;
import modal.Setting;
import service.SettingService;

/**
 *
 * @author User
 */
public class SettingServiceImpl implements SettingService{
    
    private final SettingDAL setting_dal = new SettingDAL();
    
    @Override
    public List<Setting> findAllSemesterIsActive() {
       return setting_dal.findAllSemesterIsActive();
    }
    @Override
    public boolean updateSuccess(String id, String name, String type, String display_order, String status, String description) {
        boolean check = true;
        String nameRegex = "^[a-zA-Z\\s]+$";
        Pattern namePattern = Pattern.compile(nameRegex);
        if (!namePattern.matcher(name).matches() && type.equals("Rold")) {
            check = false;
        }
        List<Setting> list = new SettingDAL().getAll();
        for (Setting setting : list) {
            if (setting.getSetting_id() != Integer.parseInt(id)
                    && setting.getSetting_type().equals(type)
                    && setting.getDisplay_order() == Integer.parseInt(display_order)) {
                check = false;
            }
        }    
        if (check) {
            new SettingDAL().updateSetting(id, name, type, display_order, status, description);
        }
        return check;
    }

    @Override
    public boolean addnewSuccess(String name, String type, String display_order, String status, String description) {
        boolean check = true;
        String nameRegex = "^[a-zA-Z\\s]+$";
        Pattern namePattern = Pattern.compile(nameRegex);
        if (!namePattern.matcher(name).matches() && type.equals("Rold")) {
            check = false;
        }
        List<Setting> list = new SettingDAL().getAll();
        for (Setting setting : list) {
            if (setting.getSetting_name().toUpperCase().equals(name.toUpperCase())) {
                check = false;
            }
        }
        for (Setting settingg : list) {
            if (settingg.getSetting_type().equals(type) && settingg.getDisplay_order() == Integer.parseInt(display_order)) {
                check = false;
            }
        }
        if (check) {
            new SettingDAL().createSetting(name, type, display_order, status, description);
        }
        return check;
    }
    
}
