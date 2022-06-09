package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        int len = t.length();
        for (int i = 0; i < len; i++) {
            char cur = t.charAt(i);
            tMap.put(cur, tMap.getOrDefault(cur, 0) + 1);
        }
        List<Character> characters = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            char cur = s.charAt(i);
            if (tMap.containsKey(cur)) {
                characters.add(cur);
                indexes.add(i);
            }
        }
        int l = 0, r = -1;
        int realL = 0, realR = 0;
        String ans = null;
        int size = characters.size();
        int tCharSize = tMap.size();
        while (r < size - 1) {
            r++;
            char curR = characters.get(r);
            int curRCount = tMap.get(curR) - 1;
            tMap.put(curR, curRCount);
            char curL = characters.get(l);
            int curLCount = tMap.get(curL) + 1;
            while (curLCount <= 0) {
                tMap.put(curL, curLCount);
                l++;
                curL = characters.get(l);
                curLCount = tMap.get(curL) + 1;
            }
            if (curRCount == 0) {
                tCharSize--;
                if (tCharSize == 0) {
                    realL = indexes.get(l);
                    realR = indexes.get(r);
                    if (ans == null || ans.length() > realR - realL + 1) {
                        ans = s.substring(realL, realR + 1);
                    }
                    curL = characters.get(l);
                    curLCount = tMap.get(curL) + 1;
                    tMap.put(curL, curLCount);
                    l++;
                    tCharSize++;
                }
            }
        }
        return ans == null ? "" : ans;
    }
}
