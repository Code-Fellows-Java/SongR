package com.ianmcshoeSongr.songrmcshoe.controllers;

import com.ianmcshoeSongr.songrmcshoe.Repositories.Albumrepo;
import com.ianmcshoeSongr.songrmcshoe.Repositories.Songs;
import com.ianmcshoeSongr.songrmcshoe.models.Album;
import com.ianmcshoeSongr.songrmcshoe.models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

public class SongController {
    @Autowired
    Songs songrepo;

    @Autowired
    Albumrepo albumrepo;


    @GetMapping("/songs")
    public String getSong(Model m) {
        List<Song> newSong = songrepo.findAll();
        m.addAttribute("songList", newSong);
        return "songs";
    }

    @PostMapping("/songs")
    public RedirectView postSongs(String title, String songLength, String trackNum, String album ) {
        int lengthSong = (int) Integer.parseInt(songLength);
        int numTrack = (int) Integer.parseInt(trackNum);
        Album newAlb = albumrepo.findByTitle(album);
        Song song = new Song(title, lengthSong, numTrack, newAlb);
        songrepo.save(song);
        return new RedirectView("/albums");
    }

}
