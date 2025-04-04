import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;


class Node{
    char ch;
    int freq;
    Node left;
    Node right;

    Node(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}

public class G2DEF_Huffman {
    static HashMap<Character, Integer> getFrequency(String s){

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0 ;i < s.length() ;i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
            else{
                map.put(s.charAt(i),1);
            }
        }
        return map;
    }

    static PriorityQueue<Node> insertIntoHeap( HashMap<Character, Integer> map){
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.freq< o2.freq){
                    return -1;
                }
                else if( o1.freq> o2.freq){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        });

        for(Entry<Character, Integer> en : map.entrySet()){
            Node obj = new Node(en.getKey(),en.getValue());
            pq.add(obj);
        }

        return pq;
    }
    static Node getTree(PriorityQueue<Node> pq){

        while(pq.size()>=2){
            Node temp1 = pq.poll();
            Node temp2 = pq.poll();

            Node nn = new Node('*',temp1.freq + temp2.freq);
            nn.left = temp1;
            nn.right= temp2;

            pq.add(nn);
        }

        return pq.peek();
    }

    static void getCodes(Node root, String code){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            System.out.println(root.ch+ " -  "+code);
            return;
        }
        getCodes(root.left, code+"0");
        getCodes(root.right, code+"1");
    }
    public static void main(String[] args) {
        String s = "asdeadsdseadsdesdsseeasesedaedads";

        HashMap<Character, Integer> map= getFrequency(s);

        PriorityQueue<Node> pq= insertIntoHeap(map);

        // for(;pq.size()!=0;){
        //     Node temp = pq.poll();
        //     System.out.println(temp.ch+"  -  "+temp.freq);
        // }

        Node head = getTree(pq);

        getCodes(head, "");

    }   
}
