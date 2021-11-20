public class Cliente {
    private String nome;
    private String morada;
    private String email;
    private String telefone;
    private String dataDeNascimento;
    private boolean clienteFrequente;

    public Cliente(String nome, String morada, String email, String telefone, String dataDeNascimento, boolean clienteFrequente) {
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.telefone = telefone;
        this.dataDeNascimento = dataDeNascimento;
        this.clienteFrequente = clienteFrequente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public boolean isClienteFrequente() {
        return clienteFrequente;
    }

    public void setClienteFrequente(boolean clienteFrequente) {
        this.clienteFrequente = clienteFrequente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataDeNascimento='" + dataDeNascimento + '\'' +
                ", clienteFrequente=" + clienteFrequente +
                '}';
    }
}
