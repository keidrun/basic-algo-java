package collection;
/**
 * Copyright 2017 Keid
*/

/**
 * Singly linked list.
 * 
 * @author Keid
 */
public class SinglyLinkedList<E> implements List<E> {

    private transient int size;
    private transient Node<E> header;
    private transient Node<E> last;

    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    public SinglyLinkedList() {
        size = 0;
        header = last = new Node<E>(null, null);
    }

    /**
     * Add the element after the last element.
     * 
     * @param element
     *            the element
     */
    public void add(E element) {

        Node<E> newNode = new Node<E>(element, header);
        last.next = last = newNode;
        size++;

    }

    /**
     * Add the element before the first element.
     * 
     * @param element
     *            the element
     */
    public void addFirst(E element) {
        set(0, element);
    }

    /**
     * Add the element after the last element.
     * 
     * @param element
     *            the element
     */
    public void addLast(E element) {
        add(element);
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
        if (index == 0) {
            Node<E> nextNode = node(index + 1);
            header.next = nextNode;
        } else if (index == (size - 1)) {
            Node<E> prevNode = node(index - 1);
            prevNode.next = node.next;
            last = prevNode.next;
        } else {
            Node<E> prevNode = node(index - 1);
            Node<E> nextNode = node(index + 1);
            prevNode.next = nextNode;
        }
        size--;

        return node.element;
    }

    /**
     * Remove the first element.
     * 
     * @return the removed element
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * Remove the last element.
     * 
     * @return the removed element
     */
    public E removeLast() {
        return remove(size - 1);
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
        if (index == 0) {
            Node<E> newNode = new Node<E>(element, node);
            header.next = newNode;
        } else if (index == (size - 1)) {
            Node<E> newNode = new Node<E>(element, node);
            last.next = newNode;
            last = newNode;
        } else {
            Node<E> prevNode = node(index - 1);
            Node<E> newNode = new Node<E>(element, node);
            prevNode.next = newNode;
        }
        size++;

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
     * Get the first element.
     * 
     * @return the first element
     */
    public E getFirst() {
        return header.next.element;
    }

    /**
     * Get the last element.
     * 
     * @return the last element
     */
    public E getLast() {
        return last.element;
    }

    /**
     * Get the size
     * 
     * @return the size
     */
    public int size() {
        return size;
    }

    private Node<E> node(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<E> node = header;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return node;

    }

}
