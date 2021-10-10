package tela;

import modelos.TrabalhoObj;
import modelos.WOO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Trabalho extends JFrame implements ActionListener, MouseListener {
    private JLabel labelNome, labelCragaHoraria, labelId,
            labelActualizacao, labelPesquisa, labelRemocao;
    private JTextField textNome, textId, textCargaHoraria,
            textCodigoActualizar, textCodigoRemover, textCriterioNome;
    private JButton  btnGravar, btnSair, btnActualizar,btnRemover,btnPesquisa;
    private JScrollPane scrollPane;
    private static DefaultTableModel model;
    private JTable table_2;
    static int id = 0;
    JLabel image;


    public static final String CADEIA = "cadeia";
    public static final String CADEIA_TRABALHO = "trabalho";
    public static final String TRABALHO_ID ="id";
    public static final String TRABALHO_NOME ="nome";
    public static final String TRABALHO_CARGA_HORARIA = "carga_horaria";

    public static final String STRING_LIGACAO = "jdbc:mysql://localhost:3306/cadeia";
    public static final String INSERIR_STRING_INICIAL = "INSERT INTO " + CADEIA + '.' + CADEIA_TRABALHO + "(" +
            TRABALHO_ID + ", " + TRABALHO_NOME + ", " + TRABALHO_CARGA_HORARIA + ")" + " VALUES (";

    public static final String ACTUALIZAR_TRABALHO_TEXTO_INICIAL = "UPDATE " + CADEIA + '.' + CADEIA_TRABALHO +
            " SET " + TRABALHO_NOME + " = ";

    public static final String ASPA_ESCAPADA = "\"";

    ArrayList<TrabalhoObj> trabalhos;



    public Trabalho() {
        this.setTitle("Trabalho");
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
        model.addColumn("nome");
        model.addColumn("carga_horaria");

        labelId = new JLabel("Id: ");
        labelId.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelId.setBounds(11, 60, 75, 23);
        panel.add(labelId);

        textId = new JTextField();
        textId.setBounds(120, 60, 90, 20);
        textId.setColumns(5);
        textId.setEditable(false);
        textId.setText(String.valueOf(id));
        panel.add(textId);

        labelNome = new JLabel("Nome: ");
        labelNome.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelNome.setBounds(11, 90, 75, 23);
        panel.add(labelNome);

        textNome = new JTextField();
        textNome.setBounds(120, 90, 200, 20);
        panel.add(textNome);
        textNome.setColumns(10);

        labelCragaHoraria = new JLabel("Carga_Horária: ");
        labelCragaHoraria.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelCragaHoraria.setBounds(11, 120, 95, 23);
        panel.add(labelCragaHoraria);

        textCargaHoraria = new JTextField();
        textCargaHoraria.setBounds(120, 120, 200, 20);
        panel.add(textCargaHoraria);
        textCargaHoraria.setColumns(10);



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

        textCodigoRemover = new JTextField();
        textCodigoRemover.setBounds(460, 370, 140, 20);
        textCodigoRemover.setColumns(10);
        textCodigoRemover.setToolTipText("Introduza o código");
        panel.add(textCodigoRemover);

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
        textCodigoRemover.addMouseListener(this);


        image = new JLabel("");
        image.setIcon(new ImageIcon("tela/segundafoto.jpeg"));
        image.setBounds(0, 0, 830, 700);
        panel.add(image);
        this.add(panel);


        this.setVisible(true);
        tabelar();
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGravar){
            int id = Integer.parseInt(textId.getText());
            String nome = textNome.getText();
            String carga_horaria = textCargaHoraria.getText();

            try (Connection connection = DriverManager.getConnection(STRING_LIGACAO, "root", WOO.WOO);
                 Statement statement = connection.createStatement()){
                StringBuilder sb = new StringBuilder(INSERIR_STRING_INICIAL);
                sb.append(ASPA_ESCAPADA + id + ASPA_ESCAPADA + ", ");
                sb.append(ASPA_ESCAPADA + nome + ASPA_ESCAPADA + ", ");
                sb.append(ASPA_ESCAPADA + carga_horaria + ASPA_ESCAPADA);
                sb.append(");");
                statement.execute(sb.toString());
                tabelar();


            }catch (Exception c){
                JOptionPane.showMessageDialog(this, "Falha " + c.getMessage());
            }

        }


        if (e.getSource() == btnActualizar){
            String nome = textNome.getText();
            String cargaHoraria = textCargaHoraria.getText();
            try {
                if (estaNaBaseDeDados(Integer.parseInt(textCodigoActualizar.getText()))>=0){
                    actualizar(textCodigoActualizar.getText(), nome, cargaHoraria);
                }
            }catch (Exception c){
                JOptionPane.showMessageDialog(this, "Não pode actualizar " + c.getMessage());
            }

        }

        if (e.getSource() == btnRemover){
            try {
                int idPorRemover = Integer.parseInt(textCodigoRemover.getText());
                if (estaNaBaseDeDados(idPorRemover)>0){
                    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadeia", "root", WOO.WOO);
                         Statement statement = connection.createStatement()){
                        String queryString = "DELETE FROM " + CADEIA + '.' + CADEIA_TRABALHO + " WHERE " + TRABALHO_ID + " = "
                                + idPorRemover + ";";
                         statement.execute(queryString);
                        JOptionPane.showMessageDialog(this, "Trabalho eliminado");
                        tabelar();
                    }catch (Exception a){
                        System.out.println("Falha ao remover " + a.getMessage());
                    }
                }else {
                    JOptionPane.showMessageDialog(this, "O trabalho não foi encontrado");
                }
            }catch (Exception c){
                JOptionPane.showMessageDialog(this, "Código invalido " + c.getMessage());
            }
        }

        if (e.getSource() == btnPesquisa){
            String nomePorPesquisar = textCriterioNome.getText();
            pesquisarPorNome(nomePorPesquisar);
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
            try {
                int id = estaNaBaseDeDados(Integer.parseInt(textCodigoActualizar.getText()));
                if (id>=0){
                    TrabalhoObj trabalho = pegarTrabalho(id);
                    textNome.setText(trabalho.getNome());
                    textCargaHoraria.setText(trabalho.getCarga_horaria());
                }else{
                    JOptionPane.showMessageDialog(this, "Não encontrado " +id);
                }
            }catch (Exception c){
                JOptionPane.showMessageDialog(this, "Não encontrado " + c.getMessage());
            }

        }
    }

    public void tabelar(){
        try (Connection connection = DriverManager.getConnection(STRING_LIGACAO, "root", WOO.WOO);
             Statement statement = connection.createStatement();){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + CADEIA_TRABALHO);
            trabalhos = new ArrayList<>();
            while (resultSet.next()){
                TrabalhoObj trabalhoObj = new TrabalhoObj();
                trabalhoObj.setId(resultSet.getInt(TRABALHO_ID));
                trabalhoObj.setNome(resultSet.getString(TRABALHO_NOME));
                trabalhoObj.setCarga_horaria(resultSet.getString(TRABALHO_CARGA_HORARIA));

                id = trabalhoObj.getId()>= id ? trabalhoObj.getId() + 1: id;
                trabalhos.add(trabalhoObj);
            }

            textId.setText(String.valueOf(id));

            for (int i= model.getRowCount(); 0<i; i--){
                model.removeRow(i-1);
            }

            for (TrabalhoObj trabalho:trabalhos){
                model.addRow(new Object[]{trabalho.getId(), trabalho.getNome(), trabalho.getCarga_horaria()});
            }

        } catch(Exception a) {
            System.out.println("Falha ao procurar dados " + a.getMessage());
            a.printStackTrace();
        }

    }

    public int estaNaBaseDeDados(int id){
        for (TrabalhoObj trabalho : trabalhos){
            if (trabalho.getId() == id){
                return trabalho.getId();
            }
        }
        return -1;
    }

    public TrabalhoObj pegarTrabalho(int id){
        for (TrabalhoObj trabalho : trabalhos){
            if (trabalho.getId() == id){
                return trabalho;
            }
        }
        return null;
    }

    private void actualizar(String id, String nome, String cargaHoraria) {
        StringBuilder sb = new StringBuilder(ACTUALIZAR_TRABALHO_TEXTO_INICIAL);
        sb.append(ASPA_ESCAPADA + nome + ASPA_ESCAPADA + ", ");
        sb.append(TRABALHO_CARGA_HORARIA + " = ");
        sb.append(ASPA_ESCAPADA + cargaHoraria + ASPA_ESCAPADA);
        sb.append("WHERE ");
        sb.append(TRABALHO_ID + " = ");
        sb.append(id + ";");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadeia", "root", WOO.WOO);
             Statement statement = connection.createStatement()){
             statement.execute(sb.toString());
             tabelar();
        }catch (Exception e){
            System.out.println("Falha ao actualizar " + e.getMessage());
            e.printStackTrace();
        }

    }

    private void pesquisarPorNome(String nome){
        String queryString = "SELECT * FROM " + CADEIA + '.' + CADEIA_TRABALHO + " WHERE " +
                TRABALHO_NOME + " LIKE " + ASPA_ESCAPADA + "%" + nome + "%" + ASPA_ESCAPADA + ";";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadeia", "root", WOO.WOO);
             Statement statement = connection.createStatement()){
             ResultSet resultSet = statement.executeQuery(queryString);

             ArrayList<TrabalhoObj> trabalhoObjs = new ArrayList<>();

             while (resultSet.next()){
                 TrabalhoObj trabalhoObj = new TrabalhoObj();
                 trabalhoObj.setId(resultSet.getInt(TRABALHO_ID));
                 trabalhoObj.setNome(resultSet.getString(TRABALHO_NOME));
                 trabalhoObj.setCarga_horaria(resultSet.getString(TRABALHO_CARGA_HORARIA));
                 trabalhoObjs.add(trabalhoObj);
             }

            for (int i= model.getRowCount(); 0<i; i--){
                model.removeRow(i-1);
            }

            for (TrabalhoObj trabalho:trabalhoObjs){
                model.addRow(new Object[]{trabalho.getId(), trabalho.getNome(), trabalho.getCarga_horaria()});
            }

        }catch (Exception e){
            System.out.println("Falha ao actualizar " + e.getMessage());
            e.printStackTrace();
        }
    }
}
