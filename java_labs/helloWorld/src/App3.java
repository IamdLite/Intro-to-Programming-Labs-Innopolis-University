import java.io.*;
import java.util.Scanner;


class Author {

    private String name = new String();
    private String email = new String();
    private String gender = new String();
    

    Author(){
        this.name = "Esdras";
        this.email = "my@email.com";
        this.gender = "male";
    }

    Author(String name, String email, String gender){
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getGender(){
        return this.gender;
    }

    @Override
    public String toString(){
        return "{" +
                "name='" + name + '\'' + ", email='"
                + email + "', gender='" + gender + "'}\n"
        ;
    }

}

class Book{
    private String name;
    private Author author =  new Author();
    private double price;
    private int qty;

    Book(){};

    Book(String name, Author author, double price, int qty){
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public String getName(){
        return this.name;
    }

    public Author getAuthor(){
        return this.author;
    }

    public double getPrice(){
        return this.getPrice();
    }

    public int getQty(){
        return this.qty;
    }

    public void setQty(int quantity){
        this.qty = quantity;
    }

    @Override
    public String toString(){
        return "{" +
                "name='" + name + '\'' + ", author='"
                + author.toString() + "', price=" + price + ", quantity="
                + qty + "}"
        ;
    }
  }

  class Library{

    Book[] books = new Book[5];

    Library(){

        for(int i=0; i<5; i++){
            Author author = new Author("author"+i+1, "email@"+i, "prefer not to say");
            Book book = new Book("book"+i+1, author, 100.0*i+1,5+i+1);
            books[i] = book;
        }
    }


    
    public void printBooks(){

    for(int i=0; i<5; i++){
        System.out.println(books[i]);
    }

  }

  }

public class App3 {
    
public static void main(String[] args){

   
    // Author author = new Author();
    // Book book = new Book();
    Library library = new Library();;

    
    // System.out.println("New book object: " + book.toString());
    // System.out.println("New author object: " + author.toString());
    library.printBooks();
    


}











}
