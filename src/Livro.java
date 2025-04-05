public class Livro extends Material{
    private String genero;

    public Livro(String titulo, String autor, String genero) {
        super(titulo, autor);
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "---------------------------\n" +
            "Título: " + getTitulo() + "\n" +
            "Autor: " + getAutor() + "\n" +
            "Gênero: " + genero + "\n";
    }
}
