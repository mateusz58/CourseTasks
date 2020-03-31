package com.kodilla.patterns2.adapter;

import com.kodilla.patterns2.adapter.libraryB.Book;
import com.kodilla.patterns2.adapter.libraryB.BookSignature;
import com.kodilla.patterns2.adapter.libraryB.BookStatistics;
import com.kodilla.patterns2.adapter.libraryB.Statistics;

import java.util.Map;

public class MedianAdaptee implements BookStatistics {

    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books) {
        Statistics statistics = new Statistics();
        return statistics.averagePublicationYear(books);
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, Book> books) {
        Statistics statistics = new Statistics();
        return statistics.medianPublicationYear(books);
    }
}
