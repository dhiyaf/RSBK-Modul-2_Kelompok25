/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import java.text.DecimalFormat;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author fir
 */
@Stateless
@LocalBean
public class KonversiSuhu {

        DecimalFormat a= new DecimalFormat("0.0");
        String result;
      public String persegi(double parameter) {
        return result=a.format((parameter*4.0));
    }


    public String segitiga(double parameter) {
        return result=a.format(((parameter)*3.0));
    }

    public String lingkaran(double parameter) {
         return result=a.format(((parameter)*3.14));
    }}
