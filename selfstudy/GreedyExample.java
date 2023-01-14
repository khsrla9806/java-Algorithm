package selfstudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GreedyExample {
    public static void main(String[] args) {
        List<Activity> activities = new ArrayList<>(){{
            add(new Activity("a", 7, 8));
            add(new Activity("b", 5, 7));
            add(new Activity("c", 3, 6));
            add(new Activity("d", 1, 2));
            add(new Activity("e", 6, 9));
            add(new Activity("f", 10, 11));
        }};
        Collections.sort(activities); // 정의해준 compareTo에 따라서 정렬 진행

        for (Activity activity : greedy(activities)) {
            System.out.print(activity.toString() + " ");
        }
        System.out.println();
        System.out.println("최대 " + greedy(activities).size() + "개의 활동을 할 수 있습니다.");
    }

    public static List<Activity> greedy(List<Activity> activities) {
        List<Activity> result = new ArrayList<>();
        int PreviousActivityEndTime = 0;

        // 그리디 알고리즘의 선택 기준을 만족하기 위한 조건에 맞으면 선택
        for (Activity activity : activities) {
            if (activity.startTime >= PreviousActivityEndTime) {
                result.add(activity);
                PreviousActivityEndTime = activity.endTime;
            }
        }
        return result;
    }
}

class Activity implements Comparable<Activity> {
    String activityName;
    int startTime;
    int endTime;

    public Activity(String activityName, int startTime, int endTime) {
        this.activityName = activityName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Activity 객체의 정렬 기준을 설정한다. endTime 기준으로 오름차순 정렬을 진행
    @Override
    public int compareTo(Activity activity) {
        return this.endTime - activity.endTime;
    }

    @Override
    public String toString() {
        return this.activityName;
    }
}
