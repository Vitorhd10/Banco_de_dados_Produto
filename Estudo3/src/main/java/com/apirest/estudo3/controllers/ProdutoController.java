package com.apirest.estudo3.controllers;


import com.apirest.estudo3.models.Produto;
import com.apirest.estudo3.repository.ProdutoRepository;
import com.apirest.estudo3.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.ID;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
@RestController
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/produtos")
    public List<Produto> listaProdutos() {
        return produtoService.listaProdutos();
    }

    @GetMapping("/produto/{id}")
    public Produto listaProdutounico(@PathVariable(value = "id") Long id) {
        return produtoService.listaProdutounico(id);
    }

    @PostMapping(value = "/salvar")
    public ModelAndView salvar(@ModelAttribute Produto produto) {
        ModelAndView mv = new ModelAndView("salvo");
        Produto produto1 = produtoService.salvar(produto);
        return mv;
    }

    @GetMapping("/salvo")
    public String salvo(Model model) {
        return "salvo";
    }

    @GetMapping(value = "/index")
    public ModelAndView newProduto() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @GetMapping("/")
    public ModelAndView formIndex(Model model) {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }


}
