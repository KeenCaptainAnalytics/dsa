class DEFG1_Bits{
    static void binary(int num ){
    
        for(int i =5 ;i >=0;i--){
            System.out.print(num>>i & 1);
        }
        System.out.println();
    }
    static int setBit(int num , int i){
        return num | 1<<i;
    }
    static int unSetBit(int num , int i){
        return num ^ 1<<i;
    }
    public static void main(String[] args) {
    //    set or unset bits
    int i = 2;
    binary(25);
    int num = setBit(25, i);
    binary(num);
    num =unSetBit(num , 4 );
    binary(num);
    
    // to get all the subsets of a set

    // [1,2,3,4] = > [1], [1, 2], [1,2,3], [1,2,3,4]
    //               [2], [2, 3], [2,3,4]
    
        [1,2,3] 

    // 000111
    // 000010
    // 000101
    //  int i = 3;
    //  int num = 15;
    //  if((num & 1<<i)>0){
    //     System.out.println("set bit");
    //  }
    //  else{
    //     System.out.println("bit is not set");
    //  }
    //  0101010
    //  0000001
    //  0000010
    //  0000100
    //  0001000
    //  0001000
        // 
        // 111>>1
        // 011

        // 1000 >> 1, 8
        // 0100 >> 1, 4
        // 0010 >>1 , 2
        // 0001>>1 ,1
        // 0000 ,  0 

        // 0111 << 1
        // 1110 
        // 0001 << 3
        // 0010 << 1
        // 0100 << 1
        // 1000 << 

        // ^ 0 ^ 0 = 0
        //   1 ^ 1 = 0
        //   1 ^ 0 = 1
        //   0 ^ 1 = 1

        // System.out.println(5 ^ 3);
        // 0101 => 5
        // 0011 3
        // 0110
        // 0 => 0000
        // 1 => 0001
        // 2 => 0010
        // 3 => 0011
        // 4 => 0100
        // 5 => 0101



                
        // 4 & 5  
        // 0100
        // 0101
        // 0100

        // 0111
        // // 0101
        //    0111
        // System.out.println(7 | 5);


        // 0 1 0 1 = >      (0*2^3 )+(1*2^2)+(0* 2^1)+(1*2^0) =4+1 = 5
        // 3 2 1 0  
        // int a = 2;
        // & | ^
        // & (0 & 0=0)
        //    1 & 0 =0
        //    0 & 1 =0
        //    1 & 1 =1
         
        // 0 | 0 = 0
        // 0 | 1 = 1
        // 1 | 0 = 1
        // 1 | 1 = 1 
    }   
}