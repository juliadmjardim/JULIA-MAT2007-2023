import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Exercise2Test {

    private BookShelf shelf;

    public boolean containsString(final Exception e, String keyword)
    {
        if (e.getMessage() != null && e.getMessage().contains(keyword)) 
	{
          System.out.println("The exception is about: " +  keyword);
          return true; 
        }
	else
	{
   	  return false;	
	}
    }


    @Before
    public void setUp() {
        shelf = new BookShelf();
    }

    // Robustness Tests
    @Test(timeout = 200)
    public void testFindNonExistentBook() {
        assertNull(shelf.find("Non Existent Book"));
    }

    @Test(timeout = 200)
    public void testRemoveNonExistentBook() {
        shelf.remove("Non Existent Book"); // This shouldn't throw an error.
    }

    @Test(timeout = 200)
    public void testAddNullBook() {
        shelf.add(null);  // This shouldn't throw an error.
    }

    @Test(timeout = 200)
    public void testAddDuplicateBook() {
        Book book = new Book("Robotics", "Richard Murray");
        shelf.add(book);
        shelf.add(book);
	// This shouldn't throw an error.
    }

    // Correctness Tests
    @Test(timeout = 200)
    public void testBookConstructor() {
        Book book = new Book("Robotics", "Richard Murray");
        assertEquals("Robotics", book.getTitle());
        // Similarly, you can test other properties.
    }

    @Test(timeout = 200)
    public void testBookShelfConstructor() {
        assertNotNull(shelf);
    }

    // Efficiency
    @Test(timeout = 2000)
    public void testFindEfficiency() {
        for (int i = 10000; i <= 1000000; i += 100000) {
            shelf = new BookShelf();

            // Add books
            for (int j = 1; j <= i; j++) {
                shelf.add(new Book("Title" + j, "Author"));
            }

            // Time the find operation
            long startTime = System.nanoTime();
            shelf.find("Title" + (i + 1));  // Book doesn't exist to ensure full traversal
            long endTime = System.nanoTime();

	    double run_time = ((endTime - startTime) / 1_000_000.0);
            // System.out.println("Number of books: " + i + " Time taken (ms): " + (endTime - startTime) / 1_000_000.0);
	    assertTrue(run_time < 30.0);
        }
    }

}


