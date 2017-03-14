/**
 * 
 */
package edu.iis.mto.bsearch;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {

	private static final int NOT_FOUND = -1;
	private int position = NOT_FOUND;
        private int[] sortedlist;

    public int[] getSortedlist() {
        return sortedlist;
    }

    public void setSortedlist(int[] sortedlist) {
        this.sortedlist = sortedlist;
    }

	public boolean isFound() {
		return position > NOT_FOUND;
	}

	void setPosition(int position) {
		if (position > NOT_FOUND) {
			this.position = position;
		}
	}

	public int getPosition() {
		return position;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SearchResult) {
			return this.position == ((SearchResult) obj).position;

		}
		return false;
	}
        
	@Override
	public String toString() {

		return isFound() ? "( elem at position " + position + ")"
				: "elem not found";
	}
}