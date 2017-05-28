import java.util.Map;
import java.util.HashMap;

/**
 * Classe que contém as hashmap necessárias para guardar as informações dos snapshots
 */
public class Estruturas
{
   /**
    * Variáveis de Instância;
    */
   
   /**
   * Número total de pages
   */
   private long nrPages;
   /**
    * Map que tem como chave o id de um artigo e como valor as informações do artigo
    */
   private Map<Long,Artigo> artigos;
   /**
    * Map que tem como chave o id de um contribuidor e como valor as informações do contribuidor
    */
   private Map<Long,Contribuidor> contribuidores;
   /**
    * Map que tem como chave o id de uma revisão e como valor o timestamp da revisão
    */
   private Map<Long,String> revisoes;
   
   /**
    * Construtores
    */
   
   /**
     * Construtor vazio que cria uma instância Estruturas
     */
   public Estruturas(){
   	   this.nrPages = 0;
       this.artigos = new HashMap<>();
       this.contribuidores = new HashMap<>();
       this.revisoes = new HashMap<>();
   }
   
   /**
     * Construtor que cria uma nova estrutura a partir de uma estrutura passada como parâmetro
     * 
     * @param e  Estruturas  
     */
   public Estruturas(Estruturas e){
   	   this.nrPages = e.getNrPages();
       this.artigos = e.getArtigos();
       this.contribuidores = e.getContribuidores();
       this.revisoes = e.getRevisoes();
   }
   
   /**
    * Métodos de Instância
    */

   /**
    * Método que devolve o número de páginas de uma estrutura
    * 
    * @return  Número de páginas da estrutura
    */
   public long getNrPages(){
       return this.nrPages;
   }
   
   /**
    * Método que define o número de páginas de uma estrutura a partir de um long passado como parâmetro
    * 
    * @param n   Número de páginas a ser aplicado
    */
   public void setNrPages(long n){
       this.nrPages = n;
   }
   
   /**
    * Método que devolve uma cópia da hashmap com as informações dos artigos
    * 
    * @return  Map com as informações dos artigos
    */
   public Map<Long,Artigo> getArtigos(){
       Map<Long,Artigo> aux = new HashMap<>();
       
       for(Map.Entry<Long,Artigo> a: this.artigos.entrySet()){
           aux.put(a.getKey(), a.getValue().clone());
       }
       
       return aux;
   }
   
   /**
    * Método que define o map das informações dos artigos de uma estrutura a partir de um map passado como parâmetro
    * 
    * @param art   Map a ser aplicado
    */
   public void setArtigos(Map<Long,Artigo> art){
       this.artigos.clear();
       
       for(Map.Entry<Long,Artigo> a: art.entrySet()){
           this.artigos.put(a.getKey(), a.getValue().clone());
       }
   }
   
   /**
    * Método que devolve uma cópia da hashmap com as informações dos contribuidores
    * 
    * @return  Map com as informações dos contribuidores
    */
   public Map<Long,Contribuidor> getContribuidores(){
       Map<Long,Contribuidor> aux = new HashMap<>();
       
       for(Map.Entry<Long,Contribuidor> c: this.contribuidores.entrySet()){
           aux.put(c.getKey(), c.getValue().clone());
       }
       
       return aux;
   }
   
   /**
    * Método que define o map das informações dos contribuidores de uma estrutura a partir de um map passado como parâmetro
    * 
    * @param cont   Map a ser aplicado
    */
   public void setContribuidores(Map<Long,Contribuidor> cont){
       this.contribuidores.clear();
       
       for(Map.Entry<Long,Contribuidor> c: cont.entrySet()){
           this.contribuidores.put(c.getKey(), c.getValue().clone());
       }
   }
   
   /**
    * Método que devolve uma cópia da hashmap com as informações das revisões
    * 
    * @return  Map com as informações das revisões
    */
   public Map<Long,String> getRevisoes(){
       Map<Long,String> aux = new HashMap<>();
       
       for(Map.Entry<Long,String> r: this.revisoes.entrySet()){
           aux.put(r.getKey(), r.getValue());
       }
       
       return aux;
   }
   
   /**
    * Método que define o map das informações das revisões de uma estrutura a partir de um map passado como parâmetro
    * 
    * @param rev   Map a ser aplicado
    */
   public void setRevisoes(Map<Long,String> rev){
       this.revisoes.clear();
       
       for(Map.Entry<Long,String> r: rev.entrySet()){
           this.revisoes.put(r.getKey(), r.getValue());
       }
   }
   
   /**
     * Método que converte uma estrutura numa string
     * 
     * @return  String com a informação da estrutura
     */
   public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Número total de pages: ").append(this.nrPages+"\n");
        sb.append("Estrutura artigos: \n").append(this.artigos.toString());
        sb.append("Estrutura contribuidores: \n").append(this.contribuidores.toString());
        sb.append("Estrutura revisoes: \n").append(this.revisoes.toString());
        
        return sb.toString();
   }
  
   /**
     * Método que cria uma cópia de uma estrutura
     */
   public Estruturas clone(){
       return new Estruturas(this);
    }
    
   /**
    * Método que testa se um objeto é igual a uma determinada estrutura
    * @param o     objeto a ser testado
    * @return      true se o objeto for igual à estrutura, false se o objeto passado não for igual à estrutura
    */
   public boolean equals(Object o){
       if(this == o) return true;
       if(o == null || o.getClass() != this.getClass()) return false;
       
       Estruturas e = (Estruturas) o;
       return this.nrPages == e.getNrPages() && this.artigos.equals(e.getArtigos()) && this.contribuidores.equals(e.getContribuidores()) && this.revisoes.equals(e.getRevisoes());
   }

   /**
    * Método que adiciona a informação de uma nova revisão ao map das revisões
    *
    * @param idRevisao  Id da revisão
    * @param timestamp  Timestamp da revisão
    */
   public void adicionaRevisao(long idRevisao, String timestamp){
      this.revisoes.put(idRevisao, timestamp);
   }

   /**
     * Método que alterar a informação de um artigo, caso este já exista na hashmap dos artigos, ou insere um novo artigo na hashmap, caso este ainda não exista
     * 
     * @param idArtigo    Id do artigo
     * @param titulo  	  Titulo do artigo
     * @param nrChars     Número de caracteres do artigo
     * @param nrPalavras  Número de palavras do artigo
     */
   public void renovaArtigo(long idArtigo, String titulo, long nrChars, long nrPalavras){
   	   if(this.artigos.containsKey(idArtigo)){
   	       Artigo artigoHash = this.artigos.get(idArtigo);

   	       if(artigoHash.getNrChars() > nrChars) nrChars = artigoHash.getNrChars();
   	       if(artigoHash.getNrPalavras() > nrPalavras) nrPalavras = artigoHash.getNrPalavras();

   	       Artigo novoArtigo = new Artigo(idArtigo, titulo, nrChars, nrPalavras);
   	       this.artigos.replace(idArtigo, novoArtigo);
   	   }

   	   else{
   	       Artigo novoArtigo = new Artigo(idArtigo, titulo, nrChars, nrPalavras);
   	       this.artigos.put(idArtigo, novoArtigo.clone());
   	   }
   }

   /**
     * Método que alterar a informação de um contribuidor, caso este já exista na hashmap dos contribuidores, ou insere um novo contribuidor na hashmap, caso este ainda não exista
     * 
     * @param idContribuidor    Id do contribuidor
     * @param nome  	  		Nome do contribuidor
     */
   public void renovaContribuidor(long idContribuidor, String nome){
   	   if(this.contribuidores.containsKey(idContribuidor)){
   	       Contribuidor contribuidorHash = this.contribuidores.get(idContribuidor);

   	       	long contribuicoesAtuais = contribuidorHash.getNrContribuicoes() + 1;
   	       
   	       Contribuidor novoContribuidor = new Contribuidor(idContribuidor, nome, contribuicoesAtuais);
   	       this.contribuidores.replace(idContribuidor, novoContribuidor);
   	   }

   	   else{
   	       Contribuidor novoContribuidor = new Contribuidor(idContribuidor, nome, 1);
   	       this.contribuidores.put(idContribuidor, novoContribuidor.clone());
   	   }
   }

   public void limpaEstruturas(){
      this.nrPages = 0;
      this.artigos.clear();
      this.contribuidores.clear();
   }
}
