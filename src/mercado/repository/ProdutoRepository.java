package mercado.repository;

import mercado.model.Produto;

public interface ProdutoRepository {
	
	public void procurarPorId(int id);
	public void listarTodos();
	public void cadastro(Produto produto);
	public void atualizar(Produto produto);
	public void deletar(int id);

}
