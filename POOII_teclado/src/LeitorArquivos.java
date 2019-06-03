import java.io.*;

public class LeitorArquivos{

    //    private FileWriter fileWriter;
    private FileReader fileReader;
    //    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    private File file;

    public LeitorArquivos() {

    }

    public String readFile(String path) {

        file = new File(path);
        String text = new String();
        String line;
        try {

            if(!file.exists()) {
                file.createNewFile();
            }
//            System.out.println(file.getAbsolutePath());

            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();

            while(line != null) {
                text += line;
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();

        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }

        return text;

    }
}
