import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Notificacao {
    void enviar(String mensagem);
}

class NotificacaoEmail implements Notificacao {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando e-mail: " + mensagem);
    }
}

class NotificacaoSms implements Notificacao {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando SMS: " + mensagem);
    }
}

class NotificacaoWhatsApp implements Notificacao {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando WhatsApp: " + mensagem);
    }
}

class ServicoNotificacao {
    public void notificarCliente(Notificacao notificacao, String mensagem) {
        notificacao.enviar(mensagem);
    }
}

public class SistemaNotificacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServicoNotificacao servico = new ServicoNotificacao();

        List<Notificacao> listaNotificacoes = new ArrayList<>();
        listaNotificacoes.add(new NotificacaoEmail());
        listaNotificacoes.add(new NotificacaoSms());
        listaNotificacoes.add(new NotificacaoWhatsApp());

        System.out.println("Escolha o tipo de notificação:");
        System.out.println("1 - E-mail");
        System.out.println("2 - SMS");
        System.out.println("3 - WhatsApp");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao < 1 || opcao > 3) {
            System.out.println("Opção inválida!");
            scanner.close();
            return;
        }

        System.out.print("Digite a mensagem que será enviada: ");
        String mensagem = scanner.nextLine();

        Notificacao notificacaoSelecionada = listaNotificacoes.get(opcao - 1);
        servico.notificarCliente(notificacaoSelecionada, mensagem);

        scanner.close();
    }
}