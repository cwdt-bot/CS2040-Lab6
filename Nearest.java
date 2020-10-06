/**
 * Name         : Yap Kai Herng
 * Matric. No   : A0199729A
*/

import java.util.*;

public class Nearest {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int n=0; n < num; n++) {
            int curr = sc.nextInt();
            list.add(curr);
            if (!map.containsKey(curr)) {
                List<Integer> idx = new ArrayList<>();
                idx.add(n);
                map.put(curr, idx);
            } else {
                map.get(curr).add(n);
            }
        }
        for (int x= 0; x < num; x++) {
            int curr = list.get(x);
            List<Integer> idx = map.get(curr);
            if (idx.size() == 1) {
                System.out.println(-1);
                continue;
            } else {
                int pos = idx.indexOf(x);
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if (pos != 0) left = idx.get(pos-1);
                if (pos != idx.size()-1) right = idx.get(pos+1);
                if (Math.abs(x-left) < Math.abs(right-x)) {
                    System.out.println(Math.abs(x-left));
                    idx.remove(pos-1);
                } else {
                    System.out.println(Math.abs(right-x));
                }
            }
        }
    }

    public static void main(String args[]) {
        Nearest runner = new Nearest();
        runner.run();
    }
}

    



