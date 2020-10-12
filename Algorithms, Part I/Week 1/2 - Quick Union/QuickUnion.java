/*
Week One: Quick Union

Time complexities:
Initialization: Best case: O(n)
Initialization: Worst case: O(n)

Union: Best case: O(1)
Union: Worst case: O(n)

Find: Best case: O(1)
Find: Worst case: O(n)

Space complexity:
O(1)
*/

public class QuickUnion {
    private final int[] array;

    public QuickUnion(final int arrayLength) {
        array = new int[arrayLength];

        for (int index = 0; index < array.length; index++)
            array[index] = index;
    }

    public void union(final int indexOne, final int indexTwo) {
        array[root(indexTwo)] = root(indexOne);
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

