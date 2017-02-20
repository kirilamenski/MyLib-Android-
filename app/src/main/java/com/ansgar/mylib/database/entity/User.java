package com.ansgar.mylib.database.entity;

import com.ansgar.mylib.util.BitmapCover;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;

/**
 * Created by kirill on 24.1.17.
 */

@DatabaseTable(tableName = "users")
public class User implements Serializable {

    @SerializedName("id")
    @DatabaseField(generatedId = true, columnName = "id")
    private int mId;
    @SerializedName("firstName")
    @DatabaseField(columnName = "first_name")
    private String mFirstName;
    @SerializedName("lastName")
    @DatabaseField(columnName = "last_name")
    private String mLastName;
    @SerializedName("coverBytes")
    @DatabaseField(columnName = "cover_bytes")
    private String mCoverBytes;
    @SerializedName("email")
    @DatabaseField(columnName = "email")
    private String mEmail;
    @SerializedName("password")
    @DatabaseField(columnName = "password")
    private String mPassword;
    @SerializedName("hasSynchronized")
    @DatabaseField(columnName = "synchronized")
    private int mHasSynchronized;

    @ForeignCollectionField
    ForeignCollection<Author> mAuthorsList;
    //    @ForeignCollectionField
//    ForeignCollection<Book> mBooks;
    @SerializedName("authors")
    private List<Author> mAuthors;

    public User() {

    }

    public User(int id, String firstName, String lastName, String cover, String email, String password, int hasSynchronized, List<Author> authors) {
        mId = id;
        mFirstName = firstName;
        mLastName = lastName;
        mCoverBytes = cover;
        mEmail = email;
        mPassword = password;
        mHasSynchronized = hasSynchronized;
        mAuthors = authors;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public List<Author> getAuthorsList() {
        List<Author> authors = new ArrayList<>();
        if (mAuthorsList == null) {
            return authors;
        }
        for (Author author : mAuthorsList) {
            authors.add(author);
        }
        return authors;
    }
//
//    public List<Book> getBooks() {
//        List<Book> books = new ArrayList<>();
//        if (mBooks == null) {
//            return books;
//        }
//        for (Book book : mBooks) {
//            books.add(book);
//        }
//        return books;
//    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getCoverBytes() {
        return mCoverBytes;
    }

    public void setCoverBytes(String coverBytes) {
        mCoverBytes = coverBytes;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public Bitmap getBitmap() {
        return BitmapCover.getBitmapCover(mCoverBytes);
    }

    public int getHasSynchronized() {
        return mHasSynchronized;
    }

    public List<Author> getAuthors() {
        return mAuthors;
    }

    public void setAuthors(List<Author> authors) {
        mAuthors = authors;
    }

    public void setHasSynchronized(int hasSynchronized) {
        mHasSynchronized = hasSynchronized;
    }
}
