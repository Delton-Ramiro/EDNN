package tela;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

public class Departamento extends JFrame implements ActionListener, MouseListener {
    private JLabel labelNome, labelId,
            labelActualizacao, labelPesquisa, labelRemocao;
    private JTextField textNome, textCodigo,
            textCodigoActualizar, textCodigoEliminar, textPesquisar;
    private JButton  btnGravar, btnSair, btnActualizar,btnRemover,btnPesquisa;
    private JScrollPane scrollPane;

    private static DefaultTableModel model;

    private JTable table_2;
    static int iteracaoSalvamento = 1;
    static int controle=0;
    JLabel image;


    public Departamento() {
        this.setTitle("Departamento");
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





        labelId = new JLabel("Codigo: ");
        labelId.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelId.setBounds(11, 80, 75, 23);
        panel.add(labelId);

        textCodigo = new JTextField();
        textCodigo.setBounds(80, 80, 90, 20);
        textCodigo.setColumns(5);
        textCodigo.setEditable(false);
        textCodigo.setText(String.valueOf(iteracaoSalvamento));
        panel.add(textCodigo);

        labelNome = new JLabel("Nome: ");
        labelNome.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelNome.setBounds(11, 120, 75, 23);
        panel.add(labelNome);

        textNome = new JTextField();
        textNome.setBounds(100, 120, 200, 20);
        panel.add(textNome);
        textNome.setColumns(10);




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

        textPesquisar = new JTextField();
        textPesquisar.setBounds(601, 270, 140, 20);
        textPesquisar.setColumns(10);
        textPesquisar.setToolTipText("Introduza o código");
        panel.add(textPesquisar);



        btnPesquisa = new JButton("Pesquisar");
        btnPesquisa.setBounds(601, 270, 140, 20);
        panel.add(btnPesquisa);

        btnGravar = new JButton("Pesquisar");
        btnGravar.setBounds(601, 310, 140, 20);
        panel.add(btnGravar);

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


