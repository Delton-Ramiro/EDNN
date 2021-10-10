package tela;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Visita extends JFrame implements ActionListener, MouseListener {
    private JLabel labelTipo, labelDataNascimento, labelId,
            labelHoraInicio, labelHoraTermino,
            labelActualizacao, labelPesquisa, labelRemocao;
    private JTextField textTipo, textId,textDataNascimento, textHoraInicio, textHoraTermino,
            textCodigoActualizar, textCodigoEliminar, textCriterioNome;
    private JButton  btnGravar, btnSair, btnActualizar,btnRemover,btnPesquisa;
    private JScrollPane scrollPane;
    private static DefaultTableModel model;
    private JTable table_2;
    static int iteracaoSalvamento = 1;
    JLabel image;


    public Visita() {
        this.setTitle("Visita");
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
        model.addColumn("tipo");
        model.addColumn("data");
        model.addColumn("hora_inicio");
        model.addColumn("hora_fim");

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

        labelTipo = new JLabel("Tipo: ");
        labelTipo.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelTipo.setBounds(11, 90, 75, 23);
        panel.add(labelTipo);

        textTipo = new JTextField();
        textTipo.setBounds(80, 90, 200, 20);
        panel.add(textTipo);
        textTipo.setColumns(10);

        labelDataNascimento = new JLabel("Data: ");
        labelDataNascimento.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelDataNascimento.setBounds(11, 120, 75, 23);
        panel.add(labelDataNascimento);

        textDataNascimento = new JTextField();
        textDataNascimento.setBounds(80, 120, 200, 20);
        panel.add(textDataNascimento);
        textDataNascimento.setColumns(10);


        labelHoraInicio = new JLabel("Hora_Inicio ");
        labelHoraInicio.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelHoraInicio.setBounds(11, 150, 75, 23);
        panel.add(labelHoraInicio);

        textHoraInicio = new JTextField();
        textHoraInicio.setBounds(80, 150, 200, 20);
        textHoraInicio.setColumns(10);
        panel.add(textHoraInicio);

        labelHoraTermino = new JLabel("Hora_Termino: ");
        labelHoraTermino.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelHoraTermino.setBounds(11, 180, 75, 23);
        panel.add(labelHoraTermino);

        textHoraTermino = new JTextField();
        textHoraTermino.setBounds(80, 180, 200, 20);
        textHoraTermino.setColumns(10);
        panel.add(textHoraTermino);


        btnGravar = new JButton("Gravar");
        btnGravar.setBounds(100, 340, 150, 20);
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
