package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProcessadorDeVendasTest {

  @Test
  void deveCalcularComissaoDeCincoPorCento() {
    NotificadorService notificador = mock(NotificadorService.class);
    ProcessadorDeVendas processador =
        new ProcessadorDeVendas(notificador);

    double comissao = processador.processarVenda(200.00);

    assertEquals(10.00, comissao, 0.001);
  }

  @Test
  void deveNotificarQuandoVendaForIgualOuSuperiorAMilReais() {
    NotificadorService notificador = mock(NotificadorService.class);
    ProcessadorDeVendas processador =
        new ProcessadorDeVendas(notificador);

    processador.processarVenda(1000.00);

    verify(notificador).notificar(
        "Venda atingiu o limite: R$ 1000.0"
    );
  }

  @Test
  void naoDeveNotificarQuandoVendaForInferiorAMilReais() {
    NotificadorService notificador = mock(NotificadorService.class);
    ProcessadorDeVendas processador =
        new ProcessadorDeVendas(notificador);

    processador.processarVenda(999.99);

    verify(notificador, never()).notificar(anyString());
  }
}
