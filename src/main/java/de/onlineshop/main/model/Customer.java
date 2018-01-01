package de.onlineshop.main.model;

import java.io.Serializable;

/**
 * Description
 *
 * @author Valery Oster
 * @version 1.0
 */
public class Customer implements Serializable {

    private Long id;
    private String email;
    private String password;

    public Customer() {
    }

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }

public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
