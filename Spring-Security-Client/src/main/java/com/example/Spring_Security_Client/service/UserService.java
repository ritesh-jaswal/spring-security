package com.example.Spring_Security_Client.service;

import com.example.Spring_Security_Client.entity.User;
import com.example.Spring_Security_Client.entity.VerificationToken;
import com.example.Spring_Security_Client.model.UserModel;

import java.util.Optional;

public interface UserService
{
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);

    User findUserByEmail(String email);

    void createPasswordResetTokenForUser(User user, String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    void changePassword(User user, String newPassword);

    boolean checkIfOldPasswordIsValid(User user, String oldPassword);
}
