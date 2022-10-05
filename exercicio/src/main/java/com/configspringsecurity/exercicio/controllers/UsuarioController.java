package com.configspringsecurity.exercicio.controllers;

import com.configspringsecurity.exercicio.models.UsuarioModel;
import com.configspringsecurity.exercicio.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path = "/list")
    public ResponseEntity<List<UsuarioModel>> buscarTodosUsuarios(){
        return ResponseEntity.ok(usuarioService.buscarUsuarios());
    }

    @PostMapping(path = "/create")
    public ResponseEntity<UsuarioModel> cadastrarUsuario (@RequestBody UsuarioModel usuarioModel){
        UsuarioModel usuarioNovo = usuarioService.cadastrarUsuarios(usuarioModel);
        return new ResponseEntity<>(usuarioNovo, HttpStatus.CREATED);
    }

    @PutMapping(path = "/update/{id}")
    public UsuarioModel alterarUsuario(@RequestBody UsuarioModel usuarioModel){
        return usuarioService.atualizarUsuario(usuarioModel);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/delete/{id}")
    public void deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
    }
}
