package org.example.parte2;

public class DatosTeruel {
    Float avgTMax, tMaxMax, tMaxMin, avgTMin, tMinMax, tMinMin;
    String aMaxMax, aMaxMin, aMinMax, aMinMin;

    public DatosTeruel(Float avgTmax, Float tMaxMax, Float tMaxMin, Float avgTmin, Float tMinMax, Float tMinMin, String aMaxMax, String aMaxMin, String aMinMax, String aMinMin) {
        this.avgTMax = avgTmax;
        this.tMaxMax = tMaxMax;
        this.tMaxMin = tMaxMin;
        this.avgTMin = avgTmin;
        this.tMinMax = tMinMax;
        this.tMinMin = tMinMin;
        this.aMaxMax = aMaxMax;
        this.aMaxMin = aMaxMin;
        this.aMinMax = aMinMax;
        this.aMinMin = aMinMin;
    }

    public DatosTeruel() {
    }

    public void calcularMaxMax(Float t){
        if (t != null){
            tMaxMax = Math.max(tMaxMax, t);
        }
    }

    public void calcularMaxMin(Float t){
        if (t != null){
            tMaxMin= Math.min(tMaxMin, t);
        }
    }

    public void calcularMinMax(Float t){
        if (t != null){
            tMinMax= Math.max(tMinMax, t);
        }
    }

    public void calcularMinMin(Float t){
        if (t != null){
            tMinMin= Math.min(tMinMin, t);
        }
    }

    public void calcularAvgMax(Float t){
        if (t != null){
            avgTMax = (avgTMax+t)/2;
        }
    }

    public void calcularAvgMin(Float t){
        if (t != null){
            avgTMin = (avgTMin+t)/2;
        }
    }
}
