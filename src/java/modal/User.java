package modal;

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

    public User(Integer id, String username, String password, String image, Boolean isActive) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.image = image;
        this.isActive = isActive;
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
