/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos.Grafos;

/**
 *
 * @author luisa
 */
public class Grafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DGraph grafo = new DGraph(5);
        grafo.insertEdge(1, 2, 3);
        grafo.insertEdge(1, 5, 8);
        grafo.insertEdge(2, 5, 9);
        grafo.insertEdge(3, 4, 5);
        grafo.insertEdge(4, 2, 2);
        grafo.insertEdge(5, 4, 10);
        grafo.insertEdge(2, 3, 8);
        
       
        System.out.println("Grafo:"+grafo.toString()); 
        System.out.println("Peso de la arista 12 es " + grafo.getEdgeW(1, 2));
        System.out.println("Numero de vertices " + grafo.nVertices());
        System.out.println("¿existe el grafo 15? " + grafo.isEdge(1, 5));
        
        System.out.println("BFS: ");
        System.out.println(grafo.toStringBFS());
        System.out.println("DFS: ");
        System.out.println(grafo.toStringDFS());
    }
    
}
