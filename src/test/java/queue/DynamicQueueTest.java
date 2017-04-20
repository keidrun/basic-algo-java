/**
 * Copyright 2017 Keid
*/
package queue;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import queue.DynamicQueue;

/**
 * @author Keid
 *
 */
public class DynamicQueueTest {

    DynamicQueue<Integer> sut;

    @Before
    public void setUp() throws Exception {
        sut = new DynamicQueue<Integer>();
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

        // exercise
        sut.enqueue(first);
        sut.enqueue(second);
        sut.enqueue(third);
        sut.enqueue(fourth);
        sut.enqueue(fifth);

        // verify
        assertEquals(5, sut.size());
        assertFalse(sut.isEmpty());
        assertThat(sut.dequeue(), equalTo(first));
        assertThat(sut.dequeue(), equalTo(second));
        assertThat(sut.dequeue(), equalTo(third));
        assertThat(sut.dequeue(), equalTo(fourth));
        assertThat(sut.dequeue(), equalTo(fifth));
        assertEquals(0, sut.size());
        assertTrue(sut.isEmpty());

    }

}
