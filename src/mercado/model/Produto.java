package mercado.model;

public abstract class Produto {

	private int idProduto;
	private String nomeProduto;
	private int tipoProduto;
	private float valor;
	
	public Produto(int idProduto, String nomeProduto, int tipoProduto, float valor) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.tipoProduto = tipoProduto;
		this.valor = valor;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(int tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
	public void visualizar() {

		String tipo = "";

		switch (this.tipoProduto) {
		case 1 -> tipo = "Bebidas";
		case 2 -> tipo = "Lanches";

		}

		System.out.println("\n\n****************************************");
		System.out.println("Dados do Produto");
		System.out.println("****************************************");
		System.out.println("ID do Produto: " + this.idProduto);
		System.out.println("Nome do Produto: " + this.nomeProduto);
		System.out.println("Tipo de Produto: " + tipo);
		System.out.println("Valor do Produto R$: " + this.valor);
	}

	
	
}
