package com.kodilla.stream.forumuser;

import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Forum {

    @Builder.Default
    private  Collection<ForumUser>forumUsers = new ArrayList<>();
}

