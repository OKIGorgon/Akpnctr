package M.ButtonAlgorithmConv;

import java.util.ArrayList;

public abstract class AbstractButtonAlgorithmConverter {
	ArrayList<String> Result;

	AbstractButtonAlgorithmConverter() {
		Result = new ArrayList<String>();
	}

	public ArrayList<String> getResult() {
		return Result;
	}
}
