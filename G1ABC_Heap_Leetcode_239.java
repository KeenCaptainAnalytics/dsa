// time limit exceeded = > using heap

class Solution {


    void getMaxWindow(int []nums,int []ans, int k,PriorityQueue<Integer> pq){
        int i =0;
        int j = k-1;

        for(int x= i; x<=j;x++){
            pq.add(nums[x]);
        }
        while(j< nums.length){
            ans[i]= pq.peek();
            pq.remove(nums[i]);
            j++;
            if(j==nums.length){
                return;
            }
            pq.add(nums[j]);
            i++;
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[] =new int[nums.length-k+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2){
                    return 1;
                }
                else if(o1>o2){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        }); 


        getMaxWindow(nums, ans, k, pq);
        return ans;
    }
}