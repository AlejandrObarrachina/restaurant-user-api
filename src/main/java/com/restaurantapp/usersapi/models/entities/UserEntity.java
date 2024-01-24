package com.restaurantapp.usersapi.models.entities;
import jakarta.persistence.*;

@Entity(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ida;
    private String username;
    private String email;
    private String password;
    private String profilePic;

    //private Date creationDate;

    public UserEntity() {
    }

    public UserEntity(Long id, String username, String email, String password, String profilePic) {
        this.ida = ida;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilePic = profilePic;
    }

    public UserEntity(String username, String email, String password, String profilePic) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilePic = profilePic;
    }

    public Long getId() {
        return ida;
    }

    public void setId(Long id) {
        this.ida = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }
}
