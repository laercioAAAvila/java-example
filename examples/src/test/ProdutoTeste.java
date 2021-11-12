import com.thoughtworks.xstream.XStream;
import org.junit.Test;
import xstream.Produto;

import static org.junit.Assert.assertEquals;

public class ProdutoTeste {

    @Test
    public void deveGerarOXmlComONomePrecoEDescricaoAdequados(){
        String xmlEsperado = "<produto codigo=\"1588\">\n"+
                                "  <nome>geladeira</nome>\n"+
                                "  <preco>1000.0</preco>\n"+
                                "  <descrição>geladeira duas portas</descrição>\n"+
                            "</produto>";


                Produto geladeira = new Produto(1588,"geladeira", 1000.0,"geladeira duas portas");
        XStream xStream = new XStream();
        xStream.alias("produto", Produto.class);
        xStream.aliasField("descrição",Produto.class,"descricao");
        xStream.useAttributeFor(Produto.class, "codigo");
        String xmlGerado = xStream.toXML(geladeira);

        assertEquals(xmlEsperado,xmlGerado);

    }
}
