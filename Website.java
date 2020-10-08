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

    //query type 3: getting the number of unique countries which accessed the website
    //postcond: prints number of countries with IP entries
    public void query(int n) {
       System.out.println(map.size());
    }

    //query type 1: adding an IP address/access duration to the HashMap
    //precond: query needs to have 4 arguments in the specified order
    //postcond: entry is added to the ipMap
    public void query(int  n, String add, String c, int durr) {
        //if country does not currently exist, create the country
        if (!map.containsKey(c)) {
            Country entry = new Country(add, durr);
            map.put(c,entry);
        } else {
            //if country exists, add the entry into the country
            Country curr = map.get(c);
            curr.add(durr, add);
        }
    }

    //query type 2 and 4: max time for country / number of entries for the country
    //precond: query needs to have 2 arguments in the specified order
    //postcond: prints number of entries for the specified country, including 0 for countries with no entries
    public void query(int n, String c) {
        //if country does not currently exist, print 0
        if(!map.containsKey(c)) {
            System.out.println(0); return;}
        if (n == 2) {
            //query type 2: IP address with the longest time
            System.out.println(map.get(c).maxTime());
        } else {
            //query type 4: number of IP address for country
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
        //if country already has the IP address, add total time of the IP
        if (this.ips.containsKey(ip)) durr  = this.ips.get(ip) + durr;
        //if IP is new, just add into the HashMap
        this.ips.put(ip, durr);
    }
}
