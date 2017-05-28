package engine;

import li3.Interface;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;

public class QueryEngineImpl implements Interface {

    /**
     *Estruturas utilizadas para inserir a informação dos snapshots
     */
    private Estruturas estruturas;
    
    //PERGUNTAR AO STOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
    /*public QueryEngineImpl(Estruturas estruturas){
        this.estruturas = estruturas;
    }*/

    /**
     *Inicia a estrutura do tipo Estruturas
     */
    public void init() {
        this.estruturas = new Estruturas();
    }

    /**
     *Carrega a informação dos snapshots para a estrutura
     *
     *@param nsnaps        O número de snapshots passados
     *@param snaps_paths   O nome dos snapshots passados
     */
    public void load(int nsnaps, ArrayList<String> snaps_paths) {
        Parse parse = new Parse();
        this.estruturas = parse.parseSnaps(nsnaps, snaps_paths);
    }

    /**
     *Calcula quantas páginas existem na estrutura 
     *
     *@return     O número total de páginas
     */
    public long all_articles() {
        return this.estruturas.getNrPages();
    }

    /**
     *Calcula quantos artigos únicos existem na estrutura
     *
     *@return     O número total de artigos únicos
     */
    public long unique_articles() {
        return this.estruturas.getArtigos().size();
    }

    /**
     *Calcula quantas revisões existem na estrutura
     *
     *@return     O número total de revisões
     */
    public long all_revisions() {
        return this.estruturas.getRevisoes().size();
    }

    /**
     *Verifica quais os 10 contribuidores que fizeram mais revisões de artigos
     *
     *@return     Um array com os ids dos 10 maiores contribuidores, organizado por ordem decrescente, caso o número de contribuições seja igual o id menor aparece primeiro
     */
    public ArrayList<Long> top_10_contributors() {
        Map<Long,Contribuidor> aux = new TreeMap<Long,Contribuidor>();
        ArrayList<Long> contribuidores = new ArrayList<>();
        int tmp;
        long id = 0, maior = 0;
        
        for(Map.Entry<Long,Contribuidor> c: this.estruturas.getContribuidores().entrySet()){
            aux.put(c.getKey(), c.getValue().clone());
        }
        
        for(tmp = 0; tmp < 10 && tmp < this.estruturas.getContribuidores().size(); tmp++){
            maior = 0;
            
            for(Contribuidor c: aux.values()){
                if(c.getNrContribuicoes() > maior){
                    maior = c.getNrContribuicoes();
                    id = c.getIdContribuidor();
                }
            }
            
            contribuidores.add(id);
            aux.remove(id);
        }

        return contribuidores;
    }

    /**
     *Verifica qual o nome de um certo identificador de contribuidor
     *
     *@param contributor_id    O id do contribuidor
     *@return     O nome do contribuidor, ou NULL caso não exita esse contribuidor
     */
    public String contributor_name(long contributor_id) {
        return this.estruturas.getContribuidores().get(contributor_id).getNome();
    }

    /**
     *Verifica quais os 20 artigos com maior número de carateres
     *
     *@return     Um array com os ids dos 20 maiores artigos, organizado por ordem decrescente, caso o número de carateres seja igual o id menor aparece primeiro
     */
    public ArrayList<Long> top_20_largest_articles() {
        Map<Long,Artigo> aux = new TreeMap<Long,Artigo>();
        ArrayList<Long> artigos = new ArrayList<>();
        int tmp;
        long id = 0, maior = 0;
        
        for(Map.Entry<Long,Artigo> a: this.estruturas.getArtigos().entrySet()){
            aux.put(a.getKey(), a.getValue().clone());
        }
        
        for(tmp = 0; tmp < 20 && tmp < this.estruturas.getArtigos().size(); tmp++){
            maior = 0;
            
            for(Artigo a: aux.values()){
                if(a.getNrChars() > maior){
                    maior = a.getNrChars();
                    id = a.getIdArtigo();
                }
            }
            
            artigos.add(id);
            aux.remove(id);
        }

        return artigos;
    }

    /**
     *Verifica qual o titulo de um certo identificador de artigo
     *
     *@param article_id    O id do artigo
     *@return     O titulo do artigo, ou NULL caso não exita esse artigo
     */
    public String article_title(long article_id) {

        return this.estruturas.getArtigos().get(article_id).getTitulo();
    }

    /**
     *Verifica quais os N artigos com maior número de palavras
     *
     *@param n   O número total de artigos desejados
     *@return     Um array com os ids dos N artigos com mais palavras, organizado por ordem decrescente, caso o número de palavras seja igual o id menor aparece primeiro
     */
    public ArrayList<Long> top_N_articles_with_more_words(int n) {
        Map<Long,Artigo> aux = new TreeMap<Long,Artigo>();
        ArrayList<Long> artigos = new ArrayList<>();
        int tmp;
        long id = 0, maior = 0;
        
        for(Map.Entry<Long,Artigo> a: this.estruturas.getArtigos().entrySet()){
            aux.put(a.getKey(), a.getValue().clone());
        }
        
        for(tmp = 0; tmp < n && tmp < this.estruturas.getArtigos().size(); tmp++){
            maior = 0;
            
            for(Artigo a: aux.values()){
                if(a.getNrPalavras() > maior){
                    maior = a.getNrPalavras();
                    id = a.getIdArtigo();
                }
            }
            
            artigos.add(id);
            aux.remove(id);
        }

        return artigos;
    }

    /**
     *Verifica quais os titulos que contem um determinado prefix
     *
     *@param prefix  O prefixo desejado
     *@return     Um array com os titulos organizados por ordem alfabética
     */
    public ArrayList<String> titles_with_prefix(String prefix){
        Set<String> aux = new TreeSet<String>();
        ArrayList<String> titulos = new ArrayList<>();
        
        for(Artigo a: this.estruturas.getArtigos().values()){
            if(a.getTitulo().startsWith(prefix)){
                aux.add(a.getTitulo());
            }
        }
        
        for(String s: aux){
            titulos.add(s);
        }

        return titulos;
    }

    /**
     *Verifica qual o timestamp de um certo identificador de revisão
     *
     *@param article_id    O id do artigo
     *@param revision_id   O id da revisão
     *@return     O timestamp da revisão, ou NULL caso não exita essa revisão
     */
    public String article_timestamp(long article_id, long revision_id) {
        return this.estruturas.getRevisoes().get(revision_id);
    }
    
    /**
     * Método que limpa as estruturas
     */
    public void clean() {
        this.estruturas.limpaEstruturas();
    }
}
