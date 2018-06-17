package calculator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StorageItem implements Serializable {
    char[][][] matrix;
    LocalDateTime add_date;
    String comment;

    public StorageItem( char[][][] matrix, String comment){
        this.matrix = matrix;
        this.add_date = LocalDateTime.now();
        this.comment = comment;
    }

    public void printItem(){

        DiagramCalculation.print(matrix,0);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(add_date));

        System.out.println(comment);
    }
}
