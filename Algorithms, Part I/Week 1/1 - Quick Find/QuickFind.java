package com.company;

public class QuickFind {
    private int[] array;

    public QuickFind(int n) {
        array = new int[n];

        for(int i = 0; i < n; i++)
            array[i] = i;
    }

    public boolean connected(int index_one, int index_two) {
        return array[index_one] == array[index_two];
    }

    public void union(int index_one, int index_two) {
        int node_one_parent_id = array[index_one];
        int node_two_parent_id = array[index_two];

        for(int i = 0; i < array.length; i++)
            if(array[i] == node_two_parent_id)
                array[i] = node_one_parent_id;
    }
}
