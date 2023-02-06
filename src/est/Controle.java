package est;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Controle {

	public void adicionarEstudante(int codigo, String nome, String endereco, int anoLectivo) throws SQLException {

		Conne con = new Conne();
		Connection conectar = (Connection) con.connectar();
		PreparedStatement query = null;
		conectar.prepareStatement("Insert into alunos (codigo,nome,endereco,nivelAcademico) values (?,?,?,?);");
		// query.setInt(0, 12);
		if (query == null) {

			
			query.setInt(1, codigo);
			query.setString(2, nome);
			query.setString(3, endereco);
			query.setInt(4, anoLectivo);
			query.executeUpdate();
			conectar.close();
		}

	}

	public ArrayList<Estudante> listar() {

		ArrayList<Estudante> listaDeEstudante = new ArrayList<>();

		Conne con = new Conne();
		Connection conectar = (Connection) con.connectar();
		PreparedStatement query = null;

		try {
			ResultSet result = (ResultSet) query.executeQuery();
			conectar.prepareStatement("select * from aluno;");
			while (result.next()) {
				int codigo = result.getInt(1);
				String nome = result.getString(2);
				String endereco = result.getString(3);
				int anoLectivo = result.getInt(4);

				Estudante aluno = new Estudante(codigo, nome, endereco, anoLectivo);
				listaDeEstudante.add(aluno);
			}

			JOptionPane.showMessageDialog(null, "Listagem efectudada com sucesso");
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Falha ao fazer a listagem");

		}

		return listaDeEstudante;

	}

	public void Actualizar(int codigo, String nome, String endereco, int anoLectivo) {

		Conne connect = new Conne();
		Connection con = (Connection) connect.connectar();
		PreparedStatement query = null;
		try {
			con.prepareStatement("update table aluno set nome =? ,endereco=?, nivelAcademico=? where codigo =?;");
			query.setInt(1, codigo);
			query.executeUpdate();

			JOptionPane.showMessageDialog(null, "Atualizão concluida com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao atualizar a tabela");
		}

	}

	public void remover(int codigo) {

		Conne con = new Conne();
		Connection conectar = (Connection) con.connectar();
		PreparedStatement query = null;

		try {
			conectar.prepareStatement("delete from aluno where codigo = ?;");
			query.setInt(1, codigo);
			query.executeUpdate();
			JOptionPane.showMessageDialog(null, "Aluno removido");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao remover");

		}

	}
}
