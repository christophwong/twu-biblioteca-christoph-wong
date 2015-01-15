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
        }while(option != 3);

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
        System.out.println("3. Quit");
        System.out.println("Choose an option number");
    }

    public void relayOptions(int option) {
        if(option == 1){
            this.listBooks();
        }else if (option == 2){
            this.promptCheckOut();
        }
        else if (option == 3){
            System.out.println("Goodbye!");
        }
        else {
            System.out.println("Invalid option, please try again.");
        }

    }

    public void checkOut(int id){
        Book itemToCheckOut = library.bookList.get(id);
        System.out.println("Thank you! Enjoy the book");
        library.checkOut(itemToCheckOut);
    }

    public void promptCheckOut(){
        System.out.println("Input the ID of the book that you want to check out:");
        Scanner idScanner = new Scanner(System.in);
        int id = idScanner.nextInt();
        this.checkOut(id);
    }
}
