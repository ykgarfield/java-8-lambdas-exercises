package com.insightfullogic.java8.examples.chapter4;

import com.insightfullogic.java8.examples.chapter1.Album;

import java.util.IntSummaryStatistics;

public class Primitives {

    // 　使用 summaryStatistics 方法统计曲目长度
    // BEGIN printTrackLengthStatistics
    public static void printTrackLengthStatistics(Album album) {
        IntSummaryStatistics trackLengthStats
                = album.getTracks()
                // 此方法返回的不是一个一般的 Stream，而是一个特殊处理的 Stream
                // 将每首曲目映射为曲目长度。因为该方法返回一个 IntStream 对象
                .mapToInt(track -> track.getLength())
                .summaryStatistics();

        System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
                trackLengthStats.getMax(),
                trackLengthStats.getMin(),
                trackLengthStats.getAverage(),
                trackLengthStats.getSum());
    }
// END printTrackLengthStatistics

}
