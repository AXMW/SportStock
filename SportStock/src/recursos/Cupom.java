package recursos;

public class Cupom {
	private int idCupom;
	private String codCupom;
	private float porcentagemCupom;
	private int qtdUsosCupom;
	
	public Cupom() {
		
	}
	
	public int getIdCupom() {
		return idCupom;
	}
	
	public void setIdCupom(int idCupom) {
		this.idCupom = idCupom;
	}
	
	public String getCodCupom() {
		return codCupom;
	}
	
	public void setCodCupom(String codCupom) {
		this.codCupom = codCupom;
	}
	
	public float getPorcentagemCupom() {
		return porcentagemCupom;
	}
	
	public void setPorcentagemCupom(float porcentagemCupom) {
		this.porcentagemCupom = porcentagemCupom;
	}
	
	public int getQtdUsosCupom() {
		return qtdUsosCupom;
	}
	
	public void setQtdUsosCupom(int qtdUsosCupom) {
		this.qtdUsosCupom = qtdUsosCupom;
	}
	
}