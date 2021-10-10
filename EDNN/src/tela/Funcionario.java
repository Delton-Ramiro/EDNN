package tela;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Funcionario extends JFrame implements ActionListener, MouseListener {
    private JLabel labelFuncao, labelDataNascimento, labelId,
            labelNome,labelBi, labelApelido, labelTurno, labelContacto, labelDepartamento, labelNrCasa, labelCidade, labelBairro,
            labelRua, labelQuarteirao,labelPeso,
            labelActualizacao, labelPesquisa, labelRemocao;
    private JTextField textFuncao, textId,textDataNascimento, textNome,textBi,textApelido, textTurno,textContacto,
            textDepartamento, textNrCasa,textCidade, textBairro, textRua, textQuarteirao, textPeso,
            textCodigoActualizar, textCodigoEliminar, textCriterioNome, textCodPosicaoPorInserir;
    private JRadioButton rbMasculino, rbFemenino;
    private JButton  btnGravar, btnSair, btnActualizar,btnRemover,btnPesquisa;
    private JScrollPane scrollPane;
    private ButtonGroup btnGrupo;
    private static DefaultTableModel model;
    private JTable table_2;
    static int iteracaoSalvamento = 1;
    JLabel image;


    public Funcionario() {
        this.setTitle("Funcionário");
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
        model.addColumn("id");
        model.addColumn("função");
        model.addColumn("data_nasc");
        model.addColumn("nome");
        model.addColumn("bi");
        model.addColumn("apelido");
        model.addColumn("turno");
        model.addColumn("contacto");
        model.addColumn("depart");
        model.addColumn("nr_casa");
        model.addColumn("cidade");
        model.addColumn("bairro");
        model.addColumn("rua");
        model.addColumn("quarteirao");
        model.addColumn("contacto");
        model.addColumn("peso");


        labelId = new JLabel("Id: ");
        labelId.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelId.setBounds(11, 60, 75, 23);
        panel.add(labelId);

        textId = new JTextField();
        textId.setBounds(80, 60, 90, 20);
        textId.setColumns(5);
        textId.setEditable(false);
        textId.setText(String.valueOf(iteracaoSalvamento));
        panel.add(textId);

        labelFuncao = new JLabel("Função: ");
        labelFuncao.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelFuncao.setBounds(11, 90, 75, 23);
        panel.add(labelFuncao);

        textFuncao = new JTextField();
        textFuncao.setBounds(80, 90, 200, 20);
        panel.add(textFuncao);
        textFuncao.setColumns(10);

        labelDataNascimento = new JLabel("Nasc: ");
        labelDataNascimento.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelDataNascimento.setBounds(11, 120, 75, 23);
        panel.add(labelDataNascimento);

        textDataNascimento = new JTextField();
        textDataNascimento.setBounds(80, 120, 200, 20);
        panel.add(textDataNascimento);
        textDataNascimento.setColumns(10);


        labelNome = new JLabel("Nome: ");
        labelNome.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelNome.setBounds(11, 150, 75, 23);
        panel.add(labelNome);

        textNome = new JTextField();
        textNome.setBounds(80, 150, 200, 20);
        textNome.setColumns(10);
        panel.add(textNome);

        labelBi = new JLabel("Bi: ");
        labelBi.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelBi.setBounds(11, 180, 75, 23);
        panel.add(labelBi);

        textBi = new JTextField();
        textBi.setBounds(80, 180, 200, 20);
        textBi.setColumns(10);
        panel.add(textBi);

        labelApelido = new JLabel("Apelido: ");
        labelApelido.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelApelido.setBounds(11, 210, 75, 23);
        panel.add(labelApelido);

        textApelido = new JTextField();
        textApelido.setBounds(80, 210, 200, 20);
        textApelido.setColumns(10);
        panel.add(textApelido);

        labelTurno = new JLabel("Turno: ");
        labelTurno.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelTurno.setBounds(11, 240, 75, 23);
        panel.add(labelTurno);

        textTurno = new JTextField();
        textTurno.setBounds(80, 240, 200, 20);
        textTurno.setColumns(10);
        panel.add(textTurno);

        labelContacto = new JLabel("Contacto: ");
        labelContacto.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelContacto.setBounds(11, 270, 75, 23);
        panel.add(labelContacto);

        textContacto = new JTextField();
        textContacto.setBounds(80, 270, 200, 20);
        textContacto.setColumns(10);
        panel.add(textContacto);

        labelDepartamento = new JLabel("Departamento: ");
        labelDepartamento.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelDepartamento.setBounds(11, 300, 75, 23);
        panel.add(labelDepartamento);

        textDepartamento = new JTextField();
        textDepartamento.setBounds(80, 300, 200, 20);
        textDepartamento.setColumns(10);
        panel.add(textDepartamento);

        labelPeso = new JLabel("Peso: ");
        labelPeso.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelPeso.setBounds(11, 330, 75, 23);
        panel.add(labelPeso);

        textPeso = new JTextField();
        textPeso.setBounds(80, 330, 200, 20);
        textPeso.setColumns(10);
        panel.add(textPeso);


        labelNrCasa = new JLabel("Nr casa: ");
        labelNrCasa.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelNrCasa.setBounds(400, 60, 75, 23);
        panel.add(labelNrCasa);

        textNrCasa = new JTextField();
        textNrCasa.setBounds(479, 60, 200, 20);
        textNrCasa.setColumns(10);
        panel.add(textNrCasa);

        labelCidade = new JLabel("Cidade: ");
        labelCidade.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelCidade.setBounds(400, 90, 75, 23);
        panel.add(labelCidade);

        textCidade = new JTextField();
        textCidade.setBounds(479, 90, 200, 20);
        textCidade.setColumns(10);
        panel.add(textCidade);

        labelBairro = new JLabel("Bairro: ");
        labelBairro.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelBairro.setBounds(400, 120, 75, 23);
        panel.add(labelBairro);

        textBairro = new JTextField();
        textBairro.setBounds(479, 120, 200, 20);
        textBairro.setColumns(10);
        panel.add(textBairro);

        labelRua = new JLabel("Rua: ");
        labelRua.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelRua.setBounds(400, 150, 75, 23);
        panel.add(labelRua);

        textRua = new JTextField();
        textRua.setBounds(479, 150, 200, 20);
        textRua.setColumns(10);
        panel.add(textRua);

        labelQuarteirao = new JLabel("Quarteirão: ");
        labelQuarteirao.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelQuarteirao.setBounds(400, 180, 75, 23);
        panel.add(labelQuarteirao);

        textQuarteirao = new JTextField();
        textQuarteirao.setBounds(479, 180, 200, 20);
        textQuarteirao.setColumns(10);
        panel.add(textQuarteirao);









        textCodPosicaoPorInserir = new JTextField();
        textCodPosicaoPorInserir.setBounds(40, 360, 50, 20);
        textCodPosicaoPorInserir.setColumns(10);
        textCodPosicaoPorInserir.setToolTipText("Introduza a posição a inserir ");
        panel.add(textCodPosicaoPorInserir);

        btnGravar = new JButton("Gravar");
        btnGravar.setBounds(100, 360, 150, 20);
        panel.add(btnGravar);

        labelActualizacao = new JLabel("Actualizar");
        labelActualizacao.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelActualizacao.setBounds(280, 340, 75, 23);
        panel.add(labelActualizacao);

        textCodigoActualizar = new JTextField();
        textCodigoActualizar.setBounds(280, 370, 140, 20);
        textCodigoActualizar.setColumns(10);
        textCodigoActualizar.setToolTipText("Introduza o código");
        panel.add(textCodigoActualizar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(280, 400, 140, 20);
        panel.add(btnActualizar);



        labelRemocao = new JLabel("Remover");
        labelRemocao.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelRemocao.setBounds(460, 340, 75, 23);
        panel.add(labelRemocao);

        textCodigoEliminar = new JTextField();
        textCodigoEliminar.setBounds(460, 370, 140, 20);
        textCodigoEliminar.setColumns(10);
        textCodigoEliminar.setToolTipText("Introduza o código");
        panel.add(textCodigoEliminar);

        btnRemover = new JButton("Rem/codigo");
        btnRemover.setBounds(460, 400, 140, 20);
        panel.add(btnRemover);


        labelPesquisa = new JLabel("Pesquisar");
        labelPesquisa.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelPesquisa.setBounds(640, 340, 75, 23);
        panel.add(labelPesquisa);

        textCriterioNome = new JTextField();
        textCriterioNome.setBounds(640, 370, 140, 20);
        textCriterioNome.setColumns(10);
        panel.add(textCriterioNome);

        btnPesquisa = new JButton("Pesquisar");
        btnPesquisa.setBounds(640, 400, 140, 20);
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
