/**
 * Copyright 2017 Keid
*/
package stack;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import stack.DynamicStack;

public class DynamicStackTest {

    DynamicStack<Integer> sut;

    @Before
    public void setUp() throws Exception {
        sut = new DynamicStack<Integer>();
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
        assertThat(sut.pop(), equalTo(fifth));
        assertThat(sut.pop(), equalTo(fourth));
        assertThat(sut.pop(), equalTo(third));
        assertThat(sut.pop(), equalTo(second));
        assertThat(sut.pop(), equalTo(first));
        assertEquals(0, sut.size());
        assertTrue(sut.isEmpty());

    }

}
