package PF_Session4;
class Queens {
    int[] numberOfQueens;
    public Queens(int number) {
    	numberOfQueens = new int[number];							//number of Queens.
    }
   /*Returns TRUE if a queen can be placed in row r and column c. 
    //Using backtracking this method prints all possible placements of n */
    public void placeQueens(int r, int n) {
        for (int c = 0; c < n; c++) {
            if (canPlaceQueen(r, c)) {
            	numberOfQueens[r] = c;							//placing column number for row, where row number is index of x.
                if (r == (n - 1)) {
                    printQueens(numberOfQueens);
                } else {
                    placeQueens(r + 1, n);
                }
            }
        }
    }
    //checking if queen can be placed here.
    public boolean canPlaceQueen(int r, int c) {
        for (int i = 0; i < r; i++) {
            if (numberOfQueens[i] == c || (i - r) == (c - numberOfQueens[i]) || (i - r) == (numberOfQueens[i] - c) ){
                return false;
            }
        }
        return true;								//passing column number for row.
    }
    public void callplaceNqueens() {
        placeQueens(0, numberOfQueens.length);							//calling main function with required parameters.
    }
    //final function to print queens.
    public void printQueens(int[] x) {
        int rows = x.length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (x[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
