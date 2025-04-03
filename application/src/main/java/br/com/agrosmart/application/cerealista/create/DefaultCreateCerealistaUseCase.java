package br.com.agrosmart.application.cerealista.create;

import br.com.agrosmart.domain.cerealista.Cerealista;
import br.com.agrosmart.domain.cerealista.CerealistaGateway;
import br.com.agrosmart.domain.validation.handler.ThrowsValidationHandler;

import java.util.Objects;

public class DefaultCreateCerealistaUseCase extends CreateCerealistaUseCase {
    private final CerealistaGateway cerealistaGateway;

    public DefaultCreateCerealistaUseCase(final CerealistaGateway cerealistaGateway) {
        this.cerealistaGateway = Objects.requireNonNull(cerealistaGateway);
    }

    @Override
    public CreateCerealistaOutput execute(final CreateCerealistaCommand aCommand) {

        final var aCerealista = Cerealista.newCerealista(aCommand.name(), aCommand.cnpj());
        aCerealista.validate(new ThrowsValidationHandler());

        return CreateCerealistaOutput.from(this.cerealistaGateway.create(aCerealista));
    }
}
