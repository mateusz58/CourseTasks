package com.kodilla.patterns.strategy.social;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User millenials = new Millenials("Matt");
        User yGeneration = new YGeneration("Adam");
        User zGeneration = new ZGeneration("Janet");

        //When
        String mSocialPublisher = millenials.sharePost();
        System.out.println("Matt speak: " + mSocialPublisher);
        String ySocialPublisher = yGeneration.sharePost();
        System.out.println("Adam speak: " + ySocialPublisher);
        String zSocialPublisher = zGeneration.sharePost();
        System.out.println("Janet speak: " + zSocialPublisher);

        //Then
        assertEquals("I like Twitter", mSocialPublisher);
        assertEquals("I like Facebook", ySocialPublisher);
        assertEquals("I like Snapchat", zSocialPublisher);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User millenials = new Millenials("Matt");

        //When
        String mSocialPublisher = millenials.sharePost();
        System.out.println("Matt speak: " + mSocialPublisher);
        millenials.setSocialPublisher(new FacebookPublisher());
        mSocialPublisher = millenials.sharePost();
        System.out.println("Matt now speak: " + mSocialPublisher);

        //Then
        assertEquals("I like Facebook", mSocialPublisher);
    }
}
