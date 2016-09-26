package edu.niu.cs.z1717009.burgerqueen;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private RadioGroup pattyRadioGroup, cheeseRadioGroup;
    private CheckBox baconCheckBox;
    private SeekBar sauceSeekBar;
    private TextView caloriesTV;

    private Burger burger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create Burger Object
        burger = new Burger();

        //Connect variables and screen items
        pattyRadioGroup = (RadioGroup) findViewById(R.id.burgerPattyRGId);
        cheeseRadioGroup= (RadioGroup) findViewById(R.id.cheeseRGId);
        baconCheckBox = (CheckBox) findViewById(R.id.baconCheckBox);
        sauceSeekBar = (SeekBar) findViewById(R.id.sauceSeekBar);
        caloriesTV = (TextView) findViewById(R.id.caloriesOutTV);
        displayCalories();
        //set listeners

        pattyRadioGroup.setOnCheckedChangeListener( burgerListener );

        // CHEESE RADIO GROUP LISTENER
        cheeseRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.noCheeseRadio: burger.setCheeseCalories(0);break;
                    case R.id.mozzarellaRadio: burger.setCheeseCalories(Burger.MOZZARELLA);break;
                    case R.id.cheddarRadio: burger.setCheeseCalories(Burger.CHEDDAR);break;
                }
                displayCalories();
            }
        }); // On checked change Listener

        // BACON CHECK BOX LISTENER
        baconCheckBox.setOnClickListener( baconListener );

        // SEEK BAR LISTENER
        sauceSeekBar.setOnSeekBarChangeListener( sauceListener );


    }// On Create
// Listener for Patty radio button
    private RadioGroup.OnCheckedChangeListener burgerListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            //Log.d("Main Activity","Patty");
            switch (checkedId){
                case R.id.veggieRadio: burger.setPattyCalories(Burger.VEGGIE); break;
                case R.id.turkeyRadio: burger.setPattyCalories(Burger.TURKEY); break;
                case R.id.chickenRadio: burger.setPattyCalories(Burger.CHICKEN); break;
            }
            displayCalories();
        }
    };
// Listener for Bacon Check box
    private View.OnClickListener baconListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                burger.setBaconCalories(((CheckBox) v).isChecked());
                displayCalories();
        }
    };
// Listener for Seek bar
    private SeekBar.OnSeekBarChangeListener sauceListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            burger.setSauceCalories(seekBar.getProgress());
           // Log.d("Main Activity","Seek Bar"+progress);
            displayCalories();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    // Display calories
    public void displayCalories(){
        caloriesTV.setText("Calories : "+ burger.getCalories());
    }
}
