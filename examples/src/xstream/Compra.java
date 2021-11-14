package xstream;

import java.util.*;

public class Compra {

    private int id;
    private List<Produto> produtoList = new ArrayList<>();

    public Compra(int id, List<Produto> produtoList) {
        this.id = id;
        this.produtoList = produtoList;
    }
}
