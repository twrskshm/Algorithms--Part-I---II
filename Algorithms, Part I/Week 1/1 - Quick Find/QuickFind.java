/*
Week One: Quick Find

Time complexities:
Initialization: Best case: O(n)
Initialization: Worst case: O(n)

Union: Best case: O(n)
Union: Worst case: O(n)

Find: Best case: O(1)
Find: Worst case: O(1)

Space complexity:
O(1)
*/

public class QuickFind {
    private final int[] array;

    public QuickFind(final int arrayLength) {
        array = new int[arrayLength];

        for (int index = 0; index < array.length; index++)
            array[index] = index;
    }

    public void union(final int indexOne, final int indexTwo) {
        for (int index = 0; index < array.length; index++)
            if (array[index] == array[indexTwo])
                array[index] = array[indexOne];
    }

    public boolean find(final int indexOne, final int indexTwo) {
        return array[indexOne] == array[indexTwo];
    }
}
