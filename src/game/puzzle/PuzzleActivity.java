package game.puzzle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PuzzleActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	Button easy;
	Button normal;
	Button hard;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        easy=(Button)findViewById(R.id.easy);
        easy.setOnClickListener(this);
        normal=(Button)findViewById(R.id.normal);
        normal.setOnClickListener(this);
        hard=(Button)findViewById(R.id.hard);
        hard.setOnClickListener(this);
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.easy){
			BoardActivity.easy=1;
			BoardActivity.hard=0;
			BoardActivity.normal=0;
		}
		else if(v.getId()==R.id.normal){
			BoardActivity.normal=1;
			BoardActivity.easy=0;
			BoardActivity.hard=0;		
		}
		else if(v.getId()==R.id.hard){
			BoardActivity.hard=1;
			BoardActivity.normal=0;
			BoardActivity.easy=0;
		}
		Intent intent=new Intent(this, BoardActivity.class);
		startActivity(intent);
		
	}
}