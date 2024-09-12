package com.example.Spring_Security_Client.model;

import lombok.Data;

@Data
public class PasswordModel
{
    private String email;

    private String oldPassword;

    private String newPassword;
}
