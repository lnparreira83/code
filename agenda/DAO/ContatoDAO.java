package agenda.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import agenda.modelo.Contato;

public class ContatoDAO {

	  private Connection connection;
	  
	// a conexão com o banco de dados
	public ContatoDAO() {
        this.connection = new ConnectionFactory().getConnection();
        
    }


	public void adiciona(Contato contato) {
		String sql = "insert into contatos " + "(id,nome,email,endereco,dataNascimento)" + " values (?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores

			stmt.setLong(1, contato.getId());
			stmt.setString(2, contato.getNome());
			stmt.setString(3, contato.getEmail());
			stmt.setString(4, contato.getEndereco());
			stmt.setString(5, contato.getDataNascimento());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getLista() {
        try {
            List<Contato> contatos = new ArrayList<Contato>();
            PreparedStatement stmt = this.connection.
                    prepareStatement("select * from contatos");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Contato contato = new Contato();
                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setDataNascimento(rs.getString("dataNascimento"));

				/*
				 * // montando a data através do Calendar Calendar data =
				 * Calendar.getInstance(); data.setTime(rs.getDate("dataNascimento"));
				 * contato.setDataNascimento(data);
				 */

                // adicionando o objeto à lista
                contatos.add(contato);
            }
            rs.close();
            stmt.close();
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

	public void altera(Contato contato) throws SQLException {
	    String sql = "update contatos set id=?, nome=?, email=?, endereco=?,dataNascimento=? where id=?";
	    PreparedStatement stmt = this.connection.
                prepareStatement(sql);
	    try {
	    	
	        stmt.setLong(1, contato.getId());
	        stmt.setString(2, contato.getEmail());
	        stmt.setString(3, contato.getEndereco());
	        stmt.setString(4, contato.getDataNascimento());
	        stmt.setString(5,  contato.getNome());
	        stmt.setLong(6, contato.getId());

	        stmt.executeUpdate();
	        System.out.println("Alterado com sucesso");
	        stmt.close();
	    } catch (SQLException e) {
	    	System.out.println("Erro ao alterar");
	        throw new RuntimeException(e);
	    }
	}

	public void remove(Contato contato) {
	    try {
	        PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?");
	        stmt.setLong(1, contato.getId());
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public Contato buscaContatoPeloId(Long id) {
		List<Contato> contatos = new ArrayList<Contato>();
		for (Contato contato : contatos) {
			if (contato.getId() == id) {
				return contato;
			}
		}
		return null;
	}


}