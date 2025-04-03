package br.com.agrosmart.application.cerealista.create;

import br.com.agrosmart.domain.cerealista.Cerealista;
import br.com.agrosmart.domain.cerealista.CerealistaID;

public record CreateCerealistaOutput(CerealistaID id) {

    public static CreateCerealistaOutput from(final Cerealista aCerealista) {
        return new CreateCerealistaOutput(aCerealista.getId());
    }

}
