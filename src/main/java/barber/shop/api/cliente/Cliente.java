package barber.shop.api.cliente;


import barber.shop.api.controller.DadosAtualizacaoClientes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cliente")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private boolean ativo;
    public Cliente(DadosCadastroCliente dados1) {
        this.ativo = true;
        this.nome = dados1.nome();
        this.email = dados1.email();
        this.telefone = dados1.telefone();
        this.cpf = dados1.cpf();
    }

    public void AtualizarInformacoes(DadosAtualizacaoClientes dados1) {
        if (dados1.nome() != null) {
            this.nome = dados1.nome();
        }
        if (dados1.telefone() != null) {
            this.telefone = dados1.telefone();
        }
    }

    public void excluir1() {
        this.ativo = false;
    }
}