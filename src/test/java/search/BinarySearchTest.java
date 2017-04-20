/**
 * Copyright 2017 Keid
*/
package search;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class BinarySearchTest {

    @RunWith(Theories.class)
    public static class searchTest {
        static Search<Integer> sut;

        @Before
        public void setup() throws Exception {
            sut = new BinarySearch();
        }

        // @formatter:off
        @DataPoints
        public static Fixture[] FIXTUREs = {
                // Found
                new Fixture(10, 10, Arrays.asList(0,1,2,3,4,5,6,7,8,9,10)),
                new Fixture(0, 0, Arrays.asList(0,1,2,3,4,5,6,7,8,9,10)),
                new Fixture(5, 5, Arrays.asList(0,1,2,3,4,5,6,7,8,9,10)),
                new Fixture(-5, 0, Arrays.asList(-5,-4,-3,-2,-1,0,1,2,3,4,5)),
                new Fixture(5, 10, Arrays.asList(-5,-4,-3,-2,-1,0,1,2,3,4,5)),
                new Fixture(-1, 4, Arrays.asList(-5,-4,-3,-2,-1,0,1,2,3,4,5)),
                // MID
                new Fixture(4, 5, Arrays.asList(0,1,2,3,4,4,4,5,6,7,8)),
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
            assertThat(actualIndex, equalTo(expectedIndex));

        }

        @Theory
        public void testPrivateSearch() throws Exception {

            // setup of private enum
            Object[] patternEnum = null;
            for (Class<?> clazz : BinarySearch.class.getDeclaredClasses()) {
                if ("Pattern".equals(clazz.getSimpleName())) {
                    patternEnum = clazz.getEnumConstants();
                    break;
                }
            }
            Object patternMID = null, patternLEFT = null, patternRIGHT = null;
            for (Object o : patternEnum) {
                if (((Enum<?>) o).name().equals("MID")) {
                    patternMID = o;
                } else if (((Enum<?>) o).name().equals("LEFT")) {
                    patternLEFT = o;
                } else if (((Enum<?>) o).name().equals("RIGHT")) {
                    patternRIGHT = o;
                }
            }

            // expected
            // MID
            int expectedIndexOfMid = 5;
            // LEFT
            int expectedIndexOfLeft1 = 4;
            int expectedIndexOfLeft2 = 3;
            // RIGHT
            int expectedIndexOfRight1 = 6;
            int expectedIndexOfRight2 = 7;

            // exercise
            Method targetMethod = BinarySearch.class.getDeclaredMethod("search", Integer.class, List.class,
                    patternMID.getClass());
            targetMethod.setAccessible(true);
            // MID
            int actualIndexOfMid = (int) targetMethod.invoke(sut, 4, Arrays.asList(0, 1, 2, 3, 4, 4, 4, 5, 6, 7, 8),
                    patternMID);
            // LEFT
            int actualIndexOfLeft1 = (int) targetMethod.invoke(sut, 4, Arrays.asList(0, 1, 2, 3, 4, 4, 4, 5, 6, 7, 8),
                    patternLEFT);
            int actualIndexOfLeft2 = (int) targetMethod.invoke(sut, 4, Arrays.asList(0, 1, 2, 4, 4, 4, 4, 4, 6, 7, 8),
                    patternLEFT);
            // RIGHT
            int actualIndexOfRight1 = (int) targetMethod.invoke(sut, 4, Arrays.asList(0, 1, 2, 3, 4, 4, 4, 5, 6, 7, 8),
                    patternRIGHT);
            int actualIndexOfRight2 = (int) targetMethod.invoke(sut, 4, Arrays.asList(0, 1, 2, 4, 4, 4, 4, 4, 6, 7, 8),
                    patternRIGHT);

            // verify
            assertThat(actualIndexOfMid, equalTo(expectedIndexOfMid));
            assertThat(actualIndexOfLeft1, equalTo(expectedIndexOfLeft1));
            assertThat(actualIndexOfLeft2, equalTo(expectedIndexOfLeft2));
            assertThat(actualIndexOfRight1, equalTo(expectedIndexOfRight1));
            assertThat(actualIndexOfRight2, equalTo(expectedIndexOfRight2));

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
