package problems.cut_off_trees_for_golf_event;


import java.util.*;


class Solution {
    public int cutOffTree(List<List<Integer>> forest) {

        //start from 0,0
        //go to shortest tree (for this I have to know which one is next)
        //calculate shortest distance with BFS or Dijisktra or A*
        //sum all distances and return answer

        //BFS and dijiskta is same when all distances are 1 or equal length
        //a* is an intelligent algorithm that does not traverse all nodes.

        //here since all the distances are equal, we will use BFS

        List<int[]> trees = new ArrayList<>();
        int R = forest.size();
        int C = forest.get(0).size();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }

        trees.sort((a, b) -> Integer.compare(a[2], b[2]));

        int sr = 0, sc = 0;
        int minDist = 0;
        for (int[] tree : trees) {
            int tr = tree[0];
            int tc = tree[1];
            int dist = dist(forest, sr, sc, tr, tc);
            if (dist < 0) return -1;
            minDist += dist;
            sr = tr;
            sc = tc;
        }

        return minDist;
    }

    private int dist(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
        int R = forest.size();
        int C = forest.get(0).size();

        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        Queue<int[]> q = new LinkedList<>();
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};

        q.add(new int[]{sr, sc, 0});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cr = current[0];
            int cc = current[1];
            int cv = current[2];
            if (cr == tr && cc == tc) {
                return cv;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if (
                        nr >= 0 && nr < R && nc >= 0 && nc < C
                                && !visited[nr][nc]
                                && forest.get(nr).get(nc) > 0

                ) {
                    //mark as visited as soon as possible so that we do not process this nodes again in the queue
                    //since we have already calculate its shortest distance by traversing BFS.
                    //if edge weights weren't same as 1, we could not mark as visited. Because we
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, cv + 1});
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        Integer[][] graph = new Integer[][]{
                {1,2,3},
                {0,0,4},
                {7,6,5}
        };
        List<List<Integer>> list= new ArrayList<List<Integer>>();

        for (int i=0;i<graph.length;i++){
            list.add(Arrays.asList(graph[i]) );
        }


        System.out.println(s.cutOffTree(list));
    }
}