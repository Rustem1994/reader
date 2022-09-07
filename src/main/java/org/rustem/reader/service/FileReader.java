package org.rustem.reader.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FileReader {

    @Scheduled(fixedDelay = 10000)
    public void test(){
        System.out.println("Запустили test");
        List<File> lst = Arrays.asList((new File("folder")).listFiles());
        System.out.println("Список файлов в папке folder = "+lst.toString());

        String max_max_line="";// Значение максимальной строки в папке
        String max_max_filename="";
        for (File file : lst){
            System.out.println("файл "+file.getName());
            System.out.println("Читаем файл "+file.getName());
            String[] arr_line = new String[0];
            try (BufferedReader br = new BufferedReader(new java.io.FileReader(file)))
            {
                String line="";
                String max_line="";
                int count_line=0;

                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    System.out.println("Количество символов в строке = "+line.length());
                    System.out.println("Текущее значение max_line = "+ max_line);

                    if (line.length()>max_line.length()){
                        max_line=line;
                    }
                    count_line++;
                }
                arr_line=new String[count_line];

                if (max_max_line.length()<max_line.length()) {
                    max_max_line = max_line;
                    max_max_filename=file.getName();
                }
                System.out.println("Максимальная строка max_line в файле "+ file.getName()+" = "+max_line);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (BufferedReader br = new BufferedReader(new java.io.FileReader(file)))
            {
                String line="";
                int index=0;
                while ((line = br.readLine()) != null) {
                    arr_line[index++]=line;

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Получили массив");
            for (int i=0; i<arr_line.length;i++){
                System.out.println("arr_line["+i+"]="+arr_line[i]);
            }


            for (int i = 0; i < arr_line.length-1; i++) {
                int max=-1;
                int max_index=0;
                for (int j = 0; j < arr_line.length-i; j++) {
                    if (arr_line[j].length() >= max) {
                        max = arr_line[j].length();
                        max_index = j;
                    }
                }
                String val = arr_line[max_index];
                arr_line[max_index] = arr_line[arr_line.length - 1 - i];
                arr_line[arr_line.length - 1- i] = val;
            }
            System.out.println("Сортированный массив");
            for (int i=0; i<arr_line.length;i++){
                System.out.println("arr_line["+i+"]="+arr_line[i]);
            }



        }
        System.out.println("Нашли max_max_line в файле "+max_max_filename+" = "+max_max_line);
        System.out.println("Закрыли test");
    }

}
