package com.example.akki.daybox_admin_portal.pojo;

/**
 * Created by Akki on 07-06-2017.
 */

public class SalesPersonDTO {

    private String mobile;
    private String email;
    private Boolean pin_exists;
    private int id;
    private String name;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getPin_exists() {
        return pin_exists;
    }

    public void setPin_exists(Boolean pin_exists) {
        this.pin_exists = pin_exists;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
