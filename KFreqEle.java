import java.security.KeyStore.Entry;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

class Pair{
    int ele;
    int freq;
    Pair(int ele, int freq){
        this.ele=  ele;
        this.freq= freq;
    }
}

public class KFreqEle {
    public static int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int ele: nums){
            if(map.containsKey(ele)){
                map.put(ele, map.get(ele)+1);
            }
            else{
                map.put(ele, 1);
            }
        }

        System.out.println(map);

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.freq<o2.freq)
                    return 1;
                else if( o1.freq>o2.freq){
                    return -1;
                }
                else 
                return 0;
            }
        });
        for(java.util.Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
          }

        for(int i = 0 ;i< k; i++){
            ans[i]= pq.poll().ele;
        }
        return ans;
    }
    public static void main(String[] args) {
       int ans[]=  topKFrequent(new int[]{1,1,2,3,4,4,5,6,3,4,3,9,2,3,4,2,1}, 2);
     
       for(int ele: ans){
        System.out.print(ele+" ");
       }
    }
}
