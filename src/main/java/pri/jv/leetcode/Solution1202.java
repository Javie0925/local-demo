package pri.jv.leetcode;

import java.util.*;

/**
 * @ClassName Solution1202
 * @Dscription
 * @Date 3/18/21
 * @Author JV
 **/
public class Solution1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        List<List<Set<Integer>>> routers = new ArrayList<>();

        // init routers
        for (List<Integer> l:pairs){
            if (routers.size()==0){
                List<Set<Integer>> toAdd = new ArrayList<>();
                Set<Integer> keys = new TreeSet<>(l);
                Set<Integer> values = new TreeSet<>();
                values.add((int)s.charAt(l.get(0)));
                values.add((int)s.charAt(l.get(1)));
                toAdd.add(keys);
                toAdd.add(values);
                routers.add(toAdd);
            }else {
                boolean contains = false;
                for (List<Set<Integer>> ll: routers) {
                    if (ll.get(0).contains(l.get(0)) && !ll.get(0).contains(l.get(1))){
                        ll.get(0).add(l.get(1));
                        ll.get(1).add((int)s.charAt(l.get(1)));
                        contains = true;
                        break;
                    }else if (ll.get(0).contains(l.get(1)) && ! ll.get(0).contains(l.get(0))){
                        ll.get(0).add(l.get(0));
                        ll.get(1).add((int)s.charAt(l.get(0)));
                        contains = true;
                        break;
                    }
                }
                if (!contains){
                    List<Set<Integer>> toAdd = new ArrayList<>();
                    Set<Integer> keys = new TreeSet<>(l);
                    Set<Integer> values = new TreeSet<>();
                    values.add((int)s.charAt(l.get(0)));
                    values.add((int)s.charAt(l.get(1)));
                    toAdd.add(keys);
                    toAdd.add(values);
                    routers.add(toAdd);
                }
            }
        }
        for (int i=1;i<routers.size();i++){
            List<Set<Integer>> l = routers.get(i-1);

        }
        byte[] chars = new byte[s.length()];
        for (List<Set<Integer>> ll: routers){
            ArrayList<Integer> keys = new ArrayList<>(ll.get(0));
            ArrayList<Integer> values = new ArrayList<>(ll.get(1));
            for (int i=0;i<ll.get(0).size();i++){
                chars[keys.get(i)] = Byte.parseByte(values.get(i).toString());
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Solution1202 solution1202 = new Solution1202();
        String s = "dcab";

        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> toAdd1 = new ArrayList<>();
        toAdd1.add(0);
        toAdd1.add(3);
        ArrayList<Integer> toAdd2 = new ArrayList<>();
        toAdd2.add(1);
        toAdd2.add(2);
        ArrayList<Integer> toAdd3 = new ArrayList<>();
        toAdd3.add(0);
        toAdd3.add(2);
        lists.add(toAdd1);
        lists.add(toAdd2);
        lists.add(toAdd3);
        System.out.println(solution1202.smallestStringWithSwaps(s,lists));

    }
}
