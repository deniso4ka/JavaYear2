
  
 public class FavouriteSport extends AlbumItem{

	  public FavouriteSport(String picture,String discription) {
		  this.picture = picture;
		  this.discription=discription;
		// TODO Auto-generated constructor stub
	}
		
	  

	  public String getFact() {

		String desc =  this.getdiscription();
		
		

		return desc ; 
		
		
		
	  }
	  public String getImage() {

			String desc =  this.getpicture();
			
			

			return desc; 
			
			
			
		  }
	  
	}
