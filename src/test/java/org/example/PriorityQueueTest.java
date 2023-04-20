package org.example;

import org.example.PriorityQueueBinaryHeap.PriorityQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    @Test
    void ascTest(){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.push(1,1);
        priorityQueue.push(2,2);
        priorityQueue.push(15,3);
        priorityQueue.push(17,4);
        assertEquals(priorityQueue.pop(),4);
        assertEquals(priorityQueue.pop(),3);
        assertEquals(priorityQueue.pop(),2);
        assertEquals(priorityQueue.pop(),1);
    }
    @Test
    void dscTest(){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.push(17,1);
        priorityQueue.push(16,2);
        priorityQueue.push(15,3);
        priorityQueue.push(2,4);
        assertEquals(priorityQueue.pop(),1);
        assertEquals(priorityQueue.pop(),2);
        assertEquals(priorityQueue.pop(),3);
        assertEquals(priorityQueue.pop(),4);
    }
    @Test
    void randTest(){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.push(1,1);
        priorityQueue.push(1,2);
        priorityQueue.push(1,3);
        priorityQueue.push(1,4);
        priorityQueue.push(1,5);
        assertEquals(priorityQueue.pop(),1);
        assertEquals(priorityQueue.pop(),5);
        assertEquals(priorityQueue.pop(),4);
        assertEquals(priorityQueue.pop(),3);
        assertEquals(priorityQueue.pop(),2);
    }

}