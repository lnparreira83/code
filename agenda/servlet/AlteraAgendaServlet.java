package agenda.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.DAO.ContatoDAO;
import agenda.modelo.Contato;

@WebServlet("/alteraContato")
public class AlteraAgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Alterando contato");
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String paramdataNascimento = request.getParameter("data");
		Long id = Long.parseLong(request.getParameter("id"));
		
		ContatoDAO dao = new ContatoDAO();
		Contato contato = new Contato();
		
		//contato.setId(parmid);
	
		contato.setId(id);
		contato.setNome(nome);
	    contato.setEmail(email);
	    contato.setEndereco(endereco);
	    contato.setDataNascimento(paramdataNascimento);
		try {
			dao.altera(contato);
			System.out.println("Contato alterado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Deu ruim!");
			e.printStackTrace();
		}

		request.setAttribute("contato", contato);

		response.sendRedirect("listaContatos");

	}

}
