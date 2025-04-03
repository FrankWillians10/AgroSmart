package br.com.agrosmart.domain.cerealista;

import java.util.Optional;

public interface CerealistaGateway {

    Cerealista create(Cerealista aCereslista);

    void deleteById(CerealistaID anId);

    Optional<Cerealista> findById();

    Cerealista update(Cerealista aCerealista);

}
