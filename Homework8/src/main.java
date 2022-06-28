public class main {
    public static void main(String[] args) {

        MyGraph<Integer> myTestGraph = new MyGraph<>(7);
        Vertex Tuzla = myTestGraph.newVertex("Tuzla", 9.0);
        Vertex Bagcilar = myTestGraph.newVertex("Bagcilar", 12.0);
        Vertex Fatih = myTestGraph.newVertex("Fatih", 15.0);
        Vertex Gebze = myTestGraph.newVertex("Gebze", 20);
        Vertex Esenyurt = myTestGraph.newVertex("Esenyurt", 1);
        Vertex Kemah= myTestGraph.newVertex("Kemah", 24);

        Tuzla.properties.put("Color","Blue");
        Tuzla.properties.put("City","Istanbul");
        Bagcilar.properties.put("Color","Red");
        Bagcilar.properties.put("City","Istanbul");
        Fatih.properties.put("Color","Blue");
        Fatih.properties.put("City","Istanbul");
        Gebze.properties.put("Color","Orange");
        Gebze.properties.put("City","Kocaeli");
        Esenyurt.properties.put("Color","Gray");
        Esenyurt.properties.put("City","Istanbul");
        Kemah.properties.put("Color","Brown");
        Kemah.properties.put("City","Erzincan");


        /*
        Tuzla.setBoosting(3.0);
        Bagcilar.setBoosting(6.0);
        Fatih.setBoosting(9.0);
        Gebze.setBoosting(10.0);
        Esenyurt.setBoosting(1.0);
        Kemah.setBoosting(4.0);

         */

        myTestGraph.addVertex(Tuzla);
        myTestGraph.addVertex(Bagcilar);
        myTestGraph.addVertex(Fatih);
        myTestGraph.addVertex(Gebze);
        myTestGraph.addVertex(Esenyurt);
        myTestGraph.addVertex(Kemah);

        myTestGraph.addEdge(0,1,15);//Tuzla - Bagcilar - 15
        myTestGraph.addEdge(0,3,40);//Tuzla - Gebze - 40
        myTestGraph.addEdge(1,3,20);//Bagcilar - Gebze - 20
        myTestGraph.addEdge(1,2,25);//Bagcilar - Fatih - 25
        myTestGraph.addEdge(2,3,30);//Fatih - Gebze - 30
        myTestGraph.addEdge(3,4,35);//Gebze - Esenyurt - 35
        myTestGraph.addEdge(3,5,45);//Gebze - Kemah - 45

        /*
        MyGraph<Integer> myIstanbulGraph = myTestGraph.filterVertices("City","Istanbul");
        myIstanbulGraph.printGraph();

         */

        /*
        double myExportMatrix [][] = myTestGraph.exportMatrix();

        for(int i=0; i<myTestGraph.numVertices;i++){
            System.out.print(i + " ");
            for (int j=0; j < myTestGraph.numVertices;j++){
                System.out.print(myExportMatrix[i][j] + " ");
            }
            System.out.println();
        }
        */



        //myTestGraph.printGraph();


        /*
        DijkstrasAlgorithm testDijkstrasAlgorithm = new DijkstrasAlgorithm();
        int predArray[] = new int[99];
        double distArray[] = new double[99];
        testDijkstrasAlgorithm.dijkstrasAlgorithm(myTestGraph,3,predArray,distArray);
        System.out.println("Gebze to Istanbul Optimized Dijkstra'a Algortihm Value: " + distArray[0]);
        System.out.println("Gebze to Bagciler Optimized Dijkstra'a Algortihm Value: " +distArray[1]);
        System.out.println("Gebze to Fatih Optimized Dijkstra'a Algortihm Value: " + distArray[2]);
        System.out.println("Gebze to Esenyurt Optimized Dijkstra'a Algortihm Value: "+ distArray[4]);
        System.out.println("Gebze to Kemah Optimized Dijkstra'a Algortihm Value: " + distArray[5]);
         */

        //myTestGraph.removeVertex(0);
        //myTestGraph.printGraph();

        //myTestGraph.removeEdge(3,2);
        //myTestGraph.printGraph();

        //myTestGraph.removeVertex("Bagcilar");
        //myTestGraph.printGraph();

        BreadthFirstSearch myBFSTest = new BreadthFirstSearch();

        /*
        int bfsArray [] = myBFSTest.breadthFirstSearch(myTestGraph,0);
        for (int i = 0; i < bfsArray.length; i++){
            System.out.println(bfsArray[i]);
        }
        */


        DepthFirstSearch myDFSTest = new DepthFirstSearch(myTestGraph);
        int dfsArray [] = myDFSTest.depthFirstSearch(0);
        /*
        for (int i = 0; i < dfsArray.length; i++){
            System.out.println(dfsArray[i]);
        }
        */
        /*
        myDFSTest.diffBetweenPaths(myTestGraph,0,3);

         */



        myDFSTest.diffBetweenPaths(myTestGraph,0,5);




    }

}
