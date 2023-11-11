//Alicia del Prado Rebordinos – 6295981 - Exercise2
import java.util.ArrayList;
public class BookShelf {
    //Books are stored in the ArrayList named library.
    private ArrayList<Book> library;
    //Constructor.
    public BookShelf(){
        library = new ArrayList<>();
    }
    /*
    Adds a book to the shelf.
    Before adding the book, it checks if it or the title aren't null.
     */
    public void add(Book book){
        if (book != null && book.getTitle() != null){
            library.add(book);
        }
    }
    /*
    Removes a book by its title.
    Initializes a variable corresponding with the book that has to be removed called 'removed'.
    Iterates through the books in the library and looks for the book that has to be removed
    by checking if the titles match.
    If the titles match, the variable 'removed' is saved as the book to be removed.
    If the titles don't match the 'removed' variable will remain null.
    Therefore, if 'removed' isn't null then the book is removed from the library.
     */
    public void remove(String title){
        Book removed = null;
        for (Book book : library){
            if (book.getTitle().equals(title)){
                removed = book;
                library.remove(removed);
                break;
            }
        }
        if (removed != null){
            library.remove(removed);
        }else{
            System.out.println("The book couldn't be found on the shelf.");
        }
    }
    /*
    Find a book by its title.
    Open a loop that goes through all the books in the library and checks if their titles match with the provided one.
    If this is the case the book is found.
     */
    public Book find(String title){
        for (Book book : library){
            if (book.getTitle().equals(title)){
                System.out.println("The book '"+title+"' was found.");
                return book;
            }
        }
        System.out.println("The book '"+title+"' couldn't be found.");
        return null; //if the book isnt found
    }
    /*
    Prints all the books on the shelf.
    First it checks if the ArrayList is empty.
    Then it iterates through all the books in the library
    and prints their details using the toString() method from the Book class.
     */
    public void display(){
        if (library.isEmpty()){
            System.out.println("The library is empty");
            return;
        }
        for (Book book : library){
            System.out.println(book);
        }
    }
}
