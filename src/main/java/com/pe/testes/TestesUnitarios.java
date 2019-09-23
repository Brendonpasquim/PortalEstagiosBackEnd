package com.pe.testes;

import java.util.Properties;

import br.com.starmetal.database.postgresql.QueryMaker;
import br.com.starmetal.io.IOArquivo;
import br.com.starmetal.io.IOProperties;

public class TestesUnitarios {
	
	private static void TesteIO() {
		
		System.out.println(IOArquivo.CAMINHO_PROJETO_ATUAL);
		System.out.println(IOProperties.DEFAULT_PROPERTIES_FILE_PATH);
		System.out.println(IOProperties.DEFAULT_PROPERTIES_FOLDER_PATH);
		
		String sshPath = IOProperties.DEFAULT_PROPERTIES_FOLDER_PATH + IOArquivo.SEPARADOR_DE_DIRETORIO + "ssh.properties";
		System.out.println(sshPath);
		Properties pro = IOProperties.getProperties(sshPath);
		
		System.out.println(pro.getProperty("ssh.username"));
	}
	
	private static void TesteQueryMaker() {
        QueryMaker query = new QueryMaker();
        query.select("P.numero_ponto, P.endereco, P.tipo, P.codigo_linha, L.nome_linha, P.seq, L.apenas_cartao, ST_AsGeoJSON(P.geom, 15, 0) as geojson")
        	 .from("pontos_de_onibus P, linhas_de_onibus L")
        	 .where("P.codigo_linha = L.codigo_linha ORDER BY P.numero_ponto");
        
        query.printQuery();
        
        System.out.println();
        
		QueryMaker query2 = new QueryMaker();
		query2.select("A.seq", "A.numero_ponto", "A.codigo_linha", "ST_AsGeoJSON(geom, 15, 0) geojson")
			 .from("pontos_de_onibus A")
			 .where("(A.seq >= (SELECT MIN(seq) FROM pontos_de_onibus WHERE codigo_linha = A.codigo_linha AND numero_ponto = ':X' AND direcao = A.direcao) " + 
			 		"AND A.seq <= (SELECT MAX(seq) FROM pontos_de_onibus WHERE codigo_linha = A.codigo_linha AND numero_ponto = ':Y' AND direcao = A.direcao))")
			 .setParameter("X", 1)
			 .setParameter("Y", 2)
			 .where("A.codigo_linha", String.valueOf(147))
			 .orderBy("codigo_linha, seq");
		
		query2.printQuery();
	}
	
	public static void main(String[] args) {
		TestesUnitarios.TesteIO();
//		TestesUnitarios.TesteSSH2();
		TestesUnitarios.TesteQueryMaker();
	}

}
