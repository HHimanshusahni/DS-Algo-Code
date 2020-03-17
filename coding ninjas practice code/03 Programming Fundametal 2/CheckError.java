public class CheckError {
    public static void main(String[] args) {
        int a = 10;
        if(a > 5) {
            int a = 100;
        }
        System.out.println(a);
    }
}