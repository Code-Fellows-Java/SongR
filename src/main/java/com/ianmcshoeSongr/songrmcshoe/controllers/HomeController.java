package com.ianmcshoeSongr.songrmcshoe.controllers;

import com.ianmcshoeSongr.songrmcshoe.Repositories.Albumrepo;
import com.ianmcshoeSongr.songrmcshoe.models.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class HomeController {
    // home route
    // old way
    @Autowired
    Albumrepo albumrepo;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String getHome() {
        return "Hello World";
    }

    // new way

    @GetMapping("/Oy")
    public String getHi() {
        return "hello";
    }

    @GetMapping("/sayhello/{name}")
    @ResponseBody
    public String  sayHello(@PathVariable String name) {
        return "Hello" + " " + name;
    }

    @GetMapping("/cap/{word}")
    public String capitalizeWord(@PathVariable String word, Model m) {
        m.addAttribute("word", word.toUpperCase());
        return "cap";
    }

    @GetMapping("/albums")
    public String getThreeAlbums(Model m) {
//        String albumString = threeAlbums();
        List<Album> oldAlb = albumrepo.findAll();
        m.addAttribute("albumList", oldAlb);
        return "albums";
    }
    @PostMapping("/albums")
    public RedirectView postAlbums(String title, String artist, String songCount, String lengthInSeconds, String imageURL) {
        int countSong = (int) Integer.parseInt(songCount);
        int songLength = (int) Integer.parseInt(lengthInSeconds);
        Album album = new Album(title,artist,countSong,songLength,imageURL);
        albumrepo.save(album);
        return new RedirectView("/albums");
    }

    private String threeAlbums() {
        Album[] threeAlbums = new Album[3];
        threeAlbums[0] = new Album("Mm..Food", "MF DOOM", 15, 2934, "https://upload.wikimedia.org/wikipedia/en/8/8a/Mmfood.jpg");
        threeAlbums[1] = new Album("Demon Days", "Gorillaz", 20, 3047, "https://upload.wikimedia.org/wikipedia/en/d/df/Gorillaz_Demon_Days.PNG");
        threeAlbums[2] = new Album("Positive Contact", "Deltron 3030", 21, 3618, "https://upload.wikimedia.org/wikipedia/en/thumb/7/7e/Deltron_3030_%28album_cover%29.jpg/220px-Deltron_3030_%28album_cover%29.jpg");

        String albumString = threeAlbums[0].albumString() + ",\n" + threeAlbums[1].albumString() + ",\n" + threeAlbums[2].albumString();
        return albumString;
    }


}
