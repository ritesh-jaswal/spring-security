package com.example.Spring_Security_Client.event.listener;

import com.example.Spring_Security_Client.entity.User;
import com.example.Spring_Security_Client.event.RegistrationCompleteEvent;
import com.example.Spring_Security_Client.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j //TO PRINT LOGGER
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent>
{
    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event)
    {
        //CREATE THE VERIFICATION TOKEN FOR USER WITH LINK
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);

        //SEND MAIL TO USER
        String url = event.getApplicationUrl()
                + "/verifyRegistration?token="
                + token;

        //SEND VERIFICATION EMAIL
        log.info("Click the Link to Verify Your Account: {}",url);
    }
}
