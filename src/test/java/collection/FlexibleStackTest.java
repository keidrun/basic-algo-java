/**
 * Copyright 2017 Keid
*/
package collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FlexibleStackTest {

    FlexibleStack<Integer> sut;

    @Before
    public void setUp() throws Exception {
        sut = new FlexibleStack<Integer>();
    }

    @Test
    public void testPushAndPop() {

        // setup
        int first = 1;
        int second = 2;
        int third = 3;
        int fourth = -4;
        int fifth = -5;
        assertEquals(0, sut.size());
        assertTrue(sut.isEmpty());

        // exercise
        sut.push(first);
        sut.push(second);
        sut.push(third);
        sut.push(fourth);
        sut.push(fifth);

        // verify
        assertEquals(5, sut.size());
        assertFalse(sut.isEmpty());
        assertThat(sut.pop(), is(fifth));
        assertThat(sut.pop(), is(fourth));
        assertThat(sut.pop(), is(third));
        assertThat(sut.pop(), is(second));
        assertThat(sut.pop(), is(first));
        assertEquals(0, sut.size());
        assertTrue(sut.isEmpty());

    }

}
