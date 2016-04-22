package com.insightfullogic.java8.examples.chapter3;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.Track;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class Refactor {

    public interface LongTrackFinder {
        Set<String> findLongTracks(List<Album> albums);
    }


    // 遗留代码：找出长度大于 1 分钟的曲目
    public static class Step0 implements LongTrackFinder {
        // BEGIN findLongTracks_0
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();
            for (Album album : albums) {
                for (Track track : album.getTrackList()) {
                    if (track.getLength() > 60) {
                        String name = track.getName();
                        trackNames.add(name);
                    }
                }
            }
            return trackNames;
        }
        // END findLongTracks_0
    }

    public static class Step1 implements LongTrackFinder {
        // BEGIN findLongTracks_1
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();
            albums.stream()
                    .forEach(album -> {
                        album.getTracks()
                                /*
                                    最内层的 forEach 方法有三个功用：
                                    1. 找出长度大于 1 分钟的曲目
                                    2. 得到符合条件的曲目名称
                                    3. 将曲目名称加入集合 Set
                                 */
                                .forEach(track -> {
                                    if (track.getLength() > 60) {
                                        String name = track.getName();
                                        trackNames.add(name);
                                    }
                                });
                    });
            return trackNames;
        }
        // END findLongTracks_1
    }

    public static class Step2 implements LongTrackFinder {
        // BEGIN findLongTracks_2
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();
            albums.stream()
                    .forEach(album -> {
                        album.getTracks()
                                // 找出满足某种条件的曲目是 filter 的功能
                                .filter(track -> track.getLength() > 60)
                                // 得到曲目名称则可用 map 达成
                                .map(track -> track.getName())
                                // 终结操作可使用 forEach 方法将曲目名称加入一个集合
                                .forEach(name -> trackNames.add(name));
                    });

            return trackNames;
        }
        // END findLongTracks_2
    }

    public static class Step3 implements LongTrackFinder {
        // BEGIN findLongTracks_3
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();

            albums.stream()
                    // 把多个 Stream 合并成一个 Stream 并返回
                    // 这里是将所有的 album 下的 Tracks 合并成一个 Stream
                    .flatMap(album -> album.getTracks())
                    .filter(track -> track.getLength() > 60)
                    .map(track -> track.getName())
                    .forEach(name -> trackNames.add(name));

            return trackNames;
        }
        // END findLongTracks_3
    }

    public static class Step4 implements LongTrackFinder {
        // BEGIN findLongTracks_4
        public Set<String> findLongTracks(List<Album> albums) {
            return albums.stream()
                    .flatMap(album -> album.getTracks())
                    .filter(track -> track.getLength() > 60)
                    .map(track -> track.getName())
                    .collect(toSet());
        }
        // END findLongTracks_4
    }

}
