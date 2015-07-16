package servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.util.Enumeration;
import store.Cart;

/**
 *
 * CartServlet. java
 * @author Fan Chen
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doPost(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * when click the "add" or "remove" button to update the cart
     * 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Enumeration headers = request.getHeaderNames();
        while(headers.hasMoreElements()){
            String header =(String)headers.nextElement();
            System.out.println(header+": "+request.getHeader(header));
        }
        
        Cart cart = getCartFromSession(request);
        
        String action = request.getParameter("action");
        String item = request.getParameter("item");
        
        //determine wheter add or remove
        if((action!=null)&&(item!=null)){
            if("add".equals(action)){
                cart.addItem(item);
            }else if ("remove".equals(action)){
                cart.removeItems(item);
            }
        }
        String cartJson = cart.toJson();
        System.out.println("==========="+cartJson+"=====================");
        response.setContentType("application/json;charset=utf-8");  
        response.getWriter().write(cartJson);
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
    
    /**
     * 
     * @param request the servlet request
     * @return the cart in current session
     */
    private Cart getCartFromSession(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        Cart cart = (Cart)session.getAttribute("cart");
        
        if(cart == null){
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        
        return cart;
    }
}
