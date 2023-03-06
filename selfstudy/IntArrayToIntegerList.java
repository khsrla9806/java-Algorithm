package selfstudy;

import java.util.*;
import java.util.stream.Collectors;

public class IntArrayToIntegerList {
    public static void main(String[] args) {
        // int타입 배열
        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7};

        // Integer 타입의 List
        // stream.boxed(): int 기본 타입을 Integer Wrapper 타입으로 변환
        List<Integer> list = Arrays.stream(intArray).boxed().collect(Collectors.toList());
        System.out.println("변환된 리스트 : " + list);

        // 다시 int 타입 배열로 변환
        int[] returnArray = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("변환된 배열 : " + Arrays.toString(returnArray));
    }
}
