import java.util.Comparator;
import java.util.PriorityQueue;

public class G2DEF_Heap {
    public static void main(String[] args) {
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
        pq.add(12);
        pq.add(14);
        pq.add(56);
        pq.add(21);

        while(pq.size()!=0){
            System.out.println(pq.poll());
        }
    }
}
