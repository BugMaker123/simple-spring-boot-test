package com.example.simplespringboottest.prac.net.mult.senior;

import java.util.concurrent.*;

/**
 * Fork/Join 框架是 Java7 提供了的一个用于并行执行任务的框架，
 * 是一个把大任务分割成若干个小任务，最终汇总每个小任务结果后得到大任务结果的框架。类似于Java 8中的parallel Stream。
 */
public class ForkJoinTest {
    public static void main(String[] args) {
        CalcForJoinTask calcForJoinTask = new CalcForJoinTask(1, 1000);

        // 这是Fork/Join框架的线程池
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> taskFuture = pool.submit(calcForJoinTask);
        try {
            Integer result = taskFuture.get();
            System.out.println("result:" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
    //针对一个数字，做计算。
    private static final Integer MAX = 200;

    static class CalcForJoinTask extends RecursiveTask<Integer> {
        private Integer startValue; //子任务的开始计算的值
        private Integer endValue; //子任务结束计算的值

        public CalcForJoinTask(Integer startValue, Integer endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        protected Integer compute() {
            //如果当前的数据区间已经小于MAX了，那么接下来的计算不需要做拆分
            if (endValue - startValue < MAX) {
                System.out.println("开始计算：startValue:" + startValue + " ; endValue:" + endValue);
                Integer totalValue = 0;
                for (int i = this.startValue; i <= this.endValue; i++) {
                    totalValue += i;
                }
                return totalValue;
            }
            //任务拆分，拆分成两个任务
            CalcForJoinTask subTask = new CalcForJoinTask(startValue, (startValue + endValue) / 2);
            subTask.fork();

            CalcForJoinTask calcForJoinTask = new CalcForJoinTask((startValue + endValue) / 2 + 1, endValue);
            calcForJoinTask.fork();


            return subTask.join() + calcForJoinTask.join();
        }
    }
}
