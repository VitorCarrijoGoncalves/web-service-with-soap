package br.com.oab.controller;

import br.com.oab.request.GetUsuarioRequest;
import br.com.oab.response.GetUsuarioResponse;
import br.com.oab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UsuarioEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8080"; // ver qual vai ser o endereco certo aqui

//    @Autowired
//    private UsuarioService usuarioService;

    @Autowired
    private UserService userService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsuarioRequest")
    @ResponsePayload
    public GetUsuarioResponse getUsuario(@RequestPayload GetUsuarioRequest request) {
        GetUsuarioResponse response = new GetUsuarioResponse();
//        response.setUsuario(usuarioRepository.findById(request.getId()).get());
        response.setUsuario(userService.getUsers(request.getId()));

        return response;

    }

}
