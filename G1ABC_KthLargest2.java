import java.util.PriorityQueue;

public class G1ABC_KthLargest2 {

    public static int KthMax(int arr[], int k,PriorityQueue<Integer> pq){
        for(int ele: arr){
            if(pq.size()<k){
                pq.add(ele);
            }
            else{
                int top = pq.peek();
                if(top< ele){
                    pq.poll();
                    pq.add(ele);
                }
            }
        }

        return pq.peek();
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int arr[] = {1,5,3,7,8,3,5,7,8,23,12,17,13,56};
        
        int maxkth = KthMax(arr, 5, pq);
        System.out.println(maxkth);
    }
}
