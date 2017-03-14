/**
 * 
 */
package edu.iis.mto.bsearch;

import java.util.Arrays;
import java.util.List;

/**
 * Utility Class dla wyszukiwania binarnego
 * 
 */
public class BinarySearch {

    /**
     * Metoda realizujaca wyszukiwanie binarne
     * 
     * @param key
     *            - szukany obiekt
     * @param seq
     *            - rosnaco uporzadkowana niepusta sekwencja
     * @return obiekt rezultatu o polach: - found (true jezeli znaleziony) - position (jezeli znaleziony - pozycja w
     *         sekwencji, jezeli nie znaleziony -1)
     */
    public static SearchResult search(int key, int[] seq) {
        int start = 0;
        int end = seq.length - 1;
        int center;
        int[] res = null;
        SearchResult result = new SearchResult();
        if (seq.length == 0)
            throw new IllegalArgumentException("Empty data");
        while (start <= end) {
            center = start + (end - start) / 2;

            if (key < seq[center])
                end = center - 1;
            else if (key > seq[center])
                start = center + 1;
            else {
                result.setPosition(center);
                break;

            }

        }

        return result;
    }

}
