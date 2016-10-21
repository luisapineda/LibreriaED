/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos.Nodes;

/**
 *
 * @author luisa
 */
public class Node <T>{
//Atributos
    public Node next;
    private T data;
    
    //Metodos
    //Constructor
    public Node(T data){
        this.data=data;
        this.next=null;
    }
    public Node(){
        this.data=null;
        this.next=null;
    }
    public void setData(T data){
        this.data=data;
    }
    public T getData(){
        return this.data;
    }
    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }
}
//cambiar a privadas e ingresar métodos get y set