package practice.leetcode.algorithm;

/**
 * @Description: 463. Island Perimeter
 *
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * One cell is a square with side length 1.
 * The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 */
public class IslandPerimeter {
    // 下面这种方法对于每个岛屿格子先默认加上四条边，
    // 然后检查其右面和下面是否有岛屿格子，
    // 有的话分别减去两条边，这样也能得到正确的结果，参见代码如下：
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0
                || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int p = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    continue;
                }

                p += 4;

                if ((c + 1) < grid[0].length && grid[r][c + 1] == 1) {
                    p -= 2;
                }

                if ((r + 1) < grid.length && grid[r + 1][c] == 1) {
                    p -= 2;
                }
            }
        }

        return p;
}

    // 我们知道一个格子有四条边，但是当两个格子相邻，周围为6，
    // 若某个格子四周都有格子，那么这个格子一条边都不算在周长里。那么我们怎么统计出岛的周长呢？
    // 第一种方法，我们对于每个格子的四条边分别来处理，
    // 首先看左边的边，只有当左边的边处于第一个位置或者当前格子的左面没有岛格子的时候，
    // 左边的边计入周长。其他三条边的分析情况都跟左边的边相似，这里就不多叙述了，参见代码如下
    public int islandPerimeter2(int[][] grid) {
        if (grid == null || grid.length == 0
                || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) {
                        res++;
                    }
                    if (i == m - 1 || grid[i + 1][j] == 0) {
                        res++;
                    }
                    if (j == 0 || grid[i][j - 1] == 0) {
                        res++;
                    }
                    if (j == n - 1 || grid[i][j + 1] == 0) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
