public class Node {
  private Integer data;
  private Node next,prev;

  public Node(int setData) { // should the next node be part of the constructor?
    data = setData;
    //next = setNext;
    //prev = setPrev;
  }

  //NOT SURE IF WE WERE SUPPOSED TO DO THIS
  //this method retroactively sets the next node.
  public void setNext(Node setNext) {
    next = setNext;
  }

  public void setPrev(Node setPrev) {
    prev = setPrev;
  }

  public int getData() {
    return data;
  }

  public Node getNext() {
    return next;
  }

  //
  public boolean hasNext() {
    if (next != null) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    Node test = new Node(4);
    Node test2 = new Node(2);
    test.setNext(test2);
    System.out.println(test.hasNext());
    System.out.println(test2.hasNext());
  }
}
