import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class MyDictionaryRemote extends UnicastRemoteObject implements MyDictionary {
    private HashMap<String, String> words = new HashMap<>(10000);;
    private HashMap<String, String> definitions = new HashMap<>(10000);;
    private String dictionary_file_path = "/Users/alsenydiallo/IdeaProjects/programming_assgmnt4_rpc/resources/Oxford_English_Dictionary.txt";
    private String words_file_path = "/Users/alsenydiallo/IdeaProjects/programming_assgmnt4_rpc/resources/words.txt";

    protected MyDictionaryRemote() throws RemoteException {
        super();
        loadWordsFromFile();
        loadDictionaryFromFile();
    }


    @Override
    public String lookUpWord(String word) {
        System.out.println("Server searching for: " + word);
        if (validateWord(word) != null && !definitions.isEmpty()) {
            return definitions.get(word.toLowerCase());
        }
        return null;
    }

    public String validateWord(String word) {
        if(!words.isEmpty()){
            return words.get(word.toLowerCase());
        }else{
            return null;
        }
    }

    private void loadWordsFromFile(){
        BufferedReader buffer = openFile(words_file_path);
        String line;

        try {
            while ((line = buffer.readLine()) != null) {
                words.put(line, line);
            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadDictionaryFromFile(){
        BufferedReader buffer = openFile(dictionary_file_path);
        String line;

        try {
            while ((line = buffer.readLine()) != null) {

                if (!line.equals("") && !line.equals(" ")) {
                    int space_index = line.indexOf(' ');
                    if (space_index >= 0) {
                        String word = line.substring(0, space_index);
                        String def = line.substring(space_index);
                        definitions.put(word.toLowerCase(), def);
                    } else {
                        definitions.put(line, " LETTER COVER PAGE ");
                    }
                }
            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedReader openFile(String file_name) {
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(file_name));
            return buffer;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
