package composite.iterating;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final String name;
    protected List<Node> children = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public Node(String name, Node... children) {
        this.name = name;
        this.children = List.of(children);
    }

    public Iterable<Node> breitenSuche() {
        return null;
    }

    public Iterable<Node> tiefenSuche() {
        return null;
    }

    public static void main(String[] args) {
        Node root = new Node("root",
                new Node("1",
                        new Node("1.1",
                                new Node("1.1.1"),
                                new Node("1.1.2")),
                        new Node("1.2",
                                new Node("1.2.1"),
                                new Node("1.2.2"))
                ),
                new Node("2",
                        new Node("2.1",
                                new Node("2.1.1"),
                                new Node("2.1.2")),
                        new Node("2.2",
                                new Node("2.2.1"),
                                new Node("2.2.2"))));

        for (Node node : root.breitenSuche())
            System.out.println(node);

        System.out.println();

        for (Node node : root.tiefenSuche())
            System.out.println(node);

        // Expected:
//        Breitensuche
//        Node[root]
//        Node[1]
//        Node[2]
//        Node[1.1]
//        Node[1.2]
//        Node[2.1]
//        Node[2.2]
//        Node[1.1.1]
//        Node[1.1.2]
//        Node[1.2.1]
//        Node[1.2.2]
//        Node[2.1.1]
//        Node[2.1.2]
//        Node[2.2.1]
//        Node[2.2.2]
//
//        Tiefensuche:
//        Node[root]
//        Node[1]
//        Node[1.1]
//        Node[1.1.1]
//        Node[1.1.2]
//        Node[1.2]
//        Node[1.2.1]
//        Node[1.2.2]
//        Node[2]
//        Node[2.1]
//        Node[2.1.1]
//        Node[2.1.2]
//        Node[2.2]
//        Node[2.2.1]
//        Node[2.2.2]

    }
}
