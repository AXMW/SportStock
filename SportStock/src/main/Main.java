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
	
	//Metodo pra fazer a conexao com o SQL
	private void conecta() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			
			String filename = "F://SportStock/SportStockBD.accdb";
			File arquivo = new File(filename);
			if(!arquivo.exists()) {
				JOptionPane.showMessageDialog(null, "Arquivo não existe");
			}
			String database = "jdbc:ucanaccess://" + filename.trim();
			System.out.println(database);
			Conexao = DriverManager.getConnection(database);
			DatabaseMetaData d = Conexao.getMetaData();
			rsRegistro = d.getTables(null, null, "%", null);
		}
		catch (Exception Excecao) {
			Excecao.printStackTrace();
		}
	}
	
	//Metodo pra ler os dados dos produtos e adicionar em um arraylist
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
	
	//Metodo pra ler os dados dos funcionarios e adicionar em um arraylist
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
	
	//Metodo pra ler clientes
	private void consultaCli() {
		try {
			rsRegistro = Conexao.createStatement().executeQuery("SELECT * FROM Cliente");
			while(rsRegistro.next()) {
				Cliente c1 = new Cliente();
				c1.setNomeCli(rsRegistro.getString("nomeCli"));
				c1.setCpfCli(rsRegistro.getInt("cpfCli"));
				c1.setTelefoneCli(rsRegistro.getInt("telefoneCli"));
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
	
	//Metodo pra fazer uma nova venda
	private void criarVenda() {
		for(int i = 0; i < produtos.size(); ++i) {
			String str = "ID: " + produtos.get(i).getIdProd() + "\nNome: " + produtos.get(i).getNomeProd() + "\nTipo: " + produtos.get(i).getTipoProd() + "\nPreco: " + produtos.get(i).getPrecoProd() + "\nDescricao: " + produtos.get(i).getDescricaoProd() + "\nQuantidade disponivel: " + produtos.get(i).getQtdProd();
			JOptionPane.showMessageDialog(null, str);
		}
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
		try {
			PreparedStatement strComandoSQL = Conexao.prepareStatement("INSERT INTO Venda (precoVenda, dataVenda, descricaoVenda)" + " VALUES (?,?,?)");
			strComandoSQL.setFloat(1, preco);
			strComandoSQL.setString(2, v1.getDataVenda());
			strComandoSQL.setString(3, descricao);
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
					v1.setCodVenda(codigo);
					vendas.add(v1);
					JOptionPane.showMessageDialog(null, "Venda realizada com sucesso");
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecaoo de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		catch (Exception Excecao) {
			JOptionPane.showMessageDialog(null, Excecao);
		}
	}
	
	//Metodo pra adicionar novos produtos
	private void adicionarProd() {
		
		String nome = JOptionPane.showInputDialog("Insira o nome do produto: ");
		String tipo = JOptionPane.showInputDialog("Insira o tipo do produto: ");
		float preco = Float.parseFloat(JOptionPane.showInputDialog("Insira o preco do produto: "));
		String descricao = JOptionPane.showInputDialog("Insira a descricao do produto: ");
		int qtd = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de produtos: "));
		Produto p2 = new Produto();
		p2.setNomeProd(nome);
		p2.setTipoProd(tipo);
		p2.setPrecoProd(preco);
		p2.setDescricaoProd(descricao);
		p2.setQtdProd(qtd);
		try {
			PreparedStatement strComandoSQL = Conexao.prepareStatement("INSERT INTO Produto (nomeProd, tipoProd, descricaoProd, qtdProd, precoProd)" + " VALUES (?,?,?,?,?)");
			strComandoSQL.setString(1, nome);
			strComandoSQL.setString(2, tipo);
			strComandoSQL.setString(3, descricao);
			strComandoSQL.setInt(4, qtd);
			strComandoSQL.setFloat(5, preco);
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
			JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecaoo de registro",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	//Metodo pra adicionar novos funcionarios
	private void adicionarFun() {
		
		String nome = JOptionPane.showInputDialog("Insira o nome do funcionario: ");
		String senha = JOptionPane.showInputDialog("Insira a senha de login do funcionario: ");
		String hierarquia = JOptionPane.showInputDialog("Insira a hierarquia do funcionario: ");
		Funcionario f2 = new Funcionario();
		f2.setNomeFun(nome);
		f2.setSenhaFun(senha);
		f2.setHierarquiaFun(hierarquia);
		try {
			PreparedStatement strComandoSQL = Conexao.prepareStatement("INSERT INTO Funcionario (nomeFun, senhaFun, hierarquiaFun)" + " VALUES (?,?,?)");
			strComandoSQL.setString(1, nome);
			strComandoSQL.setString(2, senha);
			strComandoSQL.setString(3, hierarquia);
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
			JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecaoo de registro",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	//Metodo pra adicionar clientes
	private void adicionarCli() {
		String nome = JOptionPane.showInputDialog("Insira o nome do cliente");
		int cpf = Integer.parseInt(JOptionPane.showInputDialog("Insira o CPF do cliente"));
		int telefone = Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone do cliente"));
		String email = JOptionPane.showInputDialog("Insira o email do cliente");
		Cliente c2 = new Cliente();
		c2.setNomeCli(nome);
		c2.setCpfCli(cpf);
		c2.setTelefoneCli(telefone);
		c2.setEmailCli(email);
		try {
			PreparedStatement strComandoSQL = Conexao.prepareStatement("INSERT INTO Cliente (cpfCli, nomeCli, telefoneCli, emailCli)" + " VALUES (?,?,?,?)");
			strComandoSQL.setInt(1, cpf);
			strComandoSQL.setString(2, nome);
			strComandoSQL.setInt(3, telefone);
			strComandoSQL.setString(4, email);
			int intRegistro = strComandoSQL.executeUpdate();
			if(intRegistro != 0) {
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
				clientes.add(c2);
			}
		}
		catch (Exception Excecao) {
			JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecaoo de registro",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Metodo pra excluir produtos
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
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecaoo de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	//Metodo pra excluir funcionario
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
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecaoo de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	//Metodo pra excluir clientes
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
		int num = JOptionPane.showConfirmDialog(null, "Confirma a exclusão?\nCPF: " + clientes.get(j).getCpfCli() + "\nNome: " + clientes.get(j).getNomeCli() + "\nTelefone: " + clientes.get(j).getTelefoneCli() + "\nEmail: " +  clientes.get(j).getEmailCli());
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
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecaoo de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	//Metodo pra editar produtos
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
		int num = JOptionPane.showConfirmDialog(null, "Confirma a edição?\nID: " + produtos.get(j).getIdProd() + "\nNome: " + produtos.get(j).getNomeProd() + "\nTipo: " + produtos.get(j).getTipoProd() + "\nPreco: " + produtos.get(j).getPrecoProd() + "\nDescricao: " + produtos.get(j).getDescricaoProd() + "\nQuantidade disponivel: " + produtos.get(j).getQtdProd(), "Exclusão", JOptionPane.YES_NO_OPTION);
		if(num == 0) {
			String nome = JOptionPane.showInputDialog("Insira o nome do produto: ");
			String tipo = JOptionPane.showInputDialog("Insira o tipo do produto: ");
			float preco = Float.parseFloat(JOptionPane.showInputDialog("Insira o preco do produto: "));
			String descricao = JOptionPane.showInputDialog("Insira a descricao do produto: ");
			int qtd = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de produtos: "));
			Produto p2 = new Produto();
			p2.setNomeProd(nome);
			p2.setTipoProd(tipo);
			p2.setPrecoProd(preco);
			p2.setDescricaoProd(descricao);
			p2.setQtdProd(qtd);
			try {
				PreparedStatement strComandoSQL = Conexao.prepareStatement("UPDATE Produto SET (nomeProd, tipoProd, descricaoProd, qtdProd, precoProd)" + " = (?,?,?,?,?) WHERE idProd = ?");
				strComandoSQL.setString(1, nome);
				strComandoSQL.setString(2, tipo);
				strComandoSQL.setString(3, descricao);
				strComandoSQL.setInt(4, qtd);
				strComandoSQL.setFloat(5, preco);
				strComandoSQL.setInt(6, n);
				int intRegistro = strComandoSQL.executeUpdate();
				if(intRegistro != 0) {
					JOptionPane.showMessageDialog(null, "Edição realizada com sucesso");
					produtos.set(j, p2);
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecaoo de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	//Metodo pra editar funcionario
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
		int num = JOptionPane.showConfirmDialog(null, "Confirma a edição?\nID: " + funcionarios.get(j).getIdFun() + "\nNome: " + funcionarios.get(j).getNomeFun() + "\nSenha: " + funcionarios.get(j).getSenhaFun() + "\nHierarquia: " + funcionarios.get(j).getHierarquiaFun(), "Exclusão", JOptionPane.YES_NO_OPTION);
		if(num == 0) {
			String nome = JOptionPane.showInputDialog("Insira o nome do funcionario: ");
			String senha = JOptionPane.showInputDialog("Insira a senha de login do funcionario: ");
			String hierarquia = JOptionPane.showInputDialog("Insira a hierarquia do funcionario: ");
			Funcionario f2 = new Funcionario();
			f2.setNomeFun(nome);
			f2.setSenhaFun(senha);
			f2.setHierarquiaFun(hierarquia);
			try {
				PreparedStatement strComandoSQL = Conexao.prepareStatement("UPDATE Funcionario SET (nomeFun, senhaFun, hierarquiaFun)" + " = (?,?,?) WHERE idFun= ?");
				strComandoSQL.setString(1, nome);
				strComandoSQL.setString(2, senha);
				strComandoSQL.setString(3, hierarquia);
				strComandoSQL.setInt(4, n);
				int intRegistro = strComandoSQL.executeUpdate();
				if(intRegistro != 0) {
					JOptionPane.showMessageDialog(null, "Edição realizada com sucesso");
					funcionarios.set(j, f2);
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecaoo de registro",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	//Metodo pra editar cliente
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
		int num = JOptionPane.showConfirmDialog(null, "Confirma a edição?\nCPF: " + clientes.get(j).getCpfCli() + "\nNome: " + clientes.get(j).getNomeCli() + "\nTelefone: " + clientes.get(j).getTelefoneCli() + "\nEmail: " +  clientes.get(j).getEmailCli());
		if(num == 0) {
			String nome = JOptionPane.showInputDialog("Insira o nome do cliente");
			int cpf = Integer.parseInt(JOptionPane.showInputDialog("Insira o CPF do cliente"));
			int telefone = Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone do cliente"));
			String email = JOptionPane.showInputDialog("Insira o email do cliente");
			Cliente c2 = new Cliente();
			c2.setNomeCli(nome);
			c2.setCpfCli(cpf);
			c2.setTelefoneCli(telefone);
			c2.setEmailCli(email);
			try {
				PreparedStatement strComandoSQL = Conexao.prepareStatement("UPDATE Cliente SET (cpfCli, nomeCli, telefoneCli, emailCli)" + " = (?,?,?,?) WHERE cpfCli= ?");
				strComandoSQL.setInt(1, cpf);
				strComandoSQL.setString(2, nome);
				strComandoSQL.setInt(3, telefone);
				strComandoSQL.setString(4, email);
				strComandoSQL.setInt(5, n);
				int intRegistro = strComandoSQL.executeUpdate();
				if(intRegistro != 0) {
					JOptionPane.showMessageDialog(null, "Edição realizada com sucesso");
					clientes.set(j, c2);
				}
			}
			catch (Exception Excecao) {
				JOptionPane.showMessageDialog(null,"SQLException: " + Excecao.getMessage(),"Erro: Selecaoo de registro",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	}
	
	private void executa() {
		conecta();
		consultaProd();
		consultaFun();
		consultaCli();
		consultaVenda();
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
	
	public static void main(String[] args) {
		new Main().executa();
	}

}