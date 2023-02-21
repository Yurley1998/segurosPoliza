package com.spring.seguros.dao;
import com.spring.seguros.bd.Conexion;
import com.spring.seguros.dto.Personas;
import com.spring.seguros.exceptions.DaoExceptions;
import com.spring.seguros.exceptions.DaoExceptions;

import java.util.ArrayList;

public interface PersonaDao {
    public void insert(Personas personas, Conexion connect) throws DaoExceptions;
    public void delete(Personas personas,Conexion connect) throws DaoExceptions;
    public Personas getById(Personas personas, Conexion connect) throws DaoExceptions;
    public ArrayList<Personas> getAll( Conexion connect) throws DaoExceptions;
    public void update(Personas personas,Conexion connect) throws DaoExceptions;
}
