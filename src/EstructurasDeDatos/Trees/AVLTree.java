/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos.Trees;
import EstructurasDeDatos.Nodes.NodeAVL;
/**
 *
 * @author luisa
 */
public class AVLTree {
    //Attibutes
    private NodeAVL root; //Raiz
    
    //Constructor

    public AVLTree() {
        this.root=null;
    }
    
    //Buscar un nodo
    public NodeAVL fetch(int d,NodeAVL r){
        if (root==null){ //No hay nodos
            return null;
        } else if (root.data==d){ //Si el dato esta en raiz
            return root; 
        } else if (root.data<d){ //Si el dato es mayor a raiz
            return fetch(d,r.right); //Lo buscamos por la derecha
        } else {
            return fetch(d,r.left); //Lo buscamos por la izquierda
        }
    }
    
}
