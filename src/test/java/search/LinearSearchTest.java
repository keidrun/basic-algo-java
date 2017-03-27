/**
 * Copyright 2017 Keid
*/
package search;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class LinearSearchTest {

    @RunWith(Theories.class)
    public static class searchTest {
        static Search<Integer> sut;

        @Before
        public void setup() throws Exception {
            sut = new LinearSearch();
        }

        // @formatter:off
        @DataPoints
        public static Fixture[] FIXTUREs = {
                // Found
                new Fixture(10, 10, Arrays.asList(0,1,2,3,4,5,6,7,8,9,10)),
                new Fixture(10, 0, Arrays.asList(10,0,1,2,3,4,5,6,7,8,9)),
                new Fixture(10, 5, Arrays.asList(0,1,2,3,4,10,6,7,8,9,5)),
                new Fixture(-5, 0, Arrays.asList(-5,-4,-3,-2,-1,0,1,2,3,4,5)),
                new Fixture(-5, 10, Arrays.asList(5,-4,-3,-2,-1,0,1,2,3,4,-5)),
                new Fixture(-5, 5, Arrays.asList(0,-4,-3,-2,-1,-5,1,2,3,4,5)),
                // Not found
                new Fixture(6, -1, Arrays.asList(-5,-4,-3,-2,-1,0,1,2,3,4,5)),
                new Fixture(-6, -1, Arrays.asList(-5,-4,-3,-2,-1,0,1,2,3,4,5))
        };
        // @formatter:on

        @Theory
        public void returnSearchedIndex(Fixture fixture) {

            // setup
            int expectedIndex = fixture.indexOfItem;

            // exercise
            int actualIndex = sut.search(fixture.item, fixture.list);

            // verify
            assertThat(actualIndex, is(expectedIndex));

        }

        static class Fixture {
            int item;
            int indexOfItem;
            List<Integer> list;

            Fixture(int item, int indexOfItem, List<Integer> list) {
                this.item = item;
                this.indexOfItem = indexOfItem;
                this.list = list;
            }
        }
    }

}
