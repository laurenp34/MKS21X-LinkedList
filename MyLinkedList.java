public class MyLinkedList {
 private int size;
 private Node start,end;

 public MyLinkedList(Node first) {
   start = first;
   end = first; //????
  }

  public int size() {
   return size;
  }

  public boolean add(int value) {
    //need some way to connect the previous node to the new one.
    //i think we would need a method in the Node class that could alter the next node.
    Node toAdd = new Node(value);
    toAdd.setPrev(end);
    end.setNext(toAdd);

    end = toAdd;

    size ++;
    return true;
  }

  public String toString(){
    Node current = start;
    String output = "[";

    //boolean cont = true;

    while (current.hasNext()) {
      output += current.getData();
      output += ", ";
      current = current.getNext();
    }

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
