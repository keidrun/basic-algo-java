/**
 * Copyright 2017 Keid
*/
package list;

/**
 * Doubly linked list.
 * 
 * @author Keid
 */
public class DoublyLinkedList<E> implements List<E> {

    private transient int size;
    private transient Node<E> header;
    private transient Node<E> last;

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

    public DoublyLinkedList() {
        size = 0;
        header = last = new Node<E>(null, null, null);
    }

    /**
     * Add the element after the last element.
     * 
     * @param element
     *            the element
     */
    public void add(E element) {

        Node<E> newNode = new Node<E>(last, element, header);
        header.prev = last.next = last = newNode;
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
        if (index == (size - 1)) {
            node.prev.next = node.next;
            last = node.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
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
        if (index == (size - 1)) {
            Node<E> newNode = new Node<E>(last.prev.next, element, node);
            last.prev.next = newNode;
            last = newNode;
        } else {
            Node<E> newNode = new Node<E>(node.prev, element, node);
            node.prev.next = newNode;
            node.prev = newNode;
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

        if (index < (size / 2)) {
            Node<E> node = header;
            for (int i = 0; i <= index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = (size - 1); i > index; i--) {
                node = node.prev;
            }
            return node;
        }

    }

}
