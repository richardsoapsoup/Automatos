import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Estado q2 = new Estado("q2");

        Set<Estado> estadosAFND = Set.of(q0, q1, q2);


        Set<Character> alfabeto = Set.of('0', '1');


        Estado estadoInicialAFND = q0;


        Set<Estado> estadosFinaisAFND = Set.of(q2);


        AFND afnd = new AFND(estadosAFND, alfabeto, estadoInicialAFND, estadosFinaisAFND);


        afnd.definirTransicao(q0, '0', Set.of(q0, q1));
        afnd.definirTransicao(q0, '1', Set.of(q0));
        afnd.definirTransicao(q1, '0', Set.of(q2));
        afnd.definirTransicao(q1, '1', Set.of(q2));
        afnd.definirTransicao(q2, '0', Set.of(q2));
        afnd.definirTransicao(q2, '1', Set.of(q2));


        ConversorAFNDparaAFD conversor = new ConversorAFNDparaAFD(afnd);
        conversor.converter();
    }
}
