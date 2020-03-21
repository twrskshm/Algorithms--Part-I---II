import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int N, ARRAY_LENGTH, VIRTUAL_TOP_INDEX, VIRTUAL_BOTTOM_INDEX;
    private int[] nodes;
    private boolean[] open;
    private int number_of_open_sites;
    private WeightedQuickUnionUF weighted_quick_union;

    public Percolation(int n) {
        validate(n);

        N = n;
        ARRAY_LENGTH = (n * n) + 2;
        VIRTUAL_TOP_INDEX = 0;
        VIRTUAL_BOTTOM_INDEX = ARRAY_LENGTH - 1;

        nodes = new int[ARRAY_LENGTH];

        open = new boolean[ARRAY_LENGTH];

        weighted_quick_union = new WeightedQuickUnionUF(ARRAY_LENGTH);
        for(int i = 1, j = VIRTUAL_BOTTOM_INDEX - 1; i <= N; i++, j--) {
            weighted_quick_union.union(VIRTUAL_TOP_INDEX, i);
            weighted_quick_union.union(VIRTUAL_BOTTOM_INDEX, j);
        }
    }

    public void open(int row, int col) {
        validate(row, col);

        int[][] adjacent_node_indices = {
                {row - 1, col},
                {row + 1, col},
                {row, col - 1},
                {row, col + 1}
        };

        int index = index(row, col);
        for(int[] indices: adjacent_node_indices) {
            int adjacent_node_index = index(indices[0], indices[1]);

            if(indices[0] > 0 && indices[0] <= N && indices[1] > 0 && indices[1] <= N)
                if(isOpen(indices[0], indices[1]) && !weighted_quick_union.connected(index, adjacent_node_index))
                    weighted_quick_union.union(index, adjacent_node_index);
        }

        open[index] = true;
        number_of_open_sites++;
    }

    public boolean isOpen(int row, int col) {
        validate(row, col);

        return open[index(row, col)];
    }

    public boolean isFull(int row, int col) {
        validate(row, col);

        return weighted_quick_union.connected(VIRTUAL_TOP_INDEX, index(row, col));
    }

    public int numberOfOpenSites() {
        return number_of_open_sites;
    }

    public boolean percolates() {
        return weighted_quick_union.connected(VIRTUAL_TOP_INDEX, VIRTUAL_BOTTOM_INDEX);
    }

    public void validate(int row, int col) {
        if(row < 1 || row > N || col < 1 || col > N)
            throw new IllegalArgumentException();
    }

    public void validate(int n) {
        if(n < 1)
            throw new IllegalArgumentException();
    }

    public int index(int row, int col) {
        return ((row - 1) * N) + col;
    }
}