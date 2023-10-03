package connect4;

import utils.Console;

enum Error {

	IS_FULL("The column is full"),
	WRONG_COORDINATES("The coordinates are wrong"),
	NULL;

	private String message;

	Error(){
	}

	Error(String message){
		this.message = message;
	}

	void writeln() {
		if (!this.isNull()) {
			Console.getInstance().writeln(this.message);
		}
	}

	public boolean isNull() {
		return this == Error.NULL;
	}

}