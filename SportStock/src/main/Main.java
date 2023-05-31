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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
			System.out.println(database);
			Conexao = DriverManager.getConnection(database);
			DatabaseMetaData d = Conexao.getMetaData();
			rsRegistro = d.getTables(null, null, "%", null);
		}
		catch (Exception Excecao) {
			Excecao.printStackTrace();
		}
	}
	
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

	//Metodo para ler fornecedor
	private void consultaFornec() {
		try {
			rsRegistro = Conexao.createStatement().executeQuery("SELECT * FROM Fornecedor");
			while(rsRegistro.next()) {
				Fornecedor f1 = new Fornecedor();
				f1.setNomeFornec(rsRegistro.getString("nomeFornec"));
				f1.setTelefoneFornec(rsRegistro.getInt("telefoneFornec"));
				f1.setEmailFornec(rsRegistro.getString("emailFornec"));
				fornecedores.add(f1);
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
			strComandoSQL.setInt(1, c2.getCpfCli());
			strComandoSQL.setString(2, c2.getNomeCli());
			strComandoSQL.setInt(3, c2.getTelefoneCli());
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
			strComandoSQL.setInt(2, f2.getTelefoneFornec());
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
				strComandoSQL.setInt(1, c2.getCpfCli());
				strComandoSQL.setString(2, c2.getNomeCli());
				strComandoSQL.setInt(3, c2.getTelefoneCli());
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
				PreparedStatement strComandoSQL = Conexao.prepareStatement("UPDATE Fornecedor SET (nomeFornec, telefoneFornec, emailFornec)" + " VALUES (?,?,?)");
				strComandoSQL.setString(1, f2.getNomeFornec());
				strComandoSQL.setInt(2, f2.getTelefoneFornec());
				strComandoSQL.setString(3, f2.getEmailFornec());
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
        valida = 0;
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

	
	public static void main(String[] args) {
		new Main().executa();
	}

}

