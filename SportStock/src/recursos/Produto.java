package recursos;

public class Produto {
	private String nomeProd;
	private int idProd;
	private String tipoProd;
	private float precoProd;
	private String descricaoProd;
	private int qtdProd;
	private int produtosTrocados;
	
	public Produto() {
		
	}

	public String getNomeProd() {
		return nomeProd;
	}

	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}

	public int getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public String getTipoProd() {
		return tipoProd;
	}

	public void setTipoProd(String tipoProd) {
		this.tipoProd = tipoProd;
	}

	public float getPrecoProd() {
		return precoProd;
	}

	public void setPrecoProd(float precoProd) {
		this.precoProd = precoProd;
	}

	public String getDescricaoProd() {
		return descricaoProd;
	}

	public void setDescricaoProd(String descricaoProd) {
		this.descricaoProd = descricaoProd;
	}

	public int getQtdProd() {
		return qtdProd;
	}

	public void setQtdProd(int qtdProd) {
		this.qtdProd = qtdProd;
	}

	public int getProdutosTrocados() {
		return produtosTrocados;
	}

	public void setProdutosTrocados(int produtosTrocados) {
		this.produtosTrocados = produtosTrocados;
	}


}
