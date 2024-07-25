package finalprojectfasttrackit.finalproject.Model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="username")
    String username;
    @Column(name ="password")
    String password;
    @Column(name="isactive")
    boolean isactive;
    @Column(name="isbuyer")
    boolean isbuyer;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public boolean isIsbuyer() {
        return isbuyer;
    }

    public void setIsbuyer(boolean isbuyer) {
        this.isbuyer = isbuyer;
    }
}
