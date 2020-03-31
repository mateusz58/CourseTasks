package com.kodilla.patterns2.observer.forum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForumUser implements Observer {
    private  String username;
    private int updateCount;

    public ForumUser(String username) {
        this.username = username;
    }

    @Override
    public void update(ForumTopic forumTopic) {
        System.out.println(username + ": New messages in topic " + forumTopic.getName() + "\n" +
                " (total: " + forumTopic.getMessages().size() + " messages)");
        updateCount++;
    }
}
