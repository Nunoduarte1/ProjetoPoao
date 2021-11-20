import java.util.ArrayList;

public class GestorDeCompras {
    private ArrayList<Venda> vendas;
    private ArrayList<Cliente> clientes;
    private ArrayList<Produto>produtos;

    public static void main(String[] args) {
        GestorDeCompras gc = new GestorDeCompras();
        gc.start();
    }

    public GestorDeCompras() {
        vendas = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void start() {
        System.out.println("-- START --");


        System.out.println("-- FINISH --");
    }
}
