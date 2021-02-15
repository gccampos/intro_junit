package carrinho;

import org.junit.jupiter.api.*;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {

    private Carrinho carrinho;

    @BeforeEach
    public void inicializa() {
        var produto1 = new Produto("cheiro verde", 10.0);
        var produto2 = new Produto("coquinha geladinha", 5.0);
        carrinho = new Carrinho();
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
    }

    @DisplayName("Testa busca de item por nome")
    @Test
    public void testeGetProdutoByNome() throws ProdutoNaoEncontradoException {
        String nome = "cheiro verde";
        Assertions.assertEquals(carrinho.getProdutoByNome("cheiro verde").getNome(), nome);
    }

    @DisplayName("Testa valor total do carrinho")
    @Test
    public void testGetValorTotal() {
        double valorTotal = 15.0;
        Assertions.assertEquals(carrinho.getValorTotal(), valorTotal);
    }

    @DisplayName("Testa adição de produtos no carrinho")
    @Test
    public void testAddProduto() throws ProdutoNaoEncontradoException {
        var produto = new Produto("guaraná", 4.0);
        var carrinho = new Carrinho();
        carrinho.addItem(produto);
        Assertions.assertEquals(carrinho.getProdutoByNome("guaraná"), produto);
    }

    @DisplayName("Testa quantidade de produtos no carrinho")
    @Test
    public void testGetQntdItems() {
        int qntd = 2;
        Assertions.assertEquals(carrinho.getQtdeItems(), qntd);
    }

    @DisplayName("Testa remoção de produtos no carrinho")
    @Test
    public void testRemoveItem() throws ProdutoNaoEncontradoException {
        var produto = new Produto("guaraná", 4.0);
        var carrinho = new Carrinho();
        carrinho.addItem(produto);
        Assertions.assertTrue(carrinho.removeItem(produto));
    }

    @DisplayName("Testa esvaziamento de carrinho")
    @Test
    public void testeEsvazia() {
        carrinho.esvazia();
        Assertions.assertEquals( carrinho.getQtdeItems(),0);
    }

    @AfterEach
    public void finaliza() {
        System.out.println("Teste executado");
    }

    @AfterAll
    public static void finalizaTodos() {
        System.out.println("Todos os testes foram executados");
    }


}
