
package org.example;

public class ProcessadorDeVendas {

  private final NotificadorService notificadorService;

  public ProcessadorDeVendas(NotificadorService notificadorService) {
    this.notificadorService = notificadorService;
  }

  public double processarVenda(double valorVenda) {
    double comissao = valorVenda * 0.05;

    if (valorVenda >= 1000.00) {
      notificadorService.notificar(
          "Venda atingiu o limite: R$ " + valorVenda
      );
    }

    return comissao;
  }
}
