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
public class NodeTree <T>{
    public T data;
    public NodeTree left;
    public NodeTree right;

    public NodeTree(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
}
