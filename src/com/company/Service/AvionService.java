package com.company.Service;

import com.company.DAO.IDAO;
import com.company.Entities.Avion;

import java.sql.SQLException;
import java.util.List;

public class AvionService {

    private IDAO<Avion> avionIDAO;

    public IDAO<Avion> getAvionIDAO() {
        return avionIDAO;
    }

    public void setAvionIDAO(IDAO<Avion> avionIDAO) {
        this.avionIDAO = avionIDAO;
    }

    public Avion guardarAvion (Avion a) throws SQLException {
        return avionIDAO.guardar(a);
    }

    public void eliminarAvion (Long id) {
        avionIDAO.eliminar(id);
    }

    public Avion buscarAvion (Long id) {
        return avionIDAO.buscar(id);
    }

    public List<Avion> buscarTodosLosAviones () {
        return avionIDAO.buscarTodos();
    }

}
