package gameoflife;

/*
 * klasse om de gegevens van het schaakbord op te slaan en bij te werken
 */

 class SchaakbordData{
    
    private int bordgrootte;                    //number of squares along either side of chessboard
    public boolean [][] schaakbord;             //lijst van cellen, tweedimensionale boolean array 
    private boolean [][] rekenbord;             //voor berekening nieuwe waarden
    private int iLess, iMore, jLess, jMore;     //variables to get neighbour cell coordinates
    private byte livingNeighbours;              //count number of living neighbours 
    private boolean previousStatus, nextStatus; //next status: to temporarily save in rekenbord 

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
    
    /**
     * toggle value of an individual cell
     */
    public void toggleCell(int x, int y){

        schaakbord[x][y] = !schaakbord[x][y];

    }

    /**
     * calculate new generation in 'game of life'
     * each cell has eight neighbours 
     * each cell[x][y] has eight neighbours:
     * 
     *      [x-1][y-1]   [x][y-1]   [x+1][y-1]
     *      [x-1][ y ]    a cell    [x+1][ y ]
     *      [x-1][y+1]   [x][y+1]   [x+1][y+1] 
     * 
     * Edge and corner cases: at the end of an array, refer to the begin of the same array
     * check for value 0, or 'bordgrootte' -1
     * ( wrap around, donut / torus style tpoplogy)
     * 
     * Determine next status (true = 'alive', false = 'dead') of each cell.
     * Count number of living (true) neighbour cells.
     *      3 living neighbours:        dead cell becomes alive
     *      2 or 3 living neighbours:   living cell stays alive
     *      0 or 1 living neigbours:    living cell dies
     *      4 -> 8 living neighbours:   living cell dies   
     */
    public void nextGeneration(){
        
        //fill rekenbord with new values
        for(int i = 0; i < bordgrootte; i++){
            for(int j = 0; j < bordgrootte; j++){
                
                if(i == 0){ iLess = bordgrootte - 1; }
                else{ iLess = i-1; }

                if(i == bordgrootte - 1){ iMore = 0; }
                else{ iMore = i + 1; }

                if(j == 0){ jLess = bordgrootte - 1; }
                else{ jLess = j -1; }

                if( j == bordgrootte - 1){ jMore = 0;}
                else{ jMore = j + 1; } 

                livingNeighbours = 0; //fresh start
                previousStatus = schaakbord[i][j];
                
                //systematically visit all neighbours
                if(schaakbord[iLess][jLess]) livingNeighbours +=1;
                if(schaakbord[iLess][  j  ]) livingNeighbours +=1;
                if(schaakbord[iLess][jMore]) livingNeighbours +=1;
                if(schaakbord[  i  ][jLess]) livingNeighbours +=1;
                if(schaakbord[  i  ][jMore]) livingNeighbours +=1;
                if(schaakbord[iMore][jLess]) livingNeighbours +=1;
                if(schaakbord[iMore][  j  ]) livingNeighbours +=1;
                if(schaakbord[iMore][jMore]) livingNeighbours +=1;

                //determine next status of our cell
                if(livingNeighbours == 0){ nextStatus = false; }
                if(livingNeighbours == 1){ nextStatus = false; }
                if(livingNeighbours == 2){ nextStatus = previousStatus; } //no change
                if(livingNeighbours == 3){ nextStatus = true; } //dead cell becomes alive, living stays alive
                if(livingNeighbours >= 4){ nextStatus = false; }
                
                //save in temporary array rekenbord
                rekenbord[i][j] = nextStatus;               

            }
        }

        //write / copy rekenbord values into schaakbord array
        for(int i = 0; i < bordgrootte; i++){
            for(int j = 0; j < bordgrootte; j++){
                schaakbord[i][j] = rekenbord[i][j];
            }
        }
    } 
 }