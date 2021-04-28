package br.com.orangetalents.CasaDoCodigo.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.orangetalents.CasaDoCodigo.dto.requests.NovoClienteRequest;
import br.com.orangetalents.CasaDoCodigo.entity.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PaisPossuiEstadoValidator implements Validator {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoClienteRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        NovoClienteRequest clienteRequest = (NovoClienteRequest) o;

        Pais pais = em.find(Pais.class, clienteRequest.getIdPais());

        boolean naoTemEstado = pais.getEstados().isEmpty();

        if (!naoTemEstado && clienteRequest.getIdEstado() == null) {
            errors.rejectValue("idEstado", null, "Esse País possui Estado, portanto terá de escolher um Estado para finalizar!");
        }
    }
}