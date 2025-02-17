package view;
import model.dao.ClienteDaoInterface;
import model.dao.DAOFactory;
import model.dao.entities.Cliente;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPrincipal extends JFrame implements ActionListener {

    private ImageIcon imgTelaPrimaria, imgTelaSecundaria;
    private JButton buttonCadastrar, buttonPedidos, buttonAdministrativo, buttonSair;
    private JButton buttonCadastro, buttonVoltar, buttonBuscar, buttonPesquisar;
    private JButton buttonAtualizar, buttonRemoverCli, buttonAlterar, buscarRemover;
    private JTextField fieldNome, fieldCpf, fieldFone, fieldCpfPesq, fieldCpfRemocao;
    private JTextField fieldNomeCliente, fieldCpfCliente, fieldFoneCliente;
    private JTextField fieldNomeUpdate, fieldCpfUpdate, fieldFoneUpdate;
    private JTextField fieldRemocao, fieldRemocao2, fieldRemocao3;
    private JLabel labelCadastro, labelPesquisa, labelTelaPrimaria, labelAdm;
    private JLabel labelTelaSecundaria;
    private UIManager uiManager;
    private Integer idRemove;
    private String cpfRemove;
    private Font fonte;

    public JanelaPrincipal() throws HeadlessException {
        setLayout(null);
        setTitle("GoodFood");//TITULO DA JANELA
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ENCERRAMENTO DA APLICAÇÃO AO FECHAR A JANELA X
        setLocationRelativeTo(null);//LOCALIZAÇÃO DA JANELA NA TELA
        setResizable(true);
        setVisible(true);//VISIBILIDADE JANELA
        getContentPane().setBackground(Color.BLACK);
        setExtendedState(MAXIMIZED_BOTH);
        uiManager.put("OptionPane.minimumSize", new Dimension(350, 50));
        uiManager.put("OptionPane.messageFont", new FontUIResource(new Font("Serif", Font.ITALIC|Font.BOLD, 30)));
        uiManager.put("Panel.background", Color.black);
        uiManager.put("OptionPane.messageForeground", Color.white);
        fonte = new Font("Serif",Font.BOLD | Font.ITALIC,31);
    }

    public void telaPrimaria(){

        buttonCadastrar = new JButton("Cadastrar");
        add(buttonCadastrar);
        buttonCadastrar.setBounds(255,705,130,30);
        buttonCadastrar.addActionListener(this);

        buttonPedidos = new JButton("Pedidos");
        add(buttonPedidos);
        buttonPedidos.setBounds(465,705,130,30);
        buttonPedidos.addActionListener(this);

        buttonPesquisar = new JButton("Pesquisar");
        add(buttonPesquisar);
        buttonPesquisar.setBounds(675,705,130,30);
        buttonPesquisar.addActionListener(this);

        buttonAdministrativo = new JButton("Administrativo");
        add(buttonAdministrativo);
        buttonAdministrativo.setBounds(890,705,130,30);
        buttonAdministrativo.addActionListener(this);

        buttonSair = new JButton("Sair");
        add(buttonSair);
        buttonSair.setBounds(1100,705,130,30);
        buttonSair.addActionListener(this);

        imgTelaPrimaria = new ImageIcon(getClass().getResource("telaPrimaria.jpeg"));
        labelTelaPrimaria = new JLabel(imgTelaPrimaria);
        add(labelTelaPrimaria);
        labelTelaPrimaria.setBounds(100,0,1280,959);
    }
    public void telaCadastro() {

        buttonCadastro = new JButton("Cadastrar");
        add(buttonCadastro);
        buttonCadastro.setBounds(255,705,130,30);
        buttonCadastro.addActionListener(this);

        buttonVoltar = new JButton("Voltar");
        add(buttonVoltar);
        buttonVoltar.setBounds(1100, 705, 130, 30);
        buttonVoltar.addActionListener(this);

        labelCadastro = new JLabel("Preencha seus dados cadastrais");
        labelCadastro.setForeground(Color.WHITE);
        add(labelCadastro);
        labelCadastro.setBounds(120, 60, 500, 115);
        labelCadastro.setFont(fonte);

        labelCadastro = new JLabel("Nome:");
        labelCadastro.setForeground(Color.WHITE);
        add(labelCadastro);
        labelCadastro.setBounds(20,20,380,750);
        labelCadastro.setFont(fonte);

        fieldNome = new JTextField(30);
        add(fieldNome);
        fieldNome.setBounds(120,382,420,30);
        fieldNome.setFont(fonte);

        labelCadastro = new JLabel("Cpf:");
        labelCadastro.setForeground(Color.WHITE);
        add(labelCadastro);
        labelCadastro.setBounds(20,60,380,850);
        labelCadastro.setFont(fonte);

        fieldCpf = new JTextField(30);
        add(fieldCpf);
        fieldCpf.setBounds(120,471,420,30);
        fieldCpf.setFont(fonte);

        labelCadastro = new JLabel("Fone:");
        labelCadastro.setForeground(Color.WHITE);
        add(labelCadastro);
        labelCadastro.setBounds(20,90,380,950);
        labelCadastro.setFont(fonte);

        fieldFone = new JTextField(30);
        add(fieldFone);
        fieldFone.setBounds(120,550,420,30);
        fieldFone.setFont(fonte);

        imgTelaSecundaria = new ImageIcon(getClass().getResource("telaSecundaria.jpeg"));
        labelTelaSecundaria = new JLabel(imgTelaSecundaria);
        add(labelTelaSecundaria);
        labelTelaSecundaria.setBounds(100, 0, 1280, 959);
    }
    public void telaPesquisa(){

        buttonBuscar = new JButton("Buscar");
        add(buttonBuscar);
        buttonBuscar.setBounds(255,705,130,30);
        buttonBuscar.addActionListener(this);

        buttonVoltar = new JButton("Voltar");
        add(buttonVoltar);
        buttonVoltar.setBounds(1100, 705, 130, 30);
        buttonVoltar.addActionListener(this);

        labelPesquisa = new JLabel("Preencha o cpf do cliente");
        labelPesquisa.setForeground(Color.WHITE);
        add(labelPesquisa);
        labelPesquisa.setBounds(120, 60, 500, 115);
        labelPesquisa.setFont(fonte);

        labelPesquisa = new JLabel("Cpf:");
        labelPesquisa.setForeground(Color.WHITE);
        add(labelPesquisa);
        labelPesquisa.setBounds(70,20,380,750);
        labelPesquisa.setFont(fonte);

        imgTelaSecundaria = new ImageIcon(getClass().getResource("telaSecundaria.jpeg"));
        labelTelaSecundaria = new JLabel(imgTelaSecundaria);
        add(labelTelaSecundaria);
        labelTelaSecundaria.setBounds(100, 0, 1280, 959);

        fieldCpfPesq = new JTextField(30);
        add(fieldCpfPesq);
        fieldCpfPesq.setBounds(150,382,420,30);
        fieldCpfPesq.setFont(fonte);
    }
    public void telaBusca(String cpfBusca){

        buttonVoltar = new JButton("Voltar");
        add(buttonVoltar);
        buttonVoltar.setBounds(1100, 705, 130, 30);
        buttonVoltar.addActionListener(this);

        labelPesquisa = new JLabel("Resultado da busca do cliente");
        labelPesquisa.setForeground(Color.WHITE);
        add(labelPesquisa);
        labelPesquisa.setBounds(120, 60, 500, 115);
        labelPesquisa.setFont(fonte);

        ClienteDaoInterface clientes = DAOFactory.createClienteDao();
        Cliente cliente;
        cliente = clientes.pesquisar(cpfBusca);

        fieldNomeCliente = new JTextField("Nome: " + cliente.getNome(),30);
        fieldNomeCliente.setForeground(Color.WHITE);
        fieldNomeCliente.setBackground(Color.BLACK);
        fieldNomeCliente.setEditable(false);
        add(fieldNomeCliente);
        fieldNomeCliente.setBounds(70, 400, 500, 40);
        fieldNomeCliente.setFont(fonte);

        fieldCpfCliente = new JTextField("Cpf: " + cliente.getCpf(),30);
        fieldCpfCliente.setForeground(Color.WHITE);
        fieldCpfCliente.setBackground(Color.BLACK);
        fieldCpfCliente.setEditable(false);
        add(fieldCpfCliente);
        fieldCpfCliente.setBounds(70, 450, 500, 40);
        fieldCpfCliente.setFont(fonte);

        fieldFoneCliente = new JTextField("Fone: " + cliente.getTelefone(),30);
        fieldFoneCliente.setForeground(Color.WHITE);
        fieldFoneCliente.setBackground(Color.BLACK);
        fieldFoneCliente.setEditable(false);
        add(fieldFoneCliente);
        fieldFoneCliente.setBounds(70, 500, 500, 40);
        fieldFoneCliente.setFont(fonte);

        imgTelaSecundaria = new ImageIcon(getClass().getResource("telaSecundaria.jpeg"));
        labelTelaSecundaria = new JLabel(imgTelaSecundaria);
        add(labelTelaSecundaria);
        labelTelaSecundaria.setBounds(100, 0, 1280, 959);
    }
    public void telaAdm() {

        buttonAtualizar = new JButton("Atualizar dados cliente");
        add(buttonAtualizar);
        buttonAtualizar.setBounds(255,705,230,30);
        buttonAtualizar.addActionListener(this);

        buttonRemoverCli = new JButton("Remover cliente");
        add(buttonRemoverCli);
        buttonRemoverCli.setBounds(680,705,230,30);
        buttonRemoverCli.addActionListener(this);

        buttonVoltar = new JButton("Voltar");
        add(buttonVoltar);
        buttonVoltar.setBounds(1100, 705, 230, 30);
        buttonVoltar.addActionListener(this);

        labelAdm = new JLabel("Restrito ao setor administrativo");
        labelAdm.setForeground(Color.WHITE);
        add(labelAdm);
        labelAdm.setBounds(120, 60, 500, 115);
        labelAdm.setFont(fonte);

        imgTelaSecundaria = new ImageIcon(getClass().getResource("telaSecundaria.jpeg"));
        labelTelaSecundaria = new JLabel(imgTelaSecundaria);
        add(labelTelaSecundaria);
        labelTelaSecundaria.setBounds(100, 0, 1280, 959);
    }
    public void buscaAtualizacao(){

        buttonAlterar = new JButton("Alterar");
        add(buttonAlterar);
        buttonAlterar.setBounds(255,705,130,30);
        buttonAlterar.addActionListener(this);

        buttonVoltar = new JButton("Voltar");
        add(buttonVoltar);
        buttonVoltar.setBounds(1100, 705, 130, 30);
        buttonVoltar.addActionListener(this);

        labelAdm = new JLabel("Restrito ao setor administrativo");
        labelAdm.setForeground(Color.WHITE);
        add(labelAdm);
        labelAdm.setBounds(135, 60, 500, 115);
        labelAdm.setFont(fonte);

        labelAdm = new JLabel("Digite o cpf para alterar os dados");
        labelAdm.setForeground(Color.WHITE);
        add(labelAdm);
        labelAdm.setBounds(120, 110, 500, 115);
        labelAdm.setFont(fonte);

        labelAdm = new JLabel("Nome:");
        labelAdm.setForeground(Color.WHITE);
        add(labelAdm);
        labelAdm.setBounds(20,110,380,750);
        labelAdm.setFont(fonte);

        fieldNomeUpdate = new JTextField(30);
        add(fieldNomeUpdate);
        fieldNomeUpdate.setBounds(120,471,420,30);
        fieldNomeUpdate.setFont(fonte);

        labelAdm = new JLabel("Cpf:");
        labelAdm.setForeground(Color.WHITE);
        add(labelAdm);
        labelAdm.setBounds(20,-30,380,850);
        labelAdm.setFont(fonte);

        fieldCpfUpdate = new JTextField(30);
        add(fieldCpfUpdate);
        fieldCpfUpdate.setBounds(120,382,420,30);
        fieldCpfUpdate.setFont(fonte);

        labelAdm = new JLabel("Fone:");
        labelAdm.setForeground(Color.WHITE);
        add(labelAdm);
        labelAdm.setBounds(20,90,380,950);
        labelAdm.setFont(fonte);

        fieldFoneUpdate = new JTextField(30);
        add(fieldFoneUpdate);
        fieldFoneUpdate.setBounds(120,550,420,30);
        fieldFoneUpdate.setFont(fonte);

        imgTelaSecundaria = new ImageIcon(getClass().getResource("telaSecundaria.jpeg"));
        labelTelaSecundaria = new JLabel(imgTelaSecundaria);
        add(labelTelaSecundaria);
        labelTelaSecundaria.setBounds(100, 0, 1280, 959);
    }
    public void telaRemove(){
        idRemove = 0;

        buscarRemover = new JButton("Remover");
        add(buscarRemover);
        buscarRemover.setBounds(255,705,130,30);
        buscarRemover.addActionListener(this);

        buttonVoltar = new JButton("Voltar");
        add(buttonVoltar);
        buttonVoltar.setBounds(1100, 705, 130, 30);
        buttonVoltar.addActionListener(this);

        labelAdm = new JLabel("Restrito ao setor administrativo");
        labelAdm.setForeground(Color.WHITE);
        add(labelAdm);
        labelAdm.setBounds(120, 60, 500, 115);
        labelAdm.setFont(fonte);

        labelAdm = new JLabel("Cpf:");
        labelAdm.setForeground(Color.WHITE);
        add(labelAdm);
        labelAdm.setBounds(70,20,380,750);
        labelAdm.setFont(fonte);

        imgTelaSecundaria = new ImageIcon(getClass().getResource("telaSecundaria.jpeg"));
        labelTelaSecundaria = new JLabel(imgTelaSecundaria);
        add(labelTelaSecundaria);
        labelTelaSecundaria.setBounds(100, 0, 1280, 959);

        fieldCpfRemocao = new JTextField(30);
        add(fieldCpfRemocao);
        fieldCpfRemocao.setBounds(140,382,420,30);
        fieldCpfRemocao.setFont(fonte);
        String cpfRemocao = fieldCpfRemocao.getText();
        cpfRemove = cpfRemocao;
    }
    public void telaRemocao(String cpfRemocao){

        buttonVoltar = new JButton("Voltar");
        add(buttonVoltar);
        buttonVoltar.setBounds(1100, 705, 130, 30);
        buttonVoltar.addActionListener(this);

        labelAdm = new JLabel("Cliente removido do sistema");
        labelAdm.setForeground(Color.WHITE);
        add(labelAdm);
        labelAdm.setBounds(120, 60, 500, 115);
        labelAdm.setFont(fonte);

        ClienteDaoInterface clientes = DAOFactory.createClienteDao();
        Cliente cliente;
        cliente = clientes.pesquisar(cpfRemocao);

        fieldRemocao = new JTextField("Nome: " + cliente.getNome(),30);
        fieldRemocao.setForeground(Color.WHITE);
        fieldRemocao.setBackground(Color.BLACK);
        fieldRemocao.setEditable(false);
        add(fieldRemocao);
        fieldRemocao.setBounds(70, 400, 500, 40);
        fieldRemocao.setFont(fonte);

        fieldRemocao2 = new JTextField("Cpf: " + cliente.getCpf(),30);
        fieldRemocao2.setForeground(Color.WHITE);
        fieldRemocao2.setBackground(Color.BLACK);
        fieldRemocao2.setEditable(false);
        add(fieldRemocao2);
        fieldRemocao2.setBounds(70, 450, 500, 40);
        fieldRemocao2.setFont(fonte);

        fieldRemocao3 = new JTextField("Fone: " + cliente.getTelefone(),30);
        fieldRemocao3.setForeground(Color.WHITE);
        fieldRemocao3.setBackground(Color.BLACK);
        fieldRemocao3.setEditable(false);
        add(fieldRemocao3);
        fieldRemocao3.setBounds(70, 500, 500, 40);
        fieldRemocao3.setFont(fonte);

        imgTelaSecundaria = new ImageIcon(getClass().getResource("telaSecundaria.jpeg"));
        labelTelaSecundaria = new JLabel(imgTelaSecundaria);
        add(labelTelaSecundaria);
        labelTelaSecundaria.setBounds(100, 0, 1280, 959);
    }
    public static void main(String[] args) {
        JanelaPrincipal j = new JanelaPrincipal();
        j.telaPrimaria();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JanelaPrincipal jnl = null;
        if (e.getSource() == buttonCadastrar){
            jnl = new JanelaPrincipal();
            jnl.telaCadastro();
        }
        else if (e.getSource() == buttonPesquisar) {
            jnl = new JanelaPrincipal();
            jnl.telaPesquisa();
        }
        else if (e.getSource() == buttonSair){
            System.exit(0);
        }
        else if (e.getSource() == buttonVoltar){
            jnl = new JanelaPrincipal();
            jnl.telaPrimaria();
        }
        else if (e.getSource() == buttonCadastro){
            String nome = fieldNome.getText();
            String cpf = fieldCpf.getText();
            String fone = fieldFone.getText();

            if (nome.equals("") || cpf.equals("") || fone.equals("")){
                JOptionPane.showMessageDialog(null,"Cadastro não efetuado!\n" +
                        "Preencha os todos os campos\n" +
                        "e os dados corretamente!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso.");
                ClienteDaoInterface clientes = DAOFactory.createClienteDao();
                Cliente cliente = new Cliente();
                cliente.setNome(nome);
                cliente.setCpf(cpf);
                cliente.setTelefone(fone);
                clientes.inserir(cliente);
                jnl = new JanelaPrincipal();
                jnl.telaPrimaria();
            }
        }
        else if (e.getSource() == buttonBuscar){
            String cpfPesq = fieldCpfPesq.getText();
            jnl = new JanelaPrincipal();
            jnl.telaBusca(cpfPesq);
        }
        else if (e.getSource() == buttonAdministrativo){
            jnl = new JanelaPrincipal();
            jnl.telaAdm();
        }
        else if (e.getSource() == buttonAtualizar) {
            jnl = new JanelaPrincipal();
            jnl.buscaAtualizacao();
        }
        else if (e.getSource() == buttonAlterar){
            ClienteDaoInterface clientes = DAOFactory.createClienteDao();
            Cliente cliente;
            String textoCaixaCpf = fieldCpfUpdate.getText();
            cliente = clientes.pesquisar(textoCaixaCpf);
            String nome = fieldNomeUpdate.getText();
            if (nome.equals("")) {
            } else {
                cliente.setNome(nome);
            }
            String fone = fieldFoneUpdate.getText();
            if (fone.equals("")) {

            } else {
                cliente.setTelefone(fone);
            }
            clientes.atualizar(cliente);
            jnl = new JanelaPrincipal();
            jnl.telaPrimaria();
        }
        else if (e.getSource() == buttonRemoverCli){
            jnl = new JanelaPrincipal();
            jnl.telaRemove();
        }
        else if (e.getSource() == buscarRemover){
            ClienteDaoInterface clientes = DAOFactory.createClienteDao();
            String textoCaixaRemover = fieldCpfRemocao.getText();
            jnl = new JanelaPrincipal();
            jnl.telaRemocao(textoCaixaRemover);
            clientes.remover(textoCaixaRemover);
        }
        else if (e.getSource() == buttonPedidos){
            JanelaPedidos janPed = new JanelaPedidos();
            janPed.telaPedido();
        }
    }
}
