package com.xz.provider.thread.pool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xz
 * @ClassName ThreaPoolTest
 * @Description
 * @date 2020/12/2 17:08
 **/
public class ThreadPoolTest {
    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    // 带符号位 左移 = -1 + count_bits个零, 而count位为 2的count_bits次方 - 1
    // 也就是 1 + count_bits - 1 个 1, 计算workerCount 时则通过 状态值 按位与上 容量 2的29次方-1
    // 11111111111111111111111111111
    // 100000000000000000000000000000 - 掩码补码机制
    // 当累加count 时 从低位开始累加
    // 100000000000000000000000000001 与上 2的29次方-1 则就是 1
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS; // 0
    private static final int STOP       =  1 << COUNT_BITS; // 100000000000000000000000000000
    private static final int TIDYING    =  2 << COUNT_BITS; // 1000000000000000000000000000000
    private static final int TERMINATED =  3 << COUNT_BITS; // 10000000000000000000000000000000

    // Packing and unpacking ctl
    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }

    public static void main(String[] args) {
        ThreadPoolTest test = new ThreadPoolTest();
        int i = test.ctl.get();
        System.out.println(i);
        System.out.println(workerCountOf(i));
        System.out.println(CAPACITY);
        test.ctl.compareAndSet(i, i + 1);
        System.out.println(test.ctl.get());
        System.out.println(runStateOf(test.ctl.get()));
    }
}
