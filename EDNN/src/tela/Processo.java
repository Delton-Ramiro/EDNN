package tela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Processo {

	private JFrame frame;
	private JTextField t_codigo_pro;
	private JTextField t_condicao_saude;
	private JTextField t_tipo_processo;
	private JTextField t_pena;
	private JTextField t_data_entrada;
	private JTextField t_hora_entrada;
	private JTextField t_data_pevista_saida;
	private JTextField t_advogado;
	private JTextField t_bens;
	private JTextField t_altura;
	private JTextField t_cor_dos_olhos;
	private JLabel lb_pesol;
	private JTextField t_peso;
	private JLabel lb_medicacao;
	private JTextField t_medicacao;
	private JTextField t_adicionar;
	private JTextField t_remover;
	private JTextField t_actualizar;
	private JButton btn_adicionar;
	private JButton btn_remover;
	private JButton btn_actualizar;
	private JButton btn_gravar;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Processo window = new Processo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Processo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setBounds(100, 100, 939, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lb_codigo = new JLabel("Codigo do Processo");
		lb_codigo.setBounds(10, 32, 146, 26);
		frame.getContentPane().add(lb_codigo);
		
		t_codigo_pro = new JTextField();
		t_codigo_pro.setBounds(10, 68, 146, 19);
		frame.getContentPane().add(t_codigo_pro);
		t_codigo_pro.setColumns(10);
		
		JLabel lb_condicao_de_saude = new JLabel("Condicao de Saude");
		lb_condicao_de_saude.setBounds(10, 100, 114, 13);
		frame.getContentPane().add(lb_condicao_de_saude);
		
		t_condicao_saude = new JTextField();
		t_condicao_saude.setBounds(10, 132, 146, 19);
		frame.getContentPane().add(t_condicao_saude);
		t_condicao_saude.setColumns(10);
		
		JLabel lb_tipo_de_processo = new JLabel("Tipo de Processo");
		lb_tipo_de_processo.setBounds(10, 161, 114, 13);
		frame.getContentPane().add(lb_tipo_de_processo);
		
		t_tipo_processo = new JTextField();
		t_tipo_processo.setBounds(10, 184, 146, 19);
		frame.getContentPane().add(t_tipo_processo);
		t_tipo_processo.setColumns(10);
		
		JLabel lb_pena = new JLabel("Pena");
		lb_pena.setBounds(20, 213, 45, 13);
		frame.getContentPane().add(lb_pena);
		
		t_pena = new JTextField();
		t_pena.setBounds(10, 236, 146, 19);
		frame.getContentPane().add(t_pena);
		t_pena.setColumns(10);
		
		JLabel lb_data_entrada = new JLabel("Data de Entrada");
		lb_data_entrada.setBounds(10, 280, 146, 13);
		frame.getContentPane().add(lb_data_entrada);
		
		t_data_entrada = new JTextField();
		t_data_entrada.setBounds(10, 301, 146, 19);
		frame.getContentPane().add(t_data_entrada);
		t_data_entrada.setColumns(10);
		
		JLabel lb_hora_de_entrada = new JLabel("Hora_de_entrada");
		lb_hora_de_entrada.setBounds(10, 330, 146, 13);
		frame.getContentPane().add(lb_hora_de_entrada);
		
		t_hora_entrada = new JTextField();
		t_hora_entrada.setBounds(10, 353, 146, 19);
		frame.getContentPane().add(t_hora_entrada);
		t_hora_entrada.setColumns(10);
		
		JLabel lb_data_prevista_saida = new JLabel("Data prevista de saida");
		lb_data_prevista_saida.setBounds(10, 382, 146, 13);
		frame.getContentPane().add(lb_data_prevista_saida);
		
		t_data_pevista_saida = new JTextField();
		t_data_pevista_saida.setBounds(10, 405, 146, 19);
		frame.getContentPane().add(t_data_pevista_saida);
		t_data_pevista_saida.setColumns(10);
		
		JLabel lb_advogado = new JLabel("Advogado");
		lb_advogado.setBounds(418, 39, 161, 13);
		frame.getContentPane().add(lb_advogado);
		
		t_advogado = new JTextField();
		t_advogado.setBounds(418, 68, 161, 19);
		frame.getContentPane().add(t_advogado);
		t_advogado.setColumns(10);
		
		JLabel lb_bens = new JLabel("Bens");
		lb_bens.setBounds(418, 100, 161, 13);
		frame.getContentPane().add(lb_bens);
		
		t_bens = new JTextField();
		t_bens.setBounds(418, 132, 161, 19);
		frame.getContentPane().add(t_bens);
		t_bens.setColumns(10);
		
		JLabel lb_altura = new JLabel("Altura");
		lb_altura.setBounds(418, 171, 161, 13);
		frame.getContentPane().add(lb_altura);
		
		JLabel lb_cor_dos_olhos = new JLabel("Cor dos Olhos");
		lb_cor_dos_olhos.setBounds(418, 223, 161, 13);
		frame.getContentPane().add(lb_cor_dos_olhos);
		
		t_altura = new JTextField();
		t_altura.setBounds(418, 194, 161, 19);
		frame.getContentPane().add(t_altura);
		t_altura.setColumns(10);
		
		t_cor_dos_olhos = new JTextField();
		t_cor_dos_olhos.setBounds(418, 246, 161, 19);
		frame.getContentPane().add(t_cor_dos_olhos);
		t_cor_dos_olhos.setColumns(10);
		
		lb_pesol = new JLabel("Peso");
		lb_pesol.setBounds(428, 280, 151, 13);
		frame.getContentPane().add(lb_pesol);
		
		t_peso = new JTextField();
		t_peso.setBounds(418, 313, 161, 19);
		frame.getContentPane().add(t_peso);
		t_peso.setColumns(10);
		
		lb_medicacao = new JLabel("Medicacao");
		lb_medicacao.setBounds(418, 356, 161, 13);
		frame.getContentPane().add(lb_medicacao);
		
		t_medicacao = new JTextField();
		t_medicacao.setBounds(418, 379, 161, 29);
		frame.getContentPane().add(t_medicacao);
		t_medicacao.setColumns(10);
		
		t_adicionar = new JTextField();
		t_adicionar.setBounds(269, 437, 96, 19);
		frame.getContentPane().add(t_adicionar);
		t_adicionar.setColumns(10);
		
		t_remover = new JTextField();
		t_remover.setBounds(413, 437, 96, 19);
		frame.getContentPane().add(t_remover);
		t_remover.setColumns(10);
		
		t_actualizar = new JTextField();
		t_actualizar.setBounds(555, 437, 96, 19);
		frame.getContentPane().add(t_actualizar);
		t_actualizar.setColumns(10);
		
		btn_adicionar = new JButton("Adicionar");
		btn_adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_adicionar.setBounds(280, 479, 85, 21);
		frame.getContentPane().add(btn_adicionar);
		
		btn_remover = new JButton("Remover");
		btn_remover.setBounds(418, 479, 85, 21);
		frame.getContentPane().add(btn_remover);
		
		btn_actualizar = new JButton("Acrtualizar");
		btn_actualizar.setBounds(555, 479, 85, 21);
		frame.getContentPane().add(btn_actualizar);
		
		btn_gravar = new JButton("Gravar");
		btn_gravar.setBounds(64, 448, 85, 21);
		frame.getContentPane().add(btn_gravar);
		
		table_2 = new JTable();
		table_2.setBounds(10, 537, 891, 137);
		frame.getContentPane().add(table_2);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(884, 537, 17, 137);
		frame.getContentPane().add(scrollBar);

		this.frame.setVisible(true);
	}
}
