public abstract class Material {
    private String titulo;
    private String autor;

    public Material(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "\nMaterial Encontrado:\n" +
            "---------------------------\n" +
            "Título: " + titulo + "\n" +
            "Autor: " + autor + "\n";
    }
}
