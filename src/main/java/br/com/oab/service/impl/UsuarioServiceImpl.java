//package br.com.oab.service.impl;
//
//import br.com.oab.model.Usuario;
//import br.com.oab.repository.UsuarioRepository;
//import br.com.oab.service.UsuarioService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UsuarioServiceImpl implements UsuarioService {
//
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//
//    @Override
//    public Usuario createOrUpdate(Usuario usuario) {
//        return this.usuarioRepository.save(usuario);
//    }
//
//    @Override
//    public Optional<Usuario> findById(Long id) {
//        return this.usuarioRepository.findById(id);
//    }
//
//    @Override
//    public void delete(Long id) {
//        this.usuarioRepository.deleteById(id);
//    }
//
//    @Override
//    public Page<Usuario> findAll(int page, int count) {
//        Pageable pages = (Pageable) new PageRequest(page, count);
//        return this.usuarioRepository.findAll(pages);
//    }
//}
