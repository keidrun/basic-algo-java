/**
 * Copyright 2017 Keid
*/
package stack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import stack.FixedStack;

/**
 * @author Keid
 *
 */
public class FixedStackTest {

    FixedStack<Integer> sut;

    @Before
    public void setUp() throws Exception {
        sut = new FixedStack<Integer>(5);
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
        assertFalse(sut.isFull());

        // exercise
        sut.push(first);
        sut.push(second);
        sut.push(third);
        sut.push(fourth);
        sut.push(fifth);

        // verify
        assertEquals(5, sut.size());
        assertFalse(sut.isEmpty());
        assertTrue(sut.isFull());
        assertThat(sut.pop(), is(fifth));
        assertThat(sut.pop(), is(fourth));
        assertThat(sut.pop(), is(third));
        assertThat(sut.pop(), is(second));
        assertThat(sut.pop(), is(first));
        assertEquals(0, sut.size());
        assertTrue(sut.isEmpty());
        assertFalse(sut.isFull());

    }

    @Test(expected = IllegalStateException.class)
    public void testStackUnderflow() {
        sut.pop();
    }

    @Test(expected = IllegalStateException.class)
    public void testStackOverflow() {
        // setup
        int first = 1;
        int second = 2;
        int third = 3;
        int fourth = -4;
        int fifth = -5;
        int additional = 6;
        sut.push(first);
        sut.push(second);
        sut.push(third);
        sut.push(fourth);
        sut.push(fifth);

        // exercise
        sut.push(additional);
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
        sut.push(first);
        sut.push(second);
        sut.push(third);
        sut.push(fourth);
        sut.push(fifth);
        assertEquals(5, sut.size());
        assertTrue(sut.isFull());

        // exercise
        sut.resize(10);

        // verify
        assertEquals(5, sut.size());
        assertFalse(sut.isFull());
        sut.push(additionalOne);
        sut.push(additionalTwo);
        sut.push(additionalThree);
        sut.push(additionalFour);
        sut.push(additionalFive);
        assertEquals(10, sut.size());
        assertTrue(sut.isFull());

        assertThat(sut.pop(), is(additionalFive));
        assertThat(sut.pop(), is(additionalFour));
        assertThat(sut.pop(), is(additionalThree));
        assertThat(sut.pop(), is(additionalTwo));
        assertThat(sut.pop(), is(additionalOne));
        assertThat(sut.pop(), is(fifth));
        assertThat(sut.pop(), is(fourth));
        assertThat(sut.pop(), is(third));
        assertThat(sut.pop(), is(second));
        assertThat(sut.pop(), is(first));
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
        sut.push(first);
        sut.push(second);
        sut.push(third);
        sut.push(fourth);
        sut.push(fifth);
        assertEquals(5, sut.size());
        assertTrue(sut.isFull());

        // exercise
        sut.resize(4);
    }

}
