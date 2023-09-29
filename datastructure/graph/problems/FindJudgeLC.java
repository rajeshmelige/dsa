package dsa.datastructure.graph.problems;

// https://leetcode.com/problems/find-the-town-judge/description/
public class FindJudgeLC {
    public static void main(String[] args) {
        int numberOfPerson = 3;
        int[][] trustGraph = {{1,3}, {2,3}};
        int judge = findJudge(numberOfPerson, trustGraph);
        System.out.println("judge=" +judge);
    }
    private static int findJudge(int n, int[][] trust) {
        if(n==1)    return n;
        int[] count = new int[n+1];
        for(int[] person: trust) {
            count[person[0]]--;
            count[person[1]]++;
        }

        for(int i=0;i<count.length;i++) {
            if(count[i] == n-1) {
                return i;
            }
        }
        return -1;
    }
}
