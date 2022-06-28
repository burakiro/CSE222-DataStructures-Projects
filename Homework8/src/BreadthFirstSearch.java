import java.util.*;

/** Class to implement the breadth-first search algorithm.
 *  @author Koffman and Wolfgang
 * */

public class BreadthFirstSearch {

    /** Perform a breadth-first search of a graph.
     post: The array parent will contain the predecessor
     of each vertex in the breadth-first
     search tree.
     @return The array of parents
     */



    public static void swap(int i1 ,int i2 , List<Edge> list){
        Edge ed1 = list.get(i1);
        Edge ed2 = list.get(i2);

        list.set(i1, ed2);
        list.set(i2, ed1);

    }



    public static int[] breadthFirstSearch(MyGraph<Integer> graph, int start) {
        Queue < Integer > theQueue = new LinkedList < Integer > ();
        List<Integer> listem = new ArrayList<>();
        // Declare array parent and initialize its elements to �1.
        int[] parent = new int[graph.getNumV()];
        for (int i = 0; i < graph.getNumV(); i++) {
            parent[i] = -1;
        }
        // Declare array identified and
        // initialize its elements to false.
        boolean[] identified = new boolean[graph.getNumV()];
    /* Mark the start vertex as identified and insert it
       into the queue */
        identified[start] = true;
        theQueue.offer(start);
        /* While the queue is not empty */
        while (!theQueue.isEmpty()) {
      /* Take a vertex, current, out of the queue.
       (Begin visiting current). */
            int current = theQueue.remove();
            /* Examine each vertex, neighbor, adjacent to current. */
            Iterator < Edge > itr = graph.edgeIterator(current);

            List<Edge> list = new ArrayList<>();

            while (itr.hasNext()) {
                Edge edge = itr.next();
                list.add(edge);

            }
            for(int i = 0;i< list.size();i++){
                for(int j = i+1;j< list.size();j++){
                    if(list.get(i).getWeight() > list.get(j).getWeight()){
                        swap(i, j, list);
                    }
                }
            }






            for(int i = 0; i < list.size();i++) {
                Edge edge = list.get(i);
                int neighbor = edge.getDest();
                // If neighbor has not been identified
                if (!identified[neighbor]) {
                    // Mark it identified.
                    identified[neighbor] = true;
                    // Place it into the queue.
                    theQueue.offer(neighbor);
          /* Insert the edge (current, neighbor)
             into the tree. */
                    listem.add(edge.getDest());

                    //listem.add((int) graph.getVertexList().get(edge.getDest()).getWeight());
                    parent[neighbor] = (int) graph.vertexList.get(edge.getDest()).getWeight();
                }
            }
            // Finished visiting current.
        }
        //System.out.println(listem);
        for(int i = 1;i<listem.size()+1;i++)
            parent[i] = listem.get(i-1);

        return parent;
    }
}