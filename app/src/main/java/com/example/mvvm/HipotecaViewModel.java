package com.example.mvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class HipotecaViewModel extends AndroidViewModel {

    Executor executor;

    SimuladorHipoteca simulador;

    MutableLiveData<Double> cuota = new MutableLiveData<>();

    public HipotecaViewModel(@NonNull Application application) {
        super(application);

        executor = Executors.newSingleThreadExecutor();
        simulador = new SimuladorHipoteca();
    }

    public void calcular(double capital, int plazo) {

        final SolicitudHipoteca solicitud = new SolicitudHipoteca(capital, plazo);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                double cuotaResultante = simulador.calcular(solicitud);
                cuota.postValue(cuotaResultante);
            }
        });
    }
}