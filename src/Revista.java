public class Revista extends Material{
    private Integer numero;

    public Revista(String titulo, String autor, Integer numero) {
        super(titulo, autor);
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "---------------------------\n" +
            "Título: " + getTitulo() + "\n" +
            "Autor: " + getAutor() + "\n" +
            "Número: " + numero + "\n";
    }
}
