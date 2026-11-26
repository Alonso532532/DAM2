package ejercicios.consultas.records;

import ejercicios.consultas.Modelos.Cliente;

public record ClienteResumen(Cliente cliente, Long totalCoches, Double precioTotal) {}