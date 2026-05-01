class Solution {
    public boolean isValidSudoku(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        //1. Check for rows and col 
        for(int i=0; i<r; i++) {
            Set<Character> rset = new HashSet<>();
            Set<Character> cset = new HashSet<>();
            for(int j=0;j<c;j++) {
                //System.out.print(board[i][j]+" ");
                if((board[i][j] != '.' && !rset.add(board[i][j])) || (board[j][i] != '.' && !cset.add(board[j][i])))
                   return false;
            }
            //System.out.println();
        }
        //2. 3x3 matrix
        for(int R=3; R<=r; R=R+3) 
        {
           for(int C=3; C<=c; C=C+3) {
           Set<Character> rset = new HashSet<>();
           for(int i=R-3; i<R; i++) {
                for(int j=C-3;j<C;j++) {
                  // System.out.print(board[i][j]+" ");
                    if(board[i][j] != '.' && !rset.add(board[i][j]))
                      return false;
            }
            //System.out.println();
           }
           //System.out.println();
           //System.out.println();
        }
        }

        return true;
    }
}
