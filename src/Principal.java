import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Digite o CEP para o qual você quer o endereço: ");
        Scanner leitura = new Scanner(System.in);
        ConsultaCep consultaCep = new ConsultaCep();
        var cep = leitura.nextLine();

        try {
            Endereco novoEndereco = consultaCep.buscaeEndereco(cep);
            System.out.println(novoEndereco);
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.geraJson(novoEndereco);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }



    }
}
