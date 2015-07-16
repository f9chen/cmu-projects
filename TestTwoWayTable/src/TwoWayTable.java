public class TwoWayTable {
    int numRows;
    int numCols;
    int[][] cell;
    int[] rowSum;
    int[] colSum;
    int grandTotal;

    // constructor
    TwoWayTable(int[][] data) {
       numRows = data.length + 1;
       numCols = data[0].length + 1;
       cell = new int[numRows][numCols];
       rowSum = new int[numRows];
       colSum = new int[numCols];
       for (int i = 0; i < numRows - 1; i++){
    	   for (int j = 0; j < numCols - 1; j++){
    		   cell[i][j] = data[i][j];
    	   }
       }
       setMargins();
    }

    void setMargins() {
       for (int i = 0; i < numRows - 1; i++){
    	   for (int j = 0; j < numCols - 1; j++){
    		   rowSum[i] += cell[i][j];
    	   }
    	   cell[i][numCols - 1] = rowSum[i];
       }   
       for (int j = 0; j < numCols - 1; j++){
    	   for (int i = 0; i < numRows - 1; i++){
    		   colSum[j] += cell[i][j];
    	   }
    	   cell[numRows - 1][j] = colSum[j];
       }
       for (int i = 0; i < numRows - 1; i++){
    	   cell[numRows - 1][numCols - 1] = grandTotal += rowSum[i];
       }
       // compute the row and column sums;       
       // ÒmarginsÓ is the statisticianÕs term 
       // for these totals, since they appear
       // Òin the marginsÓ
    }
    public String toString() {
        String result = "";
        if (numRows > 0) {
            for (int i = 0; i < numRows - 1; i++) {
            	for (int j = 0; j < numCols - 1; j++){
            		if(cell[i][j] < 10){
            			 result = result + "  " + cell[i][j];
            		}
            		else{
                         result = result + " " + cell[i][j];
            		}//adjust spaces between each number, applys for 2 digit
                }
            	result = result + " | " + cell[i][numCols - 1]+"\n";//manually print | before rowSum
            }//print our all but last row
            result = result +"--------------------"+"\n";//seperater before last row
            for (int j = 0; j < numCols - 1; j++){
            	if(cell[numRows - 1][j] < 10){
           			 result = result + "  " + cell[numRows - 1][j];
            	}
           		else{
                     result = result + " " + cell[numRows - 1][j];
           		}//adjust spaces between each number, applys for 2 digit
            	}//print last row
            result = result + " | " + cell[numRows - 1][numCols - 1];
            } 
        return result;
    } // overwrite toString function   
}


