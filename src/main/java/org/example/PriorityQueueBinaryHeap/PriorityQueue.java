package org.example.PriorityQueueBinaryHeap;


import java.util.ArrayList;
import java.util.List;

//binary heap implementation
//completed binary tree
public class PriorityQueue<T> {

    private List<Integer> binaryTreeStructure = new ArrayList<>();
    private List<T> values = new ArrayList<>();

    private int leftChild(int k){
        return (k*2)+1;
    }

    private int rightChild(int k){
        return (k*2)+2;
    }

    private int parent(int k){
        return (k-1)/2;
    }

    public void push(int priorty, T value){//O(log n)
        if(binaryTreeStructure.size()==0){
            binaryTreeStructure.add(priorty);
            values.add(value);
            return;
        }
        binaryTreeStructure.add(priorty);
        values.add(value);
        int index = binaryTreeStructure.size()-1;
        while(binaryTreeStructure.get(index)> binaryTreeStructure.get(parent(index))){
            T valueTemp = values.get(parent(index));
            values.set(parent(index),values.get(index));
            values.set(index,valueTemp);//O(1)
            int temp = binaryTreeStructure.get(parent(index));
            binaryTreeStructure.set(parent(index), binaryTreeStructure.get(index));//O(1)
            binaryTreeStructure.set(index,temp);//O(1)
            index=parent(index);
        }
    }

    public T pop(){
       if(binaryTreeStructure.size()>0){
           if(binaryTreeStructure.size()==1){
               binaryTreeStructure.remove(0);
               return values.remove(0);
           }else {
               binaryTreeStructure.set(0, binaryTreeStructure.get(binaryTreeStructure.size()-1));
               binaryTreeStructure.remove(binaryTreeStructure.size()-1);
               T result = values.get(0);
               values.set(0,values.get(values.size()-1));
               values.remove(values.size()-1);
               int index=0;
               int greaterChild;
               while(true){
                   if ((leftChild(index)< binaryTreeStructure.size())&&(binaryTreeStructure.get(leftChild(index))> binaryTreeStructure.get(index))){
                       greaterChild=leftChild(index);
                   }else if((rightChild(index)< binaryTreeStructure.size())&&(binaryTreeStructure.get(rightChild(index))> binaryTreeStructure.get(index))){
                       greaterChild=rightChild(index);
                   }else {
                       break;
                   }
                   T valueTemp = values.get(greaterChild);
                   values.set(greaterChild,values.get(index));
                   values.set(index,valueTemp);//O(1)
                   int temp = binaryTreeStructure.get(greaterChild);
                   binaryTreeStructure.set(greaterChild, binaryTreeStructure.get(index));//O(1)
                   binaryTreeStructure.set(index,temp);//O(1)
                   index=greaterChild;
               }
               return result;
           }
       }else {
           throw new ArrayIndexOutOfBoundsException();
       }

    }
    public void print(){
        values.forEach(elements -> System.out.print(elements+" "));
        System.out.println();
    }

}
