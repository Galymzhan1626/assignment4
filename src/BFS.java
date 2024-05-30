public class BFS {
    public void bfs(MyGraph graph, String startVertex) {
        boolean[] visited = new boolean[graph.getVertexCount()];
        String[] queue = new String[graph.getVertexCount()];
        int front = 0, rear = 0;
        queue[rear++] = startVertex;

        while (front != rear) {
            String vertex = queue[front++];
            int vertexIndex = getVertexIndex(graph, vertex);
            if (visited[vertexIndex]) {
                continue;
            }
            visited[vertexIndex] = true;
            System.out.print(vertex + " ");

            for (Edge edge : graph.getEdges()) {
                if (edge.getSource().equals(vertex) && !visited[getVertexIndex(graph, edge.getDestination())]) {
                    queue[rear++] = edge.getDestination();
                }
            }
        }
        System.out.println();
    }

    private int getVertexIndex(MyGraph graph, String vertex) {
        for (int i = 0; i < graph.getVertexCount(); i++) {
            if (graph.getVertices()[i].equals(vertex)) {
                return i;
            }
        }
        return -1;
    }
}
