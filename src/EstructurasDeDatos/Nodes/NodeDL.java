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
    public T data;
    public NodeDL next;
    public NodeDL prev;
    
    public NodeDL(T data){
        this.data=data;
    }
}
//cambiar a privadas e ingresar métodos get y set