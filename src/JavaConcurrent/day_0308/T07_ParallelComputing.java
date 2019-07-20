package JavaConcurrent.day_0308;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class T07_ParallelComputing {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        List<Integer> resluts = getPrime(1,200000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        final int cpuCoreNum = 4;
        ExecutorService service = Executors.newFixedThreadPool(cpuCoreNum);

        Mytask t1 = new Mytask(1,80000);//为什么不平均分，因为越大的数，素数计算的时间越长
        Mytask t2 = new Mytask(80001,130000);
        Mytask t3 = new Mytask(130001,170000);
        Mytask t4 = new Mytask(170001,200000);

        Future<List<Integer>> f1 = service.submit(t1);
        Future<List<Integer>> f2 = service.submit(t2);
        Future<List<Integer>> f3 = service.submit(t3);
        Future<List<Integer>> f4 = service.submit(t4);

        start = System.currentTimeMillis();
        f1.get();
        f2.get();
        f3.get();
        f4.get();
        end = System.currentTimeMillis();
        System.out.println(end - start);


    }


    static class Mytask implements Callable<List<Integer>>{

        int startPos,endPos;

        Mytask(int s,int e){
            this.endPos = e;
            this.startPos = s;
        }
        @Override
        public List<Integer> call() throws Exception {
            List<Integer> r = getPrime(startPos,endPos);
            return r;
        }
    }

    static boolean isPrime(int num){
        for (int i = 2; i <= num/2 ; i++) {
            if(num%i == 0) return false;
        }
        return true;
    }

    static List<Integer> getPrime(int start,int end){
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <=end ; i++) {
            if(isPrime(i)){
                list.add(i);
            }
        }
        return list;
    }
}
