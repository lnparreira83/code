package agenda.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.DAO.ContatoDAO;
import agenda.modelo.Contato;

@WebServlet("/removeContato")
public class RemoveAgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	    //Long id = Long.parseLong(request.getParameter("id"));
	    //String nomeTemp = request.getParameter("nome");
		//System.out.println(nomeTemp);
		
		Contato contato = new Contato();
		
		//contato.setNome(nomeTemp);
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		contato.setId(id);
		contato.getId();
		
		System.out.println(">>>>>>> " + contato.getId());
		
		ContatoDAO dao = new ContatoDAO();
		dao.remove(contato);
		
		System.out.println("Excluindo contato...");

		response.sendRedirect("listaContatos");

	}

}
