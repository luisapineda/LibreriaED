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
public class NodeAVL {
    public int data, bf; //balance factor
    public NodeAVL left, right;

    public NodeAVL(int data) {
        this.data = data;
        this.left=null;
        this.right=null;
    }
    
    
}
