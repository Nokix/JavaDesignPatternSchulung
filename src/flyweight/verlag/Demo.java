package flyweight.verlag;

import flyweight.Book;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Book book1 = new Book(1234, "Goethes Faust", "Goethe", "Reclam", new Date(0), "München");
        Book book2 = new Book(4567, "Goethes Fuß", "Goethe", "Reclam", new Date(0), "München");

        System.out.println();
    }
}
