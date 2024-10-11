import java.util.*;

public class ConversorAFNDparaAFD {

    private AFND afnd;

    public ConversorAFNDparaAFD(AFND afnd) {
        this.afnd = afnd;
    }

    public void converter() {

        Set<Set<Estado>> estadosAFD = new HashSet<>();

        Map<Set<Estado>, Map<Character, Set<Estado>>> funcaoDeTransicaoAFD = new HashMap<>();


        Set<Estado> estadoInicialAFD = new HashSet<>();
        estadoInicialAFD.add(afnd.getEstadoInicial());


        Queue<Set<Estado>> fila = new LinkedList<>();
        fila.add(estadoInicialAFD);
        estadosAFD.add(estadoInicialAFD);

        while (!fila.isEmpty()) {
            Set<Estado> estadoAtualAFD = fila.poll();
            funcaoDeTransicaoAFD.put(estadoAtualAFD, new HashMap<>());


            for (Character simbolo : afnd.getAlfabeto()) {
                Set<Estado> novoEstadoAFD = new HashSet<>();


                for (Estado estado : estadoAtualAFD) {

                    Set<Estado> estadosDestino = afnd.getFuncaoDeTransicao().get(estado).get(simbolo);
                    if (estadosDestino != null) {
                        novoEstadoAFD.addAll(estadosDestino);
                    }
                }


                if (!estadosAFD.contains(novoEstadoAFD) && !novoEstadoAFD.isEmpty()) {
                    fila.add(novoEstadoAFD);
                    estadosAFD.add(novoEstadoAFD);
                }


                funcaoDeTransicaoAFD.get(estadoAtualAFD).put(simbolo, novoEstadoAFD);
            }
        }


        System.out.println("Estados do AFD:");
        for (Set<Estado> estado : estadosAFD) {
            System.out.println(estado);
        }

        System.out.println("\nFunção de Transição do AFD:");
        for (Map.Entry<Set<Estado>, Map<Character, Set<Estado>>> entrada : funcaoDeTransicaoAFD.entrySet()) {
            Set<Estado> estadoOrigemAFD = entrada.getKey();
            for (Map.Entry<Character, Set<Estado>> transicao : entrada.getValue().entrySet()) {
                Character simbolo = transicao.getKey();
                Set<Estado> estadoDestinoAFD = transicao.getValue();
                System.out.println(estadoOrigemAFD + " -- " + simbolo + " --> " + estadoDestinoAFD);
            }
        }
    }
}
