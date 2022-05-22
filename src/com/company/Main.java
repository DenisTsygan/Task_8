package com.company;

import java.io.File;
import java.time.LocalDateTime;
import java.util.*;

public class Main {

    public static void main(String[] args)  {
        Database database=new Database();
        Random random = new Random();
        int number_triangles = 10;
        Triangles triangles = new Triangles();
        for (int i = 0; i < number_triangles; i++) {
            triangles.add(new EquilateralTriangle(random.nextInt(5)));
        }
        int number_pyramid = 10;
        Pyramids pyramids = new Pyramids();
        for (int i = 0; i < number_pyramid; i++) {
            pyramids.add(new RightPyramid(random.nextInt(5),random.nextInt(5)));
        }
        //backup_copy(database);
        String filename="D:\\Dowland chrome\\db_task8\\database.txt";
        database.add(pyramids);
        database.add(triangles);
        database.save(filename);
        database.clear();
        database.load(filename);
        LocalDateTime date_finish=LocalDateTime.now();
        //Создание названия резервной копии как метка времени(день-месяц-год,часы-минуты)
        String date_finish_txt=""+date_finish.getDayOfMonth()+"-"+date_finish.getMonthValue()+"-"+date_finish.getYear()+","+date_finish.getHour()+"-"+date_finish.getMinute();
        //Создание резервной копии при завершении программы
        database.save("D:\\Dowland chrome\\db_task8\\backup_copy("+date_finish_txt+").txt");


    }
    /**
     Функция которая восстанавдивает данне из последней созданной резервной копии при запуске(то есть в начале программы)
     */
    private static void backup_copy(Database database) {
        String filename_backup_copy="D:\\Dowland chrome\\db_task8\\";
        File dir = new File(filename_backup_copy);
        LocalDateTime[] date=new LocalDateTime[dir.listFiles().length];
        int iterator=0;
        if(dir.isDirectory())
        {
            for(File item : dir.listFiles()){
                if(!item.isDirectory()){
                    if(item.getName().startsWith("backup_copy")){
                        String resultStr = item.getName().substring(item.getName().indexOf('(') + 1, item.getName().indexOf(')'));
                        String[] numbers =resultStr.split("-");
                        String[] year_hour=numbers[2].split(",");
                        date[iterator]=LocalDateTime.of((Integer.parseInt(year_hour[0])),Integer.parseInt(numbers[1]),Integer.parseInt(numbers[0]),Integer.parseInt(year_hour[1]),Integer.parseInt(numbers[3]));
                        iterator+=1;
                    }
                }
            }
        }
        date=Arrays.copyOf(date,iterator);
        int index_file=0;
        for (int i = 0; i < date.length; i++) {
            if(i+1<date.length) {
                if (date[i].isBefore(date[i + 1])) {
                    index_file = i + 1;
                }
            }
        }
        for(File item : dir.listFiles()){
            if(!item.isDirectory()){
                if(item.getName().startsWith("backup_copy("+date[index_file].getDayOfMonth()+"-"+date[index_file].getMonthValue()+"-"+date[index_file].getYear()+","+date[index_file].getHour()+"-"+date[index_file].getMinute()+")")){
                    database.load(filename_backup_copy+"backup_copy("+date[index_file].getDayOfMonth()+"-"+date[index_file].getMonthValue()+"-"+date[index_file].getYear()+","+date[index_file].getHour()+"-"+date[index_file].getMinute()+").txt");
                }
            }
        }

    }
}
