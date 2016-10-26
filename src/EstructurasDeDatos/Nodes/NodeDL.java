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
public class NodeDL <T> {
    private T data;
    public NodeDL next;
    public NodeDL prev;
    
    public NodeDL(T data){
        this.data=data;
    }
    public NodeDL(){
        
    }

    public T getData() {
        return data;
    }

    public NodeDL getNext() {
        return next;
    }

    public NodeDL getPrev() {
        return prev;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(NodeDL next) {
        this.next = next;
    }

    public void setPrev(NodeDL prev) {
        this.prev = prev;
    }
    
}
//cambiar a privadas e ingresar métodos get y set