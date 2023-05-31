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
package main;
import recursos.*;
import java.io.File;
import java.util.ArrayList;
import java.sql.DatabaseMetaData;
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
			
			String filename = "F://SportStock/SportStockBD.accdb";
			File arquivo = new File(filename);
			if(!arquivo.exists()) {
				JOptionPane.showMessageDialog(null, "Arquivo não existe");
			}
			String database = "jdbc:ucanaccess://" + filename.trim();
			//System.out.println(database);
			Conexao = DriverManager.getConnection(database);
			//DatabaseMetaData d = Conexao.getMetaData();
			//rsRegistro = d.getTables(null, null, "%", null);
		}
		catch (Exception Excecao) {
			Excecao.printStackTrace();
		}
	}
	
	//Metodo para receber dados do prouto     <-----------
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

	//Metodo para receber dados do funcionário		<-----------
	private static Funcionario lerDadosFun(){
		
		String nome = JOptionPane.showInputDialog("Insira o nome do funcionario: ");
		String senha = JOptionPane.showInputDialog("Insira a senha de login do funcionario: ");
		String hierarquia = JOptionPane.showInputDialog("Insira a hierarquia do funcionario: ");
		Funcionario f2 = new Funcionario();
		f2.setNomeFun(nome);
		f2.setSenhaFun(senha);
		f2.setHierarquiaFun(hierarquia);
	
		return f2;
	}
	
	//Metodo para receber dados do cliente		<----------
	private static Cliente lerDadosCli(){

		String nome = JOptionPane.showInputDialog("Insira o nome do cliente");
		long cpf = Integer.parseInt(JOptionPane.showInputDialog("Insira o CPF do cliente"));
		long telefone = Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone do cliente"));
		String email = JOptionPane.showInputDialog("Insira o email do cliente");
		Cliente c2 = new Cliente();
		c2.setNomeCli(nome);
		c2.setCpfCli(cpf);
		c2.setTelefoneCli(telefone);
		c2.setEmailCli(email);

		return c2;
	}

	private static Fornecedor lerDadosFornec(){

		String nome = JOptionPane.showInputDialog("Insira o nome do fornecedor");
		long telefone = Long.parseLong(JOptionPane.showInputDialog("Insira o telefone do fornecedor"));
		String email = JOptionPane.showInputDialog("Insira o email do fornecedor");
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
		c1.setQtdUsosCupom(qtdUsos);
		
		return c1;
	}

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
				c1.setCpfCli(rsRegistro.getLong("cpfCli"));
				c1.setTelefoneCli(rsRegistro.getLong("telefoneCli"));
				c1.setEmailCli(rsRegistro.getString("emailCli"));
				clientes.add(c1);
			}
		}
		catch (Exception Excecao) {
			JOptionPane.showMessageDialog(null, "SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
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
	}

	//Metodo para ler fornecedor
	private void consultaFornec() {
		try {
			rsRegistro = Conexao.createStatement().executeQuery("SELECT * FROM Fornecedor");
			while(rsRegistro.next()) {
				Fornecedor f1 = new Fornecedor();
				f1.setNomeFornec(rsRegistro.getString("nomeFornec"));
				f1.setTelefoneFornec(rsRegistro.getLong("telefoneFornec"));
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
				c1.setQtdUsosCupom(rsRegistro.getInt("qtdUsosCupom"));
				cupons.add(c1);
			}
		}
		catch (Exception Excecao) {
			JOptionPane.showMessageDialog(null, "SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Metodo pra fazer uma nova venda
	private void criarVenda() {
		for(int i = 0; i < produtos.size(); ++i) {
			String str = "ID: " + produtos.get(i).getIdProd() + "\nNome: " + produtos.get(i).getNomeProd() + "\nTipo: " + produtos.get(i).getTipoProd() + "\nPreco: " + produtos.get(i).getPrecoProd() + "\nDescricao: " + produtos.get(i).getDescricaoProd() + "\nQuantidade disponivel: " + produtos.get(i).getQtdProd();
			JOptionPane.showMessageDialog(null, str);
		}
		
		ArrayList<Venda> venda = new ArrayList<Venda>();
		while(true) {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do produto que deseja vender"));
			int qtd = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de produtos que deseja vender"));
			int index = 0;
			float preco = 0;
			for(int i = 0; i < produtos.size(); ++i) {
				if(id == produtos.get(i).getIdProd()) {
					index = i;
					preco = qtd * produtos.get(i).getPrecoProd();
					break;
				}
			}
			
			String descricao = produtos.get(index).getNomeProd() + " x " + qtd + " = " + (qtd * produtos.get(index).getPrecoProd());
			Venda v1 = new Venda();
			v1.setPrecoVenda(preco);
			v1.setDescricaoVenda(descricao);
			v1.setIdProd(id);
			v1.setIndexProd(index);
			v1.setQtdProd(qtd);
			venda.add(v1);
			int confirmacao = JOptionPane.showConfirmDialog(null, "Mais algum produto?", "Venda", JOptionPane.YES_NO_OPTION);
			if(confirmacao != 0) {
				break;
			}
		}
		
		int desconto = JOptionPane.showConfirmDialog(null, "Inserir cupom de desconto?", "Desconto", JOptionPane.YES_NO_OPTION);
		if(desconto == 0) {
			float valorDesc = 0;
			int idCupom = 0;
			while(true) {
				try {
					idCupom = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do cupom"));
					boolean verify = false;
					for(int i = 0; i < cupons.size(); ++i) {
						if(idCupom == cupons.get(i).getIdCupom()) {
							valorDesc = cupons.get(i).getPorcentagemCupom() / 100;
							verify = true;
							break;
						}
					}
					if(verify == true) {
						break;
					}
				}
				catch(Exception Excecao) {
					JOptionPane.showMessageDialog(null, "Insira apenas numeros inteiros e validos de cupom");
				}
			}
			for(int i = 0; i < venda.size(); ++i) {
				venda.get(i).setPrecoVenda((venda.get(i).getPrecoVenda() - (venda.get(i).getPrecoVenda() * valorDesc)));
				venda.get(i).setIdCupomDesconto(idCupom);
			}
		}
		
		for(int i = 0; i < venda.size(); ++i) {
			try {
				PreparedStatement strComandoSQL = Conexao.prepareStatement("INSERT INTO Venda (precoVenda, dataVenda, descricaoVenda)" + " VALUES (?,?,?)");
				strComandoSQL.setFloat(1, venda.get(i).getPrecoVenda());
				strComandoSQL.setString(2, venda.get(i).getDataVenda());
				strComandoSQL.setString(3, venda.get(i).getDescricaoVenda());
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
						venda.get(i).setCodVenda(codigo);
						
						int quantidadeProd = produtos.get(venda.get(i).getIndexProd()).getQtdProd();
						quantidadeProd -= venda.get(i).getQtdProd();
						produtos.get(venda.get(i).getIndexProd()).setQtdProd(quantidadeProd);
						strComandoSQL = Conexao.prepareStatement("UPDATE Produto SET qtdProd VALUE ? WHERE idProd= ?");
						strComandoSQL.setInt(1, quantidadeProd);
						strComandoSQL.setInt(2, venda.get(i).getIdProd());
						try {
							strComandoSQL.executeUpdate();
						}
						catch (Exception Excecao) {
							JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecaoo de registro",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				catch (Exception Excecao) {
					JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecaoo de registro",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecaoo de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		vendas.addAll(venda);
	}
	
	//Metodo para adicionar novos produtos
	private void adicionarProd() {
		
		Produto p2 = new Produto();
		p2 = lerDadosProd();

		try {
			PreparedStatement strComandoSQL = Conexao.prepareStatement("INSERT INTO Produto (nomeProd, tipoProd, descricaoProd, qtdProd, precoProd)" + " VALUES (?,?,?,?,?)");
			strComandoSQL.setString(1, p2.getNomeProd());
			strComandoSQL.setString(2, p2.getTipoProd());
			strComandoSQL.setString(3, p2.getDescricaoProd());
			strComandoSQL.setInt(4, p2.getQtdProd());
			strComandoSQL.setFloat(5, p2.getPrecoProd());
			int intRegistro = strComandoSQL.executeUpdate();
			if(intRegistro != 0) {
				rsRegistro = Conexao.createStatement().executeQuery("SELECT idProd FROM Produto");
				int codigo = 0;
				while(rsRegistro.next()) {
					if(codigo < rsRegistro.getInt("idProd")) {
						codigo = rsRegistro.getInt("idProd");
					}
				}
				p2.setIdProd(codigo);
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
				produtos.add(p2);
			}
		}
		catch (Exception Excecao) {
			JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	//Metodo para adicionar novos funcionarios
	private void adicionarFun() {
		
		Funcionario f2 = new Funcionario();
		f2 = lerDadosFun();

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
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
				funcionarios.add(f2);
			}
		}
		catch (Exception Excecao) {
			JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	//Metodo para adicionar clientes
	private void adicionarCli() {

		Cliente c2 = new Cliente();
		c2 = lerDadosCli();

		try {
			PreparedStatement strComandoSQL = Conexao.prepareStatement("INSERT INTO Cliente (cpfCli, nomeCli, telefoneCli, emailCli)" + " VALUES (?,?,?,?)");
			strComandoSQL.setLong(1, c2.getCpfCli());
			strComandoSQL.setString(2, c2.getNomeCli());
			strComandoSQL.setLong(3, c2.getTelefoneCli());
			strComandoSQL.setString(4, c2.getEmailCli());
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
	private void adicionaFornec() {

		Fornecedor f2 = new Fornecedor();
		f2 = lerDadosFornec();

		try {
			PreparedStatement strComandoSQL = Conexao.prepareStatement("INSERT INTO Fornecedor (nomeFornec, telefoneFornec, emailFornec)" + " VALUES (?,?,?)");
			strComandoSQL.setString(1, f2.getNomeFornec());
			strComandoSQL.setLong(2, f2.getTelefoneFornec());
			strComandoSQL.setString(3, f2.getEmailFornec());
			int intRegistro = strComandoSQL.executeUpdate();
			if(intRegistro != 0) {
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
				fornecedores.add(f2);
			}
		}
		catch (Exception Excecao) {
			JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Metodo para adicionar cupom
	private void adicionarCupom() {
		
		Cupom c2 = new Cupom();
		c2 = lerDadosCupom();
		
		try {
			PreparedStatement strComandoSQL = Conexao.prepareStatement("INSERT INTO Cupom (codCupom, porcentagemCupom, qtdUsosCupom" + " VALUES (?,?,?)");
			strComandoSQL.setString(1, c2.getCodCupom());
			strComandoSQL.setFloat(2, c2.getPorcentagemCupom());
			strComandoSQL.setInt(3, c2.getQtdUsosCupom());
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
	private void excluirProd() {
		for(int i = 0; i < produtos.size(); ++i) {
			String str = "ID: " + produtos.get(i).getIdProd() + "\nNome: " + produtos.get(i).getNomeProd() + "\nTipo: " + produtos.get(i).getTipoProd() + "\nPreco: " + produtos.get(i).getPrecoProd() + "\nDescricao: " + produtos.get(i).getDescricaoProd() + "\nQuantidade disponivel: " + produtos.get(i).getQtdProd();
			JOptionPane.showMessageDialog(null, str);
		}
		int n = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do produto que deseja excluir"));
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
					produtos.remove(j);
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	//Metodo para excluir funcionario
	private void excluirFun() {
		for(int i = 0; i < funcionarios.size(); ++i) {
			String str = "ID: " + funcionarios.get(i).getIdFun() +"\nNome: " + funcionarios.get(i).getNomeFun() + "\nSenha: " + funcionarios.get(i).getSenhaFun() + "\nHierarquia: " + funcionarios.get(i).getHierarquiaFun();
			JOptionPane.showMessageDialog(null, str);
		}
		int n = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do funcionario que deseja excluir"));
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
					funcionarios.remove(j);
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	//Metodo para excluir clientes
	private void excluirCli() {
		for(int i = 0; i < clientes.size(); ++i) {
			JOptionPane.showMessageDialog(null, "CPF: " + clientes.get(i).getCpfCli() + "\nNome: " + clientes.get(i).getNomeCli() + "\nTelefone: " + clientes.get(i).getTelefoneCli() + "\nEmail: " +  clientes.get(i).getEmailCli());
		}
		int n = Integer.parseInt(JOptionPane.showInputDialog("Insira o CPF do cliente que deseja excluir"));
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
				strComandoSQL.setInt(1, n);
				int intRegistro = strComandoSQL.executeUpdate();
				if(intRegistro != 0) {
					JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
					clientes.remove(j);
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	//Metodo para excluir fornecedor
	private void excluiFornec() {
		for(int i = 0; i < fornecedores.size(); ++i) {
			JOptionPane.showMessageDialog(null, "Nome: " + fornecedores.get(i).getNomeFornec() + "\nTelefone: " + fornecedores.get(i).getTelefoneFornec() + "\nEmail: " + fornecedores.get(i).getEmailFornec());
		}
		String n = (JOptionPane.showInputDialog("Insira o nome do fornecedor que deseja excluir"));
		int j = 0;
		for(int i = 0; i < fornecedores.size(); ++i) {
			if(fornecedores.get(i).getNomeFornec() == n) {
				j = i;
				break;
			}
		}
		int num = JOptionPane.showConfirmDialog(null, "Confirma a exclusão?\nNome: " + fornecedores.get(j).getNomeFornec() + "\nTelefone: " + fornecedores.get(j).getTelefoneFornec() + "\nEmail: " + fornecedores.get(j).getEmailFornec(), "Exclusão", JOptionPane.YES_NO_OPTION);
		if(num == 0) {
			try {
				PreparedStatement strComandoSQL = Conexao.prepareStatement("DELETE from Fornecedor WHERE" + " nomeFornec= ?");
				strComandoSQL.setString(1, n);
				int intRegistro = strComandoSQL.executeUpdate();
				if(intRegistro != 0) {
					JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
					fornecedores.remove(j);
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	//Metodo para excluir cupom
	private void excluirCupom() {
		for(int i = 0; i < cupons.size(); ++i) {
			JOptionPane.showMessageDialog(null, "ID: " + cupons.get(i).getIdCupom() + "\nCodigo: " + cupons.get(i).getCodCupom() + "\nPorcentagem: " + cupons.get(i).getPorcentagemCupom() + "\nQuantidade de usos: " + cupons.get(i).getQtdUsosCupom());
		}
		int n = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do cupom que deseja excluir"));
		int j = 0;
		for(int i = 0; i < cupons.size(); ++i) {
			if(cupons.get(i).getIdCupom() == n) {
				j = i;
				break;
			}
		}
		int num = JOptionPane.showConfirmDialog(null, "Confirma a exclusão?\nID: " + cupons.get(j).getIdCupom() + "\nCodigo: " + cupons.get(j).getCodCupom() + "\nPorcentagem: " + cupons.get(j).getPorcentagemCupom() + "\nQuantidade de usos: " + cupons.get(j).getQtdUsosCupom(), "Exclusão", JOptionPane.YES_NO_OPTION);
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
	}

	//Metodo para editar produtos
	private void editarProd() {
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
			Produto p2 = new Produto();

			p2 = lerDadosProd();

			try {
				PreparedStatement strComandoSQL = Conexao.prepareStatement("UPDATE Produto SET (nomeProd, tipoProd, descricaoProd, qtdProd, precoProd)" + " = (?,?,?,?,?) WHERE idProd = ?");
				strComandoSQL.setString(1, p2.getNomeProd());
				strComandoSQL.setString(2, p2.getTipoProd());
				strComandoSQL.setString(3, p2.getDescricaoProd());
				strComandoSQL.setInt(4, p2.getQtdProd());
				strComandoSQL.setFloat(5, p2.getPrecoProd());
				strComandoSQL.setInt(6, n);
				int intRegistro = strComandoSQL.executeUpdate();
				if(intRegistro != 0) {
					JOptionPane.showMessageDialog(null, "Edição realizada com sucesso");
					produtos.set(j, p2);
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	//Metodo para editar funcionario
	private void editarFun() {
		for(int i = 0; i < funcionarios.size(); ++i) {
			String str = "ID: " + funcionarios.get(i).getIdFun() +"\nNome: " + funcionarios.get(i).getNomeFun() + "\nSenha: " + funcionarios.get(i).getSenhaFun() + "\nHierarquia: " + funcionarios.get(i).getHierarquiaFun();
			JOptionPane.showMessageDialog(null, str);
		}
		int n = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do funcionario que deseja editar"));
		int j = 0;
		for(int i = 0; i < funcionarios.size(); ++i) {
			if(funcionarios.get(i).getIdFun() == n) {
				j = i;
				break;
			}
		}
		int num = JOptionPane.showConfirmDialog(null, "Confirma a edição?\nID: " + funcionarios.get(j).getIdFun() + "\nNome: " + funcionarios.get(j).getNomeFun() + "\nSenha: " + funcionarios.get(j).getSenhaFun() + "\nHierarquia: " + funcionarios.get(j).getHierarquiaFun(), "Edição", JOptionPane.YES_NO_OPTION);
		if(num == 0) {
		
			Funcionario f2 = new Funcionario();
			f2 = lerDadosFun();
	
			try {
				PreparedStatement strComandoSQL = Conexao.prepareStatement("UPDATE Funcionario SET (nomeFun, senhaFun, hierarquiaFun)" + " = (?,?,?) WHERE idFun= ?");
				strComandoSQL.setString(1, f2.getNomeFun());
				strComandoSQL.setString(2, f2.getSenhaFun());
				strComandoSQL.setString(3, f2.getSenhaFun());
				strComandoSQL.setInt(4, n);
				int intRegistro = strComandoSQL.executeUpdate();
				if(intRegistro != 0) {
					JOptionPane.showMessageDialog(null, "Edição realizada com sucesso");
					funcionarios.set(j, f2);
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	//Metodo para editar cliente
	private void editarCli() {
		for(int i = 0; i < clientes.size(); ++i) {
			JOptionPane.showMessageDialog(null, "CPF: " + clientes.get(i).getCpfCli() + "\nNome: " + clientes.get(i).getNomeCli() + "\nTelefone: " + clientes.get(i).getTelefoneCli() + "\nEmail: " +  clientes.get(i).getEmailCli());
		}
		int n = Integer.parseInt(JOptionPane.showInputDialog("Insira o CPF do cliente que deseja editar"));
		int j = 0;
		for(int i = 0; i < clientes.size(); ++i) {
			if (clientes.get(i).getCpfCli() == n) {
				j = i;
				break;
			}
		}
		int num = JOptionPane.showConfirmDialog(null, "Confirma a edição?\nCPF: " + clientes.get(j).getCpfCli() + "\nNome: " + clientes.get(j).getNomeCli() + "\nTelefone: " + clientes.get(j).getTelefoneCli() + "\nEmail: " +  clientes.get(j).getEmailCli(), "Edição", JOptionPane.YES_NO_OPTION);
		if(num == 0) {

			Cliente c2 = new Cliente();
			c2 = lerDadosCli();

			try {
				PreparedStatement strComandoSQL = Conexao.prepareStatement("UPDATE Cliente SET (cpfCli, nomeCli, telefoneCli, emailCli)" + " = (?,?,?,?) WHERE cpfCli= ?");
				strComandoSQL.setLong(1, c2.getCpfCli());
				strComandoSQL.setString(2, c2.getNomeCli());
				strComandoSQL.setLong(3, c2.getTelefoneCli());
				strComandoSQL.setString(4, c2.getEmailCli());
				strComandoSQL.setInt(5, n);
				int intRegistro = strComandoSQL.executeUpdate();
				if(intRegistro != 0) {
					JOptionPane.showMessageDialog(null, "Edição realizada com sucesso");
					clientes.set(j, c2);
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	}
	
	//Metodo para editar fornecedor
	private void editaFornec() {
		for(int i = 0; i < fornecedores.size(); ++i) {
			JOptionPane.showMessageDialog(null, "Nome: " + fornecedores.get(i).getNomeFornec() + "\nTelefone: " + fornecedores.get(i).getTelefoneFornec() + "\nEmail: " + fornecedores.get(i).getEmailFornec());
		}
		String n = (JOptionPane.showInputDialog("Insira o nome do fornecedor que deseja editar"));
		int j = 0;
		for(int i = 0; i < fornecedores.size(); ++i) {
			if(fornecedores.get(i).getNomeFornec() == n) {
				j = i;
				break;
			}
		}
		int num = JOptionPane.showConfirmDialog(null, "Confirma a edição?\nNome: " + fornecedores.get(j).getNomeFornec() + "\nTelefone: " + fornecedores.get(j).getTelefoneFornec() + "\nEmail: " + fornecedores.get(j).getEmailFornec(), "Edição", JOptionPane.YES_NO_OPTION);
		if(num == 0) {

			Fornecedor f2 = new Fornecedor();
			f2 = lerDadosFornec();

			try {
				PreparedStatement strComandoSQL = Conexao.prepareStatement("UPDATE Fornecedor SET (nomeFornec, telefoneFornec, emailFornec)" + " = (?,?,?) WHERE nomeFornec= ?");
				strComandoSQL.setString(1, f2.getNomeFornec());
				strComandoSQL.setLong(2, f2.getTelefoneFornec());
				strComandoSQL.setString(3, f2.getEmailFornec());
				strComandoSQL.setString(4, n);
				int intRegistro = strComandoSQL.executeUpdate();
				if(intRegistro != 0) {
					JOptionPane.showMessageDialog(null, "Edição realizada com sucesso");
					fornecedores.set(j, f2);
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecao de registro",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	}
	
	//Metodo para editar cupom
	private void editarCupom() {
		for(int i = 0; i < cupons.size(); ++i) {
			JOptionPane.showMessageDialog(null, "ID: " + cupons.get(i).getIdCupom() + "\nCodigo: " + cupons.get(i).getCodCupom() + "\nPorcentagem: " + cupons.get(i).getPorcentagemCupom() + "\nQuantidade de usos: " + cupons.get(i).getQtdUsosCupom());
		}
		int n = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do cupom que deseja editar"));
		int j = 0;
		for(int i = 0; i < cupons.size(); ++i) {
			if(cupons.get(i).getIdCupom() == n) {
				j = i;
				break;
			}
		}
		int num = JOptionPane.showConfirmDialog(null, "Confirma a edição?\nID: " + cupons.get(j).getIdCupom() + "\nCodigo: " + cupons.get(j).getCodCupom() + "\nPorcentagem: " + cupons.get(j).getPorcentagemCupom() + "\nQuantidade de usos: " + cupons.get(j).getQtdUsosCupom(), "Exclusão", JOptionPane.YES_NO_OPTION);
		if(num == 0) {
			Cupom c2 = new Cupom();
			c2 = lerDadosCupom();
				
			try {
				PreparedStatement strComandoSQL = Conexao.prepareStatement("UPDATE Cupom SET(codCupom, porcentagemCupom, qtdUsosCupom)" + " = (?,?,?) WHERE idCupom= ?");
				strComandoSQL.setString(1, c2.getCodCupom());
				strComandoSQL.setFloat(2, c2.getPorcentagemCupom());
				strComandoSQL.setInt(3, c2.getQtdUsosCupom());
				strComandoSQL.setInt(4, n);
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
			
	}
	
	//Metodo para alterar o estoque
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
	}

	private void executa() {
		conecta();
		consultaProd();
		consultaFun();
		consultaCli();
		consultaVenda();
		consultaFornec();
		consultaCupom();
		imprimirProd();
		imprimirFun();
		//excluirProd();
		//excluirFun();
		//adicionarProd();
		//editarProd();
		//editarFun();
		//imprimirFun();
		//imprimirProd();
	}
	

	private static void imprimirProd() {
		for(int i = 0; i < produtos.size(); ++i) {
			System.out.println(produtos.get(i).getNomeProd());
		}
	}


	private static void imprimirFun() {
		for(int i = 0; i < funcionarios.size(); ++i) {
			System.out.println(funcionarios.get(i).getNomeFun());
		}
	}
	
	//Metodo para validar o nome de acordo com 
	private static boolean validarNome(String nome){

		if (!nome.matches("[A-Za-z]*")){
			return false;
		}
		if (nome.replaceAll(" ", "").length() < 3){
			return false;
		}
		
		return true;
	}

	
	public static void main(String[] args) {
		new Main().executa();
	}

}

