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
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class TelaGerenteEstoque {

	private JFrame frmFuncionarioEstoque;
	
	private static ArrayList<Produto> produtos = new ArrayList<Produto>();
	private static ArrayList<Produto> buscaProdutos = new ArrayList<Produto>();
	private JTextField escolherProdutoAlt;
	private boolean bloqueio = true;
	
	private String produto = "<html><body>";
    private String codigos = "<html><body>";
    private String precos = "<html><body>";
    private String quantidade = "<html><body>";
    private String tipo = "<html><body>";
    private String descricao = "<html><body>";
    private JTextField alterarNome;
    private JTextField alterarTipo;
    private JTextField alterarDescricao;
    private JTextField alterarQuantidade;
    private JTextField alterarPreco;

	/**
	 * Launch the application.
	 */
	public static void telaGerenteEstoque() {
		produtos = new Main().getListaProd();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerenteEstoque window = new TelaGerenteEstoque();
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
	public TelaGerenteEstoque() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFuncionarioEstoque = new JFrame();
		frmFuncionarioEstoque.getContentPane().setBackground(new Color(255, 255, 255));
		frmFuncionarioEstoque.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaGerenteEstoque.class.getResource("/img/SportStockLogo.jpg")));
		frmFuncionarioEstoque.setTitle("Gerenciar");
		frmFuncionarioEstoque.setBounds(100, 100, 1060, 585);
		frmFuncionarioEstoque.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFuncionarioEstoque.getContentPane().setLayout(null);
		
        JButton btnAlterar = new JButton("Alterar");
        btnAlterar.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
        btnAlterar.setBackground(Color.WHITE);
        btnAlterar.setBounds(894, 107, 103, 36);
        frmFuncionarioEstoque.getContentPane().add(btnAlterar);
		
		alterarNome = new JTextField();
	    alterarNome.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
	    alterarNome.setColumns(10);
	    alterarNome.setBounds(122, 183, 154, 36);
	    frmFuncionarioEstoque.getContentPane().add(alterarNome);
	        
	    alterarTipo = new JTextField();
	    alterarTipo.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
	    alterarTipo.setColumns(10);
	    alterarTipo.setBounds(279, 183, 154, 36);
	    frmFuncionarioEstoque.getContentPane().add(alterarTipo);
	        
	    alterarDescricao = new JTextField();
	    alterarDescricao.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
	    alterarDescricao.setColumns(10);
	    alterarDescricao.setBounds(436, 183, 264, 84);
	    frmFuncionarioEstoque.getContentPane().add(alterarDescricao);
	        
	    alterarQuantidade = new JTextField();
	    alterarQuantidade.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
	    alterarQuantidade.setColumns(10);
	    alterarQuantidade.setBounds(703, 183, 154, 36);
	    frmFuncionarioEstoque.getContentPane().add(alterarQuantidade);
	        
	    alterarPreco = new JTextField();
	    alterarPreco.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
	    alterarPreco.setColumns(10);
	    alterarPreco.setBounds(859, 183, 154, 36);
	    frmFuncionarioEstoque.getContentPane().add(alterarPreco);
	    
	    alterarNome.setVisible(!bloqueio);
	    alterarTipo.setVisible(!bloqueio);
	    alterarDescricao.setVisible(!bloqueio);
	    alterarQuantidade.setVisible(!bloqueio);
	    alterarPreco.setVisible(!bloqueio);
	    btnAlterar.setVisible(!bloqueio);
		
		JComboBox Opcoes = new JComboBox();
		Opcoes.setBackground(new Color(255, 255, 255));
		Opcoes.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		Opcoes.setModel(new DefaultComboBoxModel(new String[] {"Código: ", "Nome: ", "Tipo: ", "Descrição: ", "Quantidade: ", "Preço: "}));
		Opcoes.setBounds(121, 105, 155, 36);
		frmFuncionarioEstoque.getContentPane().add(Opcoes);
		
		escolherProdutoAlt = new JTextField();
		escolherProdutoAlt.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		escolherProdutoAlt.setColumns(10);
		escolherProdutoAlt.setBounds(303, 107, 321, 36);
		frmFuncionarioEstoque.getContentPane().add(escolherProdutoAlt);
		
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
		
		JButton btnExcluirProduto = new JButton("Excluir produto");
		btnExcluirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (bloqueio == false) {
						for (int i = 0; i < buscaProdutos.size(); i++) {
							new Main().excluirProd(buscaProdutos.get(i).getIdProd());
						}
					produtos = new Main().getListaProd();
					}
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
		
		JLabel Erro = new JLabel("aaaaaaaaaaaaaaa");
		Erro.setBackground(new Color(255, 0, 0));
		Erro.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		Erro.setBounds(795, 58, 188, 36);
		frmFuncionarioEstoque.getContentPane().add(Erro);
		
		JLabel descricaoProdutosEstoque = new JLabel("");
		descricaoProdutosEstoque.setVerticalAlignment(SwingConstants.TOP);
		descricaoProdutosEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		descricaoProdutosEstoque.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		descricaoProdutosEstoque.setBounds(397, 186, 310, 242);
		frmFuncionarioEstoque.getContentPane().add(descricaoProdutosEstoque);
		
		JButton AdicionarProd = new JButton("Buscar");
		AdicionarProd.setBackground(new Color(255, 255, 255));
		AdicionarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				bloqueio = false;
				
				buscaProdutos.clear();
				
				switch ((String)Opcoes.getSelectedItem()) {
					case "Código: ":
						String codigo = escolherProdutoAlt.getText().toLowerCase();
						
						for (int i = 0; i < produtos.size(); i++) {
							if (Integer.toString(produtos.get(i).getIdProd()).toLowerCase().contains(codigo)) {
								buscaProdutos.add(produtos.get(i));
							}
						}
						break;
						
					case "Nome: ":
						String nome = escolherProdutoAlt.getText().toLowerCase();
						
						for (int i = 0; i < produtos.size(); i++) {
							if (produtos.get(i).getNomeProd().toLowerCase().contains(nome)) {
								buscaProdutos.add(produtos.get(i));
							}
						}
						break;
						
					case "Tipo: ":
						String tipo = escolherProdutoAlt.getText().toLowerCase();
						
						for (int i = 0; i < produtos.size(); i++) {
							if (produtos.get(i).getTipoProd().toLowerCase().contains(tipo)) {
								buscaProdutos.add(produtos.get(i));
							}
						}
						break;
						
					case "Descrição: ":
						String descricao = escolherProdutoAlt.getText().toLowerCase();
						
						for (int i = 0; i < produtos.size(); i++) {
							if (produtos.get(i).getDescricaoProd().toLowerCase().contains(descricao)) {
								buscaProdutos.add(produtos.get(i));
							}
						}
						break;
						
					case "Quantidade: ":
						String quantidade = escolherProdutoAlt.getText().toLowerCase();
						
						for (int i = 0; i < produtos.size(); i++) {
							if (Integer.toString(produtos.get(i).getQtdProd()).toLowerCase().contains(quantidade)) {
								buscaProdutos.add(produtos.get(i));
							}
						}
						break;
						
					case "Preço: ":
						String preco = escolherProdutoAlt.getText().toLowerCase();
						
						for (int i = 0; i < produtos.size(); i++) {
							if (Float.toString(produtos.get(i).getPrecoProd()).toLowerCase().contains(preco)) {
								buscaProdutos.add(produtos.get(i));
							}
						}
						break;
						
				}
				
				produtosEstoque.setVisible(!bloqueio);
				tipoProdutosEstoque.setVisible(!bloqueio);
				descricaoProdutosEstoque.setVisible(!bloqueio);
				quantidadeProdutosEstoque.setVisible(!bloqueio);
				precoProdutosEstoque.setVisible(!bloqueio);
				
				alterarNome.setVisible(bloqueio);
				alterarTipo.setVisible(bloqueio);
				alterarDescricao.setVisible(bloqueio);
				alterarQuantidade.setVisible(bloqueio);
				alterarPreco.setVisible(bloqueio);
			    btnAlterar.setVisible(bloqueio);
				
				String buscaProduto = "<html><body>";
		        String buscaCodigos = "<html><body>";
		        String buscaPrecos = "<html><body>";
		        String buscaQuantidade = "<html><body>";
		        String buscaTipo = "<html><body>";
		        String buscaDescricao = "<html><body>";
		        for(int i = 0; i < buscaProdutos.size(); ++i) {
		            buscaProduto += buscaProdutos.get(i).getNomeProd() + "<br>";
		            buscaCodigos += buscaProdutos.get(i).getIdProd() + "<br>";
		            buscaPrecos += "R$ " + buscaProdutos.get(i).getPrecoProd() + "<br>";
		            buscaQuantidade += buscaProdutos.get(i).getQtdProd() + "<br>";
		            buscaTipo += buscaProdutos.get(i).getTipoProd() + "<br>";
		            buscaDescricao += buscaProdutos.get(i).getDescricaoProd() + "<br>";
		            int espaco = buscaProdutos.get(i).getDescricaoProd().length();
		            while (espaco > 31) {
		            	buscaProduto += "<br>";
		            	buscaCodigos += "<br>";
		            	buscaPrecos += "<br>";
		            	buscaQuantidade += "<br>";
		            	buscaTipo += "<br>";
		            	espaco -= 31;
		            }
		        }
		        buscaProduto += "</body></html>";
		        buscaCodigos += "</body></html>";
		       buscaPrecos += "</body></html>";
		        buscaQuantidade += "</body></html>";
		        buscaTipo += "</body></html>";
		        buscaDescricao += "</body></html>";
		        produtosEstoque.setText(buscaProduto);
		        codigosProdutosEstoque.setText(buscaCodigos);
		        precoProdutosEstoque.setText(buscaPrecos);
		        quantidadeProdutosEstoque.setText(buscaQuantidade);
		        tipoProdutosEstoque.setText(buscaTipo);
		        descricaoProdutosEstoque.setText(buscaDescricao);
				
	
				
			}
		});
		AdicionarProd.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		AdicionarProd.setBounds(668, 107, 103, 36);
		frmFuncionarioEstoque.getContentPane().add(AdicionarProd);
		
		
		JLabel lblPreo_1 = new JLabel("Descrição: ");
		lblPreo_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblPreo_1.setBounds(502, 152, 96, 23);
		frmFuncionarioEstoque.getContentPane().add(lblPreo_1);
		
		produto = "<html><body>";
        codigos = "<html><body>";
        precos = "<html><body>";
        quantidade = "<html><body>";
        tipo = "<html><body>";
        descricao = "<html><body>";
		
        for(int i = 0; i < produtos.size(); ++i) {
            produto += produtos.get(i).getNomeProd() + "<br>";
            codigos += produtos.get(i).getIdProd() + "<br>";
            precos += "R$ " + produtos.get(i).getPrecoProd() + "<br>";
            quantidade += produtos.get(i).getQtdProd() + "<br>";
            tipo += produtos.get(i).getTipoProd() + "<br>";
            descricao += produtos.get(i).getDescricaoProd() + "<br>";
            int espaco = produtos.get(i).getDescricaoProd().length();
            while (espaco > 31) {
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
		
		JButton btnAlterarProduto = new JButton("Alterar produto");
		btnAlterarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (buscaProdutos.size() != 0) {
					
					produtosEstoque.setVisible(bloqueio);
					tipoProdutosEstoque.setVisible(bloqueio);
					descricaoProdutosEstoque.setVisible(bloqueio);
					quantidadeProdutosEstoque.setVisible(bloqueio);
					precoProdutosEstoque.setVisible(bloqueio);
					
					 alterarNome.setVisible(!bloqueio);
					 alterarTipo.setVisible(!bloqueio);
					 alterarDescricao.setVisible(!bloqueio);
					 alterarQuantidade.setVisible(!bloqueio);
					 alterarPreco.setVisible(!bloqueio);
					 btnAlterar.setVisible(!bloqueio);
					
					for (int i = 0; i < buscaProdutos.size(); i++) {
						
						alterarNome.setText(buscaProdutos.get(i).getNomeProd());
						alterarTipo.setText(buscaProdutos.get(i).getTipoProd());
						alterarDescricao.setText(buscaProdutos.get(i).getDescricaoProd());
						alterarQuantidade.setText(Integer.toString(buscaProdutos.get(i).getQtdProd()));
						alterarPreco.setText(Float.toString(buscaProdutos.get(i).getPrecoProd()));
						
						
					}
				}
				
			}
		});
		btnAlterarProduto.setBackground(new Color(255, 255, 255));
		btnAlterarProduto.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		btnAlterarProduto.setBounds(463, 58, 184, 36);
		frmFuncionarioEstoque.getContentPane().add(btnAlterarProduto);
        
        JButton btnResetar = new JButton("Resetar");
        btnResetar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		
        		bloqueio = true;
        		
        		produto = "<html><body>";
                codigos = "<html><body>";
                precos = "<html><body>";
                quantidade = "<html><body>";
                tipo = "<html><body>";
                descricao = "<html><body>";
        		
                for(int i = 0; i < produtos.size(); ++i) {
                    produto += produtos.get(i).getNomeProd() + "<br>";
                    codigos += produtos.get(i).getIdProd() + "<br>";
                    precos += "R$ " + produtos.get(i).getPrecoProd() + "<br>";
                    quantidade += produtos.get(i).getQtdProd() + "<br>";
                    tipo += produtos.get(i).getTipoProd() + "<br>";
                    descricao += produtos.get(i).getDescricaoProd() + "<br>";
                    int espaco = produtos.get(i).getDescricaoProd().length();
                    while (espaco > 31) {
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
        	    
        	    produtosEstoque.setVisible(bloqueio);
				tipoProdutosEstoque.setVisible(bloqueio);
				descricaoProdutosEstoque.setVisible(bloqueio);
				quantidadeProdutosEstoque.setVisible(bloqueio);
				precoProdutosEstoque.setVisible(bloqueio);
				
				alterarNome.setVisible(!bloqueio);
				alterarTipo.setVisible(!bloqueio);
				alterarDescricao.setVisible(!bloqueio);
				alterarQuantidade.setVisible(!bloqueio);
				alterarPreco.setVisible(!bloqueio);
			    btnAlterar.setVisible(!bloqueio);
        		
        	    buscaProdutos.clear();
        	
        	}
        });
        btnResetar.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
        btnResetar.setBackground(Color.WHITE);
        btnResetar.setBounds(781, 107, 103, 36);
        frmFuncionarioEstoque.getContentPane().add(btnResetar);
        

        
       
        
        
	}
}