package com.example.mvvm;

public class SimuladorHipoteca {
    public double calcular(SolicitudHipoteca solicitud) {
        double interes = 0;
        try {
            Thread.sleep(10000);   // simular operacion de larga duracion (10s)
            interes = 0.01605;
        } catch (InterruptedException e) {}

        return solicitud.capital*interes/12/(1-Math.pow(1+(interes/12),-solicitud.plazo*12));
    }
}