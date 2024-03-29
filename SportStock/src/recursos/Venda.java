package recursos;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class Venda {
	private int codVenda;
	private float precoVenda;
	private String dataVenda;
	private String codNF;
	private String descricaoVenda;
	private int idProd;
	private int indexProd;
	private int qtdProd;
	private int idFunVenda;
	private int idCupomDesconto;
	
	public Venda() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		this.dataVenda = formatter.format(date);
		this.idCupomDesconto = 0;
	}
	
	
	public int getIndexProd() {
		return indexProd;
	}

	public void setIndexProd(int indexProd) {
		this.indexProd = indexProd;
	}

	public int getQtdProd() {
		return qtdProd;
	}


	public void setQtdProd(int qtdProd) {
		this.qtdProd = qtdProd;
	}


	public int getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public int getIdFunVenda() {
		return idFunVenda;
	}

	public void setIdFunVenda(int idFunVenda) {
		this.idFunVenda = idFunVenda;
	}

	public int getIdCupomDesconto() {
		return idCupomDesconto;
	}

	public void setIdCupomDesconto(int idCupomDesconto) {
		this.idCupomDesconto = idCupomDesconto;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public int getCodVenda() {
		return codVenda;
	}

	public void setCodVenda(int codVenda) {
		this.codVenda = codVenda;
	}

	public float getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}

	public String getCodNF() {
		return codNF;
	}

	public void setCodNF(String codNF) {
		this.codNF = codNF;
	}

	public String getDescricaoVenda() {
		return descricaoVenda;
	}

	public void setDescricaoVenda(String descricaoVenda) {
		this.descricaoVenda = descricaoVenda;
	}

}
