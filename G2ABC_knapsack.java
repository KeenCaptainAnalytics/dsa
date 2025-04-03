import java.util.Arrays;
import java.util.Comparator;

class Item{
    int quantity;
    int cost;
    float perUnitCost;

    Item(int quantity, int cost, float perUnitCost ){
        this.quantity = quantity;
        this.cost = cost;
        this.perUnitCost =perUnitCost;

    }
}
public class G2ABC_knapsack {
    public static void main(String[] args) {
        int quantity[] = {5,2,1,3,8};
        int cost[] ={400, 500, 600, 100, 200};
        int k = 10;
        // max Profit ?
        float perKgCost[] = new float[quantity.length];
        for(int i=0; i<perKgCost.length ;i++){
            perKgCost[i] = cost[i]/(float)quantity[i];

        }


        Item[] arr = new Item[cost.length];
        for(int i =0;i<arr.length ;i++){
            Item obj = new Item(quantity[i], cost[i],perKgCost[i]);
            arr[i] =obj;
        }

        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if(o1.perUnitCost < o2.perUnitCost){
                    return 1;
                }
                else if(o1.perUnitCost > o2.perUnitCost){
                    return -1;
                }
                return 0;
            }
        });

        for(int i=0;i< arr.length ;i++){
            System.out.println(arr[i].quantity+" - "+arr[i].cost+" - "+arr[i].perUnitCost);
        }

    }
}
