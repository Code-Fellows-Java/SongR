package com.ianmcshoeSongr.songrmcshoe.Repositories;

import com.ianmcshoeSongr.songrmcshoe.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Songs extends JpaRepository <Song, Long> {


}
