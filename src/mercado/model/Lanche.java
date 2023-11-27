package mercado.model;

public class Lanche extends Produto {

	private int sabor;

	public Lanche(int idProduto, String nomeProduto, int tipoProduto, float valor, int sabor) {
		super(idProduto, nomeProduto, tipoProduto, valor);
		this.sabor = sabor;
	}

	public int getSabor() {
		return sabor;
	}

	public void setSabor(int sabor) {
		this.sabor = sabor;
	}

	public boolean checarSabor(int gosto) {
		if (this.getSabor() == 1) {
			return false;
		}
		return true;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		if (checarSabor(sabor) == false) {
			System.out.println("Sabor: Doce");
		} else
			System.out.println("Sabor: Salgado");
	}

}
