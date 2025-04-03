import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class TreeNode{
    char ch;
    int freq;
    TreeNode left;
     TreeNode right;
    TreeNode(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}
public class G2ABC_Huffman {
    static void getCode(TreeNode head, String code){
        if(head==null){
            return;
        }


        if(head.left==null && head.right==null){
            System.out.println(code);
            return ;
        }

        getCode(head.left, code+"0");
    
        getCode(head.right, code+"1");

    }
    public static void main(String[] args) {
        String s = "ababcbcadcdcacdabcbca";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0;i< s.length() ;i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }
            else{
                map.put(ch, 1);
            }
        }

        PriorityQueue<TreeNode>  pq = new PriorityQueue<>(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                if(o1.freq< o2.freq){
                    return 1;
                }
                else if(o1.freq > o2.freq){
                    return -1;
                }
                return 0;
            }
        });

        // addd elements into pq

        while (pq.size()>1) {
            TreeNode temp1 = pq.poll();
            TreeNode temp2 = pq.poll();
            TreeNode nn = new TreeNode('*', temp1.freq+temp2.freq);
            pq.add(nn);

        }

        TreeNode head = pq.poll();
        System.out.println(head.freq);
        getCode(head, "");

    }
}
