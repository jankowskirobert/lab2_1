/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose
 * Tools | Templates and open the template in the editor.
 */
package tests;

import edu.iis.mto.bsearch.BinarySearch;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jankowskirobert
 */
public class TestBinarySearch {

    @Test(expected = IllegalArgumentException.class)
    public void testSearchResultThrowException() {
        BinarySearch searchObj = new BinarySearch();
        int keyTemplate = 1;
        int[] data = new int[] {};
        searchObj.search(keyTemplate, data);
    }

    @Test
    public void testSearchResultKeyFound() {
        BinarySearch searchObj = new BinarySearch();
        final int[] data = new int[] {1, 2, 6, 9};
        for (int i = 0; i < data.length; i++) {
            Assert.assertEquals(i, searchObj.search(data[i], data).getPosition());
            Assert.assertTrue(searchObj.search(data[i], data).isFound());
        }
    }

    @Test
    public void testSearchResultKeyNotFound() {
        BinarySearch searchObj = new BinarySearch();
        final int[] data = new int[] {1, 2, 6, 9};
        final int templateKey = 5;
        final int valueNotFound = -1;
        Assert.assertEquals(valueNotFound, searchObj.search(templateKey, data).getPosition());
        Assert.assertFalse(searchObj.search(templateKey, data).isFound());
    }

    @Test
    public void testSearchResultMiddleElement() {
        BinarySearch searchObj = new BinarySearch();
        final int[] data = new int[] {1, 3, 5, 7, 9};
        final int position = data.length / 2 + 1;
        final int templateKey = data[position];
        Assert.assertEquals(position, searchObj.search(templateKey, data).getPosition());
        Assert.assertTrue(searchObj.search(templateKey, data).isFound());
    }

    @Test
    public void testSearchResultInSequence() {
        BinarySearch searchObj = new BinarySearch();
        final int[] data = new int[] {1};
        final int position = 0;
        final int templateKey = 1;
        Assert.assertEquals(position, searchObj.search(templateKey, data).getPosition());
        Assert.assertTrue(searchObj.search(templateKey, data).isFound());
    }

    @Test
    public void testSearchResultInSequenceNotFound() {
        BinarySearch searchObj = new BinarySearch();
        final int[] data = new int[] {1};
        final int position = -1;
        final int templateKey = Integer.MAX_VALUE;
        Assert.assertEquals(position, searchObj.search(templateKey, data).getPosition());
        Assert.assertFalse(searchObj.search(templateKey, data).isFound());
    }

    @Test
    public void testSearchResultIsFirst() {
        BinarySearch searchObj = new BinarySearch();
        final int[] data = new int[] {1, 3, 7};
        final int position = 0;
        final int templateKey = data[position];
        Assert.assertEquals(position, searchObj.search(templateKey, data).getPosition());
        Assert.assertTrue(searchObj.search(templateKey, data).isFound());
    }

    @Test
    public void testSearchResultIsLast() {
        BinarySearch searchObj = new BinarySearch();
        final int[] data = new int[] {1, 3, 7};
        final int position = data.length - 1;
        final int templateKey = data[position];
        Assert.assertEquals(position, searchObj.search(templateKey, data).getPosition());
        Assert.assertTrue(searchObj.search(templateKey, data).isFound());
    }
}
