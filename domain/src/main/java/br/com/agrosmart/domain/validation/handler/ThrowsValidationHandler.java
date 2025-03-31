package br.com.agrosmart.domain.validation.handler;

import br.com.agrosmart.domain.exceptions.DomainException;
import br.com.agrosmart.domain.validation.Error;
import br.com.agrosmart.domain.validation.Validation;
import br.com.agrosmart.domain.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {


    @Override
    public ValidationHandler append(final Error anError) {
        throw DomainException.with(anError);
    }

    @Override
    public ValidationHandler append(final ValidationHandler anHandler) {
        throw DomainException.with(anHandler.getErrors());
    }

    @Override
    public List<Error> getErrors() {
        return null;
    }

    @Override
    public ValidationHandler validate(final Validation aValidation) {
        try {
            aValidation.validate();
        } catch (final Exception ex) {
            throw DomainException.with(new Error(ex.getMessage()));
        }

        return this;
    }
}
