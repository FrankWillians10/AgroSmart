package br.com.agrosmart.application.cerealista.create;

public record CreateCerealistaCommand(String name, String cnpj) {

    public static CreateCerealistaCommand with(final String aName, final String aCnpj) {
        return new CreateCerealistaCommand(aName, aCnpj);
    }

}
