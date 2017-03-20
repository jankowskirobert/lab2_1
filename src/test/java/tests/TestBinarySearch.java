/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose
 * Tools | Templates and open the template in the editor.
 */
package tests;

import edu.iis.mto.bsearch.BinarySearch;
import static org.hamcrest.Matchers.is;
import org.junit.Assert;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author jankowskirobert
 */
public class TestBinarySearch {

    @Test(expected = IllegalArgumentException.class)
    public void testSearchResultThrowException() {
        int keyTemplate = 1;
        int[] data = new int[] {};
        BinarySearch.search(keyTemplate, data);        
    }

    @Test
    public void testSearchResultKeyFound() {
        final int[] data = new int[] {1, 2, 6, 9};
        for (int i = 0; i < data.length; i++) {
            Assert.assertThat(BinarySearch.search(data[i], data).isFound(), is(true));
            Assert.assertThat(i, is(BinarySearch.search(data[i], data).getPosition()));
        }
    }

    @Test
    public void testSearchResultKeyNotFound() {
        final int[] data = new int[] {1, 2, 6, 9};
        final int templateKey = 5;
        final int valueNotFound = -1;
        assertThat(BinarySearch.search(templateKey, data).getPosition(), is(valueNotFound));
        assertThat(BinarySearch.search(templateKey, data).isFound(), is(false));
    }

    @Test
    public void testSearchResultMiddleElement() {        
        final int[] data = new int[] {1, 3, 5, 7, 9};
        final int position = (data.length-1) / 2 ;
        final int templateKey = data[position];
        assertThat(BinarySearch.search(templateKey, data).getPosition(), is(position));
        assertThat(BinarySearch.search(templateKey, data).isFound(), is(true));
    }

    @Test
    public void testSearchResultInSequence() {
        final int[] data = new int[] {1};
        final int position = 0;
        final int templateKey = 1;
        assertThat(BinarySearch.search(templateKey, data).getPosition(), is(position));
        assertThat(BinarySearch.search(templateKey, data).isFound(), is(true));
    }

    @Test
    public void testSearchResultInSequenceNotFound() {
        final int[] data = new int[] {1};
        final int position = -1;
        final int templateKey = Integer.MAX_VALUE;
        assertThat(BinarySearch.search(templateKey, data).getPosition(), is(position));
        assertThat(BinarySearch.search(templateKey, data).isFound(), is(false));
    }

    @Test
    public void testSearchResultIsFirst() {
        final int[] data = new int[] {1, 3, 7};
        final int position = 0;
        final int templateKey = data[position];
        assertThat(BinarySearch.search(templateKey, data).getPosition(), is(position));
        assertThat(BinarySearch.search(templateKey, data).isFound(), is(true));
    }

    @Test
    public void testSearchResultIsLast() {
        final int[] data = new int[] {1, 3, 7};
        final int position = data.length - 1;
        final int templateKey = data[position];
        assertThat(BinarySearch.search(templateKey, data).getPosition(), is(position));
        assertThat(BinarySearch.search(templateKey, data).isFound(), is(true));
    }
    
    
}
