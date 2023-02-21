package programmersTest;

public class 칸토어 {
    public static void main(String[] args) {
        solution(2, 4, 17);
    }
    public static int solution(int n, long l, long r) {
        long answer = r-l+1;
        for(long i=l-1;i<=r-1;i++){
            for(int j=0;j<n;j++){
                if((i/(int)Math.pow(5,j))%5==2){
                    answer--;
                    break;
                }
            }
        }

        return (int) answer;
    }
}
