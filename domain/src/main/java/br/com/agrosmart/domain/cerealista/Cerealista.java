package br.com.agrosmart.domain.cerealista;

import br.com.agrosmart.domain.AgregateRoot;
import br.com.agrosmart.domain.validation.ValidationHandler;

import java.util.ArrayList;
import java.util.List;


public class Cerealista extends AgregateRoot<CerealistaID> {

   private String name;
   private String cnpj;
   final private List <String> contratos = new ArrayList<>();

    private Cerealista(final CerealistaID id, final String name, final String cnpj) {
        super(id);
        this.name = name;
        this.cnpj = cnpj;
    }

    public static Cerealista newCerealista(final String name, final String cnpj) {
        final var id = CerealistaID.unique();
        return new Cerealista(id,name, cnpj);
    }

    @Override
    public void validate(final ValidationHandler handler) {
        new CerealistaValidator(this, handler).validate();
    }

    public CerealistaID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCnpj() {
        return cnpj;
    }
}