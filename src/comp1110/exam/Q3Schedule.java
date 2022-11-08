package comp1110.exam;

import java.util.ArrayList;
import java.util.List;

public class Q3Schedule {

    /**
     * Find the largest set of tasks that can be fit into a schedule of
     * given maximum time, satisfying exclusion constraints.
     *
     * The input consists of N tasks (numbered zero to N-1), and a maximum
     * total time. For each task is given its duration (an integer).
     * However, each task also has given a list of "exclusions", which are
     * other tasks that cannot be included in the schedule if this task is
     * (for example due to location or setup constraints).
     * The task is to select a maximal subset of tasks such that (a) the
     * sum of selected tasks' durations is at most the given maximum
     * schedule time; and (b) no task in the selected subset is in the
     * exclusion list set of another task in the subset.
     *
     * If there are several possible subsets with an equal number of tasks,
     * select the one that has the greatest total duration.
     *
     * @param duration An array of N integers, representing the duration of
     *        each task.
     * @param max_schedule_time The maximum total schedule time.
     * @param exclusions An array of N arrays of ints, representing the
     *        exclusion list of each task. The exlusion list of task i is
     *        an array containing the indices of tasks that cannot be in
     *        the schedule together with task i.
     *
     *        For example, if there are three tasks, 0, 1 and 2, the
     *        array { {1,2}, {}, {1} } means that task 0 cannot be scheduled
     *        together with either 1 or 2, task 1 has no exclusions, but
     *        task 2 cannot be scheduled together with task 1. Note that the
     *        exclusion lists are not necessarily symmetric.
     *
     * @return The maximal set of scheduled tasks, represented as a boolean
     *         array. The size of the array must be N, and it must be true
     *         for those tasks that are in the schedule, and false for all
     *         others.
     */
    public static boolean[] maximalSchedule(int[] duration, int max_schedule_time, int[][] exclusions) {
        boolean[] findmax = new boolean[duration.length];
        List<Integer> used = new ArrayList<>();
        int num = 0;
        for (int i = 0 ;i < duration.length;i++){
            if (findMax(duration,max_schedule_time,exclusions,used,duration[i],i,findmax)){
                int newnum = 0;
                if (num==0){
                    for (int j = 0; j< findmax.length;j++){
                        if (findmax[j]){
                            num+=duration[j];
                        }
                    }
                }else {
                    for (int j = 0; j< findmax.length;j++){
                        if (findmax[j]){
                            newnum+=duration[j];
                        }
                    }
                }

            }
        }
	// FIXME
	return findmax;
    }

    public static boolean findMax (int[] duration, int max_schedule_time, int[][] exclusions, List<Integer> used,Integer max ,int task1,boolean[]findmax){
        if (max>=max_schedule_time){
            return false;
        }
      for (int i = 0; i< duration.length;i++){
          if (!used.contains(i)){
              if (max+duration[i]<=max_schedule_time&&notExclude(exclusions,task1,i)){
                  used.add(i);
                  if(!findMax(duration,max_schedule_time,exclusions,used,max+duration[i],i)){
                  used.remove(i);}
                  findmax[i]=true;
                  return true;
              }
          }
      }
    }
    public static boolean notExclude(int[][]exclusion,int task1,int task2){
        for (int i = 0;i<exclusion[task1].length;i++){
            if (exclusion[task1][i]==task2){
                return false;
            }
        }
        return true;
    }



}
