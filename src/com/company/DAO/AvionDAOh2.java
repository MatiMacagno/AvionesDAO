package com.company.DAO;

import com.company.Entities.Avion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvionDAOh2 implements IDAO<Avion> {

    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/DB_Aviones";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";


    @Override
    public Avion guardar(Avion avion) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{

            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO AVIONES VALUES(?, ?, ?, ?, ?)");
            preparedStatement.setLong(1, avion.getId());
            preparedStatement.setString(2, avion.getMarca());
            preparedStatement.setString(3, avion.getModelo());
            preparedStatement.setString(4, avion.getMatricula());
            preparedStatement.setString(5, avion.getFechaEntrada());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return avion;
    }

    @Override
    public void eliminar(Long id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("DELETE FROM AVIONES WHERE ID=?");
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Avion buscar(Long id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Avion avion = null;


        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT FROM AVIONES WHERE ID=?");
            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Long idAvion = rs.getLong("ID");
                String marca = rs.getNString("MARCA");
                String modelo = rs.getNString("MODELO");
                String matricula = rs.getNString("MATRICULA");
                String fechadealta = rs.getNString("FECHADEALTA");
                avion = new Avion();
                avion.setId(idAvion);
                avion.setMarca(marca);
                avion.setModelo(modelo);
                avion.setMatricula(matricula);
                avion.setFechaEntrada(fechadealta);
            }

            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(avion);
        return avion;

    }

    @Override
    public List<Avion> buscarTodos() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Avion> aviones = new ArrayList<>();


        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM AVIONES");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Long idAvion = rs.getLong("ID");
                String marca = rs.getNString("MARCA");
                String modelo = rs.getNString("MODELO");
                String matricula = rs.getNString("MATRICULA");
                String fechadealta = rs.getNString("FECHADEALTA");

                Avion avion = new Avion();
                avion.setId(idAvion);
                avion.setMarca(marca);
                avion.setModelo(modelo);
                avion.setMatricula(matricula);
                avion.setFechaEntrada(fechadealta);

                aviones.add(avion);

            }

            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(aviones);

        return aviones;

    }
}
