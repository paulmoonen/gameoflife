package gameoflife;

/*
 * class to hold and recalculate cell data
 */

 class ChessboardData{
    
    private int squaresAlongSide;               //number of squares along either side of chessboard
    public boolean [][] chessboard;             //list of cells, two dimensional boolean array 
    private boolean [][] calculationboard;      //temporarily hold all new values
    private int iLess, iMore, jLess, jMore;     //variables to get neighbour cell coordinates
    private byte livingNeighbours;              //count number of living neighbours 
    private boolean previousStatus, nextStatus; //next status: to temporarily save in rekenbord    
    
    //constructor
    public ChessboardData(int bg){
        squaresAlongSide = bg;
        chessboard = new boolean [squaresAlongSide][squaresAlongSide];
        calculationboard = new boolean [squaresAlongSide][squaresAlongSide];

        //fill method on starting up
        allCellsWhite();
    }

    /**
     * fill with chessboard style pattern
     */
    public void fillChessboardStyle(){
        for(int i = 0; i < squaresAlongSide; i++){
            Boolean colorBoolean = (i%2 == 0);          //start rows alternately true or false
            for(int j = 0; j < squaresAlongSide; j++){

                chessboard[i][j] = colorBoolean;
                colorBoolean = !colorBoolean;
            }
        }
    }
    
    /**
     * invert the colors of the squares
     * or the 'lives of the cells'
     */
    public void invertLives(){

        for(int i = 0; i < squaresAlongSide; i++){            
            for(int j = 0; j < squaresAlongSide; j++){
                chessboard[i][j] = !chessboard[i][j];                
            }
        }
    }

    /**
     * make all fields white
     */
    public void allCellsWhite(){
        for(int i = 0; i < squaresAlongSide; i++){            
            for(int j = 0; j < squaresAlongSide; j++){
                chessboard[i][j] = false;                
            }
        }
    }

    /**
     * seed table with random noise
     */
    public void seedRandom(){
        double treshold = 0.15; //do play with this value! 
        
        for(int i = 0; i < squaresAlongSide; i++){            
            for(int j = 0; j < squaresAlongSide; j++){
                double randomDouble =  Math.random();
                boolean randomBoolean = (randomDouble < treshold);
                chessboard[i][j] = randomBoolean;                
            }
        }

    }
    
    /**
     * toggle value of an individual cell
     */
    public void toggleCell(int x, int y){

        chessboard[x][y] = !chessboard[x][y];

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
        for(int i = 0; i < squaresAlongSide; i++){
            for(int j = 0; j < squaresAlongSide; j++){
                
                if(i == 0){ iLess = squaresAlongSide - 1; }
                else{ iLess = i-1; }

                if(i == squaresAlongSide - 1){ iMore = 0; }
                else{ iMore = i + 1; }

                if(j == 0){ jLess = squaresAlongSide - 1; }
                else{ jLess = j -1; }

                if( j == squaresAlongSide - 1){ jMore = 0;}
                else{ jMore = j + 1; } 

                livingNeighbours = 0; //fresh start
                previousStatus = chessboard[i][j];
                
                //systematically visit all neighbours
                if(chessboard[iLess][jLess]) livingNeighbours +=1;
                if(chessboard[iLess][  j  ]) livingNeighbours +=1;
                if(chessboard[iLess][jMore]) livingNeighbours +=1;
                if(chessboard[  i  ][jLess]) livingNeighbours +=1;
                if(chessboard[  i  ][jMore]) livingNeighbours +=1;
                if(chessboard[iMore][jLess]) livingNeighbours +=1;
                if(chessboard[iMore][  j  ]) livingNeighbours +=1;
                if(chessboard[iMore][jMore]) livingNeighbours +=1;

                //determine next status of our cell
                if(livingNeighbours == 0){ nextStatus = false; }
                if(livingNeighbours == 1){ nextStatus = false; }
                if(livingNeighbours == 2){ nextStatus = previousStatus; } //no change
                if(livingNeighbours == 3){ nextStatus = true; } //dead cell becomes alive, living stays alive
                if(livingNeighbours >= 4){ nextStatus = false; }
                
                //save in temporary array rekenbord
                calculationboard[i][j] = nextStatus;               

            }
        }

        //write / copy calculationboard values into chessboard array
        for(int i = 0; i < squaresAlongSide; i++){
            for(int j = 0; j < squaresAlongSide; j++){
                chessboard[i][j] = calculationboard[i][j];
                
            }
        }
    } 
 }