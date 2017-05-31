import sac.State;
import sac.StateFunction;

public class HFunctionSpace extends StateFunction {

    @Override
    public double calculate(State state) {
    	Connect4 con = (Connect4) state;
    	byte[][] board = con.board;
    	
    	double p1 = 0.0;
    	double p2 = 0.0;
    	
    	//wiersze
    	double wp1 = 0.0;
    	double wp2 = 0.0;
        	for (int i = 0; i < board.length; i++) {		//wiersze
        		int player1 = 0,
        			r1 = 4,
        			toWin1 = 0;
        		int player2 = 0,
        			r2 = 4,
        			toWin2 = 0;
                for (int j = 0; j < board[0].length; j++) {		//kolumny w wierszu
                	if (board[i][j] == 0)
                	{
                		toWin1 = 0;
                		r1--;
                		
                		toWin2 = 0;
                		r2--;
                	}
                	if (board[i][j] == 1)
                	{
                		toWin1++;
                		player1++;
                		r1--;
                		
                		toWin2 = 0;
                		player2 = 0;
                		r2 = 4;
                	}
                	if (board[i][j] == 2)
                	{
                		toWin2++;
                		player2++;
                		r2--;
                		
                		toWin1 = 0;
                		player1 = 0;
                		r1 = 4;
                	}
                	if (toWin1 >= 4)
                		return Double.POSITIVE_INFINITY;
                	if (toWin2 >= 4)
                		return Double.NEGATIVE_INFINITY;
                	if (r1 == 0)
                		wp1 += player1;
                	if (r2 == 0)
                		wp2 += player2;
                }
        	}
        	p1 += wp1;
        	p2 += wp2;        	
        	
        //kolumny
        double kp1 = 0.0;
        double kp2 = 0.0;
        	for (int j = 0; j < board[0].length; j++) {		//kolumny
        		int player1 = 0,
        			r1 = 4,
        			toWin1 = 0;
        		int player2 = 0,
        			r2 = 4,
        			toWin2 = 0;
                for (int i = 0; i < board.length; i++) {		//wiersze w kolumnie
                	if (board[i][j] == 0)
                	{
                		toWin1 = 0;
                		r1--;
                		
                		toWin2 = 0;
                		r2--;
                	}
                	if (board[i][j] == 1)
                	{
                		toWin1++;
                		player1++;
                		r1--;
                		
                		toWin2 = 0;
                		player2 = 0;
                		r2 = 4;
                	}
                	if (board[i][j] == 2)
                	{
                		toWin2++;
                		player2++;
                		r2--;
                		
                		toWin1 = 0;
                		player1 = 0;
                		r1 = 4;
                	}
                	if (toWin1 >= 4)
                		return Double.POSITIVE_INFINITY;
                	if (toWin2 >= 4)
                		return Double.NEGATIVE_INFINITY;
                	if (r1 == 0)
                		kp1 += player1;
                	if (r2 == 0)
                		kp2 += player2;
                }
        	}
	        p1 += kp1;
	    	p2 += kp2;  
	    	
	    //skos prawo gora
	    double sg1 = 0.0;
	    double sg2 = 0.0;
        	int slants = board.length + board[0].length -1;		//linie skosne gora
        	for (int i=0; i<slants;i++){
        		int x = i;
        		int y = 0;
        		int player1 = 0,
            		r1 = 4,
            		toWin1 = 0;
            	int player2 = 0,
            		r2 = 4,
            		toWin2 = 0;
        		while(x >= 0){
        			if ( x > board.length-1 || y > board[0].length-1){
                    	x--;
                    	y++;
                    	continue;
        				
        			}
        			if (board[x][y] == 0)
                	{
        				toWin1 = 0;
                		r1--;
                		
                		toWin2 = 0;
                		r2--;
                	}
                	if (board[x][y] == 1)
                	{
                		toWin1++;
                		player1++;
                		r1--;
                		
                		toWin2 = 0;
                		player2 = 0;
                		r2 = 4;
                	}
                	if (board[x][y] == 2)
                	{
                		toWin2++;
                		player2++;
                		r2--;
                		
                		toWin1 = 0;
                		player1 = 0;
                		r1 = 4;
                	}
                	if (toWin1 >= 4)
                		return Double.POSITIVE_INFINITY;
                	if (toWin2 >= 4)
                		return Double.NEGATIVE_INFINITY;
                	if (r1 == 0)
                		kp1 += player1;
                	if (r2 == 0)
                		kp2 += player2;
                	//
                	//
                	x--;
                	y++;
        		}
        	}
        	p1 += sg1;
	    	p2 += sg2;  
	    	
	    	//skos prawo dol
	    	double sd1 = 0.0;
		    double sd2 = 0.0;
        	for (int i=0; i<slants;i++){		//linie skosne dol
        		int x = board.length-1-i;
        		int y = 0;
        		int player1 = 0,
                	r1 = 4,
                	toWin1 = 0;
                int player2 = 0,
                	r2 = 4,
                	toWin2 = 0;
        		while(x < board.length){
        			if ( x < 0 || y > board[0].length-1){
                    	x++;
                    	y++;
                    	continue;
        				
        			}
        			if (board[x][y] == 0)
                	{
        				toWin1 = 0;
                		r1--;
                		
                		toWin2 = 0;
                		r2--;
                	}
                	if (board[x][y] == 1)
                	{
                		toWin1++;
                		player1++;
                		r1--;
                		
                		toWin2 = 0;
                		player2 = 0;
                		r2 = 4;
                	}
                	if (board[x][y] == 2)
                	{
                		toWin2++;
                		player2++;
                		r2--;
                		
                		toWin1 = 0;
                		player1 = 0;
                		r1 = 4;
                	}
                	if (toWin1 >= 4)
                		return Double.POSITIVE_INFINITY;
                	if (toWin2 >= 4)
                		return Double.NEGATIVE_INFINITY;
                	if (r1 == 0)
                		kp1 += player1;
                	if (r2 == 0)
                		kp2 += player2;
                	//
                	//
                	x++;
                	y++;
        		}
        	}
        	p1 += sd1;
	    	p2 += sd2;  
        	
	    	
	    	if (con.isMaximizingTurnNow())
	    		return p1;
	    	else
	    		return p2;
        }

}
