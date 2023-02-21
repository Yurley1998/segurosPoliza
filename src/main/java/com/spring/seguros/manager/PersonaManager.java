package com.spring.seguros.manager;
import com.spring.seguros.bd.Conexion;
import com.spring.seguros.dto.Personas;
import com.spring.seguros.exceptions.ManagerExceptions;

import java.util.ArrayList;

public interface PersonaManager {
        public void save(Personas personas, Conexion connect) throws ManagerExceptions;
        public void delete(Personas personas,Conexion connect) throws ManagerExceptions;
        public ArrayList<Personas> selectAll( Conexion connect) throws ManagerExceptions;
        public void update(Personas personas, Conexion connect) throws ManagerExceptions;
    }

