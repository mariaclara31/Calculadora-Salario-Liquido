package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		double salarioLiquido = calculaIRRF(calcularInss(salarioBase));
		if(salarioLiquido <= 1039.00) {
			return 0;
		} else {
			return Math.round(salarioLiquido);
		}
	}

	private double calcularInss(double salarioBase) {
		if(salarioBase <= 1500.00){
			return (salarioBase - salarioBase * 0.08);
		} else if (salarioBase >= 1500.01 && salarioBase <= 4000.00) {
			return (salarioBase -salarioBase * 0.09);
		} else {
			return (salarioBase - salarioBase * 0.11);
		}
	}

	private double calculaIRRF(double valorReferencia) {
		if(valorReferencia <= 3000.00) {
			return valorReferencia;
		} else if (valorReferencia >= 3000.01 && valorReferencia <= 6000.00) {
			return (valorReferencia - valorReferencia * 0.075);
		} else {
			return (valorReferencia - valorReferencia * 0.15);
		}
	}
}
