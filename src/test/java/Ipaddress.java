//评测题目: 
// 
//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

import java.util.ArrayList;
import java.util.List;

// 输入：s = "25525511135"
// 输出：["255.255.11.135","255.255.111.35"]
// 111011 => [1.11.01.1] (错) 1.11.0.11,11.1.0.11,...
public class Ipaddress {
    List<String> res = new ArrayList<>();
    StringBuilder temp = new StringBuilder();
    int curNum = 0;
    String s;
    public static void main(String[] args) {
        String s = "255255255255";
        Ipaddress ipaddress = new Ipaddress();
        String[] ans = ipaddress.sToIp(s);
        for(String ss : ans){
            System.out.println(ss);
        }
//        StringBuilder temp = new StringBuilder();
//        temp.append("111111111");
//        temp.append("0.");
//        temp.delete(temp.length() - 1 - 1,temp.length());
//        temp.deleteCharAt(temp.length() - 1);
//        System.out.println(temp);
    }
    public String[] sToIp(String s){
        this.s = s;
        dfs(0);
        String[] ans = new String[res.size()];
        int ind = 0;
        for(String ss : res){
            ans[ind++] = ss;
        }
        return ans;
    }
    public void dfs(int ind){
        if(curNum == 4){
            temp.deleteCharAt(temp.length() - 1);
            if(ind == s.length()){
                res.add(temp.toString());
            }
            temp.append('.');
            return;
        }
        if(ind == s.length()) return;
        if(s.charAt(ind) == '0'){
            temp.append("0.");
            curNum++;
            dfs(ind + 1);
            curNum--;
            temp.delete(temp.length() - 2,temp.length());
            return;
        }
        int cur = 0;
        for(int i = 0; i < 3; i++){
            cur = 10 * cur;
            if(ind + i == s.length()) return;
            cur += s.charAt(ind + i) - '0';

            if(cur > 255) return;
            temp.append(cur);
            temp.append('.');
//            System.out.println(temp);
            curNum++;
            dfs(ind + i + 1);
            curNum--;
            temp.delete(temp.length() - i - 2,temp.length());
        }
    }
}