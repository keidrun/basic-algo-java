/**
 * Copyright 2017 Keid
*/
package collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Keid
 *
 */
public class FlexibleQueueTest {

    FlexibleQueue<Integer> sut;

    @Before
    public void setUp() throws Exception {
        sut = new FlexibleQueue<Integer>();
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
        assertThat(sut.dequeue(), is(first));
        assertThat(sut.dequeue(), is(second));
        assertThat(sut.dequeue(), is(third));
        assertThat(sut.dequeue(), is(fourth));
        assertThat(sut.dequeue(), is(fifth));
        assertEquals(0, sut.size());
        assertTrue(sut.isEmpty());

    }

}
