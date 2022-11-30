package iterator;

import java.util.*;

public class Node {
    private final String name;
    private List<Node> children = new ArrayList<>();
    public Node(String name) {
        this.name = name;
    }
    public Node(String name, Node... children) {
        this.name = name;
        this.children.addAll(Arrays.asList(children));
    }
    public String getName() {
        return this.name;
    }
    public List<Node> getChildren() {
        return this.children;
    }
    public Iterable<Node> breadthFirstSearch() {
        return () -> new NodeIterator(this, true);
    }
    public Iterable<Node> depthFirstSearch() {
        return () -> new NodeIterator(this, false);
    }
    @Override
    public String toString() {
        return "Node[" + this.name + "]";
    }

    static class NodeIterator implements Iterator<Node> {
        private final Deque<Iterator<Node>> iterators = new ArrayDeque<>();
        private final boolean breadthFirst;
        public NodeIterator(Node node, boolean breadthFirst) {
            this.iterators.add(Collections.singleton(node).iterator());
            this.breadthFirst = breadthFirst;
        }
        @Override
        public boolean hasNext() {
            return ! this.iterators.isEmpty();
        }
        @Override
        public Node next() {
            Iterator<Node> iterator = this.iterators.removeFirst();
            Node node = iterator.next();
            if (iterator.hasNext())
                this.iterators.addFirst(iterator);
            if (! node.getChildren().isEmpty()) {
                if (this.breadthFirst)
                    this.iterators.addLast(node.getChildren().iterator());
                else
                    this.iterators.addFirst(node.getChildren().iterator());
            }
            return node;
        }
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
        for (Node node : root.breadthFirstSearch())
            System.out.println(node);
        System.out.println();
        for (Node node : root.depthFirstSearch())
            System.out.println(node);
    }
}