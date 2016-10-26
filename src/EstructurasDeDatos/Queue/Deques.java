/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos.Queue;
import EstructurasDeDatos.Nodes.NodeDL;
/**
 *
 * @author luisa
 */
public class Deques <T> {
    //Attributes
    private NodeDL first;
    private NodeDL last;
    private int size;
    
    //Constructor 
    public Deques(){
        first=null;
        last=null;
        size=0;
    }

    public NodeDL getFirst() {
        return first;
    }

    public NodeDL getLast() {
        return last;
    }
    
    public T getFirstD(){
        return (T) first.getData();
    }
    
    public T getLasttD(){
        return (T) last.getData();
    }
    
    public int getSize() {
        return size;
    }
    
    
    public boolean isEmpty(){
        return (first==null && last==null);
    }
    public void emptyQueue(){
        this.first=null;
        this.last=null;
        this.size=0;
    }
    public void insertFirst(T data) {
        NodeDL node= new NodeDL(data);
        if (isEmpty()){
           this.first=node;
           this.last=node;
        } else {
            node.setPrev(this.first);
            this.first.setNext(node);
            this.first=node;
        }
        ++this.size;
    }
    public void insertLast(T data) {
        NodeDL node= new NodeDL(data);
        if (isEmpty()){
           this.first=node;
           this.last=node;
        } else {
            node.setNext(this.last);
            this.last.setPrev(node);
            this.last=node;
        }
        ++this.size;
    }
    public void delFirst() {
        if (first==last){
            emptyQueue();
        }else if (!isEmpty()){
            first=first.prev;
            first.setNext(null);
            --this.size;
        }
    }
    public void delLast(T data) {
        if (first==last){
            emptyQueue();
        }else if (!isEmpty()){ 
            last=last.next;
            last.setPrev(null);
            --this.size;
        }  
    }
    
    
    
}
/*
***CrearFila – Constructor 
InsertarFrente – Coloca después del primero
InsertarAtras – Coloca después del  último
QuitarFrente – Elimina el primero
QuitarAtras – Elimina el último
***Frente – Devuelve el primer objeto
***Atrás – Devuelve el último objeto
***filaVacia – Valida si está vacía, devuelve v o f
***Vaciar – Vacía la fila
***TamañoFila – Devuelve el tamaño de la fila

*/