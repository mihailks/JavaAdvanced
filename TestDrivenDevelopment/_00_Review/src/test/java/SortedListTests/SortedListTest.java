package SortedListTests;

import org.example.SortedList;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class SortedListTest {
    @Test
    public void testAdd() {
        SortedList list = new SortedList();

        list.add(5);
        list.add(-2);
        list.add(7);

        assertListElements(Arrays.asList(-2, 5, 7), list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowsIfNull() {
        SortedList list = new SortedList();

        list.add(null);
    }

    @Test
    public void testAddSingle() {
        SortedList list = new SortedList();

        list.add(5);

        assertListElements(Arrays.asList(5), list);
    }

    @Test
    public void testAddSortedOrder() {
        SortedList list = new SortedList();

        list.add(5);
        list.add(6);
        list.add(7);

        assertListElements(Arrays.asList(5, 6, 7), list);
    }

    @Test
    public void testAddUnsortedOrder() {
        SortedList list = new SortedList();

        list.add(42);
        list.add(13);
        list.add(69);

        assertListElements(Arrays.asList(13, 42, 69), list);
    }

    @Test
    public void testAddReverseSortedOrder() {
        SortedList list = new SortedList();

        list.add(7);
        list.add(6);
        list.add(5);

        assertListElements(Arrays.asList(5, 6, 7), list);
    }

    @Test
    public void testAddDuplicateElements() {
        SortedList list = new SortedList();

        list.add(7);
        list.add(6);
        list.add(7);

        assertListElements(Arrays.asList(6, 7, 7), list);
    }

    @Test
    public void testAddLargeNumberOfElements() {
        Random r = new Random();
        List<Integer> expected = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            expected.add(r.nextInt());
        }
        SortedList list = new SortedList();

        for (int integer : expected) {
            list.add(integer);
        }

        Collections.sort(expected);
        assertListElements(expected, list);
    }

    @Test
    public void testGetAll() {
        SortedList list = setupList(13, 42, 69);

        assertListElements(Arrays.asList(13, 42, 69), list);
    }

    @Test
    public void testGetAllEmpty() {
        SortedList list = new SortedList();

        assertListElements(Collections.emptyList(), list);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetAllNotModifiable() {
        SortedList list = setupList(13);

        list.getAll().add(42);
    }

    @Test
    public void testGetSize() {
        SortedList list = setupList(13, 42);

        assertEquals(2, list.getSize());
    }

    @Test
    public void testGetSizeEmpty() {
        SortedList list = new SortedList();

        assertEquals(0, list.getSize());
    }

    @Test
    public void testMerge() {
        SortedList a = setupList(4, 8, 12);
        SortedList b = setupList(5, 13);

        SortedList merged = SortedList.merge(a, b);

        assertListElements(Arrays.asList(4, 5, 8, 12, 13), merged);
    }

    @Test
    public void testMergeSameSizeLists() {
        SortedList a = setupList(4, 8, 12);
        SortedList b = setupList(5, 7, 13);

        SortedList merged = SortedList.merge(a, b);

        assertListElements(Arrays.asList(4, 5, 7, 8, 12, 13), merged);
    }

    @Test
    public void testMergeFirstBeforeSecond() {
        SortedList a = setupList(4, 5, 6);
        SortedList b = setupList(7, 13);

        SortedList merged = SortedList.merge(a, b);

        assertListElements(Arrays.asList(4, 5, 6, 7, 13), merged);
    }

    @Test
    public void testMergeSecondBeforeFirst() {
        SortedList a = setupList(4, 5, 6);
        SortedList b = setupList(7, 13);

        SortedList merged = SortedList.merge(b, a);

        assertListElements(Arrays.asList(4, 5, 6, 7, 13), merged);
    }

    @Test
    public void testMergeInterleaved() {
        SortedList a = setupList(1, 3, 5);
        SortedList b = setupList(2, 4);

        SortedList merged = SortedList.merge(a, b);

        assertListElements(Arrays.asList(1, 2, 3, 4, 5), merged);
    }

    @Test
    public void testMergeBothSingleElement() {
        SortedList a = setupList(2);
        SortedList b = setupList(1);

        SortedList merged = SortedList.merge(a, b);

        assertListElements(Arrays.asList(1, 2), merged);
    }

    @Test
    public void testMergeBothEmpty() {
        SortedList a = new SortedList();
        SortedList b = new SortedList();

        SortedList merged = SortedList.merge(a, b);

        assertListElements(Collections.emptyList(), merged);
    }

    @Test
    public void testMergeOneIsSingleElementList() {
        SortedList a = setupList(1);
        SortedList b = setupList(2, 4);

        SortedList merged = SortedList.merge(a, b);

        assertListElements(Arrays.asList(1, 2, 4), merged);
    }

    @Test
    public void testMergeOneIsEmptyElementList() {
        SortedList a = new SortedList();
        SortedList b = setupList(2, 4);

        SortedList merged = SortedList.merge(a, b);

        assertListElements(Arrays.asList(2, 4), merged);
    }

    private static void assertListElements(List<Integer> expected, SortedList actual) {
        assertEquals(expected.size(), actual.getSize());
        List<Integer> all = actual.getAll();
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), all.get(i));
        }
    }

    private static SortedList setupList(Integer... elements) {
        SortedList sortedList = new SortedList();

        for (Integer element : elements) {
            sortedList.add(element);
        }
        return sortedList;
    }
}