package MyType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class WordBook {
    private String bookName;
    private long createdTime;
    public ArrayList<Word> wordBook;

    public WordBook(String bookName){
        this.bookName = bookName;
        this.createdTime = System.currentTimeMillis();
        wordBook = new ArrayList<Word>();
    }
    public WordBook(String bookName, String name, String explanation){
        this.bookName = bookName;
        this.createdTime = System.currentTimeMillis();
        Word word = new Word(name, explanation);
        wordBook.add(word);
    }
    public WordBook(String bookName, Word word){
        this.bookName = bookName;
        this.createdTime = System.currentTimeMillis();
        wordBook.add(word);
    }
    public WordBook(String bookName, Word[] word){
        this.bookName = bookName;
        this.createdTime = System.currentTimeMillis();
        for (Word w : word
                ) {
            wordBook.add(w);
        }
    }
    public WordBook(String bookName, HashMap<String, String> word){
        this.bookName = bookName;
        this.createdTime = System.currentTimeMillis();
        Iterator iter = word.entrySet().iterator();
        while (iter.hasNext()) {
            HashMap.Entry entry = (HashMap.Entry) iter.next();
            Word newWord = new Word(entry.getKey().toString(), entry.getValue().toString());
            wordBook.add(newWord);
        }
    }

    public Word getTheWordWithTheLeastMemoryLevel(){
        Iterator<Word> iterator = wordBook.iterator();
        Word resultWord = wordBook.get(0);
        double minLevel = resultWord.getMemoryLevel();
        while (iterator.hasNext()){
            Word word = iterator.next();
            double wordLevel = word.getMemoryLevel();
            if(minLevel > wordLevel){
                minLevel = wordLevel;
                resultWord = word;
            }
        }
        return resultWord;
    }
    public Word addWord(String name, String explanation){
        Word word = new Word(name, explanation);
        wordBook.add(word);
        return word;
    }
}
