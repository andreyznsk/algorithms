package lesson7;

public class Test7 {

    public static void main(String[] args) {

        testDfs();
        testGraphCites();
    }

    private static void testGraphCites() {
        System.out.println("Cites graph test");
        Graph graph = new Graph(10);
        String[] strGoroda ={"Москва","Тула","Рязань","Калуга","Липецк","Тамбов","Орел","Саратов","Курск","Воронеж"};
        for (int i = 0; i < 10; i++) {
             graph.addVertex(strGoroda[i]);
        }
        graph.addEdges(strGoroda[0],strGoroda[1],strGoroda[2],strGoroda[3]);
        graph.addEdges(strGoroda[1],strGoroda[4]);
        graph.addEdges(strGoroda[4],strGoroda[9]);
        graph.addEdges(strGoroda[2],strGoroda[5]);
        graph.addEdges(strGoroda[5],strGoroda[7]);
        graph.addEdges(strGoroda[7],strGoroda[9]);
        graph.addEdges(strGoroda[3],strGoroda[6]);
        graph.addEdges(strGoroda[6],strGoroda[8]);
        graph.addEdges(strGoroda[8],strGoroda[9]);
        graph.display();
        graph.bfsSearchPath(strGoroda[0],strGoroda[9]);
    }

    private static void testDfs() {
        Graph graph = new Graph(8);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");


        graph.addEdges("A", "B", "C", "D");
        graph.addEdges("B", "E");
        graph.addEdges("D", "F");
        graph.addEdges("F", "G");
        graph.addEdges("H","E","G");
        graph.addEdges("C","H");


        //graph.bfs("A");
        //A B C D E H F G

        graph.bfsSearchPath("A","H");
    }


}
