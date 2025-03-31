package br.com.agrosmart.domain;

import br.com.agrosmart.domain.validation.ValidationHandler;

public abstract class AgregateRoot<ID extends Identifier> extends Entity<ID> {

    protected AgregateRoot(final ID id) {
        super(id);
    }
}
