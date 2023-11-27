package mercado.controller;

import java.util.ArrayList;
import java.util.Optional;

import mercado.model.Produto;
import mercado.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

	private ArrayList<Produto> listaProduto = new ArrayList<Produto>();

	int id = 0;

	@Override
	public void procurarPorId(int id) {

		Optional<Produto> produto = buscarNaCollection(id);

		if (produto.isPresent()) {
			produto.get().visualizar();
		} else {
			System.out.println("A conta número: " + id + " não foi encontrada!");
		}

	}

	@Override
	public void listarTodos() {
		if (listaProduto.isEmpty()) {
			System.out.println("Não existem contas cadastradas.");
		}
		for (var produto : listaProduto) {
			produto.visualizar();
		}

	}

	@Override
	public void cadastro(Produto produto) {
		listaProduto.add(produto);
		System.out.println("O Produto: " + produto.getIdProduto() + " foi cadastrada com Sucesso");
	}

	@Override
	public void atualizar(Produto produto) {

		Optional<Produto> buscaProduto = buscarNaCollection(produto.getIdProduto());

		if (buscaProduto.isPresent()) {
			listaProduto.set(listaProduto.indexOf(buscaProduto.get()), produto);
			System.out.println("A conta número: " + produto.getIdProduto() + " foi Alterada com sucesso.");
		} else {
			System.out.println("A conta número: " + produto.getIdProduto() + " não foi encontrada.");
		}

	}

	@Override
	public void deletar(int id) {
		
		Optional<Produto> produto = buscarNaCollection(id);

		if (produto.isPresent()) {
			if (listaProduto.remove(produto.get()) == true) {
				System.out.println("A conta número: " + id + " foi excluida com sucesso.");
			}

		} else {
			System.out.println("A conta número: " + id + " não foi encontrada.");
		}

	}

	public int gerarId() {
		return ++id;
	}

	public Optional<Produto> buscarNaCollection(int id) {
		for (var produto : listaProduto) {
			if (produto.getIdProduto() == id)
				return Optional.of(produto);
		}
		return Optional.empty();
	}

}
