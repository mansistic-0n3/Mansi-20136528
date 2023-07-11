package com;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int isbnno;
    private String bookName;
    private String author;

    public int getIsbnno() {
        return isbnno;
    }

    public void setIsbnno(int isbnno) {
        this.isbnno = isbnno;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class Lib {
    private ArrayList<Book> books = new ArrayList<Book>();

    public void addBook(Book add) {
        books.add(add);
    }

    public boolean isEmpty() {
        return books.isEmpty();
    }

    public ArrayList<Book> viewAllBooks() {
        return books;
    }

    public ArrayList<Book> viewBooksByAuthor(String author) {
        ArrayList<Book> booksByAuthor = new ArrayList<Book>();

        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                booksByAuthor.add(book);
            }
        }

        return booksByAuthor;
    }

    public int countBook(String bname) {
        int count = 0;

        for (Book book : books) {
            if (book.getBookName().equalsIgnoreCase(bname)) {
                count++;
            }
        }

        return count;
    }
}

public class BookInfo {
    public static void main(String[] args) {
        Lib lib = new Lib();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("1. Add Book");
            System.out.println("2. Display all book details");
            System.out.println("3. Search Book by author");
            System.out.println("4. Count number of books ( by book name )");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Book newBook = new Book();
                    System.out.println("Enter the ISBN no:");
                    newBook.setIsbnno(scanner.nextInt());
                    System.out.println("Enter the book name:");
                    scanner.nextLine(); 
                    newBook.setBookName(scanner.nextLine());
                    System.out.println("Enter the author name:");
                    newBook.setAuthor(scanner.nextLine());

                    lib.addBook(newBook);
                    break;

                case 2:
                    ArrayList<Book> all = lib.viewAllBooks();
                    if (all.isEmpty()) {
                        System.out.println("The list is empty");
                    } else {
                        for (Book book : all) {
                            System.out.println("ISBN no: " + book.getIsbnno());
                            System.out.println("Book name: " + book.getBookName());
                            System.out.println("Author name: " + book.getAuthor());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter the author name:");
                    scanner.nextLine();
                    String authorName = scanner.nextLine();
                    ArrayList<Book> bookAuthor = lib.viewBooksByAuthor(authorName);
                    if (bookAuthor.isEmpty()) {
                        System.out.println("None of the book published by the author " + authorName);
                    } else {
                        for (Book book : bookAuthor) {
                        	 System.out.println("--------------------------------------");
                            System.out.println("ISBN no: " + book.getIsbnno());
                            System.out.println("Book name: " + book.getBookName());
                            System.out.println("Author name: " + book.getAuthor());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Enter the book name:");
                    scanner.nextLine();
                    String bookName = scanner.nextLine();
                    int count = lib.countBook(bookName);
                    System.out.println("Count is " + count);
                    break;

                case 5:
                    System.out.println("Thakyou...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 5);

        scanner.close();
    }
}