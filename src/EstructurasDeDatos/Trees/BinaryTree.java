/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos.Trees;
import EstructurasDeDatos.Nodes.NodeTree;
/**
 *
 * @author luisa
 */
/*Arbol Binario xxx
Constructorxxxx
Insertar nodo (dato)xxxxx
Borrar nodo xx
EstaVacioxxxxxxxxxxx
Obtener raíz 
Determinar su altura xxxxxxx
Determinar su número de elementos xxx
*/
public class BinaryTree <T>{
    //Attributes
    private NodeTree root;
    //No necesarioooo int height;
    private int elements;
    
    //Constructor
    public BinaryTree(){
        this.root=null;
        //this.height=-1; //Es la altura, se empieza en 1
        this.elements=0;
    }
    //Getters and Setters

    public NodeTree getRoot() { //regresa la raíz
        return root;
    }
    
    public int getElements() { //regresa numero de elementos
        return elements;
    }
    
    
    public boolean eTree(){ //Verifica si esta vacio el arbol
        return this.root == null;
    }
    //Inserta un nuevo nodo
    public void insertNode(T data, NodeTree raiz) {
        NodeTree nodo = new NodeTree(data);
        if (eTree()) {
            this.root = nodo;
            elements++;
        } else {
            if ((int) nodo.data >= (int) raiz.data) {
                if (raiz.left == null) {
                    raiz.left = nodo;
                    elements++;
                } else {
                    insertNode(data, raiz.left);
                }
            } else {
                if (raiz.right == null) {
                    raiz.right = nodo;
                    elements++;
                } else {
                    insertNode(data, raiz.right);
                }
            }
        }
    }
    public boolean raices(NodeTree n, int dato){
        if (n==null) {
            return false;
        }
        if (n.right==null && n.left==null) {
            return false;
        }
        if (n.left==null) {
            return (int) n.right.data != dato;
        }
        if (n.right==null) {
            return (int) n.left.data != dato;
        }
        return (int) n.left.data != dato && (int) n.right.data != dato;
    }
    public boolean comparar(NodeTree n, int dato){
        if (n==null) {
            return false;
        }
        return n.data.equals(dato);
    }
    //Borra un nodo
    public void eNode(int dato, NodeTree raiz, int i) {
        if (searchNode(dato, raiz)) {
            while (raices (raiz, dato)) {
                if (dato > (int) raiz.data) {
                    raiz = raiz.left;
                }else{
                if (dato < (int) raiz.data) {
                    raiz = raiz.right;
                }
                }
            }
            if (comparar(raiz.left, dato)) {
                if (hoja(raiz.left)) {
                    raiz.left = null;
                }
                if (Hijos(raiz.left)) {
                    NodeTree aux = regresarSustituto(raiz.left);
                    eNode((int)aux.data, raiz.left,0);
                    raiz.left.data = aux.data; 
                }
            }
            if (comparar(raiz.right, dato)) {
                if (hoja(raiz.right)) {
                    raiz.right = null;
                }
                if (Hijos(raiz.right)) {// tiene subarbol
                   NodeTree aux = regresarSustituto(raiz.right);
                    eNode((int)aux.data, raiz.right,0);
                    raiz.right.data = aux.data;
                }
            }
            elements=elements+i;
        } else {
            System.out.println("No se encontró el dato en el árbol");
        }
    }
    //Regresar altura
    public int Height(NodeTree n){
        if (n == null) {
            return -1;
        }else{
            return 1+Math.max(Height(n.left), Height(n.right));
        }
    }
   
    public boolean hoja(NodeTree n) {
        if (n==null) {
            return false;
        }
        return n.left == null && n.right == null;
    }
    public boolean Hijos(NodeTree n) {
        if (n==null) {
            return false;
        }
        if (n.left==null && n.right==null) {
            return false;
        }
        if (n.left==null && n.right!=null) {
            return true;
        }
        if (n.right==null && n.left!=null) {
            return true;
        }
        return n.left != null || n.right != null;
    }
    public NodeTree regresarSustituto(NodeTree n) {
        if (n.left == null) {
            return n.right;
        } else {
            if (n.left.right == null) {
                return n.left;
            } else {
                n = n.left.right;
                while (n.right != null) {
                    n = n.right;
                }
                return n;
            }
        }
    }
    //Buscar nodo
    public boolean searchNode(int dato, NodeTree raiz) {
        if (raiz == null) {
            return false;
        }
        if ((int) raiz.data == (dato)) {
            return true;
        }
        if ((int) raiz.data < dato) {
            return searchNode(dato, raiz.left);
        }
        if ((int) raiz.data > dato) {
            return searchNode(dato, raiz.right);
        }
        return searchNode(dato, raiz);

    }
    public void recorrerInOrder(NodeTree raiz, boolean der, boolean izq) {
        while (der == false && raiz.right != null) {
            recorrerInOrder(raiz.right, der, false);
            der = true;
        }
        System.out.print("|" + raiz.data + "| ");
        while (raiz.left != null && izq == false) {
            recorrerInOrder(raiz.left, false, izq);
            izq = true;
        }
    }
    public void recorrerPostOrder(NodeTree raiz, boolean der, boolean izq) {
        while (der == false && raiz.right != null) {
            recorrerPostOrder(raiz.right, der, false);
            der = true;
        }
        while (raiz.left != null && izq == false) {
            recorrerPostOrder(raiz.left, false, izq);
            izq = true;
        }
        System.out.print("|" + raiz.data + "| ");
    }
    public void recorrerPreOrder(NodeTree raiz, boolean der, boolean izq) {
        System.out.print("|" + raiz.data + "| ");
        while (der == false && raiz.right != null) {
            recorrerPreOrder(raiz.right, der, false);
            der = true;
        }
        while (raiz.left != null && izq == false) {
            recorrerPreOrder(raiz.left, false, izq);
            izq = true;
        }
    }
    
    /*
    public void insert(int data, NodeTree root){ //Insertar un nuevo nodo
        NodeTree node= new NodeTree(data);
        if (isEmpty()){
            this.root=node;
        } else { //Si no esta vacio
            if (root.data <= node.data){  //Si el nodo es mayor que raiz
                if (root.left==null){ //Caso base
                    root.left=node; //Si no tiene elementos a la izquierda, se ponde ahí
                } else { //Si tiene un elemento a la izquierda
                    insert(data, root.left); //Sin el this, porque si no siempre será la izquierda del original. Buscara a la izq hasta encontrar un espacio
                }
            } else { //Si el nodo es menor que la raiz
                if (root.right==null){ //Caso base
                    root.right=node; //Si no tiene elementos a la izquierda
                } else {
                    insert(data, root.right); //Buscara por a derecha hasta encontrar un espacio
                }
            }
        }
        this.elements++;
    }
    //Ordenes en los que se puede presentar
    public void preOrder(NodeTree root, boolean right, boolean left) { //Mostrar en preorden
        System.out.print("["+root.data+"] ");
        while (right==false && root.right != null) {
            preOrder(root.right,right, false);
            right=true;
        }
        while (root.left != null && left == false) {
            preOrder(root.left, false, left);
            left=true;
        }
    }
    public void inOrder(NodeTree root, boolean right, boolean left){ //Mostrar en pantalla como inOrder 
        while (right == false && root.right !=null){ //Mientras que la derecha dada sea false y la derecha del nodo NO sea nula
            inOrder(root.right, right, false);
            right=true; //break
        }
        System.out.print("["+root.data+"] ");
        while (left==false && root.left!=null){ //Misma orden de arriba pero a la izquierda
            inOrder(root.left, left, false);
            left=true; //break
        }
    }
    public void postOrder(NodeTree root, boolean right, boolean left) { //Mostrar en pantama como postOrder
        while (right == false && root.right != null) {
            postOrder(root.right, right, false);
            right=true;
        }
        while (root.left != null && left == false) {
            postOrder(root.left, false, left);
            left=true;
        }
        System.out.print("["+root.data+"] ");
    }
    
    
    public void eNode(int data, NodeTree root, int n) { //Vinculada a los metodos de abajo, borra un 
        if (searchNode(root,data)) {
            while (root (root, data)) {
                if (data > root.data) {
                    root = root.left;
                }else{
                if (data < root.data) {
                    root = root.right;
                }
                }
            }
            if (dataEquals(root.left, data)) {
                if (Hoja(root.left)) {
                    root.left = null;
                }
                if (Hijos(root.left)) {
                    NodeTree aux = Substitute(root.left); //Se le asigna el valor de substituto
                    eNode((int)aux.data, root.left,0);
                    root.left.data = aux.data; 
                }
            }
            if (dataEquals(root.right, data)) {
                if (Hoja(root.right)) {
                    root.right = null;
                }
                if (Hijos(root.right)) {// tiene subarbol
                   NodeTree aux = Substitute(root.right); //Valor de substituto
                    eNode((int)aux.data, root.right,0);
                    root.right.data = aux.data;
                }
            }
            this.elements=this.elements+n; //conteo de elementos
        } else {
            System.out.println("No se encontró el dato en el árbol");
        }
    }
    public int Height(NodeTree n){ //Metodo que regresa los niveles del arbol
        if (n == null) {
            return -1; //cuenta con -1 nivel, es decir es nulo
        }else{
            return 1+Math.max(Height(n.left), Height(n.right)); //Devuelve el máximo valor de la altura de la rama de la derecha e izquierda, es decir el último nivel
        }
    }
    public boolean root(NodeTree node, int data){ //Metodo raiz usado para determinar la disponibilidad de la raiz. Regresa booleano
        if (node==null){
            return false;
        } //else if (node.right==null || node.left==null){
          // return false;
        if (node.right==null && node.left==null) {
            return false;
        }
        if (node.left==null) {
            return node.right.data!=data;
        }
        if (node.right==null) {
            return node.left.data!=data;
        } 
        //Si sigue en este punto, significa que right y left no son nulos
        return node.left.data!=data && node.right.data!=data; //Regresa el vlor de la compatibilidad.
    }
    
    public boolean dataEquals(NodeTree node, int data){
        if (node==null) {
            return false;
        }
        return node.data==data;
    }
    public boolean Hoja(NodeTree node) { //Determina si el nodo tiene hojas o no
        if (node==null) {
            return false;
        }
        return node.left==null && node.right==null;
    }
    public NodeTree Substitute(NodeTree node) { //Que nodo será el que reemplazará al borrar un nodo
        if (node.left == null) {
            return node.right; //Si no hay a la izquierda, se regresa el de la derecha
        } else {
            if (node.left.right == null) {
                return node.left;
            } else {
                node=node.left.right;
                while (node.right != null) {
                    node=node.right;
                }
                return node; //Se regresa el nodo de la izquierda que este más a la derecha
            }
        }
    }
    public boolean Hijos(NodeTree node) { //Determina si el nodo tiene hijos, sea 1 o dos
        if (node==null) {
            return false;
        }
        if (node.left==null && node.right==null) {
            return false;
        }
        return node.left != null || node.right != null;
    }
    
    public boolean searchNode(NodeTree root, int data) { //Buscará el nodo y regresara si existe o no
        if (root==null) { //esta vacio
            return false;
        }
        if (root.data == data){
            return true;
        }
        if (root.data < data) {
            return searchNode(root.left, data);
        }
        if (root.data > data) {
            return searchNode(root.right, data);
        }
        return searchNode(root, data);

    }
   /*
    */
    
    
}
