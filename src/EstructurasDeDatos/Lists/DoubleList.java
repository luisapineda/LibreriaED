/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos.Lists;
import EstructurasDeDatos.Nodes.NodeDL;

/**
 *
 * @author luisa
 */
public class DoubleList <T> {
    //Atributos
    private NodeDL first, last; //Se cambio a PRIVATE

    public NodeDL getFirst(){
        return first;    
    }

    //Getters
    public NodeDL getLast() {
        return last;
    }

    //Metodos
    /**
     * Este método inserta un nodo al inicio de la lista
     * @param data es de tipo generico y contiene la informacion importante
     */
    public void insertFirst(T data) {
        //Creamos nuestro nodo
        NodeDL node= new NodeDL(data);
        if(isEmpty()){
            this.first=node;
            this.last=node;
        } else{
            node.setNext(first);
            //node.next=first; //El apuntador siguiente del nuevo nodo, apunta al 
            first.setPrev(node);
            //first.prev=node
            first=node;
        }
    }
    public void insertLast(T data){
        //Creamos nuestro nodo
        NodeDL node= new NodeDL(data);
        if(isEmpty()){
            this.first=node;
            this.last=node;
        } else{
            node.setPrev(last);
            //node.prev=last; //El apuntador siguiente del nuevo nodo, apunta al 
            last.setNext(node);
            //last.next=node;
            last=node;
        }
    }
    
    public void eNodeFirst(){
        if (isEmpty()){
            System.out.println("¡☠!");
        } else if (first==last){
            first=null;
            last=null;
        } else {
        first=first.getNext();
        //first=first.next;
        first.setPrev(null);
        //first.prev=null;
        System.out.println("Se borro el primer elemento de doublelist");
        }
    }
    
    public void eNodeLast(){
        if (isEmpty()){
            System.out.println("¡☠!");
        } else {
            last=last.getPrev();
            //last=last.prev;
            last.setNext(null);
            //last.next=null;
            System.out.println("Se borro el ultimo elemento");
        }
    }
    
    public boolean isEmpty(){
        return (first==null && last==null);
    }
    
    public boolean delNode(T data){
        NodeDL aux=searchNode(data);
        if(aux==null){
            System.out.println("¡☠☠☠☠☠!");
            return false;
        }else {
            if (aux==first){
                eNodeFirst();
            } else if (aux == last){
                eNodeLast();
            } else {
                aux.next.prev=aux.prev;
                aux.prev.next=aux.next;
                System.out.println("Se borro");               
            }
            return true; 
        }
    }
    
    public NodeDL searchNode(T data){
        NodeDL aux;
        if (isEmpty()){
            return null;
        }  else {  //Si contiene elementos
            aux=first; 
            while (aux.getData()!=data && aux!=last){
                try {
                aux=aux.getNext();
                }
                catch (NullPointerException e){
                    return null;
                }
            }
            if (aux.getData()==data){ return aux; } else { return null;}           
        }
    }
    
    public void showList(){
        if (!(isEmpty())){
            NodeDL aux;
            aux=first;
            do{
                System.out.print("[" + aux.getData() + "] " );
                aux=aux.getNext();
            } while(aux!=null);
            System.out.println("");
        } else {
            System.out.println("¡☠!");
        }
        
    }
    
    public void showListAtras(){
        if (!(isEmpty())){
            NodeDL aux;
            aux=last;
            do{
                System.out.print("[" + aux.getData() + "] " );
                aux=aux.getPrev();
            } while(aux!=null);
            System.out.println("");
        } else {
            System.out.println("¡☠!");
        }
    }
    
    public NodeDL indexNode(int i){
        if (!(isEmpty())){
            NodeDL aux;
            aux=first;
            int contador=0;
            while (contador!=i && aux!=null){
                aux=aux.getNext();
                ++contador;
            }
            if (aux!=null){
                return aux;
            } else{
                return null;
            }
        } else {
            System.out.println("¡☠!");
            return null;
        }
    }
    
    public boolean eIndexNode(NodeDL node){
        NodeDL aux=node;
        if(aux==null){
            System.out.println("¡☠☠☠☠☠!");
            return false;
        }else {
            if (aux==first){
                eNodeFirst();
            } else if (aux == last){
                eNodeLast();
            } else {
                aux.next.prev=aux.getPrev();
                aux.prev.next=aux.getNext();
                //aux.next.prev=aux.prev;
                //aux.prev.next=aux.next;
                System.out.println("Se borro");               
            }
            return true; 
        }
    }
}
