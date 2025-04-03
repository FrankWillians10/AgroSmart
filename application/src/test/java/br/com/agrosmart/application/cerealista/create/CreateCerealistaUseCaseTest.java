package br.com.agrosmart.application.cerealista.create;

import br.com.agrosmart.domain.cerealista.Cerealista;
import br.com.agrosmart.domain.cerealista.CerealistaGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Objects;

import static org.mockito.AdditionalAnswers.returnsFirstArg;

public class CreateCerealistaUseCaseTest {

    @Test
    public void dadoUmComandoValido_quandoChamarCreateCerealista_entaoRetornaIdDaCerealista() {

        final var nomeEsperado = "Cargill";
        final var cnpjEsperado = "02.123.456/0001-12";
        final var cerealistaEsperada = Cerealista.newCerealista(nomeEsperado, cnpjEsperado);

        final var umComando = CreateCerealistaCommand.with(nomeEsperado, cnpjEsperado);

        final CerealistaGateway cerealistaGateway = Mockito.mock(CerealistaGateway.class);

        Mockito.when(cerealistaGateway.create(Mockito.any()))
                .thenAnswer(returnsFirstArg());

        final var useCase = new DefaultCreateCerealistaUseCase(cerealistaGateway);

        final var atualSaida = useCase.execute(umComando);

        Assertions.assertNotNull(atualSaida);
        Assertions.assertNotNull(atualSaida.id());

        Mockito.verify(cerealistaGateway, Mockito.times(1))
                .create(Mockito.argThat(aCerealista -> {
                    return Objects.equals(nomeEsperado, cerealistaEsperada.getName())
                            && Objects.nonNull(cerealistaEsperada.getId())
                            && Objects.equals(cnpjEsperado, cerealistaEsperada.getCnpj());
                }
                ));
    }

}
