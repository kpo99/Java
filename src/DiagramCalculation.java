public class DiagramCalculation {



    public DiagramCalculation(){

    }

    private char[][][] init(int flag){
        switch (flag){
            case 4:
                return init_4();
            case 5:
                return init_5();
             default:
                return null;
        }
    }

    private char[][][] init_4(){
        char[][][] output = new char[4][4][5];

        //out
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                output[i][j][0] = '*';
            }
        }

        for (int i = 0 ; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if(i == 0 || i == 1)
                {
                    output[i][j][1] = '1';
                }
                else
                {
                    output[i][j][1] = '0';
                }
            }
        }

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (j == 0 || j == 1)
                {
                    output[i][j][2] = '1';
                }
                else
                {
                    output[i][j][2] = '0';
                }
            }
        }

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (i == 1 || i == 2)
                {
                    output[i][j][3] = '1';
                }
                else
                {
                    output[i][j][3] = '0';
                }
            }
        }

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (j == 1 || j == 2)
                {
                    output[i][j][4] = '1';
                }
                else
                {
                    output[i][j][4] = '0';
                }
            }
        }
        return output;
    }

    private char[][][] init_5(){
        char[][][] output = new char[4][8][6];

        //out
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                output[i][j][0] = '*';
            }
        }

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (i == 2 || i == 3)
                {
                    output[i][j][1] = '1';
                }
                else
                {
                    output[i][j][1] = '0';
                }

            }
        }

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (i == 1 || i == 2)
                {
                    output[i][j][2] = '1';
                }
                else
                {
                    output[i][j][2] = '0';
                }
            }
        }

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (j == 2 || j == 3|| j == 4 || j == 5)
                {
                    output[i][j][3] = '1';
                }
                else
                {
                    output[i][j][3] = '0';
                }
            }
        }

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (j == 1 || j == 2 || j == 5 || j == 6)
                {
                    output[i][j][4] = '1';
                }
                else
                {
                    output[i][j][4] = '0';
                }
            }
        }

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (j == 1 || j == 2 || j == 3 || j == 0)
                {
                    output[i][j][5] = '1';
                }
                else
                {
                    output[i][j][5] = '0';
                }
            }
        }
        return output;
    }
    public static void print(char[][][] target,int level){

        System.out.println("");
        for (int i = 0; i < target.length; i++)
        {
            System.out.print(" ");
            for (int j = 0; j < target[1].length; j++)
            {
                System.out.print(target[i][j][ level] + " ");

            }
            System.out.println("");
        }
    }



    public char[][][] Calculate(char[] ... params){
       int flag =  params.length -1;

       char[][][] output = init(flag);
       int n = params[0].length;

       switch (flag){
           case 4:
            for(int x = 0; x < n; x++)
            {
                for (int i = 0; i < 4; i++)
                {
                    for (int j = 0; j < 4; j++)
                    {
                        if (output[i][j][1] == params[1][x] && output[i][j][2] == params[2][x] && output[i][j][3] == params[3][x])
                        {
                            if (params[4][x] == '*')
                            {
                                output[i][j][0] = params[0][x];
                            }
                            else
                            {
                                if (params[4][x] == output[i][j][4])
                                {
                                    output[i][j][0] = params[0][x];
                                }
                            }

                        }
                    }
                }

            }
            break;
           case 5:
               for (int x = 0; x < n; x++)
               {

                   for (int i = 0; i < 4; i++)
                   {
                       for (int j = 0; j < 8; j++)
                       {
                           if (output[i][j][1] == params[1][x] && output[i][j][2] == params[2][x] && output[i][j][3] == params[3][x] && output[i][j][4] == params[4][x])
                           {

                               if (params[5][x] == '*')
                               {
                                   output[i][j][0] = params[0][x];
                               }
                               else
                               {
                                   if (params[5][x] == output[i][j][5])
                                   {
                                       output[i][j][0] = params[0][x];
                                   }
                               }

                           }
                       }
                   }
                   //this.print(0);
               }
               break;

            default: return null;



       }


     //  print(output,0);
       return output;

    }
}
