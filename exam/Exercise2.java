import java.util.ArrayList;
import java.util.List;

public class Exercise2{

    public static void main(String[] args) {

        BookShelf shelf = new BookShelf();

        shelf.add(new Book("Robotics", "Richard Murray"));
        shelf.add(new Book("Optimization based control", "Ahmed Kheddar"));
        shelf.add(new Book("Probabilistic Principal Component Analysis", "ME Tipping"));

        System.out.println("List all the Books on the BookShelf:");
        shelf.display();

        shelf.find("Robotics");
        
        System.out.println("Removing 'Optimization based control' from shelf.");

	shelf.remove("Impact-Aware robotics");
	shelf.remove("Optimization based control");

        System.out.println("Updated BookShelf:");
        shelf.display();
    }

}
