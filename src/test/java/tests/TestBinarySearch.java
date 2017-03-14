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
    public void testSearchResultAscending() {
        BinarySearch searchObj = new BinarySearch();
        int keyTemplate = 1;
        int[] data = new int[] {2,5,4,1};
        int[] dataTemplate = new int[] {1,2,4,5};
        Assert.assertArrayEquals(dataTemplate, searchObj.search(null, data).getSortedlist());
    }
}
