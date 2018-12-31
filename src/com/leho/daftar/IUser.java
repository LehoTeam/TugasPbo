/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leho.daftar;

import java.sql.ResultSet;

/**
 *
 * @author hp
 */
public interface IUser {
    public void userDaftar(String nama, String username, String password, String alamat, String email);
    public ResultSet cekLogin(String username, String password);

}
