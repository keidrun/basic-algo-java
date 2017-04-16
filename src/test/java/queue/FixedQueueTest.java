/**
 * Copyright 2017 Keid
*/
package queue;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import queue.FixedQueue;

/**
 * @author Keid
 *
 */
public class FixedQueueTest {

    FixedQueue<Integer> sut;

    @Before
    public void setUp() throws Exception {
        sut = new FixedQueue<Integer>(5);
    }

    @Test
    public void testEnqueueAndDequeue() {

        // setup
        int first = 1;
        int second = 2;
        int third = 3;
        int fourth = -4;
        int fifth = -5;
        assertEquals(0, sut.size());
        assertTrue(sut.isEmpty());
        assertFalse(sut.isFull());

        // exercise
        sut.enqueue(first);
        sut.enqueue(second);
        sut.enqueue(third);
        sut.enqueue(fourth);
        sut.enqueue(fifth);

        // verify
        assertEquals(5, sut.size());
        assertFalse(sut.isEmpty());
        assertTrue(sut.isFull());
        assertThat(sut.dequeue(), is(first));
        assertThat(sut.dequeue(), is(second));
        assertThat(sut.dequeue(), is(third));
        assertThat(sut.dequeue(), is(fourth));
        assertThat(sut.dequeue(), is(fifth));
        assertEquals(0, sut.size());
        assertTrue(sut.isEmpty());
        assertFalse(sut.isFull());

    }

    @Test(expected = IllegalStateException.class)
    public void testQueueUnderflow() {
        sut.dequeue();
    }

    @Test(expected = IllegalStateException.class)
    public void testQueueOverflow() {
        // setup
        int first = 1;
        int second = 2;
        int third = 3;
        int fourth = -4;
        int fifth = -5;
        int additional = 6;
        sut.enqueue(first);
        sut.enqueue(second);
        sut.enqueue(third);
        sut.enqueue(fourth);
        sut.enqueue(fifth);

        // exercise
        sut.enqueue(additional);
    }

    @Test
    public void testResize() {
        // setup
        int first = 1;
        int second = 2;
        int third = 3;
        int fourth = -4;
        int fifth = -5;
        int additionalOne = 60;
        int additionalTwo = 70;
        int additionalThree = 80;
        int additionalFour = 90;
        int additionalFive = 100;
        sut.enqueue(first);
        sut.enqueue(second);
        sut.enqueue(third);
        sut.enqueue(fourth);
        sut.enqueue(fifth);
        assertEquals(5, sut.size());
        assertTrue(sut.isFull());

        // exercise
        sut.resize(10);

        // verify
        assertEquals(5, sut.size());
        assertFalse(sut.isFull());
        sut.enqueue(additionalOne);
        sut.enqueue(additionalTwo);
        sut.enqueue(additionalThree);
        sut.enqueue(additionalFour);
        sut.enqueue(additionalFive);
        assertEquals(10, sut.size());
        assertTrue(sut.isFull());

        assertThat(sut.dequeue(), is(first));
        assertThat(sut.dequeue(), is(second));
        assertThat(sut.dequeue(), is(third));
        assertThat(sut.dequeue(), is(fourth));
        assertThat(sut.dequeue(), is(fifth));
        assertThat(sut.dequeue(), is(additionalOne));
        assertThat(sut.dequeue(), is(additionalTwo));
        assertThat(sut.dequeue(), is(additionalThree));
        assertThat(sut.dequeue(), is(additionalFour));
        assertThat(sut.dequeue(), is(additionalFive));

        assertEquals(0, sut.size());
        assertTrue(sut.isEmpty());

    }

    @Test(expected = IllegalStateException.class)
    public void testArrayUnderflowOfResize() {
        // setup
        int first = 1;
        int second = 2;
        int third = 3;
        int fourth = -4;
        int fifth = -5;
        sut.enqueue(first);
        sut.enqueue(second);
        sut.enqueue(third);
        sut.enqueue(fourth);
        sut.enqueue(fifth);
        assertEquals(5, sut.size());
        assertTrue(sut.isFull());

        // exercise
        sut.resize(4);
    }

}
