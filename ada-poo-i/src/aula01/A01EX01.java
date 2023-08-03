package aula01;

public class A01EX01 {

    public static Contato buscarContatoNaAgendaELigar(Agenda agenda, String nome) {
        System.out.println("----- Buscando "+ nome +" na agenda -----");
        Contato contatoEncontrado = agenda.buscar(nome);
        if(contatoEncontrado != null) {
            contatoEncontrado.detalhar();
            contatoEncontrado.ligar();
        } else {
            System.out.println("Contato não encontrado.");
        }
        
        return contatoEncontrado;
    }

    public static void main(String[] args) {

        System.out.println("----- Criando os contatos -----");
        Contato contato1 = new Contato();
        contato1.nome = "Maria";
        contato1.ddi = "55";
        contato1.ddd = "11";
        contato1.numero = "123456";
        contato1.email = "maria@email.com";

        Contato contato2 = new Contato();
        contato2.nome = "Paulo";
        contato2.ddi = "55";
        contato2.ddd = "11";
        contato2.numero = "987654";
        contato2.email = "paulo@email.com";

        Contato contato3 = new Contato();
        contato3.nome = "Paulina";
        contato3.ddi = "55";
        contato3.ddd = "21";
        contato3.numero = "999888";
        contato3.email = "paulina@email.com.br";

        Contato contato4 = new Contato();
        contato4.nome = "Mauro";
        contato4.ddi = "33";
        contato4.ddd = "";
        contato4.numero = "8989123";
        contato4.email = "mauro@email.com";

        System.out.println("----- Criando agenda e adicionando os contatos -----");
        Agenda agenda = new Agenda();
        agenda.contatos = new Contato[]{
                contato1,
                contato2,
                contato3,
                contato4
        };

        Contato contatoEncontrado = buscarContatoNaAgendaELigar(agenda, "Paulina");

        System.out.println("----- Removendo Paulina da agenda -----");
        agenda.deletar(contatoEncontrado);
        agenda.imprimir();

        buscarContatoNaAgendaELigar(agenda, "Paulina");
        buscarContatoNaAgendaELigar(agenda, "Mauro");
        
    }
}
