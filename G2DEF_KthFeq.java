import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map.Entry;

class Pair{
    int ele ;
    int freq;

    Pair(int ele, int freq){
        this.ele = ele ;
        this.freq = freq;
    }
}
public class G2DEF_KthFeq {
    static HashMap<Integer, Integer> getMap(int nums[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : nums){
            if(map.containsKey(ele)){
                map.put(ele,map.get(ele) +1);
            }
            else{
                map.put(ele, 1);
            }
        }

        return map;
    }
    static void getElements(HashMap<Integer, Integer> map , int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            
            @Override
            public int compare(Pair o1, Pair o2) {
               
                if(o1.freq > o2.freq){
                    return -1;
                }
                else if(o1.freq < o2.freq){
                    return 1;
                }
                else
                return 0;
            }
        });

        for(Entry<Integer, Integer> set : map.entrySet()){
            Pair obj = new Pair(set.getKey(), set.getValue());
            pq.add(obj);
        }


        for(int i =0 ; pq.size()!=0 ; i++){
            Pair p = pq.poll();
            System.out.println("ele = "+ p.ele+" = = " + " freq = "+p.freq);

        }
    }
    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,3};
        int k = 2;

        HashMap<Integer, Integer> map = getMap(nums);
        getElements(map, k);
    }
}
