import java.util.ArrayList;

public class SubsetXor {
   public static void main(String[] args) {
        int arr[]= {1,2,3};
        int n = 1<<arr.length;

        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<>();

        for(int i=0 ;i <n ;i++){
            ArrayList<Integer> ans  = new ArrayList<>();
            int num = i;
            int j =0;  //arr index
            while(num !=0){
                int bin = num & 1;
                if(bin ==1){
                    ans.add(arr[j]);
                }
                num = num>>1;
                j++;

            }
            powerSet.add(ans);
        }

        System.out.println(powerSet);
   } 
}
