package schaakbord;

/*
 * klasse om de gegevens van het schaakbord op te slaan en bij te werken
 */

 class SchaakbordData{
    //lijst van cellen, tweedimensionale boolean array
    private int bordgrootte;
    public boolean [][] schaakbord; 
    private boolean [][] rekenbord; //voor berekening nieuwe waarden

    //toggle-variabele om array om en om te vullen
    boolean colorBoolean = true;

    //constructor
    public SchaakbordData(int bg){
        bordgrootte = bg;
        schaakbord = new boolean [bordgrootte][bordgrootte];
        rekenbord = new boolean [bordgrootte][bordgrootte];

        for(int i = 0; i < bordgrootte; i++){
            colorBoolean = (i%2 == 0);//begin regels om en om
            for(int j = 0; j < bordgrootte; j++){

                schaakbord[i][j] = colorBoolean;
                colorBoolean = !colorBoolean;
            }
        }
    }

    /**
     * inhoud van schaabord array tonen
     */
    public void printSchaakbord(){
        System.out.println("Inhoud schaakbord-array \n");

        for(int i = 0; i < bordgrootte; i++){
            for(int j = 0; j < bordgrootte; j++){
                System.out.print(schaakbord[i][j] + "\t");                
            }
            System.out.println("");//nieuwe regel
        }
    }
    /**
     * invert the colors of the squares
     * or the 'lives of the cells'
     */
    public void invertLives(){

        for(int i = 0; i < bordgrootte; i++){            
            for(int j = 0; j < bordgrootte; j++){
                schaakbord[i][j] = !schaakbord[i][j];                
            }
        }
    }

    /**
     * make all fields white
     */
    public void allCellsWhite(){
        for(int i = 0; i < bordgrootte; i++){            
            for(int j = 0; j < bordgrootte; j++){
                schaakbord[i][j] = false;                
            }
        }
    }

    /**
     * seed table with random noise
     */
    public void seedRandom(){
        double treshold = 0.2;
        
        for(int i = 0; i < bordgrootte; i++){            
            for(int j = 0; j < bordgrootte; j++){
                double randomDouble =  Math.random();
                boolean randomBoolean = (randomDouble < treshold);
                schaakbord[i][j] = randomBoolean;                
            }
        }

    }



    


 }