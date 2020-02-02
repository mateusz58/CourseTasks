package com.kodilla.spring.forumuser;

import lombok.Builder;
import lombok.Getter;

import java.util.Collection;

@Getter
@Builder
public class Forum {

    private final Collection<ForumUser>forumUsers;
}
