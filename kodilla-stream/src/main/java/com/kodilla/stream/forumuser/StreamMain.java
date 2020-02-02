package com.kodilla.stream.forumuser;

import com.kodilla.stream.Generators.LocalDateGenerator;
import com.kodilla.stream.Generators.NumberGenerator;
import com.kodilla.stream.Generators.WordGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        Collection<ForumUser> forumUserList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                forumUserList.add(ForumUser.builder()
                    .id(NumberGenerator.generateRandomNumber(1))
                    .birthDate(LocalDateGenerator.generateRandomLocalDate())
                    .gender('M')
                    .realname(WordGenerator.generateRandomWord())
                    .username(WordGenerator.generateRandomWord())
                    .numberOfPosts(NumberGenerator.generateRandomNumber(1))
                    .build());
            } else {
                forumUserList.add(ForumUser.builder()
                    .id(NumberGenerator.generateRandomNumber(1))
                    .birthDate(LocalDateGenerator.generateRandomLocalDate())
                    .gender('K')
                    .realname(WordGenerator.generateRandomWord())
                    .username(WordGenerator.generateRandomWord())
                    .numberOfPosts(NumberGenerator.generateRandomNumber(1))
                    .build());
            }
        }
        Forum forum =
            Forum.builder()
                .forumUsers(forumUserList).build();
        forum.getForumUsers().stream().
            filter(s -> s.getBirthDate().getYear() < 1999).
            filter(s -> s.getGender() == 'M').
            filter(s -> s.getNumberOfPosts() > 1)
            .collect(Collectors.toMap(x -> x.getId(), x -> x))
            .forEach((key, value) -> System.out.println("Key:" + key
                + " Value username:" + value.getUsername()
                + " Value birthDate:" + value.getBirthDate()
                + " Value gender: " + value.getGender()
                + " Value realName: " + value.getRealname()
                + " Value postsNumber: " + value.getNumberOfPosts()));
    }
}
