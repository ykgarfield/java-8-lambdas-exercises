package com.insightfullogic.java8.answers.chapter3;

import com.insightfullogic.java8.examples.chapter1.Artist;

import java.util.List;
import java.util.stream.Stream;

public class Question2 {
    // Q3
    public static int countBandMembersInternal(List<Artist> artists) {
        // NB: readers haven't learnt about primitives yet, so can't use the sum() method
        return artists.stream()
                .map(artist -> artist.getMembers().count())
                .reduce(0L, Long::sum)
                .intValue();
    }


    /**
     * 使用 flatMap() 方法
     */
    public static long useFlatMapCountBandMembersInterna(List<Artist> artists) {
        return artists.stream()
                .flatMap(artist -> artist.getMembers())
                .count();
    }
}
