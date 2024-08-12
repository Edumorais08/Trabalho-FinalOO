package app;

public class Disciplina {

    //declaração dos atributos da classe disciplina
    String codigo,
            nome;
    int creditos,
        cargaHoraria;

    //criação dos construtores 
    public Disciplina() {
    }
    public Disciplina(String codigo, String nome, int cargaHoraria, int creditos) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria; 
        this.creditos = creditos;
    }
    
    //getters
    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public int getCreditos() {
        return creditos;
    }

    protected void finalize() throws Throwable {
		System.out.println("Destruindo objeto: " + this);
	}

    public String toString() {
        String resposta = "DISCIPLINA: " + nome + '\n';
        resposta += "CÓDIGO: " + codigo + '\n';
        resposta += "CARGA HORÁRIA: " + cargaHoraria + " Horas" + '\n';
        resposta += "CRÉDITOS: " + creditos + '\n';
        return resposta;
    }    
}
