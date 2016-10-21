/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos.Stacks;

import java.util.Arrays;

/**
 *
 * @author luisa
 */
public class StaticStack {
    //Attributes
    private char[] arr; 
    private int size;
    
    public StaticStack() {
        this.arr=new char[20]; //The array will have space for 20 chars
        this.size=0;
    }
    public int getSize() {
        return this.size;
    }

    public char getTop() {
        return this.arr[this.size - 1];
    }
    
    public void showStack() {
        for (int i =0; i < this.arr.length; i++) {
            //System.out.println(arr[i] + "\n| \nV");
            System.out.print(arr[i] + " - ");
        }
    }

    public void push(char c) {
        this.arr[size] = c;
        ++this.size;
    }

    public void pop() {
        this.arr[this.size - 1] = ' ';
        --this.size;
    }

    
    public void delStack() {
        Arrays.fill(this.arr, ' '); //function of Arrays' class for delating or adding items to your array
        this.size=0;
    }
}
