//Julia Vieira Dal Maso Jardim
//i6289351
//Exercise 2

import java.util.List;
import java.util.ArrayList;

public class Exercise2 {
    public static void main(String[] args) {
        Bookshelf myShelf = new Bookshelf(); //Creates an instance of Bookshelf  called myShelf
        myShelf.display();
        Book book1 = new Book("The Way of Kings", "Brandon Sanderson"); //Creates a Book-book1
        myShelf.addBook(book1); //Adds book1 to myShelf
        Book book2= new Book("Klara and the Sun", "Kazuo Ishiguro");
        myShelf.addBook(book2);
        Book book3= new Book("The Body Keeps the Score", "Bessel van Der Kolk");
        myShelf.addBook(book3);
        myShelf.display();
        myShelf.remove("The Way of Kings"); //Removes book by  title
        myShelf.findBook("The Way of Kings");
        System.out.println(myShelf.findBook("The Body Keeps the Score"));
    }
static class Book{ //class for books

     final String title;
     final String author;
     public Book(String title, String author) {//constructor
         if (title.isEmpty()) {
             throw new IllegalArgumentException("Book title cannot be empty.");
         }
         this.title = title;
         this.author= author;
     }

     public String getTitle() {//Getter for title
         return title;
     }

    @Override
    public String toString() { //Overrides default toString that returns representation of  memory address
        return "Title: " + title + ", Author: " + author; //returns instead meaningful information
    }

    }

 static class Bookshelf{
     private List<Book> bookShelf = new ArrayList<>(); //Creates arraylist called bookshelf

     public void addBook(Book book) { //Adds book
         bookShelf.add(book);
     }
     public void remove(String title) { //Iterates through bookshelf
         for (Book book : bookShelf) {
             if (book.getTitle().equals(title)) { //checks if title corresponds to given title
                 bookShelf.remove(book); //if it does, removes book
                 return;
             }
        }
    }

    public Book findBook(String title){ //Returns book information when given title
        System.out.println();
         for (Book book : bookShelf){ //Iterates through elements in bookShelf and returns each books
             if (book.getTitle().equals(title)){
                 System.out.println("The book " + title + " was found:");
                 return book;
             }
         }
        System.out.println("The book " + title + " was not found.");
         return null;
    }
     public void display() { //Display all books in shelf

         System.out.println();
         if (bookShelf.isEmpty()) { //If bookshelf is empty returns that
             System.out.println("myShelf is empty.");
         } else {
             System.out.println("myShelf contains:");
             for (Book book : bookShelf) { //Otherwise returns books in shelf
                 System.out.println(book);
             }
         }

     }
}

}