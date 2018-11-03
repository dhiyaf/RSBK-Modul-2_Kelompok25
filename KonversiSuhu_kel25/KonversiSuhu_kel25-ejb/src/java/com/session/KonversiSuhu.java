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
    public String celcius_fahrenheit(double parameter) {
        return result=a.format(((parameter*9.0/5.0+32)*100)/100.0);
    }


    public String celcius_reamure(double parameter) {
        return result=a.format(((parameter)*4.0/5.0*100)/100.0);
    }

    public String reamure_celcius(double parameter) {
         return result=a.format(((parameter)*5.0/4.0*100)/100.0);
    }

    public String reamure_fahrenheit(double parameter) {
        return  result=a.format(((parameter+32)*9.0/4.0*100)/100.0);
    }

    public String fahrenheit_celcius(double parameter) {
        return result=a.format(((parameter-32)*5.0/9.0*100)/100.0);
    }

    public String fahrenheit_reamure(double parameter) {
        return result=a.format(((parameter-32)*4.0/9.0*100)/100.0);
    }

    public String celcius_kel(double parameter) {
        return result=a.format((parameter+273));
    }
}
