/*
Java implementation of Weighted Quick Union, an improvement of Quick Union algorithm
Author: Saksham Tiwari
Date: 17th March 2020
*/

package com.company;

public class WeightedQuickUnion {
    private int[] array, weights;

    public WeightedQuickUnion(int array_length) {
        // Function that initializes 'array' as 0, 1, 2, 3, ..., (n - 1) and 'weights' as 0, 0, 0, ...
        array = new int[array_length];
        weights = new int[array_length];

        for(int i = 0; i < array_length; i++)
            array[i] = i;
    }

    public void union(int node_one_index, int node_two_index) {
        // Function that changes the parent of the root of 'node_two' to the root of 'node_one', or the parent of the root of 'node_one' to the root of 'node_two' depending on the weights of both subtrees
        int node_one_root_index = root(node_one_index), node_two_root_index = root(node_two_index);

        if(weights[node_one_root_index] > weights[node_two_root_index]) {
            array[node_two_root_index] = node_one_root_index;
            weights[node_one_root_index] += weights[node_two_root_index];
        } else {
            array[node_one_root_index] = node_two_root_index;
            weights[node_two_root_index] += weights[node_one_root_index];
        }
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
