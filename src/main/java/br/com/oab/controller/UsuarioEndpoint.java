package br.com.oab.controller;

import br.com.oab.request.GetUsuarioRequest;
import br.com.oab.response.GetUsuarioResponse;
import br.com.oab.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UsuarioEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8080/ws"; // ver qual vai ser o endereco certo aqui

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioEndpoint(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsuarioRequest")
    @ResponsePayload
    public GetUsuarioResponse getUsuario(@ResponsePayload GetUsuarioRequest request) {
        GetUsuarioResponse response = new GetUsuarioResponse();
        response.setUsuario(usuarioRepository.findById(request.getId()));

        return response;

    }


}
