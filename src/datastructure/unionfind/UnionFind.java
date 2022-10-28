package datastructure.unionfind;

public class UnionFind {

    int[] parents;
    int[] size; // record each component's size
    int numOfComponent = 0; // how many components

    public UnionFind(int n) {
        parents = new int[n];
        size = new int[n];
        numOfComponent = n;

        for(int i = 0; i < n; i++) {
            parents[i] = i;
            size[i] = 1;
        }

    }

    public int find(int cur) {
        int root = cur;
        while(root != parents[root]) {
            root = parents[root];
        }

        //path compression ---> height = 2
        while(cur != root) {
            int preParent = parents[cur];
            parents[cur] = root;
            cur = preParent;
        }

        return root;
    }

    public int findComponentSize(int cur) {
        int parent = find(cur);
        return size[parent];
    }

    public void union(int node1, int node2) {
        int node1Parent = find(node1);
        int node2Parent = find(node2);

        if(node1Parent == node2Parent) {
            return;
        }

        if(size[node1Parent] > size[node2Parent]) {
            parents[node2Parent] = node1Parent;
            size[node1Parent] += node2Parent;
        } else {
            parents[node1Parent] = node2Parent;
            size[node2Parent] += node1Parent;
        }

        numOfComponent --;
    }

}
