package com.xz.provider;

import com.alibaba.csp.sentinel.slots.statistic.MetricEvent;
import com.alibaba.csp.sentinel.slots.statistic.base.LeapArray;
import com.alibaba.csp.sentinel.slots.statistic.base.WindowWrap;
import com.alibaba.csp.sentinel.slots.statistic.data.MetricBucket;
import com.alibaba.csp.sentinel.slots.statistic.metric.occupy.OccupiableBucketLeapArray;

/**
 * @author xz
 * @Description 滑动时间窗口结构处理
 * @date 2020/11/27 16:32
 **/
public class leapArrayTest {
    public static void main(String[] args) throws Exception {
        int sampleCount = 4;
        int intervalInMs = 1000;
        LeapArray<MetricBucket> leapArray = new OccupiableBucketLeapArray(sampleCount, intervalInMs);


        WindowWrap<MetricBucket> window = leapArray.currentWindow();
        window.value().add(MetricEvent.BLOCK, 1);
        window.value().add(MetricEvent.PASS, 11);
        window.value().add(MetricEvent.EXCEPTION, 111);
        window.value().add(MetricEvent.OCCUPIED_PASS, 1111);
        window.value().add(MetricEvent.RT, 11111);
        window.value().add(MetricEvent.SUCCESS, 12345);
        System.out.println(window);
        Thread.sleep(1000);
        System.out.println(leapArray.currentWindow());
        Thread.sleep(1000);
        System.out.println(leapArray.currentWindow());
        Thread.sleep(1000);
        System.out.println(leapArray.currentWindow());
        Thread.sleep(1000);
        System.out.println(leapArray.currentWindow());
    }
}
