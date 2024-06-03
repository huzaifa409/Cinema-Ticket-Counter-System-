package Cinema;

public class Customer {

	String name;
	int age;
	String moviename;
	String tickettype;
	int ticketNo;
	int seatNo;
	String date;

	public Customer(String name, int age, String Ttype, String Mname, String date) {

		this.name = name;
		this.age = age;
		this.tickettype = Ttype;
		this.moviename = Mname;
		this.date = date;

	}



	public String toString() {
		String s= """
                          ------------------------
                          Movie: """ + moviename + "\n" + "Customer: " + name + "\n" + "Age: " + age
				+ "\n" + "Ticket Type: " + tickettype + "\n" + "Ticket No: " + ticketNo + "\n" + "Seat No: " + seatNo
				+ "\n" + "Date : " + date + "\n" + "------------------------";

				return s;
	}

}
