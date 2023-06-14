package telas;

import java.awt.EventQueue;
import recursos.*;
import main.Main;
import telas.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Login {

	private JFrame frmSportstockLogin;
	private JTextField IDFun;
	private JPasswordField senhaFun;
	private static ArrayList<Funcionario> funcio = new ArrayList<Funcionario>();
	private static String[] funId = new String[2];

	
	public static void telaLogin() {
		
		funcio = new Main().getListaFun();
		try {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Login window = new Login();
						window.frmSportstockLogin.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Create the application.
	 */
	public Login() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSportstockLogin = new JFrame();
		frmSportstockLogin.getContentPane().setBackground(new Color(255, 255, 255));
		frmSportstockLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/SportStockLogo.jpg")));
		frmSportstockLogin.setTitle("Login");
		frmSportstockLogin.setBounds(100, 100, 1060, 585);
		frmSportstockLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSportstockLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Insira o seu ID de funcionario:");
		lblNewLabel.setBounds(376, 149, 261, 20);
		lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		frmSportstockLogin.getContentPane().add(lblNewLabel);
		
		IDFun = new JTextField();
		IDFun.setBackground(new Color(240, 240, 240));
		IDFun.setHorizontalAlignment(SwingConstants.CENTER);
		IDFun.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		IDFun.setBounds(376, 180, 261, 38);
		frmSportstockLogin.getContentPane().add(IDFun);
		IDFun.setColumns(10);
		
		JLabel erro = new JLabel("");
		erro.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		erro.setForeground(new Color(255, 0, 0));
		erro.setHorizontalAlignment(SwingConstants.CENTER);
		erro.setBounds(376, 347, 261, 14);
		frmSportstockLogin.getContentPane().add(erro);
		
		JLabel lblInsiraOSua = new JLabel("Insira a sua senha:");
		lblInsiraOSua.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblInsiraOSua.setBounds(426, 253, 156, 20);
		frmSportstockLogin.getContentPane().add(lblInsiraOSua);
		
		senhaFun = new JPasswordField();
		senhaFun.setBackground(new Color(240, 240, 240));
		senhaFun.setHorizontalAlignment(SwingConstants.CENTER);
		senhaFun.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		senhaFun.setBounds(376, 284, 261, 38);
		frmSportstockLogin.getContentPane().add(senhaFun);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.setBackground(new Color(158, 209, 165));
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = IDFun.getText();
				int idF = 0;
				try {
					idF = Integer.parseInt(id);
					String senha = new String(senhaFun.getPassword());
					int index = 0;
					for(int i = 0; i < funcio.size(); ++i) {
						if(funcio.get(i).getIdFun() == idF) {
							index = i;
							break;
						}
					}
					if(funcio.size() != 0) {
						if(funcio.get(index).getIdFun() == idF && funcio.get(index).getSenhaFun().equals(senha)) {
							funId[0] = "menu";
							funId[1] = id;
							//HAHAHAHAAH ESSA THREAD N ME PERTENCE
							//Thread.currentThread().notify();
							frmSportstockLogin.setVisible(false);
							frmSportstockLogin.dispose();
							if(funcio.get(index).getHierarquiaFun().equals("Gerente")) {
								TelaGerente.telaGerente();
							}
						}
						else {
							erro.setText("Usuario e/ou senha incorreto(s)");;
						}
					}
				} catch (Exception excecao) {
					erro.setText("Insira apenas numeros no campo de ID");
				}
				
				
			}
		});
		btnAcessar.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		btnAcessar.setBounds(141, 434, 191, 51);
		frmSportstockLogin.getContentPane().add(btnAcessar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(new Color(158, 209, 165));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSportstockLogin.setVisible(false);
				frmSportstockLogin.dispose();
				Cadastro.telaCadastro();
			}
		});
		btnCadastrar.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		btnCadastrar.setBounds(411, 434, 191, 51);
		frmSportstockLogin.getContentPane().add(btnCadastrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBackground(new Color(158, 209, 165));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		btnSair.setBounds(681, 434, 191, 51);
		frmSportstockLogin.getContentPane().add(btnSair);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon(Cadastro.class.getResource("/img/SportStockLogo.jpg")).getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(411, 0, 191, 147);
		frmSportstockLogin.getContentPane().add(lblNewLabel_1);
		
		
	}
}
