import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //dosya oluşturuldu
        File file = new File("notlar.txt");
        //Eğer daha önce dosya eklenmemişse oluşturuldu
        if (!(file.exists())){
            try {
                file.createNewFile();
                System.out.println(" "+file+" oluşturuldu");
            }catch (IOException e){
                throw new RuntimeException(e);
            }
            //eğer dosya daha önce oluşturulduysa dosya açıldı ve okuma yapıldı
        }else {
            System.out.println(" "+file+" açıldı");
            getFileReader(file);
        }
        //yazma yapılması için method çağırıldı
        getPrintWriter(file);
    }
    public static void getFileReader(File file){
        try {
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    //kullanıcıdan veri alındı ve true dönerek girilen veri kaydedildi.
    public static void getPrintWriter(File file) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Bir metin giriniz: ");
        String text = inp.nextLine();
        try {
            FileWriter writer = new FileWriter(file,true);
            PrintWriter writer1 = new PrintWriter(writer);
            writer1.print(text+" ");
            writer1.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
