package br.com.oab.service;

import br.com.oab.model.Usuario;
import br.com.oab.request.GetUsuarioRequest;
import br.com.oab.response.GetUsuarioResponse;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Map<Long, Usuario> users = new HashMap<>();

    @PostConstruct
    public void initialize() {

        Usuario peter = new Usuario();
        peter.setId(1l);
        peter.setNome("Peter");
        peter.setEmail("peter@emal.com");

        Usuario sam = new Usuario();
        sam.setId(2l);
        sam.setNome("Sam");
        sam.setEmail("sam@emal.com");

        Usuario ryan = new Usuario();
        ryan.setId(2l);
        ryan.setNome("Ryan");
        ryan.setEmail("ryan@emal.com");

        users.put(peter.getId(), peter);
        users.put(sam.getId(), sam);
        users.put(ryan.getId(), ryan);
    }


    public Usuario getUsers(Long id) {
        return users.get(id);
    }

}
