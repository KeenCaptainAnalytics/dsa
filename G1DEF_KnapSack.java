import java.util.Arrays;
import java.util.Comparator;

class Item{
    int Quantitiy;
    int cost;
    float perUnitCost;

    Item(int Quantitiy, int cost, float perUnitCost){
        this.Quantitiy = Quantitiy;
        this.cost =cost;
        this.perUnitCost =perUnitCost;
    }
}
class G1DEF_KnapSack{
    public static void main(String[] args) {
        int Quantitiy[] = {2,4,5,7,8,5,3};
        int cost[] = {23,34,45,26,76,4,34};

        float perItemCost[] = new float[cost.length];

        Item arr[] =  new Item[cost.length];

        for(int i =0 ;i <perItemCost.length ;i++){
            perItemCost[i] =cost[i]/((float)Quantitiy[i]);
            arr[i] = new Item(Quantitiy[i],cost[i] ,perItemCost[i] );
        }


        int k = 12;
        int i =0;

        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if(o1.perUnitCost<o2.perUnitCost){
                    return -1;
                }
                else if(o1.perUnitCost> o2.perUnitCost){
                    return 1;
                }

                return 0;
            }
        });
        
        double profit =0 ;
        for(int j =arr.length-1 ; j>0 ;j--){
            if(k>0){
                int count = arr[j].Quantitiy;
                if(k-count >=0){
                    profit = profit+ arr[j].cost;
                    k = k-count;
                }
                else{
                    profit = profit + arr[j].perUnitCost*k;
                    k = 0;
                }
            }
        }

        System.out.println(profit);
    }
}
