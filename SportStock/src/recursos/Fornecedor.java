package recursos;

public class Fornecedor {
	private String nomeFornec;
	private long telefoneFornec;
	private String emailFornec;
	private boolean confimacaoDeTroca;
	
	public Fornecedor() {
		
	}
	
	public String getNomeFornec() {
		return nomeFornec;
	}
	public void setNomeFornec(String nomeFornec) {
		this.nomeFornec = nomeFornec;
	}
	public long getTelefoneFornec() {
		return telefoneFornec;
	}
	public void setTelefoneFornec(Long telefoneFornec) {
		this.telefoneFornec = telefoneFornec;
	}
	public String getEmailFornec() {
		return emailFornec;
	}
	public void setEmailFornec(String emailFornec) {
		this.emailFornec = emailFornec;
	}
	public boolean isConfimacaoDeTroca() {
		return confimacaoDeTroca;
	}
	public void setConfimacaoDeTroca(boolean confimacaoDeTroca) {
		this.confimacaoDeTroca = confimacaoDeTroca;
	}

}
