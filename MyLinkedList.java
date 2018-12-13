public class MyLinkedList {
 private int size;
 private Node start,end;

 public MyLinkedList(Node first) {
   start = first;
   end = first; //????
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

  public boolean add(int value) {
    //need some way to connect the previous node to the new one.
    //i think we would need a method in the Node class that could alter the next node.
    Node toAdd = new Node(value);
    toAdd.setPrev(end); // setting the element to add's prev to the last node.
    end.setNext(toAdd); // setting the last node's next element to the node to add.

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
      current = current.getNext();
    }
    //because the loop doesn't include the last node, we add it ourselves (w/o comma!)
    output += end.getData();
    return output += "]";
  }

  public static void main(String[] args) {
    Node teest = new Node(3);
    MyLinkedList test = new MyLinkedList(teest);
    test.add(4);
    test.add(5);
    System.out.println(test);

    Node teeest = new Node(1);
    MyLinkedList toast = new MyLinkedList(teeest);
    System.out.println(toast);
  }

}
