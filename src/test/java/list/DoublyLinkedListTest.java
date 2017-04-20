/**
 * Copyright 2017 Keid
*/
package list;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import list.DoublyLinkedList;

public class DoublyLinkedListTest {

    DoublyLinkedList<Integer> sut;

    @Before
    public void setUp() throws Exception {
        sut = new DoublyLinkedList<Integer>();
    }

    @Test
    public void testAdd() {

        // setup
        int firstElement = 10;
        int secondElement = 20;
        int thirdElement = 30;
        int fourthElement = -40;
        int fifthElement = -50;

        // exercise and verify
        // empty
        assertEquals(0, sut.size());
        // one
        sut.add(firstElement);
        assertEquals(1, sut.size());
        assertThat(sut.get(0), equalTo(firstElement));
        // two
        sut.add(secondElement);
        assertEquals(2, sut.size());
        assertThat(sut.get(1), equalTo(secondElement));
        // three
        sut.add(thirdElement);
        assertEquals(3, sut.size());
        assertThat(sut.get(2), equalTo(thirdElement));
        // four
        sut.add(fourthElement);
        assertEquals(4, sut.size());
        assertThat(sut.get(3), equalTo(fourthElement));
        // five
        sut.add(fifthElement);
        assertEquals(5, sut.size());
        assertThat(sut.get(4), equalTo(fifthElement));

    }

    @Test
    public void testRemove() {

        // setup
        int firstElement = 10;
        int secondElement = 20;
        int thirdElement = 30;
        int fourthElement = -40;
        int fifthElement = -50;

        // exercise and verify
        sut.add(firstElement);
        sut.add(secondElement);
        sut.add(thirdElement);
        sut.add(fourthElement);
        sut.add(fifthElement);
        assertEquals(5, sut.size());
        assertThat(sut.get(0), equalTo(firstElement));
        assertThat(sut.get(1), equalTo(secondElement));
        assertThat(sut.get(2), equalTo(thirdElement));
        assertThat(sut.get(3), equalTo(fourthElement));
        assertThat(sut.get(4), equalTo(fifthElement));

        // remove middle
        int actualMid = sut.remove(2);
        assertThat(actualMid, equalTo(thirdElement));
        assertEquals(4, sut.size());
        assertThat(sut.get(0), equalTo(firstElement));
        assertThat(sut.get(1), equalTo(secondElement));
        assertThat(sut.get(2), equalTo(fourthElement));
        assertThat(sut.get(3), equalTo(fifthElement));

        // remove first
        int actualFirst = sut.remove(0);
        assertThat(actualFirst, equalTo(firstElement));
        assertEquals(3, sut.size());
        assertThat(sut.get(0), equalTo(secondElement));
        assertThat(sut.get(1), equalTo(fourthElement));
        assertThat(sut.get(2), equalTo(fifthElement));

        // remove last
        sut.remove(2);
        assertEquals(2, sut.size());
        assertThat(sut.get(0), equalTo(secondElement));
        assertThat(sut.get(1), equalTo(fourthElement));

    }

    @Test
    public void testSet() {

        // setup
        int firstElement = 10;
        int secondElement = 20;
        int thirdElement = 30;
        int fourthElement = -40;
        int fifthElement = -50;
        int sixthElement = -60;
        int seventhElement = -70;
        int eighthElement = 80;

        // exercise and verify
        sut.add(firstElement);
        sut.add(secondElement);
        sut.add(thirdElement);
        sut.add(fourthElement);
        sut.add(fifthElement);
        assertEquals(5, sut.size());
        assertThat(sut.get(0), equalTo(firstElement));
        assertThat(sut.get(1), equalTo(secondElement));
        assertThat(sut.get(2), equalTo(thirdElement));
        assertThat(sut.get(3), equalTo(fourthElement));
        assertThat(sut.get(4), equalTo(fifthElement));
        assertThat(sut.getFirst(), equalTo(firstElement));
        assertThat(sut.getLast(), equalTo(fifthElement));

        // set middle
        sut.set(2, sixthElement);
        assertEquals(6, sut.size());
        assertThat(sut.get(0), equalTo(firstElement));
        assertThat(sut.get(1), equalTo(secondElement));
        assertThat(sut.get(2), equalTo(sixthElement));
        assertThat(sut.get(3), equalTo(thirdElement));
        assertThat(sut.get(4), equalTo(fourthElement));
        assertThat(sut.get(5), equalTo(fifthElement));
        assertThat(sut.getFirst(), equalTo(firstElement));
        assertThat(sut.getLast(), equalTo(fifthElement));

        // set first
        sut.set(0, seventhElement);
        assertEquals(7, sut.size());
        assertThat(sut.get(0), equalTo(seventhElement));
        assertThat(sut.get(1), equalTo(firstElement));
        assertThat(sut.get(2), equalTo(secondElement));
        assertThat(sut.get(3), equalTo(sixthElement));
        assertThat(sut.get(4), equalTo(thirdElement));
        assertThat(sut.get(5), equalTo(fourthElement));
        assertThat(sut.get(6), equalTo(fifthElement));
        assertThat(sut.getFirst(), equalTo(seventhElement));
        assertThat(sut.getLast(), equalTo(fifthElement));

        // set last
        sut.set(6, eighthElement);
        assertEquals(8, sut.size());
        assertThat(sut.get(0), equalTo(seventhElement));
        assertThat(sut.get(1), equalTo(firstElement));
        assertThat(sut.get(2), equalTo(secondElement));
        assertThat(sut.get(3), equalTo(sixthElement));
        assertThat(sut.get(4), equalTo(thirdElement));
        assertThat(sut.get(5), equalTo(fourthElement));
        assertThat(sut.get(6), equalTo(fifthElement));
        assertThat(sut.get(7), equalTo(eighthElement));
        assertThat(sut.getFirst(), equalTo(seventhElement));
        assertThat(sut.getLast(), equalTo(eighthElement));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void throwIndexOutOfBoundsWhen0() {
        sut.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void throwIndexOutOfBoundsWhenUnderMin() {
        // setup
        int firstElement = 10;
        int secondElement = 20;
        int thirdElement = 30;
        int fourthElement = -40;
        int fifthElement = -50;
        sut.add(firstElement);
        sut.add(secondElement);
        sut.add(thirdElement);
        sut.add(fourthElement);
        sut.add(fifthElement);

        // exercise and verify
        sut.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void throwIndexOutOfBoundsWhenOverMax() {
        // setup
        int firstElement = 10;
        int secondElement = 20;
        int thirdElement = 30;
        int fourthElement = -40;
        int fifthElement = -50;
        sut.add(firstElement);
        sut.add(secondElement);
        sut.add(thirdElement);
        sut.add(fourthElement);
        sut.add(fifthElement);

        // exercise and verify
        sut.get(5);
    }

    @Test
    public void testAddFirst() {

        // setup
        int firstElement = 11;
        int secondElement = 22;
        int thirdElement = 33;
        sut.add(firstElement);
        sut.add(secondElement);
        sut.add(thirdElement);
        assertEquals(3, sut.size());
        assertThat(sut.get(0), equalTo(firstElement));
        assertThat(sut.get(1), equalTo(secondElement));
        assertThat(sut.get(2), equalTo(thirdElement));

        int additional = 99;

        // exercise
        sut.addFirst(additional);

        // verify
        assertEquals(4, sut.size());
        assertThat(sut.get(0), equalTo(additional));
        assertThat(sut.get(1), equalTo(firstElement));
        assertThat(sut.get(2), equalTo(secondElement));
        assertThat(sut.get(3), equalTo(thirdElement));

    }

    @Test
    public void testAddLast() {

        // setup
        int firstElement = 11;
        int secondElement = 22;
        int thirdElement = 33;
        sut.add(firstElement);
        sut.add(secondElement);
        sut.add(thirdElement);
        assertEquals(3, sut.size());
        assertThat(sut.get(0), equalTo(firstElement));
        assertThat(sut.get(1), equalTo(secondElement));
        assertThat(sut.get(2), equalTo(thirdElement));

        int additional = 99;

        // exercise
        sut.addLast(additional);

        // verify
        assertEquals(4, sut.size());
        assertThat(sut.get(0), equalTo(firstElement));
        assertThat(sut.get(1), equalTo(secondElement));
        assertThat(sut.get(2), equalTo(thirdElement));
        assertThat(sut.get(3), equalTo(additional));

    }

    @Test
    public void testRemoveFirst() {

        // setup
        int firstElement = 11;
        int secondElement = 22;
        int thirdElement = 33;
        sut.add(firstElement);
        sut.add(secondElement);
        sut.add(thirdElement);
        assertEquals(3, sut.size());
        assertThat(sut.get(0), equalTo(firstElement));
        assertThat(sut.get(1), equalTo(secondElement));
        assertThat(sut.get(2), equalTo(thirdElement));

        // exercise
        int actual = sut.removeFirst();

        // verify
        assertEquals(2, sut.size());
        assertThat(sut.get(0), equalTo(secondElement));
        assertThat(sut.get(1), equalTo(thirdElement));
        assertThat(actual, equalTo(firstElement));

    }

    @Test
    public void testRemoveLast() {

        // setup
        int firstElement = 11;
        int secondElement = 22;
        int thirdElement = 33;
        sut.add(firstElement);
        sut.add(secondElement);
        sut.add(thirdElement);
        assertEquals(3, sut.size());
        assertThat(sut.get(0), equalTo(firstElement));
        assertThat(sut.get(1), equalTo(secondElement));
        assertThat(sut.get(2), equalTo(thirdElement));

        // exercise
        int actual = sut.removeLast();

        // verify
        assertEquals(2, sut.size());
        assertThat(sut.get(0), equalTo(firstElement));
        assertThat(sut.get(1), equalTo(secondElement));
        assertThat(actual, equalTo(thirdElement));

    }

}
