import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhanTu<T> implements ComparableGreater<T> {
    private T value;

    public PhanTu(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        String path = args[0];
        List<PhanTu> list = new ArrayList<>();
        try {
            File input = new File(path);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                Integer data = scanner.nextInt();
                list.add(new PhanTu(data));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        list.sort();
        try {
            File file = new File("output.txt");
            file.createNewFile();
            FileWriter myWriter = new FileWriter(file);
            for (int i=0; i<list.size();i++){
                myWriter.write(list.get(i).getValue()+"\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
