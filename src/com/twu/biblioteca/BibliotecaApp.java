package com.twu.biblioteca;

import java.io.*;
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
        }while(option != 2);

    }


    public void welcome(){
        System.out.println("Welcome to the Biblioteca Application");
    }

    public void listBooks(){
        this.library.listBooks();
    }

    public void showmenu() {
        System.out.println("1. List Books");
        System.out.println("2. Quit");
        System.out.println("Choose an option number");
    }

    public void relayOptions(int option) {
        if(option == 1){
            this.listBooks();
        }else if (option == 2){
            System.out.println("Goodbye!");
        }
        else {
            System.out.println("Invalid option, please try again.");
        }

    }
}
