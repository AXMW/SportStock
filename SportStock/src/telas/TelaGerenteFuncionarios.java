package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import main.Main;
import recursos.Funcionario;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaGerenteFuncionarios {
	private String codigos = "<html><body>";
	private String nomes = "<html><body>";
	private String hierarquia = "<html><body>";
	private String senhas = "<html><body>";

	private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private JFrame frmGerenciarFun;
	private JTextField codigoFun;
	private JTextField nomeFun;
	private JTextField senhaFun;

	/**
	 * Launch the application.
	 */
	public static void telaGerenteFuncionarios() {
		funcionarios = new Main().getListaFun();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerenteFuncionarios window = new TelaGerenteFuncionarios();
					window.frmGerenciarFun.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaGerenteFuncionarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		listaFun();
		frmGerenciarFun = new JFrame();
		frmGerenciarFun.getContentPane().setBackground(new Color(255, 255, 255));
		frmGerenciarFun.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaGerente.class.getResource("/img/SportStockLogo.jpg")));
		frmGerenciarFun.setTitle("Gerenciar");
		frmGerenciarFun.setBounds(100, 100, 1060, 585);
		frmGerenciarFun.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGerenciarFun.getContentPane().setLayout(null);
		
		
		
		JButton btnVenda = new JButton("Vendas");
		btnVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGerenciarFun.setVisible(false);
				TelaGerente.telaGerente();
				frmGerenciarFun.dispose();
			}
		});
		btnVenda.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnVenda.setBackground(Color.WHITE);
		btnVenda.setBounds(123, 32, 103, 36);
		frmGerenciarFun.getContentPane().add(btnVenda);
		
		JButton btnFuncionarios = new JButton("Funcionarios");
		btnFuncionarios.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnFuncionarios.setBackground(Color.WHITE);
		btnFuncionarios.setBounds(266, 32, 115, 36);
		frmGerenciarFun.getContentPane().add(btnFuncionarios);
		
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnEstoque.setBackground(Color.WHITE);
		btnEstoque.setBounds(408, 32, 103, 36);
		frmGerenciarFun.getContentPane().add(btnEstoque);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnClientes.setBackground(Color.WHITE);
		btnClientes.setBounds(546, 32, 103, 36);
		frmGerenciarFun.getContentPane().add(btnClientes);
		
		JButton btnFornecedores = new JButton("Fornecedores");
		btnFornecedores.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnFornecedores.setBackground(Color.WHITE);
		btnFornecedores.setBounds(682, 32, 121, 36);
		frmGerenciarFun.getContentPane().add(btnFornecedores);
		
		
		
		JLabel lblNewLabel = new JLabel("Código:  ");
		lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel.setBounds(35, 143, 60, 20);
		frmGerenciarFun.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome: ");
		lblNewLabel_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(193, 145, 60, 17);
		frmGerenciarFun.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Hierarquia: ");
		lblNewLabel_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(700, 145, 77, 17);
		frmGerenciarFun.getContentPane().add(lblNewLabel_1_1);
		
		codigoFun = new JTextField();
		codigoFun.setEnabled(false);
		codigoFun.setBounds(97, 143, 86, 20);
		frmGerenciarFun.getContentPane().add(codigoFun);
		codigoFun.setColumns(10);
		
		nomeFun = new JTextField();
		nomeFun.setBounds(241, 143, 179, 20);
		frmGerenciarFun.getContentPane().add(nomeFun);
		nomeFun.setColumns(10);
		
		JButton btnAlterarFun = new JButton("Alterar Usuário");
		btnAlterarFun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = -1;
				codigoFun.setEnabled(true);
				if(codigoFun.getText() != null) {
					int codigo = Integer.parseInt(codigoFun.getText());
					for(int i = 0; i < funcionarios.size(); ++i) {
						if(codigo == funcionarios.get(i).getIdFun()) {
							index = i;
							break;
						}
					}
				}
			}
		});
		btnAlterarFun.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnAlterarFun.setBackground(Color.WHITE);
		btnAlterarFun.setBounds(327, 92, 189, 36);
		frmGerenciarFun.getContentPane().add(btnAlterarFun);
		
		JButton btnExcluirFun = new JButton("Excluir Usuário");
		btnExcluirFun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluirFun.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnExcluirFun.setBackground(Color.WHITE);
		btnExcluirFun.setBounds(614, 92, 189, 36);
		frmGerenciarFun.getContentPane().add(btnExcluirFun);
		
		JLabel lblNewLabel_2 = new JLabel("Código: ");
		lblNewLabel_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(68, 186, 86, 26);
		frmGerenciarFun.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nome: ");
		lblNewLabel_2_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(315, 186, 86, 26);
		frmGerenciarFun.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Hierarquia: ");
		lblNewLabel_2_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(563, 186, 112, 26);
		frmGerenciarFun.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Senha:");
		lblNewLabel_2_1_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblNewLabel_2_1_1_1.setBounds(830, 186, 86, 26);
		frmGerenciarFun.getContentPane().add(lblNewLabel_2_1_1_1);
		
		
		
		JLabel codigosFun = new JLabel(codigos);
		codigosFun.setBounds(53, 223, 101, 312);
		frmGerenciarFun.getContentPane().add(codigosFun);
		
		JLabel nomesFun = new JLabel(nomes);
		nomesFun.setBounds(222, 214, 247, 321);
		frmGerenciarFun.getContentPane().add(nomesFun);
		
		JLabel hierarquiasFun = new JLabel(hierarquia);
		hierarquiasFun.setBounds(488, 214, 247, 321);
		frmGerenciarFun.getContentPane().add(hierarquiasFun);
		
		JLabel senhasFun = new JLabel(senhas);
		senhasFun.setBounds(752, 214, 219, 321);
		frmGerenciarFun.getContentPane().add(senhasFun);
		
		JLabel iconGerente = new JLabel("");
		iconGerente.setBounds(885, 11, 136, 67);
		frmGerenciarFun.getContentPane().add(iconGerente);
		
		JLabel lblNewLabel_1_2 = new JLabel("Senha:");
		lblNewLabel_1_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(430, 146, 51, 17);
		frmGerenciarFun.getContentPane().add(lblNewLabel_1_2);
		
		senhaFun = new JTextField();
		senhaFun.setColumns(10);
		senhaFun.setBounds(488, 143, 202, 20);
		frmGerenciarFun.getContentPane().add(senhaFun);
		
		JComboBox<String> hierarquiaFun = new JComboBox<String>();
		hierarquiaFun.setBackground(new Color(255, 255, 255));
		hierarquiaFun.setModel(new DefaultComboBoxModel<String>(new String[] {"Vendedor", "Gerente"}));
		hierarquiaFun.setBounds(787, 142, 103, 22);
		frmGerenciarFun.getContentPane().add(hierarquiaFun);
		
		JLabel nomeIncorreto = new JLabel("");
		nomeIncorreto.setForeground(new Color(255, 0, 0));
		nomeIncorreto.setBounds(813, 92, 189, 14);
		frmGerenciarFun.getContentPane().add(nomeIncorreto);
		
		JLabel senhaIncorreta = new JLabel("");
		senhaIncorreta.setForeground(Color.RED);
		senhaIncorreta.setBounds(813, 117, 189, 14);
		frmGerenciarFun.getContentPane().add(senhaIncorreta);
		
		JButton btnCadastrarFun = new JButton("Cadastrar Usuário");
		btnCadastrarFun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codigoFun.setEnabled(false);
				lblNewLabel.setText("Código: ");
				lblNewLabel.setVisible(true);
				lblNewLabel_1.setText("Nome: ");
				lblNewLabel_1.setVisible(true);
				lblNewLabel_1_2.setText("Senha: ");
				lblNewLabel_1_2.setVisible(true);
			}
		});
		btnCadastrarFun.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnCadastrarFun.setBackground(Color.WHITE);
		btnCadastrarFun.setBounds(35, 92, 189, 36);
		frmGerenciarFun.getContentPane().add(btnCadastrarFun);
		
		
		JButton btnPesquisar = new JButton("Cadastrar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = nomeFun.getText();
				String senha = senhaFun.getText();
				String hierarquias = (String)hierarquiaFun.getSelectedItem();
				if(validarNome(nome) && validarSenha(senha)) {
					Funcionario f1 = new Funcionario();
					f1.setNomeFun(nome);
					f1.setSenhaFun(senha);
					f1.setHierarquiaFun(hierarquias);
					new Main().adicionarFun(f1);
					
				}
				else {
					if(!validarNome(nome)) {
						nomeIncorreto.setText("O nome não pode ter números ou caracteres especiais e tem que ter pelo menos 3 letras");
					}
					if(!validarSenha(senha)) {
						senhaIncorreta.setText("A senha deve ter no minimo 7 caracteres, pelo menos 1 letra maiuscula, pelo menos 1 letra minuscula e pelo menos 1 numero");
					}
				}
				listaFun();
				codigosFun.setText(codigos);
				nomesFun.setText(nomes);
				hierarquiasFun.setText(hierarquia);
				senhasFun.setText(senhas);
				nomeFun.setText(null);
				senhaFun.setText(null);
			}
		});
		btnPesquisar.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setBounds(900, 141, 121, 26);
		frmGerenciarFun.getContentPane().add(btnPesquisar);
		
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
	
	private void listaFun() {
		codigos = "<html><body>";
		nomes = "<html><body>";
		hierarquia = "<html><body>";
		senhas = "<html><body>";
		for(int i = 0; i < funcionarios.size(); ++i) {
			codigos = codigos + funcionarios.get(i).getIdFun() + "<br>";
			nomes = nomes + funcionarios.get(i).getNomeFun() + "<br>";
			hierarquia = hierarquia + funcionarios.get(i).getHierarquiaFun() + "<br>";
			senhas = senhas + funcionarios.get(i).getSenhaFun() + "<br>";
		}
		
		codigos = codigos + "</body></html>";
		nomes = nomes + "</body></html>";
		hierarquia = hierarquia + "</body></html>";
		senhas = senhas + "</body></html>";
		
	}
}
