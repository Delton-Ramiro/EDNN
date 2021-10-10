package tela;

import modelos.CelaObj;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class Cela implements ActionListener, MouseListener {

	private JFrame frame;
	private JTextField t_nr_cela;
	private JTextField t_localizacao;
	private JTextField t_nr_reclusos;
	private JTextField t_capacidade;
	private JTable table;
	private JTextField t_adicionar;
	private JTextField t_remover;
	private JTextField t_actualizar;
	private JComboBox tipos;
	JButton btn_adicionar, btn_remover, btn_actualizar;
	private static String[] tipo_cela_opcoes;
	private static DefaultTableModel model;
	private JScrollPane scrollPane;
	private int iteracao_nr_cela = 0;

	ArrayList<CelaObj> celas;

	public static final String CADEIA = "cadeia";
	public static final String CELA = "cela";
	public static final String CELA_ID = "id";
	public static final String CELA_LOCALIZACAO = "localizacao";
	public static final String CELA_NR_RECLUSOS = "nr_reclusos";
	public static final String CELA_CAPACIDADE = "capacidade";
	public static final String CELA_TIPO = "tipo";

	public static final String ASPA_ESCAPADA = "\"";



	public static final String INSERIR_CELA_TEXTO_INICIAL = "INSERT INTO " + CADEIA + '.' + CELA + "(" +
			CELA_ID + ", " + CELA_LOCALIZACAO + ", " + CELA_NR_RECLUSOS + ", " + CELA_CAPACIDADE + ", " + CELA_TIPO + ")" +
			"VALUES(" ;
	public static final String REMOVER_CELA_TEXTO_INICIAL = "DELETE FROM " + CELA + " WHERE " + CELA_ID + " = ";

	public static final String ACTUALIZAR_CELA_TEXTO_INICIAL = "UPDATE " + CADEIA + '.' + CELA +
			" SET " + CELA_LOCALIZACAO + " = ";



	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		//tabelar();


	}*/

	public int estaNaBaseDeDados(int id){
		for (CelaObj cela : celas){
			if (cela.getId() == id){
				return cela.getId();
			}
		}
		return -1;
	}

	public CelaObj pegarCela(int id){
		for (CelaObj cela : celas){
			if (cela.getId() == id){
				return cela;
			}
		}
		return null;
	}

	private void actualizar(String id, String localizacao, String tipo, int capacidade) {
		StringBuilder sb = new StringBuilder(ACTUALIZAR_CELA_TEXTO_INICIAL);
		sb.append(ASPA_ESCAPADA + localizacao + ASPA_ESCAPADA +", ");
		sb.append(CELA_CAPACIDADE + " = ");
		sb.append(ASPA_ESCAPADA + capacidade + ASPA_ESCAPADA + ", ");
		sb.append(CELA_TIPO + " = ");
		sb.append(ASPA_ESCAPADA + tipo + ASPA_ESCAPADA);
		sb.append(" WHERE ");
		sb.append(CELA_ID +  " = ");
		sb.append(id + ";");

		System.out.println(sb);

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadeia", "root", "07022000MS");
		Statement statement = connection.createStatement()){
			statement.execute(sb.toString());
			tabelar();
		}catch (Exception e){
			System.out.println("Falha ao actualizar " + e.getMessage());
			e.printStackTrace();
		}

	}

	public boolean inserir(String id, String localizacao, String nr_reclusos, String capacidade, String tipo){
		StringBuilder sb = new StringBuilder(INSERIR_CELA_TEXTO_INICIAL);
		sb.append(ASPA_ESCAPADA + id + ASPA_ESCAPADA + ", ");
		sb.append(ASPA_ESCAPADA + localizacao + ASPA_ESCAPADA + ", ");
		sb.append(ASPA_ESCAPADA + nr_reclusos + ASPA_ESCAPADA + ", ");
		sb.append(ASPA_ESCAPADA + capacidade + ASPA_ESCAPADA + ", ");
		sb.append(ASPA_ESCAPADA + tipo + ASPA_ESCAPADA);
		sb.append(");");
		System.out.println(sb);

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadeia", "root", "07022000MS");
			 Statement statement = connection.createStatement();) {
				return statement.execute(sb.toString());
			 }catch (SQLException e){
			System.out.println("Failed to query " + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	public boolean remover(String id){
		StringBuilder sb = new StringBuilder(REMOVER_CELA_TEXTO_INICIAL);
		sb.append(ASPA_ESCAPADA + id + ASPA_ESCAPADA + ";");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadeia", "root", "07022000MS");
			 Statement statement = connection.createStatement();) {
			 return statement.execute(sb.toString());
		}catch (SQLException e){
			System.out.println("Failed to query " + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	public void tabelar(){
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadeia", "root", "07022000MS");
			 Statement statement = connection.createStatement();
			 ResultSet resultSet = statement.executeQuery("SELECT * FROM " + CELA)){

			celas = new ArrayList<>();

			while (resultSet.next()){
				CelaObj cela = new CelaObj();
				cela.setId(resultSet.getInt(CELA_ID));
				cela.setLocalicazao(resultSet.getString(CELA_LOCALIZACAO));
				cela.setNr_de_reclusos(resultSet.getInt(CELA_NR_RECLUSOS));
				cela.setCapacidade(resultSet.getInt(CELA_CAPACIDADE));
				cela.setTipo(resultSet.getString(CELA_TIPO));
				iteracao_nr_cela = cela.getId()>= iteracao_nr_cela ? cela.getId() + 1: iteracao_nr_cela;
				celas.add(cela);
				/*System.out.println("id - " + resultSet.getString(CADEIA_ID) +
						" || localizacao - " + resultSet.getString(CADEIA_LOCALIZACAO) +
						" || nr_reclusos - " + resultSet.getInt(CADEIA_NR_RECLUSOS) +
						" || capacidade - " + resultSet.getInt(CADEIA_CAPACIDADE) +
						" || tipo - " + resultSet.getString(CADEIA_TIPO));*/
			}

			for (int i= model.getRowCount(); 0<i; i--){
				model.removeRow(i-1);
			}
			for (CelaObj cela : celas){
				model.addRow(new Object[]{cela.getId(), cela.getLocalicazao(), cela.getNr_de_reclusos(),
				cela.getCapacidade(), cela.getTipo()});
			}
			t_nr_cela.setText(String.valueOf(iteracao_nr_cela));
			//SwingUtilities.updateComponentTreeUI(this.frame);

		}catch (SQLException e){
			System.out.println("Falha ao procurar dados " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public Cela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 734, 327);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel nr_cela = new JLabel("Nr da cela");
		nr_cela.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nr_cela.setBounds(10, 0, 95, 31);
		frame.getContentPane().add(nr_cela);
		
		t_nr_cela = new JTextField();
		t_nr_cela.setBounds(10, 41, 95, 19);
		t_nr_cela.setEnabled(false);
		frame.getContentPane().add(t_nr_cela);
		t_nr_cela.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Localizacao");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 70, 95, 31);
		frame.getContentPane().add(lblNewLabel);
		
		t_localizacao = new JTextField();
		t_localizacao.setBounds(10, 111, 96, 19);
		frame.getContentPane().add(t_localizacao);
		t_localizacao.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Tipo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(145, 70, 95, 31);
		frame.getContentPane().add(lblNewLabel_3);

		tipos = new JComboBox();
		tipo_cela_opcoes = new String[]{"Comum","Privada"};
		tipos.setModel(new DefaultComboBoxModel(tipo_cela_opcoes));
		tipos.setToolTipText("Escolha um tipo");
		tipos.setBounds(145, 111, 96, 19);
		frame.getContentPane().add(tipos);

		JLabel lblNewLabel_1 = new JLabel("Nr de reclusos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(295, 18, 96, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		t_nr_reclusos = new JTextField();
		t_nr_reclusos.setText("");
		t_nr_reclusos.setEnabled(false);
		t_nr_reclusos.setBounds(295, 41, 96, 19);
		frame.getContentPane().add(t_nr_reclusos);
		t_nr_reclusos.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Capacidade da cela");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(295, 79, 113, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		t_capacidade = new JTextField();
		t_capacidade.setBounds(295, 113, 96, 19);
		frame.getContentPane().add(t_capacidade);
		t_capacidade.setColumns(10);


		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 170, 700, 110);
		frame.getContentPane().add(scrollPane);

		model = new DefaultTableModel();
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setModel(model);
		model.addColumn("id");
		model.addColumn("localizacao");
		model.addColumn("nr_reclusos");
		model.addColumn("capacidade");
		model.addColumn("tipo");

		
		t_adicionar = new JTextField();
		t_adicionar.setBounds(473, 41, 96, 19);
		frame.getContentPane().add(t_adicionar);
		t_adicionar.setColumns(10);
		
		btn_adicionar = new JButton("Adicionar");
		btn_adicionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_adicionar.setBounds(604, 40, 85, 21);
		frame.getContentPane().add(btn_adicionar);
		
		t_remover = new JTextField();
		t_remover.setBounds(473, 76, 96, 19);
		frame.getContentPane().add(t_remover);
		t_remover.setColumns(10);
		
		btn_remover = new JButton("Remover");
		btn_remover.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_remover.setBounds(604, 75, 85, 21);
		frame.getContentPane().add(btn_remover);
		
		t_actualizar = new JTextField();
		t_actualizar.setBounds(473, 111, 96, 19);
		frame.getContentPane().add(t_actualizar);
		t_actualizar.setColumns(10);
		
		btn_actualizar = new JButton("Actualizar");
		btn_actualizar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_actualizar.setBounds(604, 112, 85, 21);
		frame.getContentPane().add(btn_actualizar);

		btn_adicionar.addActionListener(this::actionPerformed);
		btn_remover.addActionListener(this::actionPerformed);
		btn_actualizar.addActionListener(this::actionPerformed);

		t_actualizar.addMouseListener(this);

		this.frame.setVisible(true);
		tabelar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_adicionar){
			try {
				String id = t_nr_cela.getText();
				String localizacao = t_localizacao.getText();
				String tipo = Objects.requireNonNull(tipos.getSelectedItem()).toString();
				int capacidade = Integer.parseInt(t_capacidade.getText());
				inserir(id, localizacao, "0", String.valueOf(capacidade), tipo);
				tabelar();
			}catch (Exception c){
				JOptionPane.showMessageDialog(this.frame,c.getMessage());
			}
		}

		if (e.getSource() == btn_remover){
			try {
				int id = Integer.parseInt(t_remover.getText());
				if (estaNaBaseDeDados(id)>=0){
					remover(String.valueOf(id));
					JOptionPane.showMessageDialog(this.frame, "Removido");
				}else {
					JOptionPane.showMessageDialog(this.frame, "Não existe nos registos");
				}
				tabelar();
			}catch (Exception c){
				JOptionPane.showMessageDialog(this.frame, "Não pode remover " + c.getMessage());
			}
		}

		if (e.getSource() == btn_actualizar){
			String localizacao = t_localizacao.getText();
			String tipo = Objects.requireNonNull(tipos.getSelectedItem()).toString();
			try {
				int capacidade = Integer.parseInt(t_capacidade.getText());
				if (estaNaBaseDeDados(Integer.parseInt(t_actualizar.getText()))>=0){
					actualizar(t_actualizar.getText(), localizacao, tipo, capacidade);
				}
			}catch (Exception c){
				JOptionPane.showMessageDialog(this.frame, "Não pode remover " + c.getMessage());
			}
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == t_actualizar){
			try {
				int id = estaNaBaseDeDados(Integer.parseInt(t_actualizar.getText()));
				if (id>=0){
					CelaObj cela = pegarCela(id);
					t_localizacao.setText(cela.getLocalicazao());
					t_nr_reclusos.setText(String.valueOf(cela.getNr_de_reclusos()));
					t_capacidade.setText(String.valueOf(cela.getCapacidade()));
					tipos.setSelectedItem(cela.getTipo());
				}
			}catch (Exception c){
				JOptionPane.showMessageDialog(this.frame, "Não encontrado " + c.getMessage());
			}

		}
	}
}
