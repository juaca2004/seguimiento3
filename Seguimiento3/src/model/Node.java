
package model;

public class Node {

    private Node previous;
    private int value;
    private int turnAcutal = 0;
    private Node next;
    private int numberpast = 0;

    public Node(int value) {
        this.value = value;
    }

    public int getNumberpast() {
        return numberpast;
    }

    public void setNumberpast(int numberpast) {
        this.numberpast = numberpast;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getTurnAcutal() {
        return turnAcutal;
    }

    public void setTurnAcutal(int turnAcutal) {
        this.turnAcutal = turnAcutal;
    }

}
