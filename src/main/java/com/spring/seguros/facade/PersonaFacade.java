package com.spring.seguros.facade;
import com.spring.seguros.dto.Personas;
import java.util.ArrayList;
import com.spring.seguros.exceptions.FacadeExceptions;


public interface PersonaFacade{
        public void createPerson(Personas personas) throws FacadeExceptions;
        public void delete(Personas personas) throws FacadeExceptions;
        public ArrayList<Personas> selectAll() throws FacadeExceptions;
        public void update(Personas personas) throws FacadeExceptions;

}
