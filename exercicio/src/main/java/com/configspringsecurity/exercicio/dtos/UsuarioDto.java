package com.configspringsecurity.exercicio.dtos;

import com.configspringsecurity.exercicio.models.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto implements Serializable {

    private Long id;
    private String nome;
    private Integer idade;
    private String telefone;
    private String login;
    private String senha;

    public UsuarioDto(UsuarioModel usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.idade = usuario.getIdade();
        this.telefone = usuario.getTelefone();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
    }


}
