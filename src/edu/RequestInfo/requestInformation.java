package edu.RequestInfo;

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

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class requestInformation extends SherlockActivity {

    protected void onCreate(Bundle savedInstanceState) {

        int[] editTextIds = {R.id.nameField, R.id.preferredNameField, R.id.addressField, R.id.cityField, R.id.zipCodeField, R.id.dayField, R.id.yearField, R.id.landlinePhoneField, R.id.cellPhoneField, R.id.emailField, R.id.highSchoolField, R.id.highSchoolCityStateField, R.id.highSchoolGraduationField, R.id.highSchoolGPAField, R.id.transferStudentCollegesField, R.id.academicInterestsField, R.id.collegeGPAField, R.id.collegiateAthleticsField, R.id.collegiateExtracurricularsField, R.id.citizenshipField};
        int[] editTextViewIds = {R.id.nameText, R.id.preferredNameText, R.id.addressText, R.id.cityText, R.id.zipCodeText, R.id.birthText, R.id.birthText, R.id.landlinePhoneText, R.id.cellPhoneText, R.id.emailText, R.id.highSchoolText, R.id.highSchoolCityStateText, R.id.highSchoolGraduationText, R.id.highSchoolGPAText, R.id.transferStudentCollegesText, R.id.academicInterestsText, R.id.collegeGPAText, R.id.collegiateAthleticsText, R.id.collegiateExtracurricularsText, R.id.citizenshipText};
        int[] radioIds = {R.id.titleGroup, R.id.intendedStartTermGroup, R.id.usCitizenGroup};
        int[] radioTextIds = {R.id.titleText, R.id.intendedStartTermText, R.id.usCitizenText};

        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_information);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        intendedStartDate();  // sets the appropriate text values for the RadioButtons in the intended start date RadioGroup

        Bundle bundle = getIntent().getExtras(); // get passed parameters

        Spinner spinner = (Spinner) findViewById(R.id.stateSpinner); // reference to spinner for state selection
        String[] states = {"Choose a state ...", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};

        Spinner monthSpinner = (Spinner) findViewById(R.id.monthSpinner); // reference for spinner for birthdate month selection
        String[] months = {"Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};


        if (bundle != null) // if bundle is carrying values, then the user has encountered errors when trying to submit the form
        {
            boolean[] validEditText = bundle.getBooleanArray("validEditText"); // contains boolean values indicating valid or invalid data entry
            String[] editTextEntries = bundle.getStringArray("editTextEntries"); // contains the entered values
            boolean[] validRadio = bundle.getBooleanArray("validRadio"); // contains boolean values indicating valid or invalid RadioButton checks
            int[] radioEntriesIds = bundle.getIntArray("radioEntriesIds"); // contains id of the checked RadioButton for each RadioGroup
            String[] radioEntries = bundle.getStringArray("radioEntries"); // contains the text value for the checked RadioButtons
            String selectedState = bundle.getString("selectedState");  // store what state was selected
            String selectedMonth = bundle.getString("selectedMonth"); // store what birthdate month was selected

            radioButtonErrors(validRadio, radioEntriesIds, radioEntries, radioTextIds, radioIds); // display the correct error messages for RadioGroups

            checkEditText(validEditText, editTextEntries, editTextViewIds, editTextIds); // display the correct error messages for the EditText fields

            // chooses the appropriate pre-selected value for state
            if (!selectedState.equals("Choose a state ...")) // if "Choose a state ..." is selected, the user did not select one
            {
                states[0] = selectedState; // if they did select a state, select in the new spinner
            } else // else generate error message
            {
                TextView tempText = (TextView) findViewById(R.id.stateText);
                tempText.setTextColor(Color.rgb(255, 0, 0));
                tempText.setTypeface(null, Typeface.BOLD_ITALIC);
                tempText.setText("** State\nField is required");

            }

            // chooses the appropriate pre-selected value for birthdate month
            if (!selectedMonth.equals("Month")) // if selected value was "Month", user did not select a month
            {
                months[0] = selectedMonth; // set initial selection to the month the user selected
            } else // generates error message
            {
                if (validEditText[5] && validEditText[6]) // if year and date were entered in valid formats, add an error message (used to avoid duplicate error messages)
                {
                    TextView tempText = (TextView) findViewById(R.id.birthText);
                    tempText.setTextColor(Color.rgb(255, 0, 0));
                    tempText.setTypeface(null, Typeface.BOLD_ITALIC);
                    tempText.setText("** Date of Birth\nField is required");
                }

            }
        }
        // set the arrayAdapter for the state spinner
        ArrayAdapter<String> spinnerStateAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, states);
        spinnerStateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerStateAdapter);

        // set the arrayAdapter for the birthdate month spinner
        ArrayAdapter<String> spinnerMonthAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, months);
        spinnerMonthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(spinnerMonthAdapter);
    } // end of main code

    // executes when user clicks the submit button
    public void sendRequest(View button) {

        int[] editTextIds = {R.id.nameField, R.id.preferredNameField, R.id.addressField, R.id.cityField, R.id.zipCodeField, R.id.dayField, R.id.yearField, R.id.landlinePhoneField, R.id.cellPhoneField, R.id.emailField, R.id.highSchoolField, R.id.highSchoolCityStateField, R.id.highSchoolGraduationField, R.id.highSchoolGPAField, R.id.transferStudentCollegesField, R.id.academicInterestsField, R.id.collegeGPAField, R.id.collegiateAthleticsField, R.id.collegiateExtracurricularsField, R.id.citizenshipField};
        int[] editTextViewIds = {R.id.nameText, R.id.preferredNameText, R.id.addressText, R.id.cityText, R.id.zipCodeText, R.id.birthText, R.id.birthText, R.id.landlinePhoneText, R.id.cellPhoneText, R.id.emailText, R.id.highSchoolText, R.id.highSchoolCityStateText, R.id.highSchoolGraduationText, R.id.highSchoolGPAText, R.id.transferStudentCollegesText, R.id.academicInterestsText, R.id.collegeGPAText, R.id.collegiateAthleticsText, R.id.collegiateExtracurricularsText, R.id.citizenshipText};
        int[] radioIds = {R.id.titleGroup, R.id.intendedStartTermGroup, R.id.usCitizenGroup};
        int[] radioTextIds = {R.id.titleText, R.id.intendedStartTermText, R.id.usCitizenText};

        boolean[] validEditText = new boolean[20]; // boolean array for valid or invalid indication for EditText
        String[] editTextEntries = new String[20]; // String array for EditText entries

        boolean[] validRadio = new boolean[3]; // boolean array for valid or invalid indication for RadioGroups
        int[] radioEntriesIds = new int[3]; // ids for the checked RadioButtons
        String[] radioEntries = new String[3]; // store the string values for the checked RadioButtons

        // initialize all entries to valid
        for (int i = 0; i < validEditText.length; i++) {
            validEditText[i] = true; // initialize all values to true
        }

        // gets the selected value from the state selector
        Spinner stateSpinner = (Spinner) findViewById(R.id.stateSpinner);
        String selectedState = stateSpinner.getSelectedItem().toString();

        // gets the selected value from the birthdate month selector
        Spinner monthSpinner = (Spinner) findViewById(R.id.monthSpinner);
        String selectedMonth = monthSpinner.getSelectedItem().toString();

        // initilize state valid flag to true
        boolean stateValid = true;

        // if the value of the state spinner equals "Choose a state ..." user has not made a selection, so the field is invalid
        if (selectedState.equals("Choose a state ...")) {
            stateValid = false;
        }

        // initialize month valid flag to true
        boolean monthValid = true;

        // if the value of month spinner equals "Month" user has not made a selection, so field is invalid
        if (selectedMonth.equals("Month")) {
            monthValid = false;
        }

        // radioGroupValidCheck and editTextValidCheck return boolean values indicating whether or not ALL RadioGroups are valid and ALL EditText values are valid
        // if either is false, the activity must be restarted and various parameters must be passed to indicate where the error occurs and to fill in valid data entries
        boolean radioValid = radioGroupValidCheck(validRadio, radioEntries, radioEntriesIds);
        boolean editTextValid = editTextValidCheck(validEditText, editTextEntries, editTextIds);

        // if either valid flag returns a value of false, store all the valid flags and entered information and restart the activity with the appropriate error messages
        if (!radioValid || !editTextValid || !stateValid || !monthValid) {
            Bundle params = new Bundle(); // initialize buffer to store parameters in
            params.putBooleanArray("validEditText", validEditText); // stored to determine where invalid input occurred
            params.putBooleanArray("validRadio", validRadio); // stored to determine where invalid input occurred
            params.putIntArray("radioEntriesIds", radioEntriesIds); // stored to recheck already checked RadioButtons
            params.putStringArray("radioEntries", radioEntries); // storted to store entries on checked RadioButtons
            params.putStringArray("editTextEntries", editTextEntries); // stored to sote EditText entries for fill-in on the new activity
            params.putString("selectedState", selectedState); // store state
            params.putString("selectedMonth", selectedMonth); // store month

            Class ourClass;
            try { // start the new activity
                ourClass = Class.forName("requestInformation");
                Intent newIntent = new Intent(requestInformation.this, ourClass);
                newIntent.putExtras(params); // store the parameters to be passed
                startActivity(newIntent); // start the activity
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else // if everything is valid, format and send the email
        {
            Intent sendIntent = new Intent(android.content.Intent.ACTION_SEND);  // create send intent
            String sendTo[] = {"admissions@loras.edu"}; // email address to send the information too
            sendIntent.putExtra(android.content.Intent.EXTRA_EMAIL, sendTo);
            sendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Prospective Student Information Request From " + editTextEntries[0]); // hardcode subject line
            sendIntent.setType("plain/text");

            // store the message to be sent
            String message = "Title:  " + radioEntries[0] + "\nName: " + editTextEntries[0] + "\nPreferred Name: " + editTextEntries[1] + "\nStreet Address: " + editTextEntries[2] + "\nCity: " + editTextEntries[3] + "\nState: " + selectedState + "\nZip Code: " + editTextEntries[4] + "\nDate of Birth: " + selectedMonth + " " + editTextEntries[5] + ", " + editTextEntries[6] + "\nLandline Phone Number: " + editTextEntries[7] + "\nCell Phone Number:  " + editTextEntries[8] + "\nEmail Address:  " + editTextEntries[9] + "\nIntended Start Term:  " + radioEntries[1] + "\nHigh School:  " + editTextEntries[10] + "\nHigh School City and State:  " + editTextEntries[11] + "\nHigh School Graduation Year:  " + editTextEntries[12] + "\nHigh School Grade Point Average:  " + editTextEntries[13] + "\nTransfer Student, please list colleges attended:  " + editTextEntries[14] + "\nAcademic Interest:  " + editTextEntries[15] + "\nCollege/University Grade Point Average:  " + editTextEntries[16] + "\nCollegiate Athletics:  " + editTextEntries[17] + "\nCollegiate Extracurricular Activities:  " + editTextEntries[18] + "\nAre you a United States citizen?:  " + radioEntries[2] + "\nIf not, please indicate Country of Citizenship:  " + editTextEntries[19];

            sendIntent.putExtra(android.content.Intent.EXTRA_TEXT, message); // add the message o the send intent
            sendIntent.addFlags(sendIntent.FLAG_ACTIVITY_CLEAR_TOP | sendIntent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(Intent.createChooser(sendIntent, "Send your email in:"));  //
        }
    }

    // displays the correct errors for RadioButton entries and rechecks valid entries
    public void radioButtonErrors(boolean[] valid, int[] entryIds, String[] entries, int[] textIds, int[] radioIds) {
        for (int i = 0; i < valid.length; i++) {
            if (valid[i] == false) // if invalid
            {
                TextView temp = (TextView) findViewById(textIds[i]); // change to text label to red
                temp.setTextColor(Color.rgb(255, 0, 0));
                temp.setTypeface(null, Typeface.BOLD_ITALIC);

                if (i == 1) // intended start date is under consideration add appropriate error message
                {
                    temp.setText("** Intended Start Term\nThis field is required.");
                }
            } else // if valid
            {
                if (entries[i] != "") // if entry is not blank, a value has been seleced so select it
                {
                    RadioGroup temp = (RadioGroup) findViewById(radioIds[i]);
                    temp.check(entryIds[i]);
                }
            }
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

    // checks for correct year formatting
    boolean yearCheck(String year) {
        // year may consist of 4 integers between 0-9
        Pattern p = Pattern.compile("[0-9][0-9][0-9][0-9]");
        Matcher m = p.matcher(year);

        // evalues to true if the entered string matches the pattern, or if year is left empty since it may not be a required field
        if (m.matches() || year.equals("")) {
            return true;
        }

        return false;
    }

    // checks for correct day formatting for date of birth entry
    boolean dayCheck(String day) {
        // day matches the numeric day date on a calendar, therefore it may be either 1 or 2 digits in length
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(day);

        Pattern p2 = Pattern.compile("[0-9][0-9]");
        Matcher m2 = p2.matcher(day);

        // if it matches either pattern, or is empty incase not required, return true
        if (m.matches() || m2.matches() || day.equals("")) {
            return true;
        }

        return false;
    }


    // checks for correct GPA formatting
    boolean GPACheck(String GPA) {
        // GPA must start with 1 digit from 0-5 (5 included for some GPA scales which go to 5) followed by . and then digits from 0-9
        Pattern p = Pattern.compile("[0-5]\\.[0-9]+");
        Pattern p2 = Pattern.compile("[0-5]");
        Matcher m = p.matcher(GPA);
        Matcher m2 = p2.matcher(GPA);

        // returns true if the pattern matches or if field is blank since field is not required
        if (m.matches() || GPA.equals("") || m2.matches()) {
            return true;
        }

        return false;
    }

    // determines the appropriate appearance of editText entries after an invalid submission
    public void checkEditText(boolean[] validEditText, String[] editTextEntries, int[] editTextViewIds, int[] editTextIds) {
        // checks each entry for validity, if invalid it then determines the appropriate error message, else it sets the editText entry with the previously entered data
        for (int i = 0; i < validEditText.length; i++) {
            EditText temp = (EditText) findViewById(editTextIds[i]); // get reference

            if (!validEditText[i]) // if invalid, display error message
            {
                TextView tempText = (TextView) findViewById(editTextViewIds[i]); // get textview reference

                if (i != 6) // if not the field for bithdate year, add ** to the beginning of the field name
                {
                    tempText.setTextColor(Color.rgb(255, 0, 0));
                    tempText.setTypeface(null, Typeface.BOLD_ITALIC);
                    String field = tempText.getText().toString();
                    tempText.setText("** " + field);
                } else // else, if it is the field for birthdate year, check if day was also invalid
                {
                    if (validEditText[5]) // if birthdate day was valid, then we may add the ** (done to avoid repeat error messages on the same field)
                    {
                        tempText.setTextColor(Color.rgb(255, 0, 0));
                        tempText.setTypeface(null, Typeface.BOLD_ITALIC);
                        String field = tempText.getText().toString();
                        tempText.setText("** " + field);
                    }

                }

                // switch statement to display error messages
                switch (i) {
                    case 0: // display error for name field
                        if (!isRequired(editTextEntries[i])) {
                            tempText.append("\nField is required");
                        } else {
                            tempText.append("\nField exceeds maximum number of characters");
                            temp.setText(editTextEntries[i]);
                        }
                        break;
                    case 1:  // display error for preferred name field
                        tempText.append("\nField exceeds maximum number of characters");
                        temp.setText("");
                        break;
                    case 2:  // display error for address field
                        if (!isRequired(editTextEntries[i])) {
                            tempText.append("\nField is required");
                        } else {
                            tempText.append("\nField exceeds maximum number of characters");
                            temp.setText(editTextEntries[i]);
                        }
                        break;
                    case 3:  // display error for city field
                        if (!isRequired(editTextEntries[i])) {
                            tempText.append("\nField is required");
                        } else {
                            tempText.append("\nField exceeds maximum number of characters");
                            temp.setText(editTextEntries[i]);
                        }
                        break;
                    case 4:  // display error for zipcode field field
                        if (!isRequired(editTextEntries[i])) {
                            tempText.append("\nField is required");
                        } else {
                            tempText.append("\nField must 5 integers in length");
                            temp.setText(editTextEntries[i]);
                        }
                        break;
                    case 5: // display error in birthdate day field
                        if (!isRequired(editTextEntries[i])) {
                            tempText.append("\nField is required");
                        } else {
                            tempText.append("\nDay must be 1 or 2 digits in length");
                            temp.setText(editTextEntries[i]);
                        }
                        break;
                    case 6:  // display error for birthdate year field
                        if (!isRequired(editTextEntries[i])) {
                            if (validEditText[5]) {
                                tempText.append("\nField is required");
                            }
                        } else {
                            tempText.append("\nYear must be 4 digits in length");
                            temp.setText(editTextEntries[i]);
                        }
                        break;
                    case 7:  // display error for landline phone number field
                        tempText.append("\nInvalid phone number");
                        break;
                    case 8:  // display error for cell phone number field
                        tempText.append("\nInvalid phone number");
                        break;
                    case 9:  // display error for email field
                        tempText.append("\nEmail is not correctly formatted");
                    case 10: // display error for high school field
                        if (!isRequired(editTextEntries[i])) {
                            tempText.append("\nField is required");
                        } else {
                            tempText.append("\nField exceeds maximum number of characters");
                            temp.setText(editTextEntries[i]);
                        }
                        break;
                    case 11:  // display error for high school city and state field
                        tempText.append("\nField exceeds maximum number of characters");
                        break;
                    case 12:  // display error for high school graduation field
                        if (!isRequired(editTextEntries[i])) {
                            tempText.append("\nField is required");
                        } else {
                            tempText.append("\nYear must be 4 digits in length");
                        }
                        break;
                    case 13:  // display error for high school GPA field
                        tempText.append("\nGPA entered is not a valid GPA");
                        break;
                    case 14:  // display error for transfer student previously attended colleges field
                        tempText.append("\nField exceeds maximum number of characters");
                        break;
                    case 15:  // display error for academic interest field
                        tempText.append("\nField exceeds maximum number of characters");
                        break;
                    case 16:  // display error for college GPA
                        tempText.append("\nGPA entered is not a valid GPA");
                        break;
                    case 17:  // display error for collegiate athletics
                        tempText.append("\nField exceeds maximum number of characters");
                        break;
                    case 18:  // display error for collegiate extracurricular
                        tempText.append("\nField exceeds maximum number of characters");
                        break;
                    case 19:  // display error for citizenship field
                        tempText.append("\nField exceeds maximum number of characters");
                        break;
                }
                temp.setText(editTextEntries[i]);

            } else // if field is valid, set the text to already contain the valid data entry
            {
                temp.setText(editTextEntries[i]);
            }
        }
    }

    // displays the correct selection options for intended start date
    public void intendedStartDate() {
        Date date = new Date(); // gets current date
        Calendar now = GregorianCalendar.getInstance();
        int Month = Calendar.getInstance().get(Calendar.MONTH) + 1; // gets numeric indicator of current month (Calendar.MONTH begins indexing at 0)
        int Year = Calendar.getInstance().get(Calendar.YEAR); // get the current year


        if (Month >= 1 && Month < 8) // if the current month is between January and July begin displaying intended start dates at Fall of the current year
        {
            RadioButton text = (RadioButton) findViewById(R.id.firstTerm);
            text.setText("Fall (August) " + Year);

            text = (RadioButton) findViewById(R.id.secondTerm);
            text.setText("Spring (January) " + (Year + 1));

            text = (RadioButton) findViewById(R.id.thirdTerm);
            text.setText("Fall (August) " + (Year + 1));

            text = (RadioButton) findViewById(R.id.fourthTerm);
            text.setText("Spring (January) " + (Year + 2));

            text = (RadioButton) findViewById(R.id.fifthTerm);
            text.setText("Fall (August) " + (Year + 2));

            text = (RadioButton) findViewById(R.id.sixthTerm);
            text.setText("Spring (January) " + (Year + 3));
        } else // or else begin displaying start dates at Spring of the following year
        {
            RadioButton text = (RadioButton) findViewById(R.id.firstTerm);
            text.setText("Spring (January) " + (Year + 1));

            text = (RadioButton) findViewById(R.id.secondTerm);
            text.setText("Fall (August) " + (Year + 1));

            text = (RadioButton) findViewById(R.id.thirdTerm);
            text.setText("Spring (January) " + (Year + 2));

            text = (RadioButton) findViewById(R.id.fourthTerm);
            text.setText("Fall (August) " + (Year + 2));

            text = (RadioButton) findViewById(R.id.fifthTerm);
            text.setText("Spring (January) " + (Year + 3));

            text = (RadioButton) findViewById(R.id.sixthTerm);
            text.setText("Fall (August) " + (Year + 3));
        }
    }

    // checks that the entries of the radiobuttons and radiogroups are valid
    boolean radioGroupValidCheck(boolean[] validRadio, String[] radioEntries, int[] radioEntriesIds) {
        RadioGroup temp = null;
        RadioButton tempString = null;

        for (int i = 0; i < validRadio.length; i++) // check each RadioGroup
        {
            switch (i) {
                case 0:
                    temp = (RadioGroup) findViewById(R.id.titleGroup); // get reference to RadioGroup
                    tempString = (RadioButton) findViewById(temp.getCheckedRadioButtonId()); // get string value associated with the checked RadioButton
                    break;
                case 1:
                    temp = (RadioGroup) findViewById(R.id.intendedStartTermGroup); // get reference to RadioGroup
                    tempString = (RadioButton) findViewById(temp.getCheckedRadioButtonId()); // get string value associated with the checked RadioButton
                    break;
                case 2:
                    temp = (RadioGroup) findViewById(R.id.usCitizenGroup); // get reference to RadioGroup
                    tempString = (RadioButton) findViewById(temp.getCheckedRadioButtonId()); // get string value associated with the checked RadioButton
                    break;
            }

            if (tempString != null) // if there a RadioButton was checked
            {
                radioEntries[i] = tempString.getText().toString(); // set entry value
                radioEntriesIds[i] = temp.getCheckedRadioButtonId(); // get the Id of the radio button so that it can be rechecked if there are errors in other entries
                validRadio[i] = true; // entry is valid
            } else // if no button is checked
            {
                if (i == 1) // if i = 1, then the RadioGroup is the intended start term RadioGroup
                {
                    validRadio[1] = false; // set to false because field is required
                } else // RadioGroup not required, so entry is valid
                {
                    radioEntries[i] = "";
                    validRadio[i] = true;
                }
            }
        }

        boolean radioValid = true; // set flag to true

        // cycle through all the validity flags, if 1 flag is false, then radioValid is false and activity needs to be relaunched
        for (int i = 0; i < validRadio.length; i++) {
            radioValid = radioValid && validRadio[i];
        }

        return radioValid; // returns true or false
    }

    // checks for validity of editText fields
    boolean editTextValidCheck(boolean[] validEditText, String[] editTextEntries, int[] editTextIds) {
        // cycle through all the EditText entries
        for (int i = 0; i < validEditText.length; i++) {
            EditText temp = (EditText) findViewById(editTextIds[i]); // get reference to an EditText entry
            editTextEntries[i] = temp.getText().toString().trim(); // get the value

            switch (i) {
                case 0: // check name entry
                    validEditText[i] = isRequired(editTextEntries[i]) && simpleTextEntry(editTextEntries[i], 30);
                    break;
                case 1: // check preferred name entry
                    validEditText[i] = simpleTextEntry(editTextEntries[i], 30);
                    break;
                case 2: // check street address entry
                    validEditText[i] = simpleTextEntry(editTextEntries[i], 50) && isRequired(editTextEntries[i]);
                    break;
                case 3: // check city entry
                    validEditText[i] = simpleTextEntry(editTextEntries[i], 50) && isRequired(editTextEntries[i]);
                    break;
                case 4: // check zip code entry
                    validEditText[i] = isRequired(editTextEntries[i]) && zipcodeCheck(editTextEntries[i]);
                    break;
                case 5: // check day of birth entry
                    validEditText[i] = isRequired(editTextEntries[i]) && dayCheck(editTextEntries[i]);
                    break;
                case 6: // check year of birth entry
                    validEditText[i] = isRequired(editTextEntries[i]) && yearCheck(editTextEntries[i]);
                    break;
                case 7: // check landline phone entry
                    validEditText[i] = phoneCheck(editTextEntries[i]);
                    break;
                case 8: // check cell phone entry
                    validEditText[i] = phoneCheck(editTextEntries[i]);
                    break;
                case 9: // check email
                    validEditText[i] = emailCheck(editTextEntries[i]);
                    break;
                case 10: // check high school
                    validEditText[i] = simpleTextEntry(editTextEntries[i], 50) && isRequired(editTextEntries[i]);
                    break;
                case 11: // check high school city and state
                    validEditText[i] = simpleTextEntry(editTextEntries[i], 75);
                    break;
                case 12: // check high school graduation year
                    validEditText[i] = yearCheck(editTextEntries[i]) && isRequired(editTextEntries[i]);
                    break;
                case 13: // check high school GPA
                    validEditText[i] = GPACheck(editTextEntries[i]);
                    break;
                case 14: // check colleges attended for Transfer Students
                    validEditText[i] = simpleTextEntry(editTextEntries[i], 500);
                    break;
                case 15: // check academic interests
                    validEditText[i] = simpleTextEntry(editTextEntries[i], 500);
                    break;
                case 16: // check college or university GPA
                    validEditText[i] = GPACheck(editTextEntries[i]);
                    break;
                case 17: // check college athleics
                    validEditText[i] = simpleTextEntry(editTextEntries[i], 500);
                    break;
                case 18: // check extracurricular activities
                    validEditText[i] = simpleTextEntry(editTextEntries[i], 500);
                    break;
                case 19: // check citizenship
                    validEditText[i] = simpleTextEntry(editTextEntries[i], 20);
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
	


