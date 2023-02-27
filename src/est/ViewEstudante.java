package est;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ViewEstudante extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField textEndereco;
	JButton btnInserir, btnList, btnUpdate, btnRemove;
	private JTextField textNivelAcademico;
	private JLabel lblNewLabel_3;
	private JTable tableRegistos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEstudante frame = new ViewEstudante();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewEstudante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 23, 322, 320);
		contentPane.add(panel);
		panel.setLayout(null);

		textCodigo = new JTextField();
		textCodigo.setBounds(10, 53, 111, 23);
		panel.add(textCodigo);
		textCodigo.setColumns(10);

		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(10, 135, 275, 32);
		panel.add(textNome);

		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(10, 217, 275, 38);
		panel.add(textEndereco);

		JLabel lblNewLabel = new JLabel("Codigo do estudante");
		lblNewLabel.setBounds(10, 28, 153, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome do estudante");
		lblNewLabel_1.setBounds(10, 110, 129, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Endereço do estudante");
		lblNewLabel_2.setBounds(10, 186, 129, 20);
		panel.add(lblNewLabel_2);

		textNivelAcademico = new JTextField();
		textNivelAcademico.setBounds(177, 53, 96, 23);
		panel.add(textNivelAcademico);
		textNivelAcademico.setColumns(10);

		lblNewLabel_3 = new JLabel("Nivel Academico");
		lblNewLabel_3.setBounds(188, 28, 97, 14);
		panel.add(lblNewLabel_3);

		btnInserir = new JButton("Insert");
		btnInserir.setVerticalAlignment(SwingConstants.BOTTOM);
		btnInserir.setBounds(42, 403, 89, 23);
		btnInserir.addActionListener(this);
		contentPane.add(btnInserir);

		btnList = new JButton("List");
		btnList.setBounds(197, 403, 89, 23);
		contentPane.add(btnList);
		btnList.addActionListener(this);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(42, 481, 89, 23);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(this);

		btnRemove = new JButton("Remove");
		btnRemove.setBounds(197, 481, 89, 23);
		contentPane.add(btnRemove);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(342, 23, 379, 492);
		contentPane.add(scrollPane);

		tableRegistos = new JTable();
		tableRegistos.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Nome ", "Nivel Academico", "Codigo", "Endere\u00E7o  " }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] { String.class, Integer.class, Integer.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tableRegistos);
		btnRemove.addActionListener(this);
	}

	public void LimparInputs() {
		// Metodo que limpa os inputs
		textNome.setText("");
		textCodigo.setText("");
		;
		textEndereco.setText("");
		;
		textNivelAcademico.setText("");

	}

	public void limparTabela() {
		while (tableRegistos.getRowCount() > 0) {
			((DefaultTableModel) tableRegistos.getModel()).removeRow(0);
		}
	}

	public void adicionarNaTabela() throws SQLException {
		LimparInputs();
		Controle cc = new Controle();

		DefaultTableModel adicionar = (DefaultTableModel) tableRegistos.getModel();
		ArrayList<Estudante> estudantes = cc.listar();

		for (Estudante estudante : estudantes) {
			adicionar.addRow(new Object[] { estudante.getCodigo(), estudante.getNome(), estudante.getEndereco(),
					estudante.getAnoLectivo() });

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnInserir) {
			Controle cc = new Controle();
			String nome = textNome.getText();
			int codigo = Integer.parseInt(textCodigo.getText());
			String endereco = textEndereco.getText();
			int anoLectivo = Integer.parseInt(textNivelAcademico.getText());

			try {
				cc.adicionarEstudante(codigo, nome, endereco, anoLectivo);
				LimparInputs();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("Erro ao adicionar");
			}

		}

		if (e.getSource() == btnList) {
			try {
				LimparInputs();
				adicionarNaTabela();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("erro ao listar");
			}

		}

		if (e.getSource() == btnUpdate) {
			String nome = textNome.getText();
			int codigo = Integer.parseInt(textCodigo.getText());
			String endereco = textEndereco.getText();
			int anoLectivo = Integer.parseInt(textNivelAcademico.getText());
			Controle cc = new Controle();

			try {
				cc.Actualizar(codigo, nome, endereco, anoLectivo);
				JOptionPane.showMessageDialog(null, "Dados Atualizados com sucesso");
				LimparInputs();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("Erro ao atualizar");
			}
		}

		if (e.getSource() == btnRemove) {

			int codigo = Integer.parseInt(textCodigo.getText());
			Controle cc = new Controle();
			try {
 
				cc.remover(codigo);
				JOptionPane.showMessageDialog(null, "Removido com sucesso");
				limparTabela();
				LimparInputs();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("Erro ao remover");
			}
		}

	}
}
