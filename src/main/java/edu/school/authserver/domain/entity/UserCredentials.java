package edu.school.authserver.domain.entity;

import javax.persistence.*;

@Entity
public class UserCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String uidPk;

    @Column(unique = true)
    private String username;
    private String password;
    private String name;

    public String getUidPk() {
        return uidPk;
    }

    public void setUidPk(String uidPk) {
        this.uidPk = uidPk;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
