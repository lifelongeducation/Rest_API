package com.sql_injection.injection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Client {
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Client() {
    }

    public Client(Long id, String name) {
        this.id = id;
        this.name = name;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


}