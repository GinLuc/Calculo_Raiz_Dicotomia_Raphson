/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static java.lang.Math.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GianL and FelipeSdS
 */
public class Dicotomia {
    private static double x1;
    private static double x2 = 0;
    private static double fx1;
    private static double fx2;
    private static double pm;      //Variável P.M., aonde este é o Ponto Médio entre os dois valores escolhidos: (x1 + x2) / 2
    private static double fpm;
    private static double modulo;
    private static int interacao;
    private static double precisao;
 
    
    
    
    
//Construtor: Aqui ocorre a entrada dos valores necessários para serem usados nos cálculos
    public Dicotomia (double x1, int interacao, double precisao) {
        setX1(x1);
        setX2(0);
        setFx1(x1);
        setFx2(getX2());
        setPm(getX1(), getX2());
        setFpm(getPm());
        setInteracao(interacao);
        setModulo(getX1(), getX2());
        setPrecisao(precisao);
    }
    
    
    public Dicotomia(double x1, double x2) {
        setX1(x1);
        setX2(x2);
        setFx1(x1);
        setFx2(getX2());
        setPm(getX1(), getX2());
        setFpm(getPm());
        setModulo(getX1(), getX2());
    }
    
//Getters: Ocorrem o retorno dos valores inseridos nos Setters   
    public static double getX1() {
        return x1;
    }
    
    public static double getX2() {
        return x2;
    }
    
    public static double getFx1() {
        return fx1;
    }
    
    public static double getFx2() {
        return fx2;
    }
    
    public static double getPm() {
        return pm;
    }
    
    public static double getFpm() {
        return fpm;
    }
    
    public static double getModulo() {
        return modulo;
    }
    
    public static double getInteracao() {
        return interacao;
    }
    
    public static double getPrecisao() {
        return precisao;
    }
    
//Setters: ocorrem a inserção dos valores, obtidos através do Construtor
    public static void setX1(double x1) {
        Dicotomia.x1 = x1;
    }
    
    public static void setX2(double x2) {
        Dicotomia.x2 = x2;
    }
    
    public static void setFx1(double x1) {
        Dicotomia.fx1 = sqrt(x1);
    }
    
    public static void setFx2(double x2) {
        Dicotomia.fx2 = sqrt(x2);
    }
    
    public static void setPm(double x1, double x2) {
        Dicotomia.pm = (x1 + x2) / 2;
    }
    
    public static void setFpm(double pm) {
        Dicotomia.fpm = sqrt(pm);
    }
    
    public static void setModulo (double x1, double x2) {
        Dicotomia.modulo = abs(x1 - x2);
    }
    
    public static void setInteracao(int interacao) {
        Dicotomia.interacao = interacao;
    }
    
    public static void setPrecisao(double precisao) {
        Dicotomia.precisao = precisao;
    }
    
 //Método para troca de Valores com Relação ao Dicotomia, aonde caso o valor retornado por Fx1 seja negativo igualmente ao
 //Fpm, ele deve passar o Pm para o X1, enquanto o mesmo vale para Fx2 e X2.
    public static void passaValor(double x1, double x2, double fx1,double fx2, double fpm, double pm) {
        if(fpm < 0.0) {
            if (fx1 < 0)
                new Dicotomia(pm, x2);
            else if (fx2 < 0)
                new Dicotomia(x1, pm); 
        }
        else {
            if (fx1 >= 0)
                new Dicotomia(pm, x2);
            else if (fx2 >= 0)
                new Dicotomia(x1, pm);
        }
            
       
    }
    
    
    
    public static DefaultTableModel getTableModel() {
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("X1");
        modelo.addColumn("f(X1)");
        modelo.addColumn("X2");
        modelo.addColumn("f(X2)");
        modelo.addColumn("P.M.");       
        modelo.addColumn("f(P.M.)");       
        modelo.addColumn("|X1 - X2|");       
        int i=0 ;

        while (i <= getInteracao() || getModulo() != getPrecisao()) {
            String vlx1 = Double.toString(getX1());
            String vlx2 = Double.toString(getX2());
            String vlfx1 = Double.toString(getFx1());
            String vlfx2 = Double.toString(getFx2());
            String vlpm = Double.toString(getPm());
            String vlfpm = Double.toString(getFpm());
            String vlmodulo = Double.toString(getModulo());

            String[] s = {vlx1, vlfx1, vlx2, vlfx2, vlpm, vlfpm, vlmodulo};
            modelo.addRow(s);  
            passaValor(getX1(), getX2(), getFx1(), getFx2(), getFpm(), getPm());
            i++;
        }

        return modelo;
    }
    
}
