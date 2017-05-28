import java.util.List;
import java.util.ArrayList;

/**
 * Escreva a descrição da classe Test aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Test
{
    public static void main(String[] args){
        QueryEngineImpl query = new QueryEngineImpl();
        
        query.init();
        
        ArrayList<String> arrayList = new ArrayList<>();
        
        for(int i=0; i < args.length; i++){
            arrayList.add(args[i]);
        }
        
        query.load(args.length, arrayList);
        
        System.out.println("PERGUNTA 1: "+query.all_articles());
        System.out.println("PERGUNTA 2: "+query.unique_articles());
        System.out.println("PERGUNTA 3: "+query.all_revisions());
        System.out.println("PERGUNTA 4: "+query.top_10_contributors());
        System.out.println("PERGUNTA 5: "+query.contributor_name(28903366));
        System.out.println("PERGUNTA 6: "+query.top_20_largest_articles());
        System.out.println("PERGUNTA 7: "+query.article_title(15910));
        System.out.println("PERGUNTA 8: "+query.top_N_articles_with_more_words(30));
        System.out.println("PERGUNTA 9: "+query.titles_with_prefix("Anax"));
        System.out.println("PERGUNTA 10: "+query.article_timestamp(12, 763082287));
        
        query.clean();
        System.out.println(query);
    }
}
