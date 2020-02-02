package com.kodilla.spring.forumuser;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ForumUser {

    private final String userName;

    public ForumUser() {
        this.userName = "John Smith";
    }
}

