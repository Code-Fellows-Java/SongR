package com.ianmcshoeSongr.songrmcshoe.models;

import javax.persistence.*;

@Entity
public class Song {
        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public int getSongLength() {
                return songLength;
        }

        public void setSongLength(int songLength) {
                this.songLength = songLength;
        }

        public int getTrackNum() {
                return trackNum;
        }

        public void setTrackNum(int trackNum) {
                this.trackNum = trackNum;
        }

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

        private String title;

        private int songLength;

        private int trackNum;

        @ManyToOne
        Album album;

        public Song() {}

        public Song(String title, int songLength, int trackNum, Album album) {
                this.title = title;
                this.songLength = songLength;
                this.trackNum = trackNum;
                this.album = album;
        }

}
