package barber.shop.api.domain.barbeiro;

public record DadosListagemBarbeiro(Long id, String nome, String email, Especialidade especialidade) {

    public DadosListagemBarbeiro(Barbeiro barbeiro) {

        this(barbeiro.getId(), barbeiro.getNome(), barbeiro.getEmail(), barbeiro.getEspecialidade());

    }
}
