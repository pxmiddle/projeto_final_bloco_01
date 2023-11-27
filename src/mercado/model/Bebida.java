package mercado.model;

public class Bebida extends Produto {

	private int alcool;

	public Bebida(int idProduto, String nomeProduto, int tipoProduto, float valor, int alcool) {
		super(idProduto, nomeProduto, tipoProduto, valor);
		this.alcool = alcool;
	}

	public int getAlcool() {
		return alcool;
	}

	public void setAlcool(int alcool) {
		this.alcool = alcool;
	}

	public boolean checarIdade(int maioridade) {
		if (this.getAlcool() < 18) {
			return false;
		}
		return true;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		if (checarIdade(alcool) == false) {
			System.out.println("Idade: " + this.alcool + " anos \nBebidas alcoólicas são Proibido para menores");
		} else
			System.out.println("Idade: " + this.alcool + " anos \nBebida alcoólica liberada");
	}
}