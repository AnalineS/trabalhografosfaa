/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FAA.TG.Interface;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe que gera o arquivo XML, base para o grafo que será criado pelo framework
 * @author Eduardo
 */
public class GenerateXML {

    //Aqui definimos o cabecalho do arquivo xml, isso teoricamente nao muda, entao nao se preocupe
    public static StringBuffer arquivo = new StringBuffer(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!--  An excerpt of an egocentric social network  -->\n<graphml xmlns=\"").
            append("http://graphml.graphdrawing.org/xmlns\">\n\t<graph edgedefault=\"undirected\">\n\n\t\t<!-- data schema -->\n\t\t<key id=\"name\" for=\"node\"").
            append(" attr.name=\"name\" attr.type=\"string\"/>\n\t\t<key id=\"gender\" for=\"node\" attr.name=\"gender\" attr.type=\"string\"/>\n\n\t\t<!-- nodes -->  ");
    
    /**
     * Método utilizado para gerar os nodos,
     * será passado um id, para correlação nas arestas.
     * Através do id, criaremos uma aresta de um nodo a outro.
     * @param id
     * @param nome
     * @return
     *
     */
    public static void generateNodes(long userId, String name, String gender) {
        arquivo.append("\n\t\t<node id=\"").append(userId).append("\">\n\t\t\t").append(
                "<data key=\"name\">").append(name).append("</data>\n\t\t\t<data key=\"gender\">").append(gender).append("</data>\n\t\t</node>");
    }

    /**
     * Nessa método serão construídos as arestas correspondes ao id do usuário
     * de origem (idSource)
     * ao id do usuário de destino (idTarget).
     * @param idSource
     * @param idTarget
     * @return
     */
    public static void generateEdges(int idSource, int idTarget) {
        arquivo.append("\n\t\t<edge source=\"").append(idSource).append("\" target=\"").append(idTarget).append("\"></edge>\n\t\t\t");
    }

    /**
     *
     * Esse método vai "fechar" o arquivo
     */
    public static void fechaArquivo() {
        arquivo.append("\n\n\t</graph>\n</graphml>");
    }

    /**
     *
     * Método utilizado para salvar o arquivo no disco
     * @param path
     *
     */
    public static void salvarXML(String path) {

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(path));
            out.write(arquivo.toString());
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao salvar arquivo...Saindo");
            System.exit(0);

        }

    }
}
