package com.yzh.oauth2.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    Long id;

    String name;

    String phone;

    String password;
}
