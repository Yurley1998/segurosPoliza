package com.spring.seguros.bd;

import java.util.ArrayList;

public class MgConexion {
    private static MgConexion mgConexion;
    private ArrayList<Conexion> lista;
    private MgConexion(){
        lista = new ArrayList<>();
    }
    public static MgConexion getInstance(){
        if(mgConexion == null){
            mgConexion = new MgConexion();
        }
        return mgConexion;
    }
    public void open(){
        for (int i=0; i<10;i++){
            Conexion con = new Conexion();
            con.open();
            lista.add(con);
            System.out.println(con);
        }
    }
    public void close(Conexion con){
        con.setFree(true);
    }
    public Conexion getConexion(){
        Conexion con = null;
        for (int i=0; i<10; i++){
            con = lista.get(i);
            if (con.getFree()){
                con.setFree(false);
                break;
            }
        }
        return con;
    }
}
