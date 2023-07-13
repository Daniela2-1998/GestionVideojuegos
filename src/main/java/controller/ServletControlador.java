package controller;

import data.JuegosDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Juegos;

/**
 *
 * @author Daniela
 */
@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet {
    
    // DOGET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String accion = req.getParameter("accion");
        if(accion != null){
            switch (accion){
                case "editar":
                    editarJuego(req, res);
                    break;
                default:
                    accionDefault(req, res);
                    break;
            }
        } else {
            accionDefault(req, res);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String accion = req.getParameter("accion");
        if(accion != null){
            switch (accion){
                case "insertar":
                    insertarJuego(req, res);
                break;
                case "modificar":
                    modificarJuego(req, res);
                 break;
                default:
                    accionDefault(req, res);
                    break;
            }
        } else {
            accionDefault(req, res);
        }
    }
    
    // ACCIÓN DEFAULT
    private void accionDefault(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        try {
            List<Juegos> juegos = new JuegosDAO().seleccionar();
            juegos.forEach(System.out::println);
            
            HttpSession sesion = req.getSession();
            
            sesion.setAttribute("juegos", juegos);
            sesion.setAttribute("cantidadJuegos", juegos.size());
            sesion.setAttribute("precioTotal", calcularPrecio(juegos));
            res.sendRedirect("juegos.jsp");
               
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } 
    }
    
    // INSERTAR JUEGO
    private void insertarJuego(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String nombre = req.getParameter("nombre");
        String genero = req.getParameter("genero");
        String plataforma = req.getParameter("plataforma");
        int unidades = Integer.parseInt(req.getParameter("unidades"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        
        Juegos juegoNuevo = new Juegos(nombre, genero, plataforma, unidades, precio);
        
        int registrosMod = new JuegosDAO().insertar(juegoNuevo);
        
        System.out.println("Agregado a stock: " + registrosMod);
        accionDefault(req, res);
    }
    
    // EDITAR JUEGO
    private void editarJuego(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int idjuego = Integer.parseInt(req.getParameter("idjuego"));
       
       Juegos juegos= new JuegosDAO().seleccionarPorID(idjuego);
       req.setAttribute("juegos", juegos);
       req.getRequestDispatcher("/WEB-INF/funciones/editarJuego.jsp").forward(req, res);
    }
    
    // MODIFICAR JUEGO
    private void modificarJuego(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        accionDefault(req, res);
    }
    
    
    private double calcularPrecio(List<Juegos> juegos){
        double precioTotal = 0;
        
        for(Juegos juego: juegos){
            precioTotal += juego.getPrecio();
        }
        return precioTotal;
    }
    
    
    
    
    
    
}
