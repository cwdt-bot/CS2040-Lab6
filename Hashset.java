
/**
 * Name         : Yap Kai Herng
 * Matric. No   : A01992729A
*/

import java.util.*;
import java.util.function.Function;

public class Hashset {

    private void run() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long[] ain = new long[num];
        long[] bin = new long[num];
        for(int n=0; n < num; n++) {
            ain[n] = sc.nextLong();
        }
        for(int n=0; n < num; n++) {
            bin[n] = sc.nextLong();
        }

        Data a = new Data(ain);
        Data b = new Data(bin);
        int q = sc.nextInt();
        while(q > 0) {
            q--;
            int l = sc.nextInt()-1, r = sc.nextInt()-1, u = sc.nextInt()-1, v = sc.nextInt()-1;
            String result = "Yes";
            if (!a.get(l,r).equals(b.get(u,v))) result = "No";
            if (r-l != v-u) result = "No";
            System.out.println(result);
        }
        sc.close();
    }

    public static void main(String args[]) {
        Hashset runner = new Hashset();
        runner.run();
    }
}

class Box {
    private long a;
    private long b;
    private long c;
    private long d;

    public Box(long a, long b, long c, long d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public boolean equals(Box other) {
        return this.a == other.a && this.b == other.b && this.c == other.c && this.d == other.d;
    }
}

class Data {
    private long[] sum;
    private long[] sumSquare;
    private long[] sumMod;
    private long[] sumModMod;
    private int mod = 104711;
    private int modmod = 101;

    public Data(long[] arr) {
        int n = arr.length;
        sum = new long[n];
        sumSquare = new long[n];
        sumMod = new long[n];
        sumModMod = new long[n];

        this.process(arr, sum, x -> x);
        this.process(arr, sumSquare, x -> x*x);
        this.process(arr, sumMod, x -> x%mod);
        this.process(arr, sumModMod, x -> x * (x / 2) % modmod);
    }

    private void process(long[] in, long[] out, Function<Long, Long> f) {
        int n = in.length;
        for (int i = 0; i < n; i++) {
            if (i==0) {
                out[i] = f.apply(in[i]);
            } else {
                out[i] = f.apply(in[i]) + out[i-1];
            }
        }
    }

    public Box get(int l, int r) {
        if (l == 0) {
            return new Box(sum[r],sumSquare[r],sumMod[r], sumModMod[r]);
        } else {
            return new Box(sum[r]-sum[l-1], sumSquare[r]-sumSquare[l-1], sumMod[r]-sumMod[l-1], sumModMod[r]-sumModMod[l-1]);
        }
    }

}