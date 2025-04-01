import java.util.Comparator;
import java.util.PriorityQueue;

class Example{
    public static void main(String[] args) {
        int arr[]= {2,3,7,8,9,1};
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2)
                    return 1;
                else if( o1>o2){
                    return -1;
                }
                else 
                return 0;
            }
        });
        for(int ele : arr){
            pq.add(ele);
            System.out.println(pq);
           
            
        }
        System.out.println(pq.poll());

        // System.out.println(pq);
    }
}