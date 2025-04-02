import java.util.Comparator;
import java.util.PriorityQueue;

public class G1ABC_KthLargestELemenet {
    public static void main(String[] args) {
        int arr[]= {3,54,7,8,4,342,45,76,6745};
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


        for(int ele: arr){
            pq.add(ele);
        }

        int k = 6;
        int top=0 ;
        for (int i=0; i<k ;i++){
            top = pq.poll();
        }

        System.out.println(top);
    }
}
