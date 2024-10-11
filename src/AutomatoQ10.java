import java.util.ArrayList;
import java.util.List;

public class AutomatoQ10 {

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

        String cadeia = "00111";
        int cont0 = 0;
        int cont1 = 0;
        for(int i = 0; i < cadeia.length(); i++){

            char caractereAtual = cadeia.charAt(i);
            if (caractereAtual == '0'){
                cont0 += 1;
            } else if (caractereAtual == '1'){
                cont1 += 1;
            }



        }

        if (cont0 > cont1){
            estadoAtual = "q1";
        } else{
            estadoAtual = "q0";
        }

        if (estadoAtual == "q1"){
            System.out.println("Cadeia aceita!");
        } else{
            System.out.println("Cadeia rejeitada!");
        }
    }
}
