/**
 * Copyright 2017 Keid
*/
package sort;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class BubbleSortTest {

    @RunWith(Theories.class)
    public static class sortTest {
        static Sort sut;

        @Before
        public void setup() throws Exception {
            sut = new BubbleSort();
        }

        // @formatter:off
        @DataPoints
        public static Fixture[] FIXTUREs = { 
                new Fixture(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0),
                        Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)),
                new Fixture(Arrays.asList(0, 1, 2, 3, 4, 9, 8, 7, 6, 5),
                        Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)),
                new Fixture(Arrays.asList(5, 4, 3, 2, 1, 0, -1, -2, -3, -4),
                        Arrays.asList(-4, -3, -2, -1, 0, 1, 2, 3, 4, 5)),
                new Fixture(Arrays.asList(50, 40, 30, 20, 10, 0, -10, -20, -30, -40),
                        Arrays.asList(-40, -30, -20, -10, 0, 10, 20, 30, 40, 50)),
        };
        //@formatter:on

        @Theory
        public void returnCorrectlySortedList(Fixture fixture) throws Exception {

            // exercise
            List<Integer> actualList = fixture.notSortedList;
            sut.sort(actualList);

            // verify
            for (int i = 0; i < actualList.size(); i++) {
                assertThat(actualList.get(i), is(fixture.sortedList.get(i)));
            }

        }

        static class Fixture {
            List<Integer> notSortedList;
            List<Integer> sortedList;

            Fixture(List<Integer> notSortedList, List<Integer> sortedList) {
                this.notSortedList = notSortedList;
                this.sortedList = sortedList;
            }
        }

    }

    @RunWith(Theories.class)
    public static class swipeTest {

        static Sort sut;

        @Before
        public void setup() throws Exception {
            sut = new BubbleSort();
        }

       // @formatter:off
        @DataPoints
        public static Fixture[] FIXTUREs  = {
                new Fixture(-1, 0, Arrays.asList(0,1,2,3,4)),
                new Fixture(0, -1, Arrays.asList(0,1,2,3,4)),
                new Fixture(5, 0, Arrays.asList(0,1,2,3,4)),
                new Fixture(0, 5, Arrays.asList(0,1,2,3,4))
        };
        //@formatter:on

        @Theory
        @Test(expected = IllegalArgumentException.class)
        public void badArguments(Fixture fixture) {
            sut.swipe(fixture.indexA, fixture.indexB, fixture.list);
        }

        static class Fixture {
            int indexA;
            int indexB;
            List<Integer> list;

            Fixture(int indexA, int indexB, List<Integer> list) {
                this.indexA = indexA;
                this.indexB = indexB;
                this.list = list;
            }
        }

    }

}
