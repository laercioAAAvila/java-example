import com.thoughtworks.xstream.XStream;
import org.junit.Test;
import xstream.Produto;

import static org.junit.Assert.assertEquals;

public class ProdutoTeste {

    @Test
    public void deveGerarOXmlComONomePrecoEDescricaoAdequados(){
        String xmlEsperado = "<produto codigo=\"1588\">\n"+
                                "  <nome>geladeira</nome>\n"+
                                "  <preço>1000.0</preço>\n"+
                                "  <descrição>geladeira duas portas</descrição>\n"+
                            "</produto>";

        Produto geladeira = new Produto("geladeira", 1000.0,"geladeira duas portas",1588);

        XStream xStream = new XStream();
        xStream.alias("produto", Produto.class);
        xStream.aliasField("descrição",Produto.class,"descricao");
        xStream.aliasField("preço",Produto.class,"preco");
        xStream.useAttributeFor(Produto.class, "codigo");

        String xmlGerado = xStream.toXML(geladeira);
        assertEquals(xmlEsperado,xmlGerado);
    }
}
