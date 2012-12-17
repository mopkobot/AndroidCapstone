package edu.MapsCommon;

import com.google.android.maps.GeoPoint;
import edu.HomeScreen.R;

/* This class holds all the information for each building/location on Loras' campus. It uses the location class to create a new 
 * location and pass it the necessary information. See the location class for the parameters of a location. Each new location is
 * added to the Locations array. The Map Explorer and Virtual Tour feature use this class to display information about the 
 * locations that are tapped on. This class also determines if a location is to appear in the Virtual Tour feature, and in what
 * order. 
 * 
 * Current tour locations order:
 * 1 Keane Hall (Admissions Office)
 * 2 Academic Resouce Center
 * 3 Alumni Campus Center
 * 4 Binz Hall
 * 5 Lynch-McCarthy Apartments
 * 6 Athletic and Wellness Center
 * 7 The Grotto
 * 8 Rock Bowl Stadium
 * 9 St. Joseph Hall of Science
 * 10 Fieldhouse
 * 11 Heitkamp Planetarium
 * 12 Christ the King Chapel
 *
 * Note: Categorizing a location as "submenu" prevents the MapsActivity class from creating an overlay item on the map. This is
 * useful for the ACC, for example. The ACC contains The Cafe, The Pub, etc. Instead of having an overlay item for The Cafe, The
 * Pub, and the ACC, there is just one overlay item that can access each of these locations. 
 * 
 * Programmer: Justin Steines
 */

public interface Locations {
    // define sub menus that appear when an overlay item is tapped on
    // if a location doesn't have a specific sub menu, it uses the default one which just says, "Tap here for more info."
    public static final String[] AccMenu = {"Alumni Campus Center", "The Cafe", "The Pub", "The Duhawk Market"};
    public static final String[] HoffmannMenu = {"Hoffmann Hall", "St. Joseph Auditorium", "The Pod"};
    public static final String[] defaultAry = {"Tap here for more info."};

    public static final location[] Locations =
            {
                    new location(
                            "Academic Resource Center",
                            new GeoPoint(42503240, -90679740),
                            "The Academic Resource Center was established in 2002. This 92,000 sq. ft. building houses the Loras library as well as the Loras College Barnes & Noble Bookstore which has new rental and e-book options. The library has the largest private collection of rare books in Iowa and has a seating capacity of 500 people. It contains three classrooms, group study rooms, and single study rooms. Headwaters (located on the first floor of the ARC) offers tutoring, a math assistance program, a writing center, resumr assistance, the Honors Program, and the Lynch Office of Disability Services.",
                            "study",
                            R.drawable.arc,
                            true,
                            2,
                            defaultAry),

                    new location(
                            "Alumni Campus Center",
                            new GeoPoint(42503910, -90679040),
                            "The Alumni Campus Center, originally the Collan Center, was established in 1914, with an addition added in 1992. The cafe (renovated in the summer of 2011) the Pub, and the Duhawk Market are all contained within the ACC along with a 24-hour information desk, ballrooms, the campus mail room, and meeting rooms. The offices of Student Government, Campus Ministry, Counseling Center, Health Center, College Activities Board, Center for Experiential Learning and Study Abroad, Student Life, Residence Life, Intercultural Programs, and Campus Safety are all housed in the Alumni Campus Center.",
                            "eat_study_havefun",
                            R.drawable.acc_cropped,
                            true,
                            3,
                            AccMenu),

                    new location(
                            "The Cafr",
                            new GeoPoint(42503910, -90679040),
                            "The Cafr was renovated in the summer of 2011. The meal plans for all first year students living in traditional housing (Beckman, Binz, Rohlman, Visitation) has a 200 Block Meal Plan with 200 Duhawk Dollars. Anyone in non-traditional housing (Smyth, Byrne Oaks, Lynch-McCarthy, campus houses) can choose between 145 Block Meal Plan & 200 Duhawk Dollars, the Duhawk Plan that has 500 Duhawk Dollars, or no meal plan at all.",
                            "submenu",
                            R.drawable.cafe,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "The Pub",
                            new GeoPoint(42503910, -90679040),
                            "Conveniently located in the Alumni Campus Center, The Pub offers made-to-order grill items, deli sandwiches, pizza, Asian cuisine, and much more. Duhawk Dollars may be used to make any purchases and all items are either r la carte or meal deals offered by the various stations in the Pub.",
                            "submenu",
                            R.drawable.pub,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "The Duhawk Market",
                            new GeoPoint(42503910, -90679040),
                            "The Duhawk Market is a campus convenience store located in the Alumni Campus Center.",
                            "submenu",
                            R.drawable.duhawk_market_cropped,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "Alumni Plaza",
                            new GeoPoint(42504300, -90680860),
                            "The benches and walk alongside the Rock Bowl Stadium were generously donated by Lorasr very active and engaged alumni population.",
                            "havefun",
                            R.drawable.alumni_plaza,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "Athletic and Wellness Center/Lillis Court",
                            new GeoPoint(42504940, -90678410),
                            "The Athletic Wellness Center was built in 2007 and is a 74,189 sq. ft. facility. It seats more than 1,700 people and houses the Athletic Department offices. Basketball and volleyball games are held on Lillis Court, and on the concourse above, is Lorasr Wall of Fame. Locker rooms are available for general use along with the workout area. The AWC is sometimes used for band and choir performances and guest speakers. The offices within the AWC house basketball and volleyball, Athletic Training, and the Athletic Director and Assistant Athletic Director. Locker rooms for basketball, football, and volleyball are also located here.",
                            "havefun",
                            R.drawable.awc,
                            true,
                            6,
                            defaultAry),

                    new location(
                            "Beckman Hall",
                            new GeoPoint(42504840, -90675870),
                            "Beckman Hall was established 1961. It is a coed residence that houses 245 students with communal bathrooms and houses mainly first-year students. There are two Resident Advisors per floor.  A study room and an activity lounge along with the laundry room and a kitchen are located in the basement. Beckman contains mostly double rooms and a few suites, which are generally occupied by sophomores or above.",
                            "sleep_study",
                            R.drawable.beckman,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "Belmont House",
                            new GeoPoint(42502400, -90680120),
                            "The Belmont House Intercultural Center is operated by the Office of Intercultural Programs at Loras College. The center features a rKitchen Libraryr where students may rcheck outr food and rreturnr by the rdue date.r The kitchen supplies are donated by Loras College faculty, staff, students, and community members.<br><br>The Belmont House Intercultural Center is available for student organizational meetings, informal receptions, and temporary housing.<br><br>The concept of establishing a cultural center on the Loras College campus began in the late 1969 when African American students orchestrated a sit-in at Henion Manor to demand a Black Cultural Center at Loras College. The rTakeover of Henion Manorr resulted in May Place being established as a Black Cultural Center at Loras.",
                            "study_havefun",
                            R.drawable.belmont_house,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "Binz Hall",
                            new GeoPoint(42505280, -90675560),
                            "Binz Hall was established in 1965. It is a coed residence that houses 230 students and is typically for sophomore students. Binz Hall has double rooms, and for every two rooms there is a shared bathroom between. In addition, there are suite-style rooms available. Binz houses a laundry room, a kitchen, and an activities lounge. There are also study rooms on each floor.",
                            "sleep_study",
                            R.drawable.binz,
                            true,
                            4,
                            defaultAry),

                    new location(
                            "Byrne Oaks Apartment Complex",
                            new GeoPoint(42507110, -90681650),
                            "Byrne Oaks was established in 1990. It houses sophomores, juniors, and seniors, with each apartment housing six students. Each apartment consists of two double rooms, two single rooms, two bathrooms, a kitchen, living room, dining room, and a porch. The apartments are completely furnished and a sand volleyball court is just outside the apartment complex. Students must have a minimum of 30 credits and a GPA of 2.0 to live in Byrne Oaks.",
                            "sleep_study",
                            R.drawable.byrne_oaks,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "Christ the King Chapel",
                            new GeoPoint(42503620, -90681520),
                            "Christ the King Chapel was established in 1946. It is the larger of two chapels on campus and is dedicated for the first priest who was killed in Pearl Harbor during WWII, Loras graduate Fr. Al Schmitt.  Mass is available for the campus and community Sundays nights at 8 p.m., Monday-Friday (except Wednesday) at 5:15 p.m., and Wednesday night Mass at 9 p.m.  Adoration and Reconciliation are also available at scheduled times each week.  Many Duhawks choose to be married in Christ the King.",
                            "havefun",
                            R.drawable.ctk_outside_cropped,
                            true,
                            12,
                            defaultAry),

                    new location(
                            "Daughters of Isabella Rosary Garden",
                            new GeoPoint(42506140, -90683050),
                            "The rosary garden was a gift of the student organization, Daughters of Isabella, in the spring of 2011. It serves as a quiet, reflective place where students can pray the rosary and is located in Keane Oaks.",
                            "havefun",
                            R.drawable.daughters_garden,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "Faber-Clark Field",
                            new GeoPoint(42504850, -90677090),
                            "Faber-Clark Field is now a practice field which is also available for intramurals.  The Faber-Clark Softball Field is home to all of Lorasr home softball games and includes batting cages added in 2011.",
                            "havefun",
                            R.drawable.faber_clark,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "Fieldhouse",
                            new GeoPoint(42504170, -90681450),
                            "The Field House was established in 1924 and varsity basketball games were played here before the Athletic Wellness Center was completed in 2008. It is now primarily a recreational building and houses the Sports Information Office. The football and soccer coachesr offices and soccer locker rooms are housed here. The Field House is also used for junior varsity basketball games, speakers, concerts, and guest services. John F. Kennedy delivered the 1956 Loras College commencement address here when he was still a United States Senator.",
                            "havefun",
                            R.drawable.fieldhouse,
                            true,
                            10,
                            defaultAry),

                    new location(
                            "Graber Sports Center",
                            new GeoPoint(42506330, -90680490),
                            "Graber Sports Center was established in 1983 and renovated in the summer of 2011. It houses the San Jose Pool.  Both wrestling and indoor track and field teams practice and compete in the arena area and the softball and baseball teams practice here as well. Over 50 intramural events are held here and open gym times are available as well. There are a few classrooms held here, mainly utilized by pre-professional and education majors.",
                            "havefun",
                            R.drawable.graber,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "Grotto of Our Lady of Lourdes",
                            new GeoPoint(42504580, -90679760),
                            "The Grotto, originally constructed in 1954 during the Marian year, was initiated by Loras President the Most Reverend Loras Lane and modeled after the Grotto of the University of Notre Dame. The inspiration was the famous Grotto of Our Lady of Lourdes, France. It is constructed of weathered native stone and accented by antique iron railings. The Grotto provides a setting to hold outdoor Masses, Marian ceremonies, and a spot for visitors to spend time in quiet meditation. The original gift of the Grotto came from Lillian and Rosalyn Schrup. In 1990, the Class of 1954 funded improvements to the Grotto. Additional enhancements were provided by Nicholas (r54) and Maureen Savaiano. Don Noel contributed countless hours to the beautification and upkeep of Grotto along with many other volunteers.  The relocation and building of the new Grotto was completed thanks to a generous donation by Jim Davis (r67), in memory of his wife Jane, and was dedicated on October 6, 2011.",
                            "havefun",
                            R.drawable.grotto,
                            true,
                            7,
                            defaultAry),

                    new location(
                            "Heitkamp Planetarium",
                            new GeoPoint(42503880, -90681030),
                            "The Heitkamp Planetarium holds a variety of programs put on by Loras students about once a month and houses astronomy classes.",
                            "study",
                            R.drawable.planetarium,
                            true,
                            11,
                            defaultAry),

                    new location(
                            "Hennessy Hall",
                            new GeoPoint(42504610, -90682090),
                            "Hennessy Hall was established in 1916 and houses the following departments: Math (gen. ed.), Computer Science, Criminal Justice, Engineering, Psychology, Sociology, and Social Work. It contains a classroom equipped with two-way mirrors for psychology observation labs as well as other research labs to allow students to use lie detectors and heart rate tests.",
                            "study",
                            R.drawable.hennessy,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "Hoffmann Hall",
                            new GeoPoint(42504140, -90676390),
                            "Hoffmann Hall was established in 1902 and is an original building of Loras College, which was remodeled in 1986. It houses the following departments: Accounting and Business, English, Political Science, Communication Arts, History, Philosophy, and Economics. St. Joseph Auditorium is also housed here. The Instructional Resource Center, Loras College Radio Station (KLCR), Loras College Television Studio (LCTV), The Lorian Newspaper Office, and the media studies lab are also housed in Hoffmann Hall. St. Joseph Chapel is the oldest chapel on campus, named after Lorasr patron saint. The POD (Provisions on Demand) is a campus convenience store in Hoffmann.",
                            "eat_study_havefun",
                            R.drawable.hoffmann,
                            false,
                            0,
                            HoffmannMenu),

                    new location(
                            "St. Joseph Auditorium",
                            new GeoPoint(42504080, -90676330),
                            "St. Joseph Auditorium is home to the Loras Players who put on several productions each year. The Loras Players is the oldest theater troupe west of the Mississippi, having originated in 1910.  The theatre seats 600 people and the stage includes a turntable stage.",
                            "submenu",
                            R.drawable.hoffmann_auditorium,
                            false,
                            0,
                            HoffmannMenu),

                    new location(
                            "The Pod",
                            new GeoPoint(42504080, -90676330),
                            "The POD (provisions on demand) is a campus convenience store located in Hoffmann Hall.",
                            "submenu",
                            R.drawable.pod_inside,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "Keane Hall (Admissions Office)",
                            new GeoPoint(42503080, -90681130),
                            "Keane Hall was established in 1914 and houses the following administrative offices: Admission, Campus Spiritual Life, Institutional Advancement (Advancement, Alumni, and Development services), Provost and Academic Dean, Registrar, Business Office, Marketing, and the Presidentrs Office. The Technology and Laptop Help Desk is also located in Keane Hall.",
                            "study",
                            R.drawable.keane,
                            true,
                            1,
                            defaultAry),

                    new location(
                            "Koinonia House",
                            new GeoPoint(42505930, -90683570),
                            "The Koinonia House a Loras-owned student house where students come together and build community, planning events for the campus as well. Koinonia is a Greek word for \"Community.\" The Koinonia House is a place for students to hang out, do homework, enjoy events, and grow in community. Events are held throughout the year such as movie nights, game nights, grill outs, and other events.",
                            "study_havefun",
                            R.drawable.koinonia_house,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "Loras Parkway",
                            new GeoPoint(42504440, -90678750),
                            "Formerly Cox Street, Loras purchased this street in the summer of 2010 from the City of Dubuque for $50,000 and is in the process of reconstructing and redesigning Loras Parkway into a more sustainable and pedestrian-friendly walkway.",
                            "havefun",
                            R.drawable.parkway,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "Lynch-McCarthy Apartment Complex",
                            new GeoPoint(42505900, -90675160),
                            "The Lynch-McCarthy Apartments were built in 2002. They are four-person units that include a kitchen, living room, four single bedrooms, and a bathroom. Couches, chairs and a kitchen set are provided. They are available to students with 50 or more credits and a minimum GPA of 2.0.",
                            "sleep_study",
                            R.drawable.lmac,
                            true,
                            5,
                            defaultAry),

                    new location(
                            "Physical Plant",
                            new GeoPoint(42504000, -90678280),
                            "The Physical Plant serves as the operational facility for the College, housing maintenance offices and equipment used to keep the campus in excellent running order and aesthetically beautiful.",
                            "havefun",
                            R.drawable.physical_plant,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "Rock Bowl Stadium/Bierie Field",
                            new GeoPoint(42505220, -90680670),
                            "The Rock Bowl Stadium was established in 1939 and was renovated in 2005. The renovated stadium has a turf field and is home to Duhawk football games, soccer matches, and track and field events. The stadium has an expanded seating capacity, and (with the installation of lighting) now offers athletics the option to use the facility in the evening. The Rock Bowl is one of only a handful of Division III schools to contain a jumbotron scoreboard.  All students and other groups may use the field when it is not occupied by varsity sports competitions or practices.",
                            "havefun",
                            R.drawable.rock_bowl,
                            true,
                            8,
                            defaultAry),

                    new location(
                            "Rohlman Hall",
                            new GeoPoint(42506020, -90681570),
                            "Rohlman was established in 1954 as a residence hall and now has a capacity of approximately 184 and includes singles, doubles, quads and suites. It contains laundry facilities, a kitchen, TV lounge, and a study lounge. Rohlman also houses the Division of Physical Education and Sports Studies and has two classrooms.",
                            "sleep_study",
                            R.drawable.rohlman,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "San Jose Swimming Pool",
                            new GeoPoint(42506760, -90680680),
                            "San Jose Swimming Pool is home to our swimming and diving teams. Practices and competitions are held here. Open swim is also available.",
                            "havefun",
                            R.drawable.san_jose_pool,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "Smyth Hall",
                            new GeoPoint(42504880, -90679270),
                            "Smyth Hall was established in 1927 and is a residence hall with single, double and triple rooms. It is primarily for upper-class students and houses the Religious Studies Department and one classroom.",
                            "sleep_study",
                            R.drawable.smyth,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "St. Joseph Chapel",
                            new GeoPoint(42503950, -90676690),
                            "St. Joseph Chapel is the oldest chapel on campus and is housed in Hoffmann Hall. It is named after Lorasr patron saint.",
                            "havefun",
                            R.drawable.stjoseph_chapel_cropped,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "St. Joseph Hall of Science",
                            new GeoPoint(42505230, -90682910),
                            "St. Joseph Hall of Science was established in 1963 and houses the following departments: Biology, Chemistry, Biochemistry, Physics, and Engineering. The Science hall has a DNA lab which is a newly remodeled modern lab with up-to-date equipment. Pre-med and criminal justice students are able to utilize the lab for research. An Organic Instrument Lab is also available which includes an MNR machine (similar to an MRI machine). Only 20% of schools at our level have this equipment, and students are granted access as early as sophomore year. The Chemical Research Lab has equipment used by students studying Polymer Chemistry. Loras is the only school of its size in the nation to offer Polymer Chemistry. The Cadaver Lab is used for research by pre-med students. The displayed animals within the Science Hall were donated by past professors.",
                            "study",
                            R.drawable.science_hall,
                            true,
                            9,
                            defaultAry),

                    new location(
                            "Tennis Courts",
                            new GeoPoint(42505720, -90678620),
                            "The tennis courts were resurfaced in 2010 and are available to the menrs and womenrs tennis teams as well as for student recreational use. There are also courses for credit offered in which students can learn more about and practice the sport.",
                            "havefun",
                            R.drawable.tennis,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "Visitation Complex",
                            new GeoPoint(42499780, -90678540),
                            "The Visitation Complex houses the Music and Art Departments. It also houses approximately 75 students and features an art gallery for exhibitions and a small performance hall.",
                            "sleep_study",
                            R.drawable.visitation,
                            false,
                            0,
                            defaultAry),

                    new location(
                            "Wahlert Hall",
                            new GeoPoint(42504170, -90680150),
                            "Wahlert Hall was established in 1960 and previously housed the Loras College library. It now houses the Divisions of Education and Spanish, and the curriculum library for Education majors. When looking at an aerial shot of Wahlert, the building is seen in the shape of a cross.",
                            "study",
                            R.drawable.wahlert,
                            false,
                            0,
                            defaultAry),

            };
}
