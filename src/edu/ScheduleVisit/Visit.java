/*
 * Name: Visit
 * Purpose: Allows the user to schedule a visit
 * Programmer: Aleksandar Serafimoski
 */
package edu.ScheduleVisit;
//Import internal libraries that we are using in this code

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import edu.HomeScreen.HomeScreen;
import edu.HomeScreen.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Visit extends SherlockActivity {
    //I store the textBoxes and Labels that we are validating
    int[] editTextIds = {R.id.txtName, R.id.txtLast, R.id.txtAddress, R.id.txtCity, R.id.txtZip, R.id.txtEmail, R.id.txtPhone, R.id.txtHighSchoolName, R.id.txtHSCity, R.id.txtGPA, R.id.txtMajor, R.id.txtExtra, R.id.txtAthletic, R.id.txtDepTime, R.id.txtCollegeGPA};
    int[] editTextViewIds = {R.id.nameText, R.id.lastText, R.id.addressText, R.id.cityText, R.id.zipText, R.id.textEmail, R.id.phoneText, R.id.HSText, R.id.HSCityText, R.id.gpaText, R.id.majorText, R.id.extraText, R.id.athleticText, R.id.depText, R.id.CollegeGpaTXT};

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.visit);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras(); // get passed parameters
        RadioButton AlmYes = (RadioButton) findViewById(R.id.radAlmYes);//reference to the Yes button in the Alumni section
        RadioButton AlmNo = (RadioButton) findViewById(R.id.radAlmNo);//reference to the No button in the Alumni section
        final Spinner state = (Spinner) findViewById(R.id.spnPerState);// reference to spinner for state selection
        String[] states = {"Choose a state ...", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
        final Spinner gender = (Spinner) findViewById(R.id.spnGender);// reference to spinner for gender selection
        String[] genders = {"Make your selection...", "Male", "Female"};
        final Spinner type = (Spinner) findViewById(R.id.spnType);// reference to spinner for student type selection
        String[] types = {"Make your selection...", "Freshman", "Transfer"};
        final Spinner HighSchoolState = (Spinner) findViewById(R.id.spnState);// reference to spinner for HS state selection
        String[] HSstates = {"Choose a state ...", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
        final Spinner GraduationYear = (Spinner) findViewById(R.id.spnGradYear);// reference to spinner for HS year graduation selection
        String[] gradYear = {"Make your selection...", "2012", "2013", "2014", "2015", "2016"};
        final Spinner Date = (Spinner) findViewById(R.id.spnDate);// reference to spinner for visit date selection
        String[] dates = {"Make your selection...", "3/5/2012", "3/6/2012", "3/7/2012", "3/8/2012", "3/9/2012", "3/12/2012", "3/13/2012", "3/14/2012", "3/15/2012", "3/16/2012", "3/19/2012", "3/20/2012", "3/21/2012", "3/22/2012", "3/23/2012", "3/26/2012", "3/27/2012", "3/28/2012", "3/29/2012", "3/30/2012", "4/2/2012", "4/3/2012", "4/4/2012", "4/10/2012", "/11/2012", "4/12/2012", "4/13/2012", "4/16/2012", "4/17/2012", "4/18/2012", "4/19/2012", "4/20/2012", "4/23/2012", "4/24/2012", "4/25/2012", "4/26/2012", "4/27/2012", "4/30/2012", "5/1/2012", "5/2/2012", "5/3/2012", "5/4/2012", "5/7/2012", "5/8/2012", "5/9/2012", "5/10/2012", "5/11/2012", "5/21/2012", "5/22/2012", "5/23/2012", "5/24/2012", "5/25/2012", "5/29/2012", "5/30/2012", "5/31/2012"};
        final Spinner Time = (Spinner) findViewById(R.id.spnTime);// reference to spinner for visit time selection
        String[] times = {"Make your selection...", "9:00am", "10:30am", "1:00pm", "3:00pm"};
        final Spinner Visitors = (Spinner) findViewById(R.id.spnVisitors);// reference to spinner for number of visitors selection
        String[] visitor = {"Make your selection...", "1", "2", "3", "4", "5+"};
        final Spinner RelationshipToStudent = (Spinner) findViewById(R.id.spnStudentRelationship);// reference to spinner for relationship to student selection
        String[] relationship = {"Make your selection...", "Parent", "Grandparent", "Step Parent", "Sibiling", "Step Sibiling", "Other"};
        final Spinner YearGraduatedLoras = (Spinner) findViewById(R.id.spnAttendedLoras);// reference to spinner for alumni graduation selection
        String[] alumYear = {"Make your selection...", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012"};
        final RadioGroup Present = (RadioGroup) findViewById(R.id.rdGrPresent);// reference to the radio group
        TextView AlumName = (TextView) findViewById(R.id.txtNameAlum);// reference to the name of the alumni
        AlmNo.setChecked(true);//Set the Alumni No button to checked
        // set the arrayAdapter for the state spinner
        ArrayAdapter<String> spinnerStateAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, states);
        spinnerStateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state.setAdapter(spinnerStateAdapter);

        // set the arrayAdapter for the student type spinner
        ArrayAdapter<String> spinnerTypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, types);
        spinnerTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(spinnerTypeAdapter);
        // set the arrayAdapter for the gender spinner
        ArrayAdapter<String> spinnerGenderAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genders);
        spinnerGenderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(spinnerGenderAdapter);
        // set the arrayAdapter for the HS State spinner
        ArrayAdapter<String> spinnerHSStateAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, HSstates);
        spinnerHSStateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        HighSchoolState.setAdapter(spinnerHSStateAdapter);
        // set the arrayAdapter for the graduation year spinner
        ArrayAdapter<String> spinnerGradAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gradYear);
        spinnerGradAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        GraduationYear.setAdapter(spinnerGradAdapter);
        // set the arrayAdapter for the visit date spinner
        ArrayAdapter<String> spinnerDateAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dates);
        spinnerDateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Date.setAdapter(spinnerDateAdapter);
        // set the arrayAdapter for the visit time spinner
        ArrayAdapter<String> spinnerTimeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, times);
        spinnerTimeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Time.setAdapter(spinnerTimeAdapter);
        // set the arrayAdapter for the number of visitors spinner
        ArrayAdapter<String> spinnerVisitorAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, visitor);
        spinnerVisitorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Visitors.setAdapter(spinnerVisitorAdapter);
        // set the arrayAdapter for the relationship of students spinner
        ArrayAdapter<String> spinnerRelationshipAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, relationship);
        spinnerRelationshipAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        RelationshipToStudent.setAdapter(spinnerRelationshipAdapter);
        // set the arrayAdapter for the alumni graduation year spinner
        ArrayAdapter<String> spinnerAlumYearAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, alumYear);
        spinnerAlumYearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        YearGraduatedLoras.setAdapter(spinnerAlumYearAdapter);

        if (bundle != null) // if bundle is carrying values, then the user has encountered errors when trying to submit the form
        {
            boolean[] validEditText = bundle.getBooleanArray("validEditText"); // contains boolean values indicating valid or invalid data entry
            String[] editTextEntries = bundle.getStringArray("editTextEntries"); // contains the entered values
            long[] spinnerInputs = bundle.getLongArray("inputs");  // store what state was selected
            boolean[] meetingopt = bundle.getBooleanArray("meeting");// stores the values of all of the check boxes

            checkEditText(validEditText, editTextEntries); // display the correct error messages for the EditText fields

            // chooses the appropriate pre-selected value for state
            if (spinnerInputs[0] != 0) // if "Choose a state ..." is selected, the user did not select one
            {
                state.setSelection((int) spinnerInputs[0]); // if they did select a state, select in the new spinner
            } else // else generate error message
            {
                TextView tempText = (TextView) findViewById(R.id.stateText);
                String field = tempText.getText().toString();
                tempText.setTextColor(Color.rgb(255, 0, 0));
                tempText.setTypeface(null, Typeface.BOLD_ITALIC);
                tempText.setText("** " + field + "\nSelection is required");

            }

            // chooses the appropriate pre-selected value for gender
            if (spinnerInputs[1] != 0) // if selected value was "Make your selection...", user did not select a gender
            {
                gender.setSelection((int) spinnerInputs[0]); // set initial selection to the gender selected
            } else // generates error message
            {
                TextView tempText = (TextView) findViewById(R.id.genderText);
                String field = tempText.getText().toString();
                tempText.setTextColor(Color.rgb(255, 0, 0));
                tempText.setTypeface(null, Typeface.BOLD_ITALIC);
                tempText.setText("** " + field + "\nSelection is required");


            }
            if (spinnerInputs[2] != 0) // if selected value was "Make your selection...", user did not select a type
            {
                type.setSelection((int) spinnerInputs[0]); // set initial selection to the type selected
            } else // generates error message
            {
                TextView tempText = (TextView) findViewById(R.id.typeText);
                String field = tempText.getText().toString();
                tempText.setTextColor(Color.rgb(255, 0, 0));
                tempText.setTypeface(null, Typeface.BOLD_ITALIC);
                tempText.setText("** " + field + "\nSelection is required");

            }
            if (spinnerInputs[3] != 0) // if selected value was "Choose a state ...", user did not select a state
            {
                HighSchoolState.setSelection((int) spinnerInputs[0]); // set initial selection to the state the user selected
            } else // genrates error message
            {
                TextView tempText = (TextView) findViewById(R.id.HSStateText);
                String field = tempText.getText().toString();
                tempText.setTextColor(Color.rgb(255, 0, 0));
                tempText.setTypeface(null, Typeface.BOLD_ITALIC);
                tempText.setText("** " + field + "\nSelection is required");

            }
            if (spinnerInputs[4] != 0) // if selected value was "Make your selection...", user did not select a year
            {
                GraduationYear.setSelection((int) spinnerInputs[0]); // set initial selection to the year the user selected
            } else // generates error message
            {
                TextView tempText = (TextView) findViewById(R.id.GradYearText);
                String field = tempText.getText().toString();
                tempText.setTextColor(Color.rgb(255, 0, 0));
                tempText.setTypeface(null, Typeface.BOLD_ITALIC);
                tempText.setText("** " + field + "\nSelection Year is required");

            }
            if (spinnerInputs[5] != 0) // if selected value was "Make your selection...", user did not select a date
            {
                Date.setSelection((int) spinnerInputs[0]); // set initial selection to the date the user selected
            } else // generates error message
            {
                TextView tempText = (TextView) findViewById(R.id.visitText);
                String field = tempText.getText().toString();
                tempText.setTextColor(Color.rgb(255, 0, 0));
                tempText.setTypeface(null, Typeface.BOLD_ITALIC);
                tempText.setText("** " + field + "\nSelection is required");

            }
            if (spinnerInputs[6] != 0) // if selected value was "Make your selection...", user did not select a time
            {
                Time.setSelection((int) spinnerInputs[0]);// set initial selection to the time the user selected
            } else // generates error message
            {
                TextView tempText = (TextView) findViewById(R.id.timeText);
                String field = tempText.getText().toString();
                tempText.setTextColor(Color.rgb(255, 0, 0));
                tempText.setTypeface(null, Typeface.BOLD_ITALIC);
                tempText.setText("** " + field + "\nSelection is required");

            }
            if (spinnerInputs[7] != 0) // if selected value was "Make your selection...", user did not select number of visitors
            {
                Visitors.setSelection((int) spinnerInputs[0]); // set initial selection to the number of visitors the user selected
            } else // generates error message
            {
                TextView tempText = (TextView) findViewById(R.id.visitorsText);
                String field = tempText.getText().toString();
                tempText.setTextColor(Color.rgb(255, 0, 0));
                tempText.setTypeface(null, Typeface.BOLD_ITALIC);
                tempText.setText("** " + field + "\nSelection is required");

            }
            if (meetingopt[4]) {//If the Alumni Yes button is selected we look at the inputs from the alumni section
                if (!Present.isSelected())//If the Present radio group doesn't have a selected value, we generate an error message
                {
                    TextView tempText = (TextView) findViewById(R.id.textView33);
                    String field = tempText.getText().toString();
                    tempText.setTextColor(Color.rgb(255, 0, 0));
                    tempText.setTypeface(null, Typeface.BOLD_ITALIC);
                    tempText.setText("** " + field + "\nSelection is required");
                }

                if (spinnerInputs[8] != 0) // if selected value was "Make your selection...", user did not select a relationship
                {
                    RelationshipToStudent.setSelection((int) spinnerInputs[0]); // set initial selection to the relationship the user selected
                } else // generates error message
                {
                    TextView tempText = (TextView) findViewById(R.id.relationshipText);
                    String field = tempText.getText().toString();
                    tempText.setTextColor(Color.rgb(255, 0, 0));
                    tempText.setTypeface(null, Typeface.BOLD_ITALIC);
                    tempText.setText("** " + field + "\nSelection is required");

                }
                if (AlumName.getText().toString().equals("")) // if the alumni name is empty, we generate error message
                {
                    TextView tempText = (TextView) findViewById(R.id.textView34);
                    String field = tempText.getText().toString();
                    tempText.setTextColor(Color.rgb(255, 0, 0));
                    tempText.setTypeface(null, Typeface.BOLD_ITALIC);
                    tempText.setText("** " + field + "\nField is required");

                }
                if (spinnerInputs[9] != 0) // if selected value was "Make your selection...", user did not select a graduation year
                {
                    YearGraduatedLoras.setSelection((int) spinnerInputs[0]); // set initial selection to the grad year the user selected
                }
            }
            //Reference to the check boxes in the xml file
            CheckBox opt1 = (CheckBox) findViewById(R.id.chkFaculty);
            CheckBox opt2 = (CheckBox) findViewById(R.id.chkLunch);
            CheckBox opt3 = (CheckBox) findViewById(R.id.chkTrdVisit);
            CheckBox opt4 = (CheckBox) findViewById(R.id.chkMeetWithCoach);
            //If the checkboxes were selected in the previous screen we select them in this screen too
            if (meetingopt[0] == true) {
                opt1.setChecked(true);
            }
            if (meetingopt[1] == true) {
                opt2.setChecked(true);
            }
            if (meetingopt[2] == true) {
                opt3.setChecked(true);
            }
            if (meetingopt[3] == true) {
                opt4.setChecked(true);
            }
            if (meetingopt[4] == true) {
                AlmNo.setChecked(false);
                AlmYes.setChecked(true);
            }
        }


        //Reference to the text views in the alumni section
        final TextView AlumniName = (TextView) findViewById(R.id.txtNameAlum);
        final TextView text1 = (TextView) findViewById(R.id.textView33);
        final TextView text2 = (TextView) findViewById(R.id.textView34);
        final TextView text3 = (TextView) findViewById(R.id.relationshipText);
        final TextView text4 = (TextView) findViewById(R.id.alumGradYearText);
        //If the alumni yes button is checked the alumni section is displayed
        if (AlmYes.isChecked()) {
            // TODO Auto-generated method stub
            RelationshipToStudent.setVisibility(0);
            Present.setVisibility(0);
            AlumniName.setVisibility(0);
            YearGraduatedLoras.setVisibility(0);
            text1.setVisibility(0);
            text2.setVisibility(0);
            text3.setVisibility(0);
            text4.setVisibility(0);
        }
        //When the alumni yes button is checked the alumni section is displayed
        AlmYes.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                RelationshipToStudent.setVisibility(0);
                Present.setVisibility(0);
                AlumniName.setVisibility(0);
                YearGraduatedLoras.setVisibility(0);
                text1.setVisibility(0);
                text2.setVisibility(0);
                text3.setVisibility(0);
                text4.setVisibility(0);
            }
        });
        //When the alumni no button is checked the alumni section is hidden
        AlmNo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                RelationshipToStudent.setVisibility(View.INVISIBLE);
                Present.setVisibility(View.INVISIBLE);
                AlumniName.setVisibility(View.INVISIBLE);
                YearGraduatedLoras.setVisibility(View.INVISIBLE);
                text1.setVisibility(View.INVISIBLE);
                text2.setVisibility(View.INVISIBLE);
                text3.setVisibility(View.INVISIBLE);
                text4.setVisibility(View.INVISIBLE);

            }
        });
        //When the submit button is clicked the send request method is called
        Button Submit = (Button) findViewById(R.id.btnSub);
        Submit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                sendRequest();
            }

        });
        //When the clear button is clicked the form is cleared
        Button Clear = (Button) findViewById(R.id.btnClear);
        Clear.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                finish();
                startActivity(new Intent(Visit.this, Visit.class));
            }

        });
    } // end of main code

    // executes when user clicks the submit button
    public void sendRequest() {

        boolean[] validEditText = new boolean[14]; // boolean array for valid or invalid indication for EditText
        String[] editTextEntries = new String[14]; // String array for EditText entries

        // initialize all entries to valid
        for (int i = 0; i < validEditText.length; i++) {
            validEditText[i] = true; // initialize all values to true
        }
        long[] inputs = new long[10];
        Spinner state = (Spinner) findViewById(R.id.spnPerState);// reference to spinner for state selection
        inputs[0] = state.getSelectedItemId();//stores the value in an array
        Spinner gender = (Spinner) findViewById(R.id.spnGender);// reference to spinner for gender selection
        inputs[1] = gender.getSelectedItemId();//stores the value in an array
        Spinner type = (Spinner) findViewById(R.id.spnType);// reference to spinner for student type selection
        inputs[2] = type.getSelectedItemId();//stores the value in an array
        Spinner HighSchoolState = (Spinner) findViewById(R.id.spnState);// reference to spinner for HS state selection
        inputs[3] = HighSchoolState.getSelectedItemId();//stores the value in an array
        Spinner GraduationYear = (Spinner) findViewById(R.id.spnGradYear);// reference to spinner for graduation year selection
        inputs[4] = GraduationYear.getSelectedItemId();//stores the value in an array
        Spinner Date = (Spinner) findViewById(R.id.spnDate);// reference to spinner for visit date selection
        inputs[5] = Date.getSelectedItemId();//stores the value in an array
        Spinner Time = (Spinner) findViewById(R.id.spnTime);// reference to spinner for visit time selection
        inputs[6] = Time.getSelectedItemId();//stores the value in an array
        Spinner Visitors = (Spinner) findViewById(R.id.spnVisitors);// reference to spinner for number of visitors selection
        inputs[7] = Visitors.getSelectedItemId();//stores the value in an array
        Spinner RelationshipToStudent = (Spinner) findViewById(R.id.spnStudentRelationship);// reference to spinner for relationship to student selection
        inputs[8] = RelationshipToStudent.getSelectedItemId();//stores the value in an array
        Spinner YearGraduatedLoras = (Spinner) findViewById(R.id.spnAttendedLoras);// reference to spinner for alumni year of attending Loras selection
        inputs[9] = YearGraduatedLoras.getSelectedItemId();//stores the value in an array


        // initilize state valid flag to true
        boolean stateValid = true;

        // if the value of the state spinner equals "Choose a state ..." user has not made a selection, so the field is invalid
        if (state.equals("Choose a state ...")) {
            stateValid = false;
        }

        // initialize gender valid flag to true
        boolean genderValid = true;

        // if the value of month spinner equals "Make your selection..." user has not made a selection, so field is invalid
        if (gender.equals("Make your selection...")) {
            genderValid = false;
        }
        // initialize student type valid flag to true
        boolean typeValid = true;

        // if the value of month spinner equals "Make your selection..." user has not made a selection, so field is invalid
        if (type.equals("Make your selection...")) {
            typeValid = false;
        }
        // initialize HS state valid flag to true
        boolean HighSchoolStateValid = true;

        // if the value of month spinner equals "Choose a state..." user has not made a selection, so field is invalid
        if (HighSchoolState.equals("Choose a state...")) {
            HighSchoolStateValid = false;
        }
        // initialize HS graduation year valid flag to true
        boolean HSGradValid = true;

        // if the value of month spinner equals "Choose a state..." user has not made a selection, so field is invalid
        if (GraduationYear.equals("Choose a state...")) {
            HSGradValid = false;
        }
        // initialize visit date valid flag to true
        boolean DateValid = true;

        // if the value of month spinner equals "Make your selection..." user has not made a selection, so field is invalid
        if (Date.equals("Make your selection...")) {
            DateValid = false;
        }
        // initialize visit time valid flag to true
        boolean TimeValid = true;

        // if the value of month spinner equals "Make your selection..." user has not made a selection, so field is invalid
        if (Time.equals("Make your selection...")) {
            TimeValid = false;
        }
        // initialize number of visitors valid flag to true
        boolean VisitorValid = true;

        // if the value of month spinner equals "Make your selection..." user has not made a selection, so field is invalid
        if (Visitors.equals("Make your selection...")) {
            VisitorValid = false;
        }
        //Reference to the Alumni Yes button
        RadioButton AlmYes = (RadioButton) findViewById(R.id.radAlmYes);
        // initialize relationship to student valid flag to true
        boolean RealtionshipValid = true;
        // if the Alumni Yes button is checked, the student is required to provide a relationship between him/her and the alumni
        if (AlmYes.isChecked())
            // if the value of month spinner equals "Make your selection..." user has not made a selection, so field is invalid
            if (RelationshipToStudent.equals("Make your selection...")) {
                RealtionshipValid = false;
            }

        // if input in text fields are false, the activity must be restarted and various parameters must be passed to indicate where the error occurs and to fill in valid data entries
        boolean editTextValid = editTextValidCheck(validEditText, editTextEntries);
        //Initialize boolean array
        boolean[] meeting = new boolean[5];
        //Reference checkboxes in xml layout
        CheckBox opt1 = (CheckBox) findViewById(R.id.chkFaculty);
        CheckBox opt2 = (CheckBox) findViewById(R.id.chkLunch);
        CheckBox opt3 = (CheckBox) findViewById(R.id.chkTrdVisit);
        CheckBox opt4 = (CheckBox) findViewById(R.id.chkMeetWithCoach);
        //Initialize the meeting array to false
        for (int i = 0; i < meeting.length; i++) {
            meeting[i] = false;
        }
        //If any of the text inputs, or spinners are incorrect we execute the activity again
        if (!editTextValid || !stateValid || !genderValid || !typeValid || !HighSchoolStateValid || !HSGradValid || !DateValid || !TimeValid || !VisitorValid || !RealtionshipValid) {
            //The 5 if statements store the values of the check boxes, and the alumni yes button so we can reuse them when we start the application
            if (opt1.isChecked()) {
                meeting[0] = true;
            }
            if (opt2.isChecked()) {
                meeting[1] = true;
            }
            if (opt3.isChecked()) {
                meeting[2] = true;

            }
            if (opt4.isChecked()) {
                meeting[3] = true;
            }
            if (AlmYes.isChecked()) {
                meeting[4] = true;
            }
            Bundle params = new Bundle(); // initialize buffer to store parameters in
            params.putBooleanArray("validEditText", validEditText); // stored to determine where invalid input occurred
            params.putStringArray("editTextEntries", editTextEntries); // stored EditText entries for fill-in on the new activity
            params.putLongArray("inputs", inputs); // store state
            params.putBooleanArray("meeting", meeting);//store check boxes
            //Initialize new class
            Class ourClass;
            try { // start the new activity
                ourClass = Class.forName("Visit");//Set the new class to Visit1
                Intent newIntent = new Intent(Visit.this, ourClass);//Define the intent used for the activity
                newIntent.putExtras(params); // store the parameters to be passed
                startActivity(newIntent); // start the activity
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else // if everything is valid, format and send the email
        {
            Intent sendIntent = new Intent(android.content.Intent.ACTION_SEND);  // create send intent
            String sendTo[] = {"adms@loras.edu"}; // email address to send the information too
            sendIntent.putExtra(android.content.Intent.EXTRA_EMAIL, sendTo);//We save the email address where we are sending the email message
            sendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Prospective Student Schedule a Visit Form from: " + editTextEntries[0] + " " + editTextEntries[1]); // hardcode subject line
            sendIntent.setType("plain/text");//Define type of email
            //Reference to fields from the xml layout
            TextView ACT = (TextView) findViewById(R.id.txtAct);
            TextView SAT = (TextView) findViewById(R.id.txtSat);
            TextView CollegesAttended = (TextView) findViewById(R.id.txtColleges);
            TextView CollegeGpa = (TextView) findViewById(R.id.txtCollegeGPA);
            TextView VisitFac = (TextView) findViewById(R.id.txtDpFac);
            TextView VisitAth = (TextView) findViewById(R.id.txtAthCoaches);
            TextView nameAlum = (TextView) findViewById(R.id.txtNameAlum);
            RadioButton PrNo = (RadioButton) findViewById(R.id.radPresentNo);
            RadioButton PrYes = (RadioButton) findViewById(R.id.radPresentYes);
            //Initialize a string that will store the option for the students visit
            String visitDetails = null;
            //User's input details are store into a string
            if (opt1.isChecked()) {
                if (visitDetails == null)
                    visitDetails = opt1.getText().toString();
            }
            if (opt2.isChecked()) {
                if (visitDetails == null)
                    visitDetails = opt2.getText().toString();
                else
                    visitDetails = visitDetails + ", " + opt2.getText().toString();
            }
            if (opt3.isChecked()) {
                if (visitDetails == null)
                    visitDetails = opt3.getText().toString();
                else
                    visitDetails = visitDetails + ", " + opt3.getText().toString();
            }
            if (opt4.isChecked()) {
                if (visitDetails == null)
                    visitDetails += opt4.getText().toString();
                else
                    visitDetails = visitDetails + ", " + opt4.getText().toString();

            }
            if (!opt1.isChecked() && !opt2.isChecked() && !opt3.isChecked() && !opt4.isChecked()) {
                visitDetails = "Nothing was selected.";
            }
            //Initialize a string that will store whether the alumni is going to be present during the visit
            String present = null;
            if (PrYes.isChecked()) {
                present = "Yes";
            }
            if (PrNo.isChecked() || !PrNo.isChecked()) {
                present = "No";
            }
            //Initialize a string that will show different outputs based on which Alumni button is pressed
            String alum = null;
            String selection = null;
            if (YearGraduatedLoras.getSelectedItemId() == 0) {
                selection = "Nothing selected";
            } else {
                selection = RelationshipToStudent.getSelectedItem().toString();
            }
            if (AlmYes.isChecked()) {
                alum = "Is anyone in your family an alumunus/alumna of Loras?" + " Yes" + "\n"
                        + "If so, will they be present for the visit? " + present + "\n"
                        + "If so, will they be present for the visit? " + nameAlum + "\n"
                        + "Relationship to Student: " + RelationshipToStudent.getSelectedItem().toString() + "\n"
                        + "Year graduated or attended Loras? " + selection + "\n";

            } else {
                alum = "Is anyone in your family an alumunus/alumna of Loras?" + " No" + "\n";
            }
            // store the message to be sent
            String message = "Personal Information" + "\n" + "\n"
                    + "Student First Name: " + editTextEntries[0] + "\n"
                    + "Student Last Name: " + editTextEntries[1] + "\n"
                    + "Address: " + editTextEntries[2] + "\n"
                    + "City: " + editTextEntries[3] + "\n"
                    + "State: " + state.getSelectedItem().toString() + "\n"
                    + "Zipcode: " + editTextEntries[4] + "\n"
                    + "Gender: " + gender.getSelectedItem().toString() + "\n"
                    + "Student Type: " + type.getSelectedItem().toString() + "\n"
                    + "Email: " + editTextEntries[5] + "\n"
                    + "Phone Number: " + editTextEntries[6] + "\n"
                    + "\n" + "\n"
                    + "Academic Information" + "\n" + "\n"
                    + "High School Name: " + editTextEntries[7] + "\n"//check
                    + "High School City: " + editTextEntries[8] + "\n"
                    + "High School State: " + HighSchoolState.getSelectedItem().toString() + "\n"
                    + "Graduation Year: " + GraduationYear.getSelectedItem().toString() + "\n"
                    + "High School GPA: " + editTextEntries[9] + "\n"//check
                    + "ACT Score: " + ACT.getText().toString() + "\n"//check
                    + "SAT Score: " + SAT.getText().toString() + "\n"//check
                    + "Intended Major: " + editTextEntries[10] + "\n"//check
                    + "Extra Curricular Interests in College: " + editTextEntries[11] + "\n"
                    + "Intercollegiate Atheltic Interests: " + editTextEntries[12] + "\n"
                    + "Colleges Attended: " + CollegesAttended.getText().toString() + "\n"//check
                    + "College GPA: " + CollegeGpa.getText().toString() + "\n"//check
                    + "\n" + "\n"
                    + "Visit Details" + "\n" + "\n"
                    + "Desired Visit Date: " + Date.getSelectedItem().toString() + "\n"
                    + "Time: " + Time.getSelectedItem().toString() + "\n"
                    + "Departure Time: " + editTextEntries[13] + "\n"
                    + "Visitors: " + Visitors.getSelectedItem().toString() + "\n"
                    + "List of academic deparments/faculty that you want to visit: " + VisitFac.getText().toString() + "\n"
                    + "List of athletic deparments/coaches that you want to visit: " + VisitAth.getText().toString() + "\n"
                    + "What would you like to include in your visit: " + visitDetails + "\n"
                    + "\n" + "\n"
                    + "Alumni Details" + "\n" + "\n"
                    + alum;

            sendIntent.putExtra(android.content.Intent.EXTRA_TEXT, message); // add the message o the send intent
            startActivity(Intent.createChooser(sendIntent, "Send your email in:"));  // Sends the email
        }
    }


    // checks if field is blank
    boolean isRequired(String entry) {
        if (entry.equals("")) // if field is blank, return false
        {
            return false;
        }

        return true; // else return true
    }

    // takes a string and checks if the string is longer than the given length integer
    boolean simpleTextEntry(String entry, int length) {
        // if entry is blank or shorter than the length, value is valid
        if (entry.equals("") || entry.length() < length) {

            return true;
        }

        return false; // else turn false
    }

    // checks for correctly formated zipcode
    boolean zipcodeCheck(String zipcode) {
        // pattern must match a string of 5 integers between 0 and 9
        Pattern p = Pattern.compile("[0-9][0-9][0-9][0-9][0-9]");
        Matcher m = p.matcher(zipcode);

        // string matches the correct zipcode format, return true
        if (m.matches()) {
            return true;
        }

        return false;
    }

    // checks phone number format
    boolean phoneCheck(String phone) {
        // phone numbers may contain spaces, digits from 0-9, spaces, and paraentheses
        Pattern p = Pattern.compile("[0-9\\-\\(\\) ]+");
        Matcher m = p.matcher(phone);

        if (m.matches() || phone.equals("")) {
            // checks that phone number is of excessively long length
            if (phone.length() > 20) {
                return false;
            }

            return true;
        }

        return false;
    }

    // checks for correctly formatted email
    boolean emailCheck(String email) {
        // email may consists of characters, digits from 0-9, . followed by an @ and then more characters, 0-9, .
        Pattern p = Pattern.compile("^[A-za-z0-9\\._]+@[A-Za-z\\.]+\\.[a-z]+$");
        Matcher m = p.matcher(email);

        // return true of it matches, as well as if not entered since field is not required
        if (m.matches() || email.equals("")) {
            return true;
        }

        return false;
    }

    // checks for correctly formatted departure time
    boolean timeCheck(String time) {
        // time may consist of hours, minutes and AM or PM
        Pattern p = Pattern.compile("(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)");
        Matcher m = p.matcher(time);

        // return true of it matches, as well as if not entered since field is not required
        if (m.matches() || time.equals("")) {
            return true;
        }

        return false;
    }

    // checks for correct GPA formatting
    boolean GPACheck(String GPA) {
        // GPA must start with 1 digit from 0-5 (5 included for some GPA scales which go to 5) followed by . and then digits from 0-9
        Pattern p = Pattern.compile("[0-5]\\.[0-9]+");
        Matcher m = p.matcher(GPA);

        // returns true if the pattern matches or if field is blank since field is not required
        if (m.matches() || GPA.equals("")) {
            return true;
        }

        return false;
    }

    // determines the appropriate appearance of editText entries after an invalid submission
    public void checkEditText(boolean[] validEditText, String[] editTextEntries) {
        // checks each entry for validity, if invalid it then determines the appropriate error message, else it sets the editText entry with the previously entered data
        for (int i = 0; i < validEditText.length; i++) {
            EditText temp = (EditText) findViewById(editTextIds[i]); // get reference

            if (!validEditText[i]) // if invalid, display error message
            {
                TextView tempText = (TextView) findViewById(editTextViewIds[i]); // get textview reference
                //Generates a red error message containing **
                tempText.setTextColor(Color.rgb(255, 0, 0));
                tempText.setTypeface(null, Typeface.BOLD_ITALIC);
                String field = tempText.getText().toString();
                tempText.setText("** " + field);


                // switch statement to display error messages
                switch (i) {
                    case 0: // display error for name field
                        if (!isRequired(editTextEntries[i])) {
                            tempText.append("\nField is required");
                        } else {
                            tempText.append("\nField exceeds maximum number of characters");
                            temp.setText("");
                        }
                        break;
                    case 1:  // display error for preferred name field
                        tempText.append("\nField is required");
                        temp.setText("");
                        break;
                    case 2:  // display error for address field
                        if (!isRequired(editTextEntries[i])) {
                            tempText.append("\nField is required");
                        } else {
                            tempText.append("\nField exceeds maximum number of characters");
                            temp.setText("");
                        }
                        break;
                    case 3:  // display error for city field
                        if (!isRequired(editTextEntries[i])) {
                            tempText.append("\nField is required");
                        } else {
                            tempText.append("\nField exceeds maximum number of characters");
                            temp.setText("");
                        }
                        break;
                    case 4:  // display error for zipcode field field
                        if (!isRequired(editTextEntries[i])) {
                            tempText.append("\nField is required");
                        } else {
                            tempText.append("\nField must be strictly 5 integers in length");
                            temp.setText("");
                        }
                        break;
                    case 5:  // display error for email field
                        if (!isRequired(editTextEntries[i])) {
                            tempText.append("\nField is required");
                        } else {
                            tempText.append("\nEmail is not correctly formatted");
                            temp.setText("");
                        }
                        break;
                    case 6:  // display error for cell phone number field
                        if (!isRequired(editTextEntries[i])) {
                            tempText.append("\nField is required");
                        } else {
                            tempText.append("\nInvalid phone number");
                            temp.setText("");
                        }
                        break;
                    case 7: // display error for high school field
                        if (!isRequired(editTextEntries[i])) {
                            tempText.append("\nField is required");
                        } else {
                            tempText.append("\nField exceeds maximum number of characters");
                            temp.setText("");
                        }
                        break;
                    case 8:  // display error for high school city
                        if (!isRequired(editTextEntries[i])) {
                            tempText.append("\nField is required");
                        } else {
                            tempText.append("\nField exceeds maximum number of characters");
                            temp.setText("");
                        }
                        break;
                    case 9:  // display error for high school GPA field
                        if (!isRequired(editTextEntries[i])) {
                            tempText.append("\nGPA is required");
                        } else {
                            tempText.append("\nGPA entered is not a valid GPA");
                            temp.setText("");
                        }
                        break;
                    case 10:  // display error for major field
                        tempText.append("\nField exceeds maximum number of characters");
                        temp.setText(editTextEntries[i]);
                        break;
                    case 11:  // display error for extra-cullicular activities
                        tempText.append("\nField exceeds maximum number of characters");
                        break;
                    case 12:  // display error for high school athletics
                        tempText.append("\nField exceeds maximum number of characters");
                        temp.setText(editTextEntries[i]);
                        break;
                    case 13:  // display error for departure time
                        tempText.append("\nField time is not correctly formated");
                        temp.setText(editTextEntries[i]);
                        break;
                    case 14:  // display error for college GPA
                        tempText.append("\nField is not correctly formated");
                        temp.setText(editTextEntries[i]);
                        break;
                }

            } else // if field is valid, set the text to already contain the valid data entry
            {
                temp.setText(editTextEntries[i]);
            }
        }
    }

    // checks for validity of editText fields
    boolean editTextValidCheck(boolean[] validEditText, String[] editTextEntries) {
        // cycle through all the EditText entries
        for (int i = 0; i < validEditText.length; i++) {
            EditText temp = (EditText) findViewById(editTextIds[i]); // get reference to an EditText entry
            editTextEntries[i] = temp.getText().toString(); // get the value

            switch (i) {
                case 0: // check name entry
                    validEditText[i] = isRequired(editTextEntries[i]) && simpleTextEntry(editTextEntries[i], 30);
                    break;
                case 1: // check preferred name entry
                    validEditText[i] = isRequired(editTextEntries[i]);
                    break;
                case 2: // check street address entry
                    validEditText[i] = simpleTextEntry(editTextEntries[i], 30) && isRequired(editTextEntries[i]);
                    break;
                case 3: // check city entry
                    validEditText[i] = simpleTextEntry(editTextEntries[i], 20) && isRequired(editTextEntries[i]);
                    break;
                case 4: // check zip code entry
                    validEditText[i] = isRequired(editTextEntries[i]) && zipcodeCheck(editTextEntries[i]);
                    break;
                case 5: // check email
                    validEditText[i] = emailCheck(editTextEntries[i]) && isRequired(editTextEntries[i]);
                    break;
                case 6: // check cell phone entry
                    validEditText[i] = phoneCheck(editTextEntries[i]) && isRequired(editTextEntries[i]);
                    break;
                case 7: // check high school
                    validEditText[i] = simpleTextEntry(editTextEntries[i], 50) && isRequired(editTextEntries[i]);
                    break;
                case 8: // check high school city
                    validEditText[i] = simpleTextEntry(editTextEntries[i], 75) && isRequired(editTextEntries[i]);
                    break;
                case 9: // check high school GPA
                    validEditText[i] = GPACheck(editTextEntries[i]) && isRequired(editTextEntries[i]);
                    break;
                case 10: // check major interests
                    validEditText[i] = simpleTextEntry(editTextEntries[i], 500);
                    break;
                case 11: // check extracurricular activities
                    validEditText[i] = simpleTextEntry(editTextEntries[i], 500);
                    break;
                case 12: // check college athletics
                    validEditText[i] = simpleTextEntry(editTextEntries[i], 500);
                    break;
                case 13: // check departure time
                    validEditText[i] = timeCheck(editTextEntries[i]);
                    break;
                case 14: // check college GPA
                    validEditText[i] = GPACheck(editTextEntries[i]);
                    break;

            }

        }

        boolean editTextValid = true; // set flag to true

        // if 1 or more fields is invalid, editTextValid is false and the activity must be relaunched
        for (int i = 0; i < validEditText.length; i++) {
            editTextValid = editTextValid && validEditText[i];
        }

        return editTextValid; // return true or false
    }

    // Determine what to do when an action bar icon is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Given the action bar icon that was selected, do something
        switch (item.getItemId()) {
            // If the main action bar icon (left-most icon) was selected
            case android.R.id.home:
                // Go to the home screen
                //
                // Set the Intent to launch to be the home screen
                Intent intent = new Intent(this, HomeScreen.class);
                // These flags are so if there's an instance of the home screen Activity already
                // running, bring that instance on screen instead of starting a new instance
                // of it
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                // Launch the home screen
                startActivity(intent);

                return true;
            default:
                // Call the super class version of the method with the selection
                return super.onOptionsItemSelected(item); // Required call to superclass for app lifecycle management
        }
    }
}
