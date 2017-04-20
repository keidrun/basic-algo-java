/**
 * Copyright 2017 Keid
*/
package search;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SelfOrganizingSearchTest {

    @RunWith(Theories.class)
    public static class searchTest {
        static Search<Integer> sut;

        @Before
        public void setup() throws Exception {
            sut = new SelfOrganizingSearch();
        }

        // @formatter:off
        @DataPoints
        public static Fixture[] FIXTUREs = {
            // Found
            new Fixture(10, 10, new int[]{0,1,2,3,4,5,6,7,8,9,10}, new int[]{10,0,1,2,3,4,5,6,7,8,9}),
            new Fixture(10, 0, new int[]{10,0,1,2,3,4,5,6,7,8,9}, new int[]{10,0,1,2,3,4,5,6,7,8,9}),
            new Fixture(10, 5, new int[]{0,1,2,3,4,10,6,7,8,9,5}, new int[]{10,0,1,2,3,4,6,7,8,9,5}),
            new Fixture(-5, 0, new int[]{-5,-4,-3,-2,-1,0,1,2,3,4,5}, new int[]{-5,-4,-3,-2,-1,0,1,2,3,4,5}),
            new Fixture(-5, 10, new int[]{5,-4,-3,-2,-1,0,1,2,3,4,-5}, new int[]{-5,5,-4,-3,-2,-1,0,1,2,3,4}),
            new Fixture(-5, 5, new int[]{0,-4,-3,-2,-1,-5,1,2,3,4,5}, new int[]{-5,0,-4,-3,-2,-1,1,2,3,4,5}),
            // Not found
            new Fixture(6, -1, new int[]{-5,-4,-3,-2,-1,0,1,2,3,4,5}, new int[]{-5,-4,-3,-2,-1,0,1,2,3,4,5}),
            new Fixture(-6, -1, new int[]{-5,-4,-3,-2,-1,0,1,2,3,4,5}, new int[]{-5,-4,-3,-2,-1,0,1,2,3,4,5})
        };
        // @formatter:on

        @Theory
        public void returnSearchedIndex(Fixture fixture) {

            // setup
            int expectedIndex = fixture.indexOfItem;

            // exercise
            int actualIndex = sut.search(fixture.item, fixture.actualList);

            // verify
            assertThat(actualIndex, equalTo(expectedIndex));

            for (int i = 0; i < fixture.actualList.size(); i++) {
                assertThat(fixture.actualList.get(i), equalTo(fixture.expectedList.get(i)));
            }

        }

        @Theory
        @Test(expected = IllegalArgumentException.class)
        public void wrongListType() {
            List<Integer> list = new ArrayList<Integer>();
            list.add(10);
            list.add(20);
            list.add(30);
            sut.search(20, list);
        }

        static class Fixture {
            int item;
            int indexOfItem;
            LinkedList<Integer> actualList;
            LinkedList<Integer> expectedList;

            Fixture(int item, int indexOfItem, int[] intActualList, int[] intExpectedList) {
                this.item = item;
                this.indexOfItem = indexOfItem;
                LinkedList<Integer> actualList = new LinkedList<Integer>();
                for (int e : intActualList) {
                    actualList.add(e);
                }
                this.actualList = actualList;
                LinkedList<Integer> expectedList = new LinkedList<Integer>();
                for (int e : intExpectedList) {
                    expectedList.add(e);
                }
                this.expectedList = expectedList;
            }
        }
    }

}
