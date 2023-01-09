package programmers.DFSandBFS;

import java.util.*;

public class 모음사전 {
    List<String> list = new ArrayList<>();

    public int solution(String word) {
        dfs("");
        return list.indexOf(word);
    }

    void dfs(String str) {
        if(str.length() > 5) {
            return;
        }
        list.add(str);
        for(String s : "AEIOU".split("")) {
            dfs(str + s);
        }
    }
}
