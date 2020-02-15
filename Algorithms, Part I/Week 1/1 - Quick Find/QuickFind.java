public class QuickFind {
    private int array[];

    public QuickFind(int n) {
        array = new int[n];

        for(int i = 0; i < n; i++) {
            array[i] = i;
        }
    }

    public void union(int node_one, int node_two) {
        int node_one_id = array[node_one];
        int node_two_id = array[node_two];

        for(int i = 0; i < array.length; i++) {
            if(array[i] == node_one_id) {
                array[i] = array[node_two_id];
            }
        }
    }

    public boolean connected(int node_one, int node_two) {
        return array[node_one] == array[node_two];
    }
}
