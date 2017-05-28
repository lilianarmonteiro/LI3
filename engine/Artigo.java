
/**
 * Classe que contém as informações relevantes de um artigo.
 */
public class Artigo
{
    /**
     * Variáveis de Instância
     */
    
    /**
     * Id do artigo
     */
    private long idArtigo;
    /**
     * Título do artigo
     */
    private String titulo;
    /**
     * Número de caracteres do artigo
     */
    private long nrChars;
    /**
     * Número de palavras do artigo
     */
    private long nrPalavras;
    
    /**
     * Construtores
     */
    
    /**
     * Construtor vazio que cria uma instância artigo
     */
    public Artigo(){
        this.idArtigo = -1;
        this.titulo = "ND";
        this.nrChars = 0;
        this.nrPalavras = 0;
    }
    
    /**
     * Construtor por cópia que cria um novo artigo a partir dos parâmetros dados 
     * 
     * @param id    id do artigo
     * @param titulo  titulo do artigo
     * @param nrC   número de caracteres do artigo
     * @param nrP   número de palavras do artigo
     */
    public Artigo(long id, String titulo, long nrC, long nrP){
        this.idArtigo = id;
        this.titulo = titulo;
        this.nrChars = nrC;
        this.nrPalavras = nrP;
    }
    
    /**
     * Construtor que cria um novo artigo a partir de um artigo passado como parâmetro
     * 
     * @param a  Artigo 
     */
    public Artigo(Artigo a){
        this.idArtigo = a.getIdArtigo();
        this.titulo = a.getTitulo();
        this.nrChars = a.getNrChars();
        this.nrPalavras = a.getNrPalavras();
    }
    
    /**
     * Métodos de Instância
     */
    
    /**
     * Método que devolve o id de um artigo
     * 
     * @return  Id do artigo
     */
    public long getIdArtigo(){
        return this.idArtigo;
    }
    
    /**
     * Método que define o id de um artigo a partir de um long passado como parâmetro
     * 
     * @param id   Id do artigo a ser aplicado
     */
    public void setIdArtigo(long id){
        this.idArtigo = id;
    }
    
     /**
     * Método que devolve o titulo de um artigo
     * 
     * @return  Titulo do artigo
     */
    public String getTitulo(){
        return this.titulo;
    }
    
    /**
     * Método que define o titulo de um artigo a partir de uma String passada como parâmetro
     * 
     * @param t   Titulo do artigo a ser aplicado
     */
    public void setTitulo(String t){
        this.titulo = t;
    }
    
     /**
     * Método que devolve o número de caracteres de um artigo
     * 
     * @return  Número de caracteres do artigo
     */
    public long getNrChars(){
        return this.nrChars;
    }
    
    /**
     * Método que define o número de caracteres de um artigo a partir de um long passado como parâmetro
     * 
     * @param n   Número de caracteres a ser aplicado
     */
    public void setNrChars(long n){
        this.nrChars = n;
    }
    
    /**
     * Método que devolve o número de palavras de um artigo
     * 
     * @return  Número de palavras do artigo
     */
    public long getNrPalavras(){
        return this.nrPalavras;
    }
    
    /**
     * Método que define o número de palavras de um artigo a partir de um long passado como parâmetro
     * 
     * @param n   Número de palavras a ser aplicado
     */
    public void setNrPalavras(long n){
        this.nrPalavras = n;
    }
    
    /**
     * Método que converte um artigo numa string
     * 
     * @return  String com a informação do artigo
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("INFORMACAO DE UM ARTIGO:\n");
        sb.append("Id do artigo: "+this.idArtigo+"\n");
        sb.append("Titulo do artigo: "+this.titulo+"\n");
        sb.append("Numero de caracteres do artigo: "+this.nrChars+"\n");
        sb.append("Numero de palavras do artigo: "+this.nrPalavras+"\n");
        
        return sb.toString();
    }
    
    /**
     * Método que cria uma cópia de um artigo
     */
    public Artigo clone(){
        return new Artigo(this);
    }
    
    /**
     * Método que testa se um objeto é igual a um determinado artigo
     * @param o     objeto a ser testado
     * @return      true se o objeto for igual ao artigo, false se o objeto passado não for igual ao artigo
     */
    public boolean equals(Object o){
        if (this==o) return true;
        if((o==null) || (this.getClass() != o.getClass())) return false;
        
        Artigo a = (Artigo) o;
        return this.idArtigo == a.getIdArtigo() && this.titulo.equals(a.getTitulo()) && this.nrChars == a.getNrChars() && this.nrPalavras == a.getNrPalavras();
    }
}
