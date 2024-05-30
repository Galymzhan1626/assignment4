public class Main {
    public static void main(String[] args) {
        MyGraph graph = new MyGraph(5, 10);
        graph.addVertex("Almaty");
        graph.addVertex("Nur-Sultan");
        graph.addVertex("Shymkent");
        graph.addVertex("Karaganda");
        graph.addVertex("Aktobe");

        graph.addEdge("Almaty", "Nur-Sultan", 1200);
        graph.addEdge("Almaty", "Shymkent", 700);
        graph.addEdge("Nur-Sultan", "Karaganda", 200);
        graph.addEdge("Shymkent", "Aktobe", 900);
        graph.addEdge("Karaganda", "Aktobe", 1000);
        graph.addEdge("Nur-Sultan", "Aktobe", 1700);

        graph.printGraph();

        System.out.println("Has edge between Almaty and Nur-Sultan: " + graph.hasEdge("Almaty", "Nur-Sultan"));
        System.out.println("Has edge between Almaty and Aktobe: " + graph.hasEdge("Almaty", "Aktobe"));

        graph.removeEdge("Nur-Sultan", "Aktobe");
        System.out.println("After removing edge between Nur-Sultan and Aktobe:");
        graph.printGraph();
    }
}
