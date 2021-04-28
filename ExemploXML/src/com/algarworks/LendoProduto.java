package com.algarworks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.algarworks.modelo.Produto;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class LendoProduto {

	public static void main(String[] args) throws FileNotFoundException {
		// Usar a bibliotexa XStream
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("produto", Produto.class);
		xstream.aliasAttribute(Produto.class, "codigo", "codigo");

		// Ler o xml
		Produto p = (Produto) xstream.fromXML(new FileInputStream("./produto2.xml"));
		System.out.println(p.getCodigo());
		System.out.println(p.getDescricao());
		System.out.println(p.getValor());

	}

}
