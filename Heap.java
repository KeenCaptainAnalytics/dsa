public class Heap {

    static void addIntoHeap(int heap[], int ele, int i){
        if(i ==0){
            heap[i]= ele;
            return;
        }
        else{
            while(i>0){
                heap[i]= ele;
                int parentIndex = (i-1)/2;
                if(heap[parentIndex]<ele){
                    int temp = heap[parentIndex] ;
                    heap[parentIndex] = heap[i];
                    heap[i] = temp;
                    i = parentIndex;
                }
                else{
                    break;
                }
            }
        }
    }


    static void remove(int arr[], int min, int max){
        arr[0] = arr[max];
        int i =0;
        while(i<=max){
            int l = i*2+1;
            int r = i*2+2;
            
            if(l == r){
                break;   
            }

            if(l>=max || r>=max){
                break;
            }

           if(arr[l]<arr[r]){
                if(arr[i]<arr[r]){
                    int temp  = arr[i];
                    arr[i] = arr[r];
                    arr[r] =temp;
                    i = r;
                }
           }
           else{
            if(arr[i]<=arr[l]){
                int temp  = arr[i];
                arr[i] = arr[l];
                arr[l] =temp;
                i = l;
            }
           }
        }
    }

    public static int[] sortArr(int arr[]){
        int sortedArr[] = new int[arr.length];
        int k =0;
        for(int i =0 ;i< arr.length;i++){
            sortedArr[k]= arr[0];
            k++;
            remove(arr, 0, arr.length-1-i);
        }

        return sortedArr;
    }
    public static void main(String[] args) {
        int arr[]= {2,4,3,5,4,9,6};
        int heap[] =new int[arr.length];
        int i=0;
        for(int ele : arr){
            addIntoHeap(heap, ele, i);
            i++;
        }


        arr = sortArr(heap);

        for(int ele: arr){
            System.out.print(ele+" ");
        }

    }
}
