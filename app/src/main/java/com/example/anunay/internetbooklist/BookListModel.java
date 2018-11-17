package com.example.anunay.internetbooklist;

/**
 * Created by Anunay on 19-02-2018.
 */

public class BookListModel {
    private String bookname;
    private String bookauthor;

    public BookListModel() {
    }
    public BookListModel(String bookname, String bookauthor) {

        this.bookname = bookname;
        this.bookauthor = bookauthor;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookauthor() {
        return bookauthor;
   }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }
}
