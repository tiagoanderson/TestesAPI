package dataFactory;

import pojo.ComponentePojo;
import pojo.ProdutoPojo;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDataFactory {

    public static ProdutoPojo criarprodutoValor(double valor){

        ProdutoPojo produto = new ProdutoPojo();
        produto.setProdutoNome("Nintendo");
        produto.setProdutoValor(valor);
        List<String> cores = new ArrayList<>();
        cores.add("Preto");
        cores.add("Branco");
        produto.setProdutoCores(cores);
        List<ComponentePojo> componente = new ArrayList<>();
        ComponentePojo componentes = new ComponentePojo();
        componentes.setComponenteNome("Controle");
        componentes.setComponenteQuantidade(2);
        componente.add(componentes);
        ComponentePojo segundoComponentes = new ComponentePojo();
        segundoComponentes.setComponenteNome("Controle x");
        segundoComponentes.setComponenteQuantidade(10);
        componente.add(segundoComponentes);
        produto.setComponentes(componente);

        return produto;


    }
}
