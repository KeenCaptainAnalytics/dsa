import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {
   public static void main(String[] args) {
        int arr[] = {3,6,8,9,3,5,7};
        int k =3;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
            if(o1>o2){
                return -1;
            }
            else if(o1<o2){
                return 1;
            }
            else{
                return 0;
            }
            }
        });

        for(int ele: arr){
            pq.add(ele);

        }

        for(int i=0;i<k; i++){
            System.out.print(pq.poll()+"  ");
        }
   } 
}
