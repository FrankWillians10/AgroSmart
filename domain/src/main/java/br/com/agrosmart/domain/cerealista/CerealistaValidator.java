package br.com.agrosmart.domain.cerealista;

import br.com.agrosmart.domain.validation.Error;
import br.com.agrosmart.domain.validation.ValidationHandler;
import br.com.agrosmart.domain.validation.Validator;

public class CerealistaValidator extends Validator {

    private final Cerealista cerealista;

    public CerealistaValidator(final Cerealista aCerealista, final ValidationHandler aHandler) {
        super(aHandler);
        this.cerealista = aCerealista;
    }

    @Override
    public void validate() {

        checkNameConstraints();
        checkCnpjConstraints();

    }

    private void checkNameConstraints() {
        final var name = this.cerealista.getName();
        if(name == null) {
            this.validationHandler().append(new Error("'nome' nao pode ser nulo"));
            return;
        }

        if(name.isBlank()) {
            this.validationHandler().append(new Error("'nome' nao pode ser vazio"));
            return;
        }

        final int length = name.trim().length();
        if(length > 30 || length < 3) {
            this.validationHandler().append(new Error("'nome' deve ter entre 3 e 30 caracteres"));
            return;
        }
    }

    private void checkCnpjConstraints() {
        final var cnpj = this.cerealista.getCnpj();
        if(cnpj == null) {
            this.validationHandler().append(new Error("'nome' nao pode ser nulo"));
            return;
        }

        if(cnpj.isEmpty()) {
            this.validationHandler().append(new Error("'nome' nao pode ser vazio"));
            return;
        }

        if(!cnpj.matches("[0-9]{2}[.-]?[0-9]{3}[.-]?[0-9]{3}[./-]?[0-9]{4}[.-]?[0-9]{2}")) {
            this.validationHandler().append(new Error("'cnpj' deve ter conter 14 números"));
            return;
        }
    }
}
