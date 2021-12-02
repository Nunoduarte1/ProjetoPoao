import java.io.*;
import java.util.*;
import java.io.FileReader;

public class GestorDeCompras {
    private ArrayList<Venda> vendas;
    private ArrayList<Cliente> clientes;
    private ArrayList<Produtos>produtos;
    private ArrayList<Promocoes>promocoes;
    private Cliente cliente;

    public static void main(String[] args) {
        GestorDeCompras gc = new GestorDeCompras();
        gc.start();
    }

    public GestorDeCompras() {
        vendas = new ArrayList<>();
        clientes = new ArrayList<>();
        produtos = new ArrayList<>();
        promocoes = new ArrayList<>();
    }

    public void start() {
        System.out.println("-- START --");

        Data data = null;
        try {
            data = new Data(18,11,2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);

        int escolha=0; //in the menu the -1 represents the exit option;

        //inicialização
        inicializaDados();

        while (!login()){
            System.out.println();
        }

        while (escolha!=-1){

            System.out.println("Data atual:"+data+"\n==============================\n1- Altera Data\n2- Realizar Compra\n3- Consulta Compras Realizadas\n-1 Exit\n==============================\n");
            //makes sure that the input is an input number
            while(!sc.hasNextInt()) {
                sc.next();
                System.out.println("Data atual:"+data+"\n==============================\n1- Altera Data\n2- Realizar Compra\n3- Consulta Compras Realizadas\n-1 Exit\n==============================\n");

            }

            escolha = sc.nextInt();
            //menu
            switch (escolha){
                case 1:
                    alteraData(data);
                    break;
                case 2:
                    realizaCompra(data);
                    break;
                case 3:
                    consultaCompras();
                    break;
                case -1:
                    System.out.println("*Saindo*");
                    guardaDados();
                    return;
                default:
                    System.out.println("\nNúmero inválido\n");
                    break;
            }
        }
    }

    private void guardaDados() {

    }

    private void inicializaDados() {
        File ficheiro = new File("clientesFreq.object");
        if (ficheiro.exists()) {
            //se a expressão acima for verdadeira , carregamos a informação dos ficheiros objectos.
        }
        else {
            //se a expressão acima for falsa , carregamos a informação dos ficheiros texto.

            try {
                File ficheirocftxt = new File("clientesFrequentes.txt");
                BufferedReader cftxt = new BufferedReader(new FileReader(ficheirocftxt));
                String st;

                while ((st = cftxt.readLine()) != null) {
                    String[] array =st.split(";");
                    ClienteFrequente a = new ClienteFrequente(array[1],array[2],array[0],array[3],array[4]);
                    clientes.add(a);
                    System.out.println("Cliente frequente "+array[1]+" adicionado com sucesso!");
                    // Print the string
                }
                System.out.println("\n");
                cftxt.close();
            } catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("IOException");
                e.printStackTrace();
            }


            try {
                File ficheirocrtxt = new File("clientesRegulares.txt");
                BufferedReader crtxt = new BufferedReader(new FileReader(ficheirocrtxt));
                String st;
                while ((st = crtxt.readLine()) != null) {
                    String[] array =st.split(";");
                    ClienteNormal a = new ClienteNormal(array[1],array[2],array[0],array[3],array[4]);
                    clientes.add(a);
                    System.out.println("Cliente Normal "+array[1]+" adicionado com sucesso!");

                }
                System.out.println("\n");
                crtxt.close();
            } catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("IOException");
                e.printStackTrace();
            }


            try {
                int identifica=0;
                File ficheiropromotxt = new File("promocoes.txt");
                BufferedReader promotxt = new BufferedReader(new FileReader(ficheiropromotxt));
                String st;
                while ((st = promotxt.readLine()) != null) {
                    String[] array =st.split(";");
                    identifica = Integer.parseInt(array[0])/10000;
                    String[] dataini=array[1].split("/");
                    String[] datafim=array[2].split("/");

                    Data inicio = new Data(Integer.parseInt(dataini[0]),Integer.parseInt(dataini[1]),Integer.parseInt(dataini[2]));
                    Data fim = new Data(Integer.parseInt(datafim[0]),Integer.parseInt(datafim[1]),Integer.parseInt(datafim[2]));


                    if (identifica ==1){ //paguemenos
                        PagueMenos pg = new PagueMenos(Integer.parseInt(array[0]),inicio,fim);
                        promocoes.add(pg);
                        System.out.println("Promocao "+array[0]+" adicionada com sucesso!");
                    }
                    else if(identifica==2){//paguetres
                        PagueTres pt = new PagueTres(Integer.parseInt(array[0]),inicio,fim);
                        promocoes.add(pt);
                        System.out.println("Promocao "+array[0]+" adicionada com sucesso!");
                    }
                }
                promotxt.close();
            }catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("IOException");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("\n");

            try {
                int identifica =0;
                File ficheiroptxt = new File("produtos.txt");
                BufferedReader ptxt = new BufferedReader(new FileReader(ficheiroptxt));
                String st;
                while ((st = ptxt.readLine()) != null) {
                    System.out.println(st +"isto foi uma linha xd");
                    String[] array =st.split(";");
                    identifica = Integer.parseInt(array[0])/10000;
                    String [] array1;
                    if (array[4].equals(" ")){
                        array1= null;
                    }
                    else{
                        array1=array[4].split(",");
                    }

                    ArrayList<Promocoes> promocoesMobilia= new ArrayList<>();
                    ArrayList<Promocoes> promocoesLimpeza= new ArrayList<>();
                    ArrayList<Promocoes> promocoesComida= new ArrayList<>();


                    switch (identifica){
                        case 1:
                            //int identificador, String nome, float precoUnitario, int stock,Arraylist promocao,int peso, int dimensao
                            if (array1!=null) {
                                for (String s : array1) {
                                    System.out.println(s+"String");
                                    for (Promocoes p : promocoes) {
                                        System.out.println(p+"promocoes");
                                        System.out.println( "iden de p"+p.getIdentifica()+" s->"+Integer.parseInt(s));
                                        if (p.getIdentifica() / 10000 == Integer.parseInt(s)) {
                                            System.out.println("movl");
                                            promocoesMobilia.add(p);
                                        }
                                    }
                                }
                            }
                            else {
                                promocoesMobilia=null;
                            }
                            Mobiliario a = new Mobiliario(Integer.parseInt(array[0]),array[1],Float.parseFloat(array[2]),Integer.parseInt(array[3]),promocoesMobilia,Integer.parseInt(array[5]),Integer.parseInt(array[6]));
                            produtos.add(a);
                            System.out.println("Produto "+array[1]+" adicionada com sucesso!");
                            System.out.println(a);
                            break;

                        case 2:
                            if (array1!=null) {
                                for (String s : array1) {
                                    for (Promocoes p : promocoes) {
                                        if (p.getIdentifica() / 10000 == Integer.parseInt(s)) {
                                            promocoesLimpeza.add(p);
                                        }
                                    }
                                }
                            }
                            else{
                                promocoesLimpeza = null;
                            }
                            Limpeza b = new Limpeza(Integer.parseInt(array[0]),Integer.parseInt(array[1]),array[2],Float.parseFloat(array[3]),promocoesLimpeza,Integer.parseInt(array[5]));
                            produtos.add(b);
                            System.out.println("Produto "+array[1]+" adicionada com sucesso!");
                            System.out.println(b);
                            break;

                        case 3:
                            if (array1!=null) {
                                for (String s : array1) {
                                    for (Promocoes p : promocoes) {
                                        if (p.getIdentifica() / 10000 == Integer.parseInt(s)) {
                                            promocoesComida.add(p);
                                        }
                                    }
                                }
                            }
                            else {
                                promocoesComida = null;
                            }
                            Alimentares c = new Alimentares(Integer.parseInt(array[0]),Integer.parseInt(array[1]),Integer.parseInt(array[2]),array[3],promocoesComida,Float.parseFloat(array[5]),Integer.parseInt(array[6]));
                            produtos.add(c);
                            System.out.println("Produto "+array[3]+" adicionada com sucesso!");
                            System.out.println(c);
                            break;
                    }
                }
                ptxt.close();
            } catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("IOException");
                e.printStackTrace();
            }
            System.out.println("\n");
        }
    }

    public void alteraData(Data data){
        int dia=-1,mes=-1,ano=-1;

        Scanner sc = new Scanner(System.in);

        while(dia<1 || dia>31){
            try {
                System.out.println("Insere o dia:\n");
                dia=sc.nextInt();
                data.setDia(dia);
            }
            catch (InputMismatchException e){
                System.out.println("Input inválido");
                sc.nextLine();
            }
        }


        while(mes<1 || mes > 12){
            try {
                System.out.println("Insere o mes:\n");
                mes=sc.nextInt();
                data.setMes(mes);
            } catch (Exception e){
                System.out.println("Input inválido");
                sc.nextLine();
            }

        }

        while (ano ==-1){
            try {
                System.out.println("Insere o ano:\n");
                ano=sc.nextInt();
                data.setAno(ano);
            }
            catch (InputMismatchException e){
                System.out.println("Input inválido");
                sc.nextLine();
            }
        }



    }

    public void realizaCompra(Data data){
        //Display os produtos
        int continuidade=0;
        Venda v = new Venda(cliente, data);
        while(continuidade==0) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Produtos disponíveis:\n");
            int contador = -1;
            int escolha = -1;
            int quantidade = -1;
            for (Produtos p : produtos) {
                contador++;
                System.out.println(contador + "------>" + p + "\n");
            }

            System.out.println("Insira o produto que deseja:");
            while (escolha < 0 || escolha > contador) {
                try {
                    escolha = sc.nextInt();

                    if(escolha < 0 || escolha > contador){
                        System.out.println("O valor inserido é inválido");
                        System.out.println("Insira o produto que deseja:");
                    }
                } catch (InputMismatchException i) {
                    System.out.println("O valor inserido é inválido");
                    sc.nextLine();
                    System.out.println("Insira o produto que deseja:");
                }
            }
            System.out.println("Insira a quantidade que deseja:");
            while (quantidade < 0 || quantidade > produtos.get(escolha).getStock()) {
                try {
                    quantidade = sc.nextInt();
                    if (quantidade < 0 || quantidade > produtos.get(escolha).getStock()){
                        System.out.println("O valor inserido é inválido");
                        System.out.println("Insira a quantidade que deseja:");
                    }
                } catch (InputMismatchException i) {
                    System.out.println("O valor inserido é inválido");
                    sc.nextLine();
                    System.out.println("Insira a quantidade que deseja:");
                }
            }
            try {
                v.addToCarrinhoCompras(produtos.get(escolha), quantidade);
            } catch (InputMismatchException i) {
                System.out.println("Quantidade Inválida" + "\n" + i.getMessage());
            }
            System.out.println("Deseja continuar a compra?\nSim->0 Não->1");
            try{
                continuidade=sc.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Escolha inválida a compra será continuada");
            }
        }
        v.atualizaStock();
        System.out.println(v.calculaCustoFinal());
        vendas.add(v);
    }

    public void consultaCompras() {

        System.out.println("Compras:{");

        for (Venda v : vendas) {
            if (v.getCliente().equals(cliente)){
                System.out.println(v + ",");
            }
            System.out.println("}\n");
        }
    }


    public boolean login(){
        String email = "";
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Introduza o seu email:\n");
            email = sc.nextLine();
            for (Cliente c:clientes){
                if(c.getEmail().equals(email)){
                    System.out.println("Email encontrado!\n");
                    cliente=c;
                    return true;
                }
            }
            System.out.println("Email não encontrado!\n");
            return false;
        }
        catch(InputMismatchException e){
            login();
        }

        return true;
    }
}
