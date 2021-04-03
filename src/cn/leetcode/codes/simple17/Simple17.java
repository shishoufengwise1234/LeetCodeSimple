package cn.leetcode.codes.simple17;

import cn.leetcode.codes.PKt;

import java.util.*;
import java.util.zip.Deflater;

public class Simple17 {

    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
     * <p>
     * 1 刷是否通过：
     * <p>
     * <p>
     * 2 刷是否完成：
     * <p>
     * <p>
     * 3 刷是否完成：
     * <p>
     * <p>
     * 4 刷是否完成：
     * <p>
     * <p>
     * 5 刷是否完成：
     * <p>
     * 最优解析：
     */

    public static void main(String[] args) {

        String digits = "23";
        Simple17 simple17 = new Simple17();
        List<String> re = simple17.letterCombinations2(digits);

        PKt.out("re = " + re);

    }
    /*
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



 

示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]
 

提示：

0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    //回溯算法
    public List<String> letterCombinations2(String digits){
        List<String> ans = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return ans;
        }
        Map<Character, String[]> map = new HashMap<>();
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});

        letterCombinationLoop(map, ans, digits, 0, new StringBuilder());

        return ans;
    }

    private void letterCombinationLoop(Map<Character, String[]> map, List<String> ans,String digits,int index,StringBuilder sb){
        if (index == digits.length()){
            ans.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);
        String[] contents = map.get(c);

        for (String content : contents) {
            sb.append(content);
            letterCombinationLoop(map, ans, digits, index + 1, sb);
            sb.deleteCharAt(index);
        }
    }


    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return ans;
        }
        Map<Character, String[]> map = new HashMap<>();
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});

        char[] chars = digits.toCharArray();
        int len = chars.length;
        if (len == 1){
            Collections.addAll(ans, map.get(chars[0]));
        }else {
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    createLetter(map, ans, chars[i], chars[j]);
                }
            }
        }

        return ans;
    }

    private void createLetter(Map<Character, String[]> map, List<String> ans, char key1, char key2) {
        String[] key1s = map.get(key1);
        String[] key2s = map.get(key2);
        for (String s : key1s) {
            for (String value : key2s) {
                ans.add(s + value);
            }
        }
    }


}
