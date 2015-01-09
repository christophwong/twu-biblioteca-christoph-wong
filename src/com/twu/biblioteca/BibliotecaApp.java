package com.twu.biblioteca;

import java.io.*;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp application = new BibliotecaApp();
        application.welcome();
        application.showmenu();
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

            System.out.printf("%-32s%-32s%-32s\n", "Title", "Author", "Year Published");
            while ((line = reader.readLine()) != null){
                String[] details = line.split(", ");
                String title = details[0];
                String author = details[1];
                String publishYear = details[2];

                System.out.printf("%-32s%-32s%-32s\n", title, author, publishYear);
            }
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void showmenu() {
        System.out.println("List Books");
    }
}
