/*
Week One: Weighted Quick Union

Time complexities:
Initialization: Best case: O(n)
Initialization: Worst case: O(n)

Union: Best case: O(1)
Union: Worst case: O(lg(n))

Find: Best case: O(1)
Find: Worst case: O(lg(n))

Space complexity:
O(n)
*/

public class WeightedQuickUnion {
    private final int[] array;
    private final int[] weight;

    public WeightedQuickUnion(final int arrayLength) {
        array = new int[arrayLength];
        weight = new int[arrayLength];

        for (int index = 0; index < array.length; index++)
            array[index] = index;
    }

    public void union(final int indexOne, final int indexTwo) {
        final int elementOneParent = root(indexOne);
        final int elementTwoParent = root(indexTwo);

        if (weight[elementOneParent] > weight[elementTwoParent]) {
            array[elementTwoParent] = elementOneParent;
            weight[elementOneParent] += weight[elementTwoParent];
        } else {
            array[elementOneParent] = elementTwoParent;
            weight[elementTwoParent] += weight[elementOneParent];
        }
    }

    public boolean find(final int indexOne, final int indexTwo) {
        return root(indexOne) == root(indexTwo);
    }

    private int root(int index) {
        while (array[index] != index)
            index = array[index];

        return index;
    }
}

