package com.example.product.product;




import javax.validation.constraints.Size;

import com.mongodb.lang.NonNull;



public class ProductDTO {

		private static final long serialVersionUID = 1L;

		
	@NonNull
	@Size(min=2, message = "productName must not be less than 2 characters")
		private String productName;
		
	@NonNull
		private int price;
		
	@NonNull
	@Size(message = "Description cannot be empty")
		private String description;
		
	@NonNull
	@Size(message = "Quantity cannot be empty")
		private int quantity;
		
//		private byte[] image; 
		
		
		
		public ProductDTO() {
			
		}
		 
		public ProductDTO( String productName, int price, String description, int quantity) {
				
			
			this.productName = productName;
			this.price = price;
			this.description = description;
			this.quantity = quantity;
//			this.image = image;
		}
		
		

		public String getproductName() {
			return productName;
		}


		public void setproductName(String productName) {
			this.productName = productName;
		}


		public int getPrice() {
			return price;
		}


		public void setPrice(int price) {
			this.price = price;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public int getBrand() {
			return quantity;
		}


		public void setBrand(int quantity) {
			this.quantity = quantity;
		}

		

//		public byte[] getImage() {
//			return image;
//		}
//
//		public void setImage(byte[] image) {
//			this.image = image;
//		}

		@Override
		public String toString() {
			return "ProductDTO [price=" + price + ", description=" + description + ", quantity="
					+ quantity + "]";
		}

		
}