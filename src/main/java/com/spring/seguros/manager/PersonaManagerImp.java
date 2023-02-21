package com.spring.seguros.manager;

import com.spring.seguros.dao.PersonaDao;
import com.spring.seguros.dao.PersonaDaoImp;
import com.spring.seguros.bd.Conexion;
import com.spring.seguros.dto.Personas;
import com.spring.seguros.exceptions.DaoExceptions;
import com.spring.seguros.exceptions.ManagerExceptions;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

public class PersonaManagerImp implements PersonaManager{
    private PersonaDao personaDao;
    private static PersonaManagerImp personaManager;

    private PersonaManagerImp(){
        this.personaDao = PersonaDaoImp.getInstance();
    };

    public static PersonaManager getInstance()
    {
        if (personaManager == null)
        {
            personaManager = new PersonaManagerImp();
        }
        return personaManager;
    }

    @Override
    public void save(Personas personas, Conexion connect) throws ManagerExceptions {
        try {
            Personas temp = this.personaDao.getById(personas, connect);
            if(temp==null){
                this.personaDao.insert(personas,connect);
            }else{
                this.personaDao.update(personas,connect);
            }
        } catch (DaoExceptions dex) {
            throw new ManagerExceptions(dex);
        } catch (Exception ex) {
            throw new ManagerExceptions(ex);
        }

    }

    @Override
    public void delete(Personas personas, Conexion connect) throws ManagerExceptions {
        try {
            Personas temp = this.personaDao.getById(personas,connect);
            if(temp!=null) {
                this.personaDao.delete(personas, connect);
            }
        } catch (DaoExceptions dex) {
            throw new ManagerExceptions(dex);
        } catch (Exception ex) {
            throw new ManagerExceptions(ex);
        }

    }

    @Override
    public ArrayList<Personas> selectAll(Conexion connect) throws ManagerExceptions {
        try {
            return this.personaDao.getAll(connect);
        } catch (DaoExceptions dex) {
            throw new ManagerExceptions(dex);
        } catch (Exception ex) {
            throw new ManagerExceptions(ex);
        }

    }

    @Override
    public void update(Personas personas, Conexion connect) throws ManagerExceptions {
        try {
            Personas temp = this.personaDao.getById(personas,connect);
            if(temp!=null){
                this.personaDao.update(personas,connect);

            }
        } catch (DaoExceptions dex) {
            throw new ManagerExceptions(dex);
        } catch (Exception ex) {
            throw new ManagerExceptions(ex);
        }
    }

    }

