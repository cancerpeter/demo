//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//
////        多多最近在玩一款单人闯关游戏，多多需要操控游戏角色，打败敌人，获取经验和装备，最终通关。
////        游戏里一共有n关，只有通过了第i - 1关，才能进入第i关，并且不能回到之前的关卡。
////        每关的关底，会有一个boss或一个商人。当打赢关底boss之后，除了正常获取经验和装备外，boss还会额外掉落一颗宝石。
////        当遇到关底的商人时，多多可以将宝石出售给关底商人，获得特殊的游戏货币。
////        值得注意的是，宝石一共有m种，关底的boss会固定掉落m种宝石中的一种，关底的商人也只会固定购买m种宝石中的一种。
////        并且多多操控的游戏角色，同时只能携带最多一颗宝石。
////        由于通关时角色身上的特殊的游戏货币数量将会直接影响最终的通关评分，多多为了获得最高的通关评分，已经上网提前查好了攻略，提前知道了每关关底boss掉落的宝石种类信息和商人购买宝石信息。
////        现在多多想知道，自己在通关的时候，最多能获取多少特殊的游戏货币。
//
////        第一行两个正整数n和m，分别表示关卡总数和宝石种类数。
////        第二行到第n + 1行，表示第1关到第n关的信息，每行的开头是一个字符。
////        当字符为b时，后面会有一个整数x，表示当前关的关底为boss，该boss会固定掉落第x种宝石。
////        当字符为m时，后面会有两个整数x和y，表示当前关的关底为商人，该商人会固定购买第x种宝石，并且购买的价格为y。
//
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        char[] bOrM = new char[n];
//        int[] bX = new int[n];
//        int[][] mXY = new int[n][2];
////        for(int i = 0; i < n; i++){
////
////            if(bOrM[i] == 'b'){
////                bX[i] = in.nextInt();
////            }else{
////                mXY[i][0] = in.nextInt();
////                mXY[i][1] = in.nextInt();
////            }
////        }
//        in.nextLine();
//        for(int i = 0; i < n; i++){
//            String s = in.nextLine();
//            String[] s1 = s.split(" ");
//            bOrM[i] = s.charAt(0);
//            if(bOrM[i] == 'b'){
//                bX[i] = Integer.valueOf(s1[1]);
//            }else{
//                mXY[i][0] = Integer.valueOf(s1[1]);
//                mXY[i][1] = Integer.valueOf(s1[2]);
//            }
//        }
//        boolean hasB = false;
//        boolean[] hasType = new boolean[m];
//        Map<Integer, Integer> history = new HashMap<>();
//        int maxValue = 0;
//        int maxType = -1;
//        int ans = 0;
//        for(int i = 0; i < n; i++){
//            if(bOrM[i] == 'b'){
//                if(maxValue != 0){
//                    ans += maxValue;
//                    Arrays.fill(hasType, false);
//                }
//                hasType[bX[i] - 1] = true;
//            }else{
//                int curType = mXY[i][0];
//                int curValue = mXY[i][1];
//                if(hasType[curType - 1]){
//                    maxValue = Math.max(curValue, maxValue);
//
//                }
//            }
//        }
//        ans += maxValue;
//        System.out.println(ans);
//    }
//
//}
//

//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//
//        int[][] edg = new int[n][3];
//
//
//        for(int i = 0; i < n; i++){
//            edg[i][0] = in.nextInt();
//            edg[i][1] = in.nextInt();
//            edg[i][2] = in.nextInt();
//        }
//
//
//        System.out.println(5);
//    }
//
//}
//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//
////        多多鸡拥有一个长度为n的数组A，下标范围从0到n-1，数组仅由数字 -8, -4, -2, -1, 0, 1, 2, 4, 8 组成。
////
////        现在，多多希望从A中取出一个连续子数组B，要求B的所有数字之积尽可能的大。
////
////        备注: B 可以为空数组，空数组的数字之积定义为 1。
//
//
////        共两行：
////        第一行, 一个整数 n
////        第二行, 表示数组 A，n个整数，用空格隔开
////
////        备注：1 <= n <= 100,000
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//
//        int[] A = new int[n];
//
//        for(int i = 0; i < n; i++){
//            A[i] = in.nextInt();
//        }
//
//        int l = 0, r = 0;
//        int maxValue = 1;
//        for(int i = 0; i < n; i++){
//            int curValue = A[i];
//            if(maxValue < curValue){
//                maxValue = curValue;
//                l = i;
//                r = i;
//            }
//            for(int j = i + 1; j < n; j++){
//                curValue = curValue * A[j];
//                if(maxValue < curValue){
//                    maxValue = curValue;
//                    l = i;
//                    r = i;
//                }
//            }
//        }
//        System.out.println();
//    }
//
//}

import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<int[]> lsit = new ArrayList<>();


        for(int i = 0; i < n; i++){
            int length = in.nextInt();
            int[] cur = new int[length];
            for(int j = 0; j < length; j++){
                cur[j] = in.nextInt();
            }
            lsit.add(cur);
        }

        for(int[] cur : lsit){
            if(cur.length <= 1) {
                System.out.println("0");
                continue;
            }
            Set<Integer> hasOp = new HashSet<>();
            LinkedList<Integer> q = new LinkedList<>();
            int len = cur.length;
            int ans = 0;
            for(int i = len - 1; i > 0; i--){
                int curNum = cur[i];
                if(hasOp.contains(curNum)){
                    curNum = 0;
                }
                if(cur[i - 1] > curNum){
                    if(hasOp.contains(cur[i - 1])) continue;
                    hasOp.add(cur[i - 1]);
                    ans++;
                }
            }
            for(int i = len - 1; i > 0; i--){
                int curNum = cur[i];
                if(hasOp.contains(curNum)){
                    curNum = 0;
                }
                if(cur[i - 1] > curNum){
                    if(hasOp.contains(cur[i - 1])) continue;
                    hasOp.add(cur[i - 1]);
                    ans++;
                }
            }
            System.out.println(ans);
        }

    }


}