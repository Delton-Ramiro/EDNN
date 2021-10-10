package tela;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

public class Registro extends JFrame implements ActionListener, MouseListener{
    private JLabel labelNome,labelApelido, labelGenero, labelId,
            labelNascimento, labelAreaTrabalho, labelProfissao,
            labelActualizacao, labelPesquisa, labelRemocao, labelImagem;
    private JTextField textNome, textCodigo,textApelido,textNascimento,
            textCodigoActualizar, textCodigoEliminar, textCriterioUm, textCodPosicaoPorInserir;
    private JRadioButton rbMasculino, rbFemenino;
    private JButton  btnGravar, btnSair,btnGravarInicio, btnGravarPosicao, btnActualizar,btnRemover,btnPesquisa, btnOrdenar;
    private JScrollPane scrollPane;
    private ButtonGroup btnGrupo;
    private JComboBox areas,profissoes, criteriosUm;
    private static DefaultTableModel model;
    private static String[] nomeAreas, nomeProfissoes, nomeCriteriosUm;
    private JTable table_2;
    static int iteracaoSalvamento = 1;
    static int controle=0;
    JLabel image;


    public Registro() {
        this.setTitle("Registrar/A");
        this.setSize(830,700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
        this.setResizable(false);

        JPanel panel = new JPanel();
        this.getContentPane().add(panel);
        panel.setLayout(null);



        scrollPane = new JScrollPane();
        scrollPane.setEnabled(false);
        scrollPane.setBounds(10, 533, 794, 102);
        panel.add(scrollPane);

        model = new DefaultTableModel();
        table_2 = new JTable();
        table_2.setEnabled(false);
        scrollPane.setViewportView(table_2);
        table_2.setModel(model);
        model.addColumn("Código");
        model.addColumn("Nome");
        model.addColumn("Apelido");
        model.addColumn("Nascimento");
        model.addColumn("Género");
        model.addColumn("Área");
        model.addColumn("Profissão");

        labelId = new JLabel("Código: ");
        labelId.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelId.setBounds(11, 60, 75, 23);
        panel.add(labelId);

        textCodigo = new JTextField();
        textCodigo.setBounds(80, 60, 90, 20);
        textCodigo.setColumns(5);
        textCodigo.setEditable(false);
        textCodigo.setText(String.valueOf(iteracaoSalvamento));
        panel.add(textCodigo);

        labelNome = new JLabel("Nome: ");
        labelNome.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelNome.setBounds(11, 90, 75, 23);
        panel.add(labelNome);

        textNome = new JTextField();
        textNome.setBounds(80, 90, 200, 20);
        panel.add(textNome);
        textNome.setColumns(10);

        labelApelido = new JLabel("Apelido: ");
        labelApelido.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelApelido.setBounds(11, 120, 75, 23);
        panel.add(labelApelido);

        textApelido = new JTextField();
        textApelido.setBounds(80, 120, 200, 20);
        panel.add(textApelido);
        textApelido.setColumns(10);

        labelGenero = new JLabel("Sexo: ");
        labelGenero.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelGenero.setBounds(11, 150, 75, 23);
        panel.add(labelGenero);

        rbMasculino = new JRadioButton("Masculino");
        rbFemenino = new JRadioButton("Femenino");
        btnGrupo = new ButtonGroup();btnGrupo.add(rbMasculino);btnGrupo.add(rbFemenino);
        rbMasculino.setBounds(80, 150, 85, 23);
        rbMasculino.setSelected(true);
        rbFemenino.setBounds(170, 150, 85, 23);
        panel.add(rbMasculino);
        panel.add(rbFemenino);

        labelNascimento = new JLabel("Nascimento ");
        labelNascimento.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelNascimento.setBounds(11, 180, 75, 23);
        panel.add(labelNascimento);

        textNascimento = new JTextField();

        textNascimento.setBounds(100, 180, 200, 20);
        textNascimento.setColumns(10);
        panel.add(textNascimento);

        labelAreaTrabalho = new JLabel("Área ");
        labelAreaTrabalho.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelAreaTrabalho.setBounds(11, 210, 75, 23);
        panel.add(labelAreaTrabalho);

        areas = new JComboBox();
        nomeAreas= new String[]{"Gestão", "Secretáriado", "Segurança"};
        areas.setModel(new DefaultComboBoxModel(nomeAreas));
        areas.setToolTipText("Escolha uma área");
        areas.setBounds(80, 210, 200, 20);
        panel.add(areas);

        labelProfissao = new JLabel("Profissão ");
        labelProfissao.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelProfissao.setBounds(11, 240, 75, 23);
        panel.add(labelProfissao);

        profissoes = new JComboBox();
        nomeProfissoes= new String[]{"Programador","Engenheiro electrónico","Contabilista"};
        profissoes.setModel(new DefaultComboBoxModel(nomeProfissoes));
        profissoes.setToolTipText("Escolha uma área");
        profissoes.setBounds(80, 240, 200, 20);
        panel.add(profissoes);

        btnGravar = new JButton("Gravar");
        btnGravar.setBounds(100, 280, 150, 20);
        panel.add(btnGravar);

        btnGravarInicio = new JButton("Gravar Inicio");
        btnGravarInicio.setBounds(100, 310, 150, 20);
        panel.add(btnGravarInicio);

        textCodPosicaoPorInserir = new JTextField();
        textCodPosicaoPorInserir.setBounds(40, 340, 50, 20);
        textCodPosicaoPorInserir.setColumns(10);
        textCodPosicaoPorInserir.setToolTipText("Introduza a posição a inserir ");
        panel.add(textCodPosicaoPorInserir);

        btnGravarPosicao = new JButton("Gravar Posição");
        btnGravarPosicao.setBounds(100, 340, 150, 20);
        panel.add(btnGravarPosicao);


        labelActualizacao = new JLabel("Actualizar");
        labelActualizacao.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelActualizacao.setBounds(501, 60, 75, 23);
        panel.add(labelActualizacao);

        textCodigoActualizar = new JTextField();
        textCodigoActualizar.setBounds(501, 90, 140, 20);
        textCodigoActualizar.setColumns(10);
        textCodigoActualizar.setToolTipText("Introduza o código");
        panel.add(textCodigoActualizar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(501, 120, 140, 20);
        panel.add(btnActualizar);



        labelRemocao = new JLabel("Remover");
        labelRemocao.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelRemocao.setBounds(501, 150, 75, 23);
        panel.add(labelRemocao);

        textCodigoEliminar = new JTextField();
        textCodigoEliminar.setBounds(501, 180, 140, 20);
        textCodigoEliminar.setColumns(10);
        textCodigoEliminar.setToolTipText("Introduza o código");
        panel.add(textCodigoEliminar);

        btnRemover = new JButton("Rem/codigo");
        btnRemover.setBounds(500, 210, 140, 20);
        panel.add(btnRemover);


        labelPesquisa = new JLabel("Pesquisar");
        labelPesquisa.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelPesquisa.setBounds(500, 240, 75, 23);
        panel.add(labelPesquisa);

        criteriosUm= new JComboBox();
        nomeCriteriosUm= new String[]{"","Nome","Apelido","Género","Área de Trabalho", "Profissão", "Código"};
        criteriosUm.setModel(new DefaultComboBoxModel(nomeCriteriosUm));
        criteriosUm.setToolTipText("Escolha um critério");
        criteriosUm.setBounds(501, 270, 140, 20);
        panel.add(criteriosUm);

        textCriterioUm = new JTextField();
        textCriterioUm.setBounds(501, 300, 140, 20);
        textCriterioUm.setColumns(10);
        panel.add(textCriterioUm);

        btnPesquisa = new JButton("Pesquisar");
        btnPesquisa.setBounds(501, 330, 140, 20);
        panel.add(btnPesquisa);

        btnOrdenar = new JButton("Ordenar");
        btnOrdenar.setBounds(501, 360, 140, 20);
        panel.add(btnOrdenar);


        btnSair = new JButton("Sair");
        btnSair.setBounds(11, 470, 89, 23);
        panel.add(btnSair);


        btnGravar.addActionListener(this::actionPerformed);
        btnGravarInicio.addActionListener(this);
        btnGravarPosicao.addActionListener(this::actionPerformed);
        btnSair.addActionListener(this::actionPerformed);
        btnRemover.addActionListener(this::actionPerformed);
        btnActualizar.addActionListener(this::actionPerformed);
        btnPesquisa.addActionListener(this::actionPerformed);
        btnOrdenar.addActionListener(this::actionPerformed);
        textCodigoActualizar.addMouseListener(this);
        textCodigoEliminar.addMouseListener(this);

        image = new JLabel("");
        image.setIcon(new ImageIcon("tela/segundafoto.jpeg"));
        image.setBounds(0, 0, 830, 700);
        panel.add(image);
        this.add(panel);


        this.setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGravar){

        }


        if (e.getSource() == btnGravarInicio){

        }

        if (e.getSource() == btnGravarPosicao){

        }


        if (e.getSource() == btnActualizar){

        }

        if (e.getSource() == btnRemover){

        }

        if (e.getSource() == btnPesquisa){

        }

        if (e.getSource() == btnOrdenar){

        }

        if (e.getSource()==btnSair){
            this.dispose();
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
        if (e.getSource() == textCodigoActualizar){

        }
    }


    public void tabelar(){
        for (int i= model.getRowCount(); 0<i; i--){
            model.removeRow(i-1);
        }
            model.addRow(new Object[]{});
        SwingUtilities.updateComponentTreeUI(this);
    }

}
