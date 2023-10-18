import java.io.*;

public class Main {
    public static void main(String[] args){
        //file dosyası oluşturuldu
        File file=new File("file.txt");
        try {
            //Dosya içeriği yazıldı
            String input="5\n10\n20\n12\n33";
            FileWriter fileWriter=new FileWriter(file,false);
            BufferedWriter Writer=new BufferedWriter(fileWriter);
            Writer.write(input);
            Writer.close();
            //Dosyanın içeriği FileReader ile okunmaya başlandı
            FileReader fileReader=new FileReader(file);
            String line;
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            int total=0;
            System.out.println("****** file dosyası içerisindeki sayılar ****** ");
            while ((line=bufferedReader.readLine())!=null){
                //Toplam alındı
                System.out.println(line+" ");
                total+=Integer.parseInt(line);
            }
            System.out.println();
            //Toplam ekrana basıldı
            System.out.println("Sayıların Toplamı : "+total);
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}