import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] fractions;
    private double trials;

    public PercolationStats(int n, int trials) {
        if(n < 1 || trials < 1)
            throw new IllegalArgumentException();

        this.trials = trials;
        fractions = new double[trials];

        Percolation percolation;
        for(int index = 0; index < trials; index++) {
            percolation = new Percolation(n);

            while(!percolation.percolates()) {
                int i = StdRandom.uniform(1, n + 1), j = StdRandom.uniform(1, n + 1);
                percolation.open(i, j);
            }

            fractions[index] = (double) percolation.numberOfOpenSites() / (n * n);
        }
    }

    public double mean() {
        return StdStats.mean(fractions);
    }

    public double stddev() {
        return StdStats.stddev(fractions);
    }

    public double confidenceLo() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(trials));
    }

    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(trials));
    }
}
