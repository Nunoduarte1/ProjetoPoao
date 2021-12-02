/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.InputMismatchException;

/**
 * object type Data has a day a month and a year if any of this numbers doesn't
 * make sense(for exemple the day number is greater then 31) will be store 0
 *
 * @author emanuel
 */
public class Data {

    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) throws Exception {
        setDia(dia);
        setMes(mes);
        setAno(ano);
    }

    /**
     * get dia from object type Data
     *
     * @return integer dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * get mes from object type Data
     *
     * @return integer mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * get ano from object type Data
     *
     * @return integer ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * set dia of objetct Data with value integer dia or if the value doesn't
     * maix sense(ex greater then 31 or negative) will store 0 in dia
     *
     * @param dia interger value of the day
     */
    public void setDia(int dia) {
        if (dia > 0 && dia <= 31) {
            this.dia = dia;
        } else {//if the day is a invalid number will be store 0 in atribute day
            System.out.println("dia invalido");
            this.dia = 0;
        }
    }

    /**
     * set mes of objetct Data with value integer mes or if the value doesn't
     * maix sense(ex greater then 12 or negative) will store 0 in mes
     *
     * @param mes interger value of the month
     */
    public void setMes(int mes) {
        if (mes > 0 && mes <= 12) {
            this.mes = mes;
        } else {//if the month is a invalid number will be store 0 in atribute month
            throw new InputMismatchException("valor de mes invalido");
        }
    }

    /**
     * set ano of objetct Data with value integer ano or if the value doesn't
     * maix sense(ex less then 1990) will store 0 in ano
     *
     * @param ano interger value of the year
     */
    public void setAno(int ano) {
        if (ano > 1990) {
            this.ano = ano;
        } else {//if the year is a invalid number will be store 0 in atribute year
            System.out.println("ano invalido");
            this.ano = 0;
        }
    }


    @Override
    public String toString() {
        return "Data{"+ dia +","+ mes +"," + ano + '}';
    }

    /**
     * check if date D is between the request date and the devolution date
     *
     * @param d object type Data, date to check
     * @param devolucao object type Data,devolution date
     * @param requesicao object type Data, request date
     * @return true if the date D is in between the devolution and the request
     * date
     */
    public boolean checkData(Data d, Data devolucao, Data requesicao) {// esta func nao pertencia mas penso que possa dar jeito foi de um dos meus trabalhos antigos
        int dia = d.getDia();
        int mes = d.getMes();//values from date d
        int ano = d.getAno();

        int diar = requesicao.getDia();
        int mesr = requesicao.getMes();//values from request date
        int anor = requesicao.getAno();

        int diad = devolucao.getDia();
        int mesd = devolucao.getMes();//values from devolution date
        int anod = devolucao.getAno();

//check if the date D is in between the request date and the  devolution date if not return false
        if (ano < anor || ano > anod) {
            System.out.println("1");
            return false;
        } else {
            if (ano == anor) {
                if (mes < mesr) {
                    System.out.println("2");
                    return false;
                } else if (mes == mesr) {
                    if (dia < diar) {
                        System.out.println("3");
                        return false;
                    }
                }
            }
            if (ano == anod) {
                if (mes > mesd) {
                    System.out.println("4");
                    return false;
                } else if (mes == mesd) {
                    if (dia > diad) {
                        System.out.println("5");
                        return false;
                    }
                }
            }
        }

        return true;//date d is between the request date and the devolution date
    }
}