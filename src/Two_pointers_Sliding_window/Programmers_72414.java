package Two_pointers_Sliding_window;

public class Programmers_72414 {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = getTotalSeconds(play_time);
        int[] dp = new int[playTime];
        int advTime = getTotalSeconds(adv_time);

        for(String log : logs) {
            String[] logSplit = log.split("-");

            int startSecond = getTotalSeconds(logSplit[0]);
            int finishSecond = getTotalSeconds(logSplit[1]);

            for(int i = startSecond; i < finishSecond; i++) {
                dp[i]++;
            }
        }

        int maxIdx = 0;
        long totalTime = 0;
        for (int i = 0; i < advTime; i++) {
            totalTime += dp[i];
        }
        long maxTotalTime = totalTime;
        for (int i = advTime; i < playTime; i++) {
            totalTime += dp[i] - dp[i - advTime];
            if (totalTime > maxTotalTime) {
                maxTotalTime = totalTime;
                maxIdx = i - advTime + 1;
            }
        }

        String ans = getSecString(maxIdx);
        System.out.println(maxIdx);

        return ans;
    }

    private int getTotalSeconds(String time) {
        String[] splitTimes = time.split(":");

        return Integer.parseInt(splitTimes[0])*60*60 +
                Integer.parseInt(splitTimes[1])*60 +
                Integer.parseInt(splitTimes[2]);
    }

    private String getSecString(int seconds) {
        int HH = seconds / 3600;
        int MM = (seconds % 3600) / 60;
        int SS = seconds % 60;

        return String.format("%02d:%02d:%02d", HH, MM, SS);
    }
}
