package com.kodilla.patterns2.adapter;

import com.kodilla.patterns2.adapter.libraryA.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<Book> bookA = new HashSet<>();
        bookA.add(new Book("Adam Mickiewicz",
                "Pan Tadeusz",
                1998,
                "AMPT123456"));
        bookA.add(new Book("Henryk Sienkiewicz",
                "Potop",
                1980,
                "HSP765432"));
        bookA.add(new Book("Jan Brzechwa",
                "Akademia Pana Kleksa",
                2000,
                "JBAPK987564"));
        bookA.add(new Book("Aleksander Fredro",
                "Zemsta",
                1977,
                "AFZ857463"));

        //When
        int median = medianAdapter.publicationYearMedian(bookA);

        //Then
        assertEquals(1998, median);
    }

}