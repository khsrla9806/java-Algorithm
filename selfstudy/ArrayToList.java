package selfstudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayToList {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};

        /*
            첫 번째 방법 : 반복문 사용
        */
        List<Integer> firstList = new ArrayList<>();
        for (int x : intArray) {
            firstList.add(x);
        }
        System.out.println(firstList);

        /*
            두 번째 방법 : 스트림 사용
            int 타입이라서 wrapper 객체로 바꿔야합니다.
        */
        List<Integer> secondList = new ArrayList<>();
        Arrays.stream(intArray).forEach(data -> secondList.add(Integer.valueOf(data)));
        System.out.println(secondList);
    }
}
