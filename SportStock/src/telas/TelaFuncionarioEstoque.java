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

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class TelaFuncionarioEstoque {

	private JFrame frmFuncionarioEstoque;
	
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static ArrayList<Cupom> cupons = new ArrayList<Cupom>();
	private static ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private static ArrayList<Produto> produtos = new ArrayList<Produto>();
	private static ArrayList<Venda> vendas = new ArrayList<Venda>();
	private JTextField codigoProdutoAlt;
	private JTextField descricaoProdutoAlt;
	private JTextField cupomProdutoAlt;

	/**
	 * Launch the application.
	 */
	public static void telaFuncionarioEstoque() {
		clientes = new Main().getListaCli();
		cupons = new Main().getListaCupom();
		fornecedores = new Main().getListaFornec();
		funcionarios = new Main().getListaFun(); 
		produtos = new Main().getListaProd();
		vendas = new Main().getListaVenda();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionarioEstoque window = new TelaFuncionarioEstoque();
					window.frmFuncionarioEstoque.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaFuncionarioEstoque() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFuncionarioEstoque = new JFrame();
		frmFuncionarioEstoque.getContentPane().setBackground(new Color(255, 255, 255));
		frmFuncionarioEstoque.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaFuncionarioEstoque.class.getResource("/img/SportStockLogo.jpg")));
		frmFuncionarioEstoque.setTitle("Gerenciar");
		frmFuncionarioEstoque.setBounds(100, 100, 1060, 585);
		frmFuncionarioEstoque.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFuncionarioEstoque.getContentPane().setLayout(null);
		
		System.out.println(vendas);
		
		JButton btnVenda = new JButton("Vendas");
		btnVenda.setBackground(new Color(255, 255, 255));
		btnVenda.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnVenda.setBounds(95, 11, 141, 36);
		frmFuncionarioEstoque.getContentPane().add(btnVenda);
		
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.setBackground(new Color(255, 255, 255));
		btnEstoque.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnEstoque.setBounds(342, 11, 141, 36);
		frmFuncionarioEstoque.getContentPane().add(btnEstoque);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setBackground(new Color(255, 255, 255));
		btnClientes.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnClientes.setBounds(619, 11, 141, 36);
		frmFuncionarioEstoque.getContentPane().add(btnClientes);
		
		JLabel tipoNomeFuncionario = new JLabel("");
		tipoNomeFuncionario.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		tipoNomeFuncionario.setBounds(854, 11, 121, 57);
		frmFuncionarioEstoque.getContentPane().add(tipoNomeFuncionario);
		
		JButton btnAlterarProduto = new JButton("Alterar produto");
		btnAlterarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int codigoProdVenda = Integer.parseInt(JOptionPane.showInputDialog("Insira o codigo do produto"));
				
			}
		});
		btnAlterarProduto.setBackground(new Color(255, 255, 255));
		btnAlterarProduto.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		btnAlterarProduto.setBounds(463, 58, 184, 36);
		frmFuncionarioEstoque.getContentPane().add(btnAlterarProduto);
		
		JButton btnExcluirProduto = new JButton("Excluir produto");
		btnExcluirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluirProduto.setBackground(new Color(255, 255, 255));
		btnExcluirProduto.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		btnExcluirProduto.setBounds(193, 58, 184, 36);
		frmFuncionarioEstoque.getContentPane().add(btnExcluirProduto);
		
		JLabel lblNewLabel = new JLabel("Nome: ");
		lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblNewLabel.setBounds(163, 152, 113, 23);
		frmFuncionarioEstoque.getContentPane().add(lblNewLabel);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblCdigo.setBounds(10, 152, 85, 23);
		frmFuncionarioEstoque.getContentPane().add(lblCdigo);
		
		JLabel lblPreo = new JLabel("Preço:");
		lblPreo.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblPreo.setBounds(900, 152, 59, 23);
		frmFuncionarioEstoque.getContentPane().add(lblPreo);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblQuantidade.setBounds(727, 152, 115, 23);
		frmFuncionarioEstoque.getContentPane().add(lblQuantidade);
		
		JLabel lblTotal = new JLabel("Tipo: ");
		lblTotal.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblTotal.setBounds(303, 152, 59, 23);
		frmFuncionarioEstoque.getContentPane().add(lblTotal);
		
		JLabel produtosEstoque = new JLabel("");
		produtosEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		produtosEstoque.setVerticalAlignment(SwingConstants.TOP);
		produtosEstoque.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		produtosEstoque.setBounds(121, 186, 155, 242);
		frmFuncionarioEstoque.getContentPane().add(produtosEstoque);
		
		JLabel codigosProdutosEstoque = new JLabel("");
		codigosProdutosEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		codigosProdutosEstoque.setVerticalAlignment(SwingConstants.TOP);
		codigosProdutosEstoque.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		codigosProdutosEstoque.setBounds(10, 186, 101, 242);
		frmFuncionarioEstoque.getContentPane().add(codigosProdutosEstoque);
		
		JLabel precoProdutosEstoque = new JLabel("");
		precoProdutosEstoque.setVerticalAlignment(SwingConstants.TOP);
		precoProdutosEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		precoProdutosEstoque.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		precoProdutosEstoque.setBounds(872, 186, 127, 242);
		frmFuncionarioEstoque.getContentPane().add(precoProdutosEstoque);
		
		JLabel quantidadeProdutosEstoque = new JLabel("");
		quantidadeProdutosEstoque.setVerticalAlignment(SwingConstants.TOP);
		quantidadeProdutosEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		quantidadeProdutosEstoque.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		quantidadeProdutosEstoque.setBounds(736, 186, 101, 242);
		frmFuncionarioEstoque.getContentPane().add(quantidadeProdutosEstoque);
		
		JLabel tipoProdutosEstoque = new JLabel("");
		tipoProdutosEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		tipoProdutosEstoque.setVerticalAlignment(SwingConstants.TOP);
		tipoProdutosEstoque.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		tipoProdutosEstoque.setBounds(286, 186, 101, 242);
		frmFuncionarioEstoque.getContentPane().add(tipoProdutosEstoque);
		
		codigoProdutoAlt = new JTextField();
		codigoProdutoAlt.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		codigoProdutoAlt.setBounds(95, 105, 141, 36);
		frmFuncionarioEstoque.getContentPane().add(codigoProdutoAlt);
		codigoProdutoAlt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Código: ");
		lblNewLabel_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(36, 105, 69, 36);
		frmFuncionarioEstoque.getContentPane().add(lblNewLabel_2);
		
		descricaoProdutoAlt = new JTextField();
		descricaoProdutoAlt.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		descricaoProdutoAlt.setBounds(331, 105, 141, 36);
		frmFuncionarioEstoque.getContentPane().add(descricaoProdutoAlt);
		descricaoProdutoAlt.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Descrição: ");
		lblNewLabel_2_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(256, 105, 85, 36);
		frmFuncionarioEstoque.getContentPane().add(lblNewLabel_2_1);
		
		JLabel Erro = new JLabel("aaaaaaaaaaaaaaa");
		Erro.setBackground(new Color(255, 0, 0));
		Erro.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		Erro.setBounds(795, 58, 188, 36);
		frmFuncionarioEstoque.getContentPane().add(Erro);
		
		JButton AdicionarProd = new JButton("Buscar");
		AdicionarProd.setBackground(new Color(255, 255, 255));
		AdicionarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int qtd = Integer.parseInt(descricaoProdutoAlt.getText());
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
						
					}
				} catch (Exception exce) {
					Erro.setText("Insira apenas numeros");
				}
			}
		});
		AdicionarProd.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		AdicionarProd.setBounds(920, 105, 103, 36);
		frmFuncionarioEstoque.getContentPane().add(AdicionarProd);
		
		cupomProdutoAlt = new JTextField();
		cupomProdutoAlt.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		cupomProdutoAlt.setColumns(10);
		cupomProdutoAlt.setBounds(640, 105, 141, 36);
		frmFuncionarioEstoque.getContentPane().add(cupomProdutoAlt);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Cupom de Desconto: ");
		lblNewLabel_2_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(492, 105, 155, 36);
		frmFuncionarioEstoque.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel descricaoProdutosEstoque = new JLabel("");
		descricaoProdutosEstoque.setVerticalAlignment(SwingConstants.TOP);
		descricaoProdutosEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		descricaoProdutosEstoque.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		descricaoProdutosEstoque.setBounds(397, 186, 310, 242);
		frmFuncionarioEstoque.getContentPane().add(descricaoProdutosEstoque);
		
		JLabel lblPreo_1 = new JLabel("Descrição: ");
		lblPreo_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblPreo_1.setBounds(502, 152, 96, 23);
		frmFuncionarioEstoque.getContentPane().add(lblPreo_1);
		
		
		String produto = "<html><body>";
        String codigos = "<html><body>";
        String precos = "<html><body>";
        String quantidade = "<html><body>";
        String tipo = "<html><body>";
        String descricao = "<html><body>";
        for(int i = 0; i < produtos.size(); ++i) {
            int indexProd = produtos.get(i).getIdProd();
            produto += produtos.get(indexProd).getNomeProd() + "<br>";
            codigos += produtos.get(indexProd).getIdProd() + "<br>";
            precos += "R$ " + produtos.get(indexProd).getPrecoProd() + "<br>";
            quantidade += produtos.get(i).getQtdProd() + "<br>";
            tipo += produtos.get(i).getTipoProd() + "<br>";
            descricao += produtos.get(i).getDescricaoProd() + "<br>";
            int espaco = produtos.get(i).getDescricaoProd().length();
            while (espaco > 31) {
            	//for(int j == espaco / 31)
            	produto += "<br>";
            	codigos += "<br>";
            	precos += "<br>";
            	quantidade += "<br>";
            	tipo += "<br>";
            	espaco -= 31;
            }
        }
        produto += "</body></html>";
        codigos += "</body></html>";
        precos += "</body></html>";
        quantidade += "</body></html>";
        tipo += "</body></html>";
        descricao += "</body></html>";
        produtosEstoque.setText(produto);
        codigosProdutosEstoque.setText(codigos);
        precoProdutosEstoque.setText(precos);
        quantidadeProdutosEstoque.setText(quantidade);
        tipoProdutosEstoque.setText(tipo);
        descricaoProdutosEstoque.setText(descricao);
	}
}
