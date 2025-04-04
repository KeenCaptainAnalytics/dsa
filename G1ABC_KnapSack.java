import java.util.Arrays;
import java.util.Comparator;

class MapItem{
    int q ;
    int cost;
    float perKg;

    MapItem(int q, int cost, float perKg){
        this.q= q;
        this.cost = cost;
        this.perKg = perKg;
    }
}

public class G1ABC_KnapSack {
    static void sortArray(MapItem[] arr){

        
        Arrays.sort(arr, new Comparator<MapItem>() {
            @Override
            public int compare(MapItem o1, MapItem o2) {
                if(o1.perKg<o2.perKg){
                    return 1;
                }
                else if(o1.perKg> o2.perKg){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        });
        // return arr;

    }
    public static void main(String[] args) {
        int quantity[] = {2,3,4,4,5};
        int cost[] = {40, 45, 50 ,70, 80};

        int k = 10;
        Float perKg[] = new Float[cost.length];

        MapItem arr[] = new MapItem[perKg.length];
        for(int i =0;i<cost.length;i++){
           perKg[i] = cost[i]/(float)quantity[i];
           arr[i] = new MapItem(quantity[i], cost[i], perKg[i]);

        }

        sortArray(arr);

        for(int i =0; i<perKg.length ; i++){
            System.out.println(arr[i].q+" - "+arr[i].cost+" - "+arr[i].perKg);
        }

        double profit = 0;
        for(int i =0 ;i<arr.length ;i++){
            if(k-arr[i].q>= 0){
                profit = profit+arr[i].cost;
                k = k - arr[i].q;
            }
            else{
                profit = profit + k*arr[i].perKg;
                k=0;
                break;
            }
        }

        System.out.println("total profit = "+ profit);
    }
}
