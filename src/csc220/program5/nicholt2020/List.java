/*
 * Project Name: Program 5
 * Name: Tychell Nichols
 * Date: May 3, 2017
 * Description: This program has an addBeforeNext method that allows you to add a
 * node and there is a remove method that allows you to remove a node.
 * Acknowledgements: I received help from previous labs and programming consultants.
 */

package csc220.program5.nicholt2020;

import csc220.list.AddIterator;
import csc220.list.Node;
import java.util.NoSuchElementException;

public class List<E> extends csc220.list.List<E> { 
       
   @Override
   public AddIterator<E> addIterator(){return new ListAddIterator<>();}
   
   //  This nested class replaces the one in csc220.list.List
   protected class ListAddIterator<T extends E> extends csc220.list.List<E>.ListAddIterator<E> {
       
       private static final boolean DEBUGGING = true;
      
        protected Node<E> prevNode = null;
        
        @Override
        public E next() {
            prevNode= nextNode;
            return super.next();
        }

        // For debugging purposes.
        private void printNodes(String s) {
            if (!DEBUGGING)
                return;
            System.out.print(s);
            if (prevNode != null) {
                System.out.print("--previous data = " + prevNode.data);
            }
            if (nextNode != null) {
                System.out.print("--next data = " + nextNode.data);               
            }
            System.out.println("");
        }
        
        @Override 
        public void addBeforeNext(E e) {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<E> newNode = new Node<>();
            newNode.data = e;
            newNode.next = prevNode.next;
            prevNode.next = newNode;
        }
        
        @Override
        public void remove() {
            printNodes("Remove under construction");
            Node<E> currentNode = first;
            if(prevNode == null){
                throw new IllegalStateException();
            }
            else if(prevNode == first){
                first = nextNode;
            }
            else if(prevNode == last){
                    last = null;
                  currentNode = null;
            }
            else{
                while(currentNode.next != prevNode){
                    currentNode = currentNode.next;
                }
                currentNode.next = nextNode;
            }
            prevNode = null;
            
        }
     }
   
   
}
