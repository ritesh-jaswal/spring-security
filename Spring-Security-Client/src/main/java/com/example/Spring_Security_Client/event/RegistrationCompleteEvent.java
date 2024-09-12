package com.example.Spring_Security_Client.event;

import com.example.Spring_Security_Client.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent
{
    private User user;
    private String applicationUrl;

    public RegistrationCompleteEvent(User user,String applicationUrl)
    {
        super(user);

        this.user=user;
        this.applicationUrl=applicationUrl;
    }
}
