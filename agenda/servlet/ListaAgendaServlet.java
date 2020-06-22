package agenda.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.DAO.ContatoDAO;
import agenda.modelo.Contato;

@WebServlet("/listaContatos")
public class ListaAgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ContatoDAO dao = new ContatoDAO();
		
		List <Contato> contatos = dao.getLista();
		for (Contato contato : contatos) {
			System.out.println("Id: " + contato.getId());
	        System.out.println("Nome: " + contato.getNome());
	        System.out.println("Email: " + contato.getEmail());
	        System.out.println("Endereço: " + contato.getEndereco());
	        System.out.println("Data de Nascimento: " + 
	                contato.getDataNascimento());
	    }
		
		
		request.setAttribute("contatos", contatos);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaContatos.jsp");
		rd.forward(request, response);
		
	}
}
