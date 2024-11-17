package zona_fit_cliente;

import java.util.Objects;

public class Cliente {
    private int id;
    private String nome;
    private String apelido;
    private int membro;

    public Cliente(){}

    public Cliente(int id){
        this.id = id;
    }

    public Cliente(String nome, String apelido, int membro){
        this.apelido = apelido;
        this.nome = nome;
        this.membro = membro;
    }

    public Cliente(int id, String nome, String apelido, int membro){
        this(nome, apelido, membro);
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMembro() {
        return membro;
    }

    public void setMembro(int membro) {
        this.membro = membro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", membro=" + membro +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && membro == cliente.membro && Objects.equals(nome, cliente.nome) && Objects.equals(apelido, cliente.apelido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, apelido, membro);
    }
}
