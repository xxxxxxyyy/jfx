package pojo;

import java.io.*;
import java.util.Scanner;

class Student14{
    public void cx(int num) throws IOException {
        File f=new File("d:"+File.separator+"实验14创建的.txt");
        FileReader filereader=new FileReader(f);
        LineNumberReader reader=new LineNumberReader(filereader);
        String txt=" ";
        int lines=0;
        while (txt!=null){
            lines++;
            txt =reader.readLine();
            if(lines==num)
                System.out.println("第"+num+"行的内容是"+txt+"\n");
            }
        }
        public void show() throws IOException {
            File f=new File("d:"+File.separator+"实验14创建的.txt");
            Reader r=new FileReader(f);
            char c[]=new char[(int) f.length()];
            int len =r.read(c);
            r.close();
            System.out.println(new String(c));
        }
        public void xhcx(String str) throws IOException {
            File f=new File("d:"+File.separator+"实验14创建的.txt");
            FileReader filereader=new FileReader(f);
            LineNumberReader reader=new LineNumberReader(filereader);
            String txt=" ";
            int lines=0;
                while (txt!=null){
                    lines++;
                    txt =reader.readLine();
                    if(txt!=null)
                    {
                        if(txt.indexOf(str)>=0)
                    {
                        System.out.println("学号为"+str+"的学生信息是"+txt+"\n");
                        break;
                    }
                        else
                            System.out.println("不存在");
                    }
                }
        }

    }

public class sy14 {
    public static void main(String[] args)throws Exception {
        File f=new File("d:"+File.separator+"实验14创建的.txt");
        Writer w=new FileWriter(f);
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        String Line=null;
        int i=0;
        while (true){

            i++;
            System.out.println("输入学生数据，结束输入over");
            Line=sc.nextLine();
            if(Line.equals("over"))
            {
                break;
            }
            sb.append(i+" ");
            sb.append(Line);
            sb.append("\r\n");
        }
        String s=sb.toString();
        w.write(s);
        w.close();
        Student14 st=new Student14();
        st.cx(1);
        st.show();
        st.xhcx("001");
    }
}
