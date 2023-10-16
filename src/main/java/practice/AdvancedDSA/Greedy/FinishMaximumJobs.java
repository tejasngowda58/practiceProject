package practice.AdvancedDSA.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FinishMaximumJobs {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 5, 7, 1));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(7, 8, 8, 8));
        System.out.println(solve(A, B));
//        solve(A,B);
    }

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int count = 0;

        ArrayList<Activity> activities = new ArrayList<>();
        for (int i=0; i<A.size(); i++) {
            activities.add(new Activity(A.get(i), B.get(i)));
        }
        if (!activities.isEmpty())
            count++;
        else return 0;

        Collections.sort(activities, Comparator.comparingInt(Activity::getEndTime));
        Activity currentActivity = activities.get(0);
        for (int i=1;i< activities.size(); i++){
            if (currentActivity.endTime<=activities.get(i).startTime){
                count++;
                currentActivity=activities.get(i);
            }
        }
//        for (Activity activity : activities)
//            System.out.println("Start time: "+ activity.startTime + " End time: " + activity.getEndTime());

        return count;
    }

    static class Activity {
        private Integer startTime;
        private Integer endTime;

        public Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }
    }
}



