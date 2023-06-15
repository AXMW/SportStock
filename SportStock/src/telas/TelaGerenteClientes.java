package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.Main;
import recursos.*;
public class TelaGerenteClientes {
	
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	private String cpf = "<html><body>";
	private String nome = "<html><body>";
	private String telefone = "<html><body>";
	private String email = "<html><body>";
	private int opcao = 0;
	private long cpfCliente = 0;
	
	private JFrame frmGerenciarCliente;
	private JTextField cpfCli;
	private JTextField nomeCli;
	private JTextField telefoneCli;
	private JTextField emailCli;

	/**
	 * Launch the application.
	 */
	public static void telaGerenteClientes() {
		
		clientes = new Main().getListaCli();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerenteClientes window = new TelaGerenteClientes();
					window.frmGerenciarCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaGerenteClientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		listaCli();
		frmGerenciarCliente = new JFrame();
		frmGerenciarCliente.getContentPane().setBackground(new Color(255, 255, 255));
		frmGerenciarCliente.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaGerente.class.getResource("/img/SportStockLogo.jpg")));
		frmGerenciarCliente.setTitle("Gerenciar");
		frmGerenciarCliente.setBounds(100, 100, 1060, 585);
		frmGerenciarCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGerenciarCliente.getContentPane().setLayout(null);
		
		JButton btnVenda = new JButton("Vendas");
		btnVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGerenciarCliente.setVisible(false);
				TelaGerente.telaGerente();
				frmGerenciarCliente.dispose();
			}
		});
		btnVenda.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnVenda.setBackground(Color.WHITE);
		btnVenda.setBounds(123, 32, 103, 36);
		frmGerenciarCliente.getContentPane().add(btnVenda);
		
		JButton btnFuncionarios = new JButton("Funcionarios");
		btnFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGerenciarCliente.setVisible(false);
				TelaGerenteFuncionarios.telaGerenteFuncionarios();
				frmGerenciarCliente.dispose();
			}
		});
		btnFuncionarios.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnFuncionarios.setBackground(Color.WHITE);
		btnFuncionarios.setBounds(266, 32, 115, 36);
		frmGerenciarCliente.getContentPane().add(btnFuncionarios);
		
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGerenciarCliente.setVisible(false);
				TelaFuncionarioEstoque.telaFuncionarioEstoque();
				frmGerenciarCliente.dispose();
			}
		});
		btnEstoque.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnEstoque.setBackground(Color.WHITE);
		btnEstoque.setBounds(408, 32, 103, 36);
		frmGerenciarCliente.getContentPane().add(btnEstoque);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClientes.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnClientes.setBackground(Color.WHITE);
		btnClientes.setBounds(546, 32, 103, 36);
		frmGerenciarCliente.getContentPane().add(btnClientes);
		
		JButton btnFornecedores = new JButton("Fornecedores");
		btnFornecedores.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnFornecedores.setBackground(Color.WHITE);
		btnFornecedores.setBounds(682, 32, 121, 36);
		frmGerenciarCliente.getContentPane().add(btnFornecedores);
		
		
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel.setBounds(35, 143, 60, 20);
		frmGerenciarCliente.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(164, 145, 51, 17);
		frmGerenciarCliente.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email:");
		lblNewLabel_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(578, 145, 40, 17);
		frmGerenciarCliente.getContentPane().add(lblNewLabel_1_1);
		
		cpfCli = new JTextField();
		cpfCli.setBounds(68, 143, 86, 20);
		frmGerenciarCliente.getContentPane().add(cpfCli);
		cpfCli.setColumns(10);
		
		nomeCli = new JTextField();
		nomeCli.setBounds(216, 143, 185, 20);
		frmGerenciarCliente.getContentPane().add(nomeCli);
		nomeCli.setColumns(10);
		
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(68, 186, 86, 26);
		frmGerenciarCliente.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nome:");
		lblNewLabel_2_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(315, 186, 86, 26);
		frmGerenciarCliente.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Telefone:");
		lblNewLabel_2_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(563, 186, 112, 26);
		frmGerenciarCliente.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Email:");
		lblNewLabel_2_1_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblNewLabel_2_1_1_1.setBounds(830, 186, 86, 26);
		frmGerenciarCliente.getContentPane().add(lblNewLabel_2_1_1_1);
		
		
		
		JLabel CPFCli = new JLabel(cpf);
		CPFCli.setBounds(53, 223, 101, 312);
		frmGerenciarCliente.getContentPane().add(CPFCli);
		
		JLabel nomesCli = new JLabel(nome);
		nomesCli.setBounds(222, 214, 247, 321);
		frmGerenciarCliente.getContentPane().add(nomesCli);
		
		JLabel TelefonesCli = new JLabel(telefone);
		TelefonesCli.setBounds(488, 214, 247, 321);
		frmGerenciarCliente.getContentPane().add(TelefonesCli);
		
		JLabel EmailsCli = new JLabel(email);
		EmailsCli.setBounds(752, 214, 219, 321);
		frmGerenciarCliente.getContentPane().add(EmailsCli);
		
		JLabel iconGerente = new JLabel("");
		iconGerente.setBounds(885, 11, 136, 67);
		frmGerenciarCliente.getContentPane().add(iconGerente);
		
		JLabel lblNewLabel_1_2 = new JLabel("Telefone:");
		lblNewLabel_1_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(403, 145, 66, 17);
		frmGerenciarCliente.getContentPane().add(lblNewLabel_1_2);
		
		telefoneCli = new JTextField();
		telefoneCli.setColumns(10);
		telefoneCli.setBounds(474, 143, 94, 20);
		frmGerenciarCliente.getContentPane().add(telefoneCli);
		
		JLabel nomeIncorreto = new JLabel("");
		nomeIncorreto.setForeground(new Color(255, 0, 0));
		nomeIncorreto.setBounds(813, 92, 189, 14);
		frmGerenciarCliente.getContentPane().add(nomeIncorreto);
		
		JLabel senhaIncorreta = new JLabel("");
		senhaIncorreta.setForeground(Color.RED);
		senhaIncorreta.setBounds(813, 117, 189, 14);
		frmGerenciarCliente.getContentPane().add(senhaIncorreta);
		
		
		
		
		JButton btnPesquisar = new JButton("Cadastrar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opcao == 0) {
					String nome = nomeCli.getText().trim();
					String email = emailCli.getText();
					long CPF = 0;
					long telefones = 0;
					try {
						telefones = Long.parseLong(telefoneCli.getText().trim());
						
						CPF = Long.parseLong(cpfCli.getText());
					} catch(Exception exce) {
						nomeIncorreto.setText("Valores invalidos");
					}
					
					if(validarNome(nome) && validarCPF(CPF) && validarEmail(email) && validarTelefone(telefones)) {
						Cliente c1 = new Cliente();
						c1.setCpfCli(CPF);
						c1.setEmailCli(email);
						c1.setNomeCli(nome);
						c1.setTelefoneCli(telefones);
						new Main().adicionarCli(c1);
						
					}
					else {
						if(!validarNome(nome)) {
							nomeIncorreto.setText("O nome não pode ter números ou caracteres especiais e tem que ter pelo menos 3 letras");
						}
						if(!validarCPF(CPF)) {
							senhaIncorreta.setText("Digite um CPF Válido.");
						}
						if(!validarEmail(email)) {
							nomeIncorreto.setText("Digite um email válido.");
						}
						if(!validarTelefone(telefones)) {
							senhaIncorreta.setText("Digite um telefone Válido.");
						}
					}
				} else if(opcao == 1) {
					if(nomeCli.getText().equals("") || telefoneCli.getText().equals("") || cpfCli.getText().equals("") || emailCli.getText().equals("")) {
						nomeIncorreto.setText("Campos Vazios");
					} else {
						String nome = nomeCli.getText().trim();
						String email = emailCli.getText();
						long CPF = 0;
						long telefones = 0;
						try {
							telefones = Long.parseLong(telefoneCli.getText().trim());
							CPF = Long.parseLong(cpfCli.getText());
						} catch(Exception exce) {
							nomeIncorreto.setText("Valores invalidos");
						}
						
						if(validarNome(nome) && validarCPF(CPF) && validarEmail(email) && validarTelefone(telefones)) {
							Cliente c1 = new Cliente();
							c1.setCpfCli(CPF);
							c1.setEmailCli(email);
							c1.setNomeCli(nome);
							c1.setTelefoneCli(telefones);
							new Main().editarCli(c1);
							clientes = new Main().getListaCli();
							
						}
						else {
							if(!validarNome(nome)) {
								nomeIncorreto.setText("O nome não pode ter números ou caracteres especiais e tem que ter pelo menos 3 letras");
							}
							if(!validarCPF(CPF)) {
								senhaIncorreta.setText("Digite um CPF Válido.");
							}
							if(!validarEmail(email)) {
								nomeIncorreto.setText("Digite um email válido.");
							}
							if(!validarTelefone(telefones)) {
								senhaIncorreta.setText("Digite um telefone Válido.");
							}
						}
					}
					
				} else if(opcao == 2) {
					new Main().excluirCli(cpfCliente);
					clientes = new Main().getListaCli();
				}
				
				listaCli();
				CPFCli.setText(cpf);
				nomesCli.setText(nome);
				TelefonesCli.setText(telefone);
				EmailsCli.setText(email);
				nomeCli.setText(null);
				telefoneCli.setText(null);
				emailCli.setText(null);
				cpfCli.setText(null);
				cpfCliente = -1;
			}
		});
		
		JButton btnBusca = new JButton("Buscar");
		btnBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeIncorreto.setText(null);
				int index = -1;
				if(!cpfCli.getText().trim().equals("")) {
					long codigo = Long.parseLong(cpfCli.getText().trim());
					for(int i = 0; i < clientes.size(); ++i) {
						if(codigo == clientes.get(i).getCpfCli()) {
							index = i;
							break;
						}
					}
				} else if(!nomeCli.getText().trim().equals("")) {
					String nome = nomeCli.getText();
					for(int i = 0; i < clientes.size(); ++i) {
						if(nome.equals(clientes.get(i).getNomeCli())) {
							index = i;
							break;
						}
					}
				} else if(!telefoneCli.getText().trim().equals("")) {
					long telefoneCliente = 0;
					try {
						telefoneCliente = Long.parseLong(telefoneCli.getText().trim());
					} catch(Exception exce) {
						nomeIncorreto.setText("Apenas numeros no campo telefone");
					}
					for(int i = 0; i < clientes.size(); ++i) {
						if(telefoneCliente == clientes.get(i).getTelefoneCli()) {
							index = i;
							break;
						}
					}
					
				} else if(!emailCli.getText().trim().equals("")) {
					String emailCliente = emailCli.getText();
					for(int i = 0; i < clientes.size(); ++i) {
						if(emailCliente.equals(clientes.get(i).getEmailCli())) {
							index = i;
							break;
						}
					}
				}
				if(index != -1) {
					
					cpfCliente = clientes.get(index).getCpfCli();
					cpfCli.setText(clientes.get(index).getCpfCli() + "");
					nomeCli.setText(clientes.get(index).getNomeCli().trim());
					telefoneCli.setText(clientes.get(index).getTelefoneCli() + "");
					emailCli.setText(clientes.get(index).getEmailCli());
					
				} else {
					nomeIncorreto.setText("Sem resultados");
				}
				
			}
		});
		btnBusca.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnBusca.setBackground(Color.WHITE);
		btnBusca.setBounds(823, 142, 77, 26);
		frmGerenciarCliente.getContentPane().add(btnBusca);
		
		btnPesquisar.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setBounds(909, 141, 112, 26);
		frmGerenciarCliente.getContentPane().add(btnPesquisar);
		
		JButton btnCadastrarCli = new JButton("Cadastrar Cliente");
		btnCadastrarCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeIncorreto.setText(null);
				senhaIncorreta.setText(null);
				cpfCli.setEnabled(true);
				opcao = 0;
				btnPesquisar.setText("Cadastrar");
				btnBusca.setVisible(false);
				cpfCli.setVisible(true);
				lblNewLabel.setVisible(true);
			}
		});
		btnCadastrarCli.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnCadastrarCli.setBackground(Color.WHITE);
		btnCadastrarCli.setBounds(35, 92, 189, 36);
		frmGerenciarCliente.getContentPane().add(btnCadastrarCli);
		
		JButton btnAlterarCli = new JButton("Atualizar Cliente");
		btnAlterarCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPesquisar.setText("Atualizar");
				cpfCli.setEnabled(true);
				opcao = 1;
				nomeIncorreto.setText(null);
				senhaIncorreta.setText(null);
				btnBusca.setVisible(true);
				cpfCli.setVisible(true);
				lblNewLabel.setVisible(true);
			}
		});
		btnAlterarCli.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnAlterarCli.setBackground(Color.WHITE);
		btnAlterarCli.setBounds(327, 92, 189, 36);
		frmGerenciarCliente.getContentPane().add(btnAlterarCli);
		
		JButton btnExcluirCli = new JButton("Excluir Cliente");
		btnExcluirCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPesquisar.setText("Excluir");
				cpfCli.setEnabled(true);
				opcao = 2;
				nomeIncorreto.setText(null);
				senhaIncorreta.setText(null);
				btnBusca.setVisible(true);
				cpfCli.setVisible(true);
				lblNewLabel.setVisible(true);
			}
		});
		btnExcluirCli.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnExcluirCli.setBackground(Color.WHITE);
		btnExcluirCli.setBounds(614, 92, 189, 36);
		frmGerenciarCliente.getContentPane().add(btnExcluirCli);
		
		emailCli = new JTextField();
		emailCli.setColumns(10);
		emailCli.setBounds(628, 143, 185, 20);
		frmGerenciarCliente.getContentPane().add(emailCli);
		
		btnBusca.setVisible(false);
	}
	
	private void listaCli() {
		cpf = "<html><body>";
		nome = "<html><body>";
		telefone = "<html><body>";
		email = "<html><body>";
		
		for(Cliente i : clientes) {
			cpf += i.getCpfCli() + "<br>";
			nome += i.getNomeCli() + "<br>";
			telefone += i.getTelefoneCli() + "<br>";
			email += i.getEmailCli() + "<br>";
		}
		
		cpf += "</body></html>";
		nome += "</body></html>";
		telefone += "</body></html>";
		email += "</body></html>";
		
	}
	
	private static boolean validarNome(String nome){

		if (!nome.replaceAll(" ", "").matches("[A-Za-z]*")){
			return false;
		}
		if (nome.replaceAll(" ", "").length() < 3){
			return false;
		}
		
		return true;
	}
	
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
	
	private static boolean validarEmail(String email) {
		
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

}
