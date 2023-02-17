package model;

public class List {

    private Node head;

    private Node tail;

    public void agregar() {
        if (head == null) { // lista vacia
            Node node = new Node(1);
            node.setTurnAcutal(1);
            tail = node;
            head = node;

        } else {
            Node node = new Node(tail.getValue() + 1);
            node.setPrevious(tail);
            tail.setNext(node);
            tail = node;
            head.setPrevious(tail);
            tail.setNext(head);

        }
        System.out.println("se ha agregado con exito");
    }

    public void seguir() {
        seeguir(head);
    }

    public void seeguir(Node pointer) {
        Node node1 = find(pointer);
        if (node1 != null) {
            if (node1.getValue() == head.getValue()) {
                head = node1.getNext();
                if (head == null) {
                    System.out.println("no hay mas datos");
                } else {
                    head.setPrevious(tail);
                    tail.setNext(head);
                    head.setTurnAcutal(1);
                    System.out.println("se elimino turno cabeza");
                }
            } else if (node1.getValue() == tail.getValue()) {
                tail = node1.getPrevious();
                tail.setNext(head);
                head.setPrevious(tail);
                tail.setTurnAcutal(1);
                System.out.println("se elimino turno cola");
            } else {
                node1.getNext().setTurnAcutal(1);
                node1.getPrevious().setNext(node1.getNext());
                node1.getNext().setPrevious(node1.getPrevious());
                System.out.println("se elimino turno ");

            }
        } else {
            System.out.println("noo hay turnos");
        }
    }

    private Node find(Node pointer) {
        if (pointer != null && pointer.getTurnAcutal() == 1) {
            return pointer;
        } else {
            if (pointer == null) {
                return null;
            }
            return find(pointer.getNext());
        }
    }

    public void printturn() {
        print(head);
    }

    private void print(Node pointer) {

        if (pointer != null && pointer.getTurnAcutal() == 1) {
            System.out.println("el tuno es; " + pointer.getValue());
        } else {
            print(pointer.getNext());
        }
    }

    public void pasar() {
        pasar(head);

    }

    private void pasar(Node pointer) {
        if (pointer != null && pointer.getNext() != null && pointer.getTurnAcutal() == 1) {
            pointer.getNext().setTurnAcutal(1);
            pointer.setTurnAcutal(0);
            pointer.setNumberpast(pointer.getNumberpast() + 1);
            if (pointer.getNumberpast() == 3) {
                if (pointer != null) {
                    if (pointer == head) {
                        head = pointer.getNext();
                        head.setPrevious(tail);
                        tail.setNext(head);
                    } else if (pointer == tail) {
                        tail = pointer.getPrevious();
                        tail.setNext(head);
                        head.setPrevious(tail);
                    } else {
                        pointer.getPrevious().setNext(pointer.getNext());
                        pointer.getNext().setPrevious(pointer.getPrevious());
                    }
                    pointer = null;
                }
            }
            System.out.println("se paso el turno");
        } else {
            if (pointer.getNext() != null) {
                pasar(pointer.getNext());
            } else {
                System.out.println("no hay mas turnos");
            }
        }
    }

}
