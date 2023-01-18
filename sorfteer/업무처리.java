package sorfteer;

import java.io.*;
import java.util.*;


public class 업무처리 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] HKR = bufferedReader.readLine().split(" ");
        int H = Integer.parseInt(HKR[0]);
        int K = Integer.parseInt(HKR[1]);
        int R = Integer.parseInt(HKR[2]);
        int answer = 0;

        List<Employee> list = new ArrayList<>();
        List<Integer> index = new ArrayList<>();

        for (int i = (int)Math.pow(2, H) - 1; i < (int)Math.pow(2, H + 1) - 1; i++) {
            Employee employee = new Employee(i, false);
            for (String str : bufferedReader.readLine().split(" ")) {
                employee.remainTask.get(0).offer(Integer.valueOf(str));
            }
            list.add(employee);
            index.add(i);
        }

        for (int i = 1; i < R + 1; i++) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                Employee employee = list.get(j);

                if (employee.getRemainTask(i).isEmpty()) {
                    continue;
                }

                if (employee.employeeNumber == 0) {
                    answer += employee.getRemainTask(i).poll();
                    continue;
                }

                int superiorNumber = employee.getSuperiorNumber();
                Employee superior;

                if (index.contains(superiorNumber)) {
                    superior = list.get(index.indexOf(superiorNumber));
                } else {
                    superior = new Employee(superiorNumber, true);
                    list.add(superior);
                    index.add(superior.employeeNumber);
                }

                if (employee.employeeNumber % 2 == 0) {
                    superior.remainTask.get(1).offer(employee.getRemainTask(i).poll());
                } else {
                    superior.remainTask.get(0).offer(employee.getRemainTask(i).poll());
                }
            }
        }

        System.out.println(answer);
    }
}

class Employee {
    int employeeNumber;
    boolean isSuperior;
    List<Queue<Integer>> remainTask;

    public Employee(int employeeNumber, boolean isSuperior) {
        this.employeeNumber = employeeNumber;
        this.isSuperior = isSuperior;

        remainTask = new ArrayList<>();
        if (isSuperior) {
            remainTask.add(new LinkedList<>()); // 왼쪽 직원이 올린 일
            remainTask.add(new LinkedList<>()); // 오른쪽 직원이 올린 일
        }
        if (!isSuperior) {
            remainTask.add(new LinkedList<>()); // 말단 직원의 남은 일
        }
    }

    public int getSuperiorNumber() {
        if (employeeNumber % 2 != 0) {
            return (employeeNumber - 1) / 2;
        }
        return (employeeNumber - 2) / 2;
    }

    public Queue<Integer> getRemainTask(int date) {
        if (isSuperior) {
            if (date % 2 != 0) {
                return remainTask.get(0);
            }
            return remainTask.get(1);
        }
        return remainTask.get(0);
    }
}