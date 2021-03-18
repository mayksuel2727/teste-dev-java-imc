package io.github.maykneves2727.testedevjavaimc.model.repository;

import io.github.maykneves2727.testedevjavaimc.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {

    Usuario findUsuarioByCpf(String cpf);
}

