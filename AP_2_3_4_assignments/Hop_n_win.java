package ap;
import java.util.*;
import java.io.*;

class Generic_Calculator<T>
{
	T obj1;
	T obj2;
	Generic_Calculator(T a,T b)
	{
		this.obj1=a;
		this.obj2=b;
	}

	@SuppressWarnings("unchecked")
	public T calculate(T a,T b)
	{
		if(a instanceof Integer)
		{
			return(T)new Integer(((Integer) a).intValue() / ((Integer) b).intValue());
		}
		else if(a instanceof String)
		{
			return(T)new String(((String) a) + ((String) b));
		}
		else
		{
			throw new IllegalArgumentException("Type "+a.getClass()+" is not supported by this method");
		}
	}
}

class Hop_generator
{
	private int value;
	Hop_generator(){}
	protected int roll(int num) {
		Random r=new Random();
		value=(1+r.nextInt(num));
		return value;
	}
}

class Random_number_string_generator extends Hop_generator
{
	Random_number_string_generator(){}
	protected String random_string()
	{
		int l=97,h=122;
		int l1=65,h1=90;
		Random r = new Random();
		StringBuffer s=new StringBuffer(4);
		for(int a=0;a<4;a++)
		{
			int nextrandchar=l+ (int)(r.nextFloat()*(h-l+1));
			s.append((char)nextrandchar);
		}
		return s.toString();
	}
}

class Carpet_Soft_Toy implements Cloneable
{
	private String name;
	Carpet_Soft_Toy(String n)
	{
		this.name=n;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	protected String get_name(Carpet_Soft_Toy s)
	{
		return s.name;
	}
}

class Players
{
	private ArrayList<String> T =new ArrayList<>();
	Players()
	{}
	protected void add_toy(String s)
	{
		T.add(s);
	}
	protected String get_toy(int i)
	{
		return T.get(i);
	}
	protected int getsize()
	{
		return T.size();
	}
}

public class Hop_n_win
{
	static ArrayList<Carpet_Soft_Toy> Toy = new ArrayList<>();
	static String[] Array= {"Surprise","Teddy Bear","Dog","Jerry","Flash","Duckie","Minion","Iron_Man","Spiderman","Venom","Panda","Buzz Lightyear","Antauri","Tom","Green Lantern","Hawkeye","Shazam","Black Bolt","Ghost Rider","Mickey Mouse","Loki"};
	
	private static void add_toy(int n)
	{
		Carpet_Soft_Toy s=new Carpet_Soft_Toy(Array[n]);
		Toy.add(s);
	}
	
	public static void main(String[] args) throws ClassNotFoundException,IllegalArgumentException,IOException,InputMismatchException,CloneNotSupportedException
	{
		Players p=new Players();
		Hop_generator h=new Hop_generator();
		Random_number_string_generator ra=new Random_number_string_generator();
		for(int i=0;i<21;i++)
		{
			add_toy(i);
		}
		Scanner scn=new Scanner(System.in);
		Scanner str=new Scanner(System.in);
		
		while(true)
		{
			try {
			System.out.println("\nEnter 1 to start the game: ");
			int ch=scn.nextInt();
			if(ch==1)
			{
				System.out.println("Game is Ready!!");
				for(int i=1;i<=5;i++)
				{
					while(true)
					{
						try {
						System.out.println("\nEnter 1 for your hop number "+i);
						int c=scn.nextInt();
						if(c==1)
						{
							int tile=h.roll(25);
							
							if(tile>20)
							{
								System.out.println("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!\n");
								break;
							}
							if(tile%2==0)
							{
								System.out.println("\nYou landed on tile "+tile);
								Carpet_Soft_Toy cl=(Carpet_Soft_Toy) Toy.get(tile).clone();
								System.out.println("You won a "+cl.get_name(cl)+" soft toy");
								p.add_toy(cl.get_name(cl));
							}
							else
							{
								System.out.println("\nYou landed on tile "+tile);
								while(true)
								{
									try {
									System.out.println("Question answer round: \"integer\" or \"string\" ?");
									String sr=str.nextLine();
									if(sr.equals("integer"))
									{
										int i1=ra.roll(5000);
										int i2=ra.roll(4000);
										System.out.println("Calculate the result of "+i1+" divided by "+i2);
										int res=scn.nextInt();
										Generic_Calculator<Integer> cal=new Generic_Calculator<>(i1,i2);
										int res2=(int) cal.calculate(cal.obj1, cal.obj2);
										if(res==res2)
										{
											System.out.println("Correct answer");
											Carpet_Soft_Toy cl=(Carpet_Soft_Toy) Toy.get(tile).clone();
											System.out.println("You won a "+cl.get_name(cl)+" soft toy");
											p.add_toy(cl.get_name(cl));
										}
										else
										{
											System.out.println("Incorrect answer\r\n"
													+ "You did not win any soft toy");
										}
									}
									else if(sr.equals("string"))
									{
										String s1=ra.random_string();
										String s2=ra.random_string();
										System.out.println("Calculate the concatination of string "+s1+" and "+s2);
										String res=str.nextLine();
										Generic_Calculator<String> cal=new Generic_Calculator<>(s1,s2);
										String res2=(String) cal.calculate(cal.obj1, cal.obj2);;
										if(res.equals(res2))
										{
											System.out.println("Correct answer");
											Carpet_Soft_Toy cl=(Carpet_Soft_Toy) Toy.get(tile).clone();
											System.out.println("You won a "+cl.get_name(cl)+" soft toy");
											p.add_toy(cl.get_name(cl));
										}
										else
										{
											System.out.println("Incorrect answer\r\n"
													+ "You did not win any soft toy");
										}
									}
									else
									{
										System.out.println("Invalid choice entered!!. Choose again!!");
										continue;
									}
									break;
								 }catch(Exception e)
									{
										System.out.println("Wrong Format, Try again!!");
										scn.nextLine();
									}
								}								
							}
							break;
						}
						else
						{
							System.out.println("Wrong Number Entered, you didn't hopped. Try Again!!");
						}
					  }catch(Exception e)
						{
							System.out.println("Enter Again in right format");
							scn.nextLine();
						}
					}
				}
				break;
			}
			else
			{
				System.out.println("Wrong Number Entered, Game didn't started. Try Again!!");
			}
		
		}catch(InputMismatchException e)
		{
			System.out.println("Enter Again in right format");
			scn.nextLine();
		}
	 }
		System.out.println("\nGame Over!!");
		System.out.println("Soft Toys You Won are: ");
		for(int a=0;a<p.getsize();a++)
		{
			System.out.print("\t"+p.get_toy(a)+"\n");
		}
	}
}
