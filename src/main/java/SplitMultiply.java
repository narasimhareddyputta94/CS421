// Author : Narasimha Reddy Putta

public class SplitMultiply {

    public static void main(String[] args) {
        // Parse command line arguments for x and y.
        long x = Long.parseLong(args[0]);
        long y = Long.parseLong(args[1]);
        long product = splitmultiply(x, y);
        System.out.println("x: " + x + ", y: " + y + ", x*y: " + product);
    }

    public static long splitmultiply(long x, long y) {
        int n = Math.max((int)Math.ceil(Math.log(x + 1) / Math.log(2)), (int)Math.ceil(Math.log(y + 1) / Math.log(2)));
        if (n <= 1) {
            return x * y;
        } else {
            int m = n / 2;
            long a = x >> m;
            long b = x - (a << m);
            long c = y >> m;
            long d = y - (c << m);
            long e = splitmultiply(a, c);
            long f = splitmultiply(b, d);
            long g = splitmultiply(b, c);
            long h = splitmultiply(a, d);
            return (e << (2 * m)) + ((g + h) << m) + f;
        }
    }
}
