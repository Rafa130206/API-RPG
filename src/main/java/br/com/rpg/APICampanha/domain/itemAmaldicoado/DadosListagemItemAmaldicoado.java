package br.com.rpg.APICampanha.domain.itemAmaldicoado;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DadosListagemItemAmaldicoado(Long id, String nome, Elemento elemento, String descricao, Boolean unico, Boolean penalidadeCustomizada, String descricaoPenalidadeCustomizada) {

    public DadosListagemItemAmaldicoado(ItemAmaldicoado itemAmaldicoado) {
        this(
                itemAmaldicoado.getId(),
                itemAmaldicoado.getNome(),
                itemAmaldicoado.getElemento(),
                itemAmaldicoado.getDescricao(),
                itemAmaldicoado.getUnico() ? true : null,
                itemAmaldicoado.getPenalidadeCustomizada() ? true : null,
                itemAmaldicoado.getPenalidadeCustomizada() && itemAmaldicoado.getDescricaoPenalidadeCustomizada() != null && !itemAmaldicoado.getDescricaoPenalidadeCustomizada().isBlank()
                        ? itemAmaldicoado.getDescricaoPenalidadeCustomizada()
                        : null
        );
    }

}
