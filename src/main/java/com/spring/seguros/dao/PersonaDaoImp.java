package com.spring.seguros.dao;
import com.spring.seguros.bd.Conexion;
import com.spring.seguros.date.UtilDate;
import com.spring.seguros.bd.Conexion;
import com.spring.seguros.dto.Personas;
import com.spring.seguros.exceptions.DaoExceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonaDaoImp implements PersonaDao{
    private static PersonaDaoImp personaDao;
    private PersonaDaoImp(){

    }
    public static PersonaDaoImp getInstance(){
        if(personaDao == null){
            personaDao = new PersonaDaoImp();
        }
        return personaDao;
    }

    public void insert(Personas personas, Conexion connect) throws DaoExceptions {
        String INSERT ="INSERT INTO personas (nombre1, nombre2, apellido1, apellido2, tipo_documento, num_documento,\n" +
                "                      fecha_nacimiento, profesion, correo, telefono, sexo, salario, estado_civil)\n" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        try{
            statement = connect.getConnection().prepareStatement(INSERT);
            statement.setString(1, personas.getNombre1());
            statement.setString(2,personas.getNombre2());
            statement.setString(3,personas.getApellido1());
            statement.setString(4, personas.getApellido2());
            statement.setString(5, personas.getTipoDocumento());
            statement.setInt(6, personas.getNumDocumento());
            statement.setDate(7,UtilDate.toSqlDate(personas.getFechaNacimiento()));
            statement.setString(8, personas.getProfesion());
            statement.setString(9, personas.getEmail());
            statement.setString(10,personas.getNumTelefono());
            statement.setString(11, personas.getSexo());
            statement.setDouble(12,personas.getSalario());
            statement.setString(13, personas.getEstadoCivil());
            statement.executeUpdate();
        }catch(SQLException se){
            throw new DaoExceptions(se);
        }catch(Exception ex){
            throw new DaoExceptions(ex);
        }finally{
            if(statement !=null){
                try{
                    statement.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Insertado");

    }

    @Override
    public void delete(Personas personas, Conexion connect) throws DaoExceptions {
        String SQL ="DELETE FROM personas WHERE id_persona=?";
        PreparedStatement statement = null;
        try{
            statement= connect.getConnection().prepareStatement(SQL);
            statement.setInt(1,personas.getIdPersona());
            statement.executeUpdate();
        }catch (SQLException se){
            throw new DaoExceptions(se);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }finally{
            if (statement!=null){
                try{
                    statement.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Borrado");
    }

    @Override
    public Personas getById(Personas personas, Conexion connect) throws DaoExceptions {
        String SQL= "SELECT id_persona, nombre1, nombre2, apellido1, apellido2, tipo_documento, num_documento,\n" +
                "                      fecha_nacimiento, profesion, correo, telefono, sexo, salario, estado_civil)\n" +
                "FROM personas WHERE id_persona=?";
        PreparedStatement statement = null;
        ResultSet rs= null;
        Personas result = null;
        try{
            statement = connect.getConnection().prepareStatement(SQL);
            statement.setInt(1,personas.getIdPersona());
            rs= statement.executeQuery();
            if (rs!=null){
                while (rs.next()){
                    result = new Personas();
                    result.setNombre1(rs.getString("nombre1"));
                    result.setNombre2(rs.getString("nombre2"));
                }
            }
            return result;
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }finally {
            try{
                if (rs!=null){
                    rs.close();
                    statement.close();
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }


    }

    @Override
    public ArrayList<Personas> getAll(Conexion connect) throws DaoExceptions {
        String SQL ="SELECT id_persona, nombre1, nombre2, apellido1, apellido2, tipo_documento, num_documento,\n\" +\n" +
                "                   fecha_nacimiento, profesion, correo, telefono, sexo, salario, estado_civil)\n\" +\n" +
                "                FROM personas";
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList<Personas> listaPersonas = new ArrayList<>();
        try{
            statement = connect.getConnection().prepareStatement(SQL);
            rs = statement.executeQuery();
            if (rs!=null){
                while (rs.next()){
                    Personas result = new Personas();
                    result.setNombre1(rs.getString("nombre1"));
                    result.setNombre2(rs.getString("nombre2"));
                    result.setApellido1(rs.getString("apellido1"));
                    result.setApellido2(rs.getString("apellido2"));
                    result.setTipoDocumento(rs.getString("tipo_documento"));
                    result.setNumDocumento(rs.getInt("num_documento"));
                    result.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                    result.setProfesion(rs.getString("profesion"));
                    result.setEmail(rs.getString("correo"));
                    result.setNumTelefono(rs.getString("telefono"));
                    result.setSexo(rs.getString("sexo"));
                    result.setSalario(rs.getDouble("salario"));
                    result.setEstadoCivil(rs.getString("estado_civil"));
                    listaPersonas.add(result);
                }
            }
            return listaPersonas;
        }catch(Exception e){
            throw new DaoExceptions(e);
        }finally {
            try{
                rs.close();
                statement.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(Personas personas, Conexion connect) throws DaoExceptions {
        String UPDATE = "UPDATE personas\n" +
                "set nombre1=?," +
                "nombre1, nombre2, apellido1, apellido2, tipo_documento, num_documento," +
                "fecha_nacimiento, profesion, correo, telefono, sexo, salario, estado_civil"+
                "where id_persona=?";
        PreparedStatement statement = null;
        try{
            statement = connect.getConnection().prepareStatement(UPDATE);
            statement.setString(1, personas.getNombre1());
            statement.setString(2, personas.getNombre2());
            statement.setString(3, personas.getApellido1());
            statement.setString(4, personas.getApellido2());
            statement.setString(5, personas.getTipoDocumento());
            statement.setInt(6, personas.getNumDocumento());
            statement.setDate(7, UtilDate.toSqlDate(personas.getFechaNacimiento()));
            statement.setString(8, personas.getProfesion());
            statement.setString(9, personas.getEmail());
            statement.setString(10, personas.getNumTelefono());
            statement.setString(11, personas.getSexo());
            statement.setDouble(12,personas.getSalario());
            statement.setString(13,personas.getEstadoCivil());
            statement.setInt(14, personas.getIdPersona());
            statement.executeUpdate();
        }catch (SQLException se){
            throw new DaoExceptions(se);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }finally {
            if (statement!=null){
                try{
                    statement.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

    }


}
