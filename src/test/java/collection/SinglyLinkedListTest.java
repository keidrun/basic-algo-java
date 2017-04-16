/**
 * Copyright 2017 Keid
*/
package collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class SinglyLinkedListTest {

    SinglyLinkedList<Integer> sut;

    @Before
    public void setUp() throws Exception {
        sut = new SinglyLinkedList<Integer>();
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
        assertThat(sut.get(0), is(firstElement));
        // two
        sut.add(secondElement);
        assertEquals(2, sut.size());
        assertThat(sut.get(1), is(secondElement));
        // three
        sut.add(thirdElement);
        assertEquals(3, sut.size());
        assertThat(sut.get(2), is(thirdElement));
        // four
        sut.add(fourthElement);
        assertEquals(4, sut.size());
        assertThat(sut.get(3), is(fourthElement));
        // five
        sut.add(fifthElement);
        assertEquals(5, sut.size());
        assertThat(sut.get(4), is(fifthElement));

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
        assertThat(sut.get(0), is(firstElement));
        assertThat(sut.get(1), is(secondElement));
        assertThat(sut.get(2), is(thirdElement));
        assertThat(sut.get(3), is(fourthElement));
        assertThat(sut.get(4), is(fifthElement));

        // remove middle
        int actualMid = sut.remove(2);
        assertThat(actualMid, is(thirdElement));
        assertEquals(4, sut.size());
        assertThat(sut.get(0), is(firstElement));
        assertThat(sut.get(1), is(secondElement));
        assertThat(sut.get(2), is(fourthElement));
        assertThat(sut.get(3), is(fifthElement));

        // remove first
        int actualFirst = sut.remove(0);
        assertThat(actualFirst, is(firstElement));
        assertEquals(3, sut.size());
        assertThat(sut.get(0), is(secondElement));
        assertThat(sut.get(1), is(fourthElement));
        assertThat(sut.get(2), is(fifthElement));

        // remove last
        sut.remove(2);
        assertEquals(2, sut.size());
        assertThat(sut.get(0), is(secondElement));
        assertThat(sut.get(1), is(fourthElement));

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
        assertThat(sut.get(0), is(firstElement));
        assertThat(sut.get(1), is(secondElement));
        assertThat(sut.get(2), is(thirdElement));
        assertThat(sut.get(3), is(fourthElement));
        assertThat(sut.get(4), is(fifthElement));
        assertThat(sut.getFirst(), is(firstElement));
        assertThat(sut.getLast(), is(fifthElement));

        // set middle
        sut.set(2, sixthElement);
        assertEquals(6, sut.size());
        assertThat(sut.get(0), is(firstElement));
        assertThat(sut.get(1), is(secondElement));
        assertThat(sut.get(2), is(sixthElement));
        assertThat(sut.get(3), is(thirdElement));
        assertThat(sut.get(4), is(fourthElement));
        assertThat(sut.get(5), is(fifthElement));
        assertThat(sut.getFirst(), is(firstElement));
        assertThat(sut.getLast(), is(fifthElement));

        // set first
        sut.set(0, seventhElement);
        assertEquals(7, sut.size());
        assertThat(sut.get(0), is(seventhElement));
        assertThat(sut.get(1), is(firstElement));
        assertThat(sut.get(2), is(secondElement));
        assertThat(sut.get(3), is(sixthElement));
        assertThat(sut.get(4), is(thirdElement));
        assertThat(sut.get(5), is(fourthElement));
        assertThat(sut.get(6), is(fifthElement));
        assertThat(sut.getFirst(), is(seventhElement));
        assertThat(sut.getLast(), is(fifthElement));

        // set last
        sut.set(6, eighthElement);
        assertEquals(8, sut.size());
        assertThat(sut.get(0), is(seventhElement));
        assertThat(sut.get(1), is(firstElement));
        assertThat(sut.get(2), is(secondElement));
        assertThat(sut.get(3), is(sixthElement));
        assertThat(sut.get(4), is(thirdElement));
        assertThat(sut.get(5), is(fourthElement));
        assertThat(sut.get(6), is(fifthElement));
        assertThat(sut.get(7), is(eighthElement));
        assertThat(sut.getFirst(), is(seventhElement));
        assertThat(sut.getLast(), is(eighthElement));

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
        assertThat(sut.get(0), is(firstElement));
        assertThat(sut.get(1), is(secondElement));
        assertThat(sut.get(2), is(thirdElement));

        int additional = 99;

        // exercise
        sut.addFirst(additional);

        // verify
        assertEquals(4, sut.size());
        assertThat(sut.get(0), is(additional));
        assertThat(sut.get(1), is(firstElement));
        assertThat(sut.get(2), is(secondElement));
        assertThat(sut.get(3), is(thirdElement));

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
        assertThat(sut.get(0), is(firstElement));
        assertThat(sut.get(1), is(secondElement));
        assertThat(sut.get(2), is(thirdElement));

        int additional = 99;

        // exercise
        sut.addLast(additional);

        // verify
        assertEquals(4, sut.size());
        assertThat(sut.get(0), is(firstElement));
        assertThat(sut.get(1), is(secondElement));
        assertThat(sut.get(2), is(thirdElement));
        assertThat(sut.get(3), is(additional));

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
        assertThat(sut.get(0), is(firstElement));
        assertThat(sut.get(1), is(secondElement));
        assertThat(sut.get(2), is(thirdElement));

        // exercise
        int actual = sut.removeFirst();

        // verify
        assertEquals(2, sut.size());
        assertThat(sut.get(0), is(secondElement));
        assertThat(sut.get(1), is(thirdElement));
        assertThat(actual, is(firstElement));

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
        assertThat(sut.get(0), is(firstElement));
        assertThat(sut.get(1), is(secondElement));
        assertThat(sut.get(2), is(thirdElement));

        // exercise
        int actual = sut.removeLast();

        // verify
        assertEquals(2, sut.size());
        assertThat(sut.get(0), is(firstElement));
        assertThat(sut.get(1), is(secondElement));
        assertThat(actual, is(thirdElement));

    }

}
