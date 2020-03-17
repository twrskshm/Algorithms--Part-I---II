/*
Java implementation of Quick Union, subcategory of Union Find algorithm that is used to solve dynamic connectivity problem
Author: Saksham Tiwari
Date: 17th March 2020
*/

public class QuickUnion {
    private int[] array;

    public QuickUnion(int array_length) {
        // Function that initializes 'array' as 0, 1, 2, 3, ..., (n - 1)
        array = new int[array_length];

        for(int i = 0; i < array_length; i++)
            array[i] = i;
    }

    public void union(int node_one_index, int node_two_index) {
        // Function that changes the parent of the root of 'node_two' to the root of 'node_one'
        array[root(node_two_index)] = root(node_one_index);
    }

    public boolean find(int node_one_index, int node_two_index) {
        // Function that checks whether the two nodes share the same parent
        return root(node_one_index) == root(node_two_index);
    }

    public int root(int node_index) {
        // Function that finds the root of a node
        while(node_index != array[node_index])
            node_index = array[node_index];

        return node_index;
    }
}
