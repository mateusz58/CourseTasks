package com.kodilla.generators;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;

import java.util.Random;

import static java.nio.charset.Charset.forName;

public class EasyRandomConfigure {

    private static EasyRandom  configuration() {
        return new EasyRandom( new EasyRandomParameters()
                .seed(123L)
                .excludeField(FieldPredicates.named("id"))
                .objectPoolSize(100)
                .randomizationDepth(3)
                .charset(forName("UTF-8"))
                .stringLengthRange(5, 50)
                .collectionSizeRange(1, 10)
                .scanClasspathForConcreteTypes(true)
                .overrideDefaultInitialization(false)
                .ignoreRandomizationErrors(true));
    }

    public static <T> T fillObject(Class<T> className) {
        T object = configuration().nextObject(className);
        return (T) object;
    }
}
