package agenda.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.DAO.ContatoDAO;
import agenda.modelo.Contato;

@WebServlet("/mostraContato")
public class MostraAgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Passando pela interface para mostrar");

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String paramdataNascimento = request.getParameter("data");
		long id = Long.parseLong(request.getParameter("id"));

		ContatoDAO dao = new ContatoDAO();
		Contato contato = new Contato();

		contato.setId(id);
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(paramdataNascimento);
		
		System.out.println("Saindo da primeira interface para poder alterar!");

		request.setAttribute("contato", contato);

		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraAgenda.jsp");
		rd.forward(request, response);
	}

}
