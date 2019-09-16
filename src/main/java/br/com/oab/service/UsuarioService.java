package br.com.oab.service;

import br.com.oab.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UsuarioService {

    Usuario createOrUpdate(Usuario user);

    Optional<Usuario> findById(Long id);

    void delete(Long id);

    Page<Usuario> findAll(int page, int count);

}
