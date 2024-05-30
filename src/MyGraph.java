import java.util.ArrayList;

public class MyGraph {
    private int numOfVertices;
    private ArrayList<Integer>[] adjList;

    public MyGraph(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        this.adjList = new ArrayList[numOfVertices];
        for (int i = 0; i < numOfVertices; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int source, int destination) {
        validateVertex(source);
        validateVertex(destination);
        adjList[source].add(destination);
        adjList[destination].add(source);
    }

    public boolean hasEdge(int source, int destination) {
        validateVertex(source);
        validateVertex(destination);
        return adjList[source].contains(destination);
    }

    private void validateVertex(int index) {
        if (index < 0 || index >= numOfVertices)
            throw new IndexOutOfBoundsException("Vertex does not exist");
    }

    public void removeEdge(int source, int destination){
        validateVertex(source);
        validateVertex(destination);
        adjList[source].remove(Integer.valueOf(destination));
        adjList[destination].remove(Integer.valueOf(source));
    }

    public ArrayList<Integer> getNeighbors(int vertex) {
        validateVertex(vertex);
        return adjList[vertex];
    }

    public void printGraph() {
        for (int i = 0; i < numOfVertices; i++) {
            System.out.print("Vertex " + i + " connected to " );
            for (int neighbor : adjList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyGraph graph = new MyGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();

        System.out.println("Has edge between 0 and 1: " + graph.hasEdge(0, 1));
        System.out.println("Has edge between 0 and 3: " + graph.hasEdge(0, 3));

        graph.removeEdge(1, 4);
        System.out.println("After removing edge between 1 and 4:");
        graph.printGraph();
    }
}
