package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Assignment 6: JUnit 5 tests for IntegerSet.
 *
 * Keep every predefined test method and ensure tests run independently.
 * Each test must contain meaningful assertions and run independently.
 */
public class IntegerSetTest {
    private IntegerSet set;

    private IntegerSet makeSet(int... values) {
        IntegerSet result = new IntegerSet();
        for (int value : values) {
            result.add(value);
        }
        return result;
    }

    @BeforeEach
    void setUp() {
        set = new IntegerSet();
    }
    // ===== clear() =====

    /**
     * Create a populated set; call clear(); assert that it is empty and its length is zero.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testClearClearsPopulatedSet() {
        set.add(10);
        set.add(20);
        set.add(30);
        assertEquals(3, set.length());

        set.clear();

        assertTrue(set.isEmpty(), "Set should be empty after clearing");
        assertEquals(0, set.length(), "Length should be 0");
        assertFalse(set.contains(10), "Set should not have previous integers");
        assertFalse(set.contains(20), "Set should not have previous integers");
        assertFalse(set.contains(30), "Set should not have previous integers");
    }

    /**
     * Clear an already empty set; verify it remains empty.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testClearClearsEmptySet() {

        assertTrue(set.isEmpty(), "A new set should be empty before clear");

        set.clear();

        assertTrue(set.isEmpty(), "Clearing an empty set should leave it empty");
        assertEquals(0, set.length(), "Length should remain zero");

    }

    // ===== length() =====

    /**
     * Add repeated and unique integers; assert the number of distinct elements.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLengthCountsUniqueElements() {
        set.add(4);
        set.add(4);
        set.add(-2);
        set.add(9);

        assertEquals(3, set.length());
        assertTrue(set.contains(4));
        assertTrue(set.contains(-2));
        assertTrue(set.contains(9));
    }

    /**
     * Verify a new empty set has length zero.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLengthEmptySetLength() {
        assertEquals(0, set.length());
    }

    // ===== equals() =====

    /**
     * Construct sets with identical elements in different insertion orders; assert equality.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsIgnoresInsertionOrder() {
        IntegerSet other = makeSet(2, 3, 1);
        set.add(1);
        set.add(2);
        set.add(3);

        assertTrue(set.equals(other));
        assertTrue(other.equals(set));
    }

    /**
     * Construct sets of equal length with different elements; assert inequality.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsDetectsDifferentContents() {
        IntegerSet other = makeSet(1, 3);
        set.add(1);
        set.add(2);

        assertEquals(set.length(), other.length());
        assertFalse(set.equals(other));
    }

    /**
     * Verify two separately constructed empty sets compare equal.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsEmptySetsEqual() {
        assertTrue(set.equals(new IntegerSet()));
    }

    /**
     * Verify a set equals itself and differs from a set of another size.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsSameObjectAndDifferentSizes() {
        IntegerSet differentSize = makeSet(1);
        set.add(1);
        set.add(2);

        assertTrue(set.equals(set));
        assertFalse(set.equals(differentSize));
    }

    // ===== contains() =====

    /**
     * Verify contains() is true for a present element and false for an absent one.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testContainsPresentAndAbsent() {
        set.add(-7);

        assertTrue(set.contains(-7));
        assertFalse(set.contains(0));
    }

    /**
     * Verify an empty set does not contain an arbitrary integer.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testContainsEmptySetContainsNothing() {
        assertFalse(set.contains(42));
        assertEquals(0, set.length());
    }

    // ===== largest() =====

    /**
     * Verify largest() returns the maximum across negative, zero, and positive values.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLargestNegativeAndPositiveValues() {
        set.add(-10);
        set.add(0);
        set.add(6);
        set.add(Integer.MAX_VALUE);

        assertEquals(Integer.MAX_VALUE, set.largest());
        assertEquals(6, makeSet(-10, 0, 6).largest());
        assertEquals(-2, makeSet(-10, -2, -7).largest());
    }

    /**
     * Use assertThrows() to verify IllegalStateException for an empty set.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLargestEmptySetThrowsException() {
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> set.largest());
        assertNotNull(exception);
    }

    // ===== smallest() =====

    /**
     * Verify smallest() returns the minimum across negative, zero, and positive values.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSmallestNegativeAndPositiveValues() {
        set.add(-10);
        set.add(0);
        set.add(6);
        set.add(Integer.MIN_VALUE);

        assertEquals(Integer.MIN_VALUE, set.smallest());
        assertEquals(-10, makeSet(-10, 0, 6).smallest());
        assertEquals(2, makeSet(10, 2, 7).smallest());
    }

    /**
     * Use assertThrows() to verify IllegalStateException for an empty set.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSmallestEmptySetThrowsException() {
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> set.smallest());
        assertNotNull(exception);
    }

    // ===== add() =====

    /**
     * Add the same integer repeatedly; verify only one copy exists.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testAddIgnoresDuplicates() {
        set.add(11);
        set.add(11);
        set.add(11);

        assertEquals(1, set.length());
        assertTrue(set.contains(11));
    }

    /**
     * Add Integer.MIN_VALUE, Integer.MAX_VALUE, and zero; verify all are represented.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testAddHandlesIntegerBoundaries() {
        set.add(Integer.MIN_VALUE);
        set.add(0);
        set.add(Integer.MAX_VALUE);

        assertEquals(3, set.length());
        assertTrue(set.contains(Integer.MIN_VALUE));
        assertTrue(set.contains(0));
        assertTrue(set.contains(Integer.MAX_VALUE));
    }

    // ===== remove() =====

    /**
     * Remove a present element; verify it is absent and others remain.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testRemoveRemovesExistingElement() {
        set.add(1);
        set.add(2);
        set.add(3);
        set.remove(2);
        assertFalse(set.contains(2));
        assertTrue(set.contains(1));
        assertTrue(set.contains(3));
        assertEquals(2, set.length());
    }

    /**
     * Remove an absent element; verify the set is unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testRemoveIgnoresAbsentElement() {
        set.add(1);
        set.add(3);
        set.remove(2);
        assertEquals(2, set.length());
        assertTrue(set.contains(1));
        assertTrue(set.contains(3));
    }

    // ===== union() =====

    /**
     * Verify union() contains all distinct elements from two overlapping sets.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testUnionOverlappingSets() {
        IntegerSet b = makeSet(2, 3);
        set.add(1);
        set.add(2);

        IntegerSet result = set.union(b);

        assertEquals(3, result.length());
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
        assertTrue(set.equals(makeSet(1, 2)));
        assertTrue(b.equals(makeSet(2, 3)));
    }

    /**
     * Verify union with an empty set and with the same object.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testUnionEmptyAndSameOperand() {
        set.add(4);
        set.add(9);
        assertTrue(set.union(new IntegerSet()).equals(set));
        assertTrue(set.union(set).equals(set));
    }

    /**
     * Verify both inputs remain unchanged; modify the result and verify the inputs are still unchanged.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testUnionDoesNotMutateInputs() {
        IntegerSet b = makeSet(2, 3);
        set.add(1);
        set.add(2);
        IntegerSet r = set.union(b);
        assertTrue(set.equals(makeSet(1, 2)));
        assertTrue(b.equals(makeSet(2, 3)));
        assertNotSame(set, r);
        assertNotSame(b, r);
        r.add(9);
        assertTrue(set.equals(makeSet(1, 2)));
        assertTrue(b.equals(makeSet(2, 3)));
    }

    // ===== intersect() =====

    /**
     * Verify intersection contains exactly the shared elements.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIntersectOverlappingSets() {
        IntegerSet b = makeSet(2, 3, 4);
        set.add(1);
        set.add(2);
        set.add(3);

        IntegerSet result = set.intersect(b);

        assertEquals(2, result.length());
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
        assertFalse(result.contains(1));
        assertFalse(result.contains(4));
    }

    /**
     * Verify disjoint intersection is empty and self-intersection is unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIntersectDisjointAndSameOperand() {
        IntegerSet b = makeSet(3);
        set.add(1);
        set.add(2);
        assertTrue(set.intersect(b).isEmpty());
        assertTrue(set.intersect(set).equals(set));
    }

    /**
     * Modify the intersection result and verify both input sets remain unchanged.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testIntersectIndependentResult() {
        IntegerSet b = makeSet(2, 3);
        set.add(1);
        set.add(2);
        IntegerSet r = set.intersect(b);
        assertTrue(r.equals(makeSet(2)));
        assertNotSame(set, r);
        assertNotSame(b, r);
        r.add(9);
        assertTrue(set.equals(makeSet(1, 2)));
        assertTrue(b.equals(makeSet(2, 3)));
    }

    // ===== diff() =====

    /**
     * Verify A.diff(B) returns elements in A but not B, and distinguish direction.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testDiffDirectionMatters() {
        IntegerSet b = makeSet(2, 4);
        set.add(1);
        set.add(2);
        set.add(3);

        IntegerSet forward = set.diff(b);
        IntegerSet reverse = b.diff(set);

        assertEquals(2, forward.length());
        assertTrue(forward.contains(1));
        assertTrue(forward.contains(3));
        assertFalse(forward.contains(2));
        assertEquals(1, reverse.length());
        assertTrue(reverse.contains(4));
    }

    /**
     * Verify difference with an empty set and difference with itself.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testDiffEmptyAndSameOperand() {
        set.add(4);
        set.add(7);
        assertTrue(set.diff(new IntegerSet()).equals(set));
        assertTrue(set.diff(set).isEmpty());
    }

    /**
     * Modify the difference result and verify neither input changes.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testDiffIndependentResult() {
        IntegerSet b = makeSet(2, 3);
        set.add(1);
        set.add(2);
        IntegerSet r = set.diff(b);
        assertTrue(r.equals(makeSet(1)));
        assertNotSame(set, r);
        assertNotSame(b, r);
        r.add(9);
        assertTrue(set.equals(makeSet(1, 2)));
        assertTrue(b.equals(makeSet(2, 3)));
    }

    // ===== complement() =====

    /**
     * Verify A.complement(B) returns elements in B but not A.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testComplementReverseDifference() {
        IntegerSet b = makeSet(2, 3, 4);
        set.add(1);
        set.add(2);
        assertTrue(set.complement(b).equals(makeSet(3, 4)));
    }

    /**
     * Verify complement with an empty receiver and with an empty argument.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testComplementEmptyOperands() {
        IntegerSet b = makeSet(1, 2);
        assertTrue(set.complement(b).equals(b));
        assertTrue(b.complement(set).isEmpty());
    }

    /**
     * Modify the complement result and verify neither input changes.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testComplementIndependentResult() {
        IntegerSet b = makeSet(2, 3);
        set.add(1);
        set.add(2);
        IntegerSet r = set.complement(b);
        assertTrue(r.equals(makeSet(3)));
        assertNotSame(set, r);
        assertNotSame(b, r);
        r.add(9);
        assertTrue(set.equals(makeSet(1, 2)));
        assertTrue(b.equals(makeSet(2, 3)));
    }

    // ===== isSubsetOf() =====

    /**
     * Verify a proper subset is recognized.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfProperSubset() {
        IntegerSet b = makeSet(1, 2, 3);
        set.add(1);
        set.add(2);
        assertTrue(set.isSubsetOf(b));
        assertFalse(b.isSubsetOf(set));
    }

    /**
     * Verify a set with an element missing from the other set is not a subset.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfNotSubset() {
        IntegerSet b = makeSet(1, 2);
        set.add(1);
        set.add(4);
        assertFalse(set.isSubsetOf(b));
    }

    /**
     * Verify equal sets are subsets of each other.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsSubsetOfEqualSets() {
        IntegerSet b = makeSet(3, -1);
        set.add(-1);
        set.add(3);
        assertTrue(set.isSubsetOf(b));
        assertTrue(b.isSubsetOf(set));
    }

    /**
     * Verify the empty set is a subset of a nonempty set, but not vice versa.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfEmptyCases() {
        IntegerSet b = makeSet(1);
        assertTrue(set.isSubsetOf(b));
        assertFalse(b.isSubsetOf(set));
    }

    // ===== isDisjoint() =====

    /**
     * Verify disjoint sets return true.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointNoOverlap() {
        IntegerSet b = makeSet(3, 4);
        set.add(1);
        set.add(2);
        assertTrue(set.isDisjoint(b));
        assertTrue(b.isDisjoint(set));
    }

    /**
     * Verify overlapping sets return false.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointOverlap() {
        IntegerSet b = makeSet(2, 3);
        set.add(1);
        set.add(2);
        assertFalse(set.isDisjoint(b));
    }

    /**
     * Verify disjointness with an empty set and with the same nonempty object.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointEmptyAndSameOperand() {
        set.add(7);
        assertTrue(set.isDisjoint(new IntegerSet()));
        assertFalse(set.isDisjoint(set));
    }

    // ===== symmetricDiff() =====

    /**
     * Verify symmetric difference contains elements appearing in exactly one set.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testSymmetricDiffPartiallyOverlappingSets() {
        IntegerSet b = makeSet(3, 4);
        set.add(1);
        set.add(2);
        set.add(3);
        assertTrue(set.symmetricDiff(b).equals(makeSet(1, 2, 4)));
    }

    /**
     * Verify symmetric difference of identical sets is empty.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffIdenticalSets() {
        set.add(1);
        set.add(2);
        assertTrue(set.symmetricDiff(makeSet(2, 1)).isEmpty());
    }

    /**
     * Verify behavior with an empty set and with disjoint sets.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffEmptyAndDisjointSets() {
        IntegerSet b = makeSet(5, 6);
        assertTrue(set.symmetricDiff(b).equals(b));
        set.add(1);
        set.add(2);
        assertTrue(set.symmetricDiff(b).equals(makeSet(1, 2, 5, 6)));
    }

    /**
     * Modify the result and verify both input sets remain unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffIndependentResult() {
        IntegerSet b = makeSet(2, 3);
        set.add(1);
        set.add(2);
        IntegerSet r = set.symmetricDiff(b);
        assertTrue(r.equals(makeSet(1, 3)));
        assertNotSame(set, r);
        assertNotSame(b, r);
        r.add(9);
        assertTrue(set.equals(makeSet(1, 2)));
        assertTrue(b.equals(makeSet(2, 3)));
    }

    // ===== isEmpty() =====

    /**
     * Verify a newly constructed set is empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyNewSet() {
        assertTrue(set.isEmpty());
    }

    /**
     * Verify a set with an element is not empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyPopulatedSet() {
        set.add(0);
        assertFalse(set.isEmpty());
    }

    /**
     * Clear a populated set and verify it is empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyAfterClear() {
        set.add(1);
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals(0, set.length());
    }

    // ===== toString() =====

    /**
     * Verify elements appear in ascending numeric order regardless of insertion order.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testToStringAscendingOrder() {
        set.add(8);
        set.add(-2);
        set.add(4);
        set.add(0);
        assertEquals("[-2, 0, 4, 8]", set.toString());
    }

    /**
     * Verify an empty set formats as [].
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testToStringEmptyFormatting() {
        assertEquals("[]", set.toString());
    }

    /**
     * Verify comma-space formatting, brackets, and duplicate suppression.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testToStringExactSpacingAndDuplicates() {
        set.add(3);
        set.add(1);
        set.add(3);
        set.add(2);
        assertEquals("[1, 2, 3]", set.toString());
    }

}


