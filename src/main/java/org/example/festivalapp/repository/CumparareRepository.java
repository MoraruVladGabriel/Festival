package org.example.festivalapp.repository;

import org.example.festivalapp.domain.Casier;
import org.example.festivalapp.domain.Cumparare;
import org.example.festivalapp.domain.Spectacol;

import java.util.List;

public interface CumparareRepository extends Repository<Integer, Cumparare>{
    List<Cumparare> filterByCasier(Casier casierCautat);
    List<Cumparare> filterBySpectacol(Spectacol spectacolCautat);
}
