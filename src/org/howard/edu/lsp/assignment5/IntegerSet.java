package org.howard.edu.lsp.assignment5;
import java.util.*;
/**
 * A set of unique integers stored in insertion order.
 */
public class IntegerSet {
    private final Set<Integer> IntegerSet = new LinkedHashSet<>();

    /** Removes all elements from this set. */
    public void clear() {
        IntegerSet.clear();
    }
    /**
     * Returns the number of elements.
     * @return the size of this set
     */
    public int length() {
        return IntegerSet.size();
    }
    /**
     * Compares elements regardless of insertion order.
     * @param b the set to compare with this set
     * @return true if b is non-null and both sets have the same elements
     */
    public boolean equals(IntegerSet b) {
        return b!= null && this.IntegerSet.equals(b.IntegerSet);
    }
    /**
     * Checks whether this set contains the specified value.
     * @param value the integer to look for
     * @return true if the value is present
     */
    public boolean contains(int value) {
        return this.IntegerSet.contains(value);
    }
    /**
     * Returns the smallest element.
     * @return the minimum integer in this set
     * @throws IllegalStateException if this set is empty
     */
    public int smallest() {
        if (IntegerSet.isEmpty()) {
            throw new IllegalStateException();
        }
        int min = Integer.MAX_VALUE;
        for (int num: IntegerSet) {
            if (num <= min) {
                min = num;
            }
        }
        return min;
    }
    /**
     * Returns the largest element.
     * @return the maximum integer in this set
     * @throws IllegalStateException if this set is empty
     */
    public int largest() {
        if (IntegerSet.isEmpty()) {
            throw new IllegalStateException();
        }
        int max = Integer.MIN_VALUE;
        for (int num: IntegerSet) {
            if (num >= max) {
                max = num;
            }
        }
        return max;
    }
    /**
     * Adds an integer if it is not already present.
     * @param item the integer to add
     */
    public void add(int item) {
        IntegerSet.add(item); // sets can only have 1 of an item so a dupe does nothing
    }
    /**
     * Removes an integer if it is present.
     * @param item the integer to remove
     */
    public void remove(int item) {
        if (IntegerSet.contains(item)) {
            IntegerSet.remove(item);
        }
    }
    /**
     * Returns an independent set containing elements from either set.
     * @param b the other set; null is treated as an empty set
     * @return a new set containing the union
     */
    public IntegerSet union(IntegerSet b) {
        IntegerSet resultSet = new IntegerSet();

        resultSet.IntegerSet.addAll(this.IntegerSet);

        if (b != null) {
            resultSet.IntegerSet.addAll(b.IntegerSet);
        }
        return resultSet;
    }
    /**
     * Returns an independent set containing the elements shared by both sets.
     * @param b the other set; null is treated as an empty set
     * @return a new set containing the shared elements
     */
    public IntegerSet intersect(IntegerSet b) {
        IntegerSet resultSet = new IntegerSet();

        if (b == null) {
            return resultSet;
        }
        Set<Integer> smaller = this.IntegerSet;
        Set<Integer> larger = b.IntegerSet;
        if (smaller.size() > larger.size()) {
            smaller = b.IntegerSet;
            larger = this.IntegerSet;
        }

        for (int num : smaller) {
            if (larger.contains(num)) {
                resultSet.add(num);
            }
        }
        return resultSet;
    }
    /**
     * Returns the elements in this set that are absent from the other set.
     * @param b the other set; null is treated as an empty set
     * @return a new independent set containing this set minus b
     */
    public IntegerSet diff(IntegerSet b) {
        IntegerSet resultSet = new IntegerSet();
        for (int num : this.IntegerSet) {
            if (b == null || !b.contains(num)) {
                resultSet.add(num);
            }
        }
        return resultSet;
    }

    /**
     * Returns the elements in b that are absent from this set.
     * @param b the other set; null is treated as an empty set
     * @return a new independent set containing b minus this set
     */
    public IntegerSet complement(IntegerSet b) {
        IntegerSet resultSet = new IntegerSet();
        if (b == null) {
            return resultSet;
        }
        for (int num : b.IntegerSet) {
            if (!this.contains(num)) {
                resultSet.add(num);
            }
        }
        return resultSet;
    }

    /**
     * Checks whether every element of this set is in the other set.
     * @param b the other set; null is treated as an empty set
     * @return true if this set is a subset of b
     */
    public boolean isSubsetOf(IntegerSet b) {
        if (b == null) {
            return this.isEmpty();
        }
        if (this.length() > b.length()) {
            return false;
        }
        for (int num : this.IntegerSet) {
            if (!b.contains(num)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks whether the two sets have no shared elements.
     * @param b the other set; null is treated as an empty set
     * @return true if the sets share no elements
     */
    public boolean isDisjoint(IntegerSet b) {
        if (b == null) {
            return true;
        }
        Set<Integer> smaller = this.IntegerSet;
        Set<Integer> larger = b.IntegerSet;
        if (smaller.size() > larger.size()) {
            smaller = b.IntegerSet;
            larger = this.IntegerSet;
        }
        for (int num : smaller) {
            if (larger.contains(num)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the elements that occur in exactly one of the two sets.
     * @param b the other set; null is treated as an empty set
     * @return a new independent set containing the symmetric difference
     */
    public IntegerSet symmetricDiff(IntegerSet b) {
        IntegerSet resultSet = this.diff(b);
        resultSet.IntegerSet.addAll(this.complement(b).IntegerSet);
        return resultSet;
    }

    /**
     * Returns the elements in ascending order, enclosed in square brackets.
     * @return a comma-separated representation, or [] if this set is empty
     */
    @Override
    public String toString() {
        List<Integer> sorted = new ArrayList<>(this.IntegerSet);
        Collections.sort(sorted);
        return sorted.toString();
    }

    /**
     * Checks whether this set has no elements.
     * @return true if this set is empty
     */
    public boolean isEmpty() {
        return (this.length() == 0);
    }
}
