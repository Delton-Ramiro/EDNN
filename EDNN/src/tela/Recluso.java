package tela;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

public class Recluso extends JFrame implements ActionListener, MouseListener{
    private JLabel labelNome,labelApelido, labelGenero, labelId,
            labelNascimento, labelAreaTrabalho, labelProfissao,
            labelActualizacao, labelPesquisa, labelRemocao, labelImagem,
            tituloRecluso, nomePai, nomeMae, nrCasa, rua,cidade, bairro,quarteirao;
    private JTextField textNome, textCodigo,textApelido,textNascimento,
            textCodigoActualizar, textCodigoEliminar, textCriterioUm, textCodPosicaoPorInserir,
            textoNomePai, textoNomeMae,textoidentificacao, textoNrCasa, textoRua, textoCidade, textoBairro, textoQuarteirao;
    private JRadioButton rbMasculino, rbFemenino;
    private JButton  btnGravar, btnSair,btnGravarInicio, btnGravarPosicao, btnActualizar,btnRemover,btnPesquisa;
    private JScrollPane scrollPane;
    private ButtonGroup btnGrupo;
    private JComboBox areas,profissoes, criteriosUm;
    private static DefaultTableModel model;
    private static String[] nomeAreas, nomeProfissoes, nomeCriteriosUm;
    private JTable table_2;
    static int iteracaoSalvamento = 1;
    static int controle=0;
    JLabel image;

    String nome, apelido, areaTrabalho, profissao,dataNascimento;
    String[] dataSeparada;
    int ano,codigo;
    char genero;
    LocalDate data;



    public Recluso() {
        this.setTitle("Recluso");
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
        model.addColumn("Nome do Pai");
        model.addColumn("Nome da Mae");

        tituloRecluso = new JLabel("Recluso");
        tituloRecluso.setFont(new Font("Times New Roman", Font.BOLD, 25));
        tituloRecluso.setBounds(350, 10, 600, 23);
        panel.add(tituloRecluso);


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
        textNome.setBounds(100, 90, 200, 20);
        panel.add(textNome);
        textNome.setColumns(10);

        labelApelido = new JLabel("Apelido: ");
        labelApelido.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelApelido.setBounds(11, 120, 75, 23);
        panel.add(labelApelido);

        nomeMae = new JLabel("Nome da mae: ");
        nomeMae.setFont(new Font("Times New Roman", Font.BOLD, 17));
        nomeMae.setBounds(11, 145, 75, 23);
        panel.add(nomeMae);

        textoNomeMae = new JTextField();
        textoNomeMae.setBounds(100, 145, 200, 20);
        panel.add(textoNomeMae);
        textoNomeMae.setColumns(10);

        nomePai = new JLabel("Nome da mae: ");
        nomePai.setFont(new Font("Times New Roman", Font.BOLD, 17));
        nomePai.setBounds(11, 175, 75, 23);
        panel.add(nomePai);

        textoNomePai = new JTextField();
        textoNomePai.setBounds(100, 175, 200, 20);
        panel.add(textoNomePai);
        textoNomePai.setColumns(10);

        textApelido = new JTextField();
        textApelido.setBounds(100, 120, 200, 20);
        panel.add(textApelido);
        textApelido.setColumns(10);

        labelGenero = new JLabel("Sexo: ");
        labelGenero.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelGenero.setBounds(11, 195, 75, 23);
        panel.add(labelGenero);

        rbMasculino = new JRadioButton("Masculino");
        rbFemenino = new JRadioButton("Femenino");
        btnGrupo = new ButtonGroup();btnGrupo.add(rbMasculino);btnGrupo.add(rbFemenino);
        rbMasculino.setBounds(80, 195, 85, 23);
        rbMasculino.setSelected(true);
        rbFemenino.setBounds(170, 195, 85, 23);
        panel.add(rbMasculino);
        panel.add(rbFemenino);

        labelNascimento = new JLabel("Nascimento ");
        labelNascimento.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelNascimento.setBounds(11, 220, 75, 23);
        panel.add(labelNascimento);

        textNascimento = new JTextField();

        textNascimento.setBounds(100, 220, 200, 20);
        textNascimento.setColumns(10);
        panel.add(textNascimento);

        labelAreaTrabalho = new JLabel("Identificaçao");
        labelAreaTrabalho.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelAreaTrabalho.setBounds(11, 250, 75, 23);
        panel.add(labelAreaTrabalho);


        areas = new JComboBox();
        nomeAreas= new String[]{"BI","Passaporte"};
        areas.setModel(new DefaultComboBoxModel(nomeAreas));
        areas.setToolTipText("Escolha um tipo");
        areas.setBounds(100, 250, 200, 20);
        panel.add(areas);

        textoidentificacao = new JTextField();
        textoidentificacao.setBounds(100, 275, 200, 20);
        panel.add(textoidentificacao);
        textoidentificacao.setColumns(10);

        labelProfissao = new JLabel("Actividade ");
        labelProfissao.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelProfissao.setBounds(11, 299, 75, 23);
        panel.add(labelProfissao);

        profissoes = new JComboBox();
        nomeProfissoes= new String[]{"Auxiliar de limpeza","Bibliotecario","Cozinheiro", "Lavador",};
        profissoes.setModel(new DefaultComboBoxModel(nomeProfissoes));
        profissoes.setToolTipText("Escolha uma area");
        profissoes.setBounds(100, 299, 200, 20);
        panel.add(profissoes);

        btnGravar = new JButton("Gravar");
        btnGravar.setBounds(100, 380, 150, 20);
        panel.add(btnGravar);


        textCodPosicaoPorInserir = new JTextField();
        textCodPosicaoPorInserir.setBounds(40, 340, 50, 20);
        textCodPosicaoPorInserir.setColumns(10);
        textCodPosicaoPorInserir.setToolTipText("Introduza a posição a inserir ");
        panel.add(textCodPosicaoPorInserir);

        nrCasa = new JLabel("Nr de Casa");
        nrCasa.setFont(new Font("Times New Roman", Font.BOLD, 14));
        nrCasa.setBounds(401, 60, 75, 23);
        panel.add(nrCasa);

        textoNrCasa = new JTextField();
        textoNrCasa.setBounds(401, 90, 140, 20);
        textoNrCasa.setColumns(10);
        textoNrCasa.setToolTipText("Introduza nr de casa");
        panel.add(textoNrCasa);

        cidade = new JLabel("Cidade");
        cidade.setFont(new Font("Times New Roman", Font.BOLD, 14));
        cidade.setBounds(401, 115, 75, 23);
        panel.add(cidade);

        textoCidade = new JTextField();
        textoCidade.setBounds(401, 140, 140, 20);
        textoCidade.setColumns(10);
        textoCidade.setToolTipText("Introduza cidade");
        panel.add(textoCidade);

        rua = new JLabel("Rua");
        rua.setFont(new Font("Times New Roman", Font.BOLD, 14));
        rua.setBounds(401, 170, 75, 23);
        panel.add(rua);

        textoRua = new JTextField();
        textoRua.setBounds(401, 190, 140, 20);
        textoRua.setColumns(10);
        textoRua.setToolTipText("Introduza rua");
        panel.add(textoRua);

        bairro = new JLabel("Bairro");
        bairro.setFont(new Font("Times New Roman", Font.BOLD, 14));
        bairro.setBounds(401, 210, 75, 23);
        panel.add(bairro);

        textoBairro = new JTextField();
        textoBairro.setBounds(401, 230, 140, 20);
        textoBairro.setColumns(10);
        textoBairro.setToolTipText("Introduza bairro");
        panel.add(textoBairro);

        quarteirao = new JLabel("quarteirao");
        quarteirao.setFont(new Font("Times New Roman", Font.BOLD, 14));
        quarteirao.setBounds(401, 250, 75, 23);
        panel.add(quarteirao);

        textoQuarteirao = new JTextField();
        textoQuarteirao.setBounds(401, 280, 140, 20);
        textoQuarteirao.setColumns(10);
        textoQuarteirao.setToolTipText("Introduza quarteirao");
        panel.add(textoQuarteirao);

        labelActualizacao = new JLabel("Actualizar");
        labelActualizacao.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelActualizacao.setBounds(601, 60, 75, 23);
        panel.add(labelActualizacao);

        textCodigoActualizar = new JTextField();
        textCodigoActualizar.setBounds(601, 90, 140, 20);
        textCodigoActualizar.setColumns(10);
        textCodigoActualizar.setToolTipText("Introduza o código");
        panel.add(textCodigoActualizar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(601, 120, 140, 20);
        panel.add(btnActualizar);



        labelRemocao = new JLabel("Remover");
        labelRemocao.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelRemocao.setBounds(601, 150, 75, 23);
        panel.add(labelRemocao);

        textCodigoEliminar = new JTextField();
        textCodigoEliminar.setBounds(601, 180, 140, 20);
        textCodigoEliminar.setColumns(10);
        textCodigoEliminar.setToolTipText("Introduza o código");
        panel.add(textCodigoEliminar);

        btnRemover = new JButton("Rem/codigo");
        btnRemover.setBounds(601, 210, 140, 20);
        panel.add(btnRemover);


        labelPesquisa = new JLabel("Pesquisar");
        labelPesquisa.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelPesquisa.setBounds(601, 240, 75, 23);
        panel.add(labelPesquisa);

        criteriosUm= new JComboBox();
        nomeCriteriosUm= new String[]{"","Nome","Apelido","Género","Área de Trabalho", "Profissão", "Código"};
        criteriosUm.setModel(new DefaultComboBoxModel(nomeCriteriosUm));
        criteriosUm.setToolTipText("Escolha um critério");
        criteriosUm.setBounds(601, 270, 140, 20);
        panel.add(criteriosUm);

        textCriterioUm = new JTextField();
        textCriterioUm.setBounds(601, 300, 140, 20);
        textCriterioUm.setColumns(10);
        panel.add(textCriterioUm);

        btnPesquisa = new JButton("Pesquisar");
        btnPesquisa.setBounds(601, 330, 140, 20);
        panel.add(btnPesquisa);

        btnSair = new JButton("Sair");
        btnSair.setBounds(11, 470, 89, 23);
        panel.add(btnSair);


        btnGravar.addActionListener(this::actionPerformed);

        btnSair.addActionListener(this::actionPerformed);
        btnRemover.addActionListener(this::actionPerformed);
        btnActualizar.addActionListener(this::actionPerformed);
        btnPesquisa.addActionListener(this::actionPerformed);

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
