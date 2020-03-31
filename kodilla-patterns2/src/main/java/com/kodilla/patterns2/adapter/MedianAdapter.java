package com.kodilla.patterns2.adapter;

import com.kodilla.patterns2.adapter.libraryA.Book;
import com.kodilla.patterns2.adapter.libraryA.Classifier;
import com.kodilla.patterns2.adapter.libraryB.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<Book> bookSet) {

        Map<BookSignature, com.kodilla.patterns2.adapter.libraryB.Book> bookMap =
                new HashMap<>();
        for (com.kodilla.patterns2.adapter.libraryA.Book book : bookSet) {
            com.kodilla.patterns2.adapter.libraryB.Book bookB =
                    new com.kodilla.patterns2.adapter.libraryB.Book(book.getAuthor(),
                            book.getTitle(), book.getPublicationYear());

            bookMap.put(new BookSignature(book.getSignature()), bookB);
        }
        return medianPublicationYear(bookMap);
    }
}