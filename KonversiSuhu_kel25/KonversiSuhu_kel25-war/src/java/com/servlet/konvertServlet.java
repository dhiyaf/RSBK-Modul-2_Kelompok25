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
            out.println("<h1><center>Tugas RSBK Keliling Bangun Datar</center></h1>");
            String sisi = request.getParameter("sisi");
            
            if ((sisi != null) && (sisi.length() > 0)) {
                double d = Double.parseDouble(sisi);
                if (request.getParameter("Persegi") != null){
                    String pers = konversiSuhu.persegi(d);
                    out.println("<p><center> HASIL KELILING PERSEGI: "+pers+"</center></p>");
                }  
                if (request.getParameter("Segitiga Sama Sisi") != null) {
                    String segi = konversiSuhu.segitiga(d);
                    out.println("<p><center> HASIL KELILING SEGITIGA SAMA SISI: "+segi+ " .</center></p>");
                }
                if (request.getParameter("Lingkaran") != null) {
                    String ling = konversiSuhu.lingkaran(d);
                    out.println("<p><center> HASIL KELILING LINGKARAN: " +ling+ " .</center></p>");
                }
                
            } else {
                out.println("<center>");
                out.println("<p>Masukan Sisi / Diameter:</p>");
                out.println("<form method=\"get\">");
                out.println("<p><input type=\"text\" name=\"sisi\" size=\"20\"></p>");
                out.println("<br/>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"Persegi\" value=\"Persegi\">"+ "<input type=\"submit\" name=\"Segitiga Sama Sisi\" value=\"Segitiga Sama Sisi\">"+"<input type=\"submit\" name=\"Lingkaran\" value=\"Lingkaran\">");
                out.println("<br/>");
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
