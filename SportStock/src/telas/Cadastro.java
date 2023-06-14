package telas;

import java.awt.EventQueue;
import recursos.*;
import main.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Cadastro {

	private JFrame frmSportstockCadastro;
	private JTextField nomeFun;
	private JPasswordField senhaFun;

	/**
	 * Launch the application.
	 */
	public static void telaCadastro() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro window = new Cadastro();
					window.frmSportstockCadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSportstockCadastro = new JFrame();
		frmSportstockCadastro.getContentPane().setBackground(new Color(255, 255, 255));
		frmSportstockCadastro.setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastro.class.getResource("/img/SportStockLogo.jpg")));
		frmSportstockCadastro.setTitle("Cadastro");
		frmSportstockCadastro.setBounds(100, 100, 1060, 585);
		frmSportstockCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSportstockCadastro.getContentPane().setLayout(null);
		
		nomeFun = new JTextField();
		nomeFun.setBackground(new Color(240, 240, 240));
		nomeFun.setHorizontalAlignment(SwingConstants.CENTER);
		nomeFun.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		nomeFun.setColumns(10);
		nomeFun.setBounds(368, 148, 261, 38);
		frmSportstockCadastro.getContentPane().add(nomeFun);
		
		senhaFun = new JPasswordField();
		senhaFun.setBackground(new Color(240, 240, 240));
		senhaFun.setHorizontalAlignment(SwingConstants.CENTER);
		senhaFun.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		senhaFun.setBounds(368, 272, 261, 38);
		frmSportstockCadastro.getContentPane().add(senhaFun);
		
		JLabel senhaIncorreta = new JLabel("");
		senhaIncorreta.setForeground(new Color(255, 0, 0));
		senhaIncorreta.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		senhaIncorreta.setBounds(69, 321, 856, 23);
		frmSportstockCadastro.getContentPane().add(senhaIncorreta);
		
		JLabel nomeIncorreto = new JLabel("");
		nomeIncorreto.setForeground(Color.RED);
		nomeIncorreto.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		nomeIncorreto.setBounds(196, 197, 606, 23);
		frmSportstockCadastro.getContentPane().add(nomeIncorreto);
		
		JComboBox hierarquia = new JComboBox();
		hierarquia.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		hierarquia.setBackground(new Color(255, 255, 255));
		hierarquia.setModel(new DefaultComboBoxModel(new String[] {"Vendedor", "Gerente"}));
		hierarquia.setBounds(368, 396, 141, 38);
		frmSportstockCadastro.getContentPane().add(hierarquia);
		
		JLabel lblNewLabel = new JLabel("Insira o nome do funcionario: ");
		lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblNewLabel.setBounds(368, 107, 261, 30);
		frmSportstockCadastro.getContentPane().add(lblNewLabel);
		
		JLabel lblInsiraASenha = new JLabel("Insira a senha do funcionario: ");
		lblInsiraASenha.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblInsiraASenha.setBounds(368, 231, 261, 30);
		frmSportstockCadastro.getContentPane().add(lblInsiraASenha);
		
		JLabel lblSelecioneONivel = new JLabel("Selecione a hierarquia do funcionario:  ");
		lblSelecioneONivel.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblSelecioneONivel.setBounds(331, 355, 338, 30);
		frmSportstockCadastro.getContentPane().add(lblSelecioneONivel);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = nomeFun.getText();
				String senha = new String(senhaFun.getPassword());
				String hierarquiaFun = (String)hierarquia.getSelectedItem();
				if(validarNome(nome) && validarSenha(senha)) {
					Funcionario f1 = new Funcionario();
					f1.setNomeFun(nome);
					f1.setSenhaFun(senha);
					f1.setHierarquiaFun(hierarquiaFun);
					boolean confirmacao = new Main().adicionarFun(f1);
					if(confirmacao) {
						frmSportstockCadastro.setVisible(false);
						frmSportstockCadastro.dispose();
						Login.telaLogin();
					}
				}
				else {
					if(!validarNome(nome)) {
						nomeIncorreto.setText("O nome não pode ter números ou caracteres especiais e tem que ter pelo menos 3 letras");
					}
					if(!validarSenha(senha)) {
						senhaIncorreta.setText("A senha deve ter no minimo 7 caracteres, pelo menos 1 letra maiuscula, pelo menos 1 letra minuscula e pelo menos 1 numero");
					}
				}
				
			}
		});
		btnCadastrar.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		btnCadastrar.setBackground(new Color(158, 209, 165));
		btnCadastrar.setBounds(208, 445, 191, 51);
		frmSportstockCadastro.getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSportstockCadastro.setVisible(false);
				frmSportstockCadastro.dispose();
				Login.telaLogin();
			}
		});
		btnCancelar.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		btnCancelar.setBackground(new Color(158, 209, 165));
		btnCancelar.setBounds(595, 445, 191, 51);
		frmSportstockCadastro.getContentPane().add(btnCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon(Cadastro.class.getResource("/img/SportStockLogo.jpg")).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(424, -28, 150, 166);
		frmSportstockCadastro.getContentPane().add(lblNewLabel_1);
	
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
}
