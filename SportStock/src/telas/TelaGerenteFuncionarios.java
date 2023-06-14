package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class TelaGerenteFuncionarios {

	private JFrame frmGerenciarFun;
	private JTextField codigoFun;
	private JTextField nomeFun;
	private JTextField hierarquiaFun;

	/**
	 * Launch the application.
	 */
	public static void telaGerenteFuncionarios() {
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
		frmGerenciarFun = new JFrame();
		frmGerenciarFun.getContentPane().setBackground(new Color(255, 255, 255));
		frmGerenciarFun.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaGerente.class.getResource("/img/SportStockLogo.jpg")));
		frmGerenciarFun.setTitle("Gerenciar");
		frmGerenciarFun.setBounds(100, 100, 1060, 585);
		frmGerenciarFun.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGerenciarFun.getContentPane().setLayout(null);
		
		JButton btnVenda = new JButton("Vendas");
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
		
		JButton btnCadastrarFun = new JButton("Cadastrar Usuário");
		btnCadastrarFun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCadastrarFun.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnCadastrarFun.setBackground(Color.WHITE);
		btnCadastrarFun.setBounds(35, 92, 189, 36);
		frmGerenciarFun.getContentPane().add(btnCadastrarFun);
		
		JLabel lblNewLabel = new JLabel("Código:  ");
		lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel.setBounds(35, 143, 60, 20);
		frmGerenciarFun.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome: ");
		lblNewLabel_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(291, 145, 60, 17);
		frmGerenciarFun.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Hierarquia: ");
		lblNewLabel_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(620, 145, 77, 17);
		frmGerenciarFun.getContentPane().add(lblNewLabel_1_1);
		
		codigoFun = new JTextField();
		codigoFun.setBounds(97, 143, 86, 20);
		frmGerenciarFun.getContentPane().add(codigoFun);
		codigoFun.setColumns(10);
		
		nomeFun = new JTextField();
		nomeFun.setBounds(339, 143, 179, 20);
		frmGerenciarFun.getContentPane().add(nomeFun);
		nomeFun.setColumns(10);
		
		hierarquiaFun = new JTextField();
		hierarquiaFun.setBounds(702, 143, 121, 20);
		frmGerenciarFun.getContentPane().add(hierarquiaFun);
		hierarquiaFun.setColumns(10);
		
		JButton btnAlterarFun = new JButton("Alterar Usuário");
		btnAlterarFun.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnAlterarFun.setBackground(Color.WHITE);
		btnAlterarFun.setBounds(327, 92, 189, 36);
		frmGerenciarFun.getContentPane().add(btnAlterarFun);
		
		JButton btnExcluirFun = new JButton("Excluir Usuário");
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
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setBounds(900, 141, 121, 26);
		frmGerenciarFun.getContentPane().add(btnPesquisar);
		
		JLabel codigosFun = new JLabel("");
		codigosFun.setBounds(53, 223, 101, 312);
		frmGerenciarFun.getContentPane().add(codigosFun);
		
		JLabel nomesFun = new JLabel("");
		nomesFun.setBounds(222, 214, 247, 321);
		frmGerenciarFun.getContentPane().add(nomesFun);
		
		JLabel hierarquiasFun = new JLabel("");
		hierarquiasFun.setBounds(488, 214, 247, 321);
		frmGerenciarFun.getContentPane().add(hierarquiasFun);
		
		JLabel hierarquiasFun_1 = new JLabel("");
		hierarquiasFun_1.setBounds(752, 214, 219, 321);
		frmGerenciarFun.getContentPane().add(hierarquiasFun_1);
		
		JLabel iconGerente = new JLabel("");
		iconGerente.setBounds(885, 11, 136, 67);
		frmGerenciarFun.getContentPane().add(iconGerente);
		
	}
}
