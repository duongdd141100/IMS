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
public class Setting {
    private Integer setting_id;
    private String setting_name;
    private String setting_type;
    private Integer display_order;
    private int status;
    private String description;

    public Setting() {
    }

    public Setting(Integer setting_id, String setting_name, String setting_type, Integer display_order, int status, String description) {
        this.setting_id = setting_id;
        this.setting_name = setting_name;
        this.setting_type = setting_type;
        this.display_order = display_order;
        this.status = status;
        this.description = description;
    }

    public Integer getSetting_id() {
        return setting_id;
    }

    public void setSetting_id(Integer setting_id) {
        this.setting_id = setting_id;
    }

    public String getSetting_name() {
        return setting_name;
    }

    public void setSetting_name(String setting_name) {
        this.setting_name = setting_name;
    }

    public String getSetting_type() {
        return setting_type;
    }

    public void setSetting_type(String setting_type) {
        this.setting_type = setting_type;
    }

    public Integer getDisplay_order() {
        return display_order;
    }

    public void setDisplay_order(Integer display_order) {
        this.display_order = display_order;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
