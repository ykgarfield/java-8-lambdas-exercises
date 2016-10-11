package com.insightfullogic.java8.examples.chapter3;

import com.insightfullogic.java8.examples.chapter1.Artist;

import java.util.Iterator;
import java.util.List;


/**
 * 判断一个操作是惰性求值还是及早求值很简单：只需看它的返回值。
 * 如果返回值是 Stream，那么是惰性求值；如果返回值是另一个值或为空，那么就是及早求值
 */
public class Iteration {

    /**
     * 外部迭代
     */
    public int externalCountArtistsFromLondon(List<Artist> allArtists) {
        // BEGIN external_count_londoners
        int count = 0;
        for (Artist artist : allArtists) {
            if (artist.isFrom("London")) {
                count++;
            }
        }
        // END external_count_londoners
        return count;
    }

    /**
     * 外部迭代
     */
    public int externalCountArtistsFromLondonExpanded(List<Artist> allArtists) {
        // BEGIN external_count_londoners_expanded
        int count = 0;
        Iterator<Artist> iterator = allArtists.iterator();
        while (iterator.hasNext()) {
            Artist artist = iterator.next();
            if (artist.isFrom("London")) {
                count++;
            }
        }
        // END external_count_londoners_expanded
        return count;
    }


    /**
     * 使用内部迭代
     */
    public long internalCountArtistsFromLondon(List<Artist> allArtists) {
        // BEGIN internal_count_londoners
        long count = allArtists.stream()
                .filter(artist -> artist.isFrom("London"))
                .count();
        // END internal_count_londoners
        return count;
    }


    /**
     * 只过滤, 不计数
     *
     * 这行代码并未做什么实际性的工作，filter 只刻画出了 Stream，但没有产生新的集合。
     * 像 filter 这样只描述 Stream，最终不产生新集合的方法叫作惰性求值方法；
     * 而像 count 这样最终会从 Stream 产生值的方法叫作及早求值方法。
     */
    public void filterArtistsFromLondon(List<Artist> allArtists) {
        // BEGIN filter_londoners
        allArtists.stream()
                .filter(artist -> artist.isFrom("London"));
        // END filter_londoners
    }


    /**
     * 由于使用了惰性求值，没有输出艺术家的名字
     */
    public void filterArtistsFromLondonPrinted(List<Artist> allArtists) {
        // BEGIN filter_londoners_printed
        allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom("London");
                });
        // END filter_londoners_printed
    }


    /**
     * 会被输出
     */
    public long internalCountArtistsFromLondonPrinted(List<Artist> allArtists) {
        // BEGIN internal_count_londoners_printed
        long count = allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom("London");
                })
                .count();
        // END internal_count_londoners_printed
        return count;
    }

}
