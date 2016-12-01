/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos.Grafos;
import EstructurasDeDatos.Lists.*;
/**
 *
 * @author luisa
 */
public class DGraph extends Graph{
    int vertices, edges;
    protected List <Edge> arr[];
    
    public DGraph (int v){
        this.vertices=v+1;
        this.edges=0;
        arr = new List[this.vertices];
        for (int i=1;i<this.vertices;i++){
            arr[i]=new List <>(); //inicias desde el lugar 1, no el 0
        }
    }

    @Override
    public int nEdges() { //regresa el numero de aristas
        return this.edges;
    }

    @Override
    public int nVertices() { //el numero de vértices 
        return this.vertices;
    }

    @Override //existe la arista o no???
    public boolean isEdge(int i, int j) {
       List <Edge> lista = this.arr[i]; //es la lista temporal para buscar
       for (lista.setFirst();!lista.isLast();lista.keepMoving()){
           //del primero al último con keepmoving
           if(lista.getMove().dest==j) return true;
       }
       return false;
    }

    @Override
    public double getEdgeW(int i, int j) {
        List <Edge> lista = this.arr[i];
        for (lista.setFirst();!lista.isLast();lista.keepMoving()){
            if(lista.getMove().dest==j) return lista.getMove().weight;
        }
        return 0.0;
    }

    @Override
    public void insertEdge(int i, int j) {
        insertEdge(i,j,0);
    }

    @Override
    public void insertEdge(int i, int j, double w) {
        if (!isEdge(i,j)){
            this.arr[i].insert(new Edge(j,w));
            this.edges++;
        }
    }

    @Override
    public List<Edge> adjacentTo(int i) {
        return this.arr[i];  //envia los vértices a los que es adyacente
    }
    
}
