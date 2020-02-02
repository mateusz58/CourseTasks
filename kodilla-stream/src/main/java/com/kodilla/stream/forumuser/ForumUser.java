package com.kodilla.stream.forumuser;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class ForumUser {
    private final int id;
    private final String username;
    private final String realname;
    private final LocalDate birthDate;
    private final char gender;
    private int numberOfPosts;
}

