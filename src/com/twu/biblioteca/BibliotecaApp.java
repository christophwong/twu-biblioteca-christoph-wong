package com.twu.biblioteca;

import java.io.*;

public class BibliotecaApp {

    public static void main(String[] args) {

    }

    public void run(){
        BibliotecaApp application = new BibliotecaApp();
        application.welcome();
        application.listBooks();
    }

    public void welcome(){
        System.out.println("Welcome to the Biblioteca Application");
    }

    public void listBooks(){
        try {
            File bookList = new File("books.txt");
            FileReader fileReader = new FileReader(bookList);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;

            while ((line = reader.readLine()) != null){
                line = line.split(",")[0];
                System.out.println(line);
            }
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
