package lichsuModal;

import java.util.ArrayList;

public class lichsuBo {
	lichsuDao lsdao= new lichsuDao();
	public ArrayList<lichsu> getLichsu(long makh) throws Exception{
	    return lsdao.getLichsu(makh);
	}
}
