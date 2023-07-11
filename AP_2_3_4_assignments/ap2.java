//Skip to content
//Search or jump to…
//Pull requests
//Issues
//Marketplace
//Explore
// 
//@ABHISHEKJoker1613Panda 
//ABHISHEKJoker1613Panda
///
//AP_Assignment_1
//Public
//1
//00
//Code
//Issues
//Pull requests
//Actions
//Projects
//Wiki
//Security
//Insights
//Settings
//AP_Assignment_1/src/AP.java /
//@ABHISHEKJoker1613Panda
//ABHISHEKJoker1613Panda Add files via upload
//…
//Latest commit d6e36fa 4 days ago
// History
// 1 contributor
//739 lines (710 sloc)  24 KB
//   
package ap;
import java.util.*;
import java.io.*;
//github
class Vaccine
{
	String vname;
	int no_doses,gap;
	
	Vaccine(String name, int no_doses,int gap)
	{
		this.vname=name;
		this.no_doses=no_doses;
		this.gap=gap;
	}
	public static void display_v(Vaccine v)
	{
		System.out.println("\nVaccine Added->");
		System.out.println("\nName: "+ v.vname);
		System.out.println("\nNo. of Doses: "+v.no_doses);
		System.out.println("\nGap B/w Doses: "+v.gap+"\n");
	}
}

class Hospital
{
	
	String hname;
	int pincode;
	int h_UID;
	
	Hospital(String name,int pin,int UID)
	{
		this.hname=name;
		this.pincode=pin;
		this.h_UID=UID;
	}
	
	public static void display_h(Hospital h)
	{
		System.out.println("\nHospital Added->");
		System.out.println("\nName: "+ h.hname);
		System.out.println("\nPincode: "+h.pincode);
		System.out.println("\nUnique ID of Hospital: "+h.h_UID+"\n");
	}
}

class Citizen
{
	String c_name;
	int age;
	String c_UID;
	String Vaccination_Status;
	int dosesgiven;
	String Vaccine_given;
	int due_date;
	
	Citizen(String name, int age,String UID)
	{
		this.c_name=name;
		this.age=age;
		this.c_UID=UID;
		this.Vaccination_Status="Registered";
		this.dosesgiven=-1;
		this.Vaccine_given=null;
		this.due_date=-1;
	}
	
	public static void display_c(Citizen c)
	{
		System.out.println("\nCitizen Added->");
		System.out.println("\nName: "+ c.c_name);
		System.out.println("\nAge: "+c.age);
		System.out.println("\nUnique ID of Citizen: "+c.c_UID+"\n");
	}
}

class Slotsforvaccine
{
	String slot_hname;
	int slot_day;
	int quantity;
	int hos_UID;
	String Vac_name;
	int hosp_Pincode;
	
	Slotsforvaccine(String hname,int UID,int day,int q,String vname,int pin)
	{
		this.hos_UID=UID;
		this.quantity=q;
		this.slot_day=day;
		this.slot_hname=hname;
		this.Vac_name=vname;
		this.hosp_Pincode=pin;
	}
	
	public static void display_slot(Slotsforvaccine slot)
	{
		System.out.print("\nSlot Added for->");
		System.out.print("\nVaccine : "+slot.Vac_name);
		System.out.print("\nHospital : "+slot.slot_hname);
		System.out.print("\nAt Day : "+slot.slot_day);
		System.out.println("\tQuantity : "+slot.quantity+"\n");
	}
}

public class ap2 {
	static int Hospital_UID=100000; //this will be used to generate Unique ID for hospitals
	static ArrayList<Vaccine> Detail_Vacc = new ArrayList<>();
	static ArrayList<Hospital> Detail_Hosp = new ArrayList<>();
	static ArrayList<Citizen> Detail_Citizen = new ArrayList<>();
	static ArrayList<Slotsforvaccine> Detail_SlotVaccine = new ArrayList<>();
	
	public static boolean search_citizenUID(ArrayList<Citizen> c,String U)
	{
		for(int i=0;i<c.size();i++)
		{
			if((c.get(i).c_UID).equals(U))
			{
				return true;
			}
		}
		return false;
	}
	
	public static int getposcitizen(ArrayList<Citizen> c,String U)
	{
		int k=-1;
		for(int i=0;i<c.size();i++)
		{
			if((c.get(i).c_UID).equals(U))
			{
				k=i;
			}
		}
		return k;
	}
	
	public static void getvaccinationstatus(ArrayList<Citizen> c,String U)
	{
		for(int i=0;i<c.size();i++)
		{
			if((c.get(i).c_UID).equals(U))
			{
				 System.out.println("\nCitizen Name: "+c.get(i).c_name);
				 System.out.println("\nVaccineation Status: "+c.get(i).Vaccination_Status);
				 System.out.println("\nVaccine Name: "+c.get(i).Vaccine_given);
				 System.out.println("\nDoses of Vaccine Given: "+c.get(i).dosesgiven);
				 System.out.println("\nNext Dose Due Date: "+c.get(i).due_date);
			}
		}
	}
	
	public static boolean search_hospitalUID(ArrayList<Hospital> h,int U)
	{
		for(int i=0;i<h.size();i++)
		{
			if((h.get(i).h_UID) == (U))
			{
				return true;
			}
		}
		return false;
	}
	
	public static String gethospitalname(ArrayList<Hospital> h,int U)
	{
		for(int i=0;i<h.size();i++)
		{
			if((h.get(i).h_UID) == (U))
			{
				return (h.get(i).hname);
			}
		}
		return "NotFound";
	}
	
	public static int gethospitalpincode(ArrayList<Hospital> h,int U)
	{
		for(int i=0;i<h.size();i++)
		{
			if((h.get(i).h_UID) == (U))
			{
				return (h.get(i).pincode);
			}
		}
		return -1;
	}
	
	public static boolean search_vaccinename(ArrayList<Vaccine> va,String vac)
	{
		for(int i=0;i<va.size();i++)
		{
			if((va.get(i).vname).equals(vac))
			{
				return true;
			}
		}
		return false;
	}
	
	public static int getvaccinepos(ArrayList<Vaccine> va,String vac)
	{
		int k=-1;
		for(int i=0;i<va.size();i++)
		{
			if((va.get(i).vname).equals(vac))
			{
				k=i;
			}
		}
		return k;
	}
	
	public static void main(String[] args)
	{
		System.out.println("~~~~~ CoWin Portal Initialized ~~~~~");
		System.out.println("\n--------------------------------------------------");
		Scanner scn = new Scanner(System.in);
		int choice;
		System.out.println("\n1. Add Vaccine\n2. Register Hospital\n3. Register Citizen\n4. Add Slot for Vaccination\n5. Book Slot for Vaccination\n6. List all slots for a hospital\n7. Check Vaccination Status\n8. Exit\n");
		System.out.println("\nEnter the Choice: ");
		choice=scn.nextInt();
		while(choice!=8)
		{
			if(choice==1)
			{
				System.out.println("\nVaccine Name:");
				String name=scn.next();
				while(true)
				{
					System.out.println("\nNumber of Doses of Vaccine:");
					int doses=scn.nextInt();
					if(doses<=0)
					{
						System.out.println("\nInvalid Number of Doses.Please enter Valid number of Doses.");
					}
					else if(doses==1)
					{
						Vaccine v=new Vaccine(name,doses,0);
						Detail_Vacc.add(v);
						v.display_v(v);
						System.out.println("\nVaccine Registered.");
						break;
					}
					else
					{
						System.out.println("\nGap between two Dose of Vaccine:");
						int gap=scn.nextInt();
						Vaccine v=new Vaccine(name,doses,gap);
						Detail_Vacc.add(v);
						v.display_v(v);
						System.out.println("\nVaccine Registered.");
						break;
					}
				}
			}
			else if(choice==2)
			{
				System.out.println("\nHospital Name:");
				String h_name=scn.next();
				int pincode;
				while(true)
				{
					System.out.println("\nEnter Pincode of Hospital(6-digits and not starting with 0):");
					pincode=scn.nextInt();
					int t=pincode;int size=0;
					while(t!=0)
					{
						t=t/10;
						size++;
					}
					if(size==6)
					{
						break;
					}
					else
					{
						System.out.println("\nWrong type of Pincode entered.");
					}
				}
				//hospital add
				Hospital_UID=Hospital_UID+1;
				Hospital h=new Hospital(h_name,pincode,Hospital_UID);
				Detail_Hosp.add(h);
				h.display_h(h);
				System.out.println("\nHospital Registered.");
			}
			else if(choice==3)
			{
				System.out.println("\nCitizen Name:");
				String c_name=scn.next();
				System.out.println("\nEnter Citizen Age:");
				int c_age=scn.nextInt();
				if(c_age>=18)
				{
					while(true)
					{
						System.out.println("\nCitizen Unique ID:");
						String UID=scn.next();
						if((!(UID.chars().allMatch(Character::isDigit))) && (UID.length() !=12) && (!(search_citizenUID(Detail_Citizen,UID))))
						{
							System.out.println("\nThis UID already already exist/Not of 12 Digits/It consists of alphanumeric instead of only numeric. PLease enter valid one.");
							continue;
						}
						else
						{
							Citizen c=new Citizen(c_name,c_age,UID);
							Detail_Citizen.add(c);
							c.display_c(c);
							System.out.println("\nCitizen Registered.");
							break;
						}	
					}
				}
				else
				{
					System.out.println("\nOnly above 18 allowed\n");
				}
			}
			else if(choice==4)
			{
				while(true)
				{
					System.out.println("\nEnter the Hospital's UID:");
					int ID=scn.nextInt();
					if(search_hospitalUID(Detail_Hosp,ID))
					{
						System.out.println("\nEnter the number slots to be added:");
						int slot=scn.nextInt();
						for(int i=0;i<slot;i++)
						{
							System.out.println("\nEnter Day Number:");
							int d=scn.nextInt();
							System.out.println("\nEnter Quantity:");
							int q=scn.nextInt();
							
							while(true)
							{
								System.out.println("\nEnter name of Vaccine:");
								String v_name=scn.next();
								if(search_vaccinename(Detail_Vacc,v_name))
								{
									String hos_name=gethospitalname(Detail_Hosp,ID);
									int pinc=gethospitalpincode(Detail_Hosp,ID);
									Slotsforvaccine s=new Slotsforvaccine(hos_name,ID,d,q,v_name,pinc);
									Detail_SlotVaccine.add(s);
									s.display_slot(s);
									System.out.println("\nSlot Added for a vaccine"+v_name);
									break;
								}
								else
								{
									System.out.println("\nWrong vaccine name given.");
								}
							}
						}
						break;
					}
					else
					{
						System.out.println("\nWrong Hospital UID entered.");
					}
				}
			}
			else if(choice==5)
			{
					System.out.println("\nEnter UID of Citizen:");
					String UID=scn.next();
					
					if((UID.chars().allMatch(Character::isDigit)) && (UID.length() == 12) && (search_citizenUID(Detail_Citizen,UID)))
					{
						if((Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).Vaccination_Status).equals("Fully Vaccinated"))
						{
							System.out.println("\nCitizen is Already Vaccinated.");
							break;
						}
						else if((Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).Vaccination_Status).equals("Partially Vaccinated"))
						{
							int due_day=Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).due_date;
							String vaccine_name=Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).Vaccine_given;
							while(true)
							{
								System.out.println("\nDo you want to search Slot by:\n 1. Pincode\n 2. Vaccine\n 3. EXIT");
								int ch=scn.nextInt();
								if(ch==1)
								{
									System.out.println("\nEnter Pincode:");
									int pinc=scn.nextInt();
									int flag=0;
									ArrayList<Integer> l1=new ArrayList<>();
									ArrayList<Integer> A1=new ArrayList<>();
									System.out.println("\nHospital's Available->\n");
									for(int i=0;i<Detail_SlotVaccine.size();i++)
									{
										if(Detail_SlotVaccine.get(i).hosp_Pincode == pinc)
										{
											System.out.println("Hospital UID: "+Detail_SlotVaccine.get(i).hos_UID+"\tHospital Name: "+Detail_SlotVaccine.get(i).slot_hname);
											l1.add(i);
											flag++;
										}
									}
									if(flag==0)
									{
										System.out.println("\n No Hospital with entered Pincode has Vaccine Slots.");
									}
									else
									{
										System.out.println("\nEnter Hospital UID: ");
										int id=scn.nextInt();
										int flag2=0;
										for(int j=0;j<l1.size();j++)
										{
											if((Detail_SlotVaccine.get(l1.get(j)).hos_UID == id) && (Detail_SlotVaccine.get(l1.get(j)).Vac_name).equals(vaccine_name) && (Detail_SlotVaccine.get(l1.get(j)).slot_day >= due_day))
											{
												System.out.println(l1.get(j)+" ->\tDay: "+Detail_SlotVaccine.get(l1.get(j)).slot_day+"\tAvl. Quantity: "+Detail_SlotVaccine.get(l1.get(j)).quantity+"\tVaccine Avl.: "+Detail_SlotVaccine.get(l1.get(j)).Vac_name);
												A1.add(l1.get(j));
												flag2++;
											}
										}
										if(flag2==0)
										{
											System.out.println("\n No Hospital with entered UID has Vaccine Slot for You.");
										}
										else
										{
											System.out.println("\nEnter Your Choice of Slot: ");
											int choi=scn.nextInt();
											for(int a=0;a<A1.size();a++)
											{
												if(choi==A1.get(a))
												{
													System.out.println((Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).c_name)+" is Vaccinated By "+vaccine_name);
													Detail_SlotVaccine.get(choi).quantity=Detail_SlotVaccine.get(choi).quantity-1;
													Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).Vaccine_given=vaccine_name;
													if((Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).dosesgiven) == (Detail_Vacc.get(getvaccinepos(Detail_Vacc,vaccine_name)).no_doses))
													{
														Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).Vaccination_Status="Fully Vaccinated";
														Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).due_date=10000000;
													}
													else
													{
														(Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).dosesgiven)=(Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).dosesgiven)+1;
														(Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).due_date)=(Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).due_date)+(Detail_Vacc.get(getvaccinepos(Detail_Vacc,vaccine_name)).gap);
													}
												}
											}
										}
									}
									
									break;
								}
								else if(ch==2)
								{
									System.out.println("\nEnter Vaccine Name:");
									String vnam=scn.next();
									int flag=0;
									ArrayList<Integer> l1=new ArrayList<>();
									ArrayList<Integer> A1=new ArrayList<>();
									System.out.println("\nHospital's Available->\n");
									for(int i=0;i<Detail_SlotVaccine.size();i++)
									{
										if((Detail_SlotVaccine.get(i).Vac_name).equals(vnam))
										{
											System.out.println("Hospital UID: "+Detail_SlotVaccine.get(i).hos_UID+"\tHospital Name: "+Detail_SlotVaccine.get(i).slot_hname);
											l1.add(i);
											flag++;
										}
									}
									if(flag==0)
									{
										System.out.println("\n No Hospital with entered Vaccine Name has Vaccine Slots.");
									}
									else
									{
										System.out.println("\nEnter Hospital UID: ");
										int id=scn.nextInt();
										int flag2=0;
										for(int j=0;j<l1.size();j++)
										{
											if((Detail_SlotVaccine.get(l1.get(j)).hos_UID == id) && (Detail_SlotVaccine.get(l1.get(j)).Vac_name).equals(vaccine_name) && (Detail_SlotVaccine.get(l1.get(j)).slot_day >= due_day))
											{
												System.out.println(l1.get(j)+" ->\tDay: "+Detail_SlotVaccine.get(l1.get(j)).slot_day+"\tAvl. Quantity: "+Detail_SlotVaccine.get(l1.get(j)).quantity+"\tVaccine Avl.: "+Detail_SlotVaccine.get(l1.get(j)).Vac_name);
												A1.add(l1.get(j));
												flag2++;
											}
										}
										if(flag2==0)
										{
											System.out.println("\n No Hospital with entered UID has Vaccine Slot for You.");
										}
										else
										{
											System.out.println("\nEnter Your Choice of Slot: ");
											int choi=scn.nextInt();
											for(int a=0;a<A1.size();a++)
											{
												if(choi==A1.get(a))
												{
													System.out.println((Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).c_name)+" is Vaccinated By "+vaccine_name);
													Detail_SlotVaccine.get(choi).quantity=Detail_SlotVaccine.get(choi).quantity-1;
													Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).Vaccine_given=vaccine_name;
													if((Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).dosesgiven) == (Detail_Vacc.get(getvaccinepos(Detail_Vacc,vaccine_name)).no_doses))
													{
														Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).Vaccination_Status="Fully Vaccinated";
														Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).due_date=10000000;
													}
													else
													{
														(Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).dosesgiven)=(Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).dosesgiven)+1;
														(Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).due_date)=(Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).due_date)+(Detail_Vacc.get(getvaccinepos(Detail_Vacc,vaccine_name)).gap);
													}
												}
											}
										}
									}
									break;
								}
								else
								{
									System.out.println("\nEXIT.");
									break;
								}
							}
						}
						else if((Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).Vaccination_Status).equals("Registered"))
						{
							while(true)
							{
								System.out.println("\nDo you want to search Slot by:\n 1. Pincode\n 2. Vaccine\n 3. EXIT");
								int ch=scn.nextInt();
								if(ch==1)
								{
									System.out.println("\nEnter Pincode:");
									int pinc=scn.nextInt();
									int flag=0;
									ArrayList<Integer> l1=new ArrayList<>();
									ArrayList<Integer> A1=new ArrayList<>();
									System.out.println("\nHospital's Available->\n");
									for(int i=0;i<Detail_SlotVaccine.size();i++)
									{
										if(Detail_SlotVaccine.get(i).hosp_Pincode == pinc)
										{
											System.out.println("Hospital UID: "+Detail_SlotVaccine.get(i).hos_UID+"\tHospital Name: "+Detail_SlotVaccine.get(i).slot_hname);
											l1.add(i);
											flag++;
										}
									}
									if(flag==0)
									{
										System.out.println("\n No Hospital with entered Pincode has Vaccine Slots.");
									}
									else
									{
										System.out.println("\nEnter Hospital UID: ");
										int id=scn.nextInt();
										int flag2=0;
										for(int j=0;j<l1.size();j++)
										{
											if((Detail_SlotVaccine.get(l1.get(j)).hos_UID == id))
											{
												System.out.println(l1.get(j)+" ->\tDay: "+Detail_SlotVaccine.get(l1.get(j)).slot_day+"\tAvl. Quantity: "+Detail_SlotVaccine.get(l1.get(j)).quantity+"\tVaccine Avl.: "+Detail_SlotVaccine.get(l1.get(j)).Vac_name);
												A1.add(l1.get(j));
												flag2++;
											}
										}
										if(flag2==0)
										{
											System.out.println("\n No Hospital with entered UID has Vaccine Slot for You.");
										}
										else
										{
											System.out.println("\nEnter Your Choice of Slot: ");
											int choi=scn.nextInt();
											
											for(int a=0;a<A1.size();a++)
											{
												if(choi==A1.get(a))
												{
													String vaccine_name=Detail_SlotVaccine.get(choi).Vac_name;
													System.out.println((Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).c_name)+" is Vaccinated By "+vaccine_name);
													Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).Vaccine_given=vaccine_name;
													Detail_SlotVaccine.get(choi).quantity=Detail_SlotVaccine.get(choi).quantity-1;
													if(Detail_Vacc.get(getvaccinepos(Detail_Vacc,vaccine_name)).no_doses == 1)
													{
														Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).Vaccination_Status="Fully Vaccinated";
														Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).due_date=10000000;
													}
													else
													{
														Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).Vaccination_Status="Partially Vaccinated";
														(Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).dosesgiven)=1;
														(Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).due_date)=(Detail_Vacc.get(getvaccinepos(Detail_Vacc,vaccine_name)).gap);
													}
												}
											}
										}
									}
									
									break;
								}
								else if(ch==2)
								{
									System.out.println("\nEnter Vaccine Name:");
									String vnam=scn.next();
									int flag=0;
									ArrayList<Integer> l1=new ArrayList<>();
									ArrayList<Integer> A1=new ArrayList<>();
									System.out.println("\nHospital's Available->\n");
									for(int i=0;i<Detail_SlotVaccine.size();i++)
									{
										if((Detail_SlotVaccine.get(i).Vac_name).equals(vnam))
										{
											System.out.println("Hospital UID: "+Detail_SlotVaccine.get(i).hos_UID+"\tHospital Name: "+Detail_SlotVaccine.get(i).slot_hname);
											l1.add(i);
											flag++;
										}
									}
									if(flag==0)
									{
										System.out.println("\n No Hospital with entered Vaccine Name has Vaccine Slots.");
									}
									else
									{
										System.out.println("\nEnter Hospital UID: ");
										int id=scn.nextInt();
										int flag2=0;
										for(int j=0;j<l1.size();j++)
										{
											if((Detail_SlotVaccine.get(l1.get(j)).hos_UID == id))
											{
												System.out.println(l1.get(j)+" ->\tDay: "+Detail_SlotVaccine.get(l1.get(j)).slot_day+"\tAvl. Quantity: "+Detail_SlotVaccine.get(l1.get(j)).quantity+"\tVaccine Avl.: "+Detail_SlotVaccine.get(l1.get(j)).Vac_name);
												A1.add(l1.get(j));
												flag2++;
											}
										}
										if(flag2==0)
										{
											System.out.println("\n No Hospital with entered UID has Vaccine Slot for You.");
										}
										else
										{
											System.out.println("\nEnter Your Choice of Slot: ");
											int choi=scn.nextInt();
											for(int a=0;a<A1.size();a++)
											{
												if(choi==A1.get(a))
												{
													String vaccine_name=Detail_SlotVaccine.get(choi).Vac_name;
													System.out.println((Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).c_name)+" is Vaccinated By "+vaccine_name);
													Detail_SlotVaccine.get(choi).quantity=Detail_SlotVaccine.get(choi).quantity-1;
													Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).Vaccine_given=vaccine_name;
													if((Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).dosesgiven) == (Detail_Vacc.get(getvaccinepos(Detail_Vacc,vaccine_name)).no_doses))
													{
														Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).Vaccination_Status="Fully Vaccinated";
														Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).due_date=10000000;
													}
													else
													{
														(Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).dosesgiven)=(Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).dosesgiven)+1;
														(Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).due_date)=(Detail_Citizen.get(getposcitizen(Detail_Citizen,UID)).due_date)+(Detail_Vacc.get(getvaccinepos(Detail_Vacc,vaccine_name)).gap);
													}
												}
											}
										}
									}
									break;
								}
								else
								{
									System.out.println("\nEXIT.");
									break;
								}
							}
						}
					}
					else
					{
						System.out.println("\nWrong Citizen UID entered/UID not present. Kindly Enter Again!!");
					}
			}
			else if(choice==6)
			{
				while(true)
				{
					System.out.println("\nEnter UID of Hospital:");
					int UID=scn.nextInt();
					if(search_hospitalUID(Detail_Hosp,UID))
					{
						System.out.println("\nVaccines Available at Hospital with ID: "+UID+" and Hospital Name: "+gethospitalname(Detail_Hosp,UID));
						for(int i=0;i<Detail_SlotVaccine.size();i++)
						{
							if(Detail_SlotVaccine.get(i).hos_UID==UID)
							{
								System.out.println("\nDay: "+Detail_SlotVaccine.get(i).slot_day);
								System.out.println("Vaccine: "+Detail_SlotVaccine.get(i).Vac_name);
								System.out.println("Quantity: "+Detail_SlotVaccine.get(i).quantity);
							}
						}
						
						break;
					}
					else
					{
						System.out.println("\nWrong Hospital UID given. Please Enter Again.");
					}
				}
			}
			else if(choice==7)
			{
				while(true)
				{
					System.out.println("\nEnter UID of Citizen:");
					String UID=scn.next();
					if((UID.chars().allMatch(Character::isDigit)) && (UID.length() == 12) && (search_citizenUID(Detail_Citizen,UID)))
					{
						System.out.println("\n Vaccination Status->");
						getvaccinationstatus(Detail_Citizen,UID);
						break;
					}
					else
					{
						System.out.println("\nWrong Citizen UID entered/UID not present. Kindly Enter Again!!");
					}
				}
			}
			else
			{
				System.out.println("\nWrong Choice Entered. Kindly, Enter Again!!\n");
			}
			
			System.out.println("\n--------------------------------------------------");
			System.out.println("\n1. Add Vaccine\n2. Register Hospital\n3. Register Citizen\n4. Add Slot for Vaccination\n5. Book Slot for Vaccination\n6. List all slots for a hospital\n7. Check Vaccination Status\n8. Exit\n");
			System.out.println("\nEnter the Choice:");
			choice=scn.nextInt();
		}
		System.out.println("\nExited The Portal\n\nThanks For Visiting!!\n");
	}
}
//© 2021 GitHub, Inc.
//Terms
//Privacy
//Security
//Status
//Docs
//Contact GitHub
//Pricing
//API
//Training
//Blog
//About
