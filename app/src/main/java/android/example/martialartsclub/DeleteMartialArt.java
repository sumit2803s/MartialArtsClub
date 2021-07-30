package android.example.martialartsclub;

import androidx.appcompat.app.AppCompatActivity;

import android.example.martialartsclub.Model.DatabaseHandler;
import android.example.martialartsclub.Model.MartialArt;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteMartialArt extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_martial_art);

        databaseHandler=new DatabaseHandler(DeleteMartialArt.this);

        updateThrUserInterface();


    }

    private void updateThrUserInterface() {

        ArrayList<MartialArt> allMartialArtObjects=databaseHandler.returnAllMartialArtObjects();
        RelativeLayout relativeLayout=new RelativeLayout(DeleteMartialArt.this);
        ScrollView scrollView=new ScrollView(DeleteMartialArt.this);
        RadioGroup radioGroup=new RadioGroup(DeleteMartialArt.this);

        for (MartialArt martialArt : allMartialArtObjects) {

            RadioButton currentradioButton=new RadioButton(DeleteMartialArt.this);
            currentradioButton.setId(martialArt.getMartialArtID());
            currentradioButton.setText(martialArt.toString());
            radioGroup.addView(currentradioButton);
        }

        radioGroup.setOnCheckedChangeListener(DeleteMartialArt.this);
        Button btnBack=new Button(DeleteMartialArt.this);
        btnBack.setText("Go Back");
        btnBack.setOnClickListener(DeleteMartialArt.this);

        scrollView.addView(radioGroup);

        RelativeLayout.LayoutParams buttonParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.setMargins(0,0,0,70);

        relativeLayout.addView(btnBack, buttonParams);

        ScrollView.LayoutParams scrollViewParam=new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT,ScrollView.LayoutParams.MATCH_PARENT);
        relativeLayout.addView(scrollView,scrollViewParam);
        setContentView(relativeLayout);
        updateThrUserInterface();








    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        databaseHandler.deleteMartialArtObjectFromDatabaseByID(checkedId);
        Toast.makeText(DeleteMartialArt.this,"the martial art object is deleted",Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onClick(View v) {
        finish();
    }
}