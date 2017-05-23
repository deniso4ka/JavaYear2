/**
 * 
 */

/**
 * @author den
 *
 */
public class Computer extends HandHeldDevice{

	
		
		private double computerSpeed;
		private double memory;
		private double screenSize;
		
	
		
		public Computer(String manufacturer, double weight,double computerSpeed, double memory, double screenSize){
			
			super(manufacturer,weight);
			this.computerSpeed = computerSpeed;
			this.memory = memory;
			this.screenSize = screenSize;
		
		}
		
		
		
		@Override
		public String toString() {
			return "Computer [computerSpeed=" + computerSpeed + ", memory="
					+ memory + ", screenSize=" + screenSize + "]"+ super.toString();
		}



		public double getcomputerSpeed(){
			
		return computerSpeed;
		}

		
		public double getmemory(){
			
			return memory;
			}
		
		public double getscreenSize(){
			
			return screenSize;
			}


	
}
