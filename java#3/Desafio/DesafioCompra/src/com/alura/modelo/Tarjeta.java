package com.alura.modelo;

public class Tarjeta {
    private Double saldoDisponible;
    private String credito; // Monto maximo que es el usuario puede gastar

    public Tarjeta(Double saldoDisponible, String credito) {
        this.saldoDisponible = saldoDisponible;
        this.credito = credito;
    }

    public String getCredito() {
        return credito;
    }

    public Double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void realizarCompra(Double monto) {
        if (monto <= saldoDisponible) {
            saldoDisponible -= monto;
            System.out.println("Compra realizada por: $" + monto);
        } else {
            System.out.println("Saldo insuficiente para realizar la compra.");
        }
    }

    public void verificarSaldo() {
        System.out.println("Saldo disponible: $" + saldoDisponible);
    }
}
