/**
 * Copyright 2017 Keid
*/
package collection;

/**
 * Linked list.
 * 
 * @author Keid
 */
public class LinkedList<E> {

    private int capacity;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    public LinkedList() {
        capacity = 0;
        first = last = new Node<E>(null, null, null);
    }

    /**
     * Add element after the last element.
     * 
     * @param element
     */
    public void add(E element) {

        Node<E> newNode = new Node<E>(last, element, first);
        first.prev = last.next = last = newNode;
        capacity++;

    }

    /**
     * Remove the element of the index.
     * 
     * @param index
     *            the index
     * @return the removed element
     */
    public E remove(int index) {

        Node<E> node = node(index);
        if (index == (capacity - 1)) {
            node.prev.next = node.next;
            last = node.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        capacity--;

        return node.element;
    }

    /**
     * Set the element to the index.
     * 
     * @param index
     *            the index
     * @param element
     *            the element
     */
    public void set(int index, E element) {

        Node<E> node = node(index);
        if (index == (capacity - 1)) {
            Node<E> newNode = new Node<E>(last.prev.next, element, node);
            last.prev.next = newNode;
            last = newNode;
        } else {
            Node<E> newNode = new Node<E>(node.prev, element, node);
            node.prev.next = newNode;
            node.prev = newNode;
        }
        capacity++;

    }

    /**
     * Get element of index.
     * 
     * @param index
     *            the index
     * @return element
     */
    public E get(int index) {
        return node(index).element;
    }

    /**
     * Get the capacity
     * 
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Get the first element.
     * 
     * @return the first element
     */
    public E getFirst() {
        return first.next.element;
    }

    /**
     * Get the last element.
     * 
     * @return the last element
     */
    public E getLast() {
        return last.element;
    }

    private Node<E> node(int index) {

        if (index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Capacity: " + capacity);
        }

        if (index < (capacity / 2)) {
            Node<E> node = first;
            for (int i = 0; i <= index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = (capacity - 1); i > index; i--) {
                node = node.prev;
            }
            return node;
        }

    }

}
