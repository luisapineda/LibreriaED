/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos.Stacks;
import EstructurasDeDatos.Nodes.Node;

/**
 *
 * @author luisa
 */
public class DynamicStack <T>{
    //Atributes
    private Node top;
    private int size;
    
    //Constructor
    public DynamicStack(){
        this.top=null;
        this.size=0;
    }
    /**
     * Getter
     * @return stack's top 
     */
    public Node getTop(){
        return top;
    }
    /**
     * Getter
     * @return stack's size 
     */
    public int getSize() {
        return size;
    }
    
    /**
     * isEmpty method
     * @return if the stack is empty
     */
    public boolean isEmpty(){
        return top==null;
    }
    /**
     * Inserta un elemento en el top
     * @param data 
     */
    public void push(T data){
        Node node=new Node(data);
        if (isEmpty()){ //Si la pila esta vacia
            top=node;
        } else {
            node.setNext(top);
            top=node;
        }
        ++size;
    }
    /**
     * Elimina un elemento de la pila
     */
    public void pop(){
        if (!isEmpty()){
            top=top.getNext();
            --size;
        } else {
            System.out.println("La pila esta vacía");
        }
    }
    /**
     * Delete every node of the stack
     */
    public void emptyStack(){
        top=null;
    }
    public void showStack(){
       if (!isEmpty()){
            Node aux=top;
            do {
                System.out.println(aux.getData() + "\n| \nV");
                aux=aux.getNext();
            } while(aux!=null);
        }
        System.out.println("null");
       }
}
