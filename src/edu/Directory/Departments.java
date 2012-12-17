package edu.Directory;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.util.Linkify;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import edu.HomeScreen.R;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Departments extends SherlockActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        // retrieve the department the user is looking for
        Bundle bundle = getIntent().getExtras();
        String department = bundle.getString("department"); // stores the department the user is looking for

        setContentView(R.layout.campus_directory);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String str = ""; // declare str to hold the record
        InputStream inputstream = getResources().openRawResource(R.raw.academic_dir_report); // store the reference to the academic directory report to be parsed through
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(inputstream, "utf-8")); // reader contains reference to directory report

            Pattern p = Pattern.compile(","); // finds commas
            LinearLayout layout = (LinearLayout) findViewById(R.id.directory); // stores reference to the layout the records are to be added to

            TextView departmentTitle = (TextView) findViewById(R.id.departmentTitle); // stores reference to the header textview to contain the department listing title
            departmentTitle.setText(department + "\n"); // sets the text of the department header to the department name

            if (inputstream != null) // if inputstream properly recieved a reference to an existing document
            {
                while (str != null) {
                    try {
                        str = reader.readLine(); // stores a string of the current line in the report (each line contains one full record)

                        if (str != null) // if it successfully reads a line
                        {
                            String[] result = p.split(str); // split the string on commas and store each component in a string array

                            if (department.equals(getDepartment(result[result.length - 1]))) // if department listed for the record falls under the category of the department the user is currently looking for, display the record
                            {
                                Pattern adjunct = Pattern.compile("Adjunct|Emeritus|Emerita|Adj|Emer"); // patern which looks for the various strings listed
                                Matcher filterMatcher = adjunct.matcher(result[3]); // looks for the strings in the title component of each record
                                boolean filter = false; // set filter flag to false

                                // if any of the string is found, set filter to true and filter out the record
                                if (filterMatcher.find()) {
                                    filter = true;
                                }

                                // if result does not need to be filtered, display the record
                                if (!filter) {
                                    TextView temp = new TextView(this); // declare a new textview
                                    temp.setAutoLinkMask(Linkify.EMAIL_ADDRESSES); // linkify the textview so that email addresses are clickable

                                    Pattern yearSplit = Pattern.compile("/"); // pattern to split the start date appart based on /
                                    String[] date = yearSplit.split(result[2]); // split the start date and store in array date[]

                                    Pattern titleSplit = Pattern.compile(" "); // patter to split strings based on spaces
                                    String[] title = titleSplit.split(result[3]); // split the title apart based on spaces and store in array title[]

                                    String titleString = titleEdit(title); // titleEdit edits title string to not contain any abbreviations

                                    // string the entire record together into one string.
                                    String record = "<b>" + result[1] + " " + result[0] + "</b><br/>" + date[2] + "- " + titleString + "<br/>" + result[4] + "<br/>";

                                    temp.setTextAppearance(this, R.style.MyTextView); // set text appearance of the new textview to contain the record
                                    temp.setText(Html.fromHtml(record)); // set text of the text view.  Use Html.formHtml to execute Html code inside the string
                                    layout.addView(temp); // add to the layout
                                }
                            }

                        }

                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } // return to the beginning of the loop to read the next line
            } // end of inputstream != null if statement
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    } // end of onCreate()

    // takes in the department listed with the record, and returns the correct overlying division
    public String getDepartment(String major) {
        // if major listed is social work, psychology, or criminal justice return behavioral sciences
        if (major.equals("Social Work") || major.equals("Psychology") || major.equals("Criminal Justice")) {
            return "Behavioral Sciences";
        }

        // if major is acounting/business reutrn business administration
        if (major.equals("Accounting/Business")) {
            return "Business Administration";
        }

        // if major is communication art, music, or art return communication and fine arts
        if (major.equals("Communication Arts") || major.equals("Music") || major.equals("Art")) {
            return "Communication and Fine Arts";
        }

        // if major is education, return education
        if (major.equals("Education")) {
            return "Education";
        }

        // if major is english or modern foreign language, return Language and Literature
        if (major.equals("English") || major.equals("Modern Foreign Language")) {
            return "Language and Literature";
        }

        // if major is math/computer science or physics/engineering, return Mathematics, Engineering and Computer Science
        if (major.equals("Math/Computer Science") || major.equals("Physics/Engineering")) {
            return "Mathematics, Engineering and Computer Science";
        }

        // if major is chemistry or biology, return Molecular and Life Sciences
        if (major.equals("Chemistry") || major.equals("Biology")) {
            return "Molecular and Life Sciences";
        }

        // if majoris religious stuides or philosophy, return Philosophy, Religion and Theology
        if (major.equals("Religious Studies") || major.equals("Philosophy")) {
            return "Philosophy, Religion and Theology";
        }

        // if major is physical education, return Physical Education and Sport Studies
        if (major.equals("Physical Education")) {
            return "Physical Education and Sport Studies";
        }

        // if major is history, classical stuides, sociology, or politics, economics, or modern foreign language AND culture, return Social and Cultural stuides
        if (major.equals("History") || major.equals("Classical Studies") || major.equals("Sociology") || major.equals("Politics") || major.equals("Economics") || major.equals("Modern Foreign Language and Culture")) {
            return "Social and Cultural Studies";
        }

        return null;
    }

    // Determine what to do when an action bar icon is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Given the action bar icon that was selected, do something
        switch (item.getItemId()) {
            // If the main action bar icon (left-most icon) was selected
            case android.R.id.home:
                // Go to list of divisions screen
                //
                // Set the Intent to launch the screen
                Intent intent = new Intent(this, campusDirectory.class);
                // These flags are so if there's an instance of the list of divisions screen Activity already
                // running, bring that instance on screen instead of starting a new instance
                // of it
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                // Launch the list of divisions screen
                startActivity(intent);

                return true;

            default:
                // Call the super class version of the method with the selection
                return super.onOptionsItemSelected(item); // Required call to superclass for app lifecycle management
        }
    }

    // returns an edited version of a record's title so that abbreviations are edited out
    public String titleEdit(String[] title) {
        String titleString = ""; // declare string

        // cycle through each component of the title, which was previously split on spaces with its part put in the array title[]
        for (int i = 0; i < title.length; i++) {
            if (title[i].equals("Prof")) // if component is "prof" replaced with "professor"
            {
                title[i] = "Professor";
            } else {
                if (title[i].equals("Assoc")) // if component is"assoc" replace with "Associate"
                {
                    title[i] = "Associate";
                } else {
                    if (title[i].equals("Asst")) // if component is "Asst" replaced with "Assistant"
                    {
                        title[i] = "Assistant";
                    } else {
                        if (title[i].equals("Dir")) // if component is "Dir" replace with "Director"
                        {
                            title[i] = "Director";
                        } else {
                            if (title[i].equals("Instr")) // if component is "Instr" replace with "Instructor"
                            {
                                title[i] = "Instructor";
                            }
                        }
                    }
                }
            }
            titleString = titleString + title[i] + " "; // piece the title back together
        }

        return titleString; // return the completed string
    }
}

