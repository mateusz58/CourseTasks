package com.kodilla.stream.forumuser;

import lombok.*;

import java.time.LocalDate;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ForumUser {
    private  int id;
    private  String username;
    private  String realname;
    private  LocalDate birthDate;
    private  char gender;
    private int numberOfPosts;
}
