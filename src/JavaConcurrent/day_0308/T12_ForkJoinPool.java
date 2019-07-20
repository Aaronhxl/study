package JavaConcurrent.day_0308;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * fork:分叉 join:合并
 */

public class T12_ForkJoinPool {
    static int[] nums = new int[1000000];
    static final int MAX_NUM = 50000;
    static Random r = new Random();

    static {
        for (int i = 0; i <nums.length ; i++) {
            nums[i] = r.nextInt(100);
        }
        System.out.println(Arrays.stream(nums).sum());//jdk1.8里面的新特性，将Arrays转换成一个流，利用流相加
    }

    /*static class AddTask extends RecursiveAction{//继承此类并没有返回值，所以没有join

        int start,end;
        AddTask(int s,int e){
            this.start = s;
            this.end = e;
        }
        @Override
        protected void compute() {
            if(end - start<=MAX_NUM){
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum+=nums[i];
                }
                System.out.println("from: "+start+" to: "+end+" = "+sum);
            }else {
                int middle = start + (end - start)/2;
                AddTask subTask1 = new AddTask(start,middle);
                AddTask subTask2 = new AddTask(middle,end);
                subTask1.fork();
                subTask2.fork();
            }
        }
    }*/

    static class AddTask extends RecursiveTask<Long>{

        int start,end;
        AddTask(int s,int e){
            this.start = s;
            this.end = e;
        }
        @Override
        protected Long compute() {
            if(end - start<=MAX_NUM){
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum+=nums[i];
                }
                System.out.println("from: "+start+" to: "+end+" = "+sum);
                return sum;
            }
                int middle = start + (end - start)/2;
                AddTask subTask1 = new AddTask(start,middle);
                AddTask subTask2 = new AddTask(middle,end);
                subTask1.fork();
                subTask2.fork();

                return subTask1.join()+subTask2.join();

        }
    }

    public static void main(String[] args) throws IOException {
        ForkJoinPool fip = new ForkJoinPool();
        AddTask task = new AddTask(0,nums.length);
        fip.execute(task);
        long result = task.join();
        System.out.println(result);
        //精灵线程
        System.in.read();
    }
}
