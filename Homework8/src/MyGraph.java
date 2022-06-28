import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyGraph<T> implements DynamicGraph {

    ArrayList<Vertex> vertexList;
    int numVertices = 0;
    LinkedList<Vertex> adjacencyList[];
    List<Edge>[] edgeList;
    int edgeSize = 0;
    public double adjacencyMatrix[][] = new double[99][99];
    int IDofVertex = 0;

    public MyGraph(int node) {
        edgeList=new List[node];
        vertexList = new ArrayList<>();
        adjacencyList = new LinkedList[node];
        for (int i = 0; i < node; i++) {
            adjacencyList[i] = new LinkedList<>();
            edgeList[i]=new LinkedList<Edge>();
        }
    }

    @Override
    public Vertex newVertex(String label, double weight) {
        Vertex vertex = new Vertex(label, weight);
        vertex.setIndex(IDofVertex);
        ++IDofVertex;
        return vertex;
    }

    @Override
    public void addVertex(Vertex new_Vertex) {
        numVertices++;
        vertexList.add(new_Vertex);
    }

    @Override
    public void addEdge(int vertexID1, int vertexID2, double weight) {
        adjacencyList[vertexList.get(vertexID1).index].add(vertexList.get(vertexID2));
        adjacencyList[vertexList.get(vertexID2).index].add(vertexList.get(vertexID1));
        ++edgeSize;

        adjacencyMatrix[vertexID1][vertexID2] = weight;
        adjacencyMatrix[vertexID2][vertexID1] = weight;

        Edge edge=new Edge(vertexID1,vertexID2,weight);
        Edge edge2=new Edge(vertexID2,vertexID1,weight);

        edgeList[edge.getSource()].add(edge);
        edgeList[edge2.getSource()].add(edge2);
    }

    @Override
    public void removeEdge(int vertexID1, int vertexID2) {
        adjacencyList[vertexList.get(vertexID1).index].remove(vertexList.get(vertexID2));
        --edgeSize;
        adjacencyMatrix[vertexID1][vertexID2] = -1;
        adjacencyMatrix[vertexID2][vertexID1] = -1;
        edgeList[vertexID1].remove(new Edge(vertexID1,vertexID2));
    }

    @Override
    public void removeVertex(int vertexID) {
        adjacencyList[vertexID].remove();
        for (int i = 0; i < numVertices - 1; i++) {
            adjacencyMatrix[vertexID][i] = 0;
            adjacencyMatrix[i][vertexID] = 0;
        }
        --numVertices;
    }

    @Override
    public void removeVertex(String label) {
        for (int i = 0; i < adjacencyList.length; i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                removeVertex(vertexList.get(i).getIndex());
                break;
            }
        }

    }

    @Override
    public MyGraph filterVertices(String key, String filter) {
        MyGraph<Integer> filterVerticesGraph = new MyGraph<Integer>(numVertices);
        int x = 0;
        for (int i = 0; i < vertexList.size(); ++i) {
            if (vertexList.get(i).properties.get(key).equals(filter)) {
                Vertex data = filterVerticesGraph.newVertex(vertexList.get(i).getLabel(), vertexList.get(i).getWeight());
                filterVerticesGraph.addVertex(data);
                ++x;
            }
        }

        for (int i = 0; i < x - 1; ++i) {
            for (int j = i + 1; j < x; ++j) {
                {
                    filterVerticesGraph.addEdge(filterVerticesGraph.vertexList.get(i).index, filterVerticesGraph.vertexList.get(j).index, this.getRandomNumber(0,50));
                }
            }
        }
        return filterVerticesGraph;
    }

    @Override
    public double[][] exportMatrix() {
        return adjacencyMatrix;
    }

    @Override
    public void printGraph() {
        for (int i = 0; i < IDofVertex; i++) {
            System.out.print("[Vertex" + i +  "]");
            for (int j = 0; j < IDofVertex; ++j) {
                if (i != j && adjacencyMatrix[i][j] > 0) {
                    System.out.print(" --> " + "[Vertex" + j+ "|" + adjacencyMatrix[i][j] + "]");
                }
            }
            System.out.println();
        }
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public int getNumV() {
        return numVertices;
    }

    @Override
    public boolean isDirected() {
        return false;
    }

    @Override
    public void insert(Edge edge) {

    }

    @Override
    public boolean isEdge(int source, int dest) {
        return false;
    }

    @Override
    public Edge getEdge(int source, int dest) {
        return null;
    }

    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return edgeList[source].iterator();
    }
}
