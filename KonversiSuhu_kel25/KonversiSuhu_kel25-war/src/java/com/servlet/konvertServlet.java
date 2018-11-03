/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.session.KonversiSuhu;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fir
 */
public class konvertServlet extends HttpServlet {

    @EJB
    private KonversiSuhu konversiSuhu;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {            
            out.println("<html>");
            out.println("<body");
            out.println("<h1><center>Tugas RSBK Konversi Suhu</center></h1>");
            String suhu = request.getParameter("suhu");
            
            if ((suhu != null) && (suhu.length() > 0)) {
                double d = Double.parseDouble(suhu);
                if (request.getParameter("Celcius Ke Fahrenheit") != null){
                    String cefa = konversiSuhu.celcius_fahrenheit(d);
                    out.println("<p><center> HASIL KONVERSI SUHU Celcius-Fah: "+cefa+"</center></p>");
                }  
                if (request.getParameter("Celcius Ke Reamur") != null) {
                    String cere = konversiSuhu.celcius_reamure(d);
                    out.println("<p><center> HASIL KONVERSI SUHU Cel-Rea: "+cere+ " .</center></p>");
                }
                if (request.getParameter("Reamur Ke Celcius") != null) {
                    String rece = konversiSuhu.reamure_celcius(d);
                    out.println("<p><center> HASIL KONVERSI SUHU Rea-cel: " +rece+ " .</center></p>");
                }
                if (request.getParameter("Reamur Ke Fahrenheit") != null) {
                    String refa = konversiSuhu.reamure_fahrenheit(d);
                    out.println("<p><center> HASIL KONVERSI SUHU Rea-Fah: "+refa+ " .<//center></p>");
                }
                if (request.getParameter("Fahrenheit Ke Celcius") != null) {
                    String face = konversiSuhu.fahrenheit_celcius(d);
                    out.println("<p><center> HASIL KONVERSI SUHU Fah-cel: "+face+ " .</center></p>");
                }                
                if (request.getParameter("Fahrenheit Ke Reamur") != null) {
                    String fare = konversiSuhu.fahrenheit_reamure(d); 
                    out.println("<p><center> HASIL KONVERSI SUHU Fah-re: "+fare+ " .</center></p>");
                }
                 if (request.getParameter("Celcius Ke kelvin") != null) {
                    String fare = konversiSuhu.celcius_kel(d); 
                    out.println("<p><center> HASIL KONVERSI SUHU Fah-re: "+fare+ " .</center></p>");
                }
            } else {
                out.println("<center>");
                out.println("<p>Masukan Suhu:</p>");
                out.println("<form method=\"get\">");
                out.println("<p><input type=\"text\" name=\"suhu\" size=\"20\"></p>");
                out.println("<br/>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"Fahrenheit Ke Celcius\" value=\"Fahrenheit Ke Celcius\">"+ "<input type=\"submit\" name=\"Fahrenheit Ke Reamur\" value=\"Fahrenheit Ke Reamur\">"+"<input type=\"submit\" name=\"Celcius Ke kelvin\" value=\"Celcius Ke kelvin\">");
                out.println("<br/>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"Celcius Ke Fahrenheit\" value=\"Celcius Ke Fahrenheit\">"+ "<input type=\"submit\" name=\"Celcius Ke Reamur\" value=\"Celcius Ke Reamur\">");
                out.println("<br/>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"Reamur Ke Fahrenheit\" value=\"Reamur Ke Fahrenheit\">"+ "<input type=\"submit\" name=\"Reamur Ke Celcius\" value=\"Reamur Ke Celcius\">");
                out.println("</center>");
                out.println("</form>");
            }
        
        } finally {
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }               
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
