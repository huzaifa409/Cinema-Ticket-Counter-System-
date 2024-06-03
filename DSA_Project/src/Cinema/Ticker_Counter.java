package Cinema;

import java.util.Scanner;

public class Ticker_Counter {

	String Date;
	int ticketNo = 0;
	int total_ticket;
	Node rear;
	Node front;

	public Ticker_Counter() {
		Scanner obj = new Scanner(System.in);

		System.out.print("Enter Total Number of Seats  Available In Cinema :");
		int size = obj.nextInt();
		total_ticket = size;

	}

	public static void main(String[] args) {
		displayWelcomePage();
		Ticker_Counter t = new Ticker_Counter();
		Scanner obj = new Scanner(System.in);

		System.out.println();

		int menu;
		do {
			System.out.println("********************************************");
			System.out.println("*                                          *");
			System.out.println("*  🌟 What would you like to do today?     *");
			System.out.println("*                                          *");
			System.out.println("*  1. 🎟 Reserve a Seat                    *");
			System.out.println("*  2. 🚫 Remove Customer from Queue        *");
			System.out.println("*  3. 🔄 Update Reserved Seats             *");
			System.out.println("*  4. 🔍 Search Reserved Seats             *");
			System.out.println("*  5. 🎭 Display Reserved Seats            *");
			System.out.println();
			System.out.print("Enter A Number From Above:");
			menu = obj.nextInt();

			if (menu == 1) {
				System.out.println("************************************************");
				System.out.println("*           🎥 Movies Now Showing at           *");
				System.out.println("*              Shandar Cinema House 🍿               *");
				System.out.println("************************************************");
				System.out.println("*                                              *");
				System.out.println("*  1. 🚀 THE EXPANDABLES - Action Extravaganza *");
				System.out.println("*  2. 🌟 MOLA JATT - Epic Adventure            *");
				System.out.println("*  3. 😂 HARAM KHOR - Comedy Delight           *");
				System.out.println("*  4. 🐠 FINDING NEMO - Underwater Magic       *");
				System.out.println("*                                              *");
				System.out.println("************************************************");
				System.out.println();

				int choice;
				String movie = null;

				do {
					System.out.println("Enter A Number For Which Movie You Want To Watch :");
					choice = obj.nextInt();

					if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
						System.out.println("Number Not Present In List ");
					}

				} while (choice == 1 && choice == 2 && choice == 3 && choice == 4);

				if (choice == 1) {
					movie = "THE EXPANDABLES";
				} else if (choice == 2) {
					movie = "MOLA JATT";
				} else if (choice == 3) {
					movie = "HARAM KHOR";
				} else if (choice == 4) {
					movie = "FINDING NEMO";
				}

				System.out.print("Enter Customer Name :");
				String n = obj.next();
				n = n.toUpperCase();

				System.out.print("Enter Customer Age :");
				int age = obj.nextInt();

				System.out.println("Enter Ticket Type ( Vip / Student / Regular )");
				String ticket_type = obj.next();
				ticket_type = ticket_type.toUpperCase();

				System.out.println("Enter the date in YYYY-MM-DD format:");
				String date = obj.next();
				System.out.println("Seat Reserved Successfully");

				Customer c = new Customer(n, age, ticket_type, movie, date);

				t.Enqueue(c);
				System.out.println();
			} else if (menu == 2) {
				t.Dequeue();
				System.out.println();
			} else if (menu == 3) {
				t.Update();
				System.out.println();
			}

			else if (menu == 4) {
				t.Search();
				System.out.println();
			} else if (menu == 5) {
				t.Display();
				System.out.println();
			}
		} while (menu != 0);

		System.out.println();

	}

	public void Enqueue(Customer c) {
		Node n = new Node(c);

		if (front == null) {
			front = n;
			rear = n;

			if (ticketNo <= total_ticket) {
				ticketNo++;
				c.ticketNo = ticketNo;
				c.seatNo = ticketNo;

			}

		} else {
			if (ticketNo > total_ticket) {
				System.out.println("House Full ....");
			} else {

				rear.next = n;
				rear = n;
				// Assigning Ticket And Seat Number To Customers
				System.out.println("Seat reserved successfully ");
				ticketNo++;
				c.ticketNo = ticketNo;
				c.seatNo = ticketNo;

			}
		}
	}

	public Customer Dequeue() {
		if (front == null) {
			System.out.println("Queue Empty");
			return null;
		} else {
			Customer temp = front.data;
			front = front.next;
			ticketNo--;
			return temp;
		}
	}

	public void Display() {
		if (front == null) {
			System.out.println("House Empty .....");
		} else {
			Node curr = front;
			do {
				System.out.println(curr.data);
				curr = curr.next;
			} while (curr != null);
		}
	}

	public void Update() {
		Scanner obj = new Scanner(System.in);
		if (front == null) {
			System.out.println("No Ticket Is Reserved ");
		} else {
			System.out.print("What You Want To Change \n1: Customer Name \n2: Movie Name ");
			int choice = obj.nextInt();

			System.out.println("Enter Ticket No For Which You Want Changes ");
			int tcktno = obj.nextInt();
			if (choice == 1) {
				Node curr = front;
				while (curr != null) {
					if (curr.data.ticketNo == tcktno) {
						System.out.print("Enter New Name :");
						String newname = obj.next();
						newname = newname.toUpperCase();

						curr.data.name = newname;
						System.out.println("Value Updated");
						curr = curr.next;
					} else {
						curr = curr.next;

					}
				}
				boolean b = check_ticket(tcktno);
				if (b == false) {
					System.out.println("NO Ticket Found Against That Number");
				}

			} else if (choice == 2) {
				Node curr = front;
				while (curr != null) {
					if (curr.data.ticketNo == tcktno) {
						System.out.println("List Of Movies Aired Now In Aired Cinema ");
						System.out.println("1 : THE EXPANDABLES");
						System.out.println("2 : MOLA JATT");
						System.out.println("3 : HARAM KHOR");
						System.out.println("4 : FINDING NEMO");

						int moviechoice;
						do {
							System.out.println("Enter A Number For Which Movie You Want To See :");
							moviechoice = obj.nextInt();

							if (moviechoice != 1 && moviechoice != 2 && moviechoice != 3 && moviechoice != 4) {
								System.out.println("Number Not Present In List ");
							}

						} while (moviechoice == 1 && moviechoice == 2 && moviechoice == 3 && moviechoice == 4);

						if (moviechoice == 1) {
							curr.data.moviename = "THE EXPANDABLES";
						} else if (moviechoice == 2) {
							curr.data.moviename = "MOLA JATT";
						} else if (moviechoice == 3) {
							curr.data.moviename = "HARAM KHOR";
						} else if (moviechoice == 4) {
							curr.data.moviename = "FINDING NEMO";
						}

						curr = curr.next;
					} else {
						curr = curr.next;
					}
				}
				boolean b = check_ticket(tcktno);
				if (b == false) {
					System.out.println("NO Ticket Found Against That Number");
				}
			}

		}
	}

	public void Search() {
		Scanner obj = new Scanner(System.in);
		if (front == null) {
			System.out.println("House Empty...");
		} else {
			System.out.println(
					"Enter A Number For You Which Want To Search\n1: To Search By Ticket Number \n2: To Search By Customer Name ");
			int choice = obj.nextInt();

			if (choice == 1) {
				Node curr =front;
				System.out.println("Enter Ticket No For Which You Want Changes ");
				int tcktno = obj.nextInt();
				while (curr != null) {
					if (curr.data.ticketNo == tcktno) {
						System.out.println(curr.data);
						curr = curr.next;
					} else {
						curr = curr.next;
					}

				}
				boolean b = check_ticket(tcktno);
				if (b == false) {
					System.out.println("NO Ticket Found Against That Number");
				}

			} else if (choice == 2) {
				Node curr = front;
				System.out.println("Enter Name Which You Want To Search ");
				String n = obj.next();

				while (curr != null) {
					if (curr.data.name.equalsIgnoreCase(n)) {
						System.out.println(curr.data);
						curr = curr.next;
					} else {
						curr = curr.next;
					}
				}

				boolean b = check_name(n);
				if (b == false) {
					System.out.println("No Ticket Found Against That Name");
				}

			}

		}
	}

	public boolean check_ticket(int ticketno) {
		Node curr = front;
		while (curr != null) {
			if (curr.data.ticketNo == ticketno) {
				return true;
			} else {
				curr = curr.next;
			}

		}
		return false;
	}

	public boolean check_name(String n) {
		Node curr = front;
		while (curr != null) {
			if (curr.data.name.equalsIgnoreCase(n)) {
				return true;
			} else {
				curr = curr.next;
			}

		}
		return false;
	}

	public static void displayWelcomePage() {
		System.out.println("******************************************************");
		System.out.println("*                  Welcome to Shandar Cinema         *");
		System.out.println("*                Your Adventure Awaits Here!         *");
		System.out.println("******************************************************");
		System.out.println("*                                                    *");
		System.out.println("*    🎉 Get ready for a cinematic journey! 🎬        *");
		System.out.println("*    🍿 Grab your popcorn and enjoy the show!        *");
		System.out.println("*    🌟 Shandar Cinema - Where Dreams Shine!         *");
		System.out.println("*                                                    *");
		System.out.println("******************************************************");
		System.out.println();
	}

}
