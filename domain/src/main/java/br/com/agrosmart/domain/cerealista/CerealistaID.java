package br.com.agrosmart.domain.cerealista;

import br.com.agrosmart.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

public class CerealistaID extends Identifier {
    private final String value;

    public CerealistaID(final String value) {
        this.value = value;
    }

    public static CerealistaID unique() {
        return new CerealistaID(UUID.randomUUID().toString().toLowerCase());
    }

    public static CerealistaID from(final String anId) {
        return new CerealistaID(anId);
    }

    public static CerealistaID from(final UUID anId) {
        return new CerealistaID(anId.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CerealistaID)) return false;
        CerealistaID that = (CerealistaID) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
