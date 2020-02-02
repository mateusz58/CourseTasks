package com.kodilla.stream.beautifier;

public class StreamMain {

    public static void main(String args[])
    {
        PoemBeautifier poemBeautifier=new PoemBeautifier();

        String l1=poemBeautifier.beautify("Beutify",(s->s.toUpperCase()));

        String l2=poemBeautifier.beautify("Beutify",(s->s.replace("e","z")));

        String l3=poemBeautifier.beautify("Beutify",(s->s.replace("B","A")));
    }
}
