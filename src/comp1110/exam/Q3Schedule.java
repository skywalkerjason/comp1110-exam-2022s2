package comp1110.exam;

import java.util.*;

public class Q3Schedule {



    /**
     * Find the largest set of tasks that can be fit into a schedule of
     * given maximum time, satisfying exclusion constraints.
     * <p>
     * The input consists of N tasks (numbered zero to N-1), and a maximum
     * total time. For each task is given its duration (an integer).
     * However, each task also has given a list of "exclusions", which are
     * other tasks that cannot be included in the schedule if this task is
     * (for example due to location or setup constraints).
     * The task is to select a maximal subset of tasks such that (a) the
     * sum of selected tasks' durations is at most the given maximum
     * schedule time; and (b) no task in the selected subset is in the
     * exclusion list set of another task in the subset.
     * <p>
     * If there are several possible subsets with an equal number of tasks,
     * select the one that has the greatest total duration.
     *
     * @param duration          An array of N integers, representing the duration of
     *                          each task.
     * @param max_schedule_time The maximum total schedule time.
     * @param exclusions        An array of N arrays of ints, representing the
     *                          exclusion list of each task. The exclusion list of task i is
     *                          an array containing the indices of tasks that cannot be in
     *                          the schedule together with task i.
     *                          <p>
     *                          For example, if there are three tasks, 0, 1 and 2, the
     *                          array { {1,2}, {}, {1} } means that task 0 cannot be scheduled
     *                          together with either 1 or 2, task 1 has no exclusions, but
     *                          task 2 cannot be scheduled together with task 1. Note that the
     *                          exclusion lists are not necessarily symmetric.
     * @return The maximal set of scheduled tasks, represented as a boolean
     * array. The size of the array must be N, and it must be true
     * for those tasks that are in the schedule, and false for all
     * others.
     */


    public static boolean[] maximalSchedule(int[] duration, int max_schedule_time, int[][] exclusions) {
        Map<boolean[], Integer> schedules = new HashMap<>();
        boolean[] scheduled = new boolean[duration.length];
        int taskNumber = 0;
        int taskDuration = 0;
        boolean[] result = new boolean[duration.length];

        allSchedules(scheduled, duration, max_schedule_time, exclusions, 0, schedules);

        for (var key : schedules.keySet()) {

            int tempNumber = 0;
            for (boolean b : key) {
                if (b) {
                    tempNumber++;
                }
            }
            if (tempNumber > taskNumber) {
                taskNumber = tempNumber;
                taskDuration = schedules.get(key);
                result = key;
            }
            if (tempNumber == taskNumber) {
                if (schedules.get(key) > taskDuration) {
                    taskDuration = schedules.get(key);
                    result = key;
                }
            }
        }
        // FIXME
        return result;
    }

    public static void allSchedules(boolean[] scheduled, int[] duration, int max_schedule_time, int[][] exclusions, int n, Map<boolean[], Integer> schedules) {

        if (n >= duration.length) {
            return;
        }

        scheduled[n] = true;
        if (canSchedule(n, scheduled, duration, max_schedule_time, exclusions)) {
            int time = 0;
            for (int j = 0; j < duration.length; j++) {
                if (scheduled[j]) {
                    time += duration[j];
                }
            }
            schedules.put(scheduled.clone(), time);
            allSchedules(scheduled, duration, max_schedule_time, exclusions, n + 1, schedules);
        }
        scheduled[n] = false;
        int time = 0;
        for (int j = 0; j < duration.length; j++) {
            if (scheduled[j]) {
                time += duration[j];
            }
        }
        schedules.put(scheduled.clone(), time);
        allSchedules(scheduled, duration, max_schedule_time, exclusions, n + 1, schedules);
    }

    public static boolean canSchedule(int taskN, boolean[] scheduled, int[] duration, int max_schedule_time, int[][] exclusions) {

        int costTime = 0;

        for (int i = 0; i < scheduled.length; i++) {
            if (scheduled[i]) {
                costTime += duration[i];
            }
        }

        if (costTime > max_schedule_time) {
            return false;
        }

        for (int i = 0; i < exclusions[taskN].length; i++) {
            if (scheduled[exclusions[taskN][i]]) {
                return false;
            }
        }

        for (int i = 0; i < scheduled.length; i++) {
            if (scheduled[i]) {
                for (int j = 0; j < exclusions[i].length; j++) {
                    if (exclusions[i][j] == taskN) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
