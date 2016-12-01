/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos.Grafos;
import EstructurasDeDatos.Lists.*;
import EstructurasDeDatos.Queue.Queue;

/**
 *
 * @author luisa
 */
public abstract class Graph {
    //Atributos.
    //Para el recorrido DFS y BFS
    protected int visited[]; 
    protected int visitOrder; //Orden de visita de los vértices
    //Solo para el recorrido BFS
    Queue<Integer>q;
    //Métodos
    public Graph(){}
    public abstract int nEdges(); //Número de aristas
    public abstract int nVertices(); //Número de vértices
    public abstract boolean isEdge(int i, int j); //Existe la arista?
    public abstract double getEdgeW(int i, int j); //Devuelve el peso de la arista
    public abstract void insertEdge (int i, int j); //Inserta una arista
    public abstract void insertEdge (int i, int j, double w); //Inserta arista con peso
    public abstract List<Edge> adjacentTo(int i);
    
    @Override
    public String toString(){
        String r = "";
        for (int i = 1; i<nVertices();i++){
            r += "\nVértice " + i + " ";
            List<Edge> pointer = adjacentTo(i); //tu apuntador
            if (pointer.isEmpty()){
                r += "sin Adyacentes.\n";
            }else{
                r += "con Adyacentes: \n";
                pointer.setFirst();
                for (int j = 1; j<=pointer.getElements(); j++){
                    r += pointer.getMove().dest;
                    r += "(" + pointer.getMove().weight +") "; 
                    pointer.keepMoving();
                }
            }
        }
        return r;
    }
    
    //Métodos DFS
    public String toStringDFS() {
        return arrayToString(toArrayDFS());
    }
    protected String arrayToString(int v[]){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < v.length; i++)
            sb.append(v[i]).append("\n");
        return sb.toString();
    }
    public int[] toArrayDFS() {
        int res[] = new int[nVertices() + 1];
        visited = new int[nVertices() + 1];
        visitOrder = 1;
        for (int i = 1; i < nVertices(); i++)
            if ( visited[i] == 0 ) toArrayDFS(i, res);
        return res;
    }
    
    protected void toArrayDFS(int origin, int res[]) {
        res[visitOrder] = origin;
        visited[origin] = visitOrder++;
        List<Edge> l = adjacentTo(origin);
        for (l.setFirst(); !l.isLast(); l.keepMoving()) {
            Edge a = l.getMove();
            if (visited[a.dest] == 0) toArrayDFS(a.dest, res);
        }
    }
    
    //Método BFS
    public String toStringBFS() {
        return arrayToString(toArrayBFS());
    }
    public int[] toArrayBFS() {
        int res[] = new int[nVertices() + 1];
        visited = new int[nVertices() + 1];
        visitOrder = 1;
        q = new Queue<>();
        for ( int i = 1; i < nVertices(); i++ )
            if (visited[i] == 0) toArrayBFS(i, res);
        return res;
    }
    protected void toArrayBFS(int origin, int res[]) {
        res[visitOrder] = origin;
        visited[origin] = visitOrder++;
        q.insertLast(origin);
        while (!q.isEmpty()) {
            int u = q.deleteFirst();
            List <Edge> l = adjacentTo(u);
            for (l.setFirst(); !l.isLast(); l.keepMoving()) {
                Edge a = l.getMove();
                if (visited[a.dest] == 0) {
                    res[visitOrder] = a.dest;
                    visited[a.dest] = visitOrder++;
                    q.insertLast(a.dest);
                }
            }
        }
    }
  
    
    
    
    

    
}
