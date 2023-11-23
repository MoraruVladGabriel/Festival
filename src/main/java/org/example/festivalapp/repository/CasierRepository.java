package org.example.festivalapp.repository;

import org.example.festivalapp.domain.Casier;

import java.util.List;

public interface CasierRepository extends Repository<Integer, Casier>{
    List<Casier> filterByOficiu(String oficiuCautat);
    Casier getCasierByEmail(String emailCautat);
}
