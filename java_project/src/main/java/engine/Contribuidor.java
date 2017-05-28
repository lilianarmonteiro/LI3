
/**
 * Classe que contém as informações relevantes de um contribuidor.
 */
public class Contribuidor
{
    /**
     * Variáveis de Instância
     */
    
    /**
     * Id do contribuidor
     */
    private long idContribuidor;
    /**
     * Nome do contribuidor
     */
    private String nome;
    /**
     * Número de contribuições
     */
    private long nrContribuicoes;
    
    /**
     * Construtores
     */
    
    /**
     * Construtor vazio que cria uma instância contribuidor
     */
    public Contribuidor(){
        this.idContribuidor = -1;
        this.nome = "ND";
        this.nrContribuicoes = 0;
    }
    
     /**
     * Construtor por cópia que cria um novo contribuidor a partir dos parâmetros dados 
     * 
     * @param id    id do contribuidor
     * @param nome  nome do contribuidor
     * @param nrC   número de contribuições
     */
    public Contribuidor(long id, String nome, long nrC){
        this.idContribuidor = id;
        this.nome = nome;
        this.nrContribuicoes = nrC;
    }
    
    /**
     * Construtor que cria um novo contribuidor a partir de um contribuidor passado como parâmetro
     * 
     * @param c  Contribuidor    
     */
    public Contribuidor(Contribuidor c){
        this.idContribuidor = c.getIdContribuidor();
        this.nome = c.getNome();
        this.nrContribuicoes = c.getNrContribuicoes();
    }
    
    /**
     * Métodos de Instância
     */
    
    /**
     * Método que devolve o id de um contribuidor
     * 
     * @return  Id do contribuidor
     */
    public long getIdContribuidor(){
        return this.idContribuidor;
    }
    
    /**
    * Método que define o id de um contribuidor a partir de um long passado como parâmetro
    * 
    * @param id   Id do contribuidor a ser aplicado
    */
    public void setIdContribuidor(long id){
        this.idContribuidor = id;
    }
    
    /**
     * Método que devolve o nome de um contribuidor
     * 
     * @return  Nome do contribuidor
     */
    public String getNome(){
        return this.nome;
    }
    
    /**
     * Método que define o nome de um contribuidor a partir de uma String passada como parâmetro
     * 
     * @param n   Nome do contribuidor a ser aplicado
     */
    public void setNome(String n){
        this.nome = n;
    }
    
    /**
     * Método que devolve o número de contribuições de um contribuidor
     * 
     * @return  Número de contribuições do contribuidor
     */
    public long getNrContribuicoes(){
        return this.nrContribuicoes;
    }
    
    /**
     * Método que define o número de contribuições de um contribuidor a partir de um long passado como parâmetro
     * 
     * @param n   Número de contribuições a ser aplicado
     */
    public void setNrContribuicoes(long n){
        this.nrContribuicoes = n;
    }
    
    /**
     * Método que converte um contribuidor numa string
     * 
     * @return  String com a informação do contribuidor
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("INFORMACAO DE UM CONTRIBUIDOR:\n");
        sb.append("Id do contribuidor: "+this.idContribuidor+"\n");
        sb.append("Nome do contribuidor: "+this.nome+"\n");
        sb.append("Numero de contribuicoes: "+this.nrContribuicoes+"\n");
        
        return sb.toString();
    }
    
    /**
     * Método que cria uma cópia de um contribuidor
     */
    public Contribuidor clone(){
        return new Contribuidor(this);
    }
    
    /**
    * Método que testa se um objeto é igual a um determinado contribuidor
    * @param o     objeto a ser testado
    * @return      true se o objeto for igual ao contribuidor, false se o objeto passado não for igual ao contribuidor
    */
    public boolean equals(Object o){
        if (this==o) return true;
        if((o==null) || (this.getClass() != o.getClass())) return false;
        
        Contribuidor c = (Contribuidor) o;
        return this.idContribuidor == c.getIdContribuidor() && this.nome.equals(c.getNome()) && this.nrContribuicoes == c.getNrContribuicoes();
    }
}
