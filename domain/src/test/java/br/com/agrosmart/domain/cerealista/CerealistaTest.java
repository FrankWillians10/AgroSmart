package br.com.agrosmart.domain.cerealista;

import br.com.agrosmart.domain.exceptions.DomainException;
import br.com.agrosmart.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CerealistaTest {
    @Test
    public void dadoParametrosValidos_quandoChamarNewCerealista_entaoInstaciaUmaCerealista() {
        final var nomeExperado = "Lar";
        final var cnpjExperado = "12345678901234";

        final var umaCerealista =
                Cerealista.newCerealista(nomeExperado, cnpjExperado);

        Assertions.assertNotNull(umaCerealista);
        Assertions.assertNotNull(umaCerealista.getId());
        Assertions.assertEquals(nomeExperado, umaCerealista.getName());
        Assertions.assertEquals(cnpjExperado, umaCerealista.getCnpj());


    }

    @Test
    public void dadoUmNomeNuloInvalido_quandoChamarNewCerealistaEValidate_entaoLancaUmaException() {
        final String nomeEsperado = null;
        final var cnpjEsperado = "12345678901234";
        final var mensagemDeErroEsperada = "'nome' nao pode ser nulo";
        final var quantidadeDeErrosEsperados = 1;

        final var umaCerealista =
                Cerealista.newCerealista(nomeEsperado, cnpjEsperado);

        final var atualException =
                Assertions.assertThrows(DomainException.class, () -> umaCerealista.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(mensagemDeErroEsperada ,atualException.getErrors().get(0).message());
        Assertions.assertEquals(quantidadeDeErrosEsperados ,atualException.getErrors().size());

    }

    @Test
    public void dadoUmNomeVazioInvalido_quandoChamarNewCerealistaEValidate_entaoLancaUmaException() {
        final String nomeEsperado = "  ";
        final var cnpjEsperado = "12345678901234";
        final var mensagemDeErroEsperada = "'nome' nao pode ser vazio";
        final var quantidadeDeErrosEsperados = 1;

        final var umaCerealista =
                Cerealista.newCerealista(nomeEsperado, cnpjEsperado);

        final var atualException =
                Assertions.assertThrows(DomainException.class, () -> umaCerealista.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(mensagemDeErroEsperada ,atualException.getErrors().get(0).message());
        Assertions.assertEquals(quantidadeDeErrosEsperados ,atualException.getErrors().size());

    }

    @Test
    public void dadoUmNomeComMenosDeTresCaracteresInvalido_quandoChamarNewCerealistaEValidate_entaoLancaUmaException() {
        final String nomeEsperado = "La ";
        final var cnpjEsperado = "12345678901234";
        final var mensagemDeErroEsperada = "'nome' deve ter entre 3 e 30 caracteres";
        final var quantidadeDeErrosEsperados = 1;

        final var umaCerealista =
                Cerealista.newCerealista(nomeEsperado, cnpjEsperado);

        final var atualException =
                Assertions.assertThrows(DomainException.class, () -> umaCerealista.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(mensagemDeErroEsperada ,atualException.getErrors().get(0).message());
        Assertions.assertEquals(quantidadeDeErrosEsperados ,atualException.getErrors().size());

    }

    @Test
    public void dadoUmNomeComMaisDeCinquentaCaracteresInvalido_quandoChamarNewCerealistaEValidate_entaoLancaUmaException() {
        final String nomeEsperado = "Louis Dreyfus Cerealista ltda   .";
        final var cnpjEsperado = "12345678901234";
        final var mensagemDeErroEsperada = "'nome' deve ter entre 3 e 30 caracteres";
        final var quantidadeDeErrosEsperados = 1;

        final var umaCerealista =
                Cerealista.newCerealista(nomeEsperado, cnpjEsperado);

        final var atualException =
                Assertions.assertThrows(DomainException.class, () -> umaCerealista.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(mensagemDeErroEsperada ,atualException.getErrors().get(0).message());
        Assertions.assertEquals(quantidadeDeErrosEsperados ,atualException.getErrors().size());

    }

}
