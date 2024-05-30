public class MyGraph {
    private String[] vertices;
    private Edge[] edges;
    private int vertexCount;
    private int edgeCount;

    public MyGraph(int maxVertices, int maxEdges) {
        vertices = new String[maxVertices];
        edges = new Edge[maxEdges];
        vertexCount = 0;
        edgeCount = 0;
    }

    public void addVertex(String city) {
        vertices[vertexCount++] = city;
    }

    public void addEdge(String source, String destination, int weight) {
        edges[edgeCount++] = new Edge(source, destination, weight);
    }

    public boolean hasEdge(String source, String destination) {
        for (int i = 0; i < edgeCount; i++) {
            if (edges[i].getSource().equals(source) && edges[i].getDestination().equals(destination)) {
                return true;
            }
        }
        return false;
    }

    public void removeEdge(String source, String destination) {
        for (int i = 0; i < edgeCount; i++) {
            if (edges[i].getSource().equals(source) && edges[i].getDestination().equals(destination)) {
                edges[i] = edges[edgeCount - 1]; // Перемещаем последний элемент на место удаляемого
                edgeCount--;
                break;
            }
        }
    }

    public void printGraph() {
        for (int i = 0; i < vertexCount; i++) {
            String vertex = vertices[i];
            System.out.print("Vertex " + vertex + " connected to: ");
            for (int j = 0; j < edgeCount; j++) {
                if (edges[j].getSource().equals(vertex)) {
                    System.out.print(edges[j].getDestination() + "(" + edges[j].getWeight() + ") ");
                }
            }
            System.out.println();
        }
    }
}
