public class Rota {
    String codigo;
    String tipo;
    String origem;
    String destino;
    Rota prox;
    Rota ant;

    public Rota(String codigo, String tipo, String origem, String destino) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.origem = origem;
        this.destino = destino;
    }
}
