//string que contem enunciado
public class Alternativa {

    public char alternativa;
    public String enunciado;

    public  Alternativa(char alternativa, String enunciado) {
        this.alternativa = alternativa;
        this.enunciado = enunciado;
    }

    public void alterarEnunciado(String enunciado){
        this.enunciado = enunciado;
    }

    public void alterarAlternativa(char alternativa){
        this.alternativa = alternativa;
    }

}
