import java.util.*;
import java.io.*;

public class MyLinkedList {
 private int size;
 private Node start,end;

 public MyLinkedList(Node first) {
   start = first;
   end = first; //????
   size = 1;
  }

  public MyLinkedList(int value) {
    Node firstNode = new Node(value);
    start = firstNode;
    end = firstNode;
  }

  public MyLinkedList() {
  }

  public int size() {
   return size;
  }

//THIS METHOD ADDS THE VALUE TO THE END.
  public boolean add(Integer value) {
    //need some way to connect the previous node to the new one.
    //i think we would need a method in the Node class that could alter the next node.
    Node toAdd = new Node(value);

  //special case: adding the value when the list is empty.
  //this block decides if it is empty.
    if (start == null && end == null) {
      start = toAdd;

    } else {

      toAdd.setPrev(end); // setting the element to add's prev to the last node.
      end.setNext(toAdd); // setting the last node's next element to the node to add.

    }

    end = toAdd;

    size ++;
    return true;
  }


  public String toString(){
    Node current = start;
    String output = "[";

    //boolean cont = true;

    while (current.hasNext()) { // the loop works out perfectly to include everything but the last node.
      // then, this ensures that you won't have an extra comma at the end.
      output += current.getData();
      output += ", ";
      current = current.next();
    }
    //because the loop doesn't include the last node, we add it ourselves (w/o comma!)
    output += end.getData();
    return output += "]";
  }



  private Node getNthNode(int n) {

    Node result = start;
    int index = 1;

    while (index <= n) {
      result = result.next();
      index ++;
    }

    return result;

  }



  public Integer get(int index) {
    return getNthNode(index).getData();

  }


  public Integer set(int index,Integer value) {
    Node indexNode = getNthNode(index);

    Integer oldValue = indexNode.getData();

    indexNode.setData(value);

    return oldValue;

  }

  public boolean contains(Integer value) {

    for (int i=0;i<size;i++) {

      if (get(i).equals(value)) {
        return true;
      }

    }

    return false;
  }

  public int indexOf(Integer value) {

    for (int i=0;i<size;i++) {

      if (get(i).equals(value)) {
        return i;
      }
    }
    return -1;
  }

public void add(int index,Integer value) {

  Node toAdd = new Node(value);

  if (index == 0) {
    if (size > 0) {
      Node atIndex = getNthNode(index);
      start = toAdd;
      start.setNext(atIndex);
    } else {
      start = toAdd;
    }
  } else { // inthis case there is a current value and a previous value at that index.

    Node atIndex = getNthNode(index);
    //Node previous = getNthNode(index-1);
    Node previous = atIndex.prev();

    previous.setNext(toAdd);
    toAdd.setNext(atIndex);

    toAdd.setPrev(previous);
    atIndex.setPrev(toAdd);

  }

  size ++;
}

public Integer remove (int index) {

  Node current = getNthNode(index);

  if (index == 0) {
    start = getNthNode(1);
    start.setPrev(null); // did this so it wouldn't mess up future loops.

  } else if (index + 1 == size()) {
    end = getNthNode(index-1);
    end.setNext(null);

  } else {

    //Node current = getNthNode(index);
    Node prevNode = current.prev();
    //System.out.println(prevNode == null);
    Node nextNode = current.next();
    //System.out.println(nextNode == null);

    prevNode.setNext(nextNode);
    nextNode.setPrev(prevNode);


  }

  size --;
  return current.getData();



}




  public static void main(String[] args) {

    MyLinkedList teeth = new MyLinkedList();
    teeth.add(1);
    teeth.add(3);
    teeth.add(6);

    teeth.add(0,3);
    System.out.println(teeth); // 3, 1, 3, 6
    teeth.add(2,9);
    System.out.println(teeth); // 3, 1, 9, 3, 6
    System.out.println(teeth.size());

    teeth.remove(2);
    System.out.println(teeth); // 3, 1, 3, 6
    teeth.remove(0);
    System.out.println(teeth); // 1, 3, 6
    teeth.remove(2);
    System.out.println(teeth); // 1`, 3

  }

}
