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
import javax.swing.JScrollPane;

public class TelaGerente {

	private JFrame frmGerenciar;
	
	private static ArrayList<Cupom> cupons = new ArrayList<Cupom>();
	private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private static ArrayList<Produto> produtos = new ArrayList<Produto>();
	private static ArrayList<Venda> vendas = new ArrayList<Venda>();
	private int opcao = 0;
	private float totalDaVenda = 0;
	private boolean usouCupom = false;
	private float porcentagemCupom = 0;
	private float[] vezes = new float[6];
	private String[] vezesS = new String[6];
	
	private JTextField txtR;
	private JTextField descontoCupom;
	private JTextField codigoProdutoAlt;
	private JTextField qtdProdutoAlt;

	/**
	 * Launch the application.
	 */
	public static void telaGerente() {
		cupons = new Main().getListaCupom();
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
		
		for(int i = 0; i < vezes.length; ++i) {
			vezes[i] = totalDaVenda / (i + 1);
			vezesS[i] = (i + 1) + "X R$ " + vezes[i];
		}
		
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
		btnFornecedores.setBounds(682, 32, 127, 36);
		frmGerenciar.getContentPane().add(btnFornecedores);
		
		JLabel tipoNomeFuncionario = new JLabel("");
		tipoNomeFuncionario.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		tipoNomeFuncionario.setBounds(854, 11, 121, 57);
		frmGerenciar.getContentPane().add(tipoNomeFuncionario);
		
		JLabel PrimeiroTexto = new JLabel("");
		PrimeiroTexto.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		PrimeiroTexto.setBounds(36, 126, 184, 36);
		frmGerenciar.getContentPane().add(PrimeiroTexto);
		
		JLabel SegundoTexto = new JLabel("");
		SegundoTexto.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		SegundoTexto.setBounds(408, 126, 225, 36);
		frmGerenciar.getContentPane().add(SegundoTexto);
		
		JLabel Erro = new JLabel("");
		Erro.setBackground(new Color(255, 0, 0));
		Erro.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		Erro.setBounds(846, 126, 188, 36);
		frmGerenciar.getContentPane().add(Erro);
		
		
		
		
		
		
		
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
		totalVenda.setBounds(897, 295, 137, 41);
		frmGerenciar.getContentPane().add(totalVenda);
		totalVenda.setText("R$ " + totalDaVenda);
		
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
		
		JComboBox<String> formaPgto = new JComboBox<String>();
		formaPgto.setBackground(new Color(255, 255, 255));
		formaPgto.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		formaPgto.setModel(new DefaultComboBoxModel<String>(new String[] {"Cartão", "Dinheiro", "Cheque", "Pix"}));
		formaPgto.setBounds(131, 479, 89, 43);
		frmGerenciar.getContentPane().add(formaPgto);
		
		JLabel lblNewLabel_1_2 = new JLabel("Parcelas");
		lblNewLabel_1_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(239, 479, 59, 43);
		frmGerenciar.getContentPane().add(lblNewLabel_1_2);
		
		JComboBox<String> qtdParcelas = new JComboBox<String>();
		qtdParcelas.setBackground(new Color(255, 255, 255));
		qtdParcelas.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		qtdParcelas.setModel(new DefaultComboBoxModel<String>(vezesS));
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
		
		
		
		codigoProdutoAlt = new JTextField();
		codigoProdutoAlt.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		codigoProdutoAlt.setBounds(230, 126, 169, 36);
		frmGerenciar.getContentPane().add(codigoProdutoAlt);
		codigoProdutoAlt.setColumns(10);
		
		
		
		qtdProdutoAlt = new JTextField();
		qtdProdutoAlt.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		qtdProdutoAlt.setText("1");
		qtdProdutoAlt.setBounds(628, 126, 94, 36);
		frmGerenciar.getContentPane().add(qtdProdutoAlt);
		qtdProdutoAlt.setColumns(10);
		
		//infelizmente esse botão ta cm mt mais linhas do q eu gostaria mas eu n vou arrumar =D
		JButton AdicionarProd = new JButton("Adicionar");
		AdicionarProd.setBackground(new Color(255, 255, 255));
		AdicionarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Erro.setText(null);
				//eu poderia ter usado um switch, mas a preguica bateu kk
				if(opcao == 0) {
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
						} else {
							Venda v1 = new Venda();
							v1.setIdProd(codigo);
							v1.setQtdProd(qtd);
							v1.setIndexProd(index);
							float preco = qtd * produtos.get(index).getPrecoProd();
							v1.setPrecoVenda(preco);
							vendas.add(v1);
							String produto = "<html><body>";
							String codigos = "<html><body>";
							String precos = "<html><body>";
							String quantidade = "<html><body>";
							String precoVenda = "<html><body>";
							for(int i = 0; i < vendas.size(); ++i) {
								int indexProd = vendas.get(i).getIndexProd();
								produto += produtos.get(indexProd).getNomeProd() + "<br>";
								codigos += produtos.get(indexProd).getIdProd() + "<br>";
								precos += "R$ " + produtos.get(indexProd).getPrecoProd() + "<br>";
								quantidade += vendas.get(i).getQtdProd() + "<br>";
								precoVenda += vendas.get(i).getPrecoVenda() + "<br>";
							}
							produto += "</body></html>";
							codigos += "</body></html>";
							precos += "</body></html>";
							quantidade += "</body></html>";
							precoVenda += "</body></html>";
							produtosVenda.setText(produto);
							codigosProdutosVenda.setText(codigos);
							precoProdutosVenda.setText(precos);
							quantidadeProdutosVenda.setText(quantidade);
							totalProdutosVenda.setText(precoVenda);
							
						}
					} catch (Exception exce) {
						Erro.setText("Insira apenas numeros");
					} finally {
						totalDaVenda = 0;
						for(int i = 0; i < vendas.size(); ++i) {
							totalDaVenda +=  vendas.get(i).getPrecoVenda();
						}
						if(usouCupom == true) {
							totalDaVenda = totalDaVenda - (totalDaVenda * porcentagemCupom);
						}
						totalVenda.setText("R$ " + totalDaVenda);
						
						for(int i = 0; i < vezes.length; ++i) {
							vezes[i] = totalDaVenda / (i + 1);
							vezesS[i] = (i + 1) + "X R$ " + vezes[i];
						}
						qtdParcelas.setModel(new DefaultComboBoxModel<String>(vezesS));
						
						
					}
				} else if(opcao == 1) {
					try {
						int qtd = Integer.parseInt(qtdProdutoAlt.getText());
						int codigo = Integer.parseInt(codigoProdutoAlt.getText());
						int index = -1;
						if(qtd < 1) {
							Erro.setText("Quantidade com valor negativo");
						}
						for(int i = vendas.size() -1; i >= 0 ; --i) {
							if(vendas.get(i).getIdProd() == codigo) {
								index = i;
								break;
							}
						}
						if(vendas.get(index).getQtdProd() < qtd) {
							Erro.setText("Quantidade maior do que a quantidade de produtos");
						} else {
							if(vendas.get(index).getQtdProd() == qtd) {
								vendas.remove(index);
							} else {
								vendas.get(index).setQtdProd(vendas.get(index).getQtdProd() - qtd);
							}
							String produto = "<html><body>";
							String codigos = "<html><body>";
							String precos = "<html><body>";
							String quantidade = "<html><body>";
							String precoVenda = "<html><body>";
							for(int i = 0; i < vendas.size(); ++i) {
								int indexProd = vendas.get(i).getIndexProd();
								produto += produtos.get(indexProd).getNomeProd() + "<br>";
								codigos += produtos.get(indexProd).getIdProd() + "<br>";
								precos += "R$ " + produtos.get(indexProd).getPrecoProd() + "<br>";
								quantidade += vendas.get(i).getQtdProd() + "<br>";
								precoVenda += vendas.get(i).getPrecoVenda() + "<br>";
							}
							produto += "</body></html>";
							codigos += "</body></html>";
							precos += "</body></html>";
							quantidade += "</body></html>";
							precoVenda += "</body></html>";
							produtosVenda.setText(produto);
							codigosProdutosVenda.setText(codigos);
							precoProdutosVenda.setText(precos);
							quantidadeProdutosVenda.setText(quantidade);
							totalProdutosVenda.setText(precoVenda);
						}
						
					} catch (Exception exce) {
						Erro.setText("Insira apenas numeros");
					} finally {
						
						totalDaVenda = 0;
						for(int i = 0; i < vendas.size(); ++i) {
							totalDaVenda +=  vendas.get(i).getPrecoVenda();
						}
						if(usouCupom == true) {
							totalDaVenda = totalDaVenda - (totalDaVenda * porcentagemCupom);
						}
						totalVenda.setText("R$ " + totalDaVenda);
						for(int i = 0; i < vezes.length; ++i) {
							vezes[i] = totalDaVenda / (i + 1);
							vezesS[i] = (i + 1) + "X R$ " + vezes[i];
						}
						qtdParcelas.setModel(new DefaultComboBoxModel<String>(vezesS));
					}
					
				} else if(opcao == 2) {
					try {
						String codigo = codigoProdutoAlt.getText();
						int index = -1;
						for(int i = 0; i < cupons.size(); ++i) {
							if(cupons.get(i).getCodCupom().equals(codigo)) {
								index = i;
							}
						}
						if(index != -1) {
							totalDaVenda = totalDaVenda - (totalDaVenda * cupons.get(index).getPorcentagemCupom());
							porcentagemCupom = cupons.get(index).getPorcentagemCupom() / 100;
							usouCupom = true;
						} else {
							Erro.setText("Cupom Invalido");
						}
					} catch (Exception exce) {
						Erro.setText("Insira apenas numeros");
						
					} finally {
						
						totalDaVenda = 0;
						for(int i = 0; i < vendas.size(); ++i) {
							totalDaVenda +=  vendas.get(i).getPrecoVenda();
						}
						if(usouCupom == true) {
							totalDaVenda = totalDaVenda - (totalDaVenda * porcentagemCupom);
						}
						totalVenda.setText("R$ " + totalDaVenda);
						for(int i = 0; i < vezes.length; ++i) {
							vezes[i] = totalDaVenda / (i + 1);
							vezesS[i] = (i + 1) + "X R$ " + vezes[i];
						}
						qtdParcelas.setModel(new DefaultComboBoxModel<String>(vezesS));
					}
					
					
				} else if(opcao == 3) {
					try {
						String codigo = codigoProdutoAlt.getText();
						float porcentagem = Float.parseFloat(qtdProdutoAlt.getText());
						
						if(porcentagem <= 20 && porcentagem > 0) {
							Cupom c1 = new Cupom();
							c1.setCodCupom(codigo);
							c1.setPorcentagemCupom(porcentagem);
							c1.setQtdUsosCupom(20);
							new Main().adicionarCupom(c1);
							cupons = new Main().getListaCupom();
						} else {
							Erro.setText("Porcentagem invalida");
						}
						
					} catch (Exception exce) {
						Erro.setText("Insira apenas numeros");
					} finally {
						for(int i = 0; i < vezes.length; ++i) {
							vezes[i] = totalDaVenda / (i + 1);
							vezesS[i] = (i + 1) + "X R$ " + vezes[i];
						}
						qtdParcelas.setModel(new DefaultComboBoxModel<String>(vezesS));
					}
					
				}
				
			}
		});
		AdicionarProd.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		AdicionarProd.setBounds(733, 126, 103, 36);
		frmGerenciar.getContentPane().add(AdicionarProd);
		
		JButton btnAlterarProduto = new JButton("Adicionar produto");
		btnAlterarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Erro.setText(null);
				opcao = 0;
				codigoProdutoAlt.setVisible(false);
				Erro.setVisible(false);
				qtdProdutoAlt.setVisible(false);
				codigoProdutoAlt.setVisible(false);
				AdicionarProd.setVisible(false);
				PrimeiroTexto.setText("Insira o codigo do produto");
				SegundoTexto.setText("Insira a quantidade de produtos");
				Erro.setVisible(true);
				qtdProdutoAlt.setVisible(true);
				codigoProdutoAlt.setVisible(true);
				AdicionarProd.setText("Adicionar");
				AdicionarProd.setVisible(true);
			}
		});
		btnAlterarProduto.setBackground(new Color(255, 255, 255));
		btnAlterarProduto.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		btnAlterarProduto.setBounds(36, 79, 184, 36);
		frmGerenciar.getContentPane().add(btnAlterarProduto);
		
		JButton btnExcluirProduto = new JButton("Remover produto");
		btnExcluirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Erro.setText(null);
				opcao = 1;
				codigoProdutoAlt.setVisible(false);
				Erro.setVisible(false);
				qtdProdutoAlt.setVisible(false);
				codigoProdutoAlt.setVisible(false);
				AdicionarProd.setVisible(false);
				PrimeiroTexto.setText("Insira o codigo do produto");
				SegundoTexto.setText("Insira a quantidade de produtos");
				Erro.setVisible(true);
				qtdProdutoAlt.setVisible(true);
				codigoProdutoAlt.setVisible(true);
				AdicionarProd.setText("Remover");
				AdicionarProd.setVisible(true);
			}
		});
		btnExcluirProduto.setBackground(new Color(255, 255, 255));
		btnExcluirProduto.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		btnExcluirProduto.setBounds(230, 79, 184, 36);
		frmGerenciar.getContentPane().add(btnExcluirProduto);
		
		JButton btnInserirCupom = new JButton("Inserir cupom");
		btnInserirCupom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Erro.setText(null);
				opcao = 2;
				codigoProdutoAlt.setVisible(false);
				Erro.setVisible(false);
				qtdProdutoAlt.setVisible(false);
				codigoProdutoAlt.setVisible(false);
				AdicionarProd.setVisible(false);
				PrimeiroTexto.setText("Insira o codigo do cupom");
				SegundoTexto.setText("");
				Erro.setVisible(true);
				codigoProdutoAlt.setVisible(true);
				AdicionarProd.setText("Adicionar");
				AdicionarProd.setVisible(true);
				
			}
		});
		btnInserirCupom.setBackground(new Color(255, 255, 255));
		btnInserirCupom.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		btnInserirCupom.setBounds(424, 79, 184, 36);
		frmGerenciar.getContentPane().add(btnInserirCupom);
		
		JButton btnCriarCupom = new JButton("Criar cupom");
		btnCriarCupom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Erro.setText(null);
				opcao = 3;
				codigoProdutoAlt.setVisible(false);
				Erro.setVisible(false);
				qtdProdutoAlt.setVisible(false);
				codigoProdutoAlt.setVisible(false);
				AdicionarProd.setVisible(false);
				PrimeiroTexto.setText("Insira o codigo do cupom");
				SegundoTexto.setText("Insira a porcentagem");
				Erro.setVisible(true);
				qtdProdutoAlt.setVisible(true);
				codigoProdutoAlt.setVisible(true);
				AdicionarProd.setText("Adicionar");
				AdicionarProd.setVisible(true);
			}
		});
		btnCriarCupom.setBackground(new Color(255, 255, 255));
		btnCriarCupom.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		btnCriarCupom.setBounds(618, 79, 184, 36);
		frmGerenciar.getContentPane().add(btnCriarCupom);
		
		
		JButton FinalizarVenda = new JButton("<html><body>Finalizar<br>&nbsp;&nbsp;venda</body></html>\r\n");
		FinalizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totalDaVenda = 0;
				vendas.clear();
				usouCupom = false;
			}
		});
		FinalizarVenda.setBackground(new Color(255, 255, 255));
		FinalizarVenda.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		FinalizarVenda.setBounds(897, 479, 115, 43);
		frmGerenciar.getContentPane().add(FinalizarVenda);
		
		
		codigoProdutoAlt.setVisible(false);
		Erro.setVisible(false);
		qtdProdutoAlt.setVisible(false);
		codigoProdutoAlt.setVisible(false);
		AdicionarProd.setVisible(false);
	}
}
