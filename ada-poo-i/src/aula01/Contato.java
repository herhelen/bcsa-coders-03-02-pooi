package aula01;

public class Contato {

    /*
    * - Modele uma classe CONTATO com os devidos atributos e os seguintes métodos:
    - ligar()
    - detalhar()
    - verNumero()
    * */
    String nome;
    String ddi;
    String ddd;
    String numero;
    String email;

    public void ligar() {
        System.out.println("Ligando para " + this.nome + " no número " + verNumero());
    }

    public void detalhar() {
        System.out.printf("Nome: %s%n", this.nome);
        System.out.printf("Número: %s%n", verNumero());
        System.out.printf("E-mail: %s%n", this.email);
    }

    public String verNumero() {
        return String.format("+%s %s %s", this.ddi, this.ddd, this.numero);
    }

    public boolean equals(Contato outro) {
        return
            this.nome.equals(outro.nome) &&
            this.verNumero().equals(outro.verNumero());
    }
}
