package com.twu.biblioteca;

import java.io.*;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) throws IOException{
        BibliotecaApp application = new BibliotecaApp();
        application.welcome();
        application.showmenu();
        int option;
        do {
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            application.relayOptions(option);
        }while(option != 2);

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
