import java.security.KeyStore.Entry;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Pair{
    int ele;
    int freq;

    Pair(int ele, int freq){
        this.ele = ele;
        this.freq= freq;
    }
}
public class G1ABC_Leetcode347 {

    static void countFreq(int arr[],  HashMap<Integer, Integer> map){
        for(int ele : arr){
            if(map.containsKey(ele)){
                map.put(ele,map.get(ele)+1);
            }
            else{
                map.put(ele, 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,1,1,2,2,3};
        int k =2;
        HashMap<Integer, Integer> map = new HashMap<>();
        countFreq(arr, map);

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            new Comparator<Pair>() {
                public int compare(Pair o1, Pair o2) {
                    if(o1.freq >  o2.freq){
                        return -1;
                    }
                    else if (o1.freq < o2.freq ){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                };
            }
        );
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Pair obj  =  new Pair(entry.getKey(), entry.getValue());
            pq.add(obj);
        }
        int size = pq.size();
        for(int i =0 ;i<size ; i++){
            Pair obj = pq.poll();
            System.out.println(obj.ele+ "  "+obj.freq);
        }

    }
}