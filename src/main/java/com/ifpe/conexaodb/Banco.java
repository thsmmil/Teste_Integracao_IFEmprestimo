/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpe.conexaodb;

import com.ifpe.utils.Constantes;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
/**
 *
 * @author Humberto
 */
public class Banco {
    
protected Connection con;
protected PreparedStatement ps;

    public void abrirConexao() throws Exception {
//    Class.forName(Constantes.DRIVER);
        con = (Connection) DriverManager.getConnection(Constantes.URL, Constantes.USER, Constantes.PASSWORD);
        

//        String username = dbUri.getUserInfo().split(":")[0];
//        String password = dbUri.getUserInfo().split(":")[1];
//        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
//        con = (Connection) DriverManager.getConnection(dbUrl, username, password);
        
    }

    public void fecharConexao() throws Exception{
        con.close();
    }
    
//    public static Connection getConnection() throws URISyntaxException, SQLException {
//        URI dbUri = new URI("mysql://b81bf686ecda13:80d182cf@us-cdbr-iron-east-02.cleardb.net/heroku_d34e19da561cb34?reconnect=true");
//
//        String username = dbUri.getUserInfo().split(":")[0];
//        String password = dbUri.getUserInfo().split(":")[1];
//        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
//        con = (Connection) DriverManager.getConnection(dbUrl, username, password);
//        return con;
//}

    
    
}
