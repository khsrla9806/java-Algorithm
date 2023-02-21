package selfstudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamMapToIntTest {
    public static void main(String[] args) {
        // Integer 객체를 저장하는 리스트를 하나 추가
        List<Integer> list = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};

        // 배열 [1, 2, 3]으로 변환
        int[] answer = list.stream().mapToInt(x -> x).toArray();

        // 변환 완료 (출력) -> [1, 2, 3]
        System.out.println(Arrays.toString(answer));
    }
}
