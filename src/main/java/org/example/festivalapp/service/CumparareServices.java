package org.example.festivalapp.service;

import org.example.festivalapp.domain.Cumparare;
import org.example.festivalapp.repository.CasierRepository;
import org.example.festivalapp.repository.CumparareRepository;
import org.example.festivalapp.repository.RepositoryException;
import org.example.festivalapp.repository.SpectacolRepository;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class CumparareServices {
    private CumparareRepository cumparareRepo;
    private SpectacolRepository spectacolRepo;
    private CasierRepository casierRepo;

    public CumparareServices(CumparareRepository cumparareRepo, SpectacolRepository spectacolRepo, CasierRepository casierRepo) {
        this.cumparareRepo = cumparareRepo;
        this.spectacolRepo = spectacolRepo;
        this.casierRepo = casierRepo;
    }

    public void addCumparare(String cumparator, int locuri, Integer idSpectacol, Integer idCasier) throws ServicesException {
        try {
            cumparareRepo.save(new Cumparare(cumparator, locuri, this.spectacolRepo.findById(idSpectacol), this.casierRepo.findById(idCasier)));
        } catch (RepositoryException e) {
            throw new ServicesException("Error adding form " + e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCumparare(Integer id) throws ServicesException {
        try {
            cumparareRepo.delete(cumparareRepo.findById(id));
        } catch (RepositoryException e) {
            throw new ServicesException("Error deleting form " + e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCumparare(Integer id, String cumparatorNou, int locuriNoi, Integer idSpectacolNou, Integer idCasierNou) throws ServicesException {
        try {
            cumparareRepo.update(id, new Cumparare(cumparatorNou, locuriNoi, spectacolRepo.findById(idSpectacolNou), casierRepo.findById(idCasierNou)));
        } catch (RepositoryException e) {
            throw new ServicesException("Error updating form " + e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Collection<Cumparare> getAll() {
        return cumparareRepo.getAll();
    }

    public List<Cumparare> filterByCasier(Integer idCasierCautat) throws SQLException {
        return cumparareRepo.filterByCasier(casierRepo.findById(idCasierCautat));
    }

    public List<Cumparare> filterBySpectacol(Integer idSpectacolCautat) throws SQLException {
        return cumparareRepo.filterBySpectacol(spectacolRepo.findById(idSpectacolCautat));
    }
}
