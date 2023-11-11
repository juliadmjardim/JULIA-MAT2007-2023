//Alicia del Prado Rebordinos – 6295981 - Exercise2
public class Book {
    //Private strings title and author.
    private String title;
    private String author;
    //Constructor.
    public Book (String title, String author){
        this.title = title;
        this.author = author;
    }
    //Title getter.
    public String getTitle(){
        return title;
    }
    //Override.
    public String toString(){
        return title +" by "+author;
    }
}
