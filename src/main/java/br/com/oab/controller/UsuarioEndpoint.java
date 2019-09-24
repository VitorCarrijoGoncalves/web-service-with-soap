package br.com.oab.controller;

import br.com.oab.model.User;
import br.com.oab.request.GetUsuarioRequest;
import br.com.oab.response.GetUsuarioResponse;
import br.com.oab.service.UserService;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UsuarioEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8080"; // ver qual vai ser o endereco certo aqui

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
    
    private static User XMLtoPersonExample(String filename) throws Exception {
        File file = new File(filename);
        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (User) jaxbUnmarshaller.unmarshal(file);
    }
    
    private static void personToXMLExample(String filename, User person) throws Exception {
        File file = new File(filename);
        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(person, file);
        jaxbMarshaller.marshal(person, System.out);
    }

}
