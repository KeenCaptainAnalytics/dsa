import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

class TreeNode{
    char ch;
    int freq;
    TreeNode left;
    TreeNode right;

    TreeNode(char ch , int freq){
        this.ch = ch;
        this.freq = freq;
    }
}

public class G1ABC_Huffman {
    static HashMap<Character, Integer> getFrequency(String s){
        HashMap <Character, Integer> map = new HashMap<>();
        for(int i  =0 ; i < s.length() ;i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }

        return map;
    }
    static  PriorityQueue<TreeNode> pushIntoQueue(HashMap<Character, Integer > map){
        
        PriorityQueue<TreeNode> pq = new PriorityQueue<>(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                if(o1.freq > o2.freq){
                    return 1;
                }
                else if(o1.freq< o2.freq){
                    return -1;
                }
                else 
                return 0;
            }
        });
        for(Entry<Character, Integer> entryObj : map.entrySet()){
            TreeNode obj = new TreeNode(entryObj.getKey(), entryObj.getValue());
            pq.add(obj);
        }

        return pq;
    }

    static TreeNode completeTree(PriorityQueue<TreeNode> pq){
        while(pq.size()>=2){
            TreeNode temp1 = pq.poll();
            TreeNode temp2 = pq.poll();
            TreeNode nn = new TreeNode('*', temp1.freq +  temp2.freq);
            nn.left = temp1;
            nn.right= temp2;
            pq.add(nn);
        }

        return pq.poll();
    }

    static void getCodes(TreeNode root, String ans){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            System.out.println(root.ch+" - "+ans);
            return;
        }
        getCodes(root.left, ans+"0");
        getCodes(root.right, ans+"1");
    }
    public static void main(String[] args) {
        String s= "abacdacdcabaaaaaabcbcbcccccababcdcdc";


        // get the frequancy of all the characters
        HashMap<Character, Integer >  map = getFrequency(s);
        // convert into nodes and put into queue;
        PriorityQueue<TreeNode> pq= pushIntoQueue(map);

        // complete the tree
        TreeNode root = completeTree(pq);

        // code printing 

            getCodes(root, "");


        // while(pq.size()>0){
        //     TreeNode temp = pq.poll();
        //     System.out.println(temp.ch+" - "+temp.freq);
        // }
    } 
}
