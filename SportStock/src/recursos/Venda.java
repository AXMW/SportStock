package recursos;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class Venda {
	private int codVenda;
	private float precoVenda;
	private String dataVenda;
	private String codNF;
	private String descricaoVenda;
	
	public Venda() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		this.dataVenda = formatter.format(date);
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