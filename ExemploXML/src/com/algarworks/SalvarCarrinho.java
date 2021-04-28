package com.algarworks;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.algarworks.modelo.Produto;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class SalvarCarrinho {

	public static void main(String[] args) throws FileNotFoundException {
		List<Produto> carrinho = new ArrayList<>(); 
		carrinho.add(new Produto (1L, "Sabonete", new BigDecimal("2.30")));
		carrinho.add(new Produto (2L, "Shampoo", new BigDecimal("8.20")));
		carrinho.add(new Produto (3L, "Cerveja", new BigDecimal("1.79")));
		

		XStream xstream = new XStream(new DomDriver());
		xstream.alias("produto", Produto.class);
		xstream.aliasAttribute(Produto.class, "codigo", "codigo");
		xstream.alias("codigo", List.class);
		
		OutputStream os = new FileOutputStream("./carrinho.xml");
		xstream.toXML(carrinho, os);
	}

}
