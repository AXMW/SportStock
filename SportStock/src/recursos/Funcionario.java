package recursos;
//TODO metodos dos funcionarios

public class Funcionario {
	protected String nomeFun;
	protected String senhaFun;
	protected String hierarquiaFun;
	protected int idFun;
	
	public Funcionario() {
		
	}
	
	public String getNomeFun() {
		return nomeFun;
	}
	public void setNomeFun(String nomeFun) {
		this.nomeFun = nomeFun;
	}
	public String getSenhaFun() {
		return senhaFun;
	}
	public void setSenhaFun(String senhaFun) {
		this.senhaFun = senhaFun;
	}
	public String getHierarquiaFun() {
		return hierarquiaFun;
	}
	public void setHierarquiaFun(String hierarquiaFun) {
		this.hierarquiaFun = hierarquiaFun;
	}
	public int getIdFun() {
		return idFun;
	}
	public void setIdFun(int idFun) {
		this.idFun = idFun;
	}
	
	/*public Venda realizarVenda(Venda obj, int codigo) {
		
		return obj;
	}*/
	
	public Cliente cadastrarCliente(Cliente c1, String nome, int cpf, int telefone, String email) {
		c1.setNomeCli(nome);
		c1.setCpfCli(cpf);
		c1.setTelefoneCli(telefone);
		c1.setEmailCli(email);
		return c1;
	}
	
}
