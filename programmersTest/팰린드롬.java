package programmersTest;

public class 팰린드롬 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 3, 0, 3, 1, 1};

        StringBuffer sb = new StringBuffer();

        for (int x : a) {
            sb.append(x);
        }

        String main = sb.toString();
        String reverse = sb.reverse().toString();

        if (main.equals(reverse)) {
            System.out.println("팰린드롬입니다.");
        } else {
            System.out.println("팰린드롬이 아닙니다.");
        }
    }
}
