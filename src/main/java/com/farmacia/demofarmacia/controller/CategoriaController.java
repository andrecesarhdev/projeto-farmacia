package com.farmacia.demofarmacia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.farmacia.demofarmacia.model.Categoria;
import com.farmacia.demofarmacia.repository.CategoriaRepository;

import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/categorias")
@Tag (name = "Categorias", description = "Gerenciamento de categorias de produtos")
public class CategoriaController {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    @Operation(summary = "Listar todas as categorias")
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }
    @PostMapping
    @Operation(summary = "Criar uma nova categoria")
    public Categoria criarCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);

    }
    @GetMapping("/{id}")
    @Operation(summary = "Buscar uma categoria por ID")
    public Categoria buscarCategoriaPorId(@PathVariable Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar uma categoria existente")
    public Categoria atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        categoria.setNome(categoria.getNome());
        categoria.setDescricao(categoria.getDescricao());
        return categoriaRepository.save(categoria);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover uma categoria existente")
    public void removerCategoria(@PathVariable Long id) {
        categoriaRepository.deleteById(id);
    }






}
