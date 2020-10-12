package com.company;

/*
Week Two: Weighted Quick Union

Time complexities:
Get: Best case: O(1)
Get: Worst case: O(1)

Add: Best case: O(1)
Add: Worst case: O(length)

Remove: Best case: O(1)
Remove: Worst case: O(length)

Increase Length If Required: Best case: O(1)
Increase Length If Required: Worst case: O(length)

Reduce Length If Required: Best case: O(1)
Reduce Length If Required: Worst case: O(length)

Space complexity:
Increase Length If Required: Best case: O(1)
Increase Length If Required: Worst case: O(array.length)

Reduce Length If Required: Best case: O(1)
Reduce Length If Required: Worst case: O(array.length)
*/

public class DynamicArray<T> {
    private T[] array;
    private int length;

    @SuppressWarnings("unchecked")
    public DynamicArray(final int arrayLength) {
        if (arrayLength < 1) {
            throw new IllegalArgumentException();
        }

        array = (T[]) new Object[arrayLength];
        length = 0;
    }

    public DynamicArray() {
        this(1);
    }

    public T get(final int index) {
        validateIndex(index, 0, length);

        return array[index];
    }

    public void add(final T data) {
        increaseLengthIfRequired();

        array[length++] = data;
    }

    public void add(T data, final int index) {
        validateIndex(index, 0, length + 1);

        increaseLengthIfRequired();

        for (int iterator = index; iterator < length; iterator++) {
            T swapValue = data;
            data = array[iterator];
            array[iterator] = swapValue;
        }

        array[length++] = data;
    }

    public void remove() {
        reduceLengthIfRequired();

        array[length-- - 1] = null;
    }

    public void remove(final int index) {
        validateIndex(index, 0, length);

        reduceLengthIfRequired();

        for (int iterator = index; iterator < length - 1; iterator++) {
            array[iterator] = array[iterator + 1];
        }

        array[length-- - 1] = null;
    }

    @SuppressWarnings("unchecked")
    private void increaseLengthIfRequired() {
        if (length == array.length) {
            T[] temporaryArray = (T[]) new Object[array.length * 2];

            for (int index = 0; index < array.length; index++) {
                temporaryArray[index] = array[index];
            }

            array = temporaryArray;
        }
    }

    @SuppressWarnings("unchecked")
    private void reduceLengthIfRequired() {
        if (length == array.length / 4) {
            T[] temporaryArray = (T[]) new Object[array.length / 2];

            for (int index = 0; index < array.length; index++) {
                temporaryArray[index] = array[index];
            }

            array = temporaryArray;
        }
    }

    private void validateIndex(final int index, final int startBound, final int endBound) {
        if (index < startBound || index > endBound) {
            throw new IllegalArgumentException();
        }
    }

    public int length() {
        return length;
    }

    public void print() {
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + " ");
        }

        System.out.println();
    }
}
