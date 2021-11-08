/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apcompiladorpilaatributos;

/**
 *
 * @author SistemaInvestigacion
 */
public class NoTerminal {

    // Atributos

    private String nombre;
    private int direc;
    private double valor;
    private boolean relacional;
    private boolean valorLogico;

    // Métodos

    public NoTerminal() {

    }

    public NoTerminal(String nom, int val1, double val2) {
        nombre = nom;
        direc = val1;
        valor = val2;
        relacional = false;
        valorLogico = false;
    }

    public NoTerminal(String nom, int val1, double val2, boolean vl) {
        nombre = nom;
        direc = val1;
        valor = val2;
        valorLogico = vl;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDirec() {
        return (int) direc;
    }

    public double getValor() {
        return (double) valor;
    }

    public void setNombre(String nom) {

        nombre = nom;
    }

    public void setDirec(int val1) {
        direc = val1;
    }

    public void setValor(double val2) {
        valor = val2;
    }

    public void setRelacional(boolean rel) {
        relacional = rel;
    }

    public boolean getRelacional() {
        return relacional;
    }

    public boolean getValorLogico() {
        return valorLogico;
    }

    public void setValorLogico(boolean vl) {
        valorLogico = vl;
    }

    public String toString() {
        return "nombre: " + nombre + " valor: " + valor + " valor logico: " + valorLogico;
    }
}
