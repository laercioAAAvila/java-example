import com.thoughtworks.xstream.XStream;
import org.junit.Test;
import xstream.Compra;
import xstream.Produto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CompraTeste {

    @Test
    public void deveGerarCadaUmDosProdutosDeUmaCompra(){
        String xmlEsperado =
                                "<compra>\n"+
                                "  <id>15</id>\n"+
                                "  <produtos>\n"+
                                "    <produto codigo=\"1588\">\n"+
                                "      <nome>geladeira</nome>\n"+
                                "      <preço>1000.0</preço>\n"+
                                "      <descrição>geladeira duas portas</descrição>\n"+
                                "    </produto>\n"+
                                "    <produto codigo=\"1589\">\n"+
                                "      <nome>ferro de passar</nome>\n"+
                                "      <preço>100.0</preço>\n"+
                                "      <descrição>ferro com vaporizador</descrição>\n"+
                                "    </produto>\n"+
                                "  </produtos>\n"+
                                "</compra>";

        Produto geladeira = new Produto("geladeira", 1000.0,"geladeira duas portas",1588);
        Produto ferro = new Produto("ferro de passar", 100.0,"ferro com vaporizador",1589);

        List<Produto> produtos = new ArrayList<>();
        produtos.add(geladeira);
        produtos.add(ferro);

        Compra compra = new Compra(15, produtos);

        XStream xStream = new XStream();
        xStream.alias("produto", Produto.class);
        xStream.alias("compra", Compra.class);
        xStream.aliasField("descrição", Produto.class, "descricao");
        xStream.aliasField("preço", Produto.class, "preco");
        xStream.useAttributeFor(Produto.class, "codigo");

        String xmlGerado = xStream.toXML(compra);
        assertEquals(xmlEsperado, xmlGerado);
    }
}
