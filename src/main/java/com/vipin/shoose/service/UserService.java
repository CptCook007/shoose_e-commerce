package com.vipin.shoose.service;

import com.vipin.shoose.dto.UserDto;
import com.vipin.shoose.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();
    public boolean verifyOtp(UserDto userDto, String otp);

    void blockUser(Long id);

    void unBlockUser(Long id);

    void sendOtp(UserDto userDto);

    void setNewPassword(UserDto userDto);

    void resendMail(UserDto userDto);

    void changeUsername(User user, String newUsername);

    User getCurrentUser();


    boolean  checkCurrentPassword(User user, String oldPassword);

    void changePassword(User user, String newPassword);
}
