public class QuickUnion {
    private int array[];

    public QuickUnion(int n) {
        array = new int[n];

        for(int i = 0; i < n; i++) {
            array[i] = i;
        }
    }

    private int root(int node) {
        while(node != array[node]) {
            node = array[node];
        }

        return node;
    }

    public void union(int node_one, int node_two) {
        array[root(node_one)] = root(node_two);
    }

    public boolean connected(int node_one, int node_two) {
        return root(node_one) == root(node_two);
    }
}
