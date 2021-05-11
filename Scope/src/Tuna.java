//Java Vm Loads
//Java Vm Starts method main
//Java Vm loads class Apple into memery
//--static class members are loaded as well
//-class lebel varialbles are allocated(once)
//-static methods are made ready to run

//new Apple() constructor called 
//-Apple object placed inte memory
//-instance fields are initialized
//-constructor(s) are run(chained)
//-instance methods are permitted to be used
//-this is initialized as well




public class Tuna {
	private int beijing;
	private int x=42;//class-level scope(instance variable)
	public void addNumbers(int x) {// int x is local-scope, and this is an instance method
	int y=55;//local-scope
	this.x=76;// here, x=42// work with its intern file
	x=6;
	if(abc == xyz) {
		int z=33;
	
	}
	int index=0;
	for(index=0; index<numbers.length; index++) {
		
	}
	System.out.print(index);
	for(int count=0;count<10;count++) {
		
	}
	}
	public int getBeijing() {
		return beijing;
	}
	public void setBeijing(int beijing) {
		this.beijing = beijing;
	}

}
