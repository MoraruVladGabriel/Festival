package org.example.festivalapp.repository;

import org.example.festivalapp.domain.Artist;

import java.util.List;

public interface ArtistRepository extends Repository<Integer, Artist>{
    List<Artist> filterByTip(String tip);
}
