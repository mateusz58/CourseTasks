package com.kodilla.spring.forumuser;

import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Forum {

    @Builder.Default
    private final Collection<ForumUser>forumUsers = new ArrayList<>();
}
