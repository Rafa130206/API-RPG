package br.com.rpg.APICampanha.domain.itemAmaldicoado;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DadosListagemItemAmaldicoado(Long id, String nome, Elemento elemento, String descricao, boolean unico, boolean penalidadeCustomizada, String descricaoPenalidadeCustomizada) {

    public DadosListagemItemAmaldicoado(ItemAmaldicoado itemAmaldicoado) {
        this(
                itemAmaldicoado.getId(),
                itemAmaldicoado.getNome(),
                itemAmaldicoado.getElemento(),
                itemAmaldicoado.getDescricao(),
                itemAmaldicoado.isUnico() ? true : null,
                itemAmaldicoado.isPenalidadeCustomizada() ? true : null,
                itemAmaldicoado.isPenalidadeCustomizada() && itemAmaldicoado.getDescricaoPenalidadeCustomizada() != null && !itemAmaldicoado.getDescricaoPenalidadeCustomizada().isBlank()
                        ? itemAmaldicoado.getDescricaoPenalidadeCustomizada()
                        : null
        );
    }

}
