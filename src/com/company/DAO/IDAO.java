package com.company.DAO;

import java.sql.SQLException;
import java.util.List;

public interface IDAO <T> {

    public T guardar(T t) throws SQLException;
    public void eliminar(Long id);
    public T buscar (Long id);
    public List<T> buscarTodos();


}
