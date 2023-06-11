package telas;

import java.awt.EventQueue;
import recursos.*;
import main.Main;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaGerente {

	private JFrame frmGerenciar;
	
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static ArrayList<Cupom> cupons = new ArrayList<Cupom>();
	private static ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private static ArrayList<Produto> produtos = new ArrayList<Produto>();
	private static ArrayList<Venda> vendas = new ArrayList<Venda>();
	private JTextField txtR;
	private JTextField descontoCupom;
	private JTextField codigoProdutoAlt;
	private JTextField qtdProdutoAlt;

	/**
	 * Launch the application.
	 */
	public static void telaGerente() {
		clientes = new Main().getListaCli();
		cupons = new Main().getListaCupom();
		fornecedores = new Main().getListaFornec();
		funcionarios = new Main().getListaFun();
		produtos = new Main().getListaProd();
		vendas = new Main().getListaVenda();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerente window = new TelaGerente();
					window.frmGerenciar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaGerente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGerenciar = new JFrame();
		frmGerenciar.getContentPane().setBackground(new Color(255, 255, 255));
		frmGerenciar.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaGerente.class.getResource("/img/SportStockLogo.jpg")));
		frmGerenciar.setTitle("Gerenciar");
		frmGerenciar.setBounds(100, 100, 1060, 585);
		frmGerenciar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGerenciar.getContentPane().setLayout(null);
		
		JButton btnVenda = new JButton("Vendas");
		btnVenda.setBackground(new Color(255, 255, 255));
		btnVenda.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnVenda.setBounds(123, 32, 103, 36);
		frmGerenciar.getContentPane().add(btnVenda);
		
		JButton btnFuncionarios = new JButton("Funcionarios");
		btnFuncionarios.setBackground(new Color(255, 255, 255));
		btnFuncionarios.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnFuncionarios.setBounds(266, 32, 115, 36);
		frmGerenciar.getContentPane().add(btnFuncionarios);
		
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.setBackground(new Color(255, 255, 255));
		btnEstoque.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnEstoque.setBounds(408, 32, 103, 36);
		frmGerenciar.getContentPane().add(btnEstoque);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setBackground(new Color(255, 255, 255));
		btnClientes.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnClientes.setBounds(546, 32, 103, 36);
		frmGerenciar.getContentPane().add(btnClientes);
		
		JButton btnFornecedores = new JButton("Fornecedores");
		btnFornecedores.setBackground(new Color(255, 255, 255));
		btnFornecedores.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnFornecedores.setBounds(682, 32, 121, 36);
		frmGerenciar.getContentPane().add(btnFornecedores);
		
		JLabel tipoNomeFuncionario = new JLabel("");
		tipoNomeFuncionario.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		tipoNomeFuncionario.setBounds(854, 11, 121, 57);
		frmGerenciar.getContentPane().add(tipoNomeFuncionario);
		
		JButton btnAlterarProduto = new JButton("Alterar produto");
		btnAlterarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int codigoProdVenda = Integer.parseInt(JOptionPane.showInputDialog("Insira o codigo do produto"));
				
			}
		});
		btnAlterarProduto.setBackground(new Color(255, 255, 255));
		btnAlterarProduto.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		btnAlterarProduto.setBounds(36, 79, 184, 36);
		frmGerenciar.getContentPane().add(btnAlterarProduto);
		
		JButton btnExcluirProduto = new JButton("Excluir produto");
		btnExcluirProduto.setBackground(new Color(255, 255, 255));
		btnExcluirProduto.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		btnExcluirProduto.setBounds(230, 79, 184, 36);
		frmGerenciar.getContentPane().add(btnExcluirProduto);
		
		JButton btnInserirCupom = new JButton("Inserir cupom");
		btnInserirCupom.setBackground(new Color(255, 255, 255));
		btnInserirCupom.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		btnInserirCupom.setBounds(424, 79, 184, 36);
		frmGerenciar.getContentPane().add(btnInserirCupom);
		
		JButton btnCriarCupom = new JButton("Criar cupom");
		btnCriarCupom.setBackground(new Color(255, 255, 255));
		btnCriarCupom.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		btnCriarCupom.setBounds(618, 79, 184, 36);
		frmGerenciar.getContentPane().add(btnCriarCupom);
		
		JLabel lblNewLabel = new JLabel("Produtos:");
		lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblNewLabel.setBounds(23, 173, 89, 23);
		frmGerenciar.getContentPane().add(lblNewLabel);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblCdigo.setBounds(256, 173, 85, 23);
		frmGerenciar.getContentPane().add(lblCdigo);
		
		JLabel lblPreo = new JLabel("Preço:");
		lblPreo.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblPreo.setBounds(424, 173, 59, 23);
		frmGerenciar.getContentPane().add(lblPreo);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblQuantidade.setBounds(565, 173, 115, 23);
		frmGerenciar.getContentPane().add(lblQuantidade);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblTotal.setBounds(755, 173, 48, 23);
		frmGerenciar.getContentPane().add(lblTotal);
		
		JLabel lblTotalDa = new JLabel("Total da");
		lblTotalDa.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblTotalDa.setBounds(927, 227, 85, 23);
		frmGerenciar.getContentPane().add(lblTotalDa);
		
		JLabel lblCompra = new JLabel("compra");
		lblCompra.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblCompra.setBounds(927, 249, 85, 23);
		frmGerenciar.getContentPane().add(lblCompra);
		
		JLabel totalVenda = new JLabel("");
		totalVenda.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		totalVenda.setBounds(927, 295, 85, 41);
		frmGerenciar.getContentPane().add(totalVenda);
		
		JLabel produtosVenda = new JLabel("");
		produtosVenda.setVerticalAlignment(SwingConstants.TOP);
		produtosVenda.setHorizontalAlignment(SwingConstants.LEFT);
		produtosVenda.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		produtosVenda.setBounds(20, 207, 206, 242);
		frmGerenciar.getContentPane().add(produtosVenda);
		
		JLabel codigosProdutosVenda = new JLabel("");
		codigosProdutosVenda.setVerticalAlignment(SwingConstants.TOP);
		codigosProdutosVenda.setHorizontalAlignment(SwingConstants.LEFT);
		codigosProdutosVenda.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		codigosProdutosVenda.setBounds(256, 207, 141, 242);
		frmGerenciar.getContentPane().add(codigosProdutosVenda);
		
		JLabel precoProdutosVenda = new JLabel("");
		precoProdutosVenda.setVerticalAlignment(SwingConstants.TOP);
		precoProdutosVenda.setHorizontalAlignment(SwingConstants.LEFT);
		precoProdutosVenda.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		precoProdutosVenda.setBounds(418, 207, 127, 242);
		frmGerenciar.getContentPane().add(precoProdutosVenda);
		
		JLabel quantidadeProdutosVenda = new JLabel("");
		quantidadeProdutosVenda.setVerticalAlignment(SwingConstants.TOP);
		quantidadeProdutosVenda.setHorizontalAlignment(SwingConstants.LEFT);
		quantidadeProdutosVenda.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		quantidadeProdutosVenda.setBounds(565, 207, 127, 242);
		frmGerenciar.getContentPane().add(quantidadeProdutosVenda);
		
		JLabel totalProdutosVenda = new JLabel("");
		totalProdutosVenda.setVerticalAlignment(SwingConstants.TOP);
		totalProdutosVenda.setHorizontalAlignment(SwingConstants.LEFT);
		totalProdutosVenda.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		totalProdutosVenda.setBounds(733, 207, 127, 242);
		frmGerenciar.getContentPane().add(totalProdutosVenda);
		
		JLabel lblNewLabel_1 = new JLabel("Forma de");
		lblNewLabel_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(36, 479, 69, 23);
		frmGerenciar.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("pagamento");
		lblNewLabel_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(36, 499, 85, 23);
		frmGerenciar.getContentPane().add(lblNewLabel_1_1);
		
		JComboBox formaPgto = new JComboBox();
		formaPgto.setBackground(new Color(255, 255, 255));
		formaPgto.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		formaPgto.setModel(new DefaultComboBoxModel(new String[] {"Cartão", "Dinheiro", "Cheque", "Pix"}));
		formaPgto.setBounds(131, 479, 89, 43);
		frmGerenciar.getContentPane().add(formaPgto);
		
		JLabel lblNewLabel_1_2 = new JLabel("Parcelas");
		lblNewLabel_1_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(239, 479, 59, 43);
		frmGerenciar.getContentPane().add(lblNewLabel_1_2);
		
		JComboBox qtdParcelas = new JComboBox();
		qtdParcelas.setBackground(new Color(255, 255, 255));
		qtdParcelas.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		qtdParcelas.setModel(new DefaultComboBoxModel(new String[] {"", "", "", "", "", ""}));
		qtdParcelas.setBounds(308, 479, 132, 43);
		frmGerenciar.getContentPane().add(qtdParcelas);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Juros");
		lblNewLabel_1_2_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(449, 479, 42, 43);
		frmGerenciar.getContentPane().add(lblNewLabel_1_2_1);
		
		txtR = new JTextField();
		txtR.setForeground(new Color(0, 0, 0));
		txtR.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		txtR.setText("R$0,00");
		txtR.setEnabled(false);
		txtR.setEditable(false);
		txtR.setBounds(501, 479, 69, 43);
		frmGerenciar.getContentPane().add(txtR);
		txtR.setColumns(10);
		
		JLabel lblNewLabel_1_3 = new JLabel("Desconto");
		lblNewLabel_1_3.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(580, 479, 69, 23);
		frmGerenciar.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("cupom");
		lblNewLabel_1_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(580, 499, 69, 23);
		frmGerenciar.getContentPane().add(lblNewLabel_1_1_1);
		
		descontoCupom = new JTextField();
		descontoCupom.setForeground(new Color(0, 0, 0));
		descontoCupom.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		descontoCupom.setText("R$0,00");
		descontoCupom.setEnabled(false);
		descontoCupom.setEditable(false);
		descontoCupom.setBounds(659, 479, 101, 42);
		frmGerenciar.getContentPane().add(descontoCupom);
		descontoCupom.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Finalizar\r\n venda\r\n");
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 13));
		btnNewButton_3.setBounds(885, 479, 127, 43);
		frmGerenciar.getContentPane().add(btnNewButton_3);
		
		codigoProdutoAlt = new JTextField();
		codigoProdutoAlt.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		codigoProdutoAlt.setBounds(230, 126, 184, 36);
		frmGerenciar.getContentPane().add(codigoProdutoAlt);
		codigoProdutoAlt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Insira o codigo do produto");
		lblNewLabel_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(36, 126, 184, 36);
		frmGerenciar.getContentPane().add(lblNewLabel_2);
		
		qtdProdutoAlt = new JTextField();
		qtdProdutoAlt.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		qtdProdutoAlt.setText("1");
		qtdProdutoAlt.setBounds(659, 126, 94, 36);
		frmGerenciar.getContentPane().add(qtdProdutoAlt);
		qtdProdutoAlt.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Insira a quantidade de produtos");
		lblNewLabel_2_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(424, 126, 225, 36);
		frmGerenciar.getContentPane().add(lblNewLabel_2_1);
		
		JLabel Erro = new JLabel("");
		Erro.setBackground(new Color(255, 0, 0));
		Erro.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 13));
		Erro.setBounds(876, 126, 158, 36);
		frmGerenciar.getContentPane().add(Erro);
		
		JButton AdicionarProd = new JButton("Adicionar");
		AdicionarProd.setBackground(new Color(255, 255, 255));
		AdicionarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int qtd = Integer.parseInt(qtdProdutoAlt.getText());
					int codigo = Integer.parseInt(codigoProdutoAlt.getText());
					int index = -1;
					if(qtd < 1) {
						Erro.setText("Quantidade com valor negativo");
					}
					for(int i = 0; i < produtos.size(); ++i) {
						if(produtos.get(i).getIdProd() == codigo) {
							index = i;
							break;
						}
					}
					if(index == -1) {
						Erro.setText("Produto não encontrado");
					}
				} catch (Exception exce) {
					Erro.setText("Insira apenas numeros");
				}
			}
		});
		AdicionarProd.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		AdicionarProd.setBounds(763, 126, 103, 36);
		frmGerenciar.getContentPane().add(AdicionarProd);
		
		
	}
}