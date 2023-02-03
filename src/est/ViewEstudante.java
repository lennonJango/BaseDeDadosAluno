package est;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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
	private JTable table;
	JButton btnInserir, btnList,btnUpdate,btnRemove;
	private JTextField textNivelAcademico;
	private JLabel lblNewLabel_3;

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
		panel.setBounds(36, 23, 322, 320);
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
		btnRemove.addActionListener(this);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(721, 530, -328, -498);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nivel Academico", "Codigo", "Nome", " Endere\u00E7o"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(399, 37, 322, 228);
		contentPane.add(table);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		 if(e.getSource()==btnInserir) {
			 String nome = textNome.getText();
			 int codigo = Integer.parseInt(textCodigo.getText());
			 String endereco = textEndereco.getText();
			  int anoLectivo = Integer.parseInt(textNivelAcademico.getText());
			 
			 Controle cc = new Controle();
			 cc.adicionarEstudante(codigo, nome, endereco,anoLectivo);
			 
		 }
		
	}
}
