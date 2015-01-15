package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    private Library library;

    public BibliotecaApp(){
        this("books.txt");
    }
    public BibliotecaApp(String fileName){
        this.library = new Library(fileName);
    }

    public static void main(String[] args){
        BibliotecaApp application = new BibliotecaApp();
        application.welcome();
        application.showmenu();
        int option;
        do {
            Scanner scanner = new Scanner(System.in);
            if(scanner.hasNextInt()) {
                option = scanner.nextInt();
                application.relayOptions(option);
            }else{
                System.out.println("Please enter a number");
                option = 8;
            }
        }while(option != 4);

    }


    public void welcome(){
        System.out.println("Welcome to the Biblioteca Application");
    }

    public void listBooks(){
        library.listBooks();
    }

    public void showmenu() {
        System.out.println("1. List Books");
        System.out.println("2. Checkout Books");
        System.out.println("3. Return Books");
        System.out.println("4. Quit");
        System.out.println("Choose an option number");
    }

    public void relayOptions(int option) {
        if(option == 1){
            this.listBooks();
        }else if (option == 2){
            this.promptCheckOut();
        } else if (option == 3){
            this.promptReturn();
        }
        else if (option == 4){
            System.out.println("Goodbye!");
        }
        else {
            System.out.println("Invalid option, please try again.");
        }

    }

    private void promptReturn() {
        library.listCheckedOutBooks();
        System.out.println("Input the ID of the book that you want to return:");
        Scanner idScanner = new Scanner(System.in);
        int id = idScanner.nextInt();
        this.returnBook(id);
    }

    private void returnBook(int id){
        if(id < library.checkedOutBookList.size()){
            Book itemToReturn = library.checkedOutBookList.get(id);
            System.out.println("Thank you for returning the book: " + itemToReturn.title);
            library.returnBook(itemToReturn);
        } else{
            System.out.println("Invalid Selection, if you book is not on the list, please check that you are at the correct library.");
            showmenu();
        }
    }

    public void checkOut(int id){
        if(id < library.bookList.size()) {
            Book itemToCheckOut = library.bookList.get(id);
            System.out.println("Thank you! Enjoy the book");
            library.checkOut(itemToCheckOut);
        } else{
            System.out.println("Book is unavailable, please try again");
            showmenu();
        }
    }

    public void promptCheckOut(){
        System.out.println("Input the ID of the book that you want to check out:");
        Scanner idScanner = new Scanner(System.in);
        int id = idScanner.nextInt();
        this.checkOut(id);
    }
}
