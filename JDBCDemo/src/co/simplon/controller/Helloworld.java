package co.simplon.controller;

import java.io.IOException;




import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.dao.DAOContext;
import co.simplon.dao.PaysDAO;
import co.simplon.model.*;

/**
 * Servlet implementation class Helloworld
 */
@WebServlet(urlPatterns="/helloworld", loadOnStartup=1)
public class Helloworld extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PaysDAO ajPays;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
    public static final long Serialversionuid= 1L;

    public Helloworld() {
        super();
        // TODO Auto-generated constructor stub
       
        
    }

	
    public void init() throws ServletException {
		// TODO Auto-generated method stub
	
		
		DAOContext daoContext = new DAOContext();
		/*daoContext.init(this.getServletContext());*/
		this.ajPays = daoContext.getPaysDao();
		
	}
		
	




	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		
		if(request.getParameter("action") != null) {
			String actionRec = request.getParameter("action");
			Pays obj_pays = new Pays();
			switch(actionRec) {
			case "update":request.setAttribute("modifPays", request.getParameter("nom"));
			              request.setAttribute("modifId",request.getParameter("id"));
			              break;
			case "delete" :obj_pays.setId(Integer.parseInt(request.getParameter("id")));
			               this.ajPays.supprimer(obj_pays);
			               break;
			}
		}
		
		
		request.setAttribute("pays",this.ajPays.lister());
		RequestDispatcher rs = request.getRequestDispatcher("Country.jsp");
        rs.forward(request, response);
		//this.getServletContext().getRequestDispatcher("/Country.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		Pays pays= new Pays();
		pays.setNom(nom);
		System.out.println(nom);
		if(request.getParameter("id") != null && request.getParameter("id") != "") {
			String id = request.getParameter("id");
			System.out.println(id);
			pays.setId(Integer.parseInt(id));
			this.ajPays.modifier(pays);
			}
		else 
		{	
		this.ajPays.ajouter(pays);
		}
		request.setAttribute("pays",this.ajPays.lister());
		RequestDispatcher rs = request.getRequestDispatcher("Country.jsp");
        rs.forward(request, response);
		//this.getServletContext().getRequestDispatcher("/Country.jsp").forward(request, response);
		/*doGet(request, response);*/
	}

}
