/**
 * Name         : Yap Kai Herng
 * Matric. No   : A0199729A
*/

import java.util.*;

public class Website {
    private void run() {
        Scanner sc = new Scanner(System.in);
        ipMap ip = new ipMap();
        int numQueries = sc.nextInt();
        for (int n = 0; n < numQueries; n++) {
            int type = sc.nextInt();
            if (type == 1) {
                ip.query(type, sc.next(),sc.next(),sc.nextInt());
            } else if (type == 3) ip.query(type);
            else ip.query(type, sc.next());
        }
        sc.close();
    }

    public static void main(String args[]) {
        Website runner = new Website();
        runner.run();
    }
}

class ipMap {
    private HashMap<String, Country> map = new HashMap<>();

    //deal with query type 3
    //postcond: returns number of countries with IP entries
    public void query(int n) {
       System.out.println(map.size());
    }

    //deal with query type 1
    //precond: query needs to have 4 arguments in the specified order
    public void query(int  n, String add, String c, int durr) {
        //if country does not currently exist
        if (!map.containsKey(c)) {
            Country entry = new Country(add, durr);
            map.put(c,entry);
        } else {
            Country curr = map.get(c);
            curr.add(durr, add);
        }
    }

    //deal with query type 2 and 4
    //precond: query needs to have 2 arguments in the specified order
    //postcond: 0 is printed if country has no previous IP entries
    public void query(int n, String c) {
        //check if country exists
        if(!map.containsKey(c)) {
            System.out.println(0); return;}
        if (n == 2) {
            System.out.println(map.get(c).maxTime());
        } else {
            System.out.println(map.get(c).size());
        }
    }
}

class Country {
    private HashMap<String, Integer> ips = new HashMap<>();

    public Country (String ip, int time) {
        this.ips.put(ip, time);
    }

    public int maxTime() {
        return Collections.max(this.ips.values());
    }

    public int size() {
        return this.ips.size();
    }

    public void add(int durr, String ip) {
        if (this.ips.containsKey(ip)) durr  = this.ips.get(ip) + durr;
        this.ips.put(ip, durr);
    }
}
