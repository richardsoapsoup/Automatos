import java.util.ArrayList;

import java.util.List;

public class AutomatoQ5 {

    public static void main(String[] args) {
        List<Integer> alfabeto = new ArrayList<>();
        alfabeto.add(0);
        alfabeto.add(1);

        List<String> estados = new ArrayList<>();

        estados.add("q0");
        estados.add("q1");

        String estadoInicial = "q0";
        String estadoAtual = estadoInicial;

        List<String> estadosFinais = new ArrayList<>();
        estadosFinais.add("q1");

        String cadeia = " ";

        for(int i = 0; i < cadeia.length(); i++){

            if (estadoAtual == "q0" && cadeia.charAt(i) == '1' || cadeia.charAt(i) == '0'){
                estadoAtual = "q0";
                break;

            } else if(estadoAtual == "q0" && cadeia.charAt(i) == ' '){
                estadoAtual = "q1";

            }


        }

        if (estadoAtual == "q1"){
            System.out.println("Cadeia aceita!");
        } else{
            System.out.println("Cadeia rejeitada!");
        }
    }
}