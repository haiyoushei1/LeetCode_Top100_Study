import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
题目大意：给出几个区间，如果有两个区间有重合，就将两个区间结合，形成一个新的大区间
题解：问题可以解构为将这些区间根据左边的点排个序，再比较右节点与其他区间的左节点的大小。
这个代码是力扣官方给的，我觉得写得很nb（对于初级极端的我是这样的）用匿名类做排序，通过集合压缩了很多不必要的代码（代码还是看的太少了）
 */



public class merge_intervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return intervals;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> merage = new ArrayList<>();

        for(int i = 0;i < intervals.length; i++){
            int L = intervals[i][0];
            int R = intervals[i][1];
            if((merage.size() == 0) || merage.get(merage.size() - 1)[1] < L){
                merage.add(intervals[i]);
            }else{
                merage.get(merage.size() - 1)[1] = Math.max(merage.get(merage.size() - 1)[1], R);
            }
        }

        return merage.toArray(new int[merage.size() - 1][2]);
    }
}
