package io.github.maykneves2727.testedevjavaimc.rest;

import io.github.maykneves2727.testedevjavaimc.model.entity.Usuario;
import io.github.maykneves2727.testedevjavaimc.model.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/Usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save (@RequestBody @Valid Usuario usuario){
        usuario.setImc(usuario.getPeso()/(usuario.getAltura()* usuario.getAltura()));
        if(usuario.getImc()<=18.5)
            usuario.setClassificacao("Abaixo do Peso");
        else if (usuario.getImc()>18.5 && usuario.getImc()<=24.9)
            usuario.setClassificacao("Peso Normal");
        else if (usuario.getImc()>24.9 && usuario.getImc()<=29.9)
            usuario.setClassificacao("Sobrepeso");
        else if (usuario.getImc()>29.9 && usuario.getImc()<=34.9)
            usuario.setClassificacao("Obesidade Grau I");
        else if (usuario.getImc()>34.9 && usuario.getImc()<=39.9)
            usuario.setClassificacao("Obesidade Grau II");
        else if (usuario.getImc()>= 40)
            usuario.setClassificacao("Obesidade Grau III");
        return repository.save(usuario);
    }

    @GetMapping("/listar")
    public List<Usuario> listar(){
        List<Usuario> usuarios; 
        return usuarios = repository.findAll();
    }

    @GetMapping("{cpf}")
    public Usuario acharPorCpf(@PathVariable String cpf){
            return this.repository.findUsuarioByCpf(cpf);
    }

}
