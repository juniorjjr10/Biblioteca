package com.ELD.Biblioteca.Controller;


import com.ELD.Biblioteca.domain.biblioteca.Biblioteca;
import com.ELD.Biblioteca.domain.biblioteca.Repositoory;
import com.ELD.Biblioteca.domain.biblioteca.dadosDeAlteracao;
import com.ELD.Biblioteca.domain.biblioteca.dadosDeCadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@Controller
@RequestMapping("/biblioteca")
public class BibliotecaController {

    @Autowired
    private Repositoory repositoory;




    @GetMapping("/formulario")
    public String carregarPaginaFormulario(Long id, Model model) {
        if (id != null){
            var Biblioteca= repositoory.getReferenceById(id);
            model.addAttribute("biblioteca", Biblioteca);
        }

        return "biblioteca/formulario";
    }

    @GetMapping

    public String carregarPaginaLista(Model model) {

        model.addAttribute("lista", repositoory.findAll());
        return "biblioteca/lista";
    }


    @PostMapping
    @Transactional

    public String cadastrarLivros(dadosDeCadastro dados) {
        var biblioteca = new Biblioteca(dados);
        repositoory.save(biblioteca);

        return "redirect:/biblioteca";



    }

    @PutMapping
    @Transactional

    public String AlterarLivros(dadosDeAlteracao dados) {
        var Biblioteca = repositoory.getReferenceById(dados.id());
        Biblioteca.atualizaDados(dados);


        return "redirect:/biblioteca";



    }

    @DeleteMapping
    @Transactional
    public String DeleteLivro(Long id){
        repositoory.deleteById(id);

        return "redirect:/biblioteca";
    }






}



    