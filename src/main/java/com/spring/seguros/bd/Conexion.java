package com.spring.seguros.bd;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public Connection getConnection(){
        return connection;

    }
    private Connection connection;
    private Boolean free = true;

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }
    public void open(){
        try {
            Class.forName("org.postgresql.Driver");
            connection =DriverManager.getConnection("jdbc:postgresql://localhost:5432/seguros",
                    "postgres", "Yurley");
            connection.setAutoCommit(false);//Defino que soy quien controlo la transacción

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
