package agenda.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.DAO.ContatoDAO;
import agenda.modelo.Contato;

@WebServlet("/novoContato")
public class NovaAgendaServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Cadastrando novo contato");

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String paramdataNascimento = request.getParameter("data");
		Long id = Long.parseLong(request.getParameter("id"));
		/*
		 * Date dataLancamento = null; SimpleDateFormat sdf = new
		 * SimpleDateFormat("dd/MM/yyyy"); try { dataLancamento =
		 * sdf.parse(paramdataNascimento); } catch (java.text.ParseException e) { throw
		 * new ServletException(e); }
		 */
		 
		ContatoDAO dao = new ContatoDAO();
		Contato contato = new Contato();
		
		contato.setId(id);
		contato.setNome(nome);
	    contato.setEmail(email);
	    contato.setEndereco(endereco);
	    contato.setDataNascimento(paramdataNascimento);
		dao.adiciona(contato);

		request.setAttribute("contato", contato);

		response.sendRedirect("listaContatos");

	}

}
