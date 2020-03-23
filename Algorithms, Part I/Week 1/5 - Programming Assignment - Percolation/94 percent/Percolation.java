import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int n, virtualTopIndex, virtualBottomIndex;
    private boolean[] open;
    private int numberOfOpenSites;
    private final WeightedQuickUnionUF weightedQuickUnionUF;

    public Percolation(int n) {
        validate(n);

        this.n = n;
        int arrayLength = (n * n) + 2;
        virtualTopIndex = 0;
        virtualBottomIndex = arrayLength - 1;

        open = new boolean[arrayLength];

        weightedQuickUnionUF = new WeightedQuickUnionUF(arrayLength);
        for (int i = 1, j = virtualBottomIndex - 1; i <= n; i++, j--) {
            weightedQuickUnionUF.union(virtualTopIndex, i);
            weightedQuickUnionUF.union(virtualBottomIndex, j);
        }
    }

    public void open(int row, int col) {
        validate(row, col);

        int index = index(row, col);
        if (!isOpen(row, col)) {
            open[index] = true;
            numberOfOpenSites++;

            int[][] adjacentNodeCoordinates = {
                    {row - 1, col},
                    {row + 1, col},
                    {row, col - 1},
                    {row, col + 1}
            };

            for (int[] coordinates: adjacentNodeCoordinates) {
                if (coordinates[0] > 0 && coordinates[0] <= n && coordinates[1] > 0 && coordinates[1] <= n) {
                    int adjacentNodeIndex = index(coordinates[0], coordinates[1]);

                    if (isOpen(coordinates[0], coordinates[1]) && !weightedQuickUnionUF.connected(index, adjacentNodeIndex)) {
                        weightedQuickUnionUF.union(index, adjacentNodeIndex);
                    }
                }
            }
        }
    }

    public boolean isOpen(int row, int col) {
        validate(row, col);

        return open[index(row, col)];
    }

    public boolean isFull(int row, int col) {
        validate(row, col);

        return isOpen(row, col) && weightedQuickUnionUF.connected(virtualTopIndex, index(row, col));
    }

    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    public boolean percolates() {
        return numberOfOpenSites >= n && weightedQuickUnionUF.connected(virtualTopIndex, virtualBottomIndex);
    }

    private void validate(int n) {
        if (n < 1)
            throw new IllegalArgumentException();
    }

    private void validate(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n)
            throw new IllegalArgumentException();
    }

    private int index(int row, int col) {
        return ((row - 1) * n) + col;
    }
}
