package com.kodilla.patterns.prototype;

import com.kodilla.patterns.Generators.LocalDateGenerator;
import com.kodilla.patterns.Generators.WordGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LibraryTestSuite {

    Library theListLibrary;
    Book book1;
    Book book2;

    @BeforeEach
    void setUp() {
        theListLibrary = new Library(WordGenerator.generateRandomWord());
        book1 = Book.builder()
            .author(WordGenerator.generateRandomWord())
            .publicationYear(LocalDateGenerator.generateRandomLocalDate().getYear())
            .title(WordGenerator.generateRandomWord())
            .build();
        book2 = Book.builder()
            .author(WordGenerator.generateRandomWord())
            .publicationYear(LocalDateGenerator.generateRandomLocalDate().getYear())
            .title(WordGenerator.generateRandomWord())
            .build();
        Set<Book> books = new HashSet<Book>(Arrays.asList(book1, book2));
        theListLibrary.setBooks(books);
    }

    @Test
    void testWithoutChangingAttributes() throws CloneNotSupportedException {

        //making a shallow clone of object board
        Library shallowCloneLibrary = null;
        shallowCloneLibrary = theListLibrary.shallowCopy();

        //making a deep copy of object board
        Library deepClonedTheListLibrary = null;
        deepClonedTheListLibrary = theListLibrary.deepCopy();
        //When

        //Then
        assertEquals(shallowCloneLibrary.getBooks().size(), theListLibrary.getBooks().size());
        assertEquals(deepClonedTheListLibrary.getBooks().size(), theListLibrary.getBooks().size());
        assertEquals(shallowCloneLibrary.getBooks(), theListLibrary.getBooks());
        assertEquals(deepClonedTheListLibrary.getBooks(), theListLibrary.getBooks());
    }

    @Test
    void testChangingAttributes() throws CloneNotSupportedException {

        //making a shallow clone of object board
        Library shallowCloneLibrary = null;
        shallowCloneLibrary = theListLibrary.shallowCopy();

        //making a deep copy of object board
        Library deepClonedTheListLibrary = null;
        deepClonedTheListLibrary = theListLibrary.deepCopy();
        //When
        theListLibrary.getBooks().remove(book1);

        //Then
        assertEquals(shallowCloneLibrary.getBooks().size(), theListLibrary.getBooks().size());
        assertNotEquals(deepClonedTheListLibrary.getBooks().size(), theListLibrary.getBooks().size());
        assertEquals(shallowCloneLibrary.getBooks(), theListLibrary.getBooks());
        assertNotEquals(deepClonedTheListLibrary.getBooks(), theListLibrary.getBooks());
    }

    @AfterEach
    void tearDown() {
    }
}
