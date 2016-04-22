/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.insightfullogic.java8.examples.chapter1;

/**
 * @author richard
 *
 * 一首歌曲
 */
public final class Track {

    // 歌曲名称
    private final String name;

    // 歌曲长度(时长)
    private final int length;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the length of the track in milliseconds.
     */
    public int getLength() {
        return length;
    }

    public Track copy() {
        return new Track(name, length);
    }

}
