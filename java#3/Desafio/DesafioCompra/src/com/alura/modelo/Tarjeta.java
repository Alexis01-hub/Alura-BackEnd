package com.alura.modelo;

/**
 * Clase que representa una tarjeta de crédito con límite y saldo disponible.
 * Permite realizar compras descontando del saldo disponible y verificar el saldo actual.
 *
 */
public class Tarjeta {
    private Double saldoDisponible; // Saldo actual disponible para realizar compras
    private Double credito; // Límite máximo de crédito de la tarjeta

    /**
     * Constructor que inicializa la tarjeta con un saldo disponible y límite de crédito.
     *
     * @param saldoDisponible El saldo inicial disponible en la tarjeta
     * @param credito El límite máximo de crédito de la tarjeta
     */
    public Tarjeta(Double saldoDisponible, Double credito) {
        this.saldoDisponible = saldoDisponible;
        this.credito = credito;
    }

    /**
     * Obtiene el límite de crédito de la tarjeta.
     *
     * @return El límite máximo de crédito
     */
    public Double getCredito() {
        return credito;
    }

    /**
     * Obtiene el saldo disponible actual de la tarjeta.
     *
     * @return El saldo disponible para compras
     */
    public Double getSaldoDisponible() {
        return saldoDisponible;
    }

    /**
     * Intenta realizar una compra con el monto especificado.
     * Si hay saldo suficiente, descuenta el monto del saldo disponible.
     * Si no hay saldo suficiente, muestra un mensaje de error.
     *
     * @param monto El valor de la compra a realizar
     */
    public void realizarCompra(Double monto) {
        if (monto <= saldoDisponible) {
            saldoDisponible -= monto; // Descuenta el monto del saldo disponible
            System.out.println("Compra realizada por: $" + monto);
        } else {
            System.out.println("Saldo insuficiente para realizar la compra.");
            System.out.println("--------------------------------------------");
        }
    }

    /**
     * Muestra en consola el saldo disponible actual de la tarjeta.
     */
    public void verificarSaldo() {
        System.out.println("Saldo disponible: $" + saldoDisponible);
    }
}
