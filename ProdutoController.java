package com.ifsp.GiDias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ifsp.GiDias.model.Produto;
import com.ifsp.GiDias.repository.ProdutoRepository;

@Controller
public class ProdutoController{ 

    @Autowired
    private ProdutoRepository ProdutoRepository;

    @GetMapping("/produto")
    public String getProduto(){
        return "formularioProduto.html";
    }

    @PostMapping("/cadastrar")
    public String cadastrarProduto (@RequestParam ("nome") String nome, @RequestParam ("descricao") String descricao, @RequestParam ("preco") double preco, @RequestParam ("quantidade") int quantidade){
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setPreco(preco);
        produto.setQuantidade(quantidade);
        ProdutoRepository.salvar(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/produtos")
    public String listarProduto(Model model){
       model.addAttribute("produtos", ProdutoRepository.findAll());
        return "listarProduto.html";
        
    }


}