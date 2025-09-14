package com.farmacia.demofarmacia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.farmacia.demofarmacia.model.Produto;
import com.farmacia.demofarmacia.repository.ProdutoRepository;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/produtos")
@Tag(name = "Produto", description = "Gerenciamento de produtos na farmácia")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    @Operation(summary = "Listar todos os produtos", description = "Retorna uma lista de todos os produtos disponíveis na farmácia")
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Adicionar um novo produto", description = "Adiciona um novo produto à farmácia")
    public Produto adicionarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar um produto por ID", description = "Retorna um produto da farmácia pelo ID")
    public Produto buscarProdutoPorId(@PathVariable Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um produto", description = "Atualiza os detalhes de um produto existente na farmácia pelo ID")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        Produto p = produtoRepository.findById(id).orElseThrow();
        p.setNome(produto.getNome());
        p.setPreco(produto.getPreco());
        p.setQuantidade(produto.getQuantidade());
        return produtoRepository.save(p);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover um produto", description = "Remove um produto da farmácia pelo ID")
    public void removerProduto(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}
