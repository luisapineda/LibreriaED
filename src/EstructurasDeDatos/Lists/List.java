/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos.Lists;
import EstructurasDeDatos.Nodes.Node;
import java.util.Scanner;

/**
 *
 * @author luisa
 */
public class List <T>{
    private Node first;
    private Node last;
    private Node move;
    private int elements;
    
    /**
     * Constructor
     */
    public List (){
        this.first=null;
        this.last=null;
    }
    
    /**
     * ¿Está la lista vacía?
     * @return true 
     */
    public boolean isEmpty(){
        return this.first==null;
    }
    
    /**
     * Inserta un elemento al inicio de la lista.
     * @param data 
     */
    public void insertFirst(T data){
        Node <T> nodo = new Node (data);
        if (isEmpty()){
            this.first = nodo;
            this.last = nodo;
        }else{
            nodo.next=this.first;
            this.first=nodo;
        }
        this.elements ++;
    }
    
    /**
     * Inserta un elemento en la lista.
     * @param data 
     */
    public void insert(T data){
        Node <T> nodo = new Node (data);
        if (isEmpty()){
            this.last = nodo;
            this.first= nodo;
        }else{
            this.last.next = nodo;
            last=nodo;
        }
        this.elements ++;
    }
    
    /**
     * Devuelve la cantidad de lementos de la lista
     * @return elements
     */
    public int getElements(){
        return this.elements;
    }
    
    /**
     * Elimina el elemento indicado en el parámetro
     * @param data
     * @return true
     */
    public boolean delete (T data){
        if(!isEmpty()){
            setFirst();
            if (move.getData().equals(data)){
                return deleteFirst();
            }else{
                while (!move.next.getData().equals(data)){
                    if (move.next!=null){
                    keepMoving();
                    }else{
                        return false;
                    }
                }
                move.next=move.next.next;
                return true;
            }
        }else{
            return false;
        }
    }
    /**
     * Elimina todos los elementos de la lista.
     */
    public void emptyList(){
        System.out.print("\033[31mAll the elements will disapear. Are you sure?(Y/N) ");
        Scanner e = new Scanner(System.in);
        String r = e.nextLine();
        if (r.equals("Y") || r.equals("y")){
            this.first=this.last=this.move=null;
            this.elements=0;
            System.out.println("\033[31mDone");
        }
    }
    
    /**
     * Elimina el primer elemento de la lista
     * @return true
     */
    public boolean deleteFirst(){
        if (!isEmpty()){
            this.first=this.first.next;
            return true;
        }else return false;
    }
    
    /**
     * Elimina el último elemento de la lista
     * @return true
     */
    public boolean deleteLast(){
        if (!isEmpty()){
            setFirst();
            while(!this.move.next.equals(this.last)){
                keepMoving();
            }
            last = this.move;
            last.next = null;
            return true;
        }else return false;
    }
    
    /**
     * Busca un elemento en la lista y lo devuelve
     * @param data
     * @return data
     */
    public T fetch(T data){
        if(!isEmpty()){
            if (last.getData().equals(data)){
                
                return (T) move.getData();
            }else{
                setFirst();
                do{
                    if (!move.getData().equals(data)){
                         keepMoving();
                    }else{
                        return (T) move.getData();
                    } 
                }while(move != last);
            }
        }
        return null;
    }
    
    /**
     * Ubica al puntero move al inicio de la lista
     */
    public void setFirst(){
        move = this.first;
    }
    
    /**
     * Evalua si el puntero move está al inicio de la lista
     * @return true
     */
    public boolean isFirst(){
        return move == this.first;
    }
    
    /**
     * Ubica el puntero move al final de la lista
     */
    public void setLast(){
        move = this.last;
    }
    
    /**
     * Evalua si el puntero move está al final de la lista
     * @return 
     */
    public boolean isLast (){
        return move == this.last;
    }
    
    /**
     * Mueve el puntero move al siguiente elemento de la lista.
     */
    public void keepMoving(){
        move = move.next;
    }
    
    /**
     * Devuelve el dato del puntero move
     * @return data
     */
    public T getMove(){
        return (T) this.move.getData();
    }
    
    @Override
    public String toString(){
        if (!isEmpty()){
            String s="";
            setFirst();
            while(move!=null){
                s += (T) getMove() + "->";
                
                keepMoving();
            }
            return s+="null";
        }
        else return "Lista vacía";
    }
}
