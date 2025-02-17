package view;
import model.dao.CardapioDaoInterface;
import model.dao.DAOFactory;
import model.dao.PedidoDaoInterface;
import model.dao.entities.Cardapio;
import model.dao.entities.Pedido;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class JanelaPedidos extends JFrame implements ActionListener {

    private JButton buttonFazer, buttonExcluir, buttonVoltar, buttonConfirmar, buttonRemover;
    private JLabel labelPedido, labelTelaSecundaria;
    private JTextField fieldCpf, fieldPedido, fieldIdPedidoRem;
    private JRadioButton mussarela, calabresa, frango, portuguesa, brigadeiro, refrigerante2L;
    private JRadioButton mussarelaCombo, calabresaCombo, frangoCombo, portuguesaCombo, brigadeiroCombo;
    private ButtonGroup grupo;
    private ImageIcon imgTelaPrimaria;
    private Font fonte;

    public JanelaPedidos() throws HeadlessException {
        setLayout(null);
        setTitle("GoodFood");//TITULO DA JANELA
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ENCERRAMENTO DA APLICAÇÃO AO FECHAR A JANELA X
        setLocationRelativeTo(null);//LOCALIZAÇÃO DA JANELA NA TELA
        setResizable(true);
        setVisible(true);//VISIBILIDADE JANELA
        getContentPane().setBackground(Color.BLACK);
        setExtendedState(MAXIMIZED_BOTH);
        fonte = new Font("Serif",Font.BOLD | Font.ITALIC,31);
    }

    public void telaPedido(){

        buttonFazer = new JButton("Fazer pedido");
        add(buttonFazer);
        buttonFazer.setBounds(255,705,230,30);
        buttonFazer.addActionListener(this);

        buttonExcluir = new JButton("Remover pedido");
        add(buttonExcluir);
        buttonExcluir.setBounds(680,705,230,30);
        buttonExcluir.addActionListener(this);

        buttonVoltar = new JButton("Voltar");
        add(buttonVoltar);
        buttonVoltar.setBounds(1100, 705, 230, 30);
        buttonVoltar.addActionListener(this);

        labelPedido = new JLabel("Restrito ao setor administrativo");
        labelPedido.setForeground(Color.WHITE);
        add(labelPedido);
        labelPedido.setBounds(120, 60, 500, 115);
        labelPedido.setFont(fonte);

        imgTelaPrimaria = new ImageIcon(getClass().getResource("telaSecundaria.jpeg"));
        labelTelaSecundaria = new JLabel(imgTelaPrimaria);
        add(labelTelaSecundaria);
        labelTelaSecundaria.setBounds(100, 0, 1280, 959);
    }
    public void telaFazerPedido(){

        buttonConfirmar = new JButton("Confirmar pedido");
        add(buttonConfirmar);
        buttonConfirmar.setBounds(255,705,230,30);
        buttonConfirmar.addActionListener(this);

        buttonVoltar = new JButton("Voltar");
        add(buttonVoltar);
        buttonVoltar.setBounds(1100, 705, 230, 30);
        buttonVoltar.addActionListener(this);

        labelPedido = new JLabel("Cpf:");
        labelPedido.setForeground(Color.WHITE);
        add(labelPedido);
        labelPedido.setBounds(900,35,380,750);
        labelPedido.setFont(fonte);

        fieldCpf = new JTextField(30);
        add(fieldCpf);
        fieldCpf.setBounds(970,402,380,30);
        fieldCpf.setFont(fonte);

        labelPedido = new JLabel("Pedido");
        labelPedido.setForeground(Color.WHITE);
        add(labelPedido);
        labelPedido.setBounds(1100, 300, 500, 115);
        labelPedido.setFont(fonte);

        labelPedido = new JLabel("Cardápio");
        labelPedido.setForeground(Color.WHITE);
        add(labelPedido);
        labelPedido.setBounds(235, 10, 500, 115);
        labelPedido.setFont(fonte);

        CardapioDaoInterface cardapios = DAOFactory.createCardapioDao();
        Cardapio cardapio = new Cardapio();

        cardapio.setCodigo("MUSSA");
        cardapio = cardapios.pesquisar(cardapio.getCodigo());
        mussarela = new JRadioButton("Pizza Mussarela         -             R$" + cardapio.getValor());
        mussarela.setForeground(Color.WHITE);
        mussarela.setBackground(Color.BLACK);
        mussarela.setFont(fonte);
        mussarela.setBounds(80,150,550,50);

        cardapio.setCodigo("CALAB");
        cardapio = cardapios.pesquisar(cardapio.getCodigo());
        calabresa = new JRadioButton("Pizza Calabresa          -             R$"+ cardapio.getValor());
        calabresa.setForeground(Color.WHITE);
        calabresa.setBackground(Color.BLACK);
        calabresa.setFont(fonte);
        calabresa.setBounds(80,200,550,50);

        cardapio.setCodigo("FRANG");
        cardapio = cardapios.pesquisar(cardapio.getCodigo());
        frango = new JRadioButton("Pizza Frango              -             R$"+ cardapio.getValor());
        frango.setForeground(Color.WHITE);
        frango.setBackground(Color.BLACK);
        frango.setFont(fonte);
        frango.setBounds(80,250,550,50);

        cardapio.setCodigo("PORT");
        cardapio = cardapios.pesquisar(cardapio.getCodigo());
        portuguesa = new JRadioButton("Pizza Portuguesa        -             R$"+ cardapio.getValor());
        portuguesa.setForeground(Color.WHITE);
        portuguesa.setBackground(Color.BLACK);
        portuguesa.setFont(fonte);
        portuguesa.setBounds(80,300,550,50);

        cardapio.setCodigo("BRIG");
        cardapio = cardapios.pesquisar(cardapio.getCodigo());
        brigadeiro = new JRadioButton("Pizza Brigadeiro         -             R$"+ cardapio.getValor());
        brigadeiro.setForeground(Color.WHITE);
        brigadeiro.setBackground(Color.BLACK);
        brigadeiro.setFont(fonte);
        brigadeiro.setBounds(80,350,550,50);

        cardapio.setCodigo("REFR2L");
        cardapio = cardapios.pesquisar(cardapio.getCodigo());
        refrigerante2L = new JRadioButton("Refrigerante 2L          -             R$"+ cardapio.getValor());
        refrigerante2L.setForeground(Color.WHITE);
        refrigerante2L.setBackground(Color.BLACK);
        refrigerante2L.setFont(fonte);
        refrigerante2L.setBounds(80,400,550,50);

        add(mussarela);
        add(calabresa);
        add(frango);
        add(portuguesa);
        add(brigadeiro);
        add(refrigerante2L);

        grupo = new ButtonGroup();
        grupo.add(mussarela);
        grupo.add(calabresa);
        grupo.add(frango);
        grupo.add(portuguesa);
        grupo.add(brigadeiro);
        grupo.add(refrigerante2L);

        cardapio.setCodigo("MUSSACOMB");
        cardapio = cardapios.pesquisar(cardapio.getCodigo());
        mussarelaCombo = new JRadioButton("Pizza Mussarela + Refri 2L   - R$"+ cardapio.getValor());
        mussarelaCombo.setForeground(Color.WHITE);
        mussarelaCombo.setBackground(Color.BLACK);
        mussarelaCombo.setFont(fonte);
        mussarelaCombo.setBounds(80,450,550,50);

        cardapio.setCodigo("CALABCOMB");
        cardapio = cardapios.pesquisar(cardapio.getCodigo());
        calabresaCombo = new JRadioButton("Pizza Calabresa + Refri 2L   - R$"+ cardapio.getValor());
        calabresaCombo.setForeground(Color.WHITE);
        calabresaCombo.setBackground(Color.BLACK);
        calabresaCombo.setFont(fonte);
        calabresaCombo.setBounds(80,500,550,50);

        cardapio.setCodigo("FRANGCOMB");
        cardapio = cardapios.pesquisar(cardapio.getCodigo());
        frangoCombo = new JRadioButton("Pizza Frango + Refri 2L       -  R$"+ cardapio.getValor());
        frangoCombo.setForeground(Color.WHITE);
        frangoCombo.setBackground(Color.BLACK);
        frangoCombo.setFont(fonte);
        frangoCombo.setBounds(80,550,550,50);

        cardapio.setCodigo("PORTCOMB");
        cardapio = cardapios.pesquisar(cardapio.getCodigo());
        portuguesaCombo = new JRadioButton("Pizza Portuguesa + Refri 2L -  R$"+ cardapio.getValor());
        portuguesaCombo.setForeground(Color.WHITE);
        portuguesaCombo.setBackground(Color.BLACK);
        portuguesaCombo.setFont(fonte);
        portuguesaCombo.setBounds(80,600,550,50);

        cardapio.setCodigo("BRIGCOMB");
        cardapio = cardapios.pesquisar(cardapio.getCodigo());
        brigadeiroCombo = new JRadioButton("Pizza Brigadeiro + Refri 2L  -  R$"+ cardapio.getValor());
        brigadeiroCombo.setForeground(Color.WHITE);
        brigadeiroCombo.setBackground(Color.BLACK);
        brigadeiroCombo.setFont(fonte);
        brigadeiroCombo.setBounds(80,650,550,50);

        add(mussarelaCombo);
        add(calabresaCombo);
        add(frangoCombo);
        add(portuguesaCombo);
        add(brigadeiroCombo);

        grupo.add(mussarelaCombo);
        grupo.add(calabresaCombo);
        grupo.add(frangoCombo);
        grupo.add(portuguesaCombo);
        grupo.add(brigadeiroCombo);

        imgTelaPrimaria = new ImageIcon(getClass().getResource("telaSecundaria.jpeg"));
        labelTelaSecundaria = new JLabel(imgTelaPrimaria);
        add(labelTelaSecundaria);
        labelTelaSecundaria.setBounds(100, 0, 1280, 959);
    }
    public void telaPedidoConfirmado(Integer idPedido, String escolha){

        buttonVoltar = new JButton("Voltar");
        add(buttonVoltar);
        buttonVoltar.setBounds(1100, 705, 130, 30);
        buttonVoltar.addActionListener(this);

        labelPedido = new JLabel("Dados do pedido");
        labelPedido.setForeground(Color.WHITE);
        add(labelPedido);
        labelPedido.setBounds(120, 60, 500, 115);
        labelPedido.setFont(fonte);

        PedidoDaoInterface pedidos = DAOFactory.createPedidoDao();
        Pedido pedido;
        pedido = pedidos.pesquisar(idPedido);

        fieldPedido = new JTextField("Id: " + pedido.getId_pedido(),30);
        fieldPedido.setForeground(Color.WHITE);
        fieldPedido.setBackground(Color.BLACK);
        fieldPedido.setEditable(false);
        add(fieldPedido);
        fieldPedido.setBounds(70, 400, 500, 40);
        fieldPedido.setFont(fonte);

        fieldPedido = new JTextField("Cpf: " + pedido.getFk_cpf(),30);
        fieldPedido.setForeground(Color.WHITE);
        fieldPedido.setBackground(Color.BLACK);
        fieldPedido.setEditable(false);
        add(fieldPedido);
        fieldPedido.setBounds(70, 450, 500, 40);
        fieldPedido.setFont(fonte);

        fieldPedido = new JTextField("Codigo cardápio: " + pedido.getFk_codigo(),30);
        fieldPedido.setForeground(Color.WHITE);
        fieldPedido.setBackground(Color.BLACK);
        fieldPedido.setEditable(false);
        add(fieldPedido);
        fieldPedido.setBounds(70, 500, 500, 40);
        fieldPedido.setFont(fonte);

        fieldPedido = new JTextField("Valor total: " + pedido.getTotal_compra(),30);
        fieldPedido.setForeground(Color.WHITE);
        fieldPedido.setBackground(Color.BLACK);
        fieldPedido.setEditable(false);
        add(fieldPedido);
        fieldPedido.setBounds(70, 650, 500, 40);
        fieldPedido.setFont(fonte);

        fieldPedido = new JTextField("Data: " + pedido.getData(),30);
        fieldPedido.setForeground(Color.WHITE);
        fieldPedido.setBackground(Color.BLACK);
        fieldPedido.setEditable(false);
        add(fieldPedido);
        fieldPedido.setBounds(70, 600, 500, 40);
        fieldPedido.setFont(fonte);

        fieldPedido = new JTextField("Prato: " + escolha,30);
        fieldPedido.setForeground(Color.WHITE);
        fieldPedido.setBackground(Color.BLACK);
        fieldPedido.setEditable(false);
        add(fieldPedido);
        fieldPedido.setBounds(70, 550, 500, 40);
        fieldPedido.setFont(fonte);

        imgTelaPrimaria = new ImageIcon(getClass().getResource("telaSecundaria.jpeg"));
        labelTelaSecundaria = new JLabel(imgTelaPrimaria);
        add(labelTelaSecundaria);
        labelTelaSecundaria.setBounds(100, 0, 1280, 959);
    }
    public void telaRemovePedido(){

        buttonRemover = new JButton("Remover");
        add(buttonRemover);
        buttonRemover.setBounds(255,705,130,30);
        buttonRemover.addActionListener(this);

        buttonVoltar = new JButton("Voltar");
        add(buttonVoltar);
        buttonVoltar.setBounds(1100, 705, 130, 30);
        buttonVoltar.addActionListener(this);

        labelPedido = new JLabel("Restrito ao setor administrativo");
        labelPedido.setForeground(Color.WHITE);
        add(labelPedido);
        labelPedido.setBounds(120, 60, 500, 115);
        labelPedido.setFont(fonte);

        labelPedido = new JLabel("Id pedido:");
        labelPedido.setForeground(Color.WHITE);
        add(labelPedido);
        labelPedido.setBounds(70,20,380,750);
        labelPedido.setFont(fonte);

        imgTelaPrimaria = new ImageIcon(getClass().getResource("telaSecundaria.jpeg"));
        labelTelaSecundaria = new JLabel(imgTelaPrimaria);
        add(labelTelaSecundaria);
        labelTelaSecundaria.setBounds(100, 0, 1280, 959);

        fieldIdPedidoRem = new JTextField(30);
        add(fieldIdPedidoRem);
        fieldIdPedidoRem.setBounds(210,382,420,30);
        fieldIdPedidoRem.setFont(fonte);
    }
    public void telaRemocao(Integer idPedido){

        buttonVoltar = new JButton("Voltar");
        add(buttonVoltar);
        buttonVoltar.setBounds(1100, 705, 130, 30);
        buttonVoltar.addActionListener(this);

        labelPedido = new JLabel("Pedido removido");
        labelPedido.setForeground(Color.WHITE);
        add(labelPedido);
        labelPedido.setBounds(120, 60, 500, 115);
        labelPedido.setFont(fonte);

        PedidoDaoInterface pedidos = DAOFactory.createPedidoDao();
        Pedido pedido;
        pedido = pedidos.pesquisar(idPedido);

        fieldPedido = new JTextField("Id: " + pedido.getId_pedido(),30);
        fieldPedido.setForeground(Color.WHITE);
        fieldPedido.setBackground(Color.BLACK);
        fieldPedido.setEditable(false);
        add(fieldPedido);
        fieldPedido.setBounds(70, 400, 500, 40);
        fieldPedido.setFont(fonte);

        fieldPedido = new JTextField("Cpf: " + pedido.getFk_cpf(),30);
        fieldPedido.setForeground(Color.WHITE);
        fieldPedido.setBackground(Color.BLACK);
        fieldPedido.setEditable(false);
        add(fieldPedido);
        fieldPedido.setBounds(70, 450, 500, 40);
        fieldPedido.setFont(fonte);

        fieldPedido = new JTextField("Codigo cardápio: " + pedido.getFk_codigo(),30);
        fieldPedido.setForeground(Color.WHITE);
        fieldPedido.setBackground(Color.BLACK);
        fieldPedido.setEditable(false);
        add(fieldPedido);
        fieldPedido.setBounds(70, 500, 500, 40);
        fieldPedido.setFont(fonte);

        fieldPedido = new JTextField("Valor total: " + pedido.getTotal_compra(),30);
        fieldPedido.setForeground(Color.WHITE);
        fieldPedido.setBackground(Color.BLACK);
        fieldPedido.setEditable(false);
        add(fieldPedido);
        fieldPedido.setBounds(70, 550, 500, 40);
        fieldPedido.setFont(fonte);

        fieldPedido = new JTextField("Data: " + pedido.getData(),30);
        fieldPedido.setForeground(Color.WHITE);
        fieldPedido.setBackground(Color.BLACK);
        fieldPedido.setEditable(false);
        add(fieldPedido);
        fieldPedido.setBounds(70, 600, 500, 40);
        fieldPedido.setFont(fonte);

        imgTelaPrimaria = new ImageIcon(getClass().getResource("telaSecundaria.jpeg"));
        labelTelaSecundaria = new JLabel(imgTelaPrimaria);
        add(labelTelaSecundaria);
        labelTelaSecundaria.setBounds(100, 0, 1280, 959);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JanelaPedidos janPed = null;
        JanelaPrincipal jnl = null;
        if (e.getSource() == buttonFazer){
            janPed = new JanelaPedidos();
            janPed.telaFazerPedido();
        }
        else if (e.getSource() == buttonVoltar){
            jnl = new JanelaPrincipal();
            jnl.telaPrimaria();
        }
        else if (e.getSource() == buttonConfirmar){
            String cpf = fieldCpf.getText();

            if (cpf.equals("")){
                JOptionPane.showMessageDialog(null,"Pedido não efetuado!\n" +
                        "Preencha todos os campos\n" +
                        "e os dados corretamente!");
            }
            else {
                String escolha = "";
                Random random = new Random();
                Integer idPedido = Math.abs(random.nextInt(1000000));
                PedidoDaoInterface pedidos = DAOFactory.createPedidoDao();
                CardapioDaoInterface cardapios = DAOFactory.createCardapioDao();
                Cardapio cardapio = new Cardapio();
                Pedido pedido = new Pedido();
                pedido.setId_pedido(idPedido);
                pedido.setFk_cpf(cpf);

                if (brigadeiro.isSelected() == true){
                    cardapio.setCodigo("BRIG");
                    cardapio = cardapios.pesquisar(cardapio.getCodigo());
                    pedido.setFk_codigo(cardapio.getCodigo());
                    pedido.setTotal_compra(cardapio.getValor());
                    escolha = cardapio.getNome();
                }
                else if (brigadeiroCombo.isSelected() == true){
                    cardapio.setCodigo("BRIGCOMB");
                    cardapio = cardapios.pesquisar(cardapio.getCodigo());
                    pedido.setFk_codigo(cardapio.getCodigo());
                    pedido.setTotal_compra(cardapio.getValor());
                    escolha = cardapio.getNome();
                }
                else if (calabresa.isSelected() == true){
                    cardapio.setCodigo("CALAB");
                    cardapio = cardapios.pesquisar(cardapio.getCodigo());
                    pedido.setFk_codigo(cardapio.getCodigo());
                    pedido.setTotal_compra(cardapio.getValor());
                    escolha = cardapio.getNome();
                }
                else if (calabresaCombo.isSelected() == true){
                    cardapio.setCodigo("CALABCOMB");
                    cardapio = cardapios.pesquisar(cardapio.getCodigo());
                    pedido.setFk_codigo(cardapio.getCodigo());
                    pedido.setTotal_compra(cardapio.getValor());
                    escolha = cardapio.getNome();
                }
                else if (frango.isSelected() == true){
                    cardapio.setCodigo("FRANG");
                    cardapio = cardapios.pesquisar(cardapio.getCodigo());
                    pedido.setFk_codigo(cardapio.getCodigo());
                    pedido.setTotal_compra(cardapio.getValor());
                    escolha = cardapio.getNome();
                }
                else if (frangoCombo.isSelected() == true){
                    cardapio.setCodigo("FRANGCOMB");
                    cardapio = cardapios.pesquisar(cardapio.getCodigo());
                    pedido.setFk_codigo(cardapio.getCodigo());
                    pedido.setTotal_compra(cardapio.getValor());
                    escolha = cardapio.getNome();
                }
                else if (mussarela.isSelected() == true){
                    cardapio.setCodigo("MUSSA");
                    cardapio = cardapios.pesquisar(cardapio.getCodigo());
                    pedido.setFk_codigo(cardapio.getCodigo());
                    pedido.setTotal_compra(cardapio.getValor());
                    escolha = cardapio.getNome();
                }
                else if (mussarelaCombo.isSelected() == true){
                    cardapio.setCodigo("MUSSACOMB");
                    cardapio = cardapios.pesquisar(cardapio.getCodigo());
                    pedido.setFk_codigo(cardapio.getCodigo());
                    pedido.setTotal_compra(cardapio.getValor());
                    escolha = cardapio.getNome();
                }
                else if (portuguesa.isSelected() == true){
                    cardapio.setCodigo("PORT");
                    cardapio = cardapios.pesquisar(cardapio.getCodigo());
                    pedido.setFk_codigo(cardapio.getCodigo());
                    pedido.setTotal_compra(cardapio.getValor());
                    escolha = cardapio.getNome();
                }
                else if (portuguesaCombo.isSelected() == true){
                    cardapio.setCodigo("PORTCOMB");
                    cardapio = cardapios.pesquisar(cardapio.getCodigo());
                    pedido.setFk_codigo(cardapio.getCodigo());
                    pedido.setTotal_compra(cardapio.getValor());
                    escolha = cardapio.getNome();
                }
                else if (refrigerante2L.isSelected() == true){
                    cardapio.setCodigo("REFR2L");
                    cardapio = cardapios.pesquisar(cardapio.getCodigo());
                    pedido.setFk_codigo(cardapio.getCodigo());
                    pedido.setTotal_compra(cardapio.getValor());
                    escolha = cardapio.getNome();
                }
                pedidos.inserir(pedido);
                janPed = new JanelaPedidos();
                janPed.telaPedidoConfirmado(idPedido,escolha);
            }
        }
        else if (e.getSource() == buttonExcluir){
            janPed = new JanelaPedidos();
            janPed.telaRemovePedido();
        }
        else if (e.getSource() == buttonRemover){
            PedidoDaoInterface pedidos = DAOFactory.createPedidoDao();
            String conversao = fieldIdPedidoRem.getText();
            int idRemocao = Integer.parseInt(conversao);
            janPed = new JanelaPedidos();
            janPed.telaRemocao(idRemocao);
            pedidos.remover(idRemocao);
        }
    }
}
