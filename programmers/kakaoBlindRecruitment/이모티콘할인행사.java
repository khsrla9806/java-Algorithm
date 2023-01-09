package programmers.kakaoBlindRecruitment;

import java.util.*;

public class 이모티콘할인행사 {
    private static final int[] DISCOUNT_PERCENTAGE = {10, 20, 30, 40};
    private static List<int[]> result = new ArrayList<>(); // 모든 경우의 수를 저장할 리스트

    public int[] solution(int[][] users, int[] emoticons) {
        Stack<Integer> stack = new Stack<>();

        for (int ratio : DISCOUNT_PERCENTAGE) {
            stack.push(ratio);
            dfs(users, emoticons, 0, stack);
            stack.pop();
        }

        result.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1]; // 가입자수가 동일한 경우 판매액이 큰 것이 우선
                }
                return o2[0] - o1[0];     // 가입자수가 큰 것이 우선
            }
        });
        return result.get(0);
    }

    public void dfs(int[][] users, int[] emoticons, int depth, Stack<Integer> stack) {
        if (stack.size() == emoticons.length) {
            int[] detectData = new int[]{0, 0}; // [가입자수, 판매액]

            for (int[] user : users) {
                int salesAmount = 0;
                for (int i = 0; i < emoticons.length; i++) {
                    if (isUserPurchase(user, stack.get(i))) {
                        salesAmount += calculationSalesAmount(stack.get(i), emoticons[i]);
                    }
                }

                if (salesAmount >= user[1]) {
                    detectData[0] += 1;
                }
                if (salesAmount < user[1]) {
                    detectData[1] += salesAmount;
                }
            }
            result.add(detectData);
            return;
        }


        for (int ratio : DISCOUNT_PERCENTAGE) {
            stack.push(ratio);
            dfs(users, emoticons, depth + 1, stack);
            stack.pop();
        }
    }

    // 사용자가 구매를 원하는 할인율 이상인지 확인하여 반환
    public boolean isUserPurchase(int[] user, int discountRatio) {
        int userWantedRatio = user[0];

        if (userWantedRatio <= discountRatio) {
            return true;
        }
        return false;
    }

    // 할인된 이모티콘 가격을 계산하여 반환
    public int calculationSalesAmount(int discountRatio, int emoticonPrice) {
        double discountedPrice = emoticonPrice * ((100 - discountRatio) * 0.01);
        return (int)discountedPrice;
    }
}
