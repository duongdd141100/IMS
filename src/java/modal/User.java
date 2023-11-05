package modal;

import java.sql.Date;

/**
 *
 */
public class User {
    private Integer id;
    
    private String fullName;

    private String username;
    
    private String password;
    
    private String image;
    
    private Boolean isActive;
    private Date birthday;
   private String address;
   private int roldId;

    public User(Integer id, String username, String password, String image, Boolean isActive) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.image = image;
        this.isActive = isActive;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoldId() {
        return roldId;
    }

    public void setRoldId(int roldId) {
        this.roldId = roldId;
    }

    public User() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getImage() {
        return image;
    }

    public Boolean getIsActive() {
        return isActive;
    }
}
