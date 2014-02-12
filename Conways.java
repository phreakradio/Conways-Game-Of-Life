import java.util.*;

public class Conways {
public static void main (String[] args)throws ArithmeticException
{
//---Define parameters of grid------
int row, column, runs;
int cellx, celly;

Scanner input = new Scanner (System.in);	//Prepare input
row= input.nextInt();						//Collect input for # of rows
column= input.nextInt();					//Collect input for # of columns
if(row< 0 || column < 0)					//Throw exception in case the user can't count
throw new ArithmeticException("Error! Please enter a valid number");

char[][] gameGrid  = new char[row][column];	//Generate size of grid for life

runs= input.nextInt();						//Collect input for # of generations
if(runs < 0)								//Throw exception in case the user mistypes a # or doesn't how to count by now
throw new ArithmeticException("It appears you have accidently entered a negative number.");		

generateGrid(gameGrid);						//Populate grid with dead cells for the time being

//while(input.hasNext())						//Collect input for where to place live cells
for(int i = 0 ; i < runs; i++)
{
cellx = input.nextInt();				//Collect X-axis coordinates for live cells
celly = input.nextInt();				//Collect Y-axis coordinates for live cells
if(cellx > row || celly > column)		//If either coordinate is out of bounds, alert user
throw new ArithmeticException("Your cell is out of bounds");
gameGrid[cellx-1][celly-1] = 'X';		//Place live cell in coordinate
}

for(int i=runs; i>=0; i--) 					//Run simulation	
{
printGrid(gameGrid);					//Prints grid after every regeneration
replace(row, column, gameGrid);			//Implements regeneration
System.out.println();					
}		
}
//----------------------------------------------------------------------
/*
* Generates the grid according to the size specified by the user
*/
public static void generateGrid(char[][]generateGrid)
{
for (int i = 0; i < generateGrid.length; i++){
for (int j = 0; j < generateGrid[i].length; j++){
generateGrid[i][j] = '_';
}//End Col loop
}//End Row loop
}//End Method
//----------------------------------------------------------------------
/*
* Prints the grid.
*/
public static void printGrid(char[][]printGrid){
for (int i = 0; i < printGrid.length; i++)
{
for (int j = 0; j <= printGrid[i].length; j++)
{
if(j == printGrid[i].length)
{
System.out.println();
}
else
System.out.print(printGrid[i][j]);
}//End Col loop				
}//End Row loop
}//End method	
//---------------------------------------------------------------------
/*
* For every cell (A) in the game grid, this method counts the # of live cells around A 
* Returns an integer value that allows the next value to determine its status in the 
* next generation
*/
public static int check(int row, int col, char[][]replaceGrid){
int acc = 0;
char Alive = 'X';

if(row==0)																//Check top row
{
if(col==0)														//Check leftmost columns first
{
if(replaceGrid[row][col+1] == Alive)					//Right
acc++;
if(replaceGrid[row+1][col] == Alive)					//Down
acc++;
if(replaceGrid[row+1][col+1] == Alive)					//Down Right
acc++;
if(replaceGrid[row][replaceGrid[row].length-1] == Alive)//Check other side of grid
acc++;
if(replaceGrid[row+1][replaceGrid[row].length-1] == Alive)//Check other side of grid
acc++;
}
if(col > 0 && col < replaceGrid[row].length-1)						//Check all columns between edges
{
if(replaceGrid[row][col-1] == Alive)					//Left
acc++;
if(replaceGrid[row+1][col-1] == Alive)					//Down left
acc++;
if(replaceGrid[row+1][col] == Alive)					//Down
acc++;
if(replaceGrid[row+1][col+1] == Alive)					//Down Right
acc++;
if(replaceGrid[row][col+1] == Alive)					//Right
acc++;
}
if(col == replaceGrid[row].length-1)							//Check last column
{
if(replaceGrid[row][col-1] == Alive)					//Left
acc++;
if(replaceGrid[row+1][col-1] == Alive)					//Down Left
acc++;
if(replaceGrid[row+1][col] == Alive)					//Down
acc++;
if(replaceGrid[row][0] == Alive)						//Check other side of grid
acc++;
if(replaceGrid[row+1][0] == Alive)						//Check other side of grid
acc++;
}
}

else if(row > 0 && row < replaceGrid.length-1)							//Any Row between top and bottom
{
if(col == 0)													//Check first column
{
if(replaceGrid[row-1][col] == Alive)					//Top
acc++;
if(replaceGrid[row-1][col+1] == Alive)					//Top right
acc++;
if(replaceGrid[row][col+1] == Alive)					//Right
acc++;
if(replaceGrid[row+1][col+1] == Alive)					//Down Right
acc++;
if(replaceGrid[row+1][col] == Alive)					//Down
acc++;
if(replaceGrid[row][replaceGrid[row].length-1] == Alive)//Check other side of grid
acc++;
if(replaceGrid[row-1][replaceGrid[row].length-1] == Alive)//Check other side of grid
acc++;
if(replaceGrid[row+1][replaceGrid[row].length-1] == Alive)//Check other side of grid
acc++;
}
if(col > 0 && col < replaceGrid[row].length-1)						//Check all columns between edges
{
if(replaceGrid[row-1][col] == Alive) 					//Top
acc++;
if(replaceGrid[row-1][col+1] == Alive) 					//Top right
acc++;
if(replaceGrid[row-1][col-1] == Alive)					//Top Left
acc++;
if(replaceGrid[row+1][col+1] == Alive) 					//Down right
acc++;
if(replaceGrid[row+1][col] == Alive) 					//Down
acc++;
if(replaceGrid[row+1][col-1] == Alive) 					//Down left
acc++;
if(replaceGrid[row][col-1] == Alive)					//Left
acc++;
if(replaceGrid[row][col+1] == Alive) 					//Right
acc++;
}
if(col == replaceGrid[row].length-1)							//Check last column
{
if(replaceGrid[row-1][col] == Alive)					//Top
acc++;
if(replaceGrid[row-1][col-1] == Alive)					//Top left
acc++;
if(replaceGrid[row][col-1] == Alive)					//Left
acc++;
if(replaceGrid[row+1][col-1] == Alive)					//Down left
acc++;
if(replaceGrid[row+1][col] == Alive)					//Down
acc++;
if(replaceGrid[row][0] == Alive)						//Check other side of grid
acc++;
if(replaceGrid[row+1][0] == Alive)						//Check other side of grid
acc++;
if(replaceGrid[row-1][0] == Alive)						//Check other side of grid
acc++;
}
}

else if(row == replaceGrid.length-1) 									//Check the last row
{
if(col==0)														//Check the first column
{
if(replaceGrid[row][col+1] == Alive)					//Right
acc++;
if(replaceGrid[row-1][col] == Alive)					//Left
acc++;
if(replaceGrid[row-1][col+1] == Alive)					//Top Right
acc++;
if(replaceGrid[row][replaceGrid[row].length-1] == Alive)//Check other side of grid
acc++;
if(replaceGrid[row-1][replaceGrid[row].length-1] == Alive)//Check other side of grid
acc++;
}
if(col > 0 && col < replaceGrid[row].length-1)						//Check all columns between top and bottom
{
if(replaceGrid[row][col-1] == Alive)					//left
acc++;
if(replaceGrid[row-1][col-1] == Alive)					//top left
acc++;
if(replaceGrid[row-1][col] == Alive)					//top
acc++;
if(replaceGrid[row-1][col+1] == Alive)					//top right
acc++;
if(replaceGrid[row][col+1] == Alive)					//right
acc++;
}
if(col == replaceGrid[row].length-1)							//Check last column
{
if(replaceGrid[row][col-1] == Alive)					//left
acc++;
if(replaceGrid[row-1][col-1] == Alive)					//Top left
acc++;
if(replaceGrid[row-1][col] == Alive)					//top
acc++;
if(replaceGrid[row][0] == Alive)						//Check other side of grid
acc++;
if(replaceGrid[row-1][0] == Alive)						//Check other side of grid
acc++;
}
}
return acc;
}//End Method
//----------------------------------------------------------------------	
/*
* Takes one cell at a time, uses previous methods output to find # of neighbors
* and determines whether conditions are suitable for next generation
*/
public static char[][] replace(int row, int col, char[][] checkGrid){
char Alive = 'X';
char Dead = '_';
int[][] subGrid = new int[row][col]; 
for(int a = 0; a < checkGrid.length;a++)
{
for(int b = 0; b < checkGrid[a].length; b++)
{
int neighbors = check(a,b,checkGrid);	//Returns the # of neighbors around cell being inspected
subGrid[a][b] = neighbors;				//Plants in an int Double array for later comparison
}//Col loop
}//Row loop


//Testing conditions for life or death. I call it, "The Hospital Loop of Doom" 
for(int c= 0; c < checkGrid.length;c++)
{
for(int d = 0; d < checkGrid[c].length;d++)
{
if(checkGrid[c][d]==Alive)
{	
if(subGrid[c][d] < 2 || subGrid[c][d] > 3) 														
{
checkGrid[c][d] = Dead;
}
else if(subGrid[c][d] == 2 || subGrid[c][d]==3)
{
checkGrid[c][d] = Alive;
}
}
else if(checkGrid[c][d]==Dead && subGrid[c][d]==3)
{
checkGrid[c][d] = Alive;
}				
}//End Col Loop
}//End Row loop
return checkGrid;
}//End Method
//----------------------------------------------------------------------	
}
