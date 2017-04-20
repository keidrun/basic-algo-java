/**
 * Copyright 2017 Keid
*/
package stack;

import static org.hamcrest.CoreMatchers.equalTo;
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
        assertThat(sut.pop(), equalTo(fifth));
        assertThat(sut.pop(), equalTo(fourth));
        assertThat(sut.pop(), equalTo(third));
        assertThat(sut.pop(), equalTo(second));
        assertThat(sut.pop(), equalTo(first));
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

        assertThat(sut.pop(), equalTo(additionalFive));
        assertThat(sut.pop(), equalTo(additionalFour));
        assertThat(sut.pop(), equalTo(additionalThree));
        assertThat(sut.pop(), equalTo(additionalTwo));
        assertThat(sut.pop(), equalTo(additionalOne));
        assertThat(sut.pop(), equalTo(fifth));
        assertThat(sut.pop(), equalTo(fourth));
        assertThat(sut.pop(), equalTo(third));
        assertThat(sut.pop(), equalTo(second));
        assertThat(sut.pop(), equalTo(first));
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
