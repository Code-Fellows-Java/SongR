package com.ianmcshoeSongr.songrmcshoe.Repositories;

import com.ianmcshoeSongr.songrmcshoe.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Albumrepo extends JpaRepository <Album, Long>{

    public Album findByTitle(String title);

}

