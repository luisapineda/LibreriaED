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
public class LinealList <T> {
    private Node first;
    private Node last;
    
    //Getters

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }
    
    
    //Metodos
    public void insertFirst(T n){
        Node node= new Node(n);
        if (isEmpty()){ //Esta vacia
            first=node;
            last=node;
        } else {
            node.next=first;
            first=node;
        }
    }
    public void insertLast(T n){
        Node node= new Node(n);
        if (isEmpty()){ //Esta vacia
            first=node;
            last=node;
        } else {
            last.next=node;
            last=node;
        }
    }
    protected boolean isEmpty(){
        return first==null;
    }
    public void borrarInicio(){
        if (isEmpty()){ //Esta vacia
            System.out.println("☠!");
        } else {
            first=first.next;
        }
    }
    public void borrarFinal(){
        if (isEmpty()){ //Esta vacia
            System.out.println("☠!");
        } else {
            Node aux;
            aux=first;
            while(aux.next.next!=null){
                aux=aux.next;
            }
            aux.next=null;
            last=aux;
        }
    }
    public boolean borrarNodo(T data){ //se borrara el data de un nodo en específico
        if (isEmpty()){ //Esta vacia
            return false;
        } else {
            Node aux;
            if (first.getData()==data){
                borrarInicio();
                return true;
            } else {
                aux=first;
                while (aux.next.getData()!=data && aux.next!=null){ //Mientras que no encuentre el dato y no llegue al final de la lista. recorre la lista
                    aux=aux.next;
                }
                if (aux.next!=null && aux.next.getData()==data){
                    aux.next=aux.next.next;
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
    public void showList(){
        if (!(isEmpty())){
            Node aux;
            aux=first;
            do{
                System.out.print("[" + aux.getData() + "] " );
                aux=aux.next;
            } while(aux!=null);
            System.out.println("");
        } else {
            System.out.println("¡☠!");
        }
    }
}
