package com.aluracurso.screenmatch.modelos;

public class Titulo {
    private String nombre;
    private int fechaLanzamiento;
    private int duracionMinutos;
    private boolean incluidoEnPlan;
    private double sumaEvalucaciones;
    private int totalEvaluaciones;

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(int fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public double getSumaEvalucaciones() {
        return sumaEvalucaciones;
    }

    public void setSumaEvalucaciones(double sumaEvalucaciones) {
        this.sumaEvalucaciones = sumaEvalucaciones;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Año de lanzamiento: " + fechaLanzamiento);
        System.out.println("Duración en minutos: " + getDuracionMinutos());
        System.out.println("Incluido en el plan: " + (incluidoEnPlan ? "Sí" : "No"));
    }

    public void evalua(double nota){
        sumaEvalucaciones += nota;
        totalEvaluaciones++;
    }
    public double calculoMedia(){
        return sumaEvalucaciones / totalEvaluaciones;
    }
}
