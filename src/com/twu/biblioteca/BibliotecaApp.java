package com.twu.biblioteca;

import java.io.*;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp application = new BibliotecaApp();
        application.welcome();
        application.showmenu();
        char option = 'q';
        do{
            try {
                option = (char) System.in.read();
                application.relayOptions(option);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while(option != 'q');
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
        System.out.println("1. List Books");
        System.out.println("Choose an option number or type 'q' to quit application.");
    }

    public void relayOptions(char option) {
        switch(option){
            case '1':
                this.listBooks();
                break;
        }
    }
}
