import java.util.Comparator;
import java.util.PriorityQueue;

public class G2DEF_SlidingWindowMax {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                if(o1<o2){
                    return 1;
                }
                else if(o1> o2){
                    return -1;
                }
                return 0;
            }
        });
        int []nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int ans[] = new int[nums.length-k+1];
        
        int i = 0;
        int j = k-1;

        int x=i;
        while(x<=j){
            pq.add(nums[x]);
            x++;

        }

        while(j<nums.length){
            ans[i] = pq.peek();
            pq.remove(nums[i]);

            i++;
            j++;
            if(j<nums.length)
             pq.add(nums[j]);
        }


        for(int t= 0 ; t< ans.length ;t++){
            System.out.print(ans[t]+"  ");
        }
    }
}
