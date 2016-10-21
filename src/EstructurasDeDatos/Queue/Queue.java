/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos.Queue;
import EstructurasDeDatos.Nodes.Node;
/**
 *
 * @author luisa
 */
public class Queue <T> {
    //Attributes
    private Node first;
    private Node last;
    private int size;
    
    //Constructors
    public Queue(){
        this.first=null;
        this.last=null;
        size=0;
    }
    public Queue(T data){
        insertLast(data);
    }
    
    //Getters and isEmpty
    public Object getFirst(){
        return this.first.getData();
    }

    public Node getLast() {
        return this.last;
    }

    public int getSize() {
        return this.size;
    }

    public void setLast(Node last) {
        this.last = last;
    }
    
    
    public boolean isEmpty(){
        return this.first==null;
    }
    //Methods
    /**
     * Insert the node at the end of the queue
     * @param data 
     */
    public void insertLast(T data){
        Node node= new Node(data);
        if (isEmpty()){
           this.first=node;
           this.last=node;
        } else {
            node.setNext(this.last);
            this.last=node;
        }
        ++this.size;
    }
    
    /**
     * Delete the first node of the queue
     */
    public void delFirst(){
        if (!isEmpty()){
            Node temp=new Node();
            temp=this.last;
            while(temp.getNext()!=this.first) {
                temp=temp.getNext();
            }
            temp.setNext(null);
            this.first= temp;
            --this.size;
        }
    }
    /**
     * Delete all the nodes of the queue
     */
    public void emptyQueue(){
        this.first=null;
        this.last=null;
        this.size=0;
    }
    
}
