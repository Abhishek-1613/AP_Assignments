package ap;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

interface submit
{
	public void view_grade(student_sub s,String g);
	public void give_grade(student_sub s,int g,String ins);
}

class student_sub implements submit
{
	String submission=null;
	String student;
	String sub_status="not submitted";
	int ID_assess;
	private int grade;
	private String graded_by;
	String grading_status="ungraded";

	student_sub(String sub,String stu,int ass)
	{
		this.ID_assess=ass;
		this.student=stu;
		this.submission=sub;
		this.sub_status="submitted";
	}
	
	
	@Override
	public void give_grade(student_sub s,int g,String ins)
	{
		s.grade=g;
		s.graded_by=ins;
		s.grading_status="graded";
	}

	@Override
	public void view_grade(student_sub s,String g) {
		if(g.equals("graded"))
		{
			System.out.println("\nSubmission: "+s.submission);
			System.out.println("Marks scored: "+s.grade);
			System.out.println("Graded By: "+s.graded_by);
		}
		else if(g.equals("ungraded"))
		{
			System.out.println("\nSubmission: "+s.submission);
		}
	}
	
}

interface Assessments
{
	public void view_assignment(Assess a);
	public void view_quiz(Assess a);
	public void close_assessments(Assess a);
	public int get_assessID(Assess a);
	public String get_ques(Assess a);
}

class Assess implements Assessments
{
	private int ID;
	String type;
	String current_state="open";
	private String ques;
	int max_marks;
	Assess(String type,String ques,int mark,int ID)
	{
		this.max_marks=mark;
		this.ques=ques;
		this.type=type;
		this.ID=ID;
	}
	
	Assess(String type,String ques,int ID)
	{
		this.max_marks=1;
		this.ques=ques;
		this.type=type;
		this.ID=ID;
	}
	
	@Override
	public void view_assignment(Assess a) {
		System.out.println("\nID:"+a.ID);
		System.out.println("Assignment: "+a.ques);
		System.out.println("Max Marks: "+a.max_marks);
		System.out.println("--------------------");
	}

	@Override
	public void view_quiz(Assess a) {
		System.out.println("\nID:"+a.ID);
		System.out.println("Quiz Question: "+a.ques);
		System.out.println("--------------------");
	}

	@Override
	public void close_assessments(Assess a) {
		a.current_state="close";
		System.out.println("Assessment with ID "+a.ID+" is closed\n");
	}
	


	@Override
	public int get_assessID(Assess a) {
		return a.ID;
	}
	
	@Override
	public String get_ques(Assess a) {
		return a.ques;
	}
	
}

interface Lecture
{
	public void view_Lectureslides(lec a);
	public void view_Lecturevideo(lec a);
}

class lec implements Lecture
{
	String type;
	private String Title;
	private ArrayList<String> sld=new ArrayList<>();
	private int no_of_slides;
	private String Date_upload;
	private String Up_by;
	private String file;
	lec(String type,String title,int n,ArrayList<String> s,String d,String u)
	{
		this.no_of_slides=n;
		this.Title=title;
		this.type=type;
		this.sld=s;
		this.Date_upload=d;
		this.Up_by=u;
	}
	lec(String type,String title,String name,String d,String u)
	{
		this.file=name;
		this.Title=title;
		this.type=type;
		this.Date_upload=d;
		this.Up_by=u;
	}
	@Override
	public void view_Lectureslides(lec a) {
		System.out.println("\nTitle:"+a.Title);
		for(int i=0;i<a.sld.size();i++)
		{
			System.out.println("Slide "+i+":"+a.sld.get(i));
		}
		System.out.println("No. Of Slides: "+a.no_of_slides);
		System.out.println("Uploaded on: "+a.Date_upload);
		System.out.println("Uploaded by: "+a.Up_by);
	}

	@Override
	public void view_Lecturevideo(lec a) {
		System.out.println("\nTitle of Video: "+a.Title);
		System.out.println("Video File: "+a.file);
		System.out.println("Uploaded on: "+a.Date_upload);
		System.out.println("Uploaded by: "+a.Up_by);
	}

}

class comments
{
	private String com;
	private String up_by;
	private String up_on;
	comments(String c,String upb,String upo)
	{
		this.com=c;
		this.up_by=upb;
		this.up_on=upo;
	}
	public void view_comments(comments a)
	{
		System.out.println("\n"+a.com);
		System.out.println("by - "+a.up_by);
		System.out.println(a.up_on+"\n");
	}
}

public class ap2_backpack_demo {
	public static int Assess_id=0;
	public static ArrayList<Assess> A=new ArrayList<>();
	public static ArrayList<lec> L=new ArrayList<>();
	public static ArrayList<comments> C=new ArrayList<>();
	public static ArrayList<student_sub> S=new ArrayList<>();
	
	public static boolean getsubmissionstatus(Assess a,String stu_name)
	{
		int Id=a.get_assessID((a));
		for(int i=0;i<S.size();i++)
		{
			if(S.get(i).ID_assess == Id && (S.get(i).student.equals(stu_name)) && !(S.get(i).submission.equals(null)))
			{
				return false;
			}
		}
		return true;
	}

	public static String getfilename()
	{
		Scanner str=new Scanner(System.in);
		while(true)
		{
			System.out.println("\nEnter Filename of Video");
			String f=str.nextLine();
			if((f.substring(f.length()-4)).equals(".mp4"))
			{
				return f;
			}
			else
			{
				System.out.println("Video file is not of .mp4 extention. Enter again");
			}
		}
	}
	
	public static String getname()
	{
		Scanner str=new Scanner(System.in);
		System.out.println("\nEnter name:");
		String f=str.nextLine();
		return f;
	}
	
	public static String getsubmission(int Id)
	{
		Scanner str=new Scanner(System.in);
		for(int i=0;i<A.size();i++)
		{
			if(A.get(i).get_assessID(A.get(i))==Id)
			{
				if(A.get(i).type.equals("Assignment"))
				{
					while(true)
					{
						System.out.println("\nEnter Filename of Submission");
						String f=str.nextLine();
						if((f.substring(f.length()-4)).equals(".zip"))
						{
							return f;
						}
						else
						{
							System.out.println("Submission file is not of .zip extention. Enter again");
						}
					}
				}
				else if(A.get(i).type.equals("Quiz"))
				{
					System.out.println("\n"+A.get(i).get_ques(A.get(i)));
					System.out.println("Enter one word answer:");
					String f=str.next();
					return f;
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		final String[] Instructor= {"I0","I1"};
		final String[] Student= {"S0","S1","S2"};
		Scanner scn=new Scanner(System.in);
		
		System.out.println("Welcome To Backpack");
		System.out.println("1. Enter As Instructor\n2. Enter As Student\n3. Exit");
		int choice=Integer.parseInt(scn.nextLine());
		while(true)
		{
			if(choice==1)
			{
				System.out.println("\nInstructors:");
				for(int i=0;i<2;i++)
				{
					System.out.println(i+" - "+Instructor[i]);
				}
				System.out.println("Choose ID:");
				int id=Integer.parseInt(scn.nextLine());
				if(id==0)
				{
					System.out.println("\nWelcome "+Instructor[id]);
					System.out.println("INSTRUCTOR MENU");
					System.out.println("1. Add class material\r\n"
							+ "2. Add assessments\r\n"
							+ "3. View lecture materials\r\n"
							+ "4. View assessments\r\n"
							+ "5. Grade assessments\r\n"
							+ "6. Close assessment\r\n"
							+ "7. View comments\r\n"
							+ "8. Add comments\r\n"
							+ "9. Logout");
					System.out.println("Enter Choice:");
					int ch=Integer.parseInt(scn.nextLine());
					while(true)
					{
						if(ch==1)
						{
							System.out.println("1. Add Lecture Slide\n2. Add Lecture Video");
							int a=Integer.parseInt(scn.nextLine());
							if(a==1)
							{
								Scanner str=new Scanner(System.in);
								System.out.println("\nEnter the topic of Slide");
								String t="";
								t+=str.nextLine();
								System.out.println("\nEnter no. of Slide");
								int n=Integer.parseInt(scn.nextLine());
								ArrayList<String> con=new ArrayList<>();
								System.out.println("Enter contents of slides");
								for(int j=0;j<n;j++)
								{
									System.out.println("Content of slide "+j+" :");
									String cn=str.nextLine();
									con.add(cn);
								}
								SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
								Date date = new Date();
								String sdate = dateFormat.format(date); 
								Lecture Lec=new lec("Slide",t,n,con,sdate,Instructor[id]);
								L.add((lec) Lec);
							}
							else if(a==2)
							{
								Scanner str=new Scanner(System.in);
								System.out.println("\nEnter the topic of Video");
								String t="";
								t+=str.nextLine();
								
								String name=getfilename();
								SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
								Date date = new Date();
								String sdate = dateFormat.format(date); 
								Lecture Lec=new lec("Video",t,name,sdate,Instructor[id]);
								L.add((lec) Lec);
							}
						}
						else if(ch==2)
						{
							System.out.println("1. Add Assignment\n2. Add Quiz");
							int a=Integer.parseInt(scn.nextLine());
							if(a==1)
							{
								Scanner str=new Scanner(System.in);
								System.out.println("Enter Problem Statement:");
								String p="";
								p+=str.nextLine();
								System.out.println("Enter Max marks:");
								int m=Integer.parseInt(scn.nextLine());
								Assessments ass=new Assess("Assignment",p,m,Assess_id++);
								A.add((Assess) ass);
							}
							else if(a==2)
							{
								Scanner str=new Scanner(System.in);
								System.out.println("Enter quiz question:");
								String p="";
								p+=str.nextLine();
								Assessments ass=new Assess("Quiz",p,Assess_id++);
								A.add((Assess) ass);
							}
						}
						else if(ch==3)
						{
							for(int i=0;i<L.size();i++)
							{
								if((L.get(i).type).equals("Slide"))
								{
									L.get(i).view_Lectureslides(L.get(i));
								}
								if((L.get(i).type).equals("Video"))
								{
									L.get(i).view_Lecturevideo(L.get(i));
								}
							}
						}
						else if(ch==4)
						{
							for(int i=0;i<A.size();i++)
							{
								if((A.get(i).type).equals("Assignment"))
								{
									A.get(i).view_assignment(A.get(i));
								}
								if((A.get(i).type).equals("Quiz"))
								{
									A.get(i).view_quiz(A.get(i));
								}
							}
						}
						else if(ch==5)
						{
							System.out.println("List of Assessments:");
							for(int i=0;i<A.size();i++)
							{
								if((A.get(i).type).equals("Assignment"))
								{
									A.get(i).view_assignment(A.get(i));
								}
								if((A.get(i).type).equals("Quiz"))
								{
									A.get(i).view_quiz(A.get(i));
								}
							}
							System.out.println("Enter ID of Assessments to view submission:");
							int ases_ID=Integer.parseInt(scn.nextLine());
							System.out.println("Choose Name of Student from these ungraded submissions");
							for(int k=0;k<S.size();k++)
							{
								if((S.get(k).ID_assess==ases_ID) && (S.get(k).grading_status).equals("ungraded"))
								{
									System.out.println(S.get(k).student);
								}
							}
							String nam=getname();
							int flag=-1;
							for(int k=0;k<S.size();k++)
							{
								if((S.get(k).ID_assess==ases_ID) && (S.get(k).grading_status).equals("ungraded") && (S.get(k).student.equals(nam)))
								{
									System.out.println("\nSubmission: "+S.get(k).submission);
									flag=k;
								}
							}
							if(flag!=-1)
							{
								System.out.println("Max Marks: "+A.get(ases_ID).max_marks);
								System.out.println("Enter marks you want to give:");
								int mark=Integer.parseInt(scn.nextLine());
								S.get(flag).give_grade(S.get(flag),mark, "I0");
							}
						}
						else if(ch==6)
						{
							System.out.println("List of Open Assessments:-");
							for(int i=0;i<A.size();i++)
							{
								if((A.get(i).current_state).equals("open"))
								{
									A.get(i).view_assignment(A.get(i));
								}
							}
							System.out.println("Enter ID of Assessment to close:");
							int Id=Integer.parseInt(scn.nextLine());
							A.get(Id).close_assessments(A.get(Id));
						}
						else if(ch==7)
						{
							System.out.println("Viewing Comments:-");
							for(int k=0;k<C.size();k++)
							{
								C.get(k).view_comments(C.get(k));
							}
						}
						else if(ch==8)
						{
							Scanner str=new Scanner(System.in);
							System.out.println("Enter Comment:");
							String s=str.nextLine();
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							Date date = new Date();
							String sdate = dateFormat.format(date);
							comments c=new comments(s,Instructor[id],sdate);
							C.add(c);
						}
						else if(ch==9)
						{
							System.out.println("\nLogging Out.");
							break;
						}
						else
						{
							System.out.println("\nWrong Choice. Enter again!!");
						}
						
						System.out.println("\nWelcome "+Instructor[id]);
						System.out.println("INSTRUCTOR MENU");
						System.out.println("1. Add class material\r\n"
								+ "2. Add assessments\r\n"
								+ "3. View lecture materials\r\n"
								+ "4. View assessments\r\n"
								+ "5. Grade assessments\r\n"
								+ "6. Close assessment\r\n"
								+ "7. View comments\r\n"
								+ "8. Add comments\r\n"
								+ "9. Logout");
						System.out.println("Enter Choice:");
						ch=Integer.parseInt(scn.nextLine());
					}
				}
				else if(id==1)
				{
					System.out.println("\nWelcome "+Instructor[id]);
					System.out.println("INSTRUCTOR MENU");
					System.out.println("1. Add class material\r\n"
							+ "2. Add assessments\r\n"
							+ "3. View lecture materials\r\n"
							+ "4. View assessments\r\n"
							+ "5. Grade assessments\r\n"
							+ "6. Close assessment\r\n"
							+ "7. View comments\r\n"
							+ "8. Add comments\r\n"
							+ "9. Logout");
					System.out.println("Enter Choice:");
					int ch=Integer.parseInt(scn.nextLine());
					while(true)
					{
						if(ch==1)
						{
							System.out.println("1. Add Lecture Slide\n2. Add Lecture Video");
							int a=Integer.parseInt(scn.nextLine());
							if(a==1)
							{
								Scanner str=new Scanner(System.in);
								System.out.println("\nEnter the topic of Slide");
								String t="";
								t+=str.nextLine();
								System.out.println("\nEnter no. of Slide");
								int n=Integer.parseInt(scn.nextLine());
								ArrayList<String> con=new ArrayList<>();
								System.out.println("Enter contents of slides");
								for(int j=0;j<n;j++)
								{
									System.out.println("Content of slide "+j+" :");
									String cn=str.nextLine();
									con.add(cn);
								}
								SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
								Date date = new Date();
								String sdate = dateFormat.format(date); 
								Lecture Lec=new lec("Slide",t,n,con,sdate,Instructor[id]);
								L.add((lec) Lec);
							}
							else if(a==2)
							{
								Scanner str=new Scanner(System.in);
								System.out.println("\nEnter the topic of Video");
								String t="";
								t+=str.nextLine();
								
								String name=getfilename();
								SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
								Date date = new Date();
								String sdate = dateFormat.format(date); 
								Lecture Lec=new lec("Video",t,name,sdate,Instructor[id]);
								L.add((lec) Lec);
							}
						}
						else if(ch==2)
						{
							System.out.println("1. Add Assignment\n2. Add Quiz");
							int a=Integer.parseInt(scn.nextLine());
							if(a==1)
							{
								Scanner str=new Scanner(System.in);
								System.out.println("Enter Problem Statement:");
								String p="";
								p+=str.nextLine();
								System.out.println("Enter Max marks:");
								int m=Integer.parseInt(scn.nextLine());
								Assessments ass=new Assess("Assignment",p,m,Assess_id++);
								A.add((Assess) ass);
							}
							else if(a==2)
							{
								Scanner str=new Scanner(System.in);
								System.out.println("Enter quiz question:");
								String p="";
								p+=str.nextLine();
								Assessments ass=new Assess("Quiz",p,Assess_id++);
								A.add((Assess) ass);
							}
						}
						else if(ch==3)
						{
							for(int i=0;i<L.size();i++)
							{
								if((L.get(i).type).equals("Slide"))
								{
									L.get(i).view_Lectureslides(L.get(i));
								}
								if((L.get(i).type).equals("Video"))
								{
									L.get(i).view_Lecturevideo(L.get(i));
								}
							}
						}
						else if(ch==4)
						{
							for(int i=0;i<A.size();i++)
							{
								if((A.get(i).type).equals("Assignment"))
								{
									A.get(i).view_assignment(A.get(i));
								}
								if((A.get(i).type).equals("Quiz"))
								{
									A.get(i).view_quiz(A.get(i));
								}
							}
						}
						else if(ch==5)
						{
							System.out.println("List of Assessments:");
							for(int i=0;i<A.size();i++)
							{
								if((A.get(i).type).equals("Assignment"))
								{
									A.get(i).view_assignment(A.get(i));
								}
								if((A.get(i).type).equals("Quiz"))
								{
									A.get(i).view_quiz(A.get(i));
								}
							}
							System.out.println("Enter ID of Assessments to view submission:");
							int ases_ID=Integer.parseInt(scn.nextLine());
							System.out.println("Choose Name of Student from these ungraded submissions");
							for(int k=0;k<S.size();k++)
							{
								if((S.get(k).ID_assess==ases_ID) && (S.get(k).grading_status).equals("ungraded"))
								{
									System.out.println(S.get(k).student);
								}
							}
							String nam=getname();
							int flag=-1;
							for(int k=0;k<S.size();k++)
							{
								if((S.get(k).ID_assess==ases_ID) && (S.get(k).grading_status).equals("ungraded")&& (S.get(k).student.equals(nam)))
								{
									System.out.println("\nSubmission: "+S.get(k).submission);
									flag=k;
								}
							}
							if(flag!=-1)
							{
								System.out.println("Max Marks: "+A.get(ases_ID).max_marks);
								System.out.println("Enter marks you want to give:");
								int mark=Integer.parseInt(scn.nextLine());
								S.get(flag).give_grade(S.get(flag),mark, "I1");
							}
						}
						else if(ch==6)
						{
							System.out.println("List of Open Assessments:-");
							for(int i=0;i<A.size();i++)
							{
								if((A.get(i).current_state).equals("open"))
								{
									A.get(i).view_assignment(A.get(i));
								}
							}
							System.out.println("Enter ID of Assessment to close:");
							int Id=Integer.parseInt(scn.nextLine());
							A.get(Id).close_assessments(A.get(Id));
						}
						else if(ch==7)
						{
							System.out.println("Viewing Comments:-");
							for(int k=0;k<C.size();k++)
							{
								C.get(k).view_comments(C.get(k));
							}
						}
						else if(ch==8)
						{
							Scanner str=new Scanner(System.in);
							System.out.println("Enter Comment:");
							String s=str.nextLine();
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							Date date = new Date();
							String sdate = dateFormat.format(date);
							comments c=new comments(s,Instructor[id],sdate);
							C.add(c);
						}
						else if(ch==9)
						{
							System.out.println("\nLogging Out.");
							break;
						}
						else
						{
							System.out.println("\nWrong Choice. Enter again!!");
						}
						
						System.out.println("\nWelcome "+Instructor[id]);
						System.out.println("INSTRUCTOR MENU");
						System.out.println("1. Add class material\r\n"
								+ "2. Add assessments\r\n"
								+ "3. View lecture materials\r\n"
								+ "4. View assessments\r\n"
								+ "5. Grade assessments\r\n"
								+ "6. Close assessment\r\n"
								+ "7. View comments\r\n"
								+ "8. Add comments\r\n"
								+ "9. Logout");
						System.out.println("Enter Choice:");
						ch=Integer.parseInt(scn.nextLine());
					}
				}
			}
			else if(choice==2)
			{
				System.out.println("\nStudent:");
				for(int i=0;i<3;i++)
				{
					System.out.println(i+" - "+Student[i]);
				}
				System.out.println("Choose ID:");
				int id=Integer.parseInt(scn.nextLine());
				if(id==0)
				{
					System.out.println("\nWelcome "+Student[id]);
					System.out.println("Student MENU");
					System.out.println("1. View lecture materials\r\n"
							+ "2. View assessments\r\n"
							+ "3. Submit assessment\r\n"
							+ "4. View grades\r\n"
							+ "5. View comments\r\n"
							+ "6. Add comments\r\n"
							+ "7. Logout");
					System.out.println("Enter Choice:");
					int ch=Integer.parseInt(scn.nextLine());
					while(true)
					{
						if(ch==1)
						{
							for(int i=0;i<L.size();i++)
							{
								if((L.get(i).type).equals("Slide"))
								{
									L.get(i).view_Lectureslides(L.get(i));
								}
								if((L.get(i).type).equals("Video"))
								{
									L.get(i).view_Lecturevideo(L.get(i));
								}
							}
						}
						else if(ch==2)
						{
							for(int i=0;i<A.size();i++)
							{
								if((A.get(i).type).equals("Assignment"))
								{
									A.get(i).view_assignment(A.get(i));
								}
								if((A.get(i).type).equals("Quiz"))
								{
									A.get(i).view_quiz(A.get(i));
								}
							}
						}
						else if(ch==3)
						{
							int flag=0;
							System.out.println("List of Pending Assessments:-");
							for(int i=0;i<A.size();i++)
							{
								if((A.get(i).current_state).equals("open") && (getsubmissionstatus(A.get(i),"S0")))
								{
									flag++;
									A.get(i).view_assignment(A.get(i));
								}
							}
							if(flag!=0)
							{
								System.out.println("Enter ID of Assessment to submit:");
								int Id=Integer.parseInt(scn.nextLine());
								String f=getsubmission(Id);
								submit s=new student_sub(f,"S0",Id);
								S.add((student_sub) s);
							}
							else
								System.out.println("No pending assessments.");
						}
						else if(ch==4)
						{
							System.out.println("\nGraded Submissions\n");
							for(int k=0;k<S.size();k++)
							{
								if(S.get(k).student.equals("S0") && S.get(k).grading_status.equals("graded"))
								{
									S.get(k).view_grade(S.get(k),"graded");
								}
							}
							
							System.out.println("\nUngraded Submissions\n");
							for(int k=0;k<S.size();k++)
							{
								if(S.get(k).student.equals("S0") && S.get(k).grading_status.equals("ungraded"))
								{
									S.get(k).view_grade(S.get(k),"ungraded");
								}
							}
						}
						else if(ch==5)
						{
							System.out.println("Viewing Comments:-");
							for(int k=0;k<C.size();k++)
							{
								C.get(k).view_comments(C.get(k));
							}
						}
						else if(ch==6)
						{
							Scanner str=new Scanner(System.in);
							System.out.println("Enter Comment:");
							String s=str.nextLine();
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							Date date = new Date();
							String sdate = dateFormat.format(date);
							comments c=new comments(s,Student[id],sdate);
							C.add(c);
						}
						else if(ch==7)
						{
							System.out.println("\nLogging Out "+Student[id]);
							break;
						}
						else
						{
							System.out.println("\nWrong Choice. Enter again!!");
						}
						
						System.out.println("\nWelcome "+Student[id]);
						System.out.println("Student MENU");
						System.out.println("1. View lecture materials\r\n"
								+ "2. View assessments\r\n"
								+ "3. Submit assessment\r\n"
								+ "4. View grades\r\n"
								+ "5. View comments\r\n"
								+ "6. Add comments\r\n"
								+ "7. Logout");
						System.out.println("Enter Choice:");
						ch=Integer.parseInt(scn.nextLine());
					}
				}
				else if(id==1)
				{
					System.out.println("\nWelcome "+Student[id]);
					System.out.println("Student MENU");
					System.out.println("1. View lecture materials\r\n"
							+ "2. View assessments\r\n"
							+ "3. Submit assessment\r\n"
							+ "4. View grades\r\n"
							+ "5. View comments\r\n"
							+ "6. Add comments\r\n"
							+ "7. Logout");
					System.out.println("Enter Choice:");
					int ch=Integer.parseInt(scn.nextLine());
					while(true)
					{
						if(ch==1)
						{
							for(int i=0;i<L.size();i++)
							{
								if((L.get(i).type).equals("Slide"))
								{
									L.get(i).view_Lectureslides(L.get(i));
								}
								if((L.get(i).type).equals("Video"))
								{
									L.get(i).view_Lecturevideo(L.get(i));
								}
							}
						}
						else if(ch==2)
						{
							for(int i=0;i<A.size();i++)
							{
								if((A.get(i).type).equals("Assignment"))
								{
									A.get(i).view_assignment(A.get(i));
								}
								if((A.get(i).type).equals("Quiz"))
								{
									A.get(i).view_quiz(A.get(i));
								}
							}
						}
						else if(ch==3)
						{
							int flag=0;
							System.out.println("List of Pending Assessments:-");
							for(int i=0;i<A.size();i++)
							{
								if((A.get(i).current_state).equals("open") && (getsubmissionstatus(A.get(i),"S1")))
								{
									flag++;
									A.get(i).view_assignment(A.get(i));
								}
							}
							if(flag!=0)
							{
								System.out.println("Enter ID of Assessment to submit:");
								int Id=Integer.parseInt(scn.nextLine());
								String f=getsubmission(Id);
								submit s=new student_sub(f,"S1",Id);
								S.add((student_sub) s);
							}
							else
								System.out.println("No pending assessments.");
						}
						else if(ch==4)
						{
							System.out.println("\nGraded Submissions\n");
							for(int k=0;k<S.size();k++)
							{
								if(S.get(k).student.equals("S1") && S.get(k).grading_status.equals("graded"))
								{
									S.get(k).view_grade(S.get(k),"graded");
								}
							}
							
							System.out.println("\nUngraded Submissions\n");
							for(int k=0;k<S.size();k++)
							{
								if(S.get(k).student.equals("S1") && S.get(k).grading_status.equals("ungraded"))
								{
									S.get(k).view_grade(S.get(k),"ungraded");
								}
							}
						}
						else if(ch==5)
						{
							System.out.println("Viewing Comments:-");
							for(int k=0;k<C.size();k++)
							{
								C.get(k).view_comments(C.get(k));
							}
						}
						else if(ch==6)
						{
							Scanner str=new Scanner(System.in);
							System.out.println("Enter Comment:");
							String s=str.nextLine();
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							Date date = new Date();
							String sdate = dateFormat.format(date);
							comments c=new comments(s,Student[id],sdate);
							C.add(c);
						}
						else if(ch==7)
						{
							System.out.println("\nLogging Out "+Student[id]);
							break;
						}
						else
						{
							System.out.println("\nWrong Choice. Enter again!!");
						}
						
						System.out.println("\nWelcome "+Student[id]);
						System.out.println("Student MENU");
						System.out.println("1. View lecture materials\r\n"
								+ "2. View assessments\r\n"
								+ "3. Submit assessment\r\n"
								+ "4. View grades\r\n"
								+ "5. View comments\r\n"
								+ "6. Add comments\r\n"
								+ "7. Logout");
						System.out.println("Enter Choice:");
						ch=Integer.parseInt(scn.nextLine());
					}
				}
				else if(id==2)
				{
					System.out.println("\nWelcome "+Student[id]);
					System.out.println("Student MENU");
					System.out.println("1. View lecture materials\r\n"
							+ "2. View assessments\r\n"
							+ "3. Submit assessment\r\n"
							+ "4. View grades\r\n"
							+ "5. View comments\r\n"
							+ "6. Add comments\r\n"
							+ "7. Logout");
					System.out.println("Enter Choice:");
					int ch=Integer.parseInt(scn.nextLine());
					while(true)
					{
						if(ch==1)
						{
							for(int i=0;i<L.size();i++)
							{
								if((L.get(i).type).equals("Slide"))
								{
									L.get(i).view_Lectureslides(L.get(i));
								}
								if((L.get(i).type).equals("Video"))
								{
									L.get(i).view_Lecturevideo(L.get(i));
								}
							}
						}
						else if(ch==2)
						{
							for(int i=0;i<A.size();i++)
							{
								if((A.get(i).type).equals("Assignment"))
								{
									A.get(i).view_assignment(A.get(i));
								}
								if((A.get(i).type).equals("Quiz"))
								{
									A.get(i).view_quiz(A.get(i));
								}
							}
						}
						else if(ch==3)
						{
							int flag=0;
							System.out.println("List of Pending Assessments:-");
							for(int i=0;i<A.size();i++)
							{
								if((A.get(i).current_state).equals("open") && (getsubmissionstatus(A.get(i),"S2")))
								{
									flag++;
									A.get(i).view_assignment(A.get(i));
								}
							}
							if(flag!=0)
							{
								System.out.println("Enter ID of Assessment to submit:");
								int Id=Integer.parseInt(scn.nextLine());
								String f=getsubmission(Id);
								submit s=new student_sub(f,"S2",Id);
								S.add((student_sub) s);
							}
							else
								System.out.println("No pending assessments.");
						}
						else if(ch==4)
						{
							System.out.println("\nGraded Submissions\n");
							for(int k=0;k<S.size();k++)
							{
								if(S.get(k).student.equals("S2") && S.get(k).grading_status.equals("graded"))
								{
									S.get(k).view_grade(S.get(k),"graded");
								}
							}
							
							System.out.println("\nUngraded Submissions\n");
							for(int k=0;k<S.size();k++)
							{
								if(S.get(k).student.equals("S2") && S.get(k).grading_status.equals("ungraded"))
								{
									S.get(k).view_grade(S.get(k),"ungraded");
								}
							}
						}
						else if(ch==5)
						{
							System.out.println("Viewing Comments:-");
							for(int k=0;k<C.size();k++)
							{
								C.get(k).view_comments(C.get(k));
							}
						}
						else if(ch==6)
						{
							Scanner str=new Scanner(System.in);
							System.out.println("Enter Comment:");
							String s=str.nextLine();
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							Date date = new Date();
							String sdate = dateFormat.format(date);
							comments c=new comments(s,Student[id],sdate);
							C.add(c);
						}
						else if(ch==7)
						{
							System.out.println("\nLogging Out "+Student[id]);
							break;
						}
						else
						{
							System.out.println("\nWrong Choice. Enter again!!");
						}
						
						System.out.println("\nWelcome "+Student[id]);
						System.out.println("Student MENU");
						System.out.println("1. View lecture materials\r\n"
								+ "2. View assessments\r\n"
								+ "3. Submit assessment\r\n"
								+ "4. View grades\r\n"
								+ "5. View comments\r\n"
								+ "6. Add comments\r\n"
								+ "7. Logout");
						System.out.println("Enter Choice:");
						ch=Integer.parseInt(scn.nextLine());
					}
				}
			}
			else if(choice==3)
			{
				System.out.println("\nExiting Bagpack\n");
				break;
			}
			else
			{
				System.out.println("\nWrong Choice. Enter again!!");
			}
			System.out.println("\nWelcome To Backpack");
			System.out.println("1. Enter As Instructor\n2. Enter As Student\n3. Exit");
			choice=Integer.parseInt(scn.nextLine());
		}
	}

}
