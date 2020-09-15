package design;

/**
 * @author chenglee
 * @date 2020/9/14 11:14
 * @description：并查集
 * 使用一个数组实现，数组下标表示元素，当前下标上的元素表示它的父节点，或者说具有连通性的节点；
 * 1.用于判断元素是否在同一个集合中，如果在同一个集合中，那么元素的父节点最终会指向同一个元素。
 * 2.用于判断集合的数量，如果下标与集合元素相等，代表它没有父节点，也就是说它就是根节点，也就代表着一个集合。
 * 使用场景：
 * (1) 图的连通性
 */
public class UnionFind {
    private int[] roots;

    public UnionFind(int size){
        this.roots = new int[size];
        for (int i = 0; i < size; i++){
            roots[i] = i;
        }
    }

    public int find(int val){
        if (roots[val] != val){
            roots[val] = find(roots[val]);
        }
        return val;
    }
    public void union(int val1, int val2){
        int root1 = find(val1);
        int root2 = find(val2);
        if (root1 != root2){
            roots[root1] = root2;
        }
    }
}
