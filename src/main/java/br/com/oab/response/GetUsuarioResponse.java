package br.com.oab.response;

import br.com.oab.model.Usuario;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "usuario"
})
@XmlRootElement(name = "getUsuarioResponse")
public class GetUsuarioResponse {

    @XmlElement(required = true)
    protected Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
