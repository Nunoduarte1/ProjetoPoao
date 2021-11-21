//!! onde e que se ve se o desconto esta valido? na class venda quando estou a calcular o preco das compras? ou na class da promocao vejo se ela esta valida e se nao estiver envio o valor sem promocao?
// !!!tive de acrescentar a data atual a venda pq faz sentido saber quando foi vendido e da jeito para fazer validacao do desconto
// !! private boolean descontoValido(Promocoes promocao) {//!!!!! este metodo nao está criado, vai depender de como metemos as datas (na class venda)
//!!! se calhar fazia mais sentido ter logo o peso nos produtos em vez da dimensao porque assim bastava usar isso nas vendas, contudo ao usar a dimensao estamos a mostrar que percebemos o conceito de polimorfismo e desempacotar objetos (tambem o poderiamos fazer com o peso)
// alteracoes no uml na parte dos clientes, nos atributos das vendas no tipo de dados dos precos unitarios, nos metodos necessarios nas vendas e nas promocoes
import java.util.ArrayList;

public class GestorDeCompras {
    private ArrayList<Venda> vendas;
    private ArrayList<Cliente> clientes;
    private ArrayList<Produtos>produtos;
    private String dataAtual;

  

    public static void main(String[] args) {
        GestorDeCompras gc = new GestorDeCompras();
        gc.start();
    }

    public GestorDeCompras() {
        vendas = new ArrayList<>();
        clientes = new ArrayList<>();
        produtos=new ArrayList<>();
        setDataAtual(dataAtual);//criar a funcao que vai alterar esta data atual
    }

    public void start() {
        System.out.println("-- START --");


        System.out.println("-- FINISH --");
    }
    
    
    
    public String getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(String dataAtual) {
        this.dataAtual = dataAtual;
    }
}
