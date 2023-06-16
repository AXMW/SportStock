/*
 * TODO
 * Ler produtos--
 * Registrar produtos--
 * Excluir produtos--
 * Alterar produtos--
 * Ler funcionario--
 * Registrar funcionario--
 * Excluir funcionario--
 * Alterar funcionario--
 * Ler clientes--
 * Registrar clientes--
 * editar clientes
 * excluir clientes--
 */

/*
 * Eu sei q o sistema n ta seguro mas ta funcionando e isso q importa :)
 */
package main;
import recursos.*;
import telas.*;
import java.io.File;
import java.util.ArrayList;
//import java.util.Arrays;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Main {
	java.sql.Connection Conexao = null;
	java.sql.Statement Comando;
	java.sql.ResultSet rsRegistro;

	private static ArrayList<Produto> produtos = new ArrayList<Produto>();
	private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static ArrayList<Venda> vendas = new ArrayList<Venda>();
	private static ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	private static ArrayList<Cupom> cupons = new ArrayList<Cupom>();
	
	//Metodo para fazer a conexao com o SQL
	private void conecta() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			
			File arquivo = new File("./../SportStockBD.accdb");
			if(!arquivo.exists()) {
				JOptionPane.showMessageDialog(null, "Arquivo não existe");
				System.exit(1);
			}
			String database = "jdbc:ucanaccess://" + arquivo.getAbsolutePath().trim();
			Conexao = DriverManager.getConnection(database);
		}
		catch (Exception Excecao) {
			Excecao.printStackTrace();
		}
	}
	
	/*
	//Metodo para receber dados do produto
	private static Produto lerDadosProd(){
		
		String nome = JOptionPane.showInputDialog("Insira o nome do produto: ");
		while (!validarNome(nome)){
			JOptionPane.showMessageDialog(null, "O nome não pode ter números ou caracteres especiais e tem que ter pelo menos 3 letras");
			nome = JOptionPane.showInputDialog("Insira o nome do produto: ");
		}

		String tipo = JOptionPane.showInputDialog("Insira o tipo do produto: ");

		float preco = 0;
		while (true) {
			try {
				preco = Float.parseFloat(JOptionPane.showInputDialog("Insira o preco do produto: "));
				if (preco > 0 ){
					break;
				} else {
					JOptionPane.showMessageDialog(null, "Digite valores maiores que 0.");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Digite apenas números e utilize . para a separação da casa decimal.");
			}
		}

		String descricao = JOptionPane.showInputDialog("Insira a descricao do produto: ");

		int qtd = 0;
		while (true) {
			try {
				qtd = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de produtos: "));
				if (qtd > 0 ){
					break;
				} else {
					JOptionPane.showMessageDialog(null, "Digite valores maiores que 0.");
				}} 
				catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Digite apenas números inteiros.");
			}
		}

		Produto p2 = new Produto();
		p2.setNomeProd(nome);
		p2.setTipoProd(tipo);
		p2.setPrecoProd(preco);
		p2.setDescricaoProd(descricao);
		p2.setQtdProd(qtd);

		return p2;
	}

	//Metodo para receber dados do funcionário
	private static Funcionario lerDadosFun(){
		
		String nome = JOptionPane.showInputDialog("Insira o nome do funcionario: ");
		while (!validarNome(nome)){
			JOptionPane.showMessageDialog(null, "O nome não pode ter números ou caracteres especiais e tem que ter pelo menos 3 letras");
			nome = JOptionPane.showInputDialog("Insira o nome do funcionario: ");
		}

		String senha = JOptionPane.showInputDialog("Insira a senha de login do funcionario: ");
		while (!validarSenha(senha)){
			JOptionPane.showMessageDialog(null, "A senha deve ter:\n-No minimo 7 caracteres\n-Pelo menos 1 letra maiuscula\n-Pelo menos 1 letra minuscula\n-Pelo menos 1 numero");
			senha = JOptionPane.showInputDialog("Insira a senha de login do funcionario: ");
		}

		String hierarquia = JOptionPane.showInputDialog("Insira a hierarquia do funcionario: ");


		Funcionario f2 = new Funcionario();
		f2.setNomeFun(nome);
		f2.setSenhaFun(senha);
		f2.setHierarquiaFun(hierarquia);
	
		return f2;
	}
	
	//Metodo para receber dados do cliente
	private static Cliente lerDadosCli(){


		String nome = JOptionPane.showInputDialog("Insira o nome do cliente: ");
		while (!validarNome(nome)){
			JOptionPane.showMessageDialog(null, "O nome não pode ter números ou caracteres especiais e tem que ter pelo menos 3 letras");
			nome = JOptionPane.showInputDialog("Insira o nome do cliente: ");
		}

		long cpf = 0;
		while (true) {
            try {
                cpf = Long.parseLong(JOptionPane.showInputDialog("Insira o CPF do cliente: "));
				if (validarCPF(cpf)) {
					break;
				}else {
					JOptionPane.showMessageDialog(null, "Digite um CPF Válido.");
				}
                } 
                catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Digite apenas números inteiros.");
            }
        }
		
		
		long telefone = 0;
		while (true) {
            try {
                telefone = Long.parseLong(JOptionPane.showInputDialog("Insira o telefone do cliente: "));
				if (validarTelefone(telefone)) {
					break;
				}else {
					JOptionPane.showMessageDialog(null, "Digite um telefone Válido.");
				}
                } 
                catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Digite apenas números inteiros.");
            }
        }

		String email = "";
        while (true) {
            try {
                email = JOptionPane.showInputDialog("Insira o email do cliente: ");
                email = email.strip();
                if (validarEmail(email)){
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Digite um email válido");
                }
            } 
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Digite um email válido.");
            }
        }


		Cliente c2 = new Cliente();
		c2.setNomeCli(nome);
		c2.setCpfCli(cpf);
		c2.setTelefoneCli(telefone);
		c2.setEmailCli(email);

		return c2;
	}

	private static Fornecedor lerDadosFornec(){


		String nome = JOptionPane.showInputDialog("Insira o nome do fornecedor: ");
		while (!validarNome(nome)){
			JOptionPane.showMessageDialog(null, "O nome não pode ter números ou caracteres especiais e tem que ter pelo menos 3 letras");
			nome = JOptionPane.showInputDialog("Insira o nome do fornecedor: ");
		}

		long telefone = 0;
		while (true) {
            try {
                telefone = Long.parseLong(JOptionPane.showInputDialog("Insira o telefone do fornecedor: "));
				if (validarTelefone(telefone)) {
					break;
				}else {
					JOptionPane.showMessageDialog(null, "Digite um telefone Válido.");
				}
                } 
                catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Digite apenas números inteiros.");
            }
        }

		String email = "";
        while (true) {
            try {
                email = JOptionPane.showInputDialog("Insira o email do fornecedor: ");
                email = email.strip();
                if (validarEmail(email)){
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Digite um email válido");
                }
            } 
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Digite um email válido.");
            }
        }


		Fornecedor f2 = new Fornecedor();
		f2.setNomeFornec(nome);
		f2.setTelefoneFornec(telefone);
		f2.setEmailFornec(email);

		return f2;
	}
	
	//Metodo para receber os dados do Cupom
	private static Cupom lerDadosCupom() {
		String codigo = JOptionPane.showInputDialog("Insira o codigo do cupom");
		float porcentagem = 0;
		while(true) {
			try {
				porcentagem = Float.parseFloat(JOptionPane.showInputDialog("Insira a porcentagem de desconto do cupom"));
				if(porcentagem < 20 && porcentagem > 0) {
					break;
				}
			}
			catch(Exception Excecao) {
				JOptionPane.showMessageDialog(null, "Insira apenas valores numericos até 20 para o desconto");
			}
		}
		int qtdUsos = 0;
		while(true) {
			try {
				qtdUsos = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de usos do cupom"));
				if(qtdUsos > 0) {
					break;
				}
			}
			catch(Exception Excecao) {
				JOptionPane.showMessageDialog(null, "Insira apenas numeros inteiros e positivos para a quantidade");
			}
		}
		Cupom c1 = new Cupom();
		c1.setCodCupom(codigo);
		c1.setPorcentagemCupom(porcentagem);
		
		return c1;
	} */

	//Metodo para ler os dados dos produtos e adicionar em um arraylist
	private void consultaProd() {
		try {
			rsRegistro = Conexao.createStatement().executeQuery("SELECT * FROM Produto");
			while(rsRegistro.next()) {
				Produto p1 = new Produto();
				p1.setNomeProd(rsRegistro.getString("nomeProd"));
				p1.setIdProd(rsRegistro.getInt("idProd"));
				p1.setTipoProd(rsRegistro.getString("tipoProd"));
				p1.setPrecoProd(rsRegistro.getFloat("precoProd"));
				p1.setDescricaoProd(rsRegistro.getString("descricaoProd"));
				p1.setQtdProd(rsRegistro.getInt("qtdProd"));
				p1.setProdutosTrocados(rsRegistro.getInt("produtosTrocados"));
				produtos.add(p1);
			}
		}
		catch (Exception Excecao) {
			JOptionPane.showMessageDialog(null, "SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Metodo para ler os dados dos funcionarios e adicionar em um arraylist
	private void consultaFun() {
		try {
			rsRegistro = Conexao.createStatement().executeQuery("SELECT * FROM Funcionario");
			while(rsRegistro.next()) {
				Funcionario f1 = new Funcionario();
				f1.setNomeFun(rsRegistro.getString("nomeFun"));
				f1.setIdFun(rsRegistro.getInt("idFun"));
				f1.setSenhaFun(rsRegistro.getString("senhaFun"));
				f1.setHierarquiaFun(rsRegistro.getString("hierarquiaFun"));
				funcionarios.add(f1);
			}
		}
		catch (Exception Excecao) {
			JOptionPane.showMessageDialog(null, "SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	//Metodo para ler clientes
	private void consultaCli() {
		try {
			rsRegistro = Conexao.createStatement().executeQuery("SELECT * FROM Cliente");
			while(rsRegistro.next()) {
				Cliente c1 = new Cliente();
				c1.setNomeCli(rsRegistro.getString("nomeCli"));
				c1.setCpfCli(Long.parseLong(rsRegistro.getString("cpfCli")));
				c1.setTelefoneCli(Long.parseLong(rsRegistro.getString("telefoneCli")));
				c1.setEmailCli(rsRegistro.getString("emailCli"));
				clientes.add(c1);
			}
		}
		catch (Exception Excecao) {
			JOptionPane.showMessageDialog(null, "SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/*
	//Metodo pra ler Vendas
	private void consultaVenda() {
		try {
			rsRegistro = Conexao.createStatement().executeQuery("SELECT * FROM Venda");
			while(rsRegistro.next()) {
				Venda v1 = new Venda();
				v1.setCodVenda(rsRegistro.getInt("codVenda"));
				v1.setPrecoVenda(rsRegistro.getFloat("precoVenda"));
				v1.setDataVenda(rsRegistro.getString("dataVenda"));
				v1.setDescricaoVenda(rsRegistro.getString("descricaoVenda"));
				vendas.add(v1);
			}
		}
		catch (Exception Excecao) {
			JOptionPane.showMessageDialog(null, "SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro", JOptionPane.INFORMATION_MESSAGE);
		}
	}*/

	//Metodo para ler fornecedor
	private void consultaFornec() {
		try {
			rsRegistro = Conexao.createStatement().executeQuery("SELECT * FROM Fornecedor");
			while(rsRegistro.next()) {
				Fornecedor f1 = new Fornecedor();
				f1.setIdFornec(rsRegistro.getInt("idFornec"));
				f1.setNomeFornec(rsRegistro.getString("nomeFornec"));
				f1.setTelefoneFornec(Long.parseLong(rsRegistro.getString("telefoneFornec")));
				f1.setEmailFornec(rsRegistro.getString("emailFornec"));
				fornecedores.add(f1);
			}
		}
		catch (Exception Excecao) {
			JOptionPane.showMessageDialog(null, "SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	//Metoto para ler Cupons
	private void consultaCupom() {
		try {
			rsRegistro = Conexao.createStatement().executeQuery("SELECT * FROM Cupom");
			while(rsRegistro.next()) {
				Cupom c1 = new Cupom();
				c1.setIdCupom(rsRegistro.getInt("idCupom"));
				c1.setCodCupom(rsRegistro.getString("codCupom"));
				c1.setPorcentagemCupom(rsRegistro.getFloat("porcentagemCupom"));
				cupons.add(c1);
			}
		}
		catch (Exception Excecao) {
			JOptionPane.showMessageDialog(null, "SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Metodo pra fazer uma nova venda
	public void criarVenda(ArrayList<Venda> vendaA, int idCupomDesc, float totalDaVenda) {
		conecta();
		Venda venda = new Venda();
		venda.setPrecoVenda(totalDaVenda);
		venda.setIdCupomDesconto(idCupomDesc);
		PreparedStatement strComandoSQL;
		for(int i = 0; i < vendaA.size(); ++i) {
			int quantidadeProd = produtos.get(venda.getIndexProd()).getQtdProd();
			quantidadeProd -= vendaA.get(i).getQtdProd();
			try {
				produtos.get(vendaA.get(i).getIndexProd()).setQtdProd(quantidadeProd);
				strComandoSQL = Conexao.prepareStatement("UPDATE Produto SET qtdProd = ? WHERE idProd= ?");
				strComandoSQL.setInt(1, quantidadeProd);
				strComandoSQL.setInt(2, vendaA.get(i).getIdProd());
				try {
					strComandoSQL.executeUpdate();
				}
				catch (Exception Excecao) {
					JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecaoo de registro",JOptionPane.INFORMATION_MESSAGE);
				}
			} catch(Exception exce) {
				JOptionPane.showMessageDialog(null,"SQLException: " + exce.getMessage(),"Erro: Selecaoo de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		try {
			strComandoSQL = Conexao.prepareStatement("INSERT INTO Venda (precoVenda, dataVenda, idFun, idCupom)" + " VALUES (?,?,?,?)");
			strComandoSQL.setFloat(1, venda.getPrecoVenda());
			strComandoSQL.setString(2, venda.getDataVenda());
			strComandoSQL.setInt(3, Login.funId);
			strComandoSQL.setInt(4, venda.getIdCupomDesconto());
			try {
				int intRegistro = strComandoSQL.executeUpdate();
				if(intRegistro != 0) {
					rsRegistro = Conexao.createStatement().executeQuery("SELECT codVenda FROM Venda");
					int codigo = 0;
					while(rsRegistro.next()) {
						if(codigo < rsRegistro.getInt("codVenda")) {
							codigo = rsRegistro.getInt("codVenda");
						}
					}
					venda.setCodVenda(codigo);
					
					
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecaoo de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		catch (Exception Excecao) {
			JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecaoo de registro",JOptionPane.INFORMATION_MESSAGE);
		}
	
		vendas.add(venda);
	}
	
	//Metodo para adicionar novos produtos
	public void adicionarProd(Produto p) {
		
		conecta();
		
		try {
			PreparedStatement strComandoSQL = Conexao.prepareStatement("INSERT INTO Produto (nomeProd, tipoProd, descricaoProd, qtdProd, precoProd)" + " VALUES (?,?,?,?,?)");
			strComandoSQL.setString(1, p.getNomeProd());
			strComandoSQL.setString(2, p.getTipoProd());
			strComandoSQL.setString(3, p.getDescricaoProd());
			strComandoSQL.setInt(4, p.getQtdProd());
			strComandoSQL.setFloat(5, p.getPrecoProd());
			int intRegistro = strComandoSQL.executeUpdate();
			if(intRegistro != 0) {
				rsRegistro = Conexao.createStatement().executeQuery("SELECT idProd FROM Produto");
				int codigo = 0;
				while(rsRegistro.next()) {
					if(codigo < rsRegistro.getInt("idProd")) {
						codigo = rsRegistro.getInt("idProd");
					}
				}
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
			}
		}
		catch (Exception Excecao) {
			JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	//Metodo para adicionar novos funcionarios
	public boolean adicionarFun(Funcionario f2) {
		conecta();
		try {
			PreparedStatement strComandoSQL = Conexao.prepareStatement("INSERT INTO Funcionario (nomeFun, senhaFun, hierarquiaFun)" + " VALUES (?,?,?)");
			strComandoSQL.setString(1, f2.getNomeFun());
			strComandoSQL.setString(2, f2.getSenhaFun());
			strComandoSQL.setString(3, f2.getHierarquiaFun());
			int intRegistro = strComandoSQL.executeUpdate();
			if(intRegistro != 0) {
				rsRegistro = Conexao.createStatement().executeQuery("SELECT idFun FROM Funcionario");
				int codigo = 0;
				while(rsRegistro.next()) {
					if(codigo < rsRegistro.getInt("idFun")) {
						codigo = rsRegistro.getInt("idFun");
					}
				}
				f2.setIdFun(codigo);
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso o seu ID é " + codigo);
				funcionarios.add(f2);
				return true;
			}
		}
		catch (Exception Excecao) {
			JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
		}
		return false;
	}
	
	//Metodo para adicionar clientes
	public void adicionarCli(Cliente c2) {
		conecta();
		try {
			String cpf = c2.getCpfCli() + "";
			String telefone = c2.getTelefoneCli() + "";
			PreparedStatement strComandoSQL = Conexao.prepareStatement("INSERT INTO Cliente (cpfCli, nomeCli, telefoneCli, emailCli, idFun)" + " VALUES (?,?,?,?,?)");
			strComandoSQL.setString(1, cpf);
			strComandoSQL.setString(2, c2.getNomeCli());
			strComandoSQL.setString(3, telefone);
			strComandoSQL.setString(4, c2.getEmailCli());
			strComandoSQL.setInt(5, Login.funId);
			int intRegistro = strComandoSQL.executeUpdate();
			if(intRegistro != 0) {
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
				clientes.add(c2);
			}
		}
		catch (Exception Excecao) {
			JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Metodo para adicionar fornecedor
	public void adicionarFornec(Fornecedor f) {
		conecta();
		String telefone = f.getTelefoneFornec() + "";
		try {
			PreparedStatement strComandoSQL = Conexao.prepareStatement("INSERT INTO Fornecedor (nomeFornec, telefoneFornec, emailFornec)" + " VALUES (?,?,?)");
			strComandoSQL.setString(1, f.getNomeFornec());
			strComandoSQL.setString(2, telefone);
			strComandoSQL.setString(3, f.getEmailFornec());
			int intRegistro = strComandoSQL.executeUpdate();
			if(intRegistro != 0) {
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
			}
		}
		catch (Exception Excecao) {
			JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Metodo para adicionar cupom
	public void adicionarCupom(Cupom c2) {
		conecta();
		try {
			PreparedStatement strComandoSQL = Conexao.prepareStatement("INSERT INTO Cupom (codCupom, porcentagemCupom)" + " VALUES (?,?)");
			strComandoSQL.setString(1, c2.getCodCupom());
			strComandoSQL.setFloat(2, c2.getPorcentagemCupom());

			int intRegistro = strComandoSQL.executeUpdate();
			if(intRegistro != 0) {
				rsRegistro = Conexao.createStatement().executeQuery("SELECT idCupom FROM Cupom");
				int codigo = 0;
				while(rsRegistro.next()) {
					if(codigo < rsRegistro.getInt("idCupom")) {
						codigo = rsRegistro.getInt("idCupom");
					}
				}
				c2.setIdCupom(codigo);
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
				cupons.add(c2);
			}
		}
		catch (Exception Excecao) {
			JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
		}
	}

	//Metodo para excluir produtos
	public void excluirProd(int n) {
		conecta();
		int j = 0;
		for(int i = 0; i < produtos.size(); ++i) {
			if(produtos.get(i).getIdProd() == n) {
				j = i;
				break;
			}
		}
		int num = JOptionPane.showConfirmDialog(null, "Confirma a exclusão?\nID: " + produtos.get(j).getIdProd() + "\nNome: " + produtos.get(j).getNomeProd() + "\nTipo: " + produtos.get(j).getTipoProd() + "\nPreco: " + produtos.get(j).getPrecoProd() + "\nDescricao: " + produtos.get(j).getDescricaoProd() + "\nQuantidade disponivel: " + produtos.get(j).getQtdProd(), "Exclusão", JOptionPane.YES_NO_OPTION);
		if(num == 0) {
			try {
				PreparedStatement strComandoSQL = Conexao.prepareStatement("DELETE from Produto WHERE" + " idProd= ?");
				strComandoSQL.setInt(1, n);
				int intRegistro = strComandoSQL.executeUpdate();
				if(intRegistro != 0) {
					JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	//Metodo para excluir funcionario
	public void excluirFun(int n) {
		conecta();
		int j = 0;
		for(int i = 0; i < funcionarios.size(); ++i) {
			if(funcionarios.get(i).getIdFun() == n) {
				j = i;
				break;
			}
		}
		int num = JOptionPane.showConfirmDialog(null, "Confirma a exclusão?\nID: " + funcionarios.get(j).getIdFun() + "\nNome: " + funcionarios.get(j).getNomeFun() + "\nSenha: " + funcionarios.get(j).getSenhaFun() + "\nHierarquia: " + funcionarios.get(j).getHierarquiaFun(), "Exclusão", JOptionPane.YES_NO_OPTION);
		if(num == 0) {
			try {
				PreparedStatement strComandoSQL = Conexao.prepareStatement("DELETE from Funcionario WHERE" + " idFun= ?");
				strComandoSQL.setInt(1, n);
				int intRegistro = strComandoSQL.executeUpdate();
				if(intRegistro != 0) {
					JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	//Metodo para excluir clientes
	public void excluirCli(long n) {
		conecta();
		
		int j = 0;
		for(int i = 0; i < clientes.size(); ++i) {
			if (clientes.get(i).getCpfCli() == n) {
				j = i;
				break;
			}
		}
		int num = JOptionPane.showConfirmDialog(null, "Confirma a exclusão?\nCPF: " + clientes.get(j).getCpfCli() + "\nNome: " + clientes.get(j).getNomeCli() + "\nTelefone: " + clientes.get(j).getTelefoneCli() + "\nEmail: " +  clientes.get(j).getEmailCli(), "Exclusão", JOptionPane.YES_NO_OPTION);
		if(num == 0) {
			try {
				PreparedStatement strComandoSQL = Conexao.prepareStatement("DELETE from Cliente WHERE" + " cpfCli= ?");
				strComandoSQL.setLong(1, n);
				int intRegistro = strComandoSQL.executeUpdate();
				if(intRegistro != 0) {
					JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	//Metodo para excluir fornecedor
	public void excluirFornec(int n) {
		conecta();
		
		int j = 0;
		for(int i = 0; i < fornecedores.size(); ++i) {
			if(fornecedores.get(i).getIdFornec() == n) {
				j = i;
				break;
			}
		}
		int num = JOptionPane.showConfirmDialog(null, "Confirma a exclusão?\nNome: " + fornecedores.get(j).getNomeFornec() + "\nTelefone: " + fornecedores.get(j).getTelefoneFornec() + "\nEmail: " + fornecedores.get(j).getEmailFornec(), "Exclusão", JOptionPane.YES_NO_OPTION);
		if(num == 0) {
			try {
				PreparedStatement strComandoSQL = Conexao.prepareStatement("DELETE from Fornecedor WHERE" + " idFornec= ?");
				strComandoSQL.setInt(1, n);
				int intRegistro = strComandoSQL.executeUpdate();
				if(intRegistro != 0) {
					JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	//Metodo para excluir cupom
	/*
	private void excluirCupom() {
		for(int i = 0; i < cupons.size(); ++i) {
			JOptionPane.showMessageDialog(null, "ID: " + cupons.get(i).getIdCupom() + "\nCodigo: " + cupons.get(i).getCodCupom() + "\nPorcentagem: " + cupons.get(i).getPorcentagemCupom());
		}
		int n = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do cupom que deseja excluir"));
		int j = 0;
		for(int i = 0; i < cupons.size(); ++i) {
			if(cupons.get(i).getIdCupom() == n) {
				j = i;
				break;
			}
		}
		int num = JOptionPane.showConfirmDialog(null, "Confirma a exclusão?\nID: " + cupons.get(j).getIdCupom() + "\nCodigo: " + cupons.get(j).getCodCupom() + "\nPorcentagem: " + cupons.get(j).getPorcentagemCupom(), "Exclusão", JOptionPane.YES_NO_OPTION);
		if(num == 0) {
			try {
				PreparedStatement strComandoSQL = Conexao.prepareStatement("DELETE from Cupom WHERE" + " idCupom= ?");
				strComandoSQL.setInt(1, n);
				int intRegistro = strComandoSQL.executeUpdate();
				if(intRegistro != 0) {
					JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
					cupons.remove(j);
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}*/

	//Metodo para editar produtos
	public void editarProd(Produto p) {
		conecta();
		int num = JOptionPane.showConfirmDialog(null, "Confirma a edição?\nID: " + p.getIdProd() + "\nNome: " + p.getNomeProd() + "\nTipo: " + p.getTipoProd() + "\nPreco: " + p.getPrecoProd() + "\nDescricao: " + p.getDescricaoProd() + "\nQuantidade disponivel: " + p.getQtdProd(), "Edição", JOptionPane.YES_NO_OPTION);
		if(num == 0) {

			try {
				PreparedStatement strComandoSQL = Conexao.prepareStatement("UPDATE Produto SET (nomeProd, tipoProd, descricaoProd, qtdProd, precoProd)" + " = (?,?,?,?,?) WHERE idProd = ?");
				strComandoSQL.setString(1, p.getNomeProd());
				strComandoSQL.setString(2, p.getTipoProd());
				strComandoSQL.setString(3, p.getDescricaoProd());
				strComandoSQL.setInt(4, p.getQtdProd());
				strComandoSQL.setFloat(5, p.getPrecoProd());
				strComandoSQL.setInt(6, p.getIdProd());
				int intRegistro = strComandoSQL.executeUpdate();
				if(intRegistro != 0) {
					JOptionPane.showMessageDialog(null, "Edição realizada com sucesso");
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	//Metodo para editar funcionario
	public void editarFun(Funcionario f) {
		conecta();
		int num = JOptionPane.showConfirmDialog(null, "Confirma a edição?\nID: " + f.getIdFun() + "\nNome: " + f.getNomeFun() + "\nSenha: " + f.getSenhaFun() + "\nHierarquia: " + f.getHierarquiaFun(), "Edição", JOptionPane.YES_NO_OPTION);
		if(num == 0) {
	
			try {
				PreparedStatement strComandoSQL = Conexao.prepareStatement("UPDATE Funcionario SET (nomeFun, senhaFun, hierarquiaFun)" + " = (?,?,?) WHERE idFun= ?");
				strComandoSQL.setString(1, f.getNomeFun());
				strComandoSQL.setString(2, f.getSenhaFun());
				strComandoSQL.setString(3, f.getHierarquiaFun());
				strComandoSQL.setInt(4, f.getIdFun());
				int intRegistro = strComandoSQL.executeUpdate();
				if(intRegistro != 0) {
					JOptionPane.showMessageDialog(null, "Edição realizada com sucesso");
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Edição cancelada");
		}
	}
	
	//Metodo para editar cliente
	public void editarCli(Cliente c) {
		conecta();
		
		int num = JOptionPane.showConfirmDialog(null, "Confirma a edição?\nCPF: " + c.getCpfCli() + "\nNome: " + c.getNomeCli() + "\nTelefone: " + c.getTelefoneCli() + "\nEmail: " +  c.getEmailCli(), "Edição", JOptionPane.YES_NO_OPTION);
		if(num == 0) {

			try {
				String cpf = c.getCpfCli() + "";
				String telefone = c.getTelefoneCli() + "";
				PreparedStatement strComandoSQL = Conexao.prepareStatement("UPDATE Cliente SET (cpfCli, nomeCli, telefoneCli, emailCli)" + " = (?,?,?,?) WHERE cpfCli= ?");
				strComandoSQL.setString(1, cpf);
				strComandoSQL.setString(2, c.getNomeCli());
				strComandoSQL.setString(3, telefone);
				strComandoSQL.setString(4, c.getEmailCli());
				strComandoSQL.setString(5, cpf);
				int intRegistro = strComandoSQL.executeUpdate();
				if(intRegistro != 0) {
					JOptionPane.showMessageDialog(null, "Edição realizada com sucesso");
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	}
	
	//Metodo para editar fornecedor
	public void editarFornec(Fornecedor f) {
		conecta();
		int num = JOptionPane.showConfirmDialog(null, "Confirma a edição?\nNome: " + f.getNomeFornec() + "\nTelefone: " + f.getTelefoneFornec() + "\nEmail: " + f.getEmailFornec(), "Edição", JOptionPane.YES_NO_OPTION);
		if(num == 0) {
			String telefone = f.getTelefoneFornec() + "";
			try {
				PreparedStatement strComandoSQL = Conexao.prepareStatement("UPDATE Fornecedor SET (nomeFornec, telefoneFornec, emailFornec)" + " = (?,?,?) WHERE idFornec= ?");
				strComandoSQL.setString(1, f.getNomeFornec());
				strComandoSQL.setString(2, telefone);
				strComandoSQL.setString(3, f.getEmailFornec());
				strComandoSQL.setInt(4, f.getIdFornec());
				int intRegistro = strComandoSQL.executeUpdate();
				if(intRegistro != 0) {
					JOptionPane.showMessageDialog(null, "Edição realizada com sucesso");
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	}
	
	//Metodo para editar cupom
	/*
	private void editarCupom() {
		for(int i = 0; i < cupons.size(); ++i) {
			JOptionPane.showMessageDialog(null, "ID: " + cupons.get(i).getIdCupom() + "\nCodigo: " + cupons.get(i).getCodCupom() + "\nPorcentagem: " + cupons.get(i).getPorcentagemCupom());
		}
		int n = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do cupom que deseja editar"));
		int j = 0;
		for(int i = 0; i < cupons.size(); ++i) {
			if(cupons.get(i).getIdCupom() == n) {
				j = i;
				break;
			}
		}
		int num = JOptionPane.showConfirmDialog(null, "Confirma a edição?\nID: " + cupons.get(j).getIdCupom() + "\nCodigo: " + cupons.get(j).getCodCupom() + "\nPorcentagem: " + cupons.get(j).getPorcentagemCupom(), "Exclusão", JOptionPane.YES_NO_OPTION);
		if(num == 0) {
			Cupom c2 = new Cupom();
			c2 = lerDadosCupom();
				
			try {
				PreparedStatement strComandoSQL = Conexao.prepareStatement("UPDATE Cupom SET(codCupom, porcentagemCupom)" + " = (?,?) WHERE idCupom= ?");
				strComandoSQL.setString(1, c2.getCodCupom());
				strComandoSQL.setFloat(2, c2.getPorcentagemCupom());
				strComandoSQL.setInt(3, n);
				int intRegistro = strComandoSQL.executeUpdate();
				if(intRegistro != 0) {
					JOptionPane.showMessageDialog(null, "Edição realizada com sucesso");
					cupons.set(j, c2);
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
			}
				
		}
			
	}*/
	
	//Metodo para alterar o estoque
	/*
	private void alterarEstoque() {
		for(int i = 0; i < produtos.size(); ++i) {
			String str = "ID: " + produtos.get(i).getIdProd() + "\nNome: " + produtos.get(i).getNomeProd() + "\nTipo: " + produtos.get(i).getTipoProd() + "\nPreco: " + produtos.get(i).getPrecoProd() + "\nDescricao: " + produtos.get(i).getDescricaoProd() + "\nQuantidade disponivel: " + produtos.get(i).getQtdProd();
			JOptionPane.showMessageDialog(null, str);
		}
		int n = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do produto que deseja editar"));
		int j = 0;
		for(int i = 0; i < produtos.size(); ++i) {
			if(produtos.get(i).getIdProd() == n) {
				j = i;
				break;
			}
		}
		int num = JOptionPane.showConfirmDialog(null, "Confirma a edição?\nID: " + produtos.get(j).getIdProd() + "\nNome: " + produtos.get(j).getNomeProd() + "\nTipo: " + produtos.get(j).getTipoProd() + "\nPreco: " + produtos.get(j).getPrecoProd() + "\nDescricao: " + produtos.get(j).getDescricaoProd() + "\nQuantidade disponivel: " + produtos.get(j).getQtdProd(), "Edição", JOptionPane.YES_NO_OPTION);
		if(num == 0) {
			int qtd = 0;
			while(true) {
				try {
					qtd = Integer.parseInt(JOptionPane.showInputDialog("Insira a nova quantidade de itens no estoque, a quantidade atual é " + produtos.get(j).getQtdProd()));
					break;
				}
				catch(Exception Excecao) {
					JOptionPane.showMessageDialog(null, "Insira apenas numeros inteiros maiores ou igual a zero");
				}
			}
			try {
				PreparedStatement strComandoSQL = Conexao.prepareStatement("UPDATE Produto SET qtdProd = ? WHERE idProd= ?");
				strComandoSQL.setInt(1, qtd);
				strComandoSQL.setInt(2, n);
				int intRegistro = strComandoSQL.executeUpdate();
				produtos.get(j).setQtdProd(qtd);
				if(intRegistro != 0) {
					JOptionPane.showMessageDialog(null, "Alteração feita com sucesso");
				}
			}
			catch(Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	}*/

	private void executa() {
		/*conecta();
		consultaProd();
		consultaFun();
		consultaCli();
		consultaVenda();
		consultaFornec();
		consultaCupom();*/
		//o que eu queria fazer n funcionou, acho q deveria ter feito medicina na usp era mais facil q isso
		Login.telaLogin();
		
	}
	
	public ArrayList<Funcionario> getListaFun() {
		conecta();
		funcionarios.clear();
		consultaFun();
		return funcionarios;
	}
	public ArrayList<Cliente> getListaCli() {
		conecta();
		clientes.clear();
		consultaCli();
		return clientes;
	}
	public ArrayList<Produto> getListaProd() {
		conecta();
		produtos.clear();
		consultaProd();
		return produtos;
	}
	public ArrayList<Venda> getListaVenda() {
		conecta();
		vendas.clear();
		consultaProd();
		return vendas;
	}
	public ArrayList<Fornecedor> getListaFornec() {
		conecta();
		fornecedores.clear();
		consultaFornec();
		return fornecedores;
	}
	public ArrayList<Cupom> getListaCupom() {
		conecta();
		cupons.clear();
		consultaCupom();
		return cupons;
	}

	/*
	 * Em memoria do esforco do miguel
	//Metodo para validar o nome de acordo com o padrão
	private static boolean validarNome(String nome){

		if (!nome.replaceAll(" ", "").matches("[A-Za-z]*")){
			return false;
		}
		if (nome.replaceAll(" ", "").length() < 3){
			return false;
		}
		
		return true;
	}

	//Metodo para validar a senha de acordo com o padrão
	private static boolean validarSenha(String senha){
		
		if (senha.length() < 7){
			return false;
		}

		boolean num= false, mai = false, min = false;

		for (int i = 0; i < senha.length(); i++) {
			if (Character.isDigit(senha.charAt(i))) {
				num = true;
			}
			if (Character.isUpperCase(senha.charAt(i))) {
				mai = true;
			}
			if (Character.isLowerCase(senha.charAt(i))) {
				min = true;
			}
		}

		if (num == false || mai == false || min == false){
			return false;
		}
		
		return true;
	}

	//Metodo para validar o CPF de acordo com o padrão
	private static boolean validarCPF(long cpf){
		String cpfStr = Long.toString(cpf);
		int valida = 0;
		//Verificar se a quantidade de numeros e a mesma de um CPF
		if (cpfStr.length() != 11) {
			return false;
		}
		//Verificador 1
		cpf = Long.parseLong(cpfStr.substring(0, 9));

		for(int i = 2; cpf != 0; i++) {
			valida += (cpf % 10)*i;
			cpf /= 10;
		}

		if ((valida % 11) < 2){
			valida = 0;
		} else {
			valida = 11 - (valida % 11);
		}
		if (!(valida == (cpfStr.charAt(9) - '0'))){
			return false;
		}

		//Verificador 2
		cpf = Long.parseLong(cpfStr.substring(0, 10));
		for(int i = 2; cpf != 0; i++) {
			valida += (cpf % 10)*i;
			cpf /= 10;
		}

		if ((valida % 11) < 2){
			valida = 0;
		} else {
			valida = 11 - (valida % 11);
		}
		if (!(valida == (cpfStr.charAt(10) - '0'))){
			return false;
		}
		
		return true;
	}

	//Metodo para validar o telefone de acordo com o padrão
	private static boolean validarTelefone(long telefone){
		String telefoneStr = Long.toString(telefone);
		
		if (telefoneStr.length() < 10 || telefoneStr.length() > 11) {
			return false;
		}
		if (telefoneStr.length() == 11 && telefoneStr.substring(1, 2).equals("9")) {
			return false;
		}

		Integer[] codigosDDD = {
			11, 12, 13, 14, 15, 16, 17, 18, 19,
			21, 22, 24, 27, 28, 31, 32, 33, 34,
			35, 37, 38, 41, 42, 43, 44, 45, 46,
			47, 48, 49, 51, 53, 54, 55, 61, 62,
			64, 63, 65, 66, 67, 68, 69, 71, 73,
			74, 75, 77, 79, 81, 82, 83, 84, 85,
			86, 87, 88, 89, 91, 92, 93, 94, 95,
			96, 97, 98, 99};

		if ( telefoneStr.length() == 11 && Arrays.asList(codigosDDD).indexOf(Integer.parseInt(telefoneStr.substring(0, 2))) == -1) { 
			return false;
		}
		Integer[] ddd = {2, 3, 4, 5, 7};

		if ( telefoneStr.length() == 10 && Arrays.asList(ddd).indexOf(Integer.parseInt(telefoneStr.substring(0, 1))) == -1) {
			return false;
		}

		return true;
	}

	//Metodo para validar o email de acordo com o padrão
	private static boolean validarEmail(String email) throws Exception {
		
		//possuir algum caracter apos o .
        //não ter espacos
		if (email.contains(" ")) {
			return false;
		}

        //não ter carcteres especiais, menos [@._]
		if (!(email.matches("[A-Za-z0-9_.@]*"))) {
			return false;
		}

        //ter apenas alfanumerico no caracter previo ao @
		if (!email.substring((email.indexOf("@")-1), (email.indexOf("@"))).matches("[A-Za-z0-9]*")) {
			return false;
		}

        //ter letras minusculas no caracter logo apos ao @
		if (!String.valueOf(email.charAt((email.indexOf("@")+1))).matches("[a-z]*")) {            
			return false;
		}

        //ter . depois do @
		if (!email.substring((email.indexOf("@")+2)).contains(".")) {
			return false;
		}

        //ter apenas letras minusculas e . depois do @
		if (!email.substring((email.indexOf("@"))+1).matches("[a-z.]*")) {
			return false;
		}

        //ter letras minusculas depois do ultimo .
		if (!email.substring((email.lastIndexOf(".")+1)).matches("[a-z]*")) {
			return false;
		}

		return true;
	}
*/
	
	public static void main(String[] args) {
		
		new Main().executa();
	}

}
