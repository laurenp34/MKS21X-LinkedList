public class Node {
  private int data;
  private Node next,prev;

  public Node(Node setPrev, int setData) { // should the next node be part of the constructor?
    data = setData;
    //next = setNext;
    prev = setPrev;
  }

  //NOT SURE IF WE WERE SUPPOSED TO DO THIS
  //this method retroactively sets the next node.
  public void setNext(Node setNext) {
    next = setNext;
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
    
  }
}
