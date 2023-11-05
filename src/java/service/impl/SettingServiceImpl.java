/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dal.SettingDAL;
import java.util.List;
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
    
}
