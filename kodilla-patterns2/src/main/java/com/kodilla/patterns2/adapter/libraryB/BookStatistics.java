package com.kodilla.patterns2.adapter.libraryB;

import java.util.Map;

public interface BookStatistics {

    int averagePublicationYear(Map<BookSignature, Book> books);
    int medianPublicationYear(Map<BookSignature, Book> books);
}