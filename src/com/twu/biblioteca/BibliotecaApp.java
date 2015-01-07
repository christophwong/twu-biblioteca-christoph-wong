package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

    }

    public void run(){
        BibliotecaApp application = new BibliotecaApp();
        application.welcome();
    }

    public void welcome(){
        System.out.println("Welcome to the Biblioteca Application");
    }

    public void listBooks(){
        System.out.println("The Old Man and The Sea");
        System.out.println("The Stranger");
    }
}
