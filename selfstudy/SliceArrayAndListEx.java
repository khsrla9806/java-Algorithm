package selfstudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SliceArrayAndListEx {
    public static void main(String[] args) {
        /* List 잘라보자 */
        List<Integer> list = new ArrayList<>(){{
            add(10);
            add(20);
            add(30);
            add(40);
        }};
        List<Integer> newList = list.subList(1, 3);
        System.out.println(newList); // 예상: [20, 30]

        /* Array 잘라보자 */
        int[] array = new int[]{10, 20, 30, 40};
        int[] newArray = Arrays.copyOfRange(array, 1, 3);
        System.out.println(Arrays.toString(newArray)); // 예상: [20, 30]
    }
}
