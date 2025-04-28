
class Notes {
	public static void main(String[] args) {
		//toString -> creates a string that represents your object
		//This is what is used when you use System.out.print() on your object
		//getClass -> tell what you class your object is
		//equals -> checks if the two objects are the same
		//hashCode -> hashCode of the object
		//clone -> clone the object, make a copy
		//finalize
		//wait and notify
		Cat cat = new Cat("kat", 12);
		Cat cat2 = new Cat("kat", 12);
		System.out.println(cat); // -> toString needs to be replaced
		System.out.println(cat2);
		// System.out.println(cat.getClass());
		System.out.println(cat.equals(cat2)); //-> needs to be replaced
		// System.out.println(cat.hashCode());
		Cat cat3 = cat.clone(); //-> needs to be replace
		System.out.println(cat.equals(cat3));
	}
}
