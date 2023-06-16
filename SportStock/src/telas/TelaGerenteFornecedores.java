package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import recursos.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import main.Main;

public class TelaGerenteFornecedores {
	
	private static ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	
	private String id = "<html><body>";
	private String nome = "<html><body>";
	private String telefone = "<html><body>";
	private String email = "<html><body>";
	private int opcao = 0;
	private int idFornec = -1;

	private JFrame frmGerenciarFornecedores;
	private JTextField idFor;
	private JTextField nomeFor;
	private JTextField telefoneFor;
	private JTextField emailFor;
	

	/**
	 * Launch the application.
	 */
	public static void telaGerenteFornecedores() {
		
		fornecedores = new Main().getListaFornec();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerenteFornecedores window = new TelaGerenteFornecedores();
					window.frmGerenciarFornecedores.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaGerenteFornecedores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		listaFornec();
		frmGerenciarFornecedores = new JFrame();
		frmGerenciarFornecedores.getContentPane().setBackground(new Color(255, 255, 255));
		frmGerenciarFornecedores.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaGerente.class.getResource("/img/SportStockLogo.jpg")));
		frmGerenciarFornecedores.setTitle("Gerenciar");
		frmGerenciarFornecedores.setBounds(100, 100, 1060, 585);
		frmGerenciarFornecedores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGerenciarFornecedores.getContentPane().setLayout(null);
		
		JButton btnVenda = new JButton("Vendas");
		btnVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGerenciarFornecedores.setVisible(false);
				TelaGerente.telaGerente();
				frmGerenciarFornecedores.dispose();
			}
		});
		btnVenda.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnVenda.setBackground(Color.WHITE);
		btnVenda.setBounds(123, 32, 103, 36);
		frmGerenciarFornecedores.getContentPane().add(btnVenda);
		
		JButton btnFuncionarios = new JButton("Funcionarios");
		btnFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGerenciarFornecedores.setVisible(false);
				TelaGerenteFuncionarios.telaGerenteFuncionarios();
				frmGerenciarFornecedores.dispose();
			}
		});
		btnFuncionarios.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnFuncionarios.setBackground(Color.WHITE);
		btnFuncionarios.setBounds(266, 32, 115, 36);
		frmGerenciarFornecedores.getContentPane().add(btnFuncionarios);
		
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGerenciarFornecedores.setVisible(false);
				TelaGerenteEstoque.telaGerenteEstoque();
				frmGerenciarFornecedores.dispose();
			}
		});
		btnEstoque.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnEstoque.setBackground(Color.WHITE);
		btnEstoque.setBounds(408, 32, 103, 36);
		frmGerenciarFornecedores.getContentPane().add(btnEstoque);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGerenciarFornecedores.setVisible(false);
				TelaGerenteClientes.telaGerenteClientes();
				frmGerenciarFornecedores.dispose();
			}
		});
		btnClientes.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnClientes.setBackground(Color.WHITE);
		btnClientes.setBounds(546, 32, 103, 36);
		frmGerenciarFornecedores.getContentPane().add(btnClientes);
		
		JButton btnFornecedores = new JButton("Fornecedores");
		btnFornecedores.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnFornecedores.setBackground(Color.WHITE);
		btnFornecedores.setBounds(682, 32, 121, 36);
		frmGerenciarFornecedores.getContentPane().add(btnFornecedores);
		
		
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel.setBounds(35, 143, 60, 20);
		frmGerenciarFornecedores.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(164, 145, 51, 17);
		frmGerenciarFornecedores.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email:");
		lblNewLabel_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(578, 145, 40, 17);
		frmGerenciarFornecedores.getContentPane().add(lblNewLabel_1_1);
		
		idFor = new JTextField();
		idFor.setBounds(68, 143, 86, 20);
		frmGerenciarFornecedores.getContentPane().add(idFor);
		idFor.setColumns(10);
		
		nomeFor = new JTextField();
		nomeFor.setBounds(216, 143, 185, 20);
		frmGerenciarFornecedores.getContentPane().add(nomeFor);
		nomeFor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(68, 186, 86, 26);
		frmGerenciarFornecedores.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nome:");
		lblNewLabel_2_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(315, 186, 86, 26);
		frmGerenciarFornecedores.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Telefone:");
		lblNewLabel_2_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(563, 186, 112, 26);
		frmGerenciarFornecedores.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Email:");
		lblNewLabel_2_1_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblNewLabel_2_1_1_1.setBounds(830, 186, 86, 26);
		frmGerenciarFornecedores.getContentPane().add(lblNewLabel_2_1_1_1);
		
		
		
		JLabel IDFun = new JLabel(id);
		IDFun.setBounds(53, 223, 101, 312);
		frmGerenciarFornecedores.getContentPane().add(IDFun);
		
		JLabel nomesFornec = new JLabel(nome);
		nomesFornec.setBounds(222, 214, 247, 321);
		frmGerenciarFornecedores.getContentPane().add(nomesFornec);
		
		JLabel TelefonesFornec = new JLabel(telefone);
		TelefonesFornec.setBounds(488, 214, 247, 321);
		frmGerenciarFornecedores.getContentPane().add(TelefonesFornec);
		
		JLabel EmailsFornec = new JLabel(email);
		EmailsFornec.setBounds(752, 214, 219, 321);
		frmGerenciarFornecedores.getContentPane().add(EmailsFornec);
		
		JLabel lblNewLabel_1_2 = new JLabel("Telefone:");
		lblNewLabel_1_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(403, 145, 66, 17);
		frmGerenciarFornecedores.getContentPane().add(lblNewLabel_1_2);
		
		telefoneFor = new JTextField();
		telefoneFor.setColumns(10);
		telefoneFor.setBounds(474, 143, 94, 20);
		frmGerenciarFornecedores.getContentPane().add(telefoneFor);
		
		JLabel nomeIncorreto = new JLabel("");
		nomeIncorreto.setForeground(new Color(255, 0, 0));
		nomeIncorreto.setBounds(830, 92, 172, 14);
		frmGerenciarFornecedores.getContentPane().add(nomeIncorreto);
		
		JLabel senhaIncorreta = new JLabel("");
		senhaIncorreta.setForeground(Color.RED);
		senhaIncorreta.setBounds(830, 117, 172, 14);
		frmGerenciarFornecedores.getContentPane().add(senhaIncorreta);
		
		JButton btnPesquisar = new JButton("Cadastrar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opcao == 0) {
					if(nomeFor.getText().trim().equals("") || telefoneFor.getText().trim().equals("") || emailFor.getText().trim().equals("")) {
						nomeIncorreto.setText("Campos Vazios");
					} else {
						String nome = nomeFor.getText().trim();
						String email = emailFor.getText().trim();
						long telefones = 0;
						try {
							telefones = Long.parseLong(telefoneFor.getText().trim());
						} catch(Exception exce) {
							nomeIncorreto.setText("Valores invalidos");
						}
						
						try {
							if(validarNome(nome) && validarEmail(email) && validarTelefone(telefones)) {
								Fornecedor f1 = new Fornecedor();
								f1.setEmailFornec(email);
								f1.setNomeFornec(nome);
								f1.setTelefoneFornec(telefones);
								new Main().adicionarFornec(f1);
								fornecedores = new Main().getListaFornec();
								
							}
							else {
								if(!validarNome(nome)) {
									nomeIncorreto.setText("O nome não pode ter números ou caracteres especiais e tem que ter pelo menos 3 letras");
								}
								try {
									if(!validarEmail(email)) {
										nomeIncorreto.setText("Digite um email válido.");
									}
								} catch(Exception exce) {
									nomeIncorreto.setText("Digite um email válido.");
								}
								if(!validarTelefone(telefones)) {
									senhaIncorreta.setText("Digite um telefone Válido.");
								}
							}
						} catch(Exception exce) {
							nomeIncorreto.setText("Digite um email válido.");
						}
						
						
					}
					
				} else if(opcao == 1) {
					if(nomeFor.getText().trim().equals("") || telefoneFor.getText().trim().equals("") || idFor.getText().trim().equals("") || emailFor.getText().trim().equals("") || idFornec == -1) {
						nomeIncorreto.setText("Campos Vazios");
					} else {
						String nome = nomeFor.getText().trim();
						String email = emailFor.getText().trim();
						int idF = -1;
						if(idFor.getText().trim().equals("")) {
							idF = idFornec;
						} else {
							try {
								idF = Integer.parseInt(idFor.getText().trim());
							} catch(Exception exce) {
								nomeIncorreto.setText("Valores invalidos");
							}
						}
						
						long telefones = 0;
						try {
							telefones = Long.parseLong(telefoneFor.getText().trim());
						} catch(Exception exce) {
							nomeIncorreto.setText("Valores invalidos");
						}
						try {
							if(validarNome(nome) && validarEmail(email) && validarTelefone(telefones)) {
								Fornecedor f1 = new Fornecedor();
								f1.setIdFornec(idF);
								f1.setEmailFornec(email);
								f1.setNomeFornec(nome);
								f1.setTelefoneFornec(telefones);
								new Main().editarFornec(f1);
								fornecedores = new Main().getListaFornec();
							}
							else {
								if(!validarNome(nome)) {
									nomeIncorreto.setText("O nome não pode ter números ou caracteres especiais e tem que ter pelo menos 3 letras");
								}
								try {
									if(!validarEmail(email)) {
										nomeIncorreto.setText("Digite um email válido.");
									}
								} catch(Exception exce) {
									nomeIncorreto.setText("Digite um email válido.");
								}
								
								if(!validarTelefone(telefones)) {
									senhaIncorreta.setText("Digite um telefone Válido.");
								}
							}
						} catch(Exception exce) {
							nomeIncorreto.setText("Digite um email válido.");
						}
						 
						
					}
					
				} else if(opcao == 2) {
					if(idFornec == -1 && idFor.getText().trim().equals("")) {
						nomeIncorreto.setText("Insira um id ou pesquise por um fornecedor");
					} else {
						new Main().excluirFornec(idFornec);
						fornecedores = new Main().getListaFornec();
					}
					
				} else if(opcao == 3) {
					if(idFornec == -1 && idFor.getText().trim().equals("")) {
						nomeIncorreto.setText("Insira um id ou pesquise por um fornecedor");
					} else {
						int idDoFornec = -1;
						if(idFornec == -1) {
							try {
								idDoFornec = Integer.parseInt(idFor.getText().trim());
							} catch (Exception exce) {
								nomeIncorreto.setText("Insira apenas numeros no campo ID");
							}
						} else {
							idDoFornec = idFornec;
						}
						String emailDoFornec = "";
						for(Fornecedor i : fornecedores) {
							if(i.getIdFornec() == idDoFornec) {
								emailDoFornec = i.getEmailFornec();
								break;
							}
						}
						if(emailDoFornec.equals("")) {
							nomeIncorreto.setText("ID invalido");
						} else {
							try {
								List<String> comandos = new ArrayList<String>();
								comandos.add("cmd.exe");
								comandos.add("/C");
								comandos.add("start");
								String mailto = "mailto:" + emailDoFornec;
								comandos.add(mailto);
								ProcessBuilder processo = new ProcessBuilder(comandos);
								processo.start();
							} catch(Exception exce) {
								JOptionPane.showMessageDialog(null, "Falha no sistema");
							}
						}
						
					}
				}
				
				listaFornec();
				IDFun.setText(id);
				nomesFornec.setText(nome);
				TelefonesFornec.setText(telefone);
				EmailsFornec.setText(email);
				nomeFor.setText(null);
				telefoneFor.setText(null);
				emailFor.setText(null);
				idFor.setText(null);
				idFornec = -1;
			}
		});
		
		JButton btnBusca = new JButton("Buscar");
		btnBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeIncorreto.setText(null);
				int index = -1;
				if(!idFor.getText().trim().equals("")) {
					int codigo = Integer.parseInt(idFor.getText().trim());
					for(int i = 0; i < fornecedores.size(); ++i) {
						if(codigo == fornecedores.get(i).getIdFornec()) {
							index = i;
							break;
						}
					}
				} else if(!nomeFor.getText().trim().equals("")) {
					String nome = nomeFor.getText().trim();
					for(int i = 0; i < fornecedores.size(); ++i) {
						if(nome.equals(fornecedores.get(i).getNomeFornec())) {
							index = i;
							break;
						}
					}
				} else if(!telefoneFor.getText().trim().equals("")) {
					long telefoneCliente = 0;
					try {
						telefoneCliente = Long.parseLong(telefoneFor.getText().trim());
					} catch(Exception exce) {
						nomeIncorreto.setText("Apenas numeros no campo telefone");
					}
					for(int i = 0; i < fornecedores.size(); ++i) {
						if(telefoneCliente == fornecedores.get(i).getTelefoneFornec()) {
							index = i;
							break;
						}
					}
					
				} else if(!emailFor.getText().trim().equals("")) {
					String emailCliente = emailFor.getText().trim();
					for(int i = 0; i < fornecedores.size(); ++i) {
						if(emailCliente.equals(fornecedores.get(i).getEmailFornec())) {
							index = i;
							break;
						}
					}
				}
				if(index != -1) {
					
					idFornec = fornecedores.get(index).getIdFornec();
					idFor.setText(fornecedores.get(index).getIdFornec() + "");
					nomeFor.setText(fornecedores.get(index).getNomeFornec().trim());
					telefoneFor.setText(fornecedores.get(index).getTelefoneFornec() + "");
					emailFor.setText(fornecedores.get(index).getEmailFornec().trim());
					
				} else {
					nomeIncorreto.setText("Sem resultados");
				}
				
			}
		});
		btnBusca.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnBusca.setBackground(Color.WHITE);
		btnBusca.setBounds(823, 142, 77, 26);
		frmGerenciarFornecedores.getContentPane().add(btnBusca);
		
		btnPesquisar.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setBounds(909, 141, 112, 26);
		frmGerenciarFornecedores.getContentPane().add(btnPesquisar);
		
		JButton btnCadastrarFornec = new JButton("Cadastrar Fornecedor");
		btnCadastrarFornec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeIncorreto.setText(null);
				senhaIncorreta.setText(null);
				idFor.setEnabled(true);
				opcao = 0;
				btnPesquisar.setText("Cadastrar");
				btnBusca.setVisible(false);
				idFor.setVisible(false);
				lblNewLabel.setVisible(false);
			}
		});
		btnCadastrarFornec.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnCadastrarFornec.setBackground(Color.WHITE);
		btnCadastrarFornec.setBounds(35, 92, 189, 36);
		frmGerenciarFornecedores.getContentPane().add(btnCadastrarFornec);
		
		JButton btnAlterarCli = new JButton("Atualizar Fornecedor");
		btnAlterarCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPesquisar.setText("Atualizar");
				idFor.setEnabled(true);
				opcao = 1;
				nomeIncorreto.setText(null);
				senhaIncorreta.setText(null);
				btnBusca.setVisible(true);
				idFor.setVisible(true);
				lblNewLabel.setVisible(true);
			}
		});
		btnAlterarCli.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnAlterarCli.setBackground(Color.WHITE);
		btnAlterarCli.setBounds(234, 92, 189, 36);
		frmGerenciarFornecedores.getContentPane().add(btnAlterarCli);
		
		JButton btnExcluirCli = new JButton("Excluir Fornecedor");
		btnExcluirCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPesquisar.setText("Excluir");
				idFor.setEnabled(true);
				opcao = 2;
				nomeIncorreto.setText(null);
				senhaIncorreta.setText(null);
				btnBusca.setVisible(true);
				idFor.setVisible(true);
				lblNewLabel.setVisible(true);
			}
		});
		btnExcluirCli.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnExcluirCli.setBackground(Color.WHITE);
		btnExcluirCli.setBounds(433, 92, 189, 36);
		frmGerenciarFornecedores.getContentPane().add(btnExcluirCli);
		
		emailFor = new JTextField();
		emailFor.setColumns(10);
		emailFor.setBounds(628, 143, 185, 20);
		frmGerenciarFornecedores.getContentPane().add(emailFor);
		
		JButton btnContatarFornec = new JButton("Contatar Fornecedor");
		btnContatarFornec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPesquisar.setText("Contatar");
				idFor.setEnabled(true);
				opcao = 3;
				nomeIncorreto.setText(null);
				senhaIncorreta.setText(null);
				btnBusca.setVisible(true);
				idFor.setVisible(true);
				lblNewLabel.setVisible(true);
			}
		});
		btnContatarFornec.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnContatarFornec.setBackground(Color.WHITE);
		btnContatarFornec.setBounds(632, 92, 189, 36);
		frmGerenciarFornecedores.getContentPane().add(btnContatarFornec);
		
		JLabel imagem = new JLabel("");
		imagem.setIcon(new ImageIcon(new ImageIcon(Cadastro.class.getResource("/img/SportStockLogo.jpg")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		imagem.setBounds(0, 0, 121, 82);
		frmGerenciarFornecedores.getContentPane().add(imagem);
		
		JLabel imagem2 = new JLabel("");
		imagem2.setIcon(new ImageIcon(new ImageIcon(Cadastro.class.getResource("/img/iconGerente.jpg")).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		imagem2.setBounds(958, 11, 121, 82);
		frmGerenciarFornecedores.getContentPane().add(imagem2);
		
		String n = "<html><body>Gerente<br>" + Login.funNome + "</body></html>";
		JLabel tipoNomeFuncionario = new JLabel(n);
		tipoNomeFuncionario.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		tipoNomeFuncionario.setBounds(854, 11, 121, 57);
		frmGerenciarFornecedores.getContentPane().add(tipoNomeFuncionario);
		
		btnBusca.setVisible(false);
		idFor.setVisible(false);
		lblNewLabel.setVisible(false);
	}
	
	private void listaFornec() {
		id = "<html><body>";
		nome = "<html><body>";
		telefone = "<html><body>";
		email = "<html><body>";
		
		for(Fornecedor i : fornecedores) {
			id += i.getIdFornec() + "<br>";
			nome += i.getNomeFornec() + "<br>";
			telefone += i.getTelefoneFornec() + "<br>";
			email += i.getEmailFornec() + "<br>";
		}
		
		id += "</body></html>";
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
	
	private static boolean validarEmail(String email) throws Exception{
		
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
