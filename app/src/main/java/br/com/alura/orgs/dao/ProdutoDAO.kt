package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Produto

class ProdutoDAO {
//    private val produtos = mutableListOf<Produto>()
    fun adiciona(produto: Produto) {
        produtos.add(produto)
    }

    fun buscaTodos(): List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}