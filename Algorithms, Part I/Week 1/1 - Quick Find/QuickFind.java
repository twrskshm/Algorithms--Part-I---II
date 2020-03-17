/*
Java implementation of Quick Find, subcategory of Union Find algorithm that is used to solve dynamic connectivity problem
Author: Saksham Tiwari
Date: 17th March 2020
*/

public class QuickFind {
    private int[] array;

    public QuickFind(int array_length) {
        // Function that initializes 'array' as 0, 1, 2, 3, ..., (n - 1)
        array = new int[array_length];

        for(int i = 0; i < array_length; i++)
            array[i] = i;
    }

    public void union(int node_one_index, int node_two_index) {
        // Function that changes the parent of all the nodes that currently have parent as 'node_two' to 'node_one'
        int node_one_parent_index = array[node_one_index], node_two_parent_index = array[node_two_index];

        for(int i = 0; i < array.length; i++)
            if(array[i] == node_two_parent_index)
                array[i] = node_one_parent_index;
    }

    public boolean find(int node_one_index, int node_two_index) {
        // Function that checks whether the two nodes share the same parent
        return array[node_one_index] == array[node_two_index];
    }
}
