package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class Assignment_4_HelperClass {

    public static void main(String[] args) {


        Random random = new Random(68957);
        int doubling = 10,  totalRounds = 15, trialCount = 10;

        for (int i = 0; i < totalRounds; i++, doubling *= 2) {
            int pairCount = 0;
            UF_HWQUPC unionFindObj = new UF_HWQUPC(doubling);
            for (int j = 0; j < trialCount; j++) {
                int totalCountofPairs = 0;
                while (unionFindObj.components() > 1) {
                    int x = random.nextInt(doubling);
                    int y = random.nextInt(doubling);
                    if (!unionFindObj.connected(x, y)) {
                        unionFindObj.union(x, y);
                    }
                    totalCountofPairs++;
                }
                pairCount = pairCount+ totalCountofPairs;
            }
            int average = (pairCount / trialCount);
            StringBuffer sb = new StringBuffer();
            sb.append("doubling = ").append(doubling).append(", average pairs required = ").append(average).append(" ");
            System.out.println(sb.toString());
        }
    }
}
