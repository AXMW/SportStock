package telas;

import java.awt.EventQueue;
import recursos.*;
import main.Main;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JLabel;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaGerenteEstoque {

	private JFrame frmGerenteEstoque;
	
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
    private int contador = 0;
    
	/**
	 * Launch the application.
	 */
	public static void telaGerenteEstoque() {
		produtos = new Main().getListaProd();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerenteEstoque window = new TelaGerenteEstoque();
					window.frmGerenteEstoque.setVisible(true);
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
		frmGerenteEstoque = new JFrame();
		frmGerenteEstoque.getContentPane().setBackground(new Color(255, 255, 255));
		frmGerenteEstoque.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaGerenteEstoque.class.getResource("/img/SportStockLogo.jpg")));
		frmGerenteEstoque.setTitle("Gerenciar");
		frmGerenteEstoque.setBounds(100, 100, 1060, 585);
		frmGerenteEstoque.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGerenteEstoque.getContentPane().setLayout(null);
		

		alterarNome = new JTextField();
	    alterarNome.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
	    alterarNome.setColumns(10);
	    alterarNome.setBounds(122, 204, 154, 36);
	    frmGerenteEstoque.getContentPane().add(alterarNome);
	        
	    alterarTipo = new JTextField();
	    alterarTipo.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
	    alterarTipo.setColumns(10);
	    alterarTipo.setBounds(279, 204, 154, 36);
	    frmGerenteEstoque.getContentPane().add(alterarTipo);
	        
	    alterarDescricao = new JTextField();
	    alterarDescricao.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
	    alterarDescricao.setColumns(10);
	    alterarDescricao.setBounds(436, 204, 264, 36);
	    frmGerenteEstoque.getContentPane().add(alterarDescricao);
	        
	    alterarQuantidade = new JTextField();
	    alterarQuantidade.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
	    alterarQuantidade.setColumns(10);
	    alterarQuantidade.setBounds(703, 204, 154, 36);
	    frmGerenteEstoque.getContentPane().add(alterarQuantidade);
	        
	    alterarPreco = new JTextField();
	    alterarPreco.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
	    alterarPreco.setColumns(10);
	    alterarPreco.setBounds(859, 204, 154, 36);
	    frmGerenteEstoque.getContentPane().add(alterarPreco);
	    
	    alterarNome.setVisible(!bloqueio);
	    alterarTipo.setVisible(!bloqueio);
	    alterarDescricao.setVisible(!bloqueio);
	    alterarQuantidade.setVisible(!bloqueio);
	    alterarPreco.setVisible(!bloqueio);
	    
	    JButton btnVenda = new JButton("Vendas");
		btnVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGerenteEstoque.setVisible(false);
				TelaGerente.telaGerente();
				frmGerenteEstoque.dispose();
			}
		});
		btnVenda.setBackground(new Color(255, 255, 255));
		btnVenda.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnVenda.setBounds(123, 32, 103, 36);
		frmGerenteEstoque.getContentPane().add(btnVenda);
		
		JButton btnFuncionarios = new JButton("Funcionarios");
		btnFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGerenteEstoque.setVisible(false);
				TelaGerenteFuncionarios.telaGerenteFuncionarios();
				frmGerenteEstoque.dispose();
			}
		});
		btnFuncionarios.setBackground(new Color(255, 255, 255));
		btnFuncionarios.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnFuncionarios.setBounds(256, 32, 125, 36);
		frmGerenteEstoque.getContentPane().add(btnFuncionarios);
		
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGerenteEstoque.setVisible(false);
				TelaGerenteEstoque.telaGerenteEstoque();
				frmGerenteEstoque.dispose();
			}
		});
		btnEstoque.setBackground(new Color(255, 255, 255));
		btnEstoque.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnEstoque.setBounds(408, 32, 103, 36);
		frmGerenteEstoque.getContentPane().add(btnEstoque);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGerenteEstoque.setVisible(false);
				TelaGerenteClientes.telaGerenteClientes();
				frmGerenteEstoque.dispose();
			}
		});
		btnClientes.setBackground(new Color(255, 255, 255));
		btnClientes.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnClientes.setBounds(546, 32, 103, 36);
		frmGerenteEstoque.getContentPane().add(btnClientes);
		
		JButton btnFornecedores = new JButton("Fornecedores");
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGerenteEstoque.setVisible(false);
				TelaGerenteFornecedores.telaGerenteFornecedores();
				frmGerenteEstoque.dispose();
			}
		});
		btnFornecedores.setBackground(new Color(255, 255, 255));
		btnFornecedores.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnFornecedores.setBounds(682, 32, 127, 36);
		frmGerenteEstoque.getContentPane().add(btnFornecedores);

	    JLabel Erro = new JLabel("");
		Erro.setBackground(new Color(255, 0, 0));
		Erro.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		Erro.setBounds(767, 252, 188, 36);
		frmGerenteEstoque.getContentPane().add(Erro);
	    
		JComboBox<String> Opcoes = new JComboBox<String>();
		Opcoes.setBackground(new Color(255, 255, 255));
		Opcoes.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		Opcoes.setModel(new DefaultComboBoxModel<String>(new String[] {"Código: ", "Nome: ", "Tipo: ", "Descrição: ", "Quantidade: ", "Preço: "}));
		Opcoes.setBounds(60, 126, 155, 36);
		frmGerenteEstoque.getContentPane().add(Opcoes);
		
		escolherProdutoAlt = new JTextField();
		escolherProdutoAlt.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		escolherProdutoAlt.setColumns(10);
		escolherProdutoAlt.setBounds(241, 126, 321, 36);
		frmGerenteEstoque.getContentPane().add(escolherProdutoAlt);
		
		JLabel lblNewLabel = new JLabel("Nome: ");
		lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblNewLabel.setBounds(163, 173, 113, 23);
		frmGerenteEstoque.getContentPane().add(lblNewLabel);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblCdigo.setBounds(10, 173, 85, 23);
		frmGerenteEstoque.getContentPane().add(lblCdigo);
		
		JLabel lblPreo = new JLabel("Preço:");
		lblPreo.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblPreo.setBounds(900, 173, 59, 23);
		frmGerenteEstoque.getContentPane().add(lblPreo);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblQuantidade.setBounds(727, 173, 115, 23);
		frmGerenteEstoque.getContentPane().add(lblQuantidade);
		
		JLabel lblTotal = new JLabel("Tipo: ");
		lblTotal.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblTotal.setBounds(303, 173, 59, 23);
		frmGerenteEstoque.getContentPane().add(lblTotal);
		
		JLabel produtosEstoque = new JLabel("");
		produtosEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		produtosEstoque.setVerticalAlignment(SwingConstants.TOP);
		produtosEstoque.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		produtosEstoque.setBounds(121, 207, 155, 242);
		frmGerenteEstoque.getContentPane().add(produtosEstoque);
		
		JLabel codigosProdutosEstoque = new JLabel("");
		codigosProdutosEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		codigosProdutosEstoque.setVerticalAlignment(SwingConstants.TOP);
		codigosProdutosEstoque.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		codigosProdutosEstoque.setBounds(10, 207, 101, 242);
		frmGerenteEstoque.getContentPane().add(codigosProdutosEstoque);
		
		JLabel precoProdutosEstoque = new JLabel("");
		precoProdutosEstoque.setVerticalAlignment(SwingConstants.TOP);
		precoProdutosEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		precoProdutosEstoque.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		precoProdutosEstoque.setBounds(872, 207, 127, 242);
		frmGerenteEstoque.getContentPane().add(precoProdutosEstoque);
		
		JLabel quantidadeProdutosEstoque = new JLabel("");
		quantidadeProdutosEstoque.setVerticalAlignment(SwingConstants.TOP);
		quantidadeProdutosEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		quantidadeProdutosEstoque.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		quantidadeProdutosEstoque.setBounds(736, 207, 101, 242);
		frmGerenteEstoque.getContentPane().add(quantidadeProdutosEstoque);
		
		JLabel tipoProdutosEstoque = new JLabel("");
		tipoProdutosEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		tipoProdutosEstoque.setVerticalAlignment(SwingConstants.TOP);
		tipoProdutosEstoque.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		tipoProdutosEstoque.setBounds(286, 207, 101, 242);
		frmGerenteEstoque.getContentPane().add(tipoProdutosEstoque);
		
		JLabel descricaoProdutosEstoque = new JLabel("");
		descricaoProdutosEstoque.setVerticalAlignment(SwingConstants.TOP);
		descricaoProdutosEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		descricaoProdutosEstoque.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		descricaoProdutosEstoque.setBounds(397, 207, 310, 242);
		frmGerenteEstoque.getContentPane().add(descricaoProdutosEstoque);
		

		
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
				codigosProdutosEstoque.setVisible(true);
				
				alterarNome.setVisible(bloqueio);
				alterarTipo.setVisible(bloqueio);
				alterarDescricao.setVisible(bloqueio);
				alterarQuantidade.setVisible(bloqueio);
				alterarPreco.setVisible(bloqueio);
				contador = 0;
				Erro.setText("");
				
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
		AdicionarProd.setBounds(586, 126, 103, 36);
		frmGerenteEstoque.getContentPane().add(AdicionarProd);
		
		JButton btnExcluirProduto = new JButton("Excluir produto");
		btnExcluirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (bloqueio == false) {
						for (int i = 0; i < buscaProdutos.size(); i++) {
							new Main().excluirProd(buscaProdutos.get(i).getIdProd());
						}
					produtos = new Main().getListaProd();
					
					AdicionarProd.doClick();
					}
				}
			});
		btnExcluirProduto.setBackground(new Color(255, 255, 255));
		btnExcluirProduto.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		btnExcluirProduto.setBounds(617, 79, 184, 36);
		frmGerenteEstoque.getContentPane().add(btnExcluirProduto);
		
		
		JLabel lblPreo_1 = new JLabel("Descrição: ");
		lblPreo_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblPreo_1.setBounds(502, 173, 96, 23);
		frmGerenteEstoque.getContentPane().add(lblPreo_1);
		
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
				
				if (buscaProdutos.size() != 0 && !(contador == buscaProdutos.size())) {
					
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

					codigosProdutosEstoque.setText(Integer.toString(produtos.get(contador).getIdProd()));		
					alterarNome.setText(buscaProdutos.get(contador).getNomeProd());
					alterarTipo.setText(buscaProdutos.get(contador).getTipoProd());
					alterarDescricao.setText(buscaProdutos.get(contador).getDescricaoProd());
					alterarQuantidade.setText(Integer.toString(buscaProdutos.get(contador).getQtdProd()));
					alterarPreco.setText(Float.toString(buscaProdutos.get(contador).getPrecoProd()));

				}
				
			}
		});
		btnAlterarProduto.setBackground(new Color(255, 255, 255));
		btnAlterarProduto.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		btnAlterarProduto.setBounds(371, 79, 184, 36);
		frmGerenteEstoque.getContentPane().add(btnAlterarProduto);
		
		
		
		JButton btnAlterar = new JButton("Alterar");
        btnAlterar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (!alterarNome.getText().equals("")) {
        			
        			Produto p = new Produto();
        			
        			try {
	        			p.setIdProd(buscaProdutos.get(contador).getIdProd());
	        			p.setNomeProd(alterarNome.getText());
	        			p.setPrecoProd(Float.parseFloat(alterarPreco.getText()));
	        			p.setDescricaoProd(alterarDescricao.getText());
	        			p.setQtdProd(Integer.parseInt(alterarQuantidade.getText()));
	        			p.setTipoProd(alterarTipo.getText());
        			} catch (Exception e1) {
        				Erro.setText("A alteração é permitida somente em produtos existentes");
        			}
        			
        			new Main().editarProd(p);
        			
        			produtos = new Main().getListaProd();

        			contador++;
        			
        			alterarNome.setText(null);
        			alterarPreco.setText(null);
        			alterarDescricao.setText(null);
        			alterarQuantidade.setText(null);
        			alterarTipo.setText(null);
        			
        			btnAlterarProduto.doClick();
        			
        		}
        		else {
        		}
        	}
        });
        btnAlterar.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
        btnAlterar.setBackground(Color.WHITE);
        btnAlterar.setBounds(812, 126, 103, 36);
        frmGerenteEstoque.getContentPane().add(btnAlterar);
		
        JButton btnResetar = new JButton("Resetar");
        btnResetar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		
        		bloqueio = true;
        		
        		contador = 0;
        		
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
        	    
        	    codigosProdutosEstoque.setVisible(true);
        	    produtosEstoque.setVisible(bloqueio);
				tipoProdutosEstoque.setVisible(bloqueio);
				descricaoProdutosEstoque.setVisible(bloqueio);
				quantidadeProdutosEstoque.setVisible(bloqueio);
				precoProdutosEstoque.setVisible(bloqueio);
				
				Erro.setText("");
				
				alterarNome.setVisible(!bloqueio);
				alterarTipo.setVisible(!bloqueio);
				alterarDescricao.setVisible(!bloqueio);
				alterarQuantidade.setVisible(!bloqueio);
				alterarPreco.setVisible(!bloqueio);
				
    			alterarNome.setText(null);
    			alterarPreco.setText(null);
    			alterarDescricao.setText(null);
    			alterarQuantidade.setText(null);
    			alterarTipo.setText(null);
        		
        	    buscaProdutos.clear();
        	
        	}
        });
        btnResetar.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
        btnResetar.setBackground(Color.WHITE);
        btnResetar.setBounds(699, 126, 103, 36);
        frmGerenteEstoque.getContentPane().add(btnResetar);
        
        JButton btnAdicionarProduto = new JButton("Adicionar Produto");
        btnAdicionarProduto.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
					
					produtosEstoque.setVisible(false);
					tipoProdutosEstoque.setVisible(false);
					descricaoProdutosEstoque.setVisible(false);
					quantidadeProdutosEstoque.setVisible(false);
					precoProdutosEstoque.setVisible(false);
					codigosProdutosEstoque.setVisible(false);
					
					alterarNome.setText(null);
	    			alterarPreco.setText(null);
	    			alterarDescricao.setText(null);
	    			alterarQuantidade.setText(null);
	    			alterarTipo.setText(null);
					
					 alterarNome.setVisible(true);
					 alterarTipo.setVisible(true);
					 alterarDescricao.setVisible(true);
					 alterarQuantidade.setVisible(true);
					 alterarPreco.setVisible(true);
        		
        	}
        });
        btnAdicionarProduto.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
        btnAdicionarProduto.setBackground(Color.WHITE);
        btnAdicionarProduto.setBounds(133, 79, 184, 36);
        frmGerenteEstoque.getContentPane().add(btnAdicionarProduto);
        
        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (!(alterarNome.getText().equals("") && alterarPreco.getText().equals("") && alterarQuantidade.getText().equals("") && alterarDescricao.getText().equals("") && alterarTipo.getText().equals(""))) {
        				Produto p = new Produto();
        				
    	    			try {
    	    				p.setNomeProd(alterarNome.getText());
        	    			p.setPrecoProd(Float.parseFloat(alterarPreco.getText()));
        	    			p.setDescricaoProd(alterarDescricao.getText());
        	    			p.setQtdProd(Integer.parseInt(alterarQuantidade.getText()));
        	    			p.setTipoProd(alterarTipo.getText());
        	    			
        	    			new Main().adicionarProd(p);
        	    			
        	    			produtos = new Main().getListaProd();
        	    			
    	    			} catch(Exception e1) {
    	    				Erro.setText("Somente números são permitidos nos campos de Quantidade e Preço");
    	    			} 

    	    			
    	    			alterarNome.setText(null);
    	    			alterarPreco.setText(null);
    	    			alterarDescricao.setText(null);
    	    			alterarQuantidade.setText(null);
    	    			alterarTipo.setText(null);
        		}
        	}
        });
        btnAdicionar.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
        btnAdicionar.setBackground(Color.WHITE);
        btnAdicionar.setBounds(925, 126, 103, 36);
        frmGerenteEstoque.getContentPane().add(btnAdicionar);
        
        JLabel imagem = new JLabel("");
		imagem.setIcon(new ImageIcon(new ImageIcon(Cadastro.class.getResource("/img/SportStockLogo.jpg")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		imagem.setBounds(0, 0, 121, 82);
		frmGerenteEstoque.getContentPane().add(imagem);
		
		JLabel imagem2 = new JLabel("");
		imagem2.setIcon(new ImageIcon(new ImageIcon(Cadastro.class.getResource("/img/iconGerente.jpg")).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		imagem2.setBounds(958, 11, 121, 82);
		frmGerenteEstoque.getContentPane().add(imagem2);
		
		String n = "<html><body>Gerente<br>" + Login.funNome + "</body></html>";
		JLabel tipoNomeFuncionario = new JLabel(n);
		tipoNomeFuncionario.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		tipoNomeFuncionario.setBounds(854, 11, 121, 57);
		frmGerenteEstoque.getContentPane().add(tipoNomeFuncionario);
        
       
        
        
	}
}
