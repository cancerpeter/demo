import java.util.LinkedList;
import java.util.Scanner;

public class ANS {

    public static LinkedList<Integer> temp = new LinkedList<>();
    public static int ans = 0;
    public static int[] array;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = in.nextInt();
        }
        dfs(0);
        System.out.println(ans);
    }

    public static void dfs(int ind){
        if(ind == array.length) {
            return;
        }
        int cur = array[ind];
        if(cur == 1) {
            ans++;
            temp.addLast(cur);
            System.out.println(temp);
        }
        else {
            boolean flag = true;
            for(int i : temp) {
                if(cur % i != 0 && i % cur != 0) {
                    flag = false;
                }
            }
            if(flag) {
                ans++;
                temp.addLast(cur);
                System.out.println(temp);
            }else {
                return;
            }
        }
        for(int i = ind + 1; i < array.length; i++) {
            if(i != ind + 1 && array[i] == array[i - 1]) continue;
            dfs(i);
        }
        temp.removeLast();
        return;
    }
}

