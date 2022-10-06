import java.net.CacheRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main {

  private static final String TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum";

  public static void main(String[] args) {

    char[] caseSymbol = TEXT.toLowerCase(Locale.ROOT).toCharArray();

    Map<Character, Integer> symbols = new HashMap<>();

    for (Character currentSymbol : caseSymbol){
      if (currentSymbol != ' '){
        symbols.merge(currentSymbol, 1, (currentValue, defaultValue) -> ++currentValue);
      }
    }
  
    int maxCount = -1;
    Map.Entry<Character, Integer> resEntry = null;

    for (Map.Entry<Character, Integer> currentEntry : symbols.entrySet()){
      if (currentEntry.getValue() > maxCount){
        resEntry = currentEntry;
        maxCount = currentEntry.getValue();
      }
    }

    System.out.println("Чаще всего встречается символ: " + resEntry.getKey() + ", он отображен " + resEntry.getValue() + " раз(а).");

    int minCount = Integer.MAX_VALUE;
    Map.Entry<Character, Integer> resultEntry = null;

    for (Map.Entry<Character, Integer> currentEntry : symbols.entrySet()){
      if (currentEntry.getValue() < minCount){
        resultEntry = currentEntry;
        minCount = currentEntry.getValue();
      }
    }
    System.out.println("Реже всего встречается символ: " + resultEntry.getKey() + ", он отображен " + resultEntry.getValue() + " раз(а).");
  }
}
