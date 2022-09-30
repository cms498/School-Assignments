public class CountUp {
    public static int countWhile(int n){
        int i = 0;
        int sum = 0;
        while(i <= n){
            System.out.println(i);
            sum += i;
            i ++;
        }
        return sum;
    }

    public static int countFor(int n){
        int sum = 0;
        for(int i = 0; i <= n; i += 1){
            System.out.println(i);
            sum += i;
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println(countWhile(4));
        System.out.println(countFor(4));
    }
}
