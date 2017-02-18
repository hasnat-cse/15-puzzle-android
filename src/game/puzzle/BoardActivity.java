package game.puzzle;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BoardActivity extends Activity implements OnClickListener{
	Button but[]=new Button[9];
	Button newBoard;
	TextView finish,level,moves;
	String diff;
	private int arr[]=new int[9];
	public static int easy=0,normal=0,hard=0;
	private int allow=0,countmove=0,check=0;
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.board);
		finish=(TextView)findViewById(R.id.finish);
		level=(TextView)findViewById(R.id.level);
		moves=(TextView)findViewById(R.id.moves);
		moves.setText("Moves: "+Integer.toString(countmove));
		but[0]=(Button)findViewById(R.id.button1);
		but[0].setOnClickListener(this);
		but[1]=(Button)findViewById(R.id.button2);
		but[1].setOnClickListener(this);
		but[2]=(Button)findViewById(R.id.button3);
		but[2].setOnClickListener(this);
		but[3]=(Button)findViewById(R.id.button4);
		but[3].setOnClickListener(this);
		but[4]=(Button)findViewById(R.id.button5);
		but[4].setOnClickListener(this);
		but[5]=(Button)findViewById(R.id.button6);
		but[5].setOnClickListener(this);
		but[6]=(Button)findViewById(R.id.button7);
		but[6].setOnClickListener(this);
		but[7]=(Button)findViewById(R.id.button8);
		but[7].setOnClickListener(this);
		but[8]=(Button)findViewById(R.id.button9);
		but[8].setOnClickListener(this);
		newBoard=(Button)findViewById(R.id.newBoard);
		newBoard.setOnClickListener(this);
		SetButton();
		levelShow();
		
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int i,j;
        for(int k=0;k<9;k++)
            if(v.getId()==but[k].getId()&&allow==0)
            {
                i=k/3;
                j=k%3;
                if(((String) but[k].getText()).compareTo("")!=0)
                {
                    if(i!=0&&((String) but[k-3].getText()).compareTo("")==0)
                    {
                        swap(k,k-3);
                    }
                    else if(i!=2&&((String) but[k+3].getText()).compareTo("")==0)
                    {
                        swap(k,k+3);
                    }
                    else if(j!=0&&((String) but[k-1].getText()).compareTo("")==0)
                    {
                        swap(k,k-1);
                    }
                    else if(j!=2&&((String) but[k+1].getText()).compareTo("")==0)
                    {
                        swap(k,k+1);
                    }
                }
            }
		if(v.getId()==R.id.newBoard){
			SetButton();
			finish.setText("");
			allow=0;
			countmove=0;
			moves.setText("Moves: "+Integer.toString(countmove));
		}
	}
	 public void levelShow()
	    {
	     if(easy==1)
	         {
	            diff="EASY";
	         }
	         else if(normal==1)
	         {
	             diff="NORMAL";
	         }
	         else if(hard==1)
	         {
	              diff="HARD";
	         }
	        level.setText(diff);
	     }
	 public void checkFinish(){
		 for(int k=0;k<8;k++)
	        {
	            if(((String) but[k].getText()).compareTo(Integer.toString(k+1))!=0)
	            {
	                check=1;
	                break;
	            }
	        }
	 }
	public void swap(int i,int j){
        String str1=(String) but[i].getText();
        String str2=(String) but[j].getText();
        but[i].setText(str2);
        but[j].setText(str1);
        countmove++;
        moves.setText("Moves: "+Integer.toString(countmove));
        check=0;
        checkFinish();
        if(check==0) 
        {
            finish.setText("Congratulations!   Total Moves: "+Integer.toString(countmove));
            allow=1;
        }
    }
	 public void Createrand3(){
         int x,a;
         Random randval=new Random();
         for(int i=0;i<9; )
         {
             x=randval.nextInt(9);
             a=0;
             for(int j=0;j<i;j++)
             {
                 if(arr[j]==x)
                 {
                     a=1;
                     break;
                 }
             }
             if(a==0)
             {
                 arr[i]=x;
                 i++;
             }
         }
         
     }
     public void Createrand2(){
         int x,a;
         Random randval=new Random();
         for(int k=0;k<2;k++)
             arr[k]=k+1;
         for(int i=2;i<9; )
         {
             x=randval.nextInt(9);
             a=0;
             for(int j=0;j<i;j++)
             {
                 if(arr[j]==x)
                 {
                     a=1;
                     break;
                 }
             }
             if(a==0)
             {
                 arr[i]=x;
                 i++;
             }
         }
         
     }
     public void Createrand1(){
         int x,a;
         Random randval=new Random();
         for(int k=0;k<4;k++)
             arr[k]=k+1;
         for(int i=4;i<9; )
         {
             x=randval.nextInt(9);
             a=0;
             for(int j=0;j<i;j++)
             {
                 if(arr[j]==x)
                 {
                     a=1;
                     break;
                 }
             }
             if(a==0)
             {
                 arr[i]=x;
                 i++;
             }
         }
         
     }
     public void SetButton(){
         if(easy==1)
         {
            Createrand1();
         }
         else if(normal==1)
         {
             Createrand2();
         }
         else if(hard==1)
         {
             Createrand3();
         }
       for(int k=0;k<9;k++)
       {
              if(arr[k]!=0)
              {
                String str=new String(Integer.toString(arr[k]));
                but[k].setText(str);
              }
              else but[k].setText("");
              if(((String) but[k].getText()).compareTo("")==0);
         }
       check=0;
       checkFinish();
       if(check==0){
      	 SetButton();
       }
     }

}
