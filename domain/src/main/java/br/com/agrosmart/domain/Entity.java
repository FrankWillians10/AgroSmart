package br.com.agrosmart.domain;

import br.com.agrosmart.domain.validation.ValidationHandler;

import java.util.Objects;

public abstract class Entity<ID extends Identifier> {
    protected final ID id;

    protected Entity(final ID id) {
        Objects.requireNonNull(id, "'id' não pode ser nulo");
        this.id = id;
    }

    public abstract void validate(ValidationHandler handler);

    public ID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;
        Entity<?> entity = (Entity<?>) o;
        return getId().equals(entity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
