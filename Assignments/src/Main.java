import java.util.*;

public class Main {


    static ArrayList<Job> arrivedJobs = new ArrayList<>();

    public static void runJob(Job job, int cycleCounter) {
        if (job.getCpuCycles() > 0)
            job.setCpuCycles(job.getCpuCycles() - 1);
        if (job.getCpuCycles() == 0) {
            job.setTurnAroundTime(cycleCounter);
            arrivedJobs.remove(job);
            System.out.println("Job " + job.getName() + " has completed at stop time: " + job.getTurnAroundTime());
        }
    }


    static public void SJN(){
        //ArrayList of Jobs is sorted by CPUCycles in ascending order
        ArrayList<Job> jobs = createSortedJobsArray();
        ArrayList<Job> arrivedJobs = new ArrayList<>();
        int cycleCount = 0;
        int WaitTimeTotal = 0;
        int n = jobs.size();
        int maxCPUCycle;

       do {
            Job jobToRun = null;
            for(Job job: jobs){
                if(job.getCpuCycles() == cycleCount)
                    arrivedJobs.add(job);
            }

            if(jobToRun == null){
                for(Job job : arrivedJobs){
                    if (job.getCpuCycles() > 0){
                        jobToRun = job;
                    }
                }
            }

            if(jobToRun != null) {
                runJob(jobToRun, cycleCount);
            }
            maxCPUCycle = jobs.get(jobs.size()-1).getCpuCycles();
            cycleCount ++;

        } while (maxCPUCycle >0);

//        //Calculate Stop times and add them to total
//        for(Job job: jobs){
//            while(job.getCpuCycles() != 0){
//                job.decrementCPUCycles();
//                cycleCount ++;
//            }
//            job.setStopTime(cycleCount);
//            WaitTimeTotal += job.getStopTime() - job.getArrivalTime();
//        }

        //Print answers
        for(Job job: jobs){
            job.printJobs();
        }
        System.out.println("Average Wait Time : " + (WaitTimeTotal / n));


    }


            static public void roundRobin(){
                ArrayList<Job> jobs = createJobsArray();
                int time =0, timeSlice = 4, avgTurnAroundTime = 0, n = jobs.size();
                ArrayList<Integer> remainingCycles= new ArrayList<>();
                for(Job job: jobs) remainingCycles.add(job.getCpuCycles());
               while (true) {
                   boolean done = true;
                   for (int i = 0; i < n; i++) {
                       Job job = jobs.get(i);
                       if (remainingCycles.get(i) > 0 ) {
                           done = false;

                           //Job continues
                           if(remainingCycles.get(i)  > timeSlice){
                               time += timeSlice;
                               remainingCycles.set(i, remainingCycles.get(i) - timeSlice);
                           }
                           //End of Job
                           else{
                               time = time + remainingCycles.get(i);
                               remainingCycles.set(i, 0);
                               job.setTurnAroundTime(time - job.getArrivalTime());
                               avgTurnAroundTime += job.getTurnAroundTime();
                           }
                       }
                   }
                   if (done == true) break;
               }
               avgTurnAroundTime /= n;
                printRoundRobin(avgTurnAroundTime, jobs);
            }

    public static void printRoundRobin(int avgTurnAroundTime, ArrayList<Job> jobs) {
        for(int i = 0; i < 50; i ++) System.out.print("*");
        System.out.println();
        for(Job job: jobs) job.printJobs();
        System.out.println("Average Turnaround Time: " + avgTurnAroundTime);
        for(int i = 0; i < 50; i ++) System.out.print("*");
        System.out.println();
    }

    public static ArrayList<Job> createSortedJobsArray () {
                ArrayList<Job> jobs = new ArrayList<>();
                Job A = new Job("A", 0, 16, false, 0);
                jobs.add(A);
                Job B = new Job("B", 1, 3, false, 0);
                jobs.add(B);
                Job C = new Job("C", 2, 8, false, 0);
                jobs.add(C);
                Job D = new Job("D", 3, 4, false, 0);
                jobs.add(C);
                Job E = new Job("E", 4, 5, false, 0);
                jobs.add(D);
                Job F = new Job("F", 5, 1, false, 0);
                jobs.add(F);
                Job G = new Job("G", 6, 6, false, 0);
                jobs.add(G);

                Collections.sort(jobs, Job::compareTo);
                return jobs;

            }

            public static ArrayList<Job> createJobsArray () {
                ArrayList<Job> jobs = new ArrayList<>();
                Job A = new Job("A", 0, 16, false, 0);
                jobs.add(A);
                Job B = new Job("B", 1, 3, false, 0);
                jobs.add(B);
                Job C = new Job("C", 2, 8, false, 0);
                jobs.add(C);
                Job D = new Job("D", 3, 4, false, 0);
                jobs.add(D);
                Job E = new Job("E", 4, 5, false, 0);
                jobs.add(E);
                Job F = new Job("F", 5, 1, false, 0);
                jobs.add(F);
                Job G = new Job("G", 6, 6, false, 0);
                jobs.add(G);

                return jobs;

            }


            public static void main (String[]args){
                ArrayList<Job> jobs = createJobsArray();
                roundRobin();
//                for(Job job: jobs) job.printJobs();

            }
        }
