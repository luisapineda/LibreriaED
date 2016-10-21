/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos.Lists;
import EstructurasDeDatos.Nodes.Node;
/**
 *
 * @author luisa
 */
public class CircularList <T> {
    //Atributos
    Node pivot;
    
   
    //Constructor nulo
    public CircularList(){
        this.pivot=null;
    }
    //Metodos
    public void insert(T d){
        Node node= new Node(d);
        if (!(isEmpty())){ //Si no esta vacia
                            //Insertamos el nodo al inicio y recorremos los nodos
            node.next=pivot;
            findLast().next=node;
            pivot=node;
        } else {
            pivot=node;
            node.next=pivot;
            
        }
    }
    private Node findLast(){
        Node aux=pivot;
        do{
            aux=aux.next;
        } while (aux.next!=pivot);
        return aux;
    }
    public void delete(T data){
        Node aux=pivot;
        if (!(isEmpty())){
            do{
                aux=aux.next;
            } while (aux.next!=pivot && aux.getData()!=data);
        } else { 
            System.out.println("¡☠☠☠!");
        }        
    }
    public void showList(){
        Node aux=pivot;
        if (!(isEmpty())){
            do{
                System.out.println("["+aux.getData()+"]->");
                aux=aux.next;
            } while (aux.next!=pivot);
        } else { 
            System.out.println("¡☠!");
        }
    }
    public boolean isEmpty(){
        return this.pivot==null;
    }
}
