package selfstudy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeTest {
    public static void main(String[] args) {
        String today = "2023/02/21";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date = LocalDate.parse(today, formatter);
        System.out.println(date); // 파싱 완료된 날짜가 출력 2023-02-21

        // date에 2달 뒤를 확인해보자.
        System.out.println(date.plusMonths(2)); // 2023-04-21

        String newDate = "2022/01/01";
        LocalDate myDate = LocalDate.parse(newDate, formatter);

        // newDate의 하루 전을 확인해보자.
        System.out.println(myDate.minusDays(1)); // 2021-12-31
    }
}
