import java.util.Comparator;
import java.util.PriorityQueue;

public class G1ABC_HeapEx {
    public static void main(String[] args) {
        int arr[] = {12,4,6,3,5,1};
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2){
                    return -1;
                }
                else if(o1>o2){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        });

        for(int i=0;i<arr.length ; i++){
            pq.add(arr[i]);
            System.out.println(pq);
            
        }

    }
}
