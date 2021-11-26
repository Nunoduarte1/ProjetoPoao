/**
 * object type Data has a day a month and a year if any of this numbers doesn't
 * make sense(for exemple the day number is greater then 31) will be store 0
 *
 * 
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
    public void setMes(int mes) throws Exception {
        if (mes > 0 && mes <= 12) {
            this.mes = mes;
        } else {//if the month is a invalid number will be store 0 in atribute month   
            throw new Exception("valor de mes invalido");
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
    
     /**
     * 
     * ve se a data d esta entre a data antes e a data depois
     *
     * @param d object type Data, date to check
     * @param antes object type Data,data que antecede
     * @param depois object type Data, data que sucede
     * @return true if the date D is in between the devolution and the request
     * date
     */
    public boolean checkData(Data d, Data antes, Data depois) {// esta func nao pertencia mas penso que possa dar jeito foi de um dos meus trabalhos antigos
        int dia = d.getDia();
        int mes = d.getMes();//values from date d
        int ano = d.getAno();

        int diar = antes.getDia();
        int mesr = antes.getMes();//values from request date
        int anor = antes.getAno();

        int diad = depois.getDia();
        int mesd = depois.getMes();//values from devolution date
        int anod = depois.getAno();

//check if the date D is in between the request date and the  devolution date if not return false
        if (ano < anor || ano > anod) {
            return false;
        } else {
            if (ano == anor) {
                if (mes < mesr) {
                    return false;
                } else if (mes == mesr) {
                    if (dia < diar) {
                        return false;
                    }
                }
            }
            if (ano == anod) {
                if (mes > mesd) {
                    return false;
                } else if (mes == mesd) {
                    if (dia > diad) {
                        return false;
                    }
                }
            }
        }

        return true;//date d is between the antes date and the depois date
    }

    @Override
    public String toString() {
        return "Data{" + "dia=" + dia + ", mes=" + mes + ", ano=" + ano + '}';
    }
    
    
    
}
