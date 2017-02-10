package com.ansgar.mylib.database.dao;

import com.ansgar.mylib.database.entity.Book;

import java.io.File;
import java.util.List;

import rx.Observable;

/**
 * Created by kirill on 24.1.17.
 */

public interface BookDao {

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(Book book);

    List<Book> getAllBooks();

    List<Book> getByGenre(String genre);

    List<Book> getBooksFromReadingList(boolean inList);

    List<Book> getBooksByReadValue(int read);

    Book getBookById(long id);

    File getPhotoFile(Book book);

    Observable<List<Book>> getUserBooks();

    Observable<List<Book>> getUserBooksByGenre(String genre);

    Observable<List<Book>> getUserBooksFromReadingList(boolean inList);

    Observable<List<Book>> getUserBooksByReadValue(int read);

    Observable<List<Book>> getUserBooksByAuthorId(int authorId);

}
