package tv;

import java.util.ArrayList;


class Pessoa {
    String nome;
    String nacionalidade;

    public String toString() {
        return nome + " (" + nacionalidade + ")";
    }

    Pessoa(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }
}

class ProgramaTV {
    private static int proximoCodigo = 1;
    protected int codigo;
    protected String nome;
    protected ArrayList<Pessoa> artistas = new ArrayList<>();
    protected Pessoa diretor;
    protected String categoria;

    ProgramaTV(String nome, String categoria) {
        this.codigo = proximoCodigo++;
        this.nome = nome;
        this.categoria = categoria;
    }

    void setDiretor(Pessoa diretor) {
        this.diretor = diretor;
    }

    void setArtistas(Pessoa artista) {
        artistas.add(artista);
    }

    public String toString() {
        StringBuilder programa = new StringBuilder();
        programa.append(codigo).append("-").append(nome).append(" (").append(categoria).append(")\n");
        programa.append("Diretor : ").append(diretor).append("\n");
        programa.append("Artistas : \n");
        for (Pessoa artista : artistas) {
            programa.append(artista).append("\n");
        }
        return programa.toString();
    }
}

class Serie extends ProgramaTV {
    private int temporadas;
    private int episodios;

    Serie(String nome, String categoria, int temporadas, int episodios) {
        super(nome, categoria);
        this.temporadas = temporadas;
        this.episodios = episodios;
    }

    public String toString() {
        return super.toString() + "Temporadas: " + temporadas + ", Episódios: " + episodios + "\n";
    }
}

public class Main {

	
	public static void main(String[] args) {
        ArrayList<ProgramaTV> programas = new ArrayList<>();

        ProgramaTV p = new ProgramaTV("O outro lado do paraíso", "Novela");
        p.setDiretor(new Pessoa("Diretor 1", "Brasileiro"));
        p.setArtistas(new Pessoa("Artista 1", "Brasileiro"));
        p.setArtistas(new Pessoa("Artista 2", "Brasileiro"));
        programas.add(p);

        p = new ProgramaTV("Orgulho e Paixão", "Novela");
        p.setDiretor(new Pessoa("Diretor 2", "Brasileiro"));
        p.setArtistas(new Pessoa("Artista 3", "Brasileiro"));
        p.setArtistas(new Pessoa("Artista 4", "Brasileiro"));
        programas.add(p);

        p = new ProgramaTV("Marley e eu", "Filme");
        p.setDiretor(new Pessoa("Diretor 3", "Brasileiro"));
        p.setArtistas(new Pessoa("Artista 5", "Brasileiro"));
        p.setArtistas(new Pessoa("Artista 6", "Brasileiro"));
        programas.add(p);

        p = new Serie("Friends", "Série", 10, 236);
        p.setDiretor(new Pessoa("Diretor 4", "Americano"));
        p.setArtistas(new Pessoa("Artista 7", "Americano"));
        p.setArtistas(new Pessoa("Artista 8", "Americano"));
        programas.add(p);

        for (ProgramaTV programa : programas) {
            System.out.println(programa);
        }
    }
}
